package distributed.rete.main;

import java.io.IOException;

import distributed.rete.database.DatabaseClientType;

/**
 * Main class for the benchmark test client.
 * 
 * @author szarnyasg
 * 
 */
public class ReteMain {

	public static void main(String[] args) throws IOException, InterruptedException {
		if (args.length < 3) {
			printUsage();
			return;
		}

		// processing argument 0
		DatabaseClientType type;
		switch (args[0]) {
		case "4store":
			type = DatabaseClientType.FOURSTORE;
			break;
		case "Titan":
			type = DatabaseClientType.TITANFAUNUS;
			break;
		default:
			System.out.println("Invalid databaseClientType argument.");
			printUsage();
			return;
		}

		// processing argument 1
		final String filename = args[1];

		// processing argument 2
		boolean loadDatabase = true;
		switch (args[2]) {
		case "load":
			loadDatabase = true;
			break;
		case "dontload":
			loadDatabase = false;
			break;
		default:
			System.out.println("Invalid loadDatabase argument.");
			printUsage();
			return;
		}

		Benchmark benchmark = new Benchmark(type, filename, loadDatabase);
		benchmark.run();
	}

	private static void printUsage() {
		System.out.println("Usage: java -jar <this file's name>.jar databaseClientType filename loadDatabase");
		System.out.println("databaseClientType = [ 4store | Titan ]");
		System.out.println("loadDatabase = [ load | dontload ]");
	}

}
