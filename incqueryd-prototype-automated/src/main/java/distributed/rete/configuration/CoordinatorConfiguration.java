package distributed.rete.configuration;

import distributed.rete.database.DatabaseClientType;

public class CoordinatorConfiguration extends IncQueryDConfiguration {

	private static final long serialVersionUID = 1L;

	public CoordinatorConfiguration(final DatabaseClientType databaseClientType, final String filename) {
		this.databaseClientType = databaseClientType;
		this.filename = filename;
	}

	public DatabaseClientType databaseClientType;
	public String filename;
	
}
