package hu.bme.mit.incqueryd.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;
import java.util.Map;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import com.thinkaurelius.faunus.FaunusVertex;
import com.thinkaurelius.faunus.formats.graphson.FaunusGraphSONUtility;
import com.tinkerpop.blueprints.Direction;
import com.tinkerpop.blueprints.Edge;
import com.tinkerpop.blueprints.Vertex;

public class GraphSonFormat {

	public static void indexGraph(final String pathName, final Collection<String> vertexTypes, final Multimap<String, Object> vertexTypeVertexIdsMap,
			final Map<Object, Map<String, Object>> vertexIdVertexPropertiesMap, final Collection<String> edgeLabels,
			final Map<String, Multimap<Object, Object>> edgeLabelVertexPairsMap) throws IOException {

		for (final String edgeLabel : edgeLabels) {
			final Multimap<Object, Object> vertexPairs = ArrayListMultimap.create();
			edgeLabelVertexPairsMap.put(edgeLabel, vertexPairs);
		}

		final BufferedReader br = new BufferedReader(new FileReader(pathName));

		// process each line of the GraphSON file
		String line = br.readLine();
		while (line != null) {
			final FaunusVertex v = FaunusGraphSONUtility.fromJSON(line);

			collectAdjacentVertices(v, edgeLabels, edgeLabelVertexPairsMap);
			extractVertexProperties(v, vertexTypes, vertexTypeVertexIdsMap, vertexIdVertexPropertiesMap);

			line = br.readLine();
		}

		br.close();
	}

	protected static void collectAdjacentVertices(final FaunusVertex v1, final Collection<String> edgeLabels,
			final Map<String, Multimap<Object, Object>> edgeLabelVertexPairsMap) throws IOException {
		final Long v1Id = (Long) v1.getId();

		for (final String edgeLabel : edgeLabels) {
			// get the appropriate vertexPairs Multimap
			final Multimap<Object, Object> vertexPairs = edgeLabelVertexPairsMap.get(edgeLabel);

			// Titan (and the property graph domain) uses uppercase edge labels
			final String titanEdgeLabel = edgeLabel.toUpperCase();
			final Iterable<Edge> edges = v1.getEdges(Direction.OUT, titanEdgeLabel);
			for (final Edge edge : edges) {
				final Vertex v2 = edge.getVertex(Direction.IN);
				final Long v2Id = (Long) v2.getId();
				vertexPairs.put(v1Id, v2Id);
			}
		}
	}

	private static void extractVertexProperties(final FaunusVertex v, final Collection<String> vertexTypes, final Multimap<String, Object> vertexTypeVertexIdsMap,
			final Map<Object, Map<String, Object>> vertexIdVertexPropertiesMap) throws IOException {
		final Map<String, Object> vertexProperties = v.getProperties();
		final String vertexType = (String) vertexProperties.get("type");
		
		// if we are looking for this vertex type, add it to the maps
		if (vertexTypes.contains(vertexType)) {
			final Long id = (Long) v.getId();
			vertexTypeVertexIdsMap.put(vertexType, id);
			vertexIdVertexPropertiesMap.put(id, vertexProperties);
		}
	}
}
