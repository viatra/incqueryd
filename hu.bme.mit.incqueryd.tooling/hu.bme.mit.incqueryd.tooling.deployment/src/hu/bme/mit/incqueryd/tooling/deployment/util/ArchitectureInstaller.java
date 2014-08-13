package hu.bme.mit.incqueryd.tooling.deployment.util;

import hu.bme.mit.incqueryd.arch.util.ArchUtil;
import hu.bme.mit.incqueryd.tooling.deployment.dialogs.MonitoringServerAddressDialog;
import infrastructure.Machine;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;

import arch.Configuration;

public class ArchitectureInstaller {

	public static final String INSTALL_DIR = "~/incqueryd/";
	public static final String COORDINATOR_DIR = "~/incqueryd/coordinator/";
	public static final String AKKA_VERSION = "2.1.4";

	public static void installArchitecture(final IFile file) throws IOException {
		final String architectureFile = file.getLocation().toString();
		final Configuration configuration = ArchUtil.loadConfiguration(architectureFile);
		
		final List<String> command = new ArrayList<>();
		command.add("~/git/incqueryd/hu.bme.mit.incqueryd.tooling/scripts/install.sh");

		//if (light) command.add("--light");
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

		// Pop up a dialog to ask for the monitoring server's IP address
		final Shell activeShell = PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow().getShell();
		final MonitoringServerAddressDialog dialog = new MonitoringServerAddressDialog(
				activeShell);

		String address = null;
		if (dialog.open() == Window.OK) {
			address = dialog.getMsIPAddress();
		}
		
		final String coordinatorIP = configuration.getCoordinatorMachine().getIp();
		
		final List<String> copyCommand = new ArrayList<>();
		copyCommand.add("scp");
		copyCommand.add(architectureFile);
		copyCommand.add(coordinatorIP + ":" + INSTALL_DIR);
		
		final Map<String, String> environment = new HashMap<>();
		
		UnixUtils.run(copyCommand.toArray(new String[copyCommand.size()]), true, environment);
		
		final String archFileNameShort = file.getName();

		final List<String> coordinatorCommand = new ArrayList<>();
		coordinatorCommand.add("ssh");
		coordinatorCommand.add(coordinatorIP);
		coordinatorCommand.add(COORDINATOR_DIR + "start-coordinator.sh");
		coordinatorCommand.add(INSTALL_DIR + archFileNameShort);
		coordinatorCommand.add(coordinatorIP);
		if (address != null && !address.isEmpty())
			coordinatorCommand.add(address);
		
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
}
