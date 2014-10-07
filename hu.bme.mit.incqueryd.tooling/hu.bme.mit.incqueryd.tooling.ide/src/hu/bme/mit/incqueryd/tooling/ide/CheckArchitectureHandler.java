package hu.bme.mit.incqueryd.tooling.ide;

import hu.bme.mit.incqueryd.arch.util.ArchUtil;
import hu.bme.mit.incqueryd.tooling.ide.httpclient.HttpClient;
import hu.bme.mit.incqueryd.tooling.ide.util.ArchitectureSelector;

import java.io.IOException;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;

import arch.Configuration;

public class CheckArchitectureHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		final IFile file = ArchitectureSelector.getSelection(event);
		String architectureFile = file.getLocation().toString();
		Configuration configuration;
		try {
			configuration = ArchUtil.loadConfiguration(architectureFile);
		} catch (IOException e) {
			throw new ExecutionException("Cannot process architecture file.", e);
		}
		
		String coordinatorIp = configuration.getCoordinatorMachine().getIp();
		
		try {
			String response = HttpClient.getURL("http://" + coordinatorIp +":9090/check");
			System.out.println(response);
		} catch (IOException e) {
			throw new ExecutionException("Coordinator actor did not respond.", e);
		}
		
		return null;
	}

}
