package hu.bme.mit.incqueryd.engine.util;

import java.io.Serializable;

import eu.mondo.driver.file.FileGraphDriverRead;
import eu.mondo.driver.fourstore.FourStoreGraphDriverReadWrite;
import eu.mondo.driver.graph.RDFGraphDriverRead;

public class DatabaseConnection implements Serializable {

	private static final long serialVersionUID = 1L;
	private final String connectionString;
	private final Backend backend;

	public DatabaseConnection(String connectionString, Backend backend) {
		this.connectionString = connectionString;
		this.backend = backend;
	}
	
	public enum Backend {
		FILE,
		FOURSTORE
	}

	public RDFGraphDriverRead getDriver() {
		switch (getBackend()) {
		case FOURSTORE:
			return new FourStoreGraphDriverReadWrite(getConnectionString());
		case FILE:
		default:
			return new FileGraphDriverRead(getConnectionString());
		}
	}

	public Backend getBackend() {
		return backend;
	}

	public String getConnectionString() {
		return connectionString;
	}
	
}
