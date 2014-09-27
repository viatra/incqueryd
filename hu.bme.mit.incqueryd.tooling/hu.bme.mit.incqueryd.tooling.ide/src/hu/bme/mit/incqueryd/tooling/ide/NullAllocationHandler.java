package hu.bme.mit.incqueryd.tooling.ide;

import hu.bme.mit.incqueryd.tooling.ide.util.ArchitectureSelector;
import hu.bme.mit.incqueryd.tooling.ide.util.ReteAllocator;

import java.io.IOException;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;

public class NullAllocationHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		final IFile file = ArchitectureSelector.getSelection(event);
		String recipeFile = file.getLocation().toString();
		
		try {
			ReteAllocator.allocateNull(recipeFile, file.getProject().getLocation().toString() + "/arch-null/" + file.getName().replaceFirst("\\." + file.getFileExtension(), "") + ".arch");
		} catch (IOException e) {
			
		}
		
		Shell activeShell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
		MessageDialog dialog = new MessageDialog(activeShell, "Allocation result", null,
			    "Your arch file is ready in the arch-null folder!", MessageDialog.INFORMATION, new String[] {"OK"}, 0);
		dialog.open();

		return null;
	}

}
