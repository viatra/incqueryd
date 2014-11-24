package hu.bme.mit.incqueryd.tooling.ide;

import hu.bme.mit.incqueryd.csp.util.ReteAllocator;
import hu.bme.mit.incqueryd.tooling.ide.dialogs.OptimizationObjectiveFunctionDialog;
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
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;

import com.google.common.base.Throwables;

public class InfrastructureAllocationHandler extends AbstractHandler {

	private static final String FOLDER_NAME = "arch";

	@Override
	public Object execute(final ExecutionEvent event) throws ExecutionException {
		final IFile file = ArchitectureSelector.getSelection(event);
		final String recipeFile = file.getLocation().toString();

		final Shell activeShell = UiUtils.getWorkbenchWindow().getShell();

		// Pop up a dialog to ask for an inventory file
		FileDialog fd = new FileDialog(activeShell, SWT.OPEN);
		fd.setText("Choose Inventory file");
		fd.setFilterPath(file.getProject().getLocation().toString());
		String[] filterExt = { "*.inventory" };
		fd.setFilterExtensions(filterExt);
		final String inventoryFile = fd.open();

		new Job("Allocating Rete to infrastructure") {
			@Override
			protected IStatus run(IProgressMonitor monitor) {

				// Pop up objective function selection dialog
				final OptimizationObjectiveFunctionDialog ofDialog = new OptimizationObjectiveFunctionDialog(activeShell);
				Display.getDefault().syncExec(new Runnable() {
					@Override
					public void run() {
						ofDialog.open();
					}
				});
				boolean forCommunication = ofDialog.forCommunication();

				final String outputFile = file.getProject().getLocation().toString() + "/" + FOLDER_NAME + "/" + file.getName().replaceFirst("\\." + file.getFileExtension(), "") + ".arch";

				ReteAllocator reteAllocator = new ReteAllocator(forCommunication, recipeFile, inventoryFile, outputFile);
				try {
					boolean success = reteAllocator.allocate();

					final MessageDialog dialog = success ?
						new MessageDialog(activeShell, "Allocation result", null, "Your arch file is ready in the " + FOLDER_NAME + " folder!", MessageDialog.INFORMATION, new String[] { "OK" }, 0) :
						new MessageDialog(activeShell, "Allocation result", null, "The allocation can not be solved with the current resource set!", MessageDialog.ERROR, new String[] { "OK" }, 0);
					Display.getDefault().asyncExec(new Runnable() {
						@Override
						public void run() {
							dialog.open();
						}
					});
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
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
