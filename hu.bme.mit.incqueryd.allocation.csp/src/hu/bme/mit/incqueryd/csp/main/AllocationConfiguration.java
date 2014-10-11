package hu.bme.mit.incqueryd.csp.main;

import java.util.Arrays;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.commons.cli.PosixParser;

public class AllocationConfiguration {

	private static final String ARCHITECTURE = "architecture";
	private static final String INVENTORY = "inventory";
	private static final String RECIPE = "recipe";
	private static final String OBJECTIVEFUNCTION = "objectiveFunction";
	private static final String STATS = "stats";
	
	private final Options options = new Options();
	private String recipe;
	private String inventory;
	private String architecture;
	private String objectiveFunction;
	private String stats;
	private boolean optimizeForCost;
	
	public String getRecipe() {
		return recipe;
	}
	
	public String getInventory() {
		return inventory;
	}
	
	public String getArchitecture() {
		return architecture;
	}
	
	public boolean isOptimizeForCost() {
		return optimizeForCost;
	}
	
	public String getStats() {
		return stats;
	}
	
	public AllocationConfiguration(String[] args) throws ParseException {
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
		
		optimizeForCost = objectiveFunction.equals("cost");
	}
	
	private void processArguments(String[] args) throws ParseException {
		options.addOption("help", false, "displays this text");
		options.addOption(requiredOption(RECIPE, "recipe file (input)"));
		options.addOption(requiredOption(INVENTORY, "inventory file (input)"));
		options.addOption(requiredOption(ARCHITECTURE, "architecture file (output)"));
		options.addOption(requiredOption(STATS, "architecture file (output)"));
		options.addOption(OBJECTIVEFUNCTION, true, "objective function: communication (default), cost");
		
		final CommandLineParser parser = new PosixParser();
		final CommandLine cmd = parser.parse(options, args);
		recipe = cmd.getOptionValue(RECIPE);
		inventory = cmd.getOptionValue(INVENTORY);
		architecture = cmd.getOptionValue(ARCHITECTURE);
		objectiveFunction = cmd.getOptionValue(OBJECTIVEFUNCTION);
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

		formatter.printHelp("java -cp \"target/*:target/lib/*\" hu.bme.mit.incqueryd.csp.main.AllocationMain", "options:", options, "", false);
		System.out.println();
	}
	
}
