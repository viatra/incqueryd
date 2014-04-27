package hu.bme.mit.incqueryd.monitoringserver.dwserver;

import hu.bme.mit.incqueryd.monitoringserver.core.processing.MonitoringWorker;
import hu.bme.mit.incqueryd.monitoringserver.dwserver.resources.IncquerydMonitoringResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

import java.util.HashMap;
import java.util.Map;

public class IncquerydMonitoringApplication extends
		Application<IncquerydMonitoringConfiguration> {
	
	public static void main(String[] args) throws Exception {
        new IncquerydMonitoringApplication().run(args);
    }

	@Override
	public void initialize(Bootstrap<IncquerydMonitoringConfiguration> bootstrap) {
		// TODO Auto-generated method stub

	}

	@Override
	public void run(IncquerydMonitoringConfiguration configuration, Environment environment)
			throws Exception {
		
		Map<String, Integer> monitoredHosts = new HashMap<>();
		
		for (MonitoredHostInfo host : configuration.getMonitoredHosts()) {
			monitoredHosts.put(host.getHostName(), host.getPort());
		}
		

		final MonitoringWorker worker = new MonitoringWorker(monitoredHosts, configuration.getAtmosHost(), configuration.getAtmosPort());
		
		worker.start();
		
		final IncquerydMonitoringResource resource = new IncquerydMonitoringResource(worker);
		
		environment.jersey().register(resource);
		

	}

}
