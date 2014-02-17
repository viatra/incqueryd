package hu.bme.mit.incqueryd.arch;

import infrastructure.InfrastructurePackage;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.incquery.runtime.rete.recipes.RecipesPackage;
import org.junit.Test;

import arch.ArchPackage;
import arch.Configuration;

public class ArchTest {


	@Test
	public void test() {
		// initialize extension to factory map
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("arch", new XMIResourceFactoryImpl());

		// initialize package registry
		// initialize the RecipesPackage before the others
		RecipesPackage.eINSTANCE.eClass();
		InfrastructurePackage.eINSTANCE.eClass();
		ArchPackage.eINSTANCE.eClass();
		
		final String architectureFile = "src/test/resources/arch/routeSensor.arch";
		
		// load resource
		final ResourceSet rs = new ResourceSetImpl();
		final Resource res = rs.getResource(URI.createFileURI(architectureFile), true);

		// traverse model
		final EObject o = res.getContents().get(0);

		if (o instanceof Configuration) {
			System.out.println(o);
		}

	}

}