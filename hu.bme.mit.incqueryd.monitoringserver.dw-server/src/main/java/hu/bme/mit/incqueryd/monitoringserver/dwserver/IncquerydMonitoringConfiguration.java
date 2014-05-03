package hu.bme.mit.incqueryd.monitoringserver.dwserver;

import io.dropwizard.Configuration;

import java.util.List;

import org.hibernate.validator.constraints.NotEmpty;

import com.bazaarvoice.dropwizard.assets.AssetsBundleConfiguration;
import com.bazaarvoice.dropwizard.assets.AssetsConfiguration;
import com.fasterxml.jackson.annotation.JsonProperty;

public class IncquerydMonitoringConfiguration extends Configuration implements AssetsBundleConfiguration {

	@NotEmpty
	private List<MonitoredHostInfo> monitoredHosts;
	
	@NotEmpty
	private String atmosHost;
	
	private int atmosPort;
	
	@JsonProperty("hosts")
	public List<MonitoredHostInfo> getMonitoredHosts() {
		return monitoredHosts;
	}
	
	@JsonProperty("hosts")
	public void setMonitoredHosts(List<MonitoredHostInfo> monitoredHosts) {
		this.monitoredHosts = monitoredHosts;
	}
	
	@JsonProperty
	public String getAtmosHost() {
		return atmosHost;
	}
	
	@JsonProperty
	public int getAtmosPort() {
		return atmosPort;
	}
	
	@JsonProperty
	public void setAtmosHost(String atmosHost) {
		this.atmosHost = atmosHost;
	}
	
	@JsonProperty
	public void setAtmosPort(int atmosPort) {
		this.atmosPort = atmosPort;
	}

	public AssetsConfiguration getAssetsConfiguration() {
		// TODO Auto-generated method stub
		return new AssetsConfiguration();
	}
	
}
