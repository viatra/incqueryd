package hu.bme.mit.incqueryd.osmonitoringagent.core;

import hu.bme.mit.incqueryd.osmonitoringagent.metrics.CPUUsage;
import hu.bme.mit.incqueryd.osmonitoringagent.metrics.DiskUsage;
import hu.bme.mit.incqueryd.osmonitoringagent.metrics.HostData;
import hu.bme.mit.incqueryd.osmonitoringagent.metrics.MemoryUsage;
import hu.bme.mit.incqueryd.osmonitoringagent.metrics.NetworkUsage;
import hu.bme.mit.incqueryd.osmonitoringagent.metrics.OSMonitoringData;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.time.StopWatch;
import org.hyperic.sigar.FileSystem;
import org.hyperic.sigar.FileSystemUsage;
import org.hyperic.sigar.NetInterfaceConfig;
import org.hyperic.sigar.NetInterfaceStat;
import org.hyperic.sigar.Sigar;
import org.hyperic.sigar.SigarException;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.actor.UntypedActor;

import com.typesafe.config.ConfigFactory;

public class OSMonitor extends UntypedActor{

	private final static Sigar sigar = new Sigar();

	private StopWatch timer = new StopWatch();

	/**
	 * List of local disks of the machine to be measured
	 */
	private List<FileSystem> diskList;

	/**
	 * List of network interfaces to be measured
	 */
	private List<String> networkInterfaces;

	/**
	 * previously measured disk read number for all disks
	 */
	private long[] previousDiskReads;

	/**
	 * previously measured disk data reads in bytes
	 */
	private long[] previousDiskReadBytes;

	/**
	 * previously measured disk write number for all disks
	 */
	private long[] previousDiskWrites;

	/**
	 * previously measured disk data writes in bytes
	 */
	private long[] previousDiskWriteBytes;

	/**
	 * previously measured RX packets
	 */
	private long[] previousRXPackets;

	/**
	 * previously measured RX bytes
	 */
	private long[] previousRXBytes;

	/**
	 * previously measured TX packets
	 */
	private long[] previousTXPackets;

	/**
	 * previously measured TX bytes
	 */
	private long[] previousTXBytes;

	/**
	 * DiskUsages which collect data for the MBean
	 */
	private List<DiskUsage> diskUsages;

	/**
	 * Collects network usage data for the MBean
	 */
	private List<NetworkUsage> netUsages;

	/**
	 * Data collecting OS level memory usage
	 */
	private MemoryUsage memoryUsage;

	/**
	 * Data collecting OS level CPU usage
	 */
	private CPUUsage cpuUsage;

	/**
	 * Name of the host to be monitored
	 */
	private String hostName;
	
	private double lastReportedCPU;
	
	private double lastReportedMemory;
	
	private boolean firstRound = true;

	private ActorRef monitoringServerAddress;
	
	private static String monitoringServerIP;

