package hu.bme.mit.incqueryd.tooling.ide;

import hu.bme.mit.incqueryd.tooling.ide.dialogs.OptimizationObjectiveFunctionDialog;
import hu.bme.mit.incqueryd.tooling.ide.util.ArchitectureSelector;
import hu.bme.mit.incqueryd.tooling.ide.util.ReteAllocator;

import java.io.IOException;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;

public class OptimizedAllocationHandler extends AbstractHandler{

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		final IFile file = ArchitectureSelector.getSelection(event);
		String recipeFile = file.getLocation().toString();
		
		
		Shell activeShell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
		
		// Pop up a dialog to ask for an inventory file
		FileDialog fd = new FileDialog(activeShell, SWT.OPEN);
		fd.setText("Choose Inventory file");
		fd.setFilterPath(file.getProject().getLocation().toString());
		String[] filterExt = { "*.inventory" };
        fd.setFilterExtensions(filterExt);
        String inventoryFile = fd.open();
        
        // Pop up objective function selection dialog
        OptimizationObjectiveFunctionDialog ofDialog = new OptimizationObjectiveFunctionDialog(activeShell);
        ofDialog.open();
        boolean forCommunication = ofDialog.forCommunication();
        
        final String outputFile = file.getProject().getLocation().toString() + "/arch-opt/" + file.getName().replaceFirst("\\." + file.getFileExtension(), "") + ".arch";
		
        ReteAllocator reteAllocator = new ReteAllocator(forCommunication, recipeFile, inventoryFile, outputFile);
        try {
			boolean success = reteAllocator.allocate();
			
			if(success) {
				MessageDialog dialog = new MessageDialog(activeShell, "Allocation result", null,
					    "Your arch file is ready in the arch-opt folder!", MessageDialog.INFORMATION, new String[] {"OK"}, 0);
				dialog.open();
			}
			else {
				MessageDialog dialog = new MessageDialog(activeShell, "Allocation result", null,
					    "The problem can not be solved with the current resource set!", MessageDialog.ERROR, new String[] {"OK"}, 0);
				dialog.open();
			}
		} catch (IOException e) {
			
		}
        
		return null;
	}

}
