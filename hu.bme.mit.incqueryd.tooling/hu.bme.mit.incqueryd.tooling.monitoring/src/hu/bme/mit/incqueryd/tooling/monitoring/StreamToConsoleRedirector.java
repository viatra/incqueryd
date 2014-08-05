package hu.bme.mit.incqueryd.tooling.monitoring;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.eclipse.ui.console.IOConsoleOutputStream;

public class StreamToConsoleRedirector extends Thread {
	private final InputStream inputStream;
	private final IOConsoleOutputStream outputStream;

	public StreamToConsoleRedirector(InputStream is, IOConsoleOutputStream outputStream) {
		this.inputStream = is;
		this.outputStream = outputStream;
	}

	public void run() {
		try {
			InputStreamReader isr = new InputStreamReader(inputStream);
			BufferedReader br = new BufferedReader(isr);
			String line = null;
			while ((line = br.readLine()) != null) {
				outputStream.write(line);
				outputStream.write("\n");
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
}