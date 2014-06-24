package hu.bme.mit.incqueryd.rete.nodes;

import static org.junit.Assert.assertEquals;
import hu.bme.mit.bigmodel.fourstore.CoordinatorFourStoreClient;
import hu.bme.mit.incqueryd.rete.dataunits.ChangeSet;

import java.io.IOException;
import java.util.Collections;

import org.eclipse.incquery.runtime.rete.recipes.BinaryInputRecipe;
import org.eclipse.incquery.runtime.rete.recipes.RecipesFactory;
import org.eclipse.incquery.runtime.rete.recipes.UnaryInputRecipe;
import org.junit.Test;

public class InputNodeTest {

	protected static final String modelPath = "src/test/resources/models/railway-xform-1.ttl";

	@Test
	public void testEdge() throws IOException {
		// start the cluster and load the model
		final CoordinatorFourStoreClient client = new CoordinatorFourStoreClient();
		client.start(false);
		client.load(modelPath);

		final BinaryInputRecipe recipe = RecipesFactory.eINSTANCE.createBinaryInputRecipe();
		recipe.setTypeName("http://www.semanticweb.org/ontologies/2011/1/TrainRequirementOntology.owl#Route_routeDefinition");

		final InputNode inputNode = new InputNode(recipe, Collections.<String> emptyList());
		final ChangeSet changeSet = inputNode.initialize();
		assertEquals(843, changeSet.getTuples().size());

		// destroy the cluster
		client.destroy(false);
	}

	@Test
	public void testVertex() throws IOException {
		// start the cluster and load the model
		final CoordinatorFourStoreClient client = new CoordinatorFourStoreClient();
		client.start(false);
		client.load(modelPath);

		final UnaryInputRecipe recipe = RecipesFactory.eINSTANCE.createUnaryInputRecipe();
		recipe.setTypeName("http://www.semanticweb.org/ontologies/2011/1/TrainRequirementOntology.owl#Route");

		final InputNode inputNode = new InputNode(recipe, Collections.<String> emptyList());
		final ChangeSet changeSet = inputNode.initialize();
		assertEquals(20, changeSet.getTuples().size());

		// destroy the cluster
		client.destroy(false);
	}

	@Test
	public void testVertexWithProperties() throws IOException {
		// start the cluster and load the model
		final CoordinatorFourStoreClient client = new CoordinatorFourStoreClient();
		client.start(false);
		client.load(modelPath);

		final BinaryInputRecipe recipe = RecipesFactory.eINSTANCE.createBinaryInputRecipe();
		recipe.setTypeName("http://www.semanticweb.org/ontologies/2011/1/TrainRequirementOntology.owl#Segment_length");

		final InputNode inputNode = new InputNode(recipe, Collections.<String> emptyList());
		final ChangeSet changeSet = inputNode.initialize();
		assertEquals(4835, changeSet.getTuples().size());

		// destroy the cluster
		client.destroy(false);
	}

}
