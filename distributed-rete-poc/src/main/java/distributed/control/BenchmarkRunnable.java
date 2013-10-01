package distributed.control;

import java.util.concurrent.CountDownLatch;

import distributed.rete.database.Neo4jClient;

public abstract class BenchmarkRunnable implements Runnable {

	protected Neo4jClient client;
	protected CountDownLatch countDownLatch;

	public BenchmarkRunnable(Neo4jClient client, CountDownLatch countDownLatch) {
		this.client = client;
		this.countDownLatch = countDownLatch;
	}

}
