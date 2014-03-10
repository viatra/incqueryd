package hu.bme.mit.incqueryd.arch;

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
		// Akka
		system = ActorSystem.create();

		final ArchTestKit testKit = new ArchTestKit(system, "../hu.bme.mit.incqueryd.recipeinstances/src/test/resources/arch/routeSensor.arch");
		testKit.test();
	}

}
