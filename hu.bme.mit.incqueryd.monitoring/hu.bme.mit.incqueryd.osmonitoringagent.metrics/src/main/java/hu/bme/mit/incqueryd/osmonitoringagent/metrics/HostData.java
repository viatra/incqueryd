package hu.bme.mit.incqueryd.osmonitoringagent.metrics;

import java.io.Serializable;

public class HostData implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String hostName;
	
	private OSMonitoringData os;
	
	public HostData(String hostName, OSMonitoringData os) {
		super();
		this.hostName = hostName;
		this.os = os;
	}

	public String getHostName() {
		return hostName;
	}
	
	public OSMonitoringData getOs() {
		return os;
	}
	
}
