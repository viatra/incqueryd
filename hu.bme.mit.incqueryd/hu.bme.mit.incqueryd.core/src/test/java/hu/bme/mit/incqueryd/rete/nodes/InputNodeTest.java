package hu.bme.mit.incqueryd.rete.nodes;

import static org.junit.Assert.assertEquals;
import hu.bme.mit.incqueryd.databases.CoordinatorFourStoreClient;
import hu.bme.mit.incqueryd.rete.dataunits.ChangeSet;

import java.io.IOException;

import org.eclipse.incquery.runtime.rete.recipes.RecipesFactory;
import org.eclipse.incquery.runtime.rete.recipes.UniquenessEnforcerRecipe;
import org.junit.Test;

public class InputNodeTest {

	protected static final String modelPath = "src/test/resources/models/railway-xform-1.owl";

	@Test
	public void testEdge() throws IOException {
		// start the cluster and load the model
		final CoordinatorFourStoreClient client = new CoordinatorFourStoreClient("src/main/resources/scripts");
		client.start(false);
		client.load(modelPath);

		final UniquenessEnforcerRecipe recipe = RecipesFactory.eINSTANCE.createUniquenessEnforcerRecipe();
		recipe.setTraceInfo("UniquenessEnforcerNode#edge : Route_routeDefinition : ");

		final InputNode inputNode = (InputNode) ReteNodeFactory.createNode(recipe);
		final ChangeSet changeSet = inputNode.initialize();
		assertEquals(843, changeSet.getTuples().size());

		// destroy the cluster
		client.destroy(false);
	}

	@Test
	public void testVertex() throws IOException {
		// start the cluster and load the model
		final CoordinatorFourStoreClient client = new CoordinatorFourStoreClient("src/main/resources/scripts");
		client.start(false);
		client.load(modelPath);

		final UniquenessEnforcerRecipe recipe = RecipesFactory.eINSTANCE.createUniquenessEnforcerRecipe();
		recipe.setTraceInfo("UniquenessEnforcerNode#vertex : Route :");

		final InputNode inputNode = (InputNode) ReteNodeFactory.createNode(recipe);
		final ChangeSet changeSet = inputNode.initialize();
		assertEquals(20, changeSet.getTuples().size());

		// destroy the cluster
		client.destroy(false);

	}

	@Test
	public void testVertexWithProperties() throws IOException {
		// start the cluster and load the model
		final CoordinatorFourStoreClient client = new CoordinatorFourStoreClient("src/main/resources/scripts");
		client.start(false);
		client.load(modelPath);

		final UniquenessEnforcerRecipe recipe = RecipesFactory.eINSTANCE.createUniquenessEnforcerRecipe();
		recipe.setTraceInfo("UniquenessEnforcerNode#vertex : Segment : [Segment_length]");

		final InputNode inputNode = (InputNode) ReteNodeFactory.createNode(recipe);
		final ChangeSet changeSet = inputNode.initialize();
		assertEquals(4835, changeSet.getTuples().size());

		// destroy the cluster
		client.destroy(false);
	}

}
