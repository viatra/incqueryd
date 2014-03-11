package hu.bme.mit.incqueryd.rete.nodes;

import static org.junit.Assert.assertEquals;
import hu.bme.mit.incqueryd.databases.CoordinatorFourStoreClient;

import java.io.IOException;

import org.eclipse.incquery.runtime.rete.recipes.RecipesFactory;
import org.eclipse.incquery.runtime.rete.recipes.UniquenessEnforcerRecipe;
import org.junit.Test;

public class InputNodeTest {

	protected static final String modelPath = "src/test/resources/models/railway-xform-1.owl";
	
	@Test
	public void testFourStoreSingle() throws IOException {		
		testFourStore(false);
	}

	@Test
	public void testFourStoreCluster() throws IOException {		
		testFourStore(true);
	}

	private void testFourStore(final boolean cluster) throws IOException {
		// start the cluster and load the model 
		final CoordinatorFourStoreClient client = new CoordinatorFourStoreClient("src/main/resources/scripts");
		client.start(cluster);
		client.load(modelPath);
			
		final UniquenessEnforcerRecipe recipe = RecipesFactory.eINSTANCE.createUniquenessEnforcerRecipe();
		recipe.setTraceInfo("UniquenessEnforcerNode : Route_routeDefinition :  [0]");
		
		final InputNode node = (InputNode) ReteNodeFactory.createNode(recipe);
		node.initialize();
		assertEquals(843, node.getEdges().size());
		
		// destroy the cluster
		client.destroy(cluster);

	}
	
}
