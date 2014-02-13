package hu.bme.mit.incqueryd.rete.nodes;

import static org.junit.Assert.assertEquals;
import hu.bme.mit.incqueryd.rete.dataunits.ChangeSet;
import hu.bme.mit.incqueryd.rete.nodes.data.AlphaTestData;
import hu.bme.mit.incqueryd.test.util.GsonParser;
import hu.bme.mit.incqueryd.test.util.TestCaseFinder;
import hu.bme.mit.incqueryd.util.RecipeSerializer;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.eclipse.incquery.runtime.rete.recipes.InequalityFilterRecipe;
import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

/**
 * Test cases for the {@link InequalityNode} class.
 * 
 * @author szarnyasg
 * 
 */
public class InequalityNodeTest {

	@Test
	public void test() throws JsonSyntaxException, JsonIOException, IOException {
		final File[] files = TestCaseFinder.getTestCases("filter-test-*.json");

		for (final File testFile : files) {
			final String recipeFile = testFile.getPath().replace("-test-", "-recipe-");
			final Gson gson = GsonParser.getGsonParser();

			final AlphaTestData data = gson.fromJson(new FileReader(testFile), AlphaTestData.class);
			final InequalityFilterRecipe recipe = (InequalityFilterRecipe) (RecipeSerializer.deserialize(recipeFile));
			filterInequality(data, recipe);
		}
	}

	public void filterInequality(final AlphaTestData data, final InequalityFilterRecipe recipe) {
		final InequalityNode filterNode = new InequalityNode(recipe);		
		final ChangeSet resultChangeSet = filterNode.update(data.getIncomingChangeSet());

		assertEquals(data.getExpectedChangeSet(), resultChangeSet);
	}

}
