package hu.bme.mit.incqueryd.agent;

import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class Agent extends Application<Configuration> {

	public static void main(String[] args) throws Exception {
		new Agent().run(args);
	}

	@Override
	public void initialize(Bootstrap<Configuration> bootstrap) {
	}

	@Override
	public void run(Configuration configuration, Environment environment) throws Exception {
		DeployResource deployResource = new DeployResource();
		environment.jersey().register(deployResource);
	}

}
