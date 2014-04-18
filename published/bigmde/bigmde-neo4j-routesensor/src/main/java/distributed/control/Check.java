package distributed.control;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

import distributed.benchmark.RouteSensorBenchmark;
import distributed.rete.database.Neo4jClient;

public class Check extends BenchmarkRunnable {

	protected Collection<Map<String, Object>> result;

	public Check(Neo4jClient client, CountDownLatch countDownLatch) {
		super(client, countDownLatch);
	}

	@Override
	public void run() {
		RouteSensorBenchmark rsb = new RouteSensorBenchmark(client);
		result = rsb.query();
		countDownLatch.countDown();
	}

	public Collection<Map<String, Object>> getResult() {
		return result;
	}

}
