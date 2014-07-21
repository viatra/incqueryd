package hu.bme.mit.incqueryd.monitoringserver.core.model;

import hu.bme.mit.incqueryd.retemonitoring.metrics.ReteNodeMetrics;

import java.util.List;

public class AggregatedMonitoringData {
	
	private List<MachineMonitoringData> machines;
	private List<ReteNodeMetrics> rete;
	private QueryResultData result;
	
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
	
	public QueryResultData getResult() {
		return result;
	}
	
	public void setResult(QueryResultData result) {
		this.result = result;
	}
}
