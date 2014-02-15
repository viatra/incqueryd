package hu.bme.mit.incqueryd.rete.actors.tests;

import hu.bme.mit.incqueryd.rete.actors.testkits.AlphaActorTestKit;
import hu.bme.mit.incqueryd.rete.nodes.data.AlphaTestData;
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
 * Test cases for the alpha nodes.
 * 
 * @author szarnyasg
 * 
 */
public class AlphaActorTest {

	static ActorSystem system;

	@BeforeClass
	public static void setup() {
		system = ActorSystem.create();
	}

	@AfterClass
	public static void teardown() {
		system.shutdown();
	}

	private void alphaNodeTest(final ReteNodeType type) throws FileNotFoundException, IOException {
		final File[] files = TestCaseFinder.getTestCases(type.toString().toLowerCase() + "-test-*.json");

		for (final File testFile : files) {
			final String recipeFile = testFile.getPath().replace("-test-", "-recipe-");
			final Gson gson = GsonParser.getGsonParser();
			final AlphaTestData data = gson.fromJson(new FileReader(testFile), AlphaTestData.class);

			final AlphaActorTestKit testKit = new AlphaActorTestKit(system);
			testKit.test(type, recipeFile, data);
		}
	}
	
	@Test
	public void trimmerNodeTest() throws JsonSyntaxException, JsonIOException, IOException {	
		alphaNodeTest(ReteNodeType.TRIMMER);
	}

	@Test
	public void equalityNodeTest() throws JsonSyntaxException, JsonIOException, IOException {
		alphaNodeTest(ReteNodeType.EQUALITY);
	}
	
	@Test
	public void inequalityNodeTest() throws JsonSyntaxException, JsonIOException, IOException {
		alphaNodeTest(ReteNodeType.INEQUALITY);
	}

}