package hu.bme.mit.incqueryd.tooling.ide;

import hu.bme.mit.incqueryd.csp.util.ReteAllocator;
import hu.bme.mit.incqueryd.tooling.ide.util.ArchitectureSelector;
import hu.bme.mit.incqueryd.tooling.ide.util.UiUtils;

import java.io.IOException;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import com.google.common.base.Throwables;

public class LocalAllocationHandler extends AbstractHandler {

	private static final String FOLDER_NAME = "arch-local";

	@Override
	public Object execute(final ExecutionEvent event) throws ExecutionException {
		final IFile file = ArchitectureSelector.getSelection(event);
		new Job("Allocating Rete to local machine") {
			@Override
			protected IStatus run(IProgressMonitor monitor) {
				String recipeFile = file.getLocation().toString();

				try {
					ReteAllocator.allocateUnoptimized(recipeFile, file.getProject().getLocation().toString() + "/" + FOLDER_NAME + "/" + file.getName().replaceFirst("\\." + file.getFileExtension(), "") + ".arch");
				} catch (IOException e) {
					Throwables.propagate(e);
				}

				Shell activeShell = UiUtils.getWorkbenchWindow().getShell();
				final MessageDialog dialog = new MessageDialog(activeShell, "Allocation result", null, "Your arch file is ready in the " + FOLDER_NAME + " folder!", MessageDialog.INFORMATION, new String[] { "OK" }, 0);
				Display.getDefault().asyncExec(new Runnable() {
					@Override
					public void run() {
						dialog.open();
					}
				});
				try {
					file.getProject().refreshLocal(IResource.DEPTH_INFINITE, monitor);
				} catch (CoreException e) {
					Throwables.propagate(e);
				}
				return Status.OK_STATUS;
			}
		}.schedule();
		return null;
	}

}
