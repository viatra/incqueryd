package hu.bme.mit.incqueryd.arch;

import hu.bme.mit.incqueryd.databases.CoordinatorFourStoreClient;
import hu.bme.mit.incqueryd.rete.actors.testkits.ArchTestKit;

import java.io.IOException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import akka.actor.ActorSystem;

public class ArchTest {

	protected static ActorSystem system;

	@BeforeClass
	public static void setup() {
		system = ActorSystem.create();
	}

	@AfterClass
	public static void teardown() {
		system.shutdown();
	}

	@Test
	public void test() throws IOException {
		// start the cluster and load the model
		final CoordinatorFourStoreClient client = new CoordinatorFourStoreClient("src/main/resources/scripts");
		client.start(false);
		client.load("src/test/resources/models/railway-xform-1.owl");

		// Akka
		system = ActorSystem.create();

		final String architecturePath = "../hu.bme.mit.incqueryd.recipeinstances/src/test/resources/arch/";

		// PosLength, expected: 470 423
		// final String architectureFile = architecturePath + "posLength.arch";

		// RouteSensor, expected: 94 85
		// final String architectureFile = architecturePath + "routeSensor.arch";

		// SwitchSensor, expected: 19 18
		// final String architectureFile = architecturePath + "switchSensor.arch";

		// SignalNeighbor, expected: 3 2
		final String architectureFile = architecturePath + "signalNeighbor.arch";

		final ArchTestKit testKit = new ArchTestKit(system, architectureFile);
		testKit.test();

		// destroy the cluster
		client.destroy(false);
	}
}
