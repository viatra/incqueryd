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
package hu.bme.mit.incqueryd.recipes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.incquery.runtime.rete.recipes.TypeInputRecipe;

public class RecipeProcessor {

	public static TypeInfo extractType(final TypeInputRecipe recipe) {
		final String patternString = "(.*)#(.*)";
		final Pattern pattern = Pattern.compile(patternString);
		final Matcher matcher = pattern.matcher(recipe.getTypeName());
		if (matcher.matches()) {
			final String ontologyIriPrefix = matcher.group(1);
			final String typeNameSuffix = matcher.group(2);
			return new TypeInfo(ontologyIriPrefix, typeNameSuffix);
		} else {
			throw new IllegalArgumentException("Type name in the TypeInputRecipe does not conform the pattern " + patternString + ".");
		}
	}

}
