package hu.bme.mit.incqueryd.tooling.deployment.main;

import hu.bme.mit.incqueryd.arch.util.ArchUtil;
import infrastructure.Machine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import arch.Configuration;

public class Main {

	public static final String INSTALL_DIR = "~/incqueryd/";
	public static final String AKKA_VERSION = "2.1.4";
	
	public static void main(final String[] args) throws IOException {
		final String architectureFile = "../../hu.bme.mit.incqueryd.queries/arch/posLength.arch";
		final Configuration configuration = ArchUtil.loadConfiguration(architectureFile);
		
		final String connectionString = configuration.getConnectionString();
		System.out.println("Connection string: " + connectionString);
		
		for (final Machine machine :  configuration.getMachines()) {
			deploy(machine);
		}
	}

	private static void deploy(final Machine machine) throws IOException {
		System.out.println(machine);
		
		final String AKKA_DIR = INSTALL_DIR + "akka-" + AKKA_VERSION + "/";
		System.out.println(AKKA_DIR);
		
		final List<String> command = new ArrayList<>();
		command.add("ssh");
		command.add("localhost");
		command.add(AKKA_DIR + "generate-configs.sh");
		command.add(machine.getIp());
		
		for (final infrastructure.Process process: machine.getProcesses()) {
			final int port = process.getPort();
			command.add(Integer.toString(port));
		}
		
		final Map<String, String> environment = new HashMap<>();
		
		run(command.toArray(new String[command.size()]), true, environment);
	}
	
	public static void run(final String[] command, final boolean showOutput, final Map<String, String> environment) throws IOException {
		final BufferedReader reader = runAndReadOutput(command, showOutput, environment);

		String line;
		while ((line = reader.readLine()) != null) {
			if (showOutput) {
				System.out.println(line);
			}
		}
		
		if (showOutput) {
			System.out.println("Command finished.");
		}
	}

	public static BufferedReader runAndReadOutput(final String[] command, final boolean showOutput, final Map<String, String> environment) throws IOException {
		if (showOutput) {
			System.out.println("Invoking command:");
			for (final String string : command) {
				System.out.print(string + " ");
			}
			System.out.println();
			System.out.println("Command output:");
		}

		// passing command name and arguments as an array to the ProcessBuilder
		final ProcessBuilder builder = new ProcessBuilder(command);
		builder.environment().putAll(environment);
		final Process process = builder.start();

		// hooking on the process' output stream
		final InputStream stdout = process.getInputStream();
		final BufferedReader reader = new BufferedReader(new InputStreamReader(stdout));
		return reader;
	}
	
	
}
