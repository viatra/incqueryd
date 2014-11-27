/*******************************************************************************
 * Copyright (c) 2010-2014, Gabor Szarnyas, Istvan Rath and Daniel Varro
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * Gabor Szarnyas - initial API and implementation
 *******************************************************************************/
package hu.bme.mit.incqueryd.engine.util;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.emfjson.jackson.resource.JsonResourceFactory;

public class EObjectDeserializer {

	public static EObject deserializeFromFile(final String filename, Set<? extends EPackage> packages) throws IOException {
		final ResourceSet resourceSet = new ResourceSetImpl();
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("json", new JsonResourceFactory());

		final Map<String, Object> options = new HashMap<String, Object>();

		final Resource resource = resourceSet.createResource(URI.createURI(filename));
		resource.load(options);
		
		return resource.getContents().get(0);
	}

	public static EObject deserializeFromString(final String model, Set<? extends EPackage> packages) throws IOException {
		final File tempFile = EObjectSerializer.createTempFile();
		FileUtils.writeStringToFile(tempFile, model);
		return deserializeFromFile(tempFile.getPath(), packages);
	}

}
