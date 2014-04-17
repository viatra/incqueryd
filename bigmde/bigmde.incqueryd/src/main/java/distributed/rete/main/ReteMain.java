package distributed.rete.main;

import java.io.IOException;

import distributed.constants.Constants;

/**
 * Main class for the benchmark test client.
 * 
 * @author szarnyasg
 * 
 */
public class ReteMain {

	public static void main(String[] args) throws IOException, InterruptedException {
		if (args.length < 2) {
			System.out.println("Usage: java -jar <this file's name>.jar [rete|control] modelsize");
			return;
		}
		
		int modelSize = Integer.parseInt(args[1]);
		Constants.INSTANCE.initializeModelSize(modelSize);
				
		switch (args[0]) {
		case "rete":
			distributed.rete.main.Benchmark.INSTANCE.run();
			break;

		case "control":
			distributed.control.Benchmark.INSTANCE.work();
			break;
			
		default:
			break;
		}		
	}

}
