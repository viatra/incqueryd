package hu.bme.mit.incqueryd.monitoringserver.core.model;

import hu.bme.mit.incqueryd.jvmmonitoring.metrics.JVMMetrics;

import java.util.ArrayList;
import java.util.List;

public class MachineMonitoringData {
	
	private String host;
	
	private OSMonitoringData os;
	
	private List<JVMMetrics> nodes;
	
	
	public MachineMonitoringData() {
		nodes = new ArrayList<>();
	}
	
	public String getHost() {
		return host;
	}
	
	public List<JVMMetrics> getNodes() {
		return nodes;
	}
	
	public OSMonitoringData getOs() {
		return os;
	}
	
	public void setHost(String host) {
		this.host = host;
	}
	
	public void addNode(JVMMetrics node) {
		this.nodes.add(node);
	}
	
	public void setOs(OSMonitoringData os) {
		this.os = os;
	}

}
