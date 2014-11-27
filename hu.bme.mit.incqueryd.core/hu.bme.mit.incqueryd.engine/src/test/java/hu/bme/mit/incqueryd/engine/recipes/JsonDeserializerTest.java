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
package hu.bme.mit.incqueryd.engine.recipes;

import hu.bme.mit.incqueryd.engine.util.RecipeDeserializer;

import java.io.IOException;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.incquery.runtime.rete.recipes.JoinRecipe;
import org.junit.Test;

public class JsonDeserializerTest {
	@Test
	public void deserialize() throws IOException {		
		final EObject eObject = RecipeDeserializer.deserializeFromFile("src/test/resources/recipe.json");
		System.out.println(eObject);
	}
	
	@Test
	public void deserializeFromStringTest() throws IOException {
		final String model = "{\n" + "  \"eClass\" : \"http://www.eclipse.org/incquery/rete/recipes#//JoinRecipe\",\n"
				+ "  \"leftParent\" : {\n"
				+ "    \"eClass\" : \"http://www.eclipse.org/incquery/rete/recipes#//ProjectionIndexer\",\n"
				+ "    \"mask\" : {\n"
				+ "      \"eClass\" : \"http://www.eclipse.org/incquery/rete/recipes#//Mask\",\n"
				+ "      \"sourceIndices\" : [ 2 ]\n" + "    }\n" + "  },\n" + "  \"rightParent\" : {\n"
				+ "    \"eClass\" : \"http://www.eclipse.org/incquery/rete/recipes#//ProjectionIndexerRecipe\",\n"
				+ "    \"mask\" : {\n"
				+ "      \"eClass\" : \"http://www.eclipse.org/incquery/rete/recipes#//Mask\",\n"
				+ "      \"sourceIndices\" : [ 0 ]\n" + "    }\n" + "  }\n" + "}";
		final EObject eObject = RecipeDeserializer.deserializeFromString(model);
		final JoinRecipe recipe =  (JoinRecipe) eObject;
		System.out.println(recipe.getLeftParent().getMask().getSourceIndices());
		System.out.println(recipe.getRightParent().getMask().getSourceIndices());
	}
}
