package hu.bme.mit.incqueryd.main;

import static akka.pattern.Patterns.ask;
import hu.bme.mit.incqueryd.databases.CoordinatorFourStoreClient;
import hu.bme.mit.incqueryd.rete.actors.CoordinatorActorFactory;
import hu.bme.mit.incqueryd.rete.messages.CoordinatorCommand;
import hu.bme.mit.trainbenchmark.benchmark.config.IncQueryDBenchmarkConfig;
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

	private final IncQueryDBenchmarkConfig bc;

	public IncQueryDWorker(final IncQueryDBenchmarkConfig bc) {
		super();
		this.bc = bc;
	}

	// PosLength, expected: 470 423
	// RouteSensor, expected: 94 85
	// SignalNeighbor, expected: 3 2
	// SwitchSensor, expected: 19 18
	public void work() throws Exception {
		final boolean cluster = false;
		final boolean initialize4s = true;

		final String testCase = bc.getTestCases().get(0);
		final int size = bc.getSizes().get(0);

		final String architectureFile = "../hu.bme.mit.incqueryd.recipeinstances/src/test/resources/arch/"
				+ testCase.toLowerCase() + ".arch";

		// initialize 4store
		final CoordinatorFourStoreClient client;
		if (initialize4s) {
			client = new CoordinatorFourStoreClient("src/main/resources/scripts");
			client.start(bc.isCluster());

			// load the model
			// src/test/resources/models/
			final String modelPath = bc.getInstanceModelPath() + "/railway-" + bc.getScenario().toLowerCase() + "-"
					+ size + "-no-metamodel.owl";
			client.load(modelPath);
		}

		// initialize Akka
		final ActorSystem system;
		final Timeout timeout = new Timeout(Duration.create(15, "seconds"));
		final Config config = ConfigFactory.parseString("akka.actor.provider = akka.remote.RemoteActorRefProvider");
		system = ActorSystem.create("test", config);

		// final String modelPath = "src/test/resources/models/railway-user-1-no-metamodel.owl";

		final Props props = new Props().withCreator(new CoordinatorActorFactory(architectureFile, cluster));
		final ActorRef coordinator = system.actorOf(props);

		final Future<Object> result = ask(coordinator, CoordinatorCommand.START, timeout);
		Await.result(result, timeout.duration());

		// destroy the 4store backend(s)
		if (initialize4s) {
			client.destroy(bc.isCluster());
		}

		system.shutdown();
	}

}
