package hu.bme.mit.incqueryd.arch.install;

import hu.bme.mit.incqueryd.arch.util.ArchUtil;
import infrastructure.Machine;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import arch.Configuration;

import com.google.common.base.Joiner;

import eu.mondo.utils.UnixUtils;

public class ArchitectureInstaller {

	public static final String INSTALL_DIR = "incqueryd/";
	public static final String COORDINATOR_DIR = "incqueryd/coordinator/";
	public static final String OSAGENT_DIR = "incqueryd/monitoring/osagent/";
	public static final String MONSERVER_DIR = "incqueryd/monitoring/server/";
	public static final String AKKA_VERSION = "2.1.4";

	public static void installArchitecture(final File architectureFile, File installerDirectory, final boolean light, OutputStream outputStream) throws IOException {
		final Configuration configuration = ArchUtil.loadConfiguration(architectureFile);

		final StringBuilder commandBuilder = new StringBuilder();
		File script = new File(installerDirectory, "hu.bme.mit.incqueryd.core/scripts/install.sh");
		commandBuilder.append(script.getAbsolutePath());

		if (light)
			commandBuilder.append(" --light");
		commandBuilder.append(" " + configuration.getCoordinatorMachine().getIp());
		for (final Machine machine : configuration.getMachines()) {
			commandBuilder.append(" " + machine.getIp());
		}

		UnixUtils.exec(commandBuilder.toString(), Collections.EMPTY_MAP, outputStream);

		// Call the monitoring install script as well
		// which installs the monitoring components to the machines as well
		final List<String> monitoringInstallCommand = new ArrayList<>();
		File monitoringScript = new File(installerDirectory, "hu.bme.mit.incqueryd.monitoring/scripts/install.sh");
		monitoringInstallCommand.add(monitoringScript.getAbsolutePath());

		if (light)
			monitoringInstallCommand.add("--light"); // Light goes for monitoring too

		monitoringInstallCommand.add(configuration.getMonitoringMachine().getIp()); // The IP of the monitoring server

		for (final Machine machine : configuration.getMachines()) {
			monitoringInstallCommand.add(machine.getIp());
		}

		UnixUtils.exec(Joiner.on(" ").join(monitoringInstallCommand), Collections.EMPTY_MAP, outputStream);
		System.out.println(monitoringInstallCommand);
	}

	public static void uninstallArchitecture(final File architectureFile, File installerDirectory, OutputStream outputStream) throws IOException {
		final Configuration configuration = ArchUtil.loadConfiguration(architectureFile);

		final List<String> command = new ArrayList<>();
		File script = new File(installerDirectory, "hu.bme.mit.incqueryd.core/scripts/uninstall.sh");
		command.add(script.getAbsolutePath());

		for (final Machine machine : configuration.getMachines()) {
			command.add(machine.getIp());
		}

		UnixUtils.exec(Joiner.on(" ").join(command), Collections.EMPTY_MAP, outputStream);
		System.out.println(command);
	}

	public static void deployArchitecture(final File architectureFile, OutputStream outputStream) throws IOException {
		final Configuration configuration = ArchUtil.loadConfiguration(architectureFile);

		final String connectionString = configuration.getConnectionString();
		System.out.println("Connection string: " + connectionString);

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

		for (final infrastructure.Process process : machine.getProcesses()) {
			final int port = process.getPort();
			command.add(Integer.toString(port));
		}

		UnixUtils.exec(Joiner.on(" ").join(command), Collections.EMPTY_MAP, outputStream);

		for (final infrastructure.Process process : machine.getProcesses()) {
			final List<String> startCommand = new ArrayList<>();
			startCommand.add("ssh");
			startCommand.add(machine.getIp());
			startCommand.add(INSTALL_DIR + "start-akka.sh");

			final int port = process.getPort();
			startCommand.add(Integer.toString(port));

			final int memory = process.getMemory();
			startCommand.add(Integer.toString(memory));

			UnixUtils.exec(Joiner.on(" ").join(startCommand), Collections.EMPTY_MAP, outputStream);

		}

	}

	private static void deployOSAgent(final Machine machine, final String monitoringServerIP, OutputStream outputStream) throws IOException {
		// Start the OS monitoring agent for the host
		final List<String> osagentStartCommand = new ArrayList<>();
		osagentStartCommand.add("ssh");
		osagentStartCommand.add(machine.getIp());
		osagentStartCommand.add(OSAGENT_DIR + "start.sh");
		osagentStartCommand.add(monitoringServerIP);

		UnixUtils.exec(Joiner.on(" ").join(osagentStartCommand), Collections.EMPTY_MAP, outputStream);
	}

	private static void deployMonitoringServer(final Machine monitoringMachine, OutputStream outputStream) throws IOException {
		// Start the OS monitoring agent for the host
		final List<String> osagentStartCommand = new ArrayList<>();
		osagentStartCommand.add("ssh");
		osagentStartCommand.add(monitoringMachine.getIp());
		osagentStartCommand.add(MONSERVER_DIR + "start-server.sh");

		UnixUtils.exec(Joiner.on(" ").join(osagentStartCommand), Collections.EMPTY_MAP, outputStream);
	}

	private static void deployCoordinator(final File architectureFile,
			final Configuration configuration, OutputStream outputStream) throws IOException {
		final String coordinatorIP = configuration.getCoordinatorMachine().getIp();

		final List<String> archCopyCommand = new ArrayList<>();
		archCopyCommand.add("scp");
		archCopyCommand.add(architectureFile.getAbsolutePath());
		archCopyCommand.add(coordinatorIP + ":" + COORDINATOR_DIR + "arch/");

		UnixUtils.exec(Joiner.on(" ").join(archCopyCommand), Collections.EMPTY_MAP, outputStream);

		final List<String> recipePaths = ArchUtil.getRecipePaths(architectureFile);
		for (final String recipeFile : recipePaths) {
			final List<String> recipeCopyCommand = new ArrayList<>();
			recipeCopyCommand.add("scp");
			recipeCopyCommand.add(recipeFile);
			recipeCopyCommand.add(coordinatorIP + ":" + COORDINATOR_DIR + "recipes/");

			UnixUtils.exec(Joiner.on(" ").join(recipeCopyCommand), Collections.EMPTY_MAP, outputStream);
		}

		final String archFileNameShort = architectureFile.getName();

		final List<String> coordinatorCommand = new ArrayList<>();
		coordinatorCommand.add("ssh");
		coordinatorCommand.add(coordinatorIP);
		coordinatorCommand.add(COORDINATOR_DIR + "start-coordinator.sh");
		coordinatorCommand.add(COORDINATOR_DIR + "arch/" + archFileNameShort);
		coordinatorCommand.add(configuration.getCoordinatorMachine().getIp());

		UnixUtils.exec(Joiner.on(" ").join(coordinatorCommand), Collections.EMPTY_MAP, outputStream);
	}

	public static void stopArchitecture(final File architectureFile, OutputStream outputStream) throws IOException {

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

		UnixUtils.exec(Joiner.on(" ").join(startCommand), Collections.EMPTY_MAP, outputStream);

	}

	private static void destroyMonitoringServer(final Machine monitoringMachine, OutputStream outputStream) throws IOException {
		final List<String> startCommand = new ArrayList<>();
		startCommand.add("ssh");
		startCommand.add(monitoringMachine.getIp());
		startCommand.add("pkill -f dw-server");

		UnixUtils.exec(Joiner.on(" ").join(startCommand), Collections.EMPTY_MAP, outputStream);

	}

	private static void destroyMachine(final Machine machine, OutputStream outputStream) throws IOException {
		final List<String> startCommand = new ArrayList<>();
		startCommand.add("ssh");
		startCommand.add(machine.getIp());
		startCommand.add("pkill -f IncQueryDMicrokernel");

		UnixUtils.exec(Joiner.on(" ").join(startCommand), Collections.EMPTY_MAP, outputStream);

		// Destroy the OS monitor agents on each machine
		final List<String> osagentDestroyCommand = new ArrayList<>();
		osagentDestroyCommand.add("ssh");
		osagentDestroyCommand.add(machine.getIp());
		osagentDestroyCommand.add("pkill -f osmonitor.core");

		UnixUtils.exec(Joiner.on(" ").join(startCommand), Collections.EMPTY_MAP, outputStream);
	}
}