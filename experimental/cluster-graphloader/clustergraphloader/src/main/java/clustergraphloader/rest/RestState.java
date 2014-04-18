package clustergraphloader.rest;

import org.apache.log4j.Logger;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

import clustergraphloader.data.ClusterConfiguration;
import clustergraphloader.graphml.GraphMlParserFirstPass;
import clustergraphloader.xmlparser.ClusterGraphLoader;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;

public enum RestState {
	instance;

	protected ActorSystem system;
	protected ActorRef coordinator;
	protected int k;
	
	// logger
	protected final Logger logger = Logger.getLogger(RestState.class);
	
	public void setCoordinator(ActorRef coordinator) {
		this.coordinator = coordinator;
	}

	public ActorRef getCoordinator() {
		return coordinator;
	}

	public void process(ClusterConfiguration configuration) {
		// initialize ActorSystem
		if (system == null) {
			logger.info("Initialising ActorSystem.");
			Config remoteCreationConfig = ConfigFactory.load().getConfig("remotecreation");
			system = ActorSystem.create("ReteNet", remoteCreationConfig);
		}

		ClusterGraphLoader loader = new ClusterGraphLoader(configuration);
		ActorRef coordinator = loader.start(system, k);
		k++;
		setCoordinator(coordinator);
	}
}
