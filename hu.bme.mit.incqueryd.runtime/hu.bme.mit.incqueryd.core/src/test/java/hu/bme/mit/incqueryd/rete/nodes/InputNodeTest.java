package hu.bme.mit.incqueryd.rete.nodes;

import static org.junit.Assert.assertEquals;
import hu.bme.mit.bigmodel.fourstore.FourStoreClient;
import hu.bme.mit.incqueryd.rete.dataunits.ChangeSet;

import java.io.IOException;
import java.util.Collections;

import org.eclipse.incquery.runtime.rete.recipes.BinaryInputRecipe;
import org.eclipse.incquery.runtime.rete.recipes.RecipesFactory;
import org.eclipse.incquery.runtime.rete.recipes.UnaryInputRecipe;
import org.junit.Test;

public class InputNodeTest {

	protected static final String FOURSTORE_CLUSTERNAME = "trainbenchmark_cluster";
	protected static final String ONTOLOGYIRI = "http://www.semanticweb.org/ontologies/2011/1/TrainRequirementOntology.owl";
	protected static final String modelPath = "src/test/resources/models/railway-xform-1.ttl";

	@Test
	public void testEdge() throws IOException {
		// start the cluster and load the model
		final FourStoreClient client = new FourStoreClient(FOURSTORE_CLUSTERNAME, ONTOLOGYIRI);
		client.start(false);
		client.load(modelPath);

		final BinaryInputRecipe recipe = RecipesFactory.eINSTANCE.createBinaryInputRecipe();
		recipe.setTypeName(ONTOLOGYIRI + "#Route_routeDefinition");
		recipe.setTraceInfo(InputNode.EDGE_DISCRIMINATOR);

		final InputNode inputNode = new InputNode(recipe, Collections.<String> emptyList(), FOURSTORE_CLUSTERNAME);
		final ChangeSet changeSet = inputNode.initialize();
		assertEquals(843, changeSet.getTuples().size());

		// destroy the cluster
		client.destroy(false);
	}

	@Test
	public void testVertex() throws IOException {
		// start the cluster and load the model
		final FourStoreClient client = new FourStoreClient("trainbenchmark_cluster", ONTOLOGYIRI);
		client.start(false);
		client.load(modelPath);

		final UnaryInputRecipe recipe = RecipesFactory.eINSTANCE.createUnaryInputRecipe();
		recipe.setTypeName(ONTOLOGYIRI + "#Route");

		final InputNode inputNode = new InputNode(recipe, Collections.<String> emptyList(), FOURSTORE_CLUSTERNAME);
		final ChangeSet changeSet = inputNode.initialize();
		assertEquals(20, changeSet.getTuples().size());

		// destroy the cluster
		client.destroy(false);
	}

	@Test
	public void testVertexWithProperties() throws IOException {
		// start the cluster and load the model
		final FourStoreClient client = new FourStoreClient("trainbenchmark_cluster", ONTOLOGYIRI);
		client.start(false);
		client.load(modelPath);

		final BinaryInputRecipe recipe = RecipesFactory.eINSTANCE.createBinaryInputRecipe();
		recipe.setTypeName(ONTOLOGYIRI + "#Segment_length");
		recipe.setTraceInfo(InputNode.ATTRIBUTE_DISCRIMINATOR);

		final InputNode inputNode = new InputNode(recipe, Collections.<String> emptyList(), FOURSTORE_CLUSTERNAME);
		final ChangeSet changeSet = inputNode.initialize();
		assertEquals(4835, changeSet.getTuples().size());

		// destroy the cluster
		client.destroy(false);
	}

}
