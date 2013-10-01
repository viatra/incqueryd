package distributed.benchmark;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import distributed.rete.database.Neo4jClient;

public class RouteSensorBenchmark {

	protected Neo4jClient client;

	public final String query = "START " +
			" route=node:node_auto_index(type='Route'), " +
			" sensor=node:node_auto_index(type='Sensor') " +
			"MATCH (route)-[:ROUTE_ROUTEDEFINITION]->(sensor) " +
			"RETURN route.idx AS routeId, sensor.idx AS sensorId " +
			"ORDER BY routeId, sensorId";
	public final String[] columns = { "routeId", "sensorId" };
	public final int nElemToModify = 10;

	public RouteSensorBenchmark(Neo4jClient client) {
		this.client = client;
	}

	public Map<Long, Long> edit() {
		long start = System.nanoTime();

		Collection<Map<String, Object>> routeAndSensorIds = client.runCyperQuery(query);
		List<Long> routeIds = extractRouteIdsFromList(routeAndSensorIds);
		
		long deltanano = System.nanoTime() - start;
		long delta = deltanano / 1000000;

		System.out.println(routeIds.size() + " routeId collected in " + delta + " ms");

		// randomly choosing some Routes to modify
		List<Long> routesToModify = new ArrayList<>();

		Random random = new Random(0);
		// choose nElemToModify elements to modify
		for (int i = 0; i < nElemToModify; i++) {
			int rndTargetPosition = random.nextInt(routeIds.size());
			Long routeToModify = routeIds.get(rndTargetPosition);
			routesToModify.add(routeToModify);

			// small modification over the original TrainBenchmark: we always choose nElemToModify different Routes
			routeIds.remove(routeToModify);
		}

		Map<Long, Long> deleteCandidates = new HashMap<>();
		for (Map<String, Object> row : routeAndSensorIds) {
			Long routeId = objectToLong(row.get("routeId"));
			Long sensorId = objectToLong(row.get("sensorId"));

			// warning: be very careful, the < 2^32 numbers are ints and 2^32 <=... < 2^64 numbers are longs
			if (routesToModify.contains(routeId)) {
				// removing the Route from the itemsToModify list
				routesToModify.remove(routeId);
				deleteCandidates.put(routeId, sensorId);
				client.deleteRouteRouteDefinitionEdge(routeId, sensorId);
			}
		}

		return deleteCandidates;
	}

	public List<Long> extractRouteIdsFromList(Collection<Map<String, Object>> result) {
		List<Long> routeIds = new ArrayList<>();
		for (Map<String, Object> row : result) {
			Object idObject = row.get("routeId");

			Long routeId = objectToLong(idObject);
			if (!routeIds.contains(routeId)) {
				routeIds.add(routeId);
			}
		}
		return routeIds;
	}

	public Collection<Map<String, Object>> query() {
		String routeSensorQuery = "START sensor=node:node_auto_index(type='Sensor')\n"
				+ "MATCH sensor-[:TRACKELEMENT_SENSOR]-switch-[:SWITCHPOSITION_SWITCH]-switchPosition-[:ROUTE_SWITCHPOSITION]-route-[r?:ROUTE_ROUTEDEFINITION]-sensor\n"
				+ "WHERE r IS NULL\n" + "RETURN sensor";
		return client.runCyperQuery(routeSensorQuery);
	}

	public static Long objectToLong(Object o) {
		Long l = null;

		if (o instanceof Integer) {
			Integer i = (Integer) o;
			l = new Long(i);
		}

		if (o instanceof Long) {
			l = (Long) o;
		}

		return l;
	}

}
