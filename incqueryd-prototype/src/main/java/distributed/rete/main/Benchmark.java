package distributed.rete.main;

import hu.bme.mit.train.util.BenchmarkResult;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

import distributed.rete.actors.controllers.Coordinator;
import distributed.rete.configuration.CoordinatorConfiguration;
import distributed.rete.database.DatabaseClient;
import distributed.rete.database.DatabaseClientFactory;
import distributed.rete.database.DatabaseClientType;

/**
 * Main benchmark class.
 * 
 * @author szarnyasg
 * 
 */
public class Benchmark {

	protected final DatabaseClientType databaseClientType;
	protected final String filename;
	protected final String databaseServerAddress = "localhost";
	protected final boolean loadDatabase;
	protected ActorSystem system;

	public Benchmark(final DatabaseClientType type, final String filename, final boolean loadDatabase) {
		this.databaseClientType = type;
		this.filename = filename;
		this.loadDatabase = loadDatabase;
	}

	public void run() {
		BenchmarkResult.INSTANCE.startStopper();
		BenchmarkResult.INSTANCE.setId("TestCaseRouteSensor_Rete");

		// reset the database
		if (loadDatabase) {
			loadDatabase();
		}

		final Config remoteCreationConfig = ConfigFactory.load().getConfig("RemoteDeployment");
		system = ActorSystem.create("ReteNet", remoteCreationConfig);		
		
		// instantiating the Coordinator actor and let it do the work
		final ActorRef coordinator = system.actorOf(new Props(Coordinator.class), "Coordinator");

		final CoordinatorConfiguration conf = new CoordinatorConfiguration(databaseClientType, filename);
		coordinator.tell(conf, null);

		BenchmarkResult.INSTANCE.setReadTime();
		BenchmarkResult.INSTANCE.startStopper();
	}

	protected void loadDatabase() {
		System.out.println("Connecting to server: " + databaseServerAddress + ", loading: " + filename);

		final DatabaseClient client = DatabaseClientFactory.createDatabaseClient(databaseClientType, databaseServerAddress, filename);
		client.load();

		System.out.println("Databased loaded.");
	}


}
