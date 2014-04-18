package hu.bme.mit.incqueryd.main;

import static akka.pattern.Patterns.ask;
import hu.bme.mit.incqueryd.rete.actors.CoordinatorActorFactory;
import hu.bme.mit.trainbenchmark.benchmark.util.BenchmarkResult;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipselabs.emfjson.resource.JsResourceFactoryImpl;

import scala.concurrent.Await;
import scala.concurrent.Future;
import scala.concurrent.duration.Duration;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.util.Timeout;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public class IncQueryDWorker {

	public IncQueryDWorker() {
		super();
		
		// initialize EMF
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("json", new JsResourceFactoryImpl());
	}

	public void work(final BenchmarkResult bmr, final String architectureFile, final boolean cluster) throws Exception {
		// initialize Akka
		final ActorSystem system;
		final Timeout timeout = new Timeout(Duration.create(14400, "seconds"));
		final Config config = ConfigFactory.parseString("akka.actor.provider = akka.remote.RemoteActorRefProvider\n"
				+ "akka.remote.netty.message-frame-size = 10000000000\n" + "akka.loglevel = \"ERROR\"");

		system = ActorSystem.create("test", config);

		// this should run on the client's side
		final Props props = new Props().withCreator(new CoordinatorActorFactory(architectureFile, cluster));
		final ActorRef coordinator = system.actorOf(props);

		// final Future<Object> result = ask(coordinator, CoordinatorCommand.START, timeout);
		final Future<Object> result = ask(coordinator, bmr, timeout);
		final BenchmarkResult bmr2 = (BenchmarkResult) Await.result(result, timeout.duration());
		System.out.println(bmr2);

		system.shutdown();
	}

}
