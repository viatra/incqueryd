package hu.bme.mit.incqueryd.rete.nodes;

import static org.junit.Assert.assertTrue;
import hu.bme.mit.incqueryd.rete.dataunits.ChangeSet;
import hu.bme.mit.incqueryd.rete.nodes.data.FilterNodeTestData;
import hu.bme.mit.incqueryd.test.util.GsonParser;
import hu.bme.mit.incqueryd.test.util.TestCaseFinder;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import org.eclipse.incquery.runtime.rete.recipes.EqualityFilterRecipe;
import org.eclipse.incquery.runtime.rete.recipes.RecipesFactory;
import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

/**
 * Test cases for the {@link EqualityNode} class.
 * 
 * @author szarnyasg
 * 
 */
public class EqualityNodeTest {

	@Test
	public void test() throws JsonSyntaxException, JsonIOException, FileNotFoundException {
		final File[] files = TestCaseFinder.getTestCases("filternode-*.json");

		for (final File file : files) {
			System.out.println(file);
			final Gson gson = GsonParser.getGsonParser();
			final FilterNodeTestData data = gson.fromJson(new FileReader(file), FilterNodeTestData.class);
			
			filterEquality(data);
		}
	}

	public void filterEquality(final FilterNodeTestData data) {
    	final EqualityFilterRecipe recipe = RecipesFactory.eINSTANCE.createEqualityFilterRecipe();
    	recipe.getIndices().addAll(data.getTupleMask().getMask());
    	
		final EqualityNode filterNode = new EqualityNode(recipe);
		final ChangeSet resultChangeSet = filterNode.update(data.getChangeSet());

		assertTrue(resultChangeSet.equals(data.getEqualityExpectedResults()));
	}

}
