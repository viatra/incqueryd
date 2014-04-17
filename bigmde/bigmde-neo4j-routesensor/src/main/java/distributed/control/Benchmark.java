package distributed.control;

import hu.bme.mit.train.util.BenchmarkResult;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

import distributed.constants.Constants;
import distributed.rete.database.Neo4jClient;

public enum Benchmark {
	INSTANCE;

	long current;
	long prev = System.nanoTime();
	int serverCount = Constants.INSTANCE.VMs.size();

	public void work() throws InterruptedException {
		BenchmarkResult.INSTANCE.setId("TestCaseRouteSensor_Control");
		BenchmarkResult.INSTANCE.startStopper();

		List<Neo4jClient> clients = new ArrayList<>();
		for (int i = 0; i < serverCount; i++) {
			String serverUrl = Constants.INSTANCE.VMs.get(i);
			Neo4jClient client = new Neo4jClient(serverUrl);
			clients.add(client);
		}

		read(clients);
		BenchmarkResult.INSTANCE.setReadTime();

		BenchmarkResult.INSTANCE.startStopper();
		int check1 = check(clients);
		BenchmarkResult.INSTANCE.addCheckTime();
		BenchmarkResult.INSTANCE.addInvalid(check1);
		
		for (int i = 0; i < 50; i++) {			
			BenchmarkResult.INSTANCE.startStopper();
			edit(clients);
			BenchmarkResult.INSTANCE.addEditTime();

			BenchmarkResult.INSTANCE.startStopper();
			int check2 = check(clients);
			BenchmarkResult.INSTANCE.addCheckTime();
			BenchmarkResult.INSTANCE.addInvalid(check2);			
		}
		
		System.out.println(BenchmarkResult.INSTANCE.toString());
	}

	private void edit(List<Neo4jClient> clients) throws InterruptedException {
		CountDownLatch countDownLatch;
		countDownLatch = new CountDownLatch(serverCount);
		for (Neo4jClient client : clients) {
			Thread thread = new Thread(new Edit(client, countDownLatch));
			thread.start();
		}
		countDownLatch.await();
	}

	private int check(List<Neo4jClient> clients) throws InterruptedException {
		CountDownLatch countDownLatch;
		countDownLatch = new CountDownLatch(serverCount);
		Collection<Map<String, Object>> checkResult = new ArrayList<>();
		Collection<Check> checks = new ArrayList<>();
		for (Neo4jClient client : clients) {
			Check check = new Check(client, countDownLatch);
			checks.add(check);
			Thread thread = new Thread(check);
			thread.start();
		}
		countDownLatch.await();
		for (Check check : checks) {
			checkResult.addAll(check.getResult());
		}
		System.out.println("result: " + checkResult.size());
		
		return checkResult.size();
	}

	private void read(List<Neo4jClient> clients) throws InterruptedException {
		CountDownLatch countDownLatch = new CountDownLatch(serverCount);
		for (int i = 0; i < serverCount; i++) {
			Neo4jClient client = clients.get(i);
			String graphMlPath = Constants.INSTANCE.GRAPHMLs.get(i);

			Thread thread = new Thread(new Read(client, graphMlPath, countDownLatch));
			thread.start();
		}
		countDownLatch.await();
	}

}
