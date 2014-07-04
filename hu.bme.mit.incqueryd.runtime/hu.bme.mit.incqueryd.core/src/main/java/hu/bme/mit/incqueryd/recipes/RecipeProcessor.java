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
			final String ontologyIri = matcher.group(1);
			final String typeNameSuffix = matcher.group(2);
			return new TypeInfo(ontologyIri, typeNameSuffix);
		} else {
			throw new IllegalArgumentException("Type name in the TypeInputRecipe does not conform the pattern " + patternString + ".");
		}
	}

}
