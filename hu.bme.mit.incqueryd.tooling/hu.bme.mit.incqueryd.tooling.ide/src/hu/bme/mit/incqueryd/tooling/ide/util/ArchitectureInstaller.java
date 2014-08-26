package hu.bme.mit.incqueryd.tooling.ide.util;

import hu.bme.mit.incqueryd.arch.util.ArchUtil;
import infrastructure.Machine;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;

import arch.Configuration;

public class ArchitectureInstaller {

	public static final String INSTALL_DIR = "~/incqueryd/";
	public static final String COORDINATOR_DIR = "~/incqueryd/coordinator/";
	public static final String OSAGENT_DIR = "~/incqueryd/monitoring/osagent/";
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
		
		UnixUtils.run(command.toArray(new String[command.size()]));
		System.out.println(command);
		
		// Call the monitoring install script as well
		// which installs the monitoring components to the machines as well
		final List<String> monitroingInstallCommand = new ArrayList<>();
		monitroingInstallCommand.add(homeDirectory + "/git/incqueryd-monitoring/scripts/install.sh");
		
		if (light) monitroingInstallCommand.add("--light"); // Light goes for monitoring too
		
		for (final Machine machine : configuration.getMachines()) {
			monitroingInstallCommand.add(machine.getIp());
		}
		
		UnixUtils.run(monitroingInstallCommand.toArray(new String[monitroingInstallCommand.size()]));
		System.out.println(monitroingInstallCommand);
	}
	
	public static void deployArchitecture(final IFile file) throws IOException {
		final String architectureFile = file.getLocation().toString();

		final Configuration configuration = ArchUtil.loadConfiguration(architectureFile);

		final String connectionString = configuration.getConnectionString();
		System.out.println("Connection string: " + connectionString);

		for (final Machine machine : configuration.getMachines()) {
			deployMachine(machine);
			deployOSAgent(machine, configuration.getMonitoringIPAddress());
		}
		deployCoordinator(file, architectureFile, configuration);
	}

	protected static void deployMachine(final Machine machine) throws IOException {
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

		UnixUtils.run(command.toArray(new String[command.size()]));

		final List<String> startCommand = new ArrayList<>();
		startCommand.add("ssh");
		startCommand.add(machine.getIp());
		startCommand.add(INSTALL_DIR + "start-akka.sh");

		for (final infrastructure.Process process : machine.getProcesses()) {
			final int port = process.getPort();
			startCommand.add(Integer.toString(port));
		}
		
		UnixUtils.run(startCommand.toArray(new String[startCommand.size()]));
		
	}
	
	private static void deployOSAgent(final Machine machine, final String monitoringServerIP) throws IOException {
		// Start the OS monitoring agent for the host
		final List<String> osagentStartCommand = new ArrayList<>();
		osagentStartCommand.add("ssh");
		osagentStartCommand.add(machine.getIp());
		osagentStartCommand.add(OSAGENT_DIR + "start.sh");
		osagentStartCommand.add(monitoringServerIP);
		
		UnixUtils.run(osagentStartCommand.toArray(new String[osagentStartCommand.size()]));
	}

	private static void deployCoordinator(final IFile file, final String architectureFile,
			final Configuration configuration) throws IOException {
		final String coordinatorIP = configuration.getCoordinatorMachine().getIp();
		
		final List<String> archCopyCommand = new ArrayList<>();
		archCopyCommand.add("scp");
		archCopyCommand.add(architectureFile);
		archCopyCommand.add(coordinatorIP + ":" + COORDINATOR_DIR + "arch/");
		
		UnixUtils.run(archCopyCommand.toArray(new String[archCopyCommand.size()]));
		
		final List<String> recipePaths = ArchUtil.getRecipePaths(architectureFile);
		for (final String recipeFile : recipePaths) {
			final List<String> recipeCopyCommand = new ArrayList<>();
			recipeCopyCommand.add("scp");
			recipeCopyCommand.add(recipeFile);
			recipeCopyCommand.add(coordinatorIP + ":" + COORDINATOR_DIR + "recipes/");
			
			UnixUtils.run(recipeCopyCommand.toArray(new String[recipeCopyCommand.size()]));
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
		
		UnixUtils.run(coordinatorCommand.toArray(new String[coordinatorCommand.size()]));
	}
	
	public static void destroyArchitecture(final IFile file) throws IOException {
		final String architectureFile = file.getLocation().toString();

		final Configuration configuration = ArchUtil.loadConfiguration(architectureFile);

		for (final Machine machine : configuration.getMachines()) {
			destroyMachine(machine);
		}

		destroyCoordinator(configuration.getCoordinatorMachine());	
	}

	private static void destroyCoordinator(final Machine coordinatorMachine) throws IOException {
		final List<String> startCommand = new ArrayList<>();
		startCommand.add("ssh");
		startCommand.add(coordinatorMachine.getIp());
		startCommand.add("pkill -f incqueryd.core");
		
		UnixUtils.run(startCommand.toArray(new String[startCommand.size()]));
		
	}

	private static void destroyMachine(final Machine machine) throws IOException {
		final List<String> startCommand = new ArrayList<>();
		startCommand.add("ssh");
		startCommand.add(machine.getIp());
		startCommand.add("pkill -f akka");
		
		UnixUtils.run(startCommand.toArray(new String[startCommand.size()]));
		
		// Destroy the OS monitor agents on each machine
		final List<String> osagentDestroyCommand = new ArrayList<>();
		osagentDestroyCommand.add("ssh");
		osagentDestroyCommand.add(machine.getIp());
		osagentDestroyCommand.add("pkill -f osmonitor.core");
		
		UnixUtils.run(osagentDestroyCommand.toArray(new String[osagentDestroyCommand.size()]));
	}
}
