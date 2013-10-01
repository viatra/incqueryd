package distributed.control;

import java.util.concurrent.CountDownLatch;

import distributed.rete.database.Neo4jClient;

public class Read extends BenchmarkRunnable {

	private String graphMlPath;

	public Read(Neo4jClient client, String graphMlPath, CountDownLatch countDownLatch) {
		super(client, countDownLatch);
		this.graphMlPath = graphMlPath;
	}

	@Override
	public void run() {
		client.load(graphMlPath);
		countDownLatch.countDown();		
	}

}
