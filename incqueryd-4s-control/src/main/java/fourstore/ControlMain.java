package fourstore;

import java.io.IOException;

public class ControlMain {

	public static void main(final String[] args) throws IOException, InterruptedException {
		final String filename = args[0];
		final int runCount = Integer.parseInt(args[1]);
		final String serverUrl = "127.0.0.1";
		
		final Worker worker = new Worker(serverUrl, filename, runCount);
		worker.work();
	}
}