	/**
	 * Constructor
	 * 
	 * @throws SigarException
	 * @throws UnknownHostException
	 */
	protected OSMonitor() throws SigarException, UnknownHostException {
		
		monitoringServerAddress = getContext().actorFor("akka://monitoringserver@" + monitoringServerIP + ":5225/user/collector");

		InetAddress iAddress = InetAddress.getLocalHost();
		hostName = iAddress.getHostName();

		memoryUsage = new MemoryUsage();
		cpuUsage = new CPUUsage();

		measureMemory();
		measureCPU();

		diskList = new ArrayList<FileSystem>();

		for (FileSystem fileSystem : sigar.getFileSystemList()) {
			if (fileSystem.getType() == FileSystem.TYPE_LOCAL_DISK) {
				diskList.add(fileSystem);
			}
		}

		int numberOfDisks = diskList.size();

		diskUsages = new ArrayList<DiskUsage>(numberOfDisks);

		previousDiskReads = new long[numberOfDisks];
		previousDiskReadBytes = new long[numberOfDisks];
		previousDiskWrites = new long[numberOfDisks];
		previousDiskWriteBytes = new long[numberOfDisks];

		for (int i = 0; i < numberOfDisks; i++) {
			FileSystem fileSystem = diskList.get(i);
			FileSystemUsage usage = sigar.getFileSystemUsage(fileSystem
					.getDirName());
			previousDiskReads[i] = usage.getDiskReads();
			previousDiskReadBytes[i] = usage.getDiskReadBytes();
			previousDiskWrites[i] = usage.getDiskWrites();
			previousDiskWriteBytes[i] = usage.getDiskWriteBytes();

			DiskUsage diskUsage = new DiskUsage(fileSystem.getDevName());
			diskUsages.add(diskUsage);
		}

		networkInterfaces = new ArrayList<String>();
		netUsages = new ArrayList<NetworkUsage>();

		for (String netInterface : sigar.getNetInterfaceList()) {

			NetInterfaceConfig netInterfaceConfig = sigar
					.getNetInterfaceConfig(netInterface);

			if ((netInterfaceConfig.getType().equals("Ethernet") || netInterfaceConfig.getType().equals("Local Loopback"))
					&& !netInterfaceConfig.getAddress().equals("0.0.0.0")) {
				networkInterfaces.add(netInterface);

				NetworkUsage netUsage = new NetworkUsage(
						netInterfaceConfig.getName(),
						netInterfaceConfig.getAddress());
				netUsages.add(netUsage);
			}

		}

		int numberOfNetInterfaces = networkInterfaces.size();

		previousRXPackets = new long[numberOfNetInterfaces];
		previousRXBytes = new long[numberOfNetInterfaces];
		previousTXPackets = new long[numberOfNetInterfaces];
		previousTXBytes = new long[numberOfNetInterfaces];

		for (int i = 0; i < numberOfNetInterfaces; i++) {
			NetInterfaceStat netStat = null;
			try {
				netStat = sigar.getNetInterfaceStat(networkInterfaces.get(i));
			} catch (SigarException e) {
				System.exit(1);
			}

			previousRXPackets[i] = netStat.getRxPackets();
			previousRXBytes[i] = netStat.getRxBytes();
			previousTXPackets[i] = netStat.getTxPackets();
			previousTXBytes[i] = netStat.getTxBytes();
		}

		timer.start();
	}

	/**
	 * Thread running method That does the periodic measurement
	 */
	public void run() {

		long diskRead = 0;
		long diskReadBytes = 0;
		long diskWrite = 0;
		long diskWriteBytes = 0;

		long RXPacket = 0;
		long RXBytes = 0;
		long TXPacket = 0;
		long TXBytes = 0;

		while (true) {

			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {

			}
			
			try {
				measureMemory();
				measureCPU();
			} catch (SigarException e) {
				System.exit(1);
			}
			
			double usedCPUPercent = cpuUsage.getUsedCPUPercent();
			double usedMemoryPercent = memoryUsage.getUsedMemoryPercent();
			
			boolean shouldAlarm = firstRound || Math.abs(usedCPUPercent - lastReportedCPU) >= 10  || Math.abs(usedMemoryPercent - lastReportedMemory) >= 5;
			
			if(! shouldAlarm) continue;
			
			// else ...
			firstRound = false;
			lastReportedCPU = usedCPUPercent;
			lastReportedMemory = usedMemoryPercent;
			
			
			long timeDiff = timer.getTime();
			double elapsedTimeInSec = (double) (timeDiff / 1000);

			for (int i = 0; i < diskList.size(); i++) {
				FileSystem fileSystem = diskList.get(i);
				FileSystemUsage usage = null;

				try {
					usage = sigar.getFileSystemUsage(fileSystem.getDirName());
				} catch (SigarException e) {
					System.exit(1);
				}

				diskRead = usage.getDiskReads();
				diskReadBytes = usage.getDiskReadBytes();
				diskWrite = usage.getDiskWrites();
				diskWriteBytes = usage.getDiskWriteBytes();

				DiskUsage diskUsage = diskUsages.get(i);

				diskUsage.setDiskQueue(usage.getDiskQueue());
				diskUsage.setDiskReads(diskRead - previousDiskReads[i]);
				diskUsage.setDiskReadBytes((double) (((diskReadBytes) - previousDiskReadBytes[i]) / elapsedTimeInSec));
				diskUsage.setDiskWrites(diskWrite - previousDiskWrites[i]);
				diskUsage.setDiskWriteBytes((double) (((diskWriteBytes) - previousDiskWriteBytes[i]) / elapsedTimeInSec));

				previousDiskReads[i] = diskRead;
				previousDiskReadBytes[i] = diskReadBytes;
				previousDiskWrites[i] = diskWrite;
				previousDiskWriteBytes[i] = diskWriteBytes;

			}

			for (int i = 0; i < networkInterfaces.size(); i++) {
				NetInterfaceStat netStat = null;
				try {
					netStat = sigar.getNetInterfaceStat(networkInterfaces
							.get(i));
				} catch (SigarException e) {
					System.exit(1);
				}

				RXPacket = netStat.getRxPackets();
				RXBytes = netStat.getRxBytes();
				TXPacket = netStat.getTxPackets();
				TXBytes = netStat.getTxBytes();

				NetworkUsage netUsage = netUsages.get(i);

				netUsage.setRxPackets(RXPacket - previousRXPackets[i]);
				netUsage.setRxTraffic((double) ((RXBytes - previousRXBytes[i]) * 8)
						/ (1024 * elapsedTimeInSec)); // in Kbps
				netUsage.setTxPackets(TXPacket - previousTXPackets[i]);
				netUsage.setTxTraffic((double) ((TXBytes - previousTXBytes[i]) * 8)
						/ (1024 * elapsedTimeInSec)); // in Kbps
				
				double toMega = 1024*1024;
				double sumRXinMB = (RXBytes / toMega);
				double sumTXinMB = (TXBytes / toMega);
				netUsage.setRxSumTraffic(sumRXinMB);
				netUsage.setTxSumTraffic(sumTXinMB);

				previousRXPackets[i] = RXPacket;
				previousRXBytes[i] = RXBytes;
				previousTXPackets[i] = TXPacket;
				previousTXBytes[i] = TXBytes;
			}


			timer.reset();
			timer.start();
			
			HostData data = new HostData(hostName, new OSMonitoringData(memoryUsage, cpuUsage, diskUsages, netUsages));
			
			monitoringServerAddress.tell(data, getSelf());

		}
	}

