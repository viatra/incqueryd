package hu.bme.mit.incqueryd.main;

import hu.bme.mit.incqueryd.rete.actors.CoordinatorActorFactory;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipselabs.emfjson.resource.JsResourceFactoryImpl;

import scala.concurrent.duration.Duration;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.util.Timeout;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public class IncQueryDEngine {

	protected final Timeout timeout = new Timeout(Duration.create(14400, "seconds"));
	protected final ActorSystem system;
	protected ActorRef coordinator;

	public IncQueryDEngine() {
		super();

		// initialize EMF
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("json", new JsResourceFactoryImpl());

		// initialize Akka
		final Config config = ConfigFactory.parseString("akka.actor.provider = akka.remote.RemoteActorRefProvider\n"
				+ "akka.remote.netty.message-frame-size = 10000000000\n" + "akka.loglevel = \"ERROR\"");

		system = ActorSystem.create("test", config);
	}

	public ActorRef initialize(final String architectureFile, final boolean cluster, final String monitoringServerIPAddress) throws Exception {
		// initialize the coordinator Actor
		// the coordinator Actor runs on the client's side
		final Props props = new Props().withCreator(new CoordinatorActorFactory(architectureFile, cluster, monitoringServerIPAddress));
		coordinator = system.actorOf(props);
		return coordinator;
	}

	public void shutdown() {
		//system.shutdown();
	}

}
