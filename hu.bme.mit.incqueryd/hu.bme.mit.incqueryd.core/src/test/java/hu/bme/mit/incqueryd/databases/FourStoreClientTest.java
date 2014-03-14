package hu.bme.mit.incqueryd.databases;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.List;

import org.junit.Test;

import com.google.common.collect.Multimap;

public class FourStoreClientTest {

	protected static final String modelPath = "src/test/resources/models/railway-xform-1-no-metamodel.owl";
	
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
		
		final Multimap<Long, Long> edges = client.collectEdges("Route_routeDefinition");		
		assertEquals(19, edges.keySet().size());
		assertEquals(843, edges.values().size());
		
		final List<Long> routes = client.collectVertices("Route");
		assertEquals(20, routes.size());
		
		// destroy the cluster
		client.destroy(cluster);
	}
	
}
