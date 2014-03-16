package hu.bme.mit.trainbenchmark.benchmark.util;

import hu.bme.mit.trainbenchmark.benchmark.config.IncQueryDBenchmarkConfig;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Util {

	protected static String getProjectPath(final IncQueryDBenchmarkConfig bc) {
		return bc.getWorkspacePath() + "/hu.bme.mit.trainbenchmark.benchmark/";
	}

	public static void runGC() {
		for (int i = 0; i < 5; ++i) {
			Runtime.getRuntime().gc();
		}
	}

	public static void freeCache(final IncQueryDBenchmarkConfig bc) {
		final String clearCacheCommand = getProjectPath(bc) + "/scripts/clearCache.sh";
		try {
			Process child;

			final String command = "/bin/sync";
			child = Runtime.getRuntime().exec(command);
			child.waitFor();
			if (child.exitValue() != 0)
				throw new InterruptedException("Bad return value: " + child.exitValue());

			child = Runtime.getRuntime().exec("sudo -n " + clearCacheCommand);
			child.waitFor();
			if (child.exitValue() != 0)
				throw new InterruptedException("Bad return value: " + child.exitValue());
		} catch (final IOException e) {
			e.printStackTrace(); // should never happen
		} catch (final InterruptedException e) {
			System.err.println("Maybe running " + clearCacheCommand + " as root is not permitted?");
			System.err.println("Use the visudo utility to add the following line to the /etc/sudoers file:");
			System.err.println("user ALL=(ALL) NOPASSWD: " + clearCacheCommand);
			e.printStackTrace();
		}
	}

	public static String readFile(final String file) throws IOException {
		final BufferedReader reader = new BufferedReader(new FileReader(file));
		String line = null;
		final StringBuilder stringBuilder = new StringBuilder();
		final String ls = System.getProperty("line.separator");
		while ((line = reader.readLine()) != null) {
			stringBuilder.append(line);
			stringBuilder.append(ls);
		}
		reader.close();
		return stringBuilder.toString();
	}

	public static void writeFile(final String filename, final String content) {
		BufferedWriter out;
		try {
			out = new BufferedWriter(new FileWriter(filename));
			out.write(content);
			out.close();
		} catch (final IOException e) {
			e.printStackTrace();
		}
	}

	public static void sleepLocal(final long ms) {
		try {
			Thread.sleep(ms);
		} catch (final InterruptedException e1) {
			System.err.println("Can not sleep.");
			e1.printStackTrace();
		}
	}

}
