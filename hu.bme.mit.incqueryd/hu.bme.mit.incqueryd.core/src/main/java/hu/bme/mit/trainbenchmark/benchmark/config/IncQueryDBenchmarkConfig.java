package hu.bme.mit.trainbenchmark.benchmark.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.commons.cli.PosixParser;

public class IncQueryDBenchmarkConfig {

	protected final Options options = new Options();
	protected final CommandLineParser parser = new PosixParser();
	protected CommandLine cmd;
	protected List<String> testCases;

	// modification constants
	protected ModificationMethod modificationMethod;
	protected int modificationConstant;

	protected int modificationConstantPosLength;
	protected int modificationConstantRouteSensor;
	protected int modificationConstantSignalNeighbor;
	protected int modificationConstantSwitchSensor;

	protected long timeout;
	protected boolean createSandbox;
	protected boolean benchmarkMode;
	protected int iterationCount;
	protected int seriesCount;

	protected boolean cluster;
	protected boolean initialize4s;
	
	public int getSeriesCount() {
		return seriesCount;
	}

	protected String instanceVariant;
	protected String queryVariant;

	// RDF-specific
	protected int inferencing;
	
	public IncQueryDBenchmarkConfig(final String args[]) throws ParseException {
		super();
		initOptions();

		if (Arrays.asList(args).contains("-help")) {
			printHelp();
			System.exit(0);
		}

		try {
			processArguments(args);
		} catch (final ParseException e) {
			printHelp();
			throw e;
		}
	}
	

	// arguments
	protected String scenario;
	public List<Integer> sizes;
	protected String workspacePath;



	// shorthand for generating required options
	protected static Option requiredOption(final String name, final String description) {
		final Option option = new Option(name, true, description);
		option.setRequired(true);
		return option;
	}

	public void printHelp() {
		final HelpFormatter formatter = new HelpFormatter();
		formatter.setWidth(120);

		formatter.printHelp("java -jar trainbenchmark-project-jarfile.jar [options]", "options:", options, "", false);
		System.out.println();
	}


	protected void initOptions() {
		options.addOption("cluster", false, "run IncQuery-D in a cluster");
		options.addOption("initialize4s", false, "initialize 4store");
		
		options.addOption("help", false, "displays this text");
		options.addOption(requiredOption("scenario", "User/XForm"));
		options.addOption(requiredOption("sizes", "model sizes, e.g. 1-8 or 1,8-512"));
		options.addOption(requiredOption("workspacePath", "path of the Eclipse workspace with all projects"));


		options.addOption(requiredOption("queries", "a comma-separated list of the queries to run"));

		options.addOption("timeout", true,
				"millisecs to wait for the test to run. If createSandbox is set, beyond this time the test will be killed.");
		options.addOption("createSandbox", true, "kill the test when timeout is reached, and this is true");
		options.addOption("benchmarkMode", true,
				"run benchmark specific (non-functional) procedures, like cleaning the OS cache.");
		options.addOption("seriesCount", true,
				"number of the run benchmark series. Will be echoed in column 1.");

		// modification constants
		options.addOption(
				"modificationMethod",
				true,
				"options: constant - modify a fixed number of elements, resultSet -- modify based a number of elements based on the size of the results set");
		options.addOption("iterationCount", true, "number of modify-check iterations");
		options.addOption("modificationConstant", true, "modification constant for the modification method");

		options.addOption("modificationConstantPosLength", true, "amount of modification for the PosLength test");
		options.addOption("modificationConstantRouteSensor", true, "amount of modification for the RouteSensor test");
		options.addOption("modificationConstantSwitchSensor", true, "amount of modification for the SwitchSensor test");
		options.addOption("modificationConstantSignalNeighbor", true,
				"amount of modification for the SignalNeighbor test");

		options.addOption("instanceVariant", true, "append to instance model filename");
		options.addOption("queryVariant", true, "select query variant");
		
		// RDF-specific
		options.addOption("inferencing", true, "RDF: type of inference");
	}

