package hu.bme.mit.incqueryd.recipes;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.incquery.runtime.rete.recipes.Mask;
import org.eclipse.incquery.runtime.rete.recipes.RecipesFactory;
import org.eclipse.incquery.runtime.rete.recipes.RecipesPackage;
import org.eclipse.incquery.runtime.rete.recipes.TrimmerRecipe;
import org.eclipselabs.emfjson.EMFJs;
import org.eclipselabs.emfjson.resource.JsResourceFactoryImpl;
import org.junit.Test;

public class JsonSerializationTest {

	private ResourceSet init() {
		final ResourceSet resourceSet = new ResourceSetImpl();
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("json", new JsResourceFactoryImpl());
		return resourceSet;
	}

	@Test
	public void serialize() throws IOException {
		System.out.println("Serialize.");

		final ResourceSet resourceSet = init();

		final TrimmerRecipe recipe = RecipesFactory.eINSTANCE.createTrimmerRecipe();
		final Mask mask = RecipesFactory.eINSTANCE.createMask();
		mask.getSourceIndices().addAll(Arrays.asList(2, 0, 3));
		recipe.setMask(mask);

		final Resource resource = resourceSet.createResource(URI.createURI("model.json"));
		final Map<String, Object> options = new HashMap<String, Object>();
//		options.put(EMFJs.OPTION_INDENT_OUTPUT, true);
		options.put(EMFJs.OPTION_INDENT_OUTPUT, false);
//		options.put(EMFJs.OPTION_SERIALIZE_TYPE, true);
		options.put(EMFJs.OPTION_SERIALIZE_TYPE, false);

		resource.getContents().add(recipe);
		resource.save(options);
		
		System.out.println();
	}

	@Test
	public void deserialize() throws IOException {
		System.out.println("Deserialize.");
		
		final ResourceSet resourceSet = init();

		final Map<String, Object> options = new HashMap<String, Object>();
		options.put(EMFJs.OPTION_ROOT_ELEMENT, RecipesPackage.eINSTANCE.getTrimmerRecipe());
		final Resource resource = resourceSet.createResource(URI.createURI("model.json"));
		resource.load(options);
		
		final TrimmerRecipe trimmerRecipe = (TrimmerRecipe)resource.getContents().get(0);
		
		
		System.out.println(trimmerRecipe.getMask());
		System.out.println();
	}

}
