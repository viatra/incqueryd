package hu.bme.mit.incqueryd.tooling.ide.util;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.resources.IFile;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;

public class ArchitectureSelector {
	public static IFile getSelection(final ExecutionEvent event) {
		final ISelection sel = HandlerUtil.getActiveMenuSelection(event);
		final IStructuredSelection selection = (IStructuredSelection) sel;
		final Object firstElement = selection.getFirstElement();

		if (firstElement instanceof IFile) {
			final IFile file = (IFile) firstElement;
			return file;
		} else {
			final String message = "The selected element is not an architecture file.";
			showErrorMessage(message);
			throw new RuntimeException(message);
		}
	}

	protected static void showErrorMessage(final String errorMessage) {
		final MessageDialog messageDialog = new MessageDialog(null, "Error during code transformation", null,
				errorMessage, MessageDialog.ERROR, new String[] { "Ok" }, 0);
		messageDialog.open();
	}


}