	public void processArguments(final String[] args) throws ParseException {
		cmd = parser.parse(options, args);

		scenario = cmd.getOptionValue("scenario");

		if (cmd.getOptionValue("sizes") != null) {
			sizes = new ArrayList<>();

			final String sizesStr = cmd.getOptionValue("sizes");
			final String[] sizeRanges = sizesStr.split(",");
			for (final String sizeRange : sizeRanges) {
				final Integer from = new Integer(sizeRange.split("-")[0]);
				Integer to;
				try {
					to = new Integer(sizeRange.split("-")[1]);
				} catch (final ArrayIndexOutOfBoundsException e) {
					to = from; // only a single number without dash
				}
				if (from != 0) {
					for (int i = from; i <= to; i *= 2) {
						sizes.add(i);
					}
				}
			}
		}

		workspacePath = cmd.getOptionValue("workspacePath");

		
		// queries argument -> testCases list
		testCases = new ArrayList<String>();
		final String queriesString = cmd.getOptionValue("queries");
		final String[] queryString = queriesString.split(",");
		for (final String query : queryString) {
			testCases.add(query);
		}

		final String modificationMethodString = cmd.getOptionValue("modificationMethod");
		if (modificationMethodString != null) {
			switch (modificationMethodString) {
			case "constant":
				modificationMethod = ModificationMethod.CONSTANT;
				break;
			case "resultSet":
				modificationMethod = ModificationMethod.RESULT_SET;
				break;
			default:
				throw new ParseException("Invalid modification method specified");
			}
		} else {
			modificationMethod = ModificationMethod.CONSTANT;
		}

		final String iterationCountString = cmd.getOptionValue("iterationCount");
		if (iterationCountString != null) {
			iterationCount = new Integer(iterationCountString);
		} else {
			iterationCount = 10;
		}

		final String seriesCountString = cmd.getOptionValue("seriesCount");
		if (seriesCountString != null) {
			seriesCount = new Integer(seriesCountString);
		} else {
			seriesCount = -1;
		}

		modificationConstant = 10;
		modificationConstant = determineModificationConstant("modificationConstant");
		modificationConstantPosLength = determineModificationConstant("modificationConstantPosLength");
		modificationConstantRouteSensor = determineModificationConstant("modificationConstantRouteSensor");
		modificationConstantSwitchSensor = determineModificationConstant("modificationConstantSwitchSensor");
		modificationConstantSignalNeighbor = determineModificationConstant("modificationConstantSignalNeighbor");
		
		final String timeoutString = cmd.getOptionValue("timeout");
		if (timeoutString != null) {
			timeout = new Long(timeoutString);
		} else {
			timeout = 60000000;
		}
		
		final String createSandboxString = cmd.getOptionValue("createSandbox");
		if (createSandboxString != null) {
			createSandbox = new Boolean(createSandboxString);
		} else {
			createSandbox = false;
		}
		
		final String benchmarkModeString = cmd.getOptionValue("benchmarkMode");
		if (benchmarkModeString != null) {
			benchmarkMode = new Boolean(benchmarkModeString);
		} else {
			benchmarkMode = false;
		}

		final String instanceVariantString = cmd.getOptionValue("instanceVariant");
		if (instanceVariantString != null) {
			instanceVariant = instanceVariantString;
			if ("-".equals(instanceVariant))
				instanceVariant = "";
		} else {
			instanceVariant = "";
		}

		final String queryVariantString = cmd.getOptionValue("queryVariant");
		if (queryVariantString != null) {
			queryVariant = queryVariantString;
			if ("-".equals(queryVariant))
				queryVariant = "";
		} else {
			queryVariant = "";
		}

		// RDF-specific
		final String inferencingString = cmd.getOptionValue("inferencing");
		if (inferencingString != null) {
			inferencing = new Integer(inferencingString);
		} else {
			inferencing = -1;
		}
		
		cluster = cmd.hasOption("cluster");
		initialize4s = cmd.hasOption("initialize4s");
	}

	private int determineModificationConstant(final String optionName) {
		if (cmd.getOptionValue(optionName) != null) {
			return new Integer(cmd.getOptionValue(optionName));
		} else {
			return modificationConstant;
		}
	}

	@Override
	public String toString() {
		return "Scenario: " + scenario + "\n" + "\n" + "variant: \"" + getVariant()
				+ "\"\n" + "createSandbox: " + createSandbox + "\n" + "benchmarkMode: " + benchmarkMode + "\n"
				+ "timeout: " + timeout + "\n" + "inferencing: " + inferencing + "\n" + "modificationConstant: "
				+ getModificationConstant() + "\n" + "modificationMethod: " + modificationMethod + "\n"
				+ "userIterate: " + iterationCount + "\n" + "testCases: " + testCases.toString() + "\n";
	}

	/**
	 * 
	 * @param testCase
	 * @return true, if the testcase was specified in the arguments. If no testcase was specified, return true. (Default
	 *         is to run all testcases.)
	 */
	public boolean doTestCase(final String testCase) {
		if (testCases.size() > 0)
			return testCases.contains(testCase);
		return true;
	}

	public ModificationMethod getModificationMethod() {
		return modificationMethod;
	}

	public int getModificationConstant() {
		return modificationConstant;
	}

	public int getModificationConstantPosLength() {
		return modificationConstantPosLength;
	}

	public int getModificationConstantRouteSensor() {
		return modificationConstantRouteSensor;
	}

	public int getModificationConstantSwitchSensor() {
		return modificationConstantSwitchSensor;
	}

	public int getModificationConstantSignalNeighbor() {
		return modificationConstantSignalNeighbor;
	}

	public int getInferencing() {
		return inferencing;
	}

	public long getTimeout() {
		return timeout;
	}

	public boolean isCreateSandbox() {
		return createSandbox;
	}

	public boolean isBenchmarkMode() {
		return benchmarkMode;
	}

	public int getIterationCount() {
		return iterationCount;
	}

	public String getQueryVariant() {
		return queryVariant;
	}

	public String getInstanceVariant() {
		return instanceVariant;
	}

	public List<String> getTestCases() {
		return testCases;
	}


	public List<Integer> getSizes() {
		return sizes;
	}

	public String getScenario() {
		return scenario;		
		

	}

	public String getWorkspacePath() {
		return workspacePath;
	}

	public String getInstanceModelPath() {
		return workspacePath + "/hu.bme.mit.trainbenchmark.instancemodels/";
	}

	public String getVariant() {
		return "-" + scenario.toLowerCase() + "-";
	}
	
	public boolean isCluster() {
		return cluster;
	}

	public boolean isInitialize4s() {
		return initialize4s;
	}
	
}
