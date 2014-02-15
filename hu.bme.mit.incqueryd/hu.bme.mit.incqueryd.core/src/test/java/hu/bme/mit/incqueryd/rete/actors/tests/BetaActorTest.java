package hu.bme.mit.incqueryd.rete.actors.tests;

import hu.bme.mit.incqueryd.rete.actors.testkits.BetaActorTestKit;
import hu.bme.mit.incqueryd.rete.nodes.data.BetaTestData;
import hu.bme.mit.incqueryd.test.util.GsonParser;
import hu.bme.mit.incqueryd.test.util.TestCaseFinder;
import hu.bme.mit.incqueryd.util.ReteNodeType;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import akka.actor.ActorSystem;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

/**
 * Test cases for the beta nodes.
 * 
 * @author szarnyasg
 * 
 */
public class BetaActorTest {

	static ActorSystem system;

	@BeforeClass
	public static void setup() {
		system = ActorSystem.create();
	}

	@AfterClass
	public static void teardown() {
		system.shutdown();
	}

	private void betaNodeTest(final String name, final ReteNodeType type) throws FileNotFoundException, IOException {
		final File[] files = TestCaseFinder.getTestCases(name + "-test-*.json");

		for (final File testFile : files) {
			final String recipeFile = testFile.getPath().replace("-test-", "-recipe-");
			final Gson gson = GsonParser.getGsonParser();
			final BetaTestData data = gson.fromJson(new FileReader(testFile), BetaTestData.class);

			final BetaActorTestKit testKit = new BetaActorTestKit(system, type, recipeFile);
			testKit.compute(data);
		}
	}
	
	@Test
	public void joinNodeTest() throws JsonSyntaxException, JsonIOException, IOException {
		betaNodeTest("join", ReteNodeType.JOIN_NODE);
	}

	@Test
	public void antiJoinNodeTest() throws JsonSyntaxException, JsonIOException, IOException {
		betaNodeTest("antijoin", ReteNodeType.ANTIJOIN_NODE);
	}

}