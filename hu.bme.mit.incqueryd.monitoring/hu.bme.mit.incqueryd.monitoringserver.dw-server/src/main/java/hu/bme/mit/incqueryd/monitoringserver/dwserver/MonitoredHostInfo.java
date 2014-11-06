package hu.bme.mit.incqueryd.monitoringserver.dwserver;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MonitoredHostInfo {

	@NotEmpty
    private String hostName = null;
	
	private int port;
	
	@JsonProperty
	public String getHostName() {
		return hostName;
	}
	
	@JsonProperty
	public int getPort() {
		return port;
	}
	
	@JsonProperty
	public void setHostName(String hostName) {
		this.hostName = hostName;
	}
	
	@JsonProperty
	public void setPort(int port) {
		this.port = port;
	}
	
}
