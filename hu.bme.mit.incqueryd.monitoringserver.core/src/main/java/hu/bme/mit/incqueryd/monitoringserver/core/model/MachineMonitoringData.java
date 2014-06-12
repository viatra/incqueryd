package hu.bme.mit.incqueryd.monitoringserver.core.model;

import java.util.ArrayList;
import java.util.List;

public class MachineMonitoringData {
	
	private String host;
	
	private OSMonitoringData os;
	
	private List<NodeMonitoringData> nodes;
	
	
	public MachineMonitoringData() {
		nodes = new ArrayList<>();
	}
	
	public String getHost() {
		return host;
	}
	
	public List<NodeMonitoringData> getNodes() {
		return nodes;
	}
	
	public OSMonitoringData getOs() {
		return os;
	}
	
	public void setHost(String host) {
		this.host = host;
	}
	
	public void addNode(NodeMonitoringData node) {
		this.nodes.add(node);
	}
	
	public void setOs(OSMonitoringData os) {
		this.os = os;
	}

}
