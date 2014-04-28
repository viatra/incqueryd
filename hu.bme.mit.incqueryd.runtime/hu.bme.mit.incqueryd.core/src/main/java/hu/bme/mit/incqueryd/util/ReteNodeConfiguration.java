package hu.bme.mit.incqueryd.util;

import java.io.IOException;
import java.io.Serializable;
import java.util.Collection;

import org.eclipse.incquery.runtime.rete.recipes.ReteNodeRecipe;

public class ReteNodeConfiguration implements Serializable {

	private static final long serialVersionUID = 1L;
	protected String recipeString;
	protected Collection<String> cacheMachines; 

	public ReteNodeConfiguration(final String recipeString, final Collection<String> cacheMachines) {
		super();
		this.recipeString = recipeString;
		this.cacheMachines = cacheMachines;
	}

	public String getRecipeString() {
		return recipeString;
	}
	
	public Collection<String> getCacheMachines() {
		return cacheMachines;
	}
	
	public ReteNodeRecipe getReteNodeRecipe() throws IOException {
		return (ReteNodeRecipe) RecipeDeserializer.deserializeFromString(getRecipeString());	
	}
}
