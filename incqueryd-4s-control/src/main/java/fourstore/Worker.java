package fourstore;

import hu.bme.mit.train.util.BenchmarkResult;

import java.io.IOException;

public class Worker {

	protected final FourStoreClient client;
	protected final int runCount;

	public Worker(final String serverUrl, final String filename, final int runCount) {
		client = new FourStoreClient(serverUrl, filename);
		this.runCount = runCount;
	}

	public void work() throws IOException, InterruptedException {

		BenchmarkResult.INSTANCE.startStopper();
		BenchmarkResult.INSTANCE.setId("TestCaseRouteSensor_4store-control");

		// load
		System.out.println("Load");
		client.load();
		BenchmarkResult.INSTANCE.setReadTime();
		BenchmarkResult.INSTANCE.startStopper();
		
		// check 1
		System.out.println();
		System.out.println("Check 0");
		final long count1 = client.check();
		BenchmarkResult.INSTANCE.addCheckTime();
		BenchmarkResult.INSTANCE.addInvalid(count1);
		
		for (int i = 1; i < runCount; i++) {
			// edit
			System.out.println();
			System.out.println("Edit");
			client.edit();
			BenchmarkResult.INSTANCE.addEditTime();
			BenchmarkResult.INSTANCE.startStopper();
	
			// check 2
			System.out.println();
			System.out.println("Check " + (i+1));
			final long count2 = client.check();
			BenchmarkResult.INSTANCE.addCheckTime();
			BenchmarkResult.INSTANCE.addInvalid(count2);
		}
		
		System.out.println(BenchmarkResult.INSTANCE.toString());
		
	}

}
