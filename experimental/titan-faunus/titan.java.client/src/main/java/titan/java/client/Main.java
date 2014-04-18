package titan.java.client;

import javax.script.ScriptException;

public class Main {

	public static void main(String[] args) throws ScriptException {
		if (args.length < 1) {
			System.out.println("Usage: client <vertices|vertexpairs> [HOST]");
			return;
		}

		String host = "localhost";
		if (args.length >= 2) {
			host = args[1];
		}
		
		TitanQueries titanQueries = new TitanQueries(host);
		
		switch (args[0]) {
		case "vertices":
			titanQueries.queryVertex();
			break;
		case "vertexpairs":
			titanQueries.queryVertexPair();
			break;
		default:
			System.out.println("Invalid parameter.");
			break;
		}

	}

}