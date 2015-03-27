package hu.bme.mit.incqueryd.engine.rete.nodes;

import java.io.IOException;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.incquery.runtime.rete.recipes.CheckRecipe;
import org.eclipse.incquery.runtime.rete.recipes.ExpressionDefinition;
import org.eclipse.incquery.runtime.rete.recipes.RecipesPackage;
import org.eclipse.incquery.runtime.rete.recipes.ReteNodeRecipe;
import org.eclipse.incquery.runtime.rete.recipes.ReteRecipe;
import org.junit.Test;

public class ExpressionDefinitionTest {
	
	@Test
	public void test() throws IOException {
		final String filename = "PosLength.rdfiq.recipe";
		String path = getClass().getClassLoader().getResource(filename).getPath();

		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("recipe", new XMIResourceFactoryImpl());
		RecipesPackage.eINSTANCE.eClass();

		final ResourceSet resourceSet = new ResourceSetImpl();
		final Resource resource = resourceSet.getResource(URI.createFileURI(path), true);
		EcoreUtil.resolveAll(resource);

		final EObject o = resource.getContents().get(0);
		ReteRecipe recipe = (ReteRecipe) o;
		EList<ReteNodeRecipe> recipeNodes = recipe.getRecipeNodes();
		for (ReteNodeRecipe reteNodeRecipe : recipeNodes) {
			if (reteNodeRecipe instanceof CheckRecipe) {
				CheckRecipe cr = (CheckRecipe) reteNodeRecipe;
				System.out.println(cr);
				ExpressionDefinition e = cr.getExpression();
				System.out.println(e);
				final Object[] evaluator = (Object[]) e.getEvaluator();
				String expression = (String) evaluator[0];

				System.out.println(expression);
				
				EMap<String, Integer> mappedIndices = cr.getMappedIndices();
				System.out.println(mappedIndices);
			}
		}
		
		System.out.println();

	}
}
