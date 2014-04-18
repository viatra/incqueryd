package gremlin.experiments;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.neo4j.rest.graphdb.entity.RestNode;
import org.neo4j.rest.graphdb.entity.RestRelationship;

public class Main {

	private static final Class<? extends Object> RestNode = null;

	public static void main(String[] args) {

		String serverUrl = "http://localhost:7474/db/data";
		Neo4jClient client = new Neo4jClient(serverUrl);

		System.out.println("Running query:");

		final String query = "t = new Table(); " +
				"g.idx('node_auto_index')[[type:'Route']].as('Route')." +
				"outE('ROUTE_ROUTEDEFINITION').as('RouteDefinition')." +
				"inV.as('Sensor').table(t).iterate(); " +
				"t";
		final Collection<Object> result = client.runGremlinQuery(query);

		System.out.println();

		for (Object object : result) {
			if (object instanceof HashMap<?, ?>) {
				@SuppressWarnings("unchecked")
				HashMap<String, Object> map = (HashMap<String, Object>) object;
				RestNode route = (RestNode) map.get("Route");
				RestNode sensor = (RestNode) map.get("Sensor");
				RestRelationship routeDefinition = (RestRelationship) map.get("RouteDefinition");
				
				System.out.println(route.getId() + " " + routeDefinition.getId() + " " + sensor.getId());				
			}
		}

	}
}
