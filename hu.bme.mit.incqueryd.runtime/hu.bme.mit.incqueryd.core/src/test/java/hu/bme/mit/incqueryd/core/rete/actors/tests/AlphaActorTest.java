package hu.bme.mit.incqueryd.core.rete.actors.tests;

import hu.bme.mit.incqueryd.core.rete.actors.testkits.AlphaActorTestKit;
import hu.bme.mit.incqueryd.core.rete.nodes.data.AlphaTestData;
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
 * Test cases for the alpha nodes.
 * 
 * @author szarnyasg
 * 
 */
public class AlphaActorTest {

	protected static ActorSystem system;

	@BeforeClass
	public static void setup() {
		system = ActorSystem.create();
	}

	@AfterClass
	public static void teardown() {
		system.shutdown();
	}

	private void alphaNodeTest(final String typeString) throws FileNotFoundException, IOException {
		final File[] files = TestCaseFinder.getTestCases(typeString + "-test-*.json");

		for (final File testFile : files) {
			final String recipeFile = testFile.getPath().replace("-test-", "-recipe-");
			final Gson gson = GsonParser.getGsonParser();
			final AlphaTestData data = gson.fromJson(new FileReader(testFile), AlphaTestData.class);

			final AlphaActorTestKit testKit = new AlphaActorTestKit(system, recipeFile);
			testKit.test(data);
		}
	}
	
	@Test
	public void trimmerNodeTest() throws JsonSyntaxException, JsonIOException, IOException {	
		alphaNodeTest("trimmer");
	}

	@Test
	public void equalityNodeTest() throws JsonSyntaxException, JsonIOException, IOException {
		alphaNodeTest("equality");
	}
	
	@Test
	public void inequalityNodeTest() throws JsonSyntaxException, JsonIOException, IOException {
		alphaNodeTest("inequality");
	}

}