package hu.bme.mit.incqueryd.recipes;

import static org.junit.Assert.assertEquals;

import org.eclipse.incquery.runtime.rete.recipes.BinaryInputRecipe;
import org.eclipse.incquery.runtime.rete.recipes.RecipesFactory;
import org.junit.Test;

public class ExtractTypeName {
	
	@Test
	public void extractTypeName() {
		 RecipesFactory.eINSTANCE.eClass();
		 final BinaryInputRecipe recipe = RecipesFactory.eINSTANCE.createBinaryInputRecipe();
		 recipe.setTypeName("http://www.semanticweb.org/ontologies/2011/1/TrainRequirementOntology.owl#Route_routeDefinition");
		 final TypeInfo extractType = RecipeProcessor.extractType(recipe);
		 assertEquals("http://www.semanticweb.org/ontologies/2011/1/TrainRequirementOntology.owl", extractType.ontologyIri());
		 assertEquals("Route_routeDefinition", extractType.typeNameSuffix());
	}
	
}
