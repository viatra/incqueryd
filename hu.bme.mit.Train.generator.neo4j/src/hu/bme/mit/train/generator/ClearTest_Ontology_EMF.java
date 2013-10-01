package hu.bme.mit.train.generator;

import hu.bme.mit.train.common.RuntimeConstants;
import hu.bme.mit.train.util.FileBroker;
import hu.bme.mit.train.util.FileCopy;

import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class ClearTest_Ontology_EMF {

	private static Resource resource;

	@BeforeClass
	public static void initModel() {

		// ************ BACKEND INIT ************

		URI resourceURI = FileBroker.getBigTestModelFile();
		ResourceSet resourceSet = new ResourceSetImpl();
		resource = resourceSet.getResource(resourceURI, true);


		FileCopy.copy(RuntimeConstants.modelProjectPath + "/models/testBig.owl.clear",
				RuntimeConstants.modelProjectPath + "/models/testBig.owl");
		// ************ TESTCASE related ************
		resource.getContents().clear();
	}

	@AfterClass
	public static void persistModel() {

		try {
			resource.save(null);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Test
	public void clearResource() {
		System.out.println("Resource contents cleared.");
	}

}
