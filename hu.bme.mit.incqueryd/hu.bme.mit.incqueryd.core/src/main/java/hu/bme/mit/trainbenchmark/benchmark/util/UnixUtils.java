package hu.bme.mit.trainbenchmark.benchmark.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class UnixUtils {

	public static void run(final String command, final boolean showOutput) throws IOException {
		run(new String[] { command }, showOutput);
	}

	public static void run(final String[] command, final boolean showOutput) throws IOException {
		final BufferedReader reader = runAndReadOutput(command, showOutput);

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

	public static BufferedReader runAndReadOutput(final String[] command, final boolean showOutput) throws IOException {
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
		final Process process = builder.start();

		// hooking on the process' output stream
		final InputStream stdout = process.getInputStream();
		final BufferedReader reader = new BufferedReader(new InputStreamReader(stdout));
		return reader;
	}
	
	public static void printBuffer(final BufferedReader reader) throws IOException {
		String line;
		while ((line = reader.readLine()) != null) {
			System.out.println(line);
		}
	}
}
