package hu.bme.mit.incqueryd.rete.actors;

import hu.bme.mit.incqueryd.rete.nodes.data.AlphaTestData;
import hu.bme.mit.incqueryd.test.util.GsonParser;
import hu.bme.mit.incqueryd.test.util.TestCaseFinder;
import hu.bme.mit.incqueryd.util.RecipeSerializer;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.eclipse.incquery.runtime.rete.recipes.EqualityFilterRecipe;
import org.eclipse.incquery.runtime.rete.recipes.TrimmerRecipe;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import akka.actor.ActorSystem;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

/**
 * Test cases for the {@link TrimmerActor} class.
 * 
 * @author szarnyasg
 * 
 */
public class TrimmerActorTest {

	static ActorSystem system;

	@BeforeClass
	public static void setup() {
		system = ActorSystem.create();
	}

	@AfterClass
	public static void teardown() {
		system.shutdown();
	}

	@Test
	public void trimmerNodeTest() throws JsonSyntaxException, JsonIOException, IOException {
		final File[] files = TestCaseFinder.getTestCases("trimmer-test-*.json");

		for (final File testFile : files) {
			final String recipeFile = testFile.getPath().replace("-test-", "-recipe-");
			final Gson gson = GsonParser.getGsonParser();
			
			final AlphaTestData data = gson.fromJson(new FileReader(testFile), AlphaTestData.class);
			final TrimmerRecipe recipe = (TrimmerRecipe) (RecipeSerializer.deserialize(recipeFile));

			final AlphaActorTestKit testKit = new AlphaActorTestKit(system, recipe);
			testKit.compute(data);
		}
	}
	
	@Test
	public void equalityNodeTest() throws JsonSyntaxException, JsonIOException, IOException {
		final File[] files = TestCaseFinder.getTestCases("equality-test-*.json");

		for (final File testFile : files) {
			final String recipeFile = testFile.getPath().replace("-test-", "-recipe-");
			final Gson gson = GsonParser.getGsonParser();
			
			final AlphaTestData data = gson.fromJson(new FileReader(testFile), AlphaTestData.class);
			final EqualityFilterRecipe recipe = (EqualityFilterRecipe) (RecipeSerializer.deserialize(recipeFile));

			final AlphaActorTestKit testKit = new AlphaActorTestKit(system, recipe);
			testKit.compute(data);
		}
	}


}