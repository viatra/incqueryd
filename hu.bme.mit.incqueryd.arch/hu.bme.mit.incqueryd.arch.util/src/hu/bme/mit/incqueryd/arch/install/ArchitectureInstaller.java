package hu.bme.mit.incqueryd.arch.install;

import hu.bme.mit.incqueryd.arch.install.util.UnixUtils;
import hu.bme.mit.incqueryd.arch.util.ArchUtil;
import infrastructure.Machine;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import arch.Configuration;

public class ArchitectureInstaller {

	public static final String INSTALL_DIR = "~/incqueryd/";
	public static final String COORDINATOR_DIR = "~/incqueryd/coordinator/";
	public static final String OSAGENT_DIR = "~/incqueryd/monitoring/osagent/";
	public static final String MONSERVER_DIR = "~/incqueryd/monitoring/server/";
	public static final String AKKA_VERSION = "2.1.4";

	public static void installArchitecture(final String architectureFile, final boolean light, OutputStream outputStream) throws IOException {
		final Configuration configuration = ArchUtil.loadConfiguration(architectureFile);

		final List<String> command = new ArrayList<>();
		final String homeDirectory = System.getProperty("user.home");
		command.add(homeDirectory + "/git/incqueryd/hu.bme.mit.incqueryd.runtime/scripts/install.sh");

		if (light)
			command.add("--light");
		command.add(configuration.getCoordinatorMachine().getIp());
		for (final Machine machine : configuration.getMachines()) {
			command.add(machine.getIp());
		}

		UnixUtils.run(command.toArray(new String[command.size()]), outputStream);
		System.out.println(command);

		// Call the monitoring install script as well
		// which installs the monitoring components to the machines as well
		final List<String> monitoringInstallCommand = new ArrayList<>();
		monitoringInstallCommand.add(homeDirectory + "/git/incqueryd/hu.bme.mit.incqueryd.monitoring/scripts/install.sh");

		if (light)
			monitoringInstallCommand.add("--light"); // Light goes for monitoring too

		monitoringInstallCommand.add(configuration.getMonitoringMachine().getIp()); // The IP of the monitoring server

		for (final Machine machine : configuration.getMachines()) {
			monitoringInstallCommand.add(machine.getIp());
		}

		UnixUtils.run(monitoringInstallCommand.toArray(new String[monitoringInstallCommand.size()]), outputStream);
		System.out.println(monitoringInstallCommand);
	}

	public static void uninstallArchitecture(final String architectureFile, OutputStream outputStream) throws IOException {
		final Configuration configuration = ArchUtil.loadConfiguration(architectureFile);

		final List<String> command = new ArrayList<>();
		final String homeDirectory = System.getProperty("user.home");
		command.add(homeDirectory + "/git/incqueryd/hu.bme.mit.incqueryd.runtime/scripts/uninstall.sh");

		for (final Machine machine : configuration.getMachines()) {
			command.add(machine.getIp());
		}

		UnixUtils.run(command.toArray(new String[command.size()]), outputStream);
		System.out.println(command);
	}

	public static void deployArchitecture(final String architectureFile, OutputStream outputStream) throws IOException {
		final Configuration configuration = ArchUtil.loadConfiguration(architectureFile);

		final String connectionString = configuration.getConnectionString();
		System.out.println("Connection string: " + connectionString);

//		deployMonitoringServer(configuration.getMonitoringMachine());

		for (final Machine machine : configuration.getMachines()) {
			deployMonitoringServer(machine, outputStream);
			deployMachine(machine, outputStream);

			if (configuration.getMonitoringMachine() != null) {
				deployOSAgent(machine, configuration.getMonitoringMachine().getIp(), outputStream);
			}

		}
		deployCoordinator(architectureFile, configuration, outputStream);

	}

	protected static void deployMachine(final Machine machine, OutputStream outputStream) throws IOException {
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

		UnixUtils.run(command.toArray(new String[command.size()]), outputStream);

		for (final infrastructure.Process process : machine.getProcesses()) {
			final List<String> startCommand = new ArrayList<>();
			startCommand.add("ssh");
			startCommand.add(machine.getIp());
			startCommand.add(INSTALL_DIR + "start-akka.sh");

			final int port = process.getPort();
			startCommand.add(Integer.toString(port));

			final int memory = process.getMemory();
			startCommand.add(Integer.toString(memory));

			UnixUtils.run(startCommand.toArray(new String[startCommand.size()]), outputStream);

		}

	}

	private static void deployOSAgent(final Machine machine, final String monitoringServerIP, OutputStream outputStream) throws IOException {
		// Start the OS monitoring agent for the host
		final List<String> osagentStartCommand = new ArrayList<>();
		osagentStartCommand.add("ssh");
		osagentStartCommand.add(machine.getIp());
		osagentStartCommand.add(OSAGENT_DIR + "start.sh");
		osagentStartCommand.add(monitoringServerIP);

		UnixUtils.run(osagentStartCommand.toArray(new String[osagentStartCommand.size()]), outputStream);
	}

	private static void deployMonitoringServer(final Machine monitoringMachine, OutputStream outputStream) throws IOException {
		// Start the OS monitoring agent for the host
		final List<String> osagentStartCommand = new ArrayList<>();
		osagentStartCommand.add("ssh");
		osagentStartCommand.add(monitoringMachine.getIp());
		osagentStartCommand.add(MONSERVER_DIR + "start-server.sh");

		UnixUtils.run(osagentStartCommand.toArray(new String[osagentStartCommand.size()]), outputStream);
	}

	private static void deployCoordinator(final String architectureFile,
			final Configuration configuration, OutputStream outputStream) throws IOException {
		final String coordinatorIP = configuration.getCoordinatorMachine().getIp();

		final List<String> archCopyCommand = new ArrayList<>();
		archCopyCommand.add("scp");
		archCopyCommand.add(architectureFile);
		archCopyCommand.add(coordinatorIP + ":" + COORDINATOR_DIR + "arch/");

		UnixUtils.run(archCopyCommand.toArray(new String[archCopyCommand.size()]), outputStream);

		final List<String> recipePaths = ArchUtil.getRecipePaths(architectureFile);
		for (final String recipeFile : recipePaths) {
			final List<String> recipeCopyCommand = new ArrayList<>();
			recipeCopyCommand.add("scp");
			recipeCopyCommand.add(recipeFile);
			recipeCopyCommand.add(coordinatorIP + ":" + COORDINATOR_DIR + "recipes/");

			UnixUtils.run(recipeCopyCommand.toArray(new String[recipeCopyCommand.size()]), outputStream);
		}

		File file = new File(architectureFile);
		final String archFileNameShort = file.getName();

		final List<String> coordinatorCommand = new ArrayList<>();
		coordinatorCommand.add("ssh");
		coordinatorCommand.add(coordinatorIP);
		coordinatorCommand.add(COORDINATOR_DIR + "start-coordinator.sh");
		coordinatorCommand.add(COORDINATOR_DIR + "arch/" + archFileNameShort);
		coordinatorCommand.add(configuration.getCoordinatorMachine().getIp());

		UnixUtils.run(coordinatorCommand.toArray(new String[coordinatorCommand.size()]), outputStream);
	}

	public static void stopArchitecture(final String architectureFile, OutputStream outputStream) throws IOException {

		final Configuration configuration = ArchUtil.loadConfiguration(architectureFile);

		for (final Machine machine : configuration.getMachines()) {
			destroyMachine(machine, outputStream);
		}

		// this was changed as the required as the destroyMachine() method destroys the cooridnator as well
		//destroyCoordinator(configuration.getCoordinatorMachine());
		destroyMachine(configuration.getCoordinatorMachine(), outputStream);
		destroyMonitoringServer(configuration.getMonitoringMachine(), outputStream);
	}

	private static void destroyCoordinator(final Machine coordinatorMachine, OutputStream outputStream) throws IOException {
		final List<String> startCommand = new ArrayList<>();
		startCommand.add("ssh");
		startCommand.add(coordinatorMachine.getIp());
		startCommand.add("pkill -f incqueryd.core");

		UnixUtils.run(startCommand.toArray(new String[startCommand.size()]), outputStream);

	}

	private static void destroyMonitoringServer(final Machine monitoringMachine, OutputStream outputStream) throws IOException {
		final List<String> startCommand = new ArrayList<>();
		startCommand.add("ssh");
		startCommand.add(monitoringMachine.getIp());
		startCommand.add("pkill -f dw-server");

		UnixUtils.run(startCommand.toArray(new String[startCommand.size()]), outputStream);

	}

	private static void destroyMachine(final Machine machine, OutputStream outputStream) throws IOException {
		final List<String> startCommand = new ArrayList<>();
		startCommand.add("ssh");
		startCommand.add(machine.getIp());
		startCommand.add("pkill -f IncQueryDMicrokernel");

		UnixUtils.run(startCommand.toArray(new String[startCommand.size()]), outputStream);

		// Destroy the OS monitor agents on each machine
		final List<String> osagentDestroyCommand = new ArrayList<>();
		osagentDestroyCommand.add("ssh");
		osagentDestroyCommand.add(machine.getIp());
		osagentDestroyCommand.add("pkill -f osmonitor.core");

		UnixUtils.run(osagentDestroyCommand.toArray(new String[osagentDestroyCommand.size()]), outputStream);
	}
}