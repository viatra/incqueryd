package hu.bme.mit.incqueryd.util;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.incquery.runtime.rete.recipes.RecipesPackage;
import org.eclipselabs.emfjson.EMFJs;
import org.eclipselabs.emfjson.resource.JsResourceFactoryImpl;

public class RecipeSerializer {

	protected static ResourceSet init() {
		final ResourceSet resourceSet = new ResourceSetImpl();
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("json", new JsResourceFactoryImpl());
		return resourceSet;
	}

	public static void serialize(final EObject eObject, final String modelFile) throws IOException {
		final ResourceSet resourceSet = init();
		final Resource resource = resourceSet.createResource(URI.createURI(modelFile));
		final Map<String, Object> options = new HashMap<String, Object>();

		options.put(EMFJs.OPTION_INDENT_OUTPUT, true);
		options.put(EMFJs.OPTION_SERIALIZE_TYPE, true);

		// options.put(EMFJs.OPTION_INDENT_OUTPUT, false);
		// options.put(EMFJs.OPTION_SERIALIZE_TYPE, false);

		resource.getContents().add(eObject);
		resource.save(options);
	}

	public static EObject deserialize(String filename) throws IOException {
		final ResourceSet resourceSet = init();
		final Map<String, Object> options = new HashMap<String, Object>();
		options.put(EMFJs.OPTION_ROOT_ELEMENT, RecipesPackage.eINSTANCE.getTrimmerRecipe());
		final Resource resource = resourceSet.createResource(URI.createURI(filename));
		resource.load(options);
		return resource.getContents().get(0);
	}

}
