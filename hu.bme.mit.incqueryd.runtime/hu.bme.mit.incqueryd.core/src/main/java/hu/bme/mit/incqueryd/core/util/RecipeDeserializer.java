package hu.bme.mit.incqueryd.core.util;

import java.io.IOException;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.incquery.runtime.rete.recipes.RecipesPackage;

import com.google.common.collect.ImmutableSet;

public class RecipeDeserializer {

	private static final ImmutableSet<RecipesPackage> RECIPE_PACKAGES = ImmutableSet.of(RecipesPackage.eINSTANCE);

	public static EObject deserializeFromFile(final String filename) throws IOException {
		return EObjectDeserializer.deserializeFromFile(filename, RECIPE_PACKAGES);
	}

	public static EObject deserializeFromString(final String model) throws IOException {
		return EObjectDeserializer.deserializeFromString(model, RECIPE_PACKAGES);
	}

}
