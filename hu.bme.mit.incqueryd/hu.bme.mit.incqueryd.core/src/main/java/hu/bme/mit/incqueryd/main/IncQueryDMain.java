package hu.bme.mit.incqueryd.main;

import hu.bme.mit.trainbenchmark.benchmark.config.IncQueryDBenchmarkConfig;

/**
 * 
 * @author szarnyasg
 * 
 */
public class IncQueryDMain {

	public static void main(final String[] args) throws Exception {
		final IncQueryDBenchmarkConfig bc = new IncQueryDBenchmarkConfig(args);
				
		final IncQueryDWorker worker = new IncQueryDWorker(bc);
		worker.work();
	}

}
