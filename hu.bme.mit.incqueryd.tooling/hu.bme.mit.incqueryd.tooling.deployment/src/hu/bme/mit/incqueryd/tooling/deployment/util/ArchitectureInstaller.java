package hu.bme.mit.incqueryd.tooling.deployment.util;

import hu.bme.mit.incqueryd.arch.util.ArchUtil;
import infrastructure.Machine;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IFile;

import arch.Configuration;

public class ArchitectureInstaller {

	public static final String INSTALL_DIR = "~/incqueryd/";
	public static final String COORDINATOR_DIR = "~/incqueryd/coordinator/";
	public static final String AKKA_VERSION = "2.1.4";

	public static void installArchitecture(final IFile file, final boolean light) throws IOException {
		final String architectureFile = file.getLocation().toString();
		final Configuration configuration = ArchUtil.loadConfiguration(architectureFile);
		
		final List<String> command = new ArrayList<>();
		final String homeDirectory = System.getProperty( "user.home" );
		command.add(homeDirectory + "/git/incqueryd/hu.bme.mit.incqueryd.runtime/scripts/install.sh");

		if (light) command.add("--light");
		command.add(configuration.getCoordinatorMachine().getIp());
		for (final Machine machine : configuration.getMachines()) {
			command.add(machine.getIp());
		}
		
		final Map<String, String> environment = new HashMap<>();
		UnixUtils.run(command.toArray(new String[command.size()]), true, environment);
		System.out.println(command);
	}
	
	public static void deployArchitecture(final IFile file) throws IOException {
		final String architectureFile = file.getLocation().toString();

		final Configuration configuration = ArchUtil.loadConfiguration(architectureFile);

		final String connectionString = configuration.getConnectionString();
		System.out.println("Connection string: " + connectionString);

		deployCoordinator(configuration.getCoordinatorMachine(), architectureFile);		
		
		for (final Machine machine : configuration.getMachines()) {
			deploy(machine);
		}

		final String coordinatorIP = configuration.getCoordinatorMachine().getIp();
		
		final List<String> archCopyCommand = new ArrayList<>();
		archCopyCommand.add("scp");
		archCopyCommand.add(architectureFile);
		archCopyCommand.add(coordinatorIP + ":" + COORDINATOR_DIR + "arch/");
		
		final Map<String, String> environment = new HashMap<>();
		
		UnixUtils.run(archCopyCommand.toArray(new String[archCopyCommand.size()]), true, environment);
		
		final List<String> recipePaths = ArchUtil.getRecipePaths(architectureFile);
		for (final String recipeFile : recipePaths) {
			final List<String> recipeCopyCommand = new ArrayList<>();
			recipeCopyCommand.add("scp");
			recipeCopyCommand.add(recipeFile);
			recipeCopyCommand.add(coordinatorIP + ":" + COORDINATOR_DIR + "recipes/");
			
			UnixUtils.run(recipeCopyCommand.toArray(new String[recipeCopyCommand.size()]), true, environment);
		}
		
		final String archFileNameShort = file.getName();
		final String monitoringIPAddress = configuration.getMonitoringIPAddress();

		final List<String> coordinatorCommand = new ArrayList<>();
		coordinatorCommand.add("ssh");
		coordinatorCommand.add(coordinatorIP);
		coordinatorCommand.add(COORDINATOR_DIR + "start-coordinator.sh");
		coordinatorCommand.add(COORDINATOR_DIR + "arch/" + archFileNameShort);
		coordinatorCommand.add(coordinatorIP);
		if (monitoringIPAddress != null && !monitoringIPAddress.isEmpty())
			coordinatorCommand.add(monitoringIPAddress);
		
		UnixUtils.run(coordinatorCommand.toArray(new String[coordinatorCommand.size()]), true, environment);
	}

	protected static void deployCoordinator(final Machine coordinatorMachine, final String architectureFile) {
		System.out.println(ArchUtil.getRecipePaths(architectureFile));
	}

	protected static void deploy(final Machine machine) throws IOException {

		final String AKKA_DIR = INSTALL_DIR + "akka-" + AKKA_VERSION + "/";
		System.out.println(AKKA_DIR);

		final List<String> command = new ArrayList<>();
		command.add("ssh");
		command.add(machine.getIp());
		command.add(AKKA_DIR + "generate-configs.sh");
		command.add(machine.getIp());

		for (final infrastructure.Process process : machine.getProcesses()) {
			final int port = process.getPort();
			command.add(Integer.toString(port));
		}

		final Map<String, String> environment = new HashMap<>();

		UnixUtils.run(command.toArray(new String[command.size()]), true, environment);

		final List<String> startCommand = new ArrayList<>();
		startCommand.add("ssh");
		startCommand.add(machine.getIp());
		startCommand.add(INSTALL_DIR + "start-akka.sh");

		for (final infrastructure.Process process : machine.getProcesses()) {
			final int port = process.getPort();
			startCommand.add(Integer.toString(port));
		}
		
		UnixUtils.run(startCommand.toArray(new String[startCommand.size()]), true, environment);

	}

	public static void destroyArchitecture(final IFile file) throws IOException {
		System.out.println("Destroy architecture.");
	}
}
