package org.eclipse.incquery.patternlanguage.rdf.generator.recipe;

import java.io.IOException;
import java.io.StringReader;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceImpl;
import org.eclipse.emf.ecore.xmi.util.XMLProcessor;
import org.xml.sax.InputSource;

public class EmfXmlConverter {

	public static EObject convertToEObject(String xmlString) throws IOException {
		XMLResourceImpl resource = new XMLResourceImpl();
		resource.setEncoding("UTF-8");
		resource.load(new InputSource(new StringReader(xmlString)), null);
		return resource.getContents().get(0);
	}

	public static String convertToXml(EObject eObject) throws IOException {
		XMLResourceImpl resource = new XMLResourceImpl();
		XMLProcessor processor = new XMLProcessor();
		resource.setEncoding("UTF-8");
		resource.getContents().add(eObject);
		return processor.saveToString(resource, null);
	}

}