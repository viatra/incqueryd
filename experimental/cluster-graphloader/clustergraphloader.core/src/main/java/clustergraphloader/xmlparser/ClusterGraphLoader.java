package clustergraphloader.xmlparser;

import java.util.ArrayList;
import java.util.List;

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

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public class ClusterGraphLoader {

	protected final String fileName;
	protected final String[] ips;

	public ClusterGraphLoader(ClusterConfiguration configuration) {
		this.fileName = configuration.getFileName();
		this.ips = configuration.getIps();
	}

	/**
	 * Starts the loading process.
	 * @return A reference to the {@link Coordinator} actor.
	 */
	public void start() {
		Timer.instance.startTimer();
    	
		Config remoteCreationConfig = ConfigFactory.load().getConfig("remotecreation");
		ActorSystem system = ActorSystem.create("ReteNet", remoteCreationConfig);

		// instantiating the Coordinator actor and let it do the work
		ActorRef coordinator = system.actorOf(new Props(Coordinator.class), "Coordinator");

		// Programmatic Remote Deployment:
		// http://doc.akka.io/docs/akka/2.1.2/java/remoting.html#Programmatic_Remote_Deployment

		// creating a list of the dbLoader actors
		List<ActorRef> actors = new ArrayList<>();

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
		
		//return coordinator;
	}

}
