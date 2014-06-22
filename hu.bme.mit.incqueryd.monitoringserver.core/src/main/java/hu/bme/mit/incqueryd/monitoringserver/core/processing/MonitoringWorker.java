package hu.bme.mit.incqueryd.monitoringserver.core.processing;

import hu.bme.mit.incqueryd.monitoringserver.core.MonitoringDataCollectorActor;
import hu.bme.mit.incqueryd.monitoringserver.core.datacollection.AkkaMonitoringDataCollector;
import hu.bme.mit.incqueryd.monitoringserver.core.datacollection.MonitoringService;
import hu.bme.mit.incqueryd.monitoringserver.core.model.AggregatedMonitoringData;
import hu.bme.mit.incqueryd.monitoringserver.core.model.MachineMonitoringData;
import hu.bme.mit.incqueryd.monitoringserver.core.model.NodeMonitoringData;
import hu.bme.mit.incqueryd.monitoringserver.core.network.NetworkAddressHelper;
import hu.bme.mit.incqueryd.retemonitoring.metrics.ReteNodeMetrics;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import akka.actor.ActorSystem;
import akka.actor.Props;

import com.typesafe.config.ConfigFactory;

public class MonitoringWorker extends Thread {
	
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
		
		for (String host : monitoredHosts.keySet()) {
			MachineMonitoringData machineData = MonitoringService.getMachineMonitoringData(host, monitoredHosts.get(host));
			machines.add(machineData);
		}
		
		AkkaMonitoringDataCollector akkaCollector = new  AkkaMonitoringDataCollector(atmosHost, atmosPort);
		List<NodeMonitoringData> nodes = akkaCollector.collectNodeData();
		
		for (MachineMonitoringData machineMonitoringData : machines) {
			for (NodeMonitoringData nodeData : nodes) {
				if (machineMonitoringData.getHost().equals(nodeData.getName().split("@")[1])) {
					machineMonitoringData.addNode(nodeData);
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
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				
			}
			
			ReteMonitoringWorker worker = new ReteMonitoringWorker();
			worker.start();
			
			//monitor(); // what if starts lately -> think about it
			
			try {
				worker.join();
			} catch (InterruptedException e1) {
			}
			
			if(worker.successful()) {
				for(ReteNodeMetrics metrics: worker.getReteMetrics()) {
					System.out.println(metrics);
				}
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
				"    transport = \"akka.remote.netty.NettyRemoteTransport\"\r\n" + 
				"    netty {\r\n" + 
				"    hostname = \"" + ipAddress + "\"\r\n" + 
				"    port = 2552\r\n" + 
				"    }\r\n" + 
				"    }\r\n" + 
				"    }";
		
		system = ActorSystem.create("monitoringserver", ConfigFactory.parseString(config));
		system.actorOf(new Props(MonitoringDataCollectorActor.class), "collector");
	}

}
