package hu.bme.mit.incqueryd.rete.nodes;

import static org.junit.Assert.assertEquals;
import hu.bme.mit.incqueryd.rete.dataunits.ChangeSet;
import hu.bme.mit.incqueryd.rete.dataunits.ReteNodeSlot;
import hu.bme.mit.incqueryd.rete.nodes.data.BetaTestData;
import hu.bme.mit.incqueryd.test.util.GsonParser;
import hu.bme.mit.incqueryd.test.util.TestCaseFinder;
import hu.bme.mit.incqueryd.util.RecipeDeserializer;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.eclipse.incquery.runtime.rete.recipes.BetaRecipe;
import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

public abstract class BetaNodeTest {

	protected String filePrefix;

	public BetaNodeTest(final String nodeType) {
		filePrefix = nodeType.toLowerCase();
	}

	@Test
	public void test() throws JsonSyntaxException, JsonIOException, IOException {
		final File[] files = TestCaseFinder.getTestCases(filePrefix + "-test-*.json");

		for (final File testFile : files) {
			// System.out.println(testFile);

			final String recipeFile = testFile.getPath().replace(filePrefix + "-test-", "beta-recipe-");
			final Gson gson = GsonParser.getGsonParser();

			final BetaTestData data = gson.fromJson(new FileReader(testFile), BetaTestData.class);
			final BetaRecipe recipe = (BetaRecipe) (RecipeDeserializer.deserializeFromFile(recipeFile));

			final BetaNode betaNode = createBetaNode(recipe);
			testJoin(data, betaNode);
		}
	}

	protected abstract BetaNode createBetaNode(final BetaRecipe recipe);

	protected void testJoin(final BetaTestData data, final BetaNode betaNode) {
		final ChangeSet expectedFirstChangeSet = data.getExpectedFirstChangeSet();
		final ChangeSet expectedSecondChangeSet = data.getExpectedSecondChangeSet();

		final ChangeSet actualFirstChangeSet = betaNode.update(data.getPrimaryChangeSet(), ReteNodeSlot.PRIMARY);
		// System.out.println("1ndE: " + expectedFirstChangeSet);
		// System.out.println("1ndA: " + actualFirstChangeSet);
		assertEquals(expectedFirstChangeSet, actualFirstChangeSet);

		final ChangeSet actualSecondChangeSet = betaNode.update(data.getSecondaryChangeSet(), ReteNodeSlot.SECONDARY);
		// System.out.println("2ndE: " + expectedSecondChangeSet);
		// System.out.println("2ndA: " + actualSecondChangeSet);
		assertEquals(expectedSecondChangeSet, actualSecondChangeSet);
	}

}
