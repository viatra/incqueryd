package hu.bme.mit.incqueryd.io;

import hu.bme.mit.incqueryd.rete.dataunits.Tuple;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

public class GraphSonLoader {

	final Map<String, Set<Tuple>> vertexTuplesMap = new HashMap<>();
	final Map<String, Set<Tuple>> edgeTuplesMap = new HashMap<>();

	public GraphSonLoader(final String pathName, final Map<String, Collection<String>> vertexTypesAndProperties,
			final Collection<String> edgeLabels) throws IOException {
		final Multimap<String, Object> vertexTypeVertexIdsMap = ArrayListMultimap.create();
		final Map<Object, Map<String, Object>> vertexIdVertexPropertiesMap = new HashMap<>();
		final Map<String, Multimap<Object, Object>> edgeLabelVertexPairsMap = new HashMap<>();

		// logMessage("Loading...");

		// collect the edges from the Faunus GraphSON file in one run
		GraphSonFormat.indexGraph(pathName, vertexTypesAndProperties, vertexTypeVertexIdsMap,
				vertexIdVertexPropertiesMap, edgeLabels, edgeLabelVertexPairsMap);

		// converting the vertices to tuples
		// e.g. <id, Segment_length>
		for (final String vertexType : vertexTypeVertexIdsMap.keySet()) {
			final Collection<Object> verticesId = vertexTypeVertexIdsMap.get(vertexType);
			final Set<Tuple> tuples = new HashSet<>();

			for (final Object vertexId : verticesId) {
				final List<Object> tupleItems = new LinkedList<>();

				// convert id to long
				tupleItems.add(convertToLongIfPossible(vertexId));

				final Collection<String> propertiesToExtract = vertexTypesAndProperties.get(vertexType);
				for (final String propertyName : propertiesToExtract) {
					final Object propertyValue = vertexIdVertexPropertiesMap.get(vertexId).get(propertyName);

					tupleItems.add(convertToLongIfPossible(propertyValue));
				}

				final Tuple tuple = new Tuple(tupleItems.toArray());
				tuples.add(tuple);
			}

			vertexTuplesMap.put(vertexType, tuples);
		}

		// converting the edges to tuples
		for (final Entry<String, Multimap<Object, Object>> entry : edgeLabelVertexPairsMap.entrySet()) {
			final String edgeLabel = entry.getKey();
			final Multimap<Object, Object> edges = entry.getValue();

			final Set<Tuple> tuples = new HashSet<>();
			edgeTuplesMap.put(edgeLabel, tuples);

			// System.out.println(edgeLabel);

			for (final Object v1 : edges.keySet()) {
				final Collection<Object> v2s = edges.get(v1);

				// logResult(v1 + ": " + v2s);
				for (final Object v2 : v2s) {
					final Tuple tuple = new Tuple(v1, v2);
					tuples.add(tuple);
					// logResult(tuple.toString());
					// System.out.println(tuple.toString() + ", ");
				}
			}

			// System.out.println();
		}
	}

	/**
	 * This method convert any whole number to long. This plays an important role in preventing ClassCastExceptions later.
	 * @param o
	 * @return
	 */
	public Object convertToLongIfPossible(Object o) {
		Object result = null;

		if (o instanceof Long) {
			result = o; // no cast required
		} else if (o instanceof Integer) {
			result = new Long((Integer) o);
		} else if (o instanceof Short) {
			result = new Long((Short) o);
		} else if (o instanceof Byte) {
			result = new Long((Byte) o);
		} else {
			result = o;
		}

		return result;
	}

	public Map<String, Set<Tuple>> getVertexTuplesMap() {
		return vertexTuplesMap;
	}

	public Map<String, Set<Tuple>> getEdgeTuplesMap() {
		return edgeTuplesMap;
	}

}
