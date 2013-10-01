package distributed.control;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

import com.google.common.collect.Multimap;

import distributed.rete.database.Neo4jClient;
import distributed.rete.datastructure.Tuple;
import distributed.rete.datastructure.TupleImpl;

public class Delete extends BenchmarkRunnable {

	private Multimap<Long, Long> routeAndSensorIds;
	private List<Long> routesToModify;
	private Collection<Tuple> negTuples;

	public Delete(Neo4jClient client, CountDownLatch countDownLatch, Multimap<Long, Long> routeAndSensorIds, List<Long> routesToModify, Collection<Tuple> negTuples) {
		super(client, countDownLatch);
		this.routeAndSensorIds = routeAndSensorIds; 
		this.routesToModify = routesToModify; 
		this.negTuples = negTuples;
	}

	@Override
	public void run() {
		Map<Long, Long> deleteCandidates = new HashMap<>();
		for (Map.Entry<Long, Long> row : routeAndSensorIds.entries()) {
			Long routeId = row.getKey();
			Long sensorId = row.getValue();

			// warning: be very careful, the < 2^32 numbers are ints and 2^32 <=... < 2^64 numbers are longs
			if (routesToModify.contains(routeId)) {
				// removing the Route from the itemsToModify list
				routesToModify.remove(routeId);
				deleteCandidates.put(routeId, sensorId);

				// creating a tuple from the result row
				Tuple tuple = new TupleImpl(routeId, sensorId);
				// adding the tuple to the negative update's tuples
				negTuples.add(tuple);					
			}
		}
		
		
		for (Map.Entry<Long, Long> deleteCandidate : deleteCandidates.entrySet()) {
			Long routeId = deleteCandidate.getKey();
			Long sensorId = deleteCandidate.getValue();			
			client.deleteRouteRouteDefinitionEdge(routeId, sensorId);
		}
		countDownLatch.countDown();
	}

}
