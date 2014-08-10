package hu.bme.mit.incqueryd.tooling.deployment.util;

import hu.bme.mit.incqueryd.arch.util.ArchUtil;
import hu.bme.mit.incqueryd.tooling.deployment.dialogs.MonitoringServerAddressDialog;
import infrastructure.Machine;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;

import arch.Configuration;

public class ArchitectureInstaller {

	public static final String INSTALL_DIR = "~/incqueryd/";
	public static final String AKKA_VERSION = "2.1.4";
	public static final String COORDINATOR_DIR = "~/incqueryd/coordinator/";
	
	public static String archFile;
	
	public static void processArchitecture(final String architectureFile) throws IOException {
		archFile = architectureFile;
		
		final Configuration configuration = ArchUtil.loadConfiguration(architectureFile);
		
		final String connectionString = configuration.getConnectionString();
		System.out.println("Connection string: " + connectionString);
		
		for (final Machine machine :  configuration.getMachines()) {
			deploy(machine);
		}
	}

	private static void deploy(final Machine machine) throws IOException {
		
		final String AKKA_DIR = INSTALL_DIR + "akka-" + AKKA_VERSION + "/";
		System.out.println(AKKA_DIR);
		
		final List<String> command = new ArrayList<>();
		command.add("ssh");
		command.add(machine.getIp());
		command.add(AKKA_DIR + "generate-configs.sh");
		command.add(machine.getIp());
		
		for (final infrastructure.Process process: machine.getProcesses()) {
			final int port = process.getPort();
			command.add(Integer.toString(port));
		}
		
		final Map<String, String> environment = new HashMap<>();
		
		UnixUtils.run(command.toArray(new String[command.size()]), true, environment);
		
		final List<String> startCommand = new ArrayList<>();
		startCommand.add("ssh");
		startCommand.add(machine.getIp());
		startCommand.add(INSTALL_DIR + "start-akka.sh");
		
		for (final infrastructure.Process process: machine.getProcesses()) {
			final int port = process.getPort();
			startCommand.add(Integer.toString(port));
		}
		
		UnixUtils.run(startCommand.toArray(new String[startCommand.size()]), true, environment);
		
		// Pop up a dialog to ask for the monitoring server's IP address
		Shell activeShell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
		MonitoringServerAddressDialog dialog = new MonitoringServerAddressDialog(activeShell);
		
		String address = "192.168.133.1";
//		if (dialog.open() == Window.OK) {
//			address = dialog.getMsIPAddress();
//		}
		
		final List<String> coordinatorCommand = new ArrayList<>();
		//coordinatorCommand.add("java -jar");
		coordinatorCommand.add(COORDINATOR_DIR +"start-coordinator.sh");
		coordinatorCommand.add(archFile);
		if(address != null && ! address.isEmpty()) coordinatorCommand.add(address);
		
		UnixUtils.run(coordinatorCommand.toArray(new String[coordinatorCommand.size()]), true, environment);
	}
}
