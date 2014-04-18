package graphloader.performance.benchmark.main;

public class AsyncBulkInsertListener implements Runnable {

	protected long n = 0;

	public boolean isFinished() {
		return n == 0;
	}

	public void insert() {
		n++;
//		System.out.println("++: " + n);
	}

	public void run() {
		n--;
//		System.out.println("--: " + n);
		if (n == 0) {
			System.out.println("notifying");
			synchronized (this) {
				this.notify();
			}
		}
	}

}
