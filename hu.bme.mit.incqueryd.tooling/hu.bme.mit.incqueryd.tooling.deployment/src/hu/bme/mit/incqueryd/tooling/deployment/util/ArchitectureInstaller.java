package hu.bme.mit.incqueryd.tooling.deployment.util;

import hu.bme.mit.incqueryd.arch.util.ArchUtil;
import infrastructure.Machine;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import arch.Configuration;

public class ArchitectureInstaller {

	public static final String INSTALL_DIR = "~/incqueryd/";
	public static final String AKKA_VERSION = "2.1.4";
	
	public static void processArchitecture(final String architectureFile) throws IOException {
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
		
		UnixUtils.run(command.toArray(new String[command.size()]), true, environment);
	}
}
