package hu.bme.mit.incqueryd.monitoringserver.core.processing;

import hu.bme.mit.incqueryd.monitoringserver.core.datacollection.AkkaMonitoringDataCollector;
import hu.bme.mit.incqueryd.monitoringserver.core.datacollection.MonitoringService;
import hu.bme.mit.incqueryd.monitoringserver.core.model.AggregatedMonitoringData;
import hu.bme.mit.incqueryd.monitoringserver.core.model.MachineMonitoringData;
import hu.bme.mit.incqueryd.monitoringserver.core.model.NodeMonitoringData;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MonitoringWorker extends Thread {
	
	private Map<String, Integer> monitoredHosts;
	private String atmosHost;
	private int atmosPort;
	
	private volatile boolean exit;
	
	private AggregatedMonitoringData monitoredData;
	
	public MonitoringWorker(Map<String, Integer> monitoredHosts, String atmosHost,
			int atmosPort) {
		super();
		this.monitoredHosts = monitoredHosts;
		this.atmosHost = atmosHost;
		this.atmosPort = atmosPort;
		
		monitoredData = new AggregatedMonitoringData();
		
		exit = false;
		
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
			
			monitor(); // what if starts lately -> think about it
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				
			}
		}
		
	}

}
