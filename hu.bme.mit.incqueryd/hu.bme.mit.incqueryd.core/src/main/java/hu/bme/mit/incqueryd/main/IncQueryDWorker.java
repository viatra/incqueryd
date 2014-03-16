package hu.bme.mit.incqueryd.main;

import static akka.pattern.Patterns.ask;
import hu.bme.mit.incqueryd.databases.CoordinatorFourStoreClient;
import hu.bme.mit.incqueryd.rete.actors.CoordinatorActorFactory;
import hu.bme.mit.trainbenchmark.benchmark.config.IncQueryDBenchmarkConfig;
import hu.bme.mit.trainbenchmark.benchmark.util.BenchmarkResult;
import hu.bme.mit.trainbenchmark.benchmark.util.Util;
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
		// final boolean cluster = bc.isCluster();
		final boolean cluster = true;
		// final boolean initialize4s = bc.isInitialize4s();
		final boolean initialize4s = true;

		final String testCase = bc.getTestCases().get(0);
		final int seriesCount = bc.getSeriesCount();

		final String architectureFile = "../hu.bme.mit.incqueryd.recipeinstances/src/test/resources/arch/"
				+ testCase.toLowerCase() + ".arch";

		final int size = bc.getSizes().get(0);
		final String modelFileName = "/railway-" + bc.getScenario().toLowerCase() + "-" + size + "-no-metamodel.owl";

		final BenchmarkResult bmr = new BenchmarkResult("IQD", testCase, size, seriesCount);
		bmr.setBenchmarkConfig(bc);
		bmr.setSize(size);
		bmr.setFileName(modelFileName);
		Util.runGC();
		if (bc.isBenchmarkMode()) {
			Util.freeCache(bc);
		}

		// initialize 4store
		CoordinatorFourStoreClient client = null;

		bmr.startStopper();
		if (initialize4s) {
			client = new CoordinatorFourStoreClient("src/main/resources/scripts");
			client.start(bc.isCluster());

			// load the model
			final String modelPath = bc.getInstanceModelPath() + modelFileName;
			client.load(modelPath);
		}
		bmr.setReadTime();

		// initialize Akka
		final ActorSystem system;
		final Timeout timeout = new Timeout(Duration.create(15, "seconds"));
		final Config config = ConfigFactory.parseString("akka.actor.provider = akka.remote.RemoteActorRefProvider\n"
				+ "akka.remote.netty.message-frame-size = 10000000000\n"
				+ "akka.loglevel = \"ERROR\"");

		system = ActorSystem.create("test", config);

		final Props props = new Props().withCreator(new CoordinatorActorFactory(architectureFile, cluster));
		final ActorRef coordinator = system.actorOf(props);

		// final Future<Object> result = ask(coordinator, CoordinatorCommand.START, timeout);
		final Future<Object> result = ask(coordinator, bmr, timeout);
		final BenchmarkResult bmr2 = (BenchmarkResult) Await.result(result, timeout.duration());
		System.out.println(bmr2);

		// destroy the 4store backend(s)
		if (initialize4s) {
			client.destroy(bc.isCluster());
		}

		system.shutdown();
	}

}
