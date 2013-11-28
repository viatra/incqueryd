package hu.bme.mit.incqueryd.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import com.thinkaurelius.faunus.FaunusVertex;
import com.thinkaurelius.faunus.formats.graphson.FaunusGraphSONUtility;
import com.tinkerpop.blueprints.Direction;
import com.tinkerpop.blueprints.Edge;
import com.tinkerpop.blueprints.Vertex;

public class GraphSonFormat {

	public static Multimap<Object, Object> collectEdges(final String pathName, final String edgeLabel) throws IOException {
		// Titan (and the property graph domain) uses uppercase edge labels
		final String titanEdgeLabel = edgeLabel.toUpperCase();
		final Multimap<Object, Object> vertexPairs = ArrayListMultimap.create();

		final BufferedReader br = new BufferedReader(new FileReader(pathName));

		// process each line of the GraphSON file
		String line = br.readLine();
		while (line != null) {
			processLine(line, titanEdgeLabel, vertexPairs);
			line = br.readLine();
		}

		br.close();
		
		return vertexPairs;
	}

	protected static void processLine(final String line, final String edgeLabel, final Multimap<Object, Object> vertexPairs) throws IOException {
		final FaunusVertex v1 = FaunusGraphSONUtility.fromJSON(line);
		final Long v1Id = (Long) v1.getId();

		final Iterable<Edge> edges = v1.getEdges(Direction.OUT, edgeLabel);
		for (final Edge edge : edges) {
			final Vertex v2 = edge.getVertex(Direction.IN);
			final Long v2Id = (Long) v2.getId();
			vertexPairs.put(v1Id, v2Id);
		}
	}
}
