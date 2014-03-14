package hu.bme.mit.incqueryd.arch;

import static akka.pattern.Patterns.ask;
import hu.bme.mit.incqueryd.databases.CoordinatorFourStoreClient;
import hu.bme.mit.incqueryd.rete.messages.CoordinatorCommand;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import scala.concurrent.Await;
import scala.concurrent.Future;
import scala.concurrent.duration.Duration;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.util.Timeout;

public class ArchTest {

	protected static ActorSystem system;
	protected final Timeout timeout = new Timeout(Duration.create(3600, "seconds"));

	@BeforeClass
	public static void setup() {
		system = ActorSystem.create();
	}

	@AfterClass
	public static void teardown() {
		system.shutdown();
	}

	@Test
	public void test() throws Exception {
		final boolean cluster = true;

		// start the cluster and load the model
		final CoordinatorFourStoreClient client = new CoordinatorFourStoreClient("src/main/resources/scripts");
		client.start(cluster);
		// final String modelPath = "src/test/resources/models/railway-user-1-no-metamodel.owl";
		final String modelPath = "src/test/resources/models/railway-xform-1-no-metamodel.owl";
		client.load(modelPath);

		// Akka
		system = ActorSystem.create();

		final String architecturePath = "../hu.bme.mit.incqueryd.recipeinstances/src/test/resources/arch/";

		// PosLength, expected: 470 423
		final String architectureFile = architecturePath + "posLength.arch";

		// RouteSensor, expected: 94 85
		// final String architectureFile = architecturePath + "routeSensor.arch";

		// SwitchSensor, expected: 19 18
		// final String architectureFile = architecturePath + "switchSensor.arch";

		// SignalNeighbor, expected: 3 2
		// final String architectureFile = architecturePath + "signalNeighbor.arch";

		final Props props = new Props().withCreator(new CoordinatorActorFactory(architectureFile));
		final ActorRef coordinator = system.actorOf(props);
		final Future<Object> result = ask(coordinator, CoordinatorCommand.START, timeout);
		Await.result(result, timeout.duration());
		
		// destroy the cluster
		client.destroy(cluster);
	}
}
