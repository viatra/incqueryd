package hu.bme.mit.incqueryd.rete.nodes;

import static org.junit.Assert.assertTrue;
import hu.bme.mit.incqueryd.rete.dataunits.ChangeSet;
import hu.bme.mit.incqueryd.rete.nodes.data.TrimmerNodeTestData;
import hu.bme.mit.incqueryd.test.util.GsonParser;
import hu.bme.mit.incqueryd.test.util.TestCaseFinder;
import hu.bme.mit.incqueryd.util.RecipeSerializer;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.eclipse.incquery.runtime.rete.recipes.TrimmerRecipe;
import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

/**
 * Test cases for the {@link TrimmerNode} class.
 * 
 * @author szarnyasg
 * 
 */
public class TrimmerNodeTest {

	@Test
	public void test() throws JsonSyntaxException, JsonIOException, IOException {
		final File[] files = TestCaseFinder.getTestCases("trimmer-test-*.json");

		for (final File testFile : files) {
			final String recipeFile = testFile.getPath().replace("-test-", "-recipe-");
			final Gson gson = GsonParser.getGsonParser();
			
			final TrimmerNodeTestData data = gson.fromJson(new FileReader(testFile), TrimmerNodeTestData.class);
			final TrimmerRecipe recipe = (TrimmerRecipe) (RecipeSerializer.deserialize(recipeFile));
			trim(data, recipe);
		}
	}

	public void trim(final TrimmerNodeTestData data, final TrimmerRecipe recipe) {
		final TrimmerNode trimmerNode = new TrimmerNode(recipe);
		final ChangeSet resultChangeSet = trimmerNode.update(data.getIncomingChangeSet());
		
		assertTrue(resultChangeSet.equals(data.getExpectedChangeSet()));
	}

}