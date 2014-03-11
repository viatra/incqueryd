package hu.bme.mit.incqueryd.databases;

import hu.bme.mit.trainbenchmark.benchmark.util.UnixUtils;

import java.io.IOException;

public class CoordinatorFourStoreClient extends FourStoreClient {

	protected final String scriptDirectory;

	public CoordinatorFourStoreClient(final String scriptDirectory) {
		super();
		this.scriptDirectory = scriptDirectory;
	}
	
	public void start(final boolean cluster) throws IOException {
		final String command = scriptDirectory + "/4s-start-" + (cluster ? "cluster" : "single")  + ".sh";
		UnixUtils.run(command, showCommandOutput);
	}
		
	public void destroy(final boolean cluster) throws IOException {
		final String command = scriptDirectory + "/4s-destroy-" + (cluster ? "cluster" : "single") + ".sh";
		UnixUtils.run(command, showCommandOutput);
	}


}
