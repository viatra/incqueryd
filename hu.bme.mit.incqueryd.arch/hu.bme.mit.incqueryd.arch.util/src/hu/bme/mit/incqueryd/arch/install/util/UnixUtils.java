package hu.bme.mit.incqueryd.arch.install.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class UnixUtils {

	public static void run(final String[] command) throws IOException {
		final Map<String, String> environment = new HashMap<>();
		final boolean showOutput = true;
		run(command, showOutput, environment);
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
