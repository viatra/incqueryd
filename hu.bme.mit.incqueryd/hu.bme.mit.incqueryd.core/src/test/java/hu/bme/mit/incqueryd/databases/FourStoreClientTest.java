package hu.bme.mit.incqueryd.databases;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import org.junit.Test;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

public class FourStoreClientTest {

	protected static final String modelPath = "src/test/resources/models/railway-xform-1-no-metamodel.owl";
	protected CoordinatorFourStoreClient client;

	public void setup(final boolean cluster) throws IOException {
		// arrange
		// start the cluster and load the model
		client = new CoordinatorFourStoreClient("src/main/resources/scripts");
		client.start(cluster);
		client.load(modelPath);
	}

	public void teardown(final boolean cluster) throws IOException {
		// destroy the cluster
		client.destroy(cluster);
	}

	@Test
	public void testEdgesSingle() throws IOException {
		testEdges(false);
	}

	@Test
	public void testVerticesSingle() throws IOException {
		testVertices(false);
	}

	private void testEdges(final boolean cluster) throws IOException {
		setup(cluster);

		final String ROUTE_ROUTEDEFINITION = "Route_routeDefinition";
		final Multimap<Long, Long> edges0 = client.collectEdges(ROUTE_ROUTEDEFINITION);
		assertEquals(19, edges0.keySet().size());
		assertEquals(843, edges0.values().size());

		// act
		// delete 0 edges
		final Multimap<Long, Long> edgesToDelete1 = ArrayListMultimap.create();
		client.deleteEdges(edgesToDelete1, ROUTE_ROUTEDEFINITION);
		// assert
		final Multimap<Long, Long> edges1 = client.collectEdges(ROUTE_ROUTEDEFINITION);
		assertEquals(19, edges1.keySet().size());
		assertEquals(843, edges1.values().size());

		// act
		// delete 1 edge
		final Multimap<Long, Long> edgesToDelete2 = ArrayListMultimap.create();
		edgesToDelete2.put(2546L, 2609L);
		client.deleteEdges(edgesToDelete2, ROUTE_ROUTEDEFINITION);
		// assert
		// we expect 843 - 1 = 842 target vertices
		final Multimap<Long, Long> edges2 = client.collectEdges(ROUTE_ROUTEDEFINITION);
		assertEquals(19, edges2.keySet().size());
		assertEquals(842, edges2.values().size());

		// act
		// delete 4 edges
		final Multimap<Long, Long> edgesToDelete3 = ArrayListMultimap.create();
		edgesToDelete3.put(3216L, 3251L);
		edgesToDelete3.put(3216L, 3429L);
		edgesToDelete3.put(3216L, 3337L);
		edgesToDelete3.put(1L, 227L);
		client.deleteEdges(edgesToDelete3, ROUTE_ROUTEDEFINITION);
		// assert
		// we expect 842 - 4 = 838 target vertices
		final Multimap<Long, Long> edges3 = client.collectEdges(ROUTE_ROUTEDEFINITION);
		assertEquals(19, edges3.keySet().size());
		assertEquals(838, edges3.values().size());

		
		
		// act
		// insert 0 edges
		final Multimap<Long, Long> edgesToInsert1 = ArrayListMultimap.create();
		client.insertEdges(edgesToInsert1, ROUTE_ROUTEDEFINITION);
		// assert
		final Multimap<Long, Long> edges4 = client.collectEdges(ROUTE_ROUTEDEFINITION);
		assertEquals(19, edges4.keySet().size());
		assertEquals(838, edges4.values().size());

		// act
		// insert 1 edge
		final Multimap<Long, Long> edgesToInsert2 = ArrayListMultimap.create();
		edgesToInsert2.put(123123123L, 456456456L);
		client.insertEdges(edgesToInsert2, ROUTE_ROUTEDEFINITION);
		// assert
		final Multimap<Long, Long> edges5 = client.collectEdges(ROUTE_ROUTEDEFINITION);
		assertEquals(20, edges5.keySet().size());
		assertEquals(839, edges5.values().size());

		// act
		// insert 3 edge
		final Multimap<Long, Long> edgesToInsert3 = ArrayListMultimap.create();
		edgesToInsert3.put(1231231237L, 4564564567L);
		edgesToInsert3.put(1231231238L, 4564564568L);
		edgesToInsert3.put(1231231239L, 4564564569L);
		client.insertEdges(edgesToInsert3, ROUTE_ROUTEDEFINITION);
		// assert
		final Multimap<Long, Long> edges6 = client.collectEdges(ROUTE_ROUTEDEFINITION);
		assertEquals(23, edges6.keySet().size());
		assertEquals(842, edges6.values().size());

		teardown(cluster);
	}

	private void testVertices(final boolean cluster) throws IOException {
		setup(cluster);

		final String SEGMENT = "Segment";
		final List<Long> vertices0 = client.collectVertices(SEGMENT);
		assertEquals(4835, vertices0.size());

		// act
		final Collection<Long> vertexIdsToDelete1 = new HashSet<>();
		client.deleteVertices(vertexIdsToDelete1);
		// assert
		final List<Long> vertices1 = client.collectVertices(SEGMENT);
		assertEquals(4835, vertices1.size());

		// act
		final Collection<Long> vertexIdsToDelete2 = Arrays.asList(1751L);
		client.deleteVertices(vertexIdsToDelete2);
		// assert
		final List<Long> vertices2 = client.collectVertices(SEGMENT);
		assertEquals(4834, vertices2.size());

		// act
		final Collection<Long> vertexIdsToDelete3 = Arrays.asList(4161L, 3708L, 4870L);
		client.deleteVertices(vertexIdsToDelete3);
		// assert
		final List<Long> vertices3 = client.collectVertices(SEGMENT);
		assertEquals(4831, vertices3.size());

		teardown(cluster);
	}

}
