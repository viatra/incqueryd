package hu.bme.mit.incqueryd.monitoringserver.core.processing;

import hu.bme.mit.incqueryd.monitoringserver.core.MonitoringDataCollectorActor;
import hu.bme.mit.incqueryd.monitoringserver.core.datacollection.AkkaMonitoringDataCollector;
import hu.bme.mit.incqueryd.monitoringserver.core.datacollection.MachineMonitoringWorker;
import hu.bme.mit.incqueryd.monitoringserver.core.model.AggregatedMonitoringData;
import hu.bme.mit.incqueryd.monitoringserver.core.model.MachineMonitoringData;
import hu.bme.mit.incqueryd.monitoringserver.core.model.NodeMonitoringData;
import hu.bme.mit.incqueryd.monitoringserver.core.network.NetworkAddressHelper;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import akka.actor.ActorSystem;
import akka.actor.Props;

import com.typesafe.config.ConfigFactory;

public class MonitoringWorker extends Thread {
	
	private static final int ATMOS_PORT = 8660;
	private static final int OS_AGENT_PORT = 7777;
	private Map<String, Integer> monitoredHosts;
	private String atmosHost;
	private int atmosPort;
	
	private volatile boolean exit;
	
	private AggregatedMonitoringData monitoredData;
	
	private ActorSystem system;
	
	public MonitoringWorker(Map<String, Integer> monitoredHosts, String atmosHost,
			int atmosPort) {
		super();
		this.monitoredHosts = monitoredHosts;
		this.atmosHost = atmosHost;
		this.atmosPort = atmosPort;
		
		monitoredData = new AggregatedMonitoringData();
		
		exit = false;
		
		this.createActor();
		
		this.setDaemon(true);
	}
	
	public AggregatedMonitoringData getMonitoredData() {
		synchronized (monitoredData) {
			return monitoredData;
		}
	}
	
	private void monitor() {
		AggregatedMonitoringData collectedData = new AggregatedMonitoringData();
		
		List<MachineMonitoringData> machines = new ArrayList<>();
		
		List<MachineMonitoringWorker> machineWorkers = new ArrayList<>();
		
		List<AkkaMonitoringDataCollector> akkaCollectors = new ArrayList<>();
		
		for (String host : monitoredHosts.keySet()) {
			MachineMonitoringWorker mWorker = new MachineMonitoringWorker(host, OS_AGENT_PORT);
			machineWorkers.add(mWorker);
			mWorker.start();
		}
		
		for (String host : monitoredHosts.keySet()) {
			AkkaMonitoringDataCollector akkaCollector = new AkkaMonitoringDataCollector(host, ATMOS_PORT);
			akkaCollectors.add(akkaCollector);
			akkaCollector.start();
		}
		
		for (MachineMonitoringWorker machineMonitoringWorker : machineWorkers) {
			try {
				machineMonitoringWorker.join();
			} catch (InterruptedException e) {
				
			}
			
			MachineMonitoringData machineData = machineMonitoringWorker.getData();
			if(machineData != null)machines.add(machineData);

		}
		
		for (AkkaMonitoringDataCollector akkaMonitoringDataCollector : akkaCollectors) {
			try {
				akkaMonitoringDataCollector.join();
			} catch (InterruptedException e) {
				
			}
			
			List<NodeMonitoringData> nodes = akkaMonitoringDataCollector.getNodeDataList();
			
			for (MachineMonitoringData machineMonitoringData : machines) {
				for (NodeMonitoringData nodeData : nodes) {
					if (machineMonitoringData.getHost().equals(nodeData.getName().split("@")[1])) {
						machineMonitoringData.addNode(nodeData);
					}
				}
			}
		}
		
		
		collectedData.setMachines(machines);
		
		synchronized (monitoredData) {
			monitoredData = collectedData;
		}
		
	}
	
	public void exit() {
		exit = true;
	}
	
	@Override
	public void run() {
		
		while (!exit) {
			System.out.println("Start");
			
			ReteMonitoringWorker worker = new ReteMonitoringWorker();
			worker.start();
			
			monitor(); 
			
			try {
				worker.join();
			} catch (InterruptedException e1) {
			}
			
			if(worker.successful()) {
				monitoredData.setRete(worker.getReteMetrics());
			}
			
		}
		
		system.shutdown();
	}
	
