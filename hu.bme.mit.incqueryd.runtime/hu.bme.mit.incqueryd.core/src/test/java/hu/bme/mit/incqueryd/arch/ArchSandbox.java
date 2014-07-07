package hu.bme.mit.incqueryd.arch;

import infrastructure.InfrastructurePackage;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.incquery.runtime.rete.recipes.RecipesPackage;
import org.junit.Test;

import arch.ArchPackage;

public class ArchSandbox {

	@Test
	public void test() {
		// initialize extension to factory map
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("arch", new XMIResourceFactoryImpl());

		// initialize package registry
		// initialize the RecipesPackage before the others
		RecipesPackage.eINSTANCE.eClass();
		InfrastructurePackage.eINSTANCE.eClass();
		ArchPackage.eINSTANCE.eClass();

		// load resource
		final ResourceSet resourceSet = new ResourceSetImpl();
		final String architectureFile = "/home/szarnyasg/git/mondo-trainbenchmark/src/hu.bme.mit.trainbenchmark.benchmark.incqueryd/src/test/resources/arch-localvm/routesensor.arch";
//		final Resource resource = resourceSet.getResource(URI.createFileURI(architectureFile), true);
//		 traverse model
//		final EObject o = resource.getContents().get(0);
//		System.out.println(o);
	}
}
