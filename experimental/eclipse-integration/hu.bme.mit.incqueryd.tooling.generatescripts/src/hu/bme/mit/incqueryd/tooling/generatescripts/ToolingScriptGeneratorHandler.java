package hu.bme.mit.incqueryd.tooling.generatescripts;

import hu.bme.mit.incqueryd.tooling.scriptgenerator.Generator;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;

import arch.Configuration;

public class ToolingScriptGeneratorHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		ISelection sel = HandlerUtil.getActiveMenuSelection(event);
		IStructuredSelection selection = (IStructuredSelection) sel;

		Object firstElement = selection.getFirstElement();

		if (firstElement instanceof IFile) {
			IFile file = (IFile) firstElement;
			ResourceSet resSet = new ResourceSetImpl();
			URI uri = URI.createPlatformResourceURI(file.getFullPath()
					.toString(), true);

//			try {
				Resource resource = resSet.getResource(uri, true);
				EObject root = resource.getContents().get(0);

				if (root instanceof Configuration) {
					Configuration configuration = (Configuration) root;

					System.out.println(file + " " + root);

					Generator generator = new Generator();
					generator.generateScripts(file, configuration);
					
				} else {
					showErrorMessage("Not a configuration file.");
				}
				
//			} catch (RuntimeException e) {
//				showErrorMessage("The selected element is not an eResource.");
//			}
		} else {
			showErrorMessage("The selected element is not a file.");
		}
		return null;
	}

	public static void showErrorMessage(String errorMessage) {
		MessageDialog messageDialog = new MessageDialog(null,
				"Error during code generation", null, errorMessage,
				MessageDialog.ERROR, new String[] { "Ok" }, 0);
		messageDialog.open();
	}
}