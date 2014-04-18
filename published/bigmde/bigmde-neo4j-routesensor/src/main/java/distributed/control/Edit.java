package distributed.control;

import java.util.Map;
import java.util.concurrent.CountDownLatch;

import distributed.benchmark.RouteSensorBenchmark;
import distributed.rete.database.Neo4jClient;

public class Edit extends BenchmarkRunnable {

	protected Map<Long, Long> editResult;

	public Edit(Neo4jClient client, CountDownLatch countDownLatch) {
		super(client, countDownLatch);
	}

	@Override
	public void run() {
		RouteSensorBenchmark rsb = new RouteSensorBenchmark(client);
		editResult = rsb.edit();
		countDownLatch.countDown();
	}
	
	public Map<Long, Long> getEditResult() {
		return editResult;
	}

}
