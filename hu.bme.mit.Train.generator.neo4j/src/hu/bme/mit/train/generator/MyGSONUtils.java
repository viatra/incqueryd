package hu.bme.mit.train.generator;

import static com.tinkerpop.blueprints.Direction.IN;
import static com.tinkerpop.blueprints.Direction.OUT;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.tinkerpop.blueprints.Edge;
import com.tinkerpop.blueprints.Element;
import com.tinkerpop.blueprints.Vertex;
import com.tinkerpop.blueprints.util.io.graphson.GraphSONMode;
import com.tinkerpop.blueprints.util.io.graphson.GraphSONTokens;
import com.tinkerpop.blueprints.util.io.graphson.GraphSONUtility;

public class MyGSONUtils {

	private static final String _OUT_E = "_outE";
	private static final String _IN_E = "_inE";

	private static Set<String> getElementPropertyKeys(final Element element, final boolean edgeIn) {
		final Set<String> elementPropertyKeys = new HashSet<String>(element.getPropertyKeys());
		elementPropertyKeys.add(GraphSONTokens._ID);
		if (element instanceof Edge) {
			if (edgeIn) {
				elementPropertyKeys.add(GraphSONTokens._IN_V);
			} else {
				elementPropertyKeys.add(GraphSONTokens._OUT_V);
			}

			elementPropertyKeys.add(GraphSONTokens._LABEL);
		}

		return elementPropertyKeys;
	}

	public static JSONObject toJSON(Vertex vertex) throws IOException {
		try {
			final JSONObject object = GraphSONUtility.jsonFromElement(vertex, getElementPropertyKeys(vertex, false),
					GraphSONMode.COMPACT);

			// force the ID to long. with blueprints, most implementations will
			// send back a long, but
			// some like TinkerGraph will return a string. the same is done for
			// edges below
			object.put(GraphSONTokens._ID, Long.valueOf(object.remove(GraphSONTokens._ID).toString()));

			// List<Edge> edges = (List<Edge>) vertex.getEdges(OUT);
			Iterable<Edge> edges = vertex.getEdges(OUT);

			// if (!edges.isEmpty()) {
			final JSONArray outEdgesArray = new JSONArray();
			for (final Edge outEdge : edges) {
				final JSONObject edgeObject = GraphSONUtility.jsonFromElement(outEdge,
						getElementPropertyKeys(outEdge, true), GraphSONMode.COMPACT);
				outEdgesArray.put(edgeObject);
			}
			object.put(_OUT_E, outEdgesArray);
			// }

			// edges = (List<Edge>) vertex.getEdges(IN);
			edges = vertex.getEdges(IN);
			// if (!edges.isEmpty()) {
			final JSONArray inEdgesArray = new JSONArray();
			for (final Edge inEdge : edges) {
				final JSONObject edgeObject = GraphSONUtility.jsonFromElement(inEdge,
						getElementPropertyKeys(inEdge, false), GraphSONMode.COMPACT);
				inEdgesArray.put(edgeObject);
			}
			object.put(_IN_E, inEdgesArray);
			// }

			return object;
		} catch (JSONException e) {
			throw new IOException(e);
		}
	}

}
