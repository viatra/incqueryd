package hu.bme.mit.incqueryd.tooling.ide;

import hu.bme.mit.incqueryd.arch.install.ArchitectureInstaller;
import hu.bme.mit.incqueryd.tooling.ide.util.ArchitectureSelector;

import java.io.IOException;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;

public class DestroyArchitectureHandler extends AbstractHandler {

	@Override
	public Object execute(final ExecutionEvent event) throws ExecutionException {
		final IFile file = ArchitectureSelector.getSelection(event);
		try {
			ArchitectureInstaller.destroyArchitecture(file.getLocation().toString());
		} catch (final IOException e) {
			throw new ExecutionException("Cannot process architecture file.", e);
		}
		return null;
	}

}
