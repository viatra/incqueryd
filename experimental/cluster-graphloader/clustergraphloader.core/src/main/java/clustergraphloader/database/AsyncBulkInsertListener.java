package clustergraphloader.database;

import java.util.concurrent.CountDownLatch;

/**
 * Class for listening asynchronous insertions. Somewhat similar to
 * {@link CountDownLatch}, but more like a "CountUpDownLatch".
 * 
 * @author szarnyasg
 * 
 */
public class AsyncBulkInsertListener implements Runnable {

	protected long n = 0;

	public boolean isFinished() {
		return n == 0;
	}

	public void insert() {
		synchronized (this) {
			// System.out.println("++");
			n++;
		}
	}

	public void run() {
		synchronized (this) {
			// System.out.println("--");
			n--;
			if (n == 0) {
				this.notify();
			}
		}
	}

}
