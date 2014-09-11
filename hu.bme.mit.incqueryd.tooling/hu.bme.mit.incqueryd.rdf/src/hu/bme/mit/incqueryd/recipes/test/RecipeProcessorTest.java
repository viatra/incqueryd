package hu.bme.mit.incqueryd.recipes.test;

import static org.junit.Assert.assertEquals;
import hu.bme.mit.incqueryd.recipes.RecipeProcessor;
import hu.bme.mit.incqueryd.recipes.TypeInfo;

import org.eclipse.incquery.runtime.rete.recipes.BinaryInputRecipe;
import org.eclipse.incquery.runtime.rete.recipes.RecipesFactory;
import org.junit.Test;

public class RecipeProcessorTest {
	
	@Test
	public void extractTypeName() {
		 RecipesFactory.eINSTANCE.eClass();
		 final BinaryInputRecipe recipe = RecipesFactory.eINSTANCE.createBinaryInputRecipe();
		 recipe.setTypeName("http://www.semanticweb.org/ontologies/2011/1/TrainRequirementOntology.owl#Route_routeDefinition");
		 final TypeInfo extractType = RecipeProcessor.extractType(recipe);
		 assertEquals("http://www.semanticweb.org/ontologies/2011/1/TrainRequirementOntology.owl", extractType.getOntologyIri());
		 assertEquals("Route_routeDefinition", extractType.getTypeNameSuffix());
	}
	
}
