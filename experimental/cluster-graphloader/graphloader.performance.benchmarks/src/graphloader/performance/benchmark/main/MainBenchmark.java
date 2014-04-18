package graphloader.performance.benchmark.main;

public class MainBenchmark {
	public static void main(String[] args) throws InterruptedException {
		int n = 10;

		Benchmark benchmark = new Benchmark("127.0.0.1");
		long startTime = System.currentTimeMillis();
//		benchmark.executeSync(n);
		benchmark.executeAsync(n);
//		benchmark.executePrepared(n);
		
		long stopTime2 = System.currentTimeMillis();
		long delta = stopTime2 - startTime;
		System.out.println("Total time: " + delta / 1000 + "s " + delta % 1000 + "ms");

		System.exit(0);
	}
}
