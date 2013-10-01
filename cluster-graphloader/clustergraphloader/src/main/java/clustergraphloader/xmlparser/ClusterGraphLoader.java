package clustergraphloader.xmlparser;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Address;
import akka.actor.Deploy;
import akka.actor.Props;
import akka.remote.RemoteScope;
import clustergraphloader.actors.Coordinator;
import clustergraphloader.actors.DatabaseLoader;
import clustergraphloader.data.ClusterConfiguration;
import clustergraphloader.helper.Timer;
import clustergraphloader.messages.CoordinatorConfig;

public class ClusterGraphLoader {

	protected final String fileName;
	protected final String[] ips;
	protected final Logger logger = Logger.getLogger(ClusterGraphLoader.class);
	
	public ClusterGraphLoader(ClusterConfiguration configuration) {
		fileName = configuration.getFileName();
		ips = configuration.getIps();
		
		logger.info("Initialising cluster graph loader for file " + fileName);
	}

	/**
	 * Starts the loading process.
	 * @return A reference to the {@link Coordinator} actor.
	 */
	public ActorRef start(ActorSystem system, int k) {
		Timer.instance.startTimer();
		
		logger.info("Instantiating coordinator node");
		
		// instantiating the Coordinator actor and let it do the work
		ActorRef coordinator = system.actorOf(new Props(Coordinator.class), "Coordinator" + k);

		// Programmatic Remote Deployment:
		// http://doc.akka.io/docs/akka/2.1.2/java/remoting.html#Programmatic_Remote_Deployment

		// creating a list of the dbLoader actors
		List<ActorRef> actors = new ArrayList<>();

		logger.info("Instantiating DatabaseLoader");
		
		// instantiating the actors
		for (String ip : ips) {
			Address addr = new Address("akka", "ClusterGraphLoader", ip, 2552);
			ActorRef dbLoader =
					system.actorOf(new Props(DatabaseLoader.class).withDeploy(new Deploy(new RemoteScope(addr))));
			actors.add(dbLoader);
		}

		// wrapping the list
		CoordinatorConfig actorRefs = new CoordinatorConfig(ips[0], actors, fileName);

		// passing the actorRefs object to the coordinator actor
		coordinator.tell(actorRefs, null);
		
		return coordinator;
	}

}
