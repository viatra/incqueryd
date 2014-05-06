package hu.bme.mit.incqueryd.tooling.core;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectNature;
import org.eclipse.core.runtime.CoreException;

public class IqdProjectNature implements IProjectNature {

	public static final String NATURE_ID = "hu.bme.mit.incqueryd.tooling.core.natures.iqd";

	private IProject project;

	public IProject getProject() {
		return project;
	}

	public void setProject(IProject project) {
		this.project = project;
	}

	public void configure() throws CoreException {
	}

	public void deconfigure() throws CoreException {
	}

}
