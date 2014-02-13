package hu.bme.mit.incqueryd.rete.nodes;

import static org.junit.Assert.assertTrue;
import hu.bme.mit.incqueryd.rete.dataunits.ChangeSet;
import hu.bme.mit.incqueryd.rete.nodes.data.BetaTestData;
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
 * Test cases for the {@link JoinNode} class.
 * 
 * @author szarnyasg
 * 
 */
public class JoinNodeTest {

	@Test
	public void test() throws JsonSyntaxException, JsonIOException, IOException {
		final File[] files = TestCaseFinder.getTestCases("join-test-*.json");

		for (final File testFile : files) {
			System.out.println(testFile);
			
			final String recipeFile = testFile.getPath().replace("join-test-", "beta-recipe-");
			final Gson gson = GsonParser.getGsonParser();
			
			final BetaTestData data = gson.fromJson(new FileReader(testFile), BetaTestData.class);
			final BetaRecipe recipe = (BetaRecipe) (RecipeSerializer.deserialize(recipeFile));
			
			join(data, recipe);
		}
	}

	private void join(final BetaTestData data, final BetaRecipe recipe) {
		final JoinNode joinNode = new JoinNode(recipe);
		final ChangeSet resultChangeSet = Algorithms.join(joinNode, data.getPrimaryChangeSet(),
				data.getSecondaryChangeSet());
		assertTrue(resultChangeSet.equals(data.getExpectedChangeSet()));		
	}

}
