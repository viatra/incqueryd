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
 * Class for writing the code generator's output to a file.
 * 
 * @author szarnyasg
 * 
 */
public class FileHandler {

    /**
     * 
     * @param neighborFile
     * @param fileName
     * @param content
     * @return
     */
    public static IPath writeFileToProject(final IFile neighborFile, final String fileName, final CharSequence content) {
        System.out.println("Writing content to file " + fileName + ".");

        final IFile file = generateFileHandle(neighborFile, fileName);
        try {
            file.create(new ByteArrayInputStream(content.toString().getBytes()), true, new NullProgressMonitor());
        } catch (final CoreException e) {
            e.printStackTrace();
        }

        return file.getRawLocation();
    }

    public static IFile generateFileHandle(final IFile neighborFile, final String fileName) {
        final IContainer parent = neighborFile.getParent();

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
        return file;
    }

}
