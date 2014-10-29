package hu.bme.mit.incqueryd.tooling.ide;

import hu.bme.mit.incqueryd.csp.util.ReteAllocator;
import hu.bme.mit.incqueryd.tooling.ide.util.ArchitectureSelector;

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
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;

import com.google.common.base.Throwables;

public class NullAllocationHandler extends AbstractHandler {

	@Override
	public Object execute(final ExecutionEvent event) throws ExecutionException {
		new Job("Allocating Rete (no optimization)") {
			@Override
			protected IStatus run(IProgressMonitor monitor) {
				final IFile file = ArchitectureSelector.getSelection(event);
				String recipeFile = file.getLocation().toString();

				try {
					ReteAllocator.allocateNull(recipeFile, file.getProject().getLocation().toString() + "/arch-null/" + file.getName().replaceFirst("\\." + file.getFileExtension(), "") + ".arch");
				} catch (IOException e) {
					Throwables.propagate(e);
				}

				Shell activeShell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
				MessageDialog dialog = new MessageDialog(activeShell, "Allocation result", null, "Your arch file is ready in the arch-null folder!", MessageDialog.INFORMATION, new String[] { "OK" }, 0);
				dialog.open();
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
