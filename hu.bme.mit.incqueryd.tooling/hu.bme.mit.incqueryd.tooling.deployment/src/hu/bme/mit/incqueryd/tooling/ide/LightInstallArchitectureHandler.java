package hu.bme.mit.incqueryd.tooling.ide;

import hu.bme.mit.incqueryd.arch.install.ArchitectureInstaller;
import hu.bme.mit.incqueryd.tooling.ide.util.ArchitectureSelector;
import hu.bme.mit.incqueryd.tooling.ide.util.IqdConsole;

import java.io.IOException;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;

public class LightInstallArchitectureHandler extends AbstractHandler {

	@Override
	public Object execute(final ExecutionEvent event) throws ExecutionException {
		final IFile file = ArchitectureSelector.getSelection(event);
		new Job("Installing architecture (light)") {
			@Override
			protected IStatus run(IProgressMonitor monitor) {
				IqdConsole console = IqdConsole.getInstance();
				try {
					ArchitectureInstaller.installArchitecture(file.getLocation().toString(), true, console.getStream());
				} catch (final IOException e) {
					throw new RuntimeException("Cannot process architecture file.", e);
				}
				return Status.OK_STATUS;
			}
		}.schedule();
		return null;
	}

}
