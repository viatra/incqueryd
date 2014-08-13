package hu.bme.mit.incqueryd.tooling.deployment;

import hu.bme.mit.incqueryd.tooling.deployment.util.ArchitectureInstaller;

import java.io.IOException;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;

public class InstallArchitectureHandler extends AbstractHandler {

	@Override
	public Object execute(final ExecutionEvent event) throws ExecutionException {
		final ISelection sel = HandlerUtil.getActiveMenuSelection(event);
		final IStructuredSelection selection = (IStructuredSelection) sel;

		final Object firstElement = selection.getFirstElement();

		if (firstElement instanceof IFile) {
			final IFile file = (IFile) firstElement;
			
			try {
				ArchitectureInstaller.installArchitecture(file);
			} catch (final IOException e) {
				throw new ExecutionException("Cannot process architecture file.", e);
			}
		} else {
			showErrorMessage("The selected element is not an architecture file.");
		}		
		
		return null;
	}

	public static void showErrorMessage(final String errorMessage) {
		final MessageDialog messageDialog = new MessageDialog(null, "Error during code transformation", null,
				errorMessage, MessageDialog.ERROR, new String[] { "Ok" }, 0);
		messageDialog.open();
	}

}
