package distributed.rete.database;

public class AsyncBulkInsertListener implements Runnable {

	protected long n = 0;

	public boolean isFinished() {
		return n == 0;
	}

	public void insert() {
		synchronized (this) {
			n++;
		}
	}

	public void run() {
		synchronized (this) {
			n--;
			if (n == 0) {
				this.notify();
			}
		}
	}

}
