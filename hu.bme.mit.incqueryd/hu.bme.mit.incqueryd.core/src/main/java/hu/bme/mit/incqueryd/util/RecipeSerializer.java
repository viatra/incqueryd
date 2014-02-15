package hu.bme.mit.incqueryd.util;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.incquery.runtime.rete.recipes.RecipesPackage;
import org.eclipselabs.emfjson.EMFJs;
import org.eclipselabs.emfjson.resource.JsResourceFactoryImpl;

public class RecipeSerializer {

	public static void serialize(final EObject eObject, final String modelFile) throws IOException {
		final ResourceSet resourceSet = new ResourceSetImpl();
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("json", new JsResourceFactoryImpl());

		final Resource resource = resourceSet.createResource(URI.createURI(modelFile));
		final Map<String, Object> options = new HashMap<String, Object>();

		options.put(EMFJs.OPTION_INDENT_OUTPUT, true);
		options.put(EMFJs.OPTION_SERIALIZE_TYPE, true);

		// options.put(EMFJs.OPTION_INDENT_OUTPUT, false);
		// options.put(EMFJs.OPTION_SERIALIZE_TYPE, false);

		resource.getContents().add(eObject);
		resource.save(options);
	}

	public static EObject deserialize(final String filename) throws IOException {
		final ResourceSet resourceSet = new ResourceSetImpl();
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("json", new JsResourceFactoryImpl());

		// This line is necessary to register the resource factory.
		// Without a resource factory, we would get the following exception:
		// java.lang.RuntimeException: Cannot create a resource for 'http://www.eclipse.org/incquery/rete/recipes'; a
		// registered resource factory is needed
		RecipesPackage.eINSTANCE.getReteRecipe();

		final Map<String, Object> options = new HashMap<String, Object>();

		final Resource resource = resourceSet.createResource(URI.createURI(filename));
		resource.load(options);

		return resource.getContents().get(0);
	}

	public static String serializeToString(final EObject eObject) throws IOException {
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("json", new JsResourceFactoryImpl());

		final File tempFile = File.createTempFile("recipe-", ".json");
		serialize(eObject, tempFile.getAbsolutePath());
		final String modelString = FileUtils.readFileToString(tempFile);

		return modelString;
	}

	public static EObject deserializeFromString(final String model) throws IOException {
		final File tempFile = File.createTempFile("recipe-", ".json");
		FileUtils.writeStringToFile(tempFile, model);

		return deserialize(tempFile.getPath());
	}

}