	/**
	 * Main method
	 * 
	 * @param args
	 * @throws SigarException
	 * @throws UnknownHostException
	 */
	public static void main(String[] args) throws SigarException,
			UnknownHostException {
		
		monitoringServerIP = args[0];
		
		String config = "akka {\r\n" + 
		 		"\r\n" + 
		 		"  actor {\r\n" + 
		 		"    provider = \"akka.remote.RemoteActorRefProvider\"\r\n" + 
		 		"  }\r\n" + 
		 		"\r\n" + 
		 		"  remote {\r\n" + 
		 		"    transport = \"akka.remote.netty.NettyRemoteTransport\"\r\n" + 
		 		"    netty {\r\n" + 
		 		"      port = 7777\r\n" + 
		 		"    }\r\n" + 
		 		"  }\r\n" + 
		 		"\r\n" + 
		 		"}";

		final ActorSystem system = ActorSystem.create("OSMonitorSystem",
		        ConfigFactory.parseString(config));
		
		OSMonitorCreator creator = new OSMonitorCreator();
		system.actorOf(Props.apply(creator), "osmonitor");
		
		try {
			Thread.sleep(2000);
		 } catch (InterruptedException e) {
			
		 }
		
		creator.getMonitor().run();

	}

	/* PRIVATE METHODS */

	private int toGig = 1024 * 1024 * 1024;

	private void measureMemory() throws SigarException {

		memoryUsage.setTotalMemory((double) sigar.getMem().getTotal() / toGig);
		memoryUsage.setUsedMemory((double) sigar.getMem().getUsed() / toGig);
		memoryUsage.setFreeMemory((double) sigar.getMem().getFree() / toGig);
		double usedPercent = (memoryUsage.getUsedMemory() / memoryUsage
				.getTotalMemory()) * 100;
		memoryUsage.setUsedMemoryPercent(usedPercent);
		memoryUsage.setFreeMemoryPercent(100 - usedPercent);

	}

	private void measureCPU() throws SigarException {

		cpuUsage.setUsedCPUPercent((sigar.getCpuPerc().getCombined()) * 100);

	}

	@Override
	public void onReceive(Object arg0) throws Exception {
	}

}
