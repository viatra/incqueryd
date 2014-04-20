package hu.bme.mit.incqueryd.recipes;

import java.io.IOException;
import java.util.Collections;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.incquery.runtime.rete.recipes.JoinRecipe;
import org.eclipse.incquery.runtime.rete.recipes.ProjectionIndexerRecipe;
import org.eclipse.incquery.runtime.rete.recipes.RecipesFactory;
import org.eclipse.incquery.runtime.rete.recipes.RecipesPackage;
import org.junit.Test;

public class JoinRecipeSerializer {

	@Test
	public void serializeJoinRecipe() throws IOException {
		RecipesPackage.eINSTANCE.eClass();

		final Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
		final Map<String, Object> m = reg.getExtensionToFactoryMap();
		m.put("recipe", new XMIResourceFactoryImpl());

		final ResourceSet resSet = new ResourceSetImpl();
		final Resource resource = resSet.createResource(URI.createURI("join.recipe"));

		final JoinRecipe recipe = RecipesFactory.eINSTANCE.createJoinRecipe();
		final ProjectionIndexerRecipe leftParent = RecipesFactory.eINSTANCE.createProjectionIndexerRecipe();
		final ProjectionIndexerRecipe rightParent = RecipesFactory.eINSTANCE.createProjectionIndexerRecipe();
		recipe.setLeftParent(leftParent);
		recipe.setRightParent(rightParent);
		resource.getContents().add(recipe);
		resource.save(Collections.EMPTY_MAP);
	}
}
