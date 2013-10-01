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
		if (args.length < 1) {
			System.out.println("Usage: java -jar <this file's name>.jar modelsize");
			return;
		}
		
		int modelSize = Integer.parseInt(args[0]);
		Constants.INSTANCE.initializeModelSize(modelSize);
		distributed.control.Benchmark.INSTANCE.work();
	}

}
