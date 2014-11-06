package hu.bme.mit.incqueryd.monitoringserver.dwserver;

import hu.bme.mit.incqueryd.monitoringserver.core.processing.MonitoringWorker;
import hu.bme.mit.incqueryd.monitoringserver.dwserver.resources.IncquerydDeltaResultResource;
import hu.bme.mit.incqueryd.monitoringserver.dwserver.resources.IncquerydMonitoringResource;
import hu.bme.mit.incqueryd.monitoringserver.dwserver.resources.IncquerydQueryResultResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

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

		final MonitoringWorker worker = new MonitoringWorker(configuration.getCollectorInterface());
		
		worker.start();
		
		final IncquerydMonitoringResource resource = new IncquerydMonitoringResource(worker);
		
		final IncquerydQueryResultResource resultResource = new IncquerydQueryResultResource();
		
		final IncquerydDeltaResultResource deltaResource = new IncquerydDeltaResultResource();
		
		environment.jersey().register(resource);
		environment.jersey().register(resultResource);
		environment.jersey().register(deltaResource);
		
	}

}
