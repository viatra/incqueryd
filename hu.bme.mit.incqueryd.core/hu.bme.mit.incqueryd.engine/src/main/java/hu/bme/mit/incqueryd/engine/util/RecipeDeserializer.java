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
package hu.bme.mit.incqueryd.engine.util;

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
