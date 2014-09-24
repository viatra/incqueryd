package hu.bme.mit.incqueryd.tooling.ide;

import hu.bme.mit.incqueryd.tooling.ide.util.ArchitectureSelector;
import hu.bme.mit.incqueryd.tooling.ide.util.ReteAllocator;

import java.io.IOException;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;

public class NullAllocationHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		final IFile file = ArchitectureSelector.getSelection(event);
		String recipeFile = file.getLocation().toString();
		
		try {
			ReteAllocator.allocateNull(recipeFile, file.getProject().getLocation().toString() + "/arch-null/" + file.getName().replaceFirst("\\." + file.getFileExtension(), "") + ".arch");
		} catch (IOException e) {
			
		}

		return null;
	}

}