	private void createActor() {
		
		String ipAddress = "127.0.0.1"; // Default is local loopback
		try {
			ipAddress = NetworkAddressHelper.getLocalHostLANAddress().getHostAddress();
		} catch (UnknownHostException e) {
			
		}
		
		String config = "akka {\r\n" + 
				"    actor {\r\n" + 
				"    provider = \"akka.remote.RemoteActorRefProvider\"\r\n" + 
				"    }\r\n" + 
				"    remote {\r\n" + 
				"    log-received-messages = off\r\n" +
				"    log-sent-messages = off\r\n" +
				"    remote-daemon-ack-timeout = 30s\r\n" +
				"    log-remote-lifecycle-events = off\r\n" +
				"    untrusted-mode = off\r\n" +
				"    transport = \"akka.remote.netty.NettyRemoteTransport\"\r\n" + 
				"    netty {\r\n" + 
				"    backoff-timeout = 0ms\r\n" +
				"    secure-cookie = \"\"\r\n" +
				"    require-cookie = off\r\n" +
				"    use-passive-connections = on\r\n" +
				"    use-dispatcher-for-io = \"\"\r\n" +
				"    hostname = \"" + ipAddress + "\"\r\n" + 
				"    port = 2552\r\n" + 
				"    message-frame-size = 1 MiB\r\n" +
				"    reconnection-time-window = 600s\r\n" +
				"    all-timeout = 0s\r\n" +
				"    read-timeout = 0s\r\n" +
				"    write-timeout = 0s\r\n" +
				"    reconnect-delay = 5s\r\n" +
				" max-channel-memory-size = 0b\r\n" + 
				" \r\n" + 
				"# (I) Maximum total size of all channels, 0 for off\r\n" + 
				"max-total-memory-size = 0b\r\n" + 
				" \r\n" + 
				"# (I&O) Sets the high water mark for the in and outbound sockets,\r\n" + 
				"# set to 0b for platform default\r\n" + 
				"write-buffer-high-water-mark = 0b\r\n" + 
				" \r\n" + 
				"# (I&O) Sets the low water mark for the in and outbound sockets,\r\n" + 
				"# set to 0b for platform default\r\n" + 
				"write-buffer-low-water-mark = 0b\r\n" + 
				" \r\n" + 
				"# (I&O) Sets the send buffer size of the Sockets,\r\n" + 
				"# set to 0b for platform default\r\n" + 
				"send-buffer-size = 0b\r\n" + 
				" \r\n" + 
				"# (I&O) Sets the receive buffer size of the Sockets,\r\n" + 
				"# set to 0b for platform default\r\n" + 
				"receive-buffer-size = 0b\r\n" + 
				" \r\n" +
				" outbound-local-address = \"auto\"\r\n" + 
				" \r\n" + 
				"# (I&O) Increase this if you want to be able to send messages with large\r\n" + 
				"# payloads\r\n" + 
				"message-frame-size = 1 MiB\r\n" + 
				" \r\n" + 
				"# (O) Sets the connectTimeoutMillis of all outbound connections,\r\n" + 
				"# i.e. how long a connect may take until it is timed out\r\n" + 
				"connection-timeout = 120s\r\n" + 
				" \r\n" + 
				"# (I) Sets the size of the connection backlog\r\n" + 
				"backlog = 4096\r\n" +
				" reuse-address = off-for-windows\r\n" + 
				" \r\n" + 
				"# (I) Length in akka.time-unit how long core threads will be kept alive if\r\n" + 
				"# idling\r\n" + 
				"execution-pool-keepalive = 60s\r\n" + 
				" \r\n" + 
				"# (I) Size in number of threads of the core pool of the remote execution\r\n" + 
				"# unit.\r\n" + 
				"# A value of 0 will turn this off, which is can lead to deadlocks under\r\n" + 
				"# some configurations!\r\n" + 
				"execution-pool-size = 4\r\n" +
				" ssl {\r\n" + 
				"# (I&O) Enable SSL/TLS encryption.\r\n" + 
				"# This must be enabled on both the client and server to work.\r\n" + 
				"enable = off\r\n" + 
				" \r\n" + 
				"# (I) This is the Java Key Store used by the server connection\r\n" + 
				"key-store = \"keystore\"\r\n" + 
				" \r\n" + 
				"# This password is used for decrypting the key store\r\n" + 
				"key-store-password = \"changeme\"\r\n" + 
				" \r\n" + 
				"# (O) This is the Java Key Store used by the client connection\r\n" + 
				"trust-store = \"truststore\"\r\n" + 
				" \r\n" + 
				"# This password is used for decrypting the trust store\r\n" + 
				"trust-store-password = \"changeme\"\r\n" + 
				" \r\n" + 
				"# (I&O) Protocol to use for SSL encryption, choose from:\r\n" + 
				"# Java 6 & 7:\r\n" + 
				"# 'SSLv3', 'TLSv1'\r\n" + 
				"# Java 7:\r\n" + 
				"# 'TLSv1.1', 'TLSv1.2'\r\n" + 
				"protocol = \"TLSv1\"\r\n" + 
				" \r\n" + 
				"# Example: [\"TLS_RSA_WITH_AES_128_CBC_SHA\", \"TLS_RSA_WITH_AES_256_CBC_SHA\"]\r\n" + 
				"# You need to install the JCE Unlimited Strength Jurisdiction Policy\r\n" + 
				"# Files to use AES 256.\r\n" + 
				"# More info here:\r\n" + 
				"# http://docs.oracle.com/javase/7/docs/technotes/guides/security/SunProviders.html#SunJCEProvider\r\n" + 
				"enabled-algorithms = [\"TLS_RSA_WITH_AES_128_CBC_SHA\"]\r\n" + 
				" \r\n" + 
				"# Using /dev/./urandom is only necessary when using SHA1PRNG on Linux to\r\n" + 
				"# prevent blocking. It is NOT as secure because it reuses the seed.\r\n" + 
				"# '' => defaults to /dev/random or whatever is set in java.security for\r\n" + 
				"# example: securerandom.source=file:/dev/random\r\n" + 
				"# '/dev/./urandom' => NOT '/dev/urandom' as that doesn't work according\r\n" + 
				"# to: http://bugs.sun.com/view_bug.do?bug_id=6202721\r\n" + 
				"sha1prng-random-source = \"\"\r\n" + 
				" \r\n" + 
				"# There are three options, in increasing order of security:\r\n" + 
				"# \"\" or SecureRandom => (default)\r\n" + 
				"# \"SHA1PRNG\" => Can be slow because of blocking issues on Linux\r\n" + 
				"# \"AES128CounterSecureRNG\" => fastest startup and based on AES encryption\r\n" + 
				"# algorithm\r\n" + 
				"# \"AES256CounterSecureRNG\"\r\n" + 
				"# The following use one of 3 possible seed sources, depending on\r\n" + 
				"# availability: /dev/random, random.org and SecureRandom (provided by Java)\r\n" + 
				"# \"AES128CounterInetRNG\"\r\n" + 
				"# \"AES256CounterInetRNG\" (Install JCE Unlimited Strength Jurisdiction\r\n" + 
				"# Policy Files first)\r\n" + 
				"# Setting a value here may require you to supply the appropriate cipher\r\n" + 
				"# suite (see enabled-algorithms section above)\r\n" + 
				"random-number-generator = \"\"\r\n" + 
				"}\r\n" + 
				" \r\n" + 
				"# (I&O) Used to configure the number of I/O worker threads on server sockets\r\n" + 
				"server-socket-worker-pool {\r\n" + 
				"# Min number of threads to cap factor-based number to\r\n" + 
				"pool-size-min = 2\r\n" + 
				" \r\n" + 
				"# The pool size factor is used to determine thread pool size\r\n" + 
				"# using the following formula: ceil(available processors * factor).\r\n" + 
				"# Resulting size is then bounded by the pool-size-min and\r\n" + 
				"# pool-size-max values.\r\n" + 
				"pool-size-factor = 1.0\r\n" + 
				" \r\n" + 
				"# Max number of threads to cap factor-based number to\r\n" + 
				"pool-size-max = 8\r\n" + 
				"}\r\n" + 
				" \r\n" + 
				"# (I&O) Used to configure the number of I/O worker threads on client sockets\r\n" + 
				"client-socket-worker-pool {\r\n" + 
				"# Min number of threads to cap factor-based number to\r\n" + 
				"pool-size-min = 2\r\n" + 
				" \r\n" + 
				"# The pool size factor is used to determine thread pool size\r\n" + 
				"# using the following formula: ceil(available processors * factor).\r\n" + 
				"# Resulting size is then bounded by the pool-size-min and\r\n" + 
				"# pool-size-max values.\r\n" + 
				"pool-size-factor = 1.0\r\n" + 
				" \r\n" + 
				"# Max number of threads to cap factor-based number to\r\n" + 
				"pool-size-max = 8\r\n" + 
				"}\r\n" +
				"    }\r\n" + 
				"    }\r\n" + 
				"    }";
		
		system = ActorSystem.create("monitoringserver", ConfigFactory.parseString(config));
		system.actorOf(new Props(MonitoringDataCollectorActor.class), "collector");
	}

}
