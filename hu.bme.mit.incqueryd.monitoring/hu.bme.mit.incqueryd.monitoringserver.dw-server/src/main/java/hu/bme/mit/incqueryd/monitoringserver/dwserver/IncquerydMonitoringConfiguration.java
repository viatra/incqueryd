package hu.bme.mit.incqueryd.monitoringserver.dwserver;

import io.dropwizard.Configuration;

import org.hibernate.validator.constraints.NotEmpty;

import com.bazaarvoice.dropwizard.assets.AssetsBundleConfiguration;
import com.bazaarvoice.dropwizard.assets.AssetsConfiguration;
import com.fasterxml.jackson.annotation.JsonProperty;

public class IncquerydMonitoringConfiguration extends Configuration implements AssetsBundleConfiguration {

	@NotEmpty
	private String collectorInterface;
	
	@JsonProperty
	public String getCollectorInterface() {
		return collectorInterface;
	}
	
	@JsonProperty
	public void setCollectorInterface(String collectorInterface) {
		this.collectorInterface = collectorInterface;
	}

	public AssetsConfiguration getAssetsConfiguration() {
		// TODO Auto-generated method stub
		return new AssetsConfiguration();
	}
	
}
