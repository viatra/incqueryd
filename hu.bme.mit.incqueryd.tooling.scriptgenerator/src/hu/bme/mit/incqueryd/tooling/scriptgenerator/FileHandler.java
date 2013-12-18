package hu.bme.mit.incqueryd.tooling.scriptgenerator;

import java.io.ByteArrayInputStream;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.NullProgressMonitor;

/**
 * 
 * @author szarnyasg
 *
 */
public class FileHandler {

	public IPath writeFile(final IFile nextToFile, final String fileName,
			final CharSequence content) {
		System.out.println("Writing content to file " + fileName + ".");

		final IContainer parent = nextToFile.getParent();

		IFile file = null;
		if (parent instanceof IFolder) {
			final IFolder folder = (IFolder) parent;
			file = folder.getFile(fileName);

		} else if (parent instanceof IProject) {
			final IProject project = (IProject) parent;
			file = project.getFile(fileName);
		}

		if (file.exists()) {
			try {
				file.delete(true, new NullProgressMonitor());
			} catch (final CoreException e) {
				e.printStackTrace();
			}
		}
		try {
			file.create(
					new ByteArrayInputStream(content.toString().getBytes()),
					true, new NullProgressMonitor());
		} catch (final CoreException e) {
			e.printStackTrace();
		}
		
		return file.getRawLocation();
	}

}
