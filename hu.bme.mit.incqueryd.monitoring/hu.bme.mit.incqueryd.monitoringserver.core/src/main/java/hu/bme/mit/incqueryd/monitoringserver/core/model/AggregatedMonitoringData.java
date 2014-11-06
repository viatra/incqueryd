package hu.bme.mit.incqueryd.monitoringserver.core.model;

import hu.bme.mit.incqueryd.retemonitoring.metrics.ReteNodeMetrics;

import java.util.List;

public class AggregatedMonitoringData {
	
	private List<MachineMonitoringData> machines;
	private List<ReteNodeMetrics> rete;
	private int changes;
	
	public void setMachines(List<MachineMonitoringData> machines) {
		this.machines = machines;
	}
	
	public List<MachineMonitoringData> getMachines() {
		return machines;
	}
	
	public void setRete(List<ReteNodeMetrics> rete) {
		this.rete = rete;
	}
	
	public List<ReteNodeMetrics> getRete() {
		return rete;
	}
	
	public int getChanges() {
		return changes;
	}
	
	public void setChanges(int changes) {
		this.changes = changes;
	}
}
