package hu.bme.mit.incqueryd.core.rete.actors.tests;

import hu.bme.mit.incqueryd.core.rete.actors.testkits.BetaActorTestKit;
import hu.bme.mit.incqueryd.core.rete.nodes.data.BetaTestData;
import hu.bme.mit.incqueryd.core.test.util.GsonParser;
import hu.bme.mit.incqueryd.core.test.util.TestCaseFinder;

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

	private void betaNodeTest(final String typeString) throws FileNotFoundException, IOException {
		final String fileNamePrefix = typeString + "-test-";
		
		final File[] files = TestCaseFinder.getTestCases(fileNamePrefix + "*.json");

		for (final File testFile : files) {
			final String recipeFile = testFile.getPath().replace(fileNamePrefix, typeString + "-recipe-");
			final Gson gson = GsonParser.getGsonParser();
			final BetaTestData data = gson.fromJson(new FileReader(testFile), BetaTestData.class);

			final BetaActorTestKit testKit = new BetaActorTestKit(system, recipeFile);
			testKit.test(data);
		}
	}
	
	@Test
	public void joinNodeTest() throws JsonSyntaxException, JsonIOException, IOException {
		betaNodeTest("join");
	}

	@Test
	public void antiJoinNodeTest() throws JsonSyntaxException, JsonIOException, IOException {
		betaNodeTest("antijoin");
	}

}