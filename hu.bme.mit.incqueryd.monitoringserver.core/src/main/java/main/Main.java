package main;

import hu.bme.mit.incqueryd.monitoringserver.core.network.NetworkAddressHelper;
import hu.bme.mit.incqueryd.monitoringserver.core.processing.MonitoringWorker;

import java.net.UnknownHostException;

public class Main {

	public static void main(String[] args) throws UnknownHostException {
		
//		AkkaMonitoringDataCollector c = new  AkkaMonitoringDataCollector("192.168.241.128", 8660);
//		
//		c.collectNodeData();
//		
//		
//		MachineMonitoringData os = MonitoringService.getMachineMonitoringData("localhost", 7777);
//		//MonitoringService.getOSMonitoringData("192.168.241.128", 7777);
//		
//
//		System.out.println(os.getHost());
//		
//		System.out.println(os.getOs().getCpuUsage().getUsedCPUPercent());
//		System.out.println(os.getOs().getMemoryUsage().getUsedMemory());
		
		System.out.println(NetworkAddressHelper.getLocalHostLANAddress().getHostAddress());
		
		final MonitoringWorker worker = new MonitoringWorker(null, "bla", 1);
		worker.start();
	}
	
	

}
