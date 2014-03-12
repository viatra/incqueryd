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

		final ArchTestKit testKit = new ArchTestKit(system, "../hu.bme.mit.incqueryd.recipeinstances/src/test/resources/arch/routeSensor.arch");
		testKit.test();

		// destroy the cluster
		client.destroy(false);
	}

}
