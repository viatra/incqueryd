package hu.bme.mit.incqueryd.stats;

import java.util.Arrays;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.commons.cli.PosixParser;

public class StatsConfiguration {

	private static final String RECIPE = "recipe";
	private static final String STATS = "stats";
	private final Options options = new Options();
	private String recipe;
	private String stats;
	
	public StatsConfiguration(String[] args) throws ParseException {
		if (Arrays.asList(args).contains("-help")) {
			printHelp();
			System.exit(0);
		}

		try {
			processArguments(args);
		} catch (ParseException e) {
			printHelp();
			throw e;
		}
	}
	
	private void processArguments(String[] args) throws ParseException {
		options.addOption("help", false, "displays this text");
		options.addOption(requiredOption(RECIPE, "recipe file (input)"));
		options.addOption(requiredOption(STATS, "stats file (output)"));
		
		final CommandLineParser parser = new PosixParser();
		final CommandLine cmd = parser.parse(options, args);
		recipe = cmd.getOptionValue(RECIPE);
		stats = cmd.getOptionValue(STATS);
	}

	protected static Option requiredOption(String name, String description) {
		Option option = new Option(name, true, description);
		option.setRequired(true);
		return option;
	}

	public void printHelp() {
		HelpFormatter formatter = new HelpFormatter();
		formatter.setWidth(120);

		formatter.printHelp("java -cp \"target/*:target/lib/*\" hu.bme.mit.incqueryd.stats.StatsMain", "options:", options, "", false);
		System.out.println();
	}
	
	public String getRecipe() {
		return recipe;
	}

	public String getStats() {
		return stats;
	}
	
}
