package hu.bme.mit.incqueryd.tooling.ide;

import hu.bme.mit.incqueryd.arch.install.ArchitectureInstaller;
import hu.bme.mit.incqueryd.tooling.ide.util.ArchitectureSelector;

import java.io.IOException;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;

public class UninstallArchitectureHandler extends AbstractHandler {

	@Override
	public Object execute(final ExecutionEvent event) throws ExecutionException {
		new Job("Uninstalling architecture") {
			@Override
			protected IStatus run(IProgressMonitor monitor) {
				final IFile file = ArchitectureSelector.getSelection(event);
				try {
					ArchitectureInstaller.uninstallArchitecture(file.getLocation().toString());
				} catch (final IOException e) {
					throw new RuntimeException("Cannot process architecture file.", e);
				}
				return Status.OK_STATUS;
			}
		}.schedule();
		return null;
	}

}
