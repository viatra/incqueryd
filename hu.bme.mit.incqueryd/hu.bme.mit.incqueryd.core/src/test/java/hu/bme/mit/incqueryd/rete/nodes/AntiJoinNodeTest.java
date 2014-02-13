package hu.bme.mit.incqueryd.rete.nodes;

import static org.junit.Assert.assertTrue;
import hu.bme.mit.incqueryd.rete.dataunits.ChangeSet;
import hu.bme.mit.incqueryd.rete.nodes.data.BetaNodeTestData;
import hu.bme.mit.incqueryd.test.util.GsonParser;
import hu.bme.mit.incqueryd.test.util.TestCaseFinder;
import hu.bme.mit.incqueryd.util.RecipeSerializer;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.eclipse.incquery.runtime.rete.recipes.BetaRecipe;
import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

/**
 * Test cases for the {@link AntiJoinNode} class.
 * 
 * @author szarnyasg
 * 
 */
public class AntiJoinNodeTest {

	@Test
	public void test() throws JsonSyntaxException, JsonIOException, IOException {
		final File[] files = TestCaseFinder.getTestCases("antijoin-test-*.json");

		for (final File testFile : files) {
			System.out.println(testFile);
			
			final String recipeFile = testFile.getPath().replace("antijoin-test-", "beta-recipe-");
			final Gson gson = GsonParser.getGsonParser();
			
			final BetaNodeTestData data = gson.fromJson(new FileReader(testFile), BetaNodeTestData.class);
			final BetaRecipe recipe = (BetaRecipe) (RecipeSerializer.deserialize(recipeFile));
			
			antijoin(data, recipe);
		}
	}

	private void antijoin(final BetaNodeTestData data, final BetaRecipe recipe) {
		final AntiJoinNode joinNode = new AntiJoinNode(recipe);
		final ChangeSet resultChangeSet = Algorithms.join(joinNode, data.getPrimaryChangeSet(),
				data.getSecondaryChangeSet());
		assertTrue(resultChangeSet.equals(data.getExpectedChangeSet()));		
	}

}
