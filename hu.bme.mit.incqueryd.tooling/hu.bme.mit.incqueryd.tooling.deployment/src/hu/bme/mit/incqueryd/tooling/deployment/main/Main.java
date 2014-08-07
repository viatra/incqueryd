package hu.bme.mit.incqueryd.tooling.deployment.main;

import hu.bme.mit.incqueryd.tooling.deployment.util.ArchitectureInstaller;

import java.io.IOException;

public class Main {

	public static void main(final String[] args) throws IOException {
		final String architectureFile = "../../hu.bme.mit.incqueryd.queries/arch/posLength.arch";
		ArchitectureInstaller.processArchitecture(architectureFile);
	}
	
}
