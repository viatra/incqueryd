package hu.bme.mit.incqueryd.monitoringserver.core.model;

import java.util.List;

public class AggregatedMonitoringData {
	
	private List<MachineMonitoringData> machines;
	
	public void setMachines(List<MachineMonitoringData> machines) {
		this.machines = machines;
	}
	
	public List<MachineMonitoringData> getMachines() {
		return machines;
	}
}
