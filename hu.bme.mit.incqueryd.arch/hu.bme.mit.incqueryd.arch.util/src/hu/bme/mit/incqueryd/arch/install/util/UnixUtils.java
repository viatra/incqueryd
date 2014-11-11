package hu.bme.mit.incqueryd.arch.install.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import com.google.common.base.Charsets;

public class UnixUtils {

	public static void run(final String[] command, OutputStream outputStream) throws IOException {
		run(command, outputStream, new HashMap<String, String>());
	}

	public static void run(final String[] command, OutputStream outputStream, final Map<String, String> environment) throws IOException {
		final BufferedReader reader = runAndReadOutput(command, outputStream, environment);

		String line;
		while ((line = reader.readLine()) != null) {
			if (outputStream != null) {
				println(outputStream, line);
			}
		}

		if (outputStream != null) {
			println(outputStream, "Command finished.");
		}
	}

	private static void println(OutputStream outputStream, String line) throws IOException {
		outputStream.write(line.getBytes(Charsets.UTF_8));
		outputStream.write('\n');
	}

	public static BufferedReader runAndReadOutput(final String[] command, OutputStream outputStream, final Map<String, String> environment) throws IOException {
		if (outputStream != null) {
			println(outputStream, "Invoking command:");
			for (final String string : command) {
				println(outputStream, string + " ");
			}
			println(outputStream, "");
			println(outputStream, "Command output:");
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
