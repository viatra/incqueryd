package hu.bme.mit.incqueryd.main;

import hu.bme.mit.incqueryd.io.GraphSonFormat;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Multimap;

/**
 * 
 * @author szarnyasg
 *
 */
public class Main {

	public static void main(final String[] args) throws IOException {
		System.out.println("IncQuery-D main");
		System.out.println("===============");

		final String pathName = "/home/szarnyasg/hdd/models/faunus-graphson/testBig_User_1.faunus-graphson";

		final Map<String, Collection<String>> vertexTypesAndProperties = new HashMap<>();
		vertexTypesAndProperties.put("Segment", ImmutableList.<String>of());
		
		final Collection<String> edgeLabels = ImmutableList.of("TrackElement_sensor");

		// for vertices
		// "type" --> "vertex ids"
		final Multimap<String, Object> vertexTypeVertexIdsMap = ArrayListMultimap.create();
		// "vertex id" --> "vertex properties"
		final Map<Object, Map<String, Object>> vertexIdVertexPropertiesMap = new HashMap<>();

		// for edges
		// "label" --> "vertex pairs, e.g. [[1]->[2, 3], [4]->[5, 6, 7], ...]"
		final Map<String, Multimap<Object, Object>> edgeLabelVertexPairsMap = new HashMap<>();

		GraphSonFormat.indexGraph(pathName, vertexTypesAndProperties, vertexTypeVertexIdsMap, vertexIdVertexPropertiesMap, edgeLabels, edgeLabelVertexPairsMap);

		System.out.println(vertexTypeVertexIdsMap);
		System.out.println(vertexIdVertexPropertiesMap);
		System.out.println(edgeLabelVertexPairsMap);

		
	}

}
