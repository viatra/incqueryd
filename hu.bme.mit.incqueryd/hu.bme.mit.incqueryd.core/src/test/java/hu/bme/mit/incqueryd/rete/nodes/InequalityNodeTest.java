package hu.bme.mit.incqueryd.rete.nodes;

import static org.junit.Assert.assertEquals;
import hu.bme.mit.incqueryd.rete.dataunits.ChangeSet;
import hu.bme.mit.incqueryd.rete.nodes.data.FilterNodeTestData;
import hu.bme.mit.incqueryd.test.util.GsonParser;
import hu.bme.mit.incqueryd.test.util.TestCaseFinder;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import org.eclipse.incquery.runtime.rete.recipes.InequalityFilterRecipe;
import org.eclipse.incquery.runtime.rete.recipes.RecipesFactory;
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
	public void test() throws JsonSyntaxException, JsonIOException, FileNotFoundException {
		final File[] files = TestCaseFinder.getTestCases("filternode-*.json");

		for (final File file : files) {
			System.out.println(file);
			final Gson gson = GsonParser.getGsonParser();
			final FilterNodeTestData data = gson.fromJson(new FileReader(file), FilterNodeTestData.class);
			filterInequality(data);
		}
	}

	public void filterInequality(final FilterNodeTestData data) {
    	final InequalityFilterRecipe recipe = RecipesFactory.eINSTANCE.createInequalityFilterRecipe();
		
    	// set the subject
		recipe.setSubject(data.getTupleMask().getMask().get(0));		
		// remove the head
		data.getTupleMask().getMask().remove(0);
		// get tha tail as inequals
		recipe.getInequals().addAll(data.getTupleMask().getMask());
    	
		final InequalityNode filterNode = new InequalityNode(recipe);		
		final ChangeSet resultChangeSet = filterNode.update(data.getChangeSet());

		assertEquals(data.getInequalityExpectedResults(), resultChangeSet);
	}

}
