package hu.bme.mit.incqueryd.tooling.ide;

import hu.bme.mit.incqueryd.tooling.ide.util.ArchitectureSelector;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
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
        String selected = fd.open();
        
        System.out.println(selected);
		
        
		return null;
	}

}
