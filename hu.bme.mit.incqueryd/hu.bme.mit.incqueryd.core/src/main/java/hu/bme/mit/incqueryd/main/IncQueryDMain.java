package hu.bme.mit.incqueryd.main;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.PosixParser;

/**
 * 
 * @author szarnyasg
 * 
 */
public class IncQueryDMain {

	public static void main(final String[] args) throws Exception {
		final Options options = new Options();
		options.addOption("cluster", false, "run IncQuery-D in a cluster");

		final CommandLineParser parser = new PosixParser();
		final CommandLine cmd = parser.parse(options, args);
		
		final boolean cluster = cmd.hasOption("cluster");		
		final IncQueryDWorker worker = new IncQueryDWorker(cluster);
		worker.work();
	}

}
