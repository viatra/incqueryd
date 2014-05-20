package org.eclipse.incquery.patternlanguage.rdf.generator.recipe;

import static com.google.common.base.Throwables.propagate;
import static com.google.common.collect.ImmutableList.copyOf;
import static com.google.common.collect.Iterables.filter;

import java.io.IOException;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.incquery.patternlanguage.patternLanguage.Pattern;
import org.eclipse.incquery.patternlanguage.rdf.psystem.RdfPModel;
import org.eclipse.incquery.patternlanguage.rdf.psystem.RdfPQuery;
import org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.RdfPatternModel;
import org.eclipse.incquery.runtime.matchers.planning.QueryPlannerException;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PQuery;
import org.eclipse.incquery.runtime.rete.construction.plancompiler.ReteRecipeCompiler;
import org.eclipse.incquery.runtime.rete.recipes.RecipesFactory;
import org.eclipse.incquery.runtime.rete.recipes.ReteNodeRecipe;
import org.eclipse.incquery.runtime.rete.recipes.ReteRecipe;
import org.eclipse.incquery.runtime.rete.util.Options;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.generator.IGenerator;

public class RecipeGenerator implements IGenerator {

	@Override
	public void doGenerate(Resource input, IFileSystemAccess fsa) {
		ReteRecipe recipe = RecipesFactory.eINSTANCE.createReteRecipe();
		for (RdfPatternModel patternModel : filter(input.getContents(), RdfPatternModel.class)) {
			RdfPModel model = new RdfPModel(patternModel);
			ReteRecipeCompiler compiler = new ReteRecipeCompiler(Options.builderMethod.layoutStrategy(), model.context);
			for (Pattern pattern : filter(copyOf(input.getAllContents()), Pattern.class)) {
				PQuery query = new RdfPQuery(pattern, model);
				try {
					ReteNodeRecipe nodeRecipe = compiler.getCompiledForm(query).getRecipe();
					recipe.getRecipeNodes().add(nodeRecipe);
				} catch (QueryPlannerException e) {
					propagate(e);
				}
			}
		}
		try {
			String contents = EmfXmlConverter.convertToXml(recipe);
			fsa.generateFile("recipe.xmi", contents);
		} catch (IOException e) {
			propagate(e);
		}
	}

}
