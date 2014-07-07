package hu.bme.mit.incqueryd.monitoringserver.dwserver;

import hu.bme.mit.incqueryd.monitoringserver.core.processing.MonitoringWorker;
import hu.bme.mit.incqueryd.monitoringserver.dwserver.resources.IncquerydMonitoringResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

import java.util.HashMap;
import java.util.Map;

import com.bazaarvoice.dropwizard.assets.ConfiguredAssetsBundle;

public class IncquerydMonitoringApplication extends
		Application<IncquerydMonitoringConfiguration> {
	
	public static void main(String[] args) throws Exception {
        new IncquerydMonitoringApplication().run(args);
    }

	@Override
	public void initialize(Bootstrap<IncquerydMonitoringConfiguration> bootstrap) {
		bootstrap.addBundle( new ConfiguredAssetsBundle("/html/", "/dashboard/"));
		
	}

	@Override
	public void run(IncquerydMonitoringConfiguration configuration, Environment environment)
			throws Exception {
		
		Map<String, Integer> monitoredHosts = new HashMap<String, Integer>();
		
		for (MonitoredHostInfo host : configuration.getMonitoredHosts()) {
			monitoredHosts.put(host.getHostName(), host.getPort());
		}
		

		final MonitoringWorker worker = new MonitoringWorker(monitoredHosts);
		
		worker.start();
		
		final IncquerydMonitoringResource resource = new IncquerydMonitoringResource(worker);
		
		environment.jersey().register(resource);
		

	}

}
