package org.eclipse.incquery.patternlanguage.rdf.generator.recipe;

import static com.google.common.base.Throwables.propagate;
import static com.google.common.collect.ImmutableList.copyOf;
import static com.google.common.collect.Iterables.filter;

import java.io.IOException;
import java.util.Set;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceImpl;
import org.eclipse.emf.ecore.xmi.util.XMLProcessor;
import org.eclipse.incquery.patternlanguage.patternLanguage.Pattern;
import org.eclipse.incquery.patternlanguage.rdf.psystem.RdfPModel;
import org.eclipse.incquery.patternlanguage.rdf.psystem.RdfPQuery;
import org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.RdfPatternModel;
import org.eclipse.incquery.runtime.matchers.planning.QueryPlannerException;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PQuery;
import org.eclipse.incquery.runtime.rete.construction.plancompiler.ReteRecipeCompiler;
import org.eclipse.incquery.runtime.rete.recipes.ProductionRecipe;
import org.eclipse.incquery.runtime.rete.recipes.RecipesFactory;
import org.eclipse.incquery.runtime.rete.recipes.ReteNodeRecipe;
import org.eclipse.incquery.runtime.rete.recipes.ReteRecipe;
import org.eclipse.incquery.runtime.rete.traceability.CompiledQuery;
import org.eclipse.incquery.runtime.rete.traceability.RecipeTraceInfo;
import org.eclipse.incquery.runtime.rete.util.Options;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.generator.IGenerator;

import com.google.common.collect.Sets;

public class RecipeGenerator implements IGenerator {

	@Override
	public void doGenerate(Resource input, IFileSystemAccess fsa) {
		XMLProcessor xmlProcessor = new XMLProcessor();
		for (RdfPatternModel patternModel : filter(input.getContents(), RdfPatternModel.class)) {
			XMLResourceImpl resource = new XMLResourceImpl();
			resource.setEncoding("UTF-8");
			ReteRecipe recipe = RecipesFactory.eINSTANCE.createReteRecipe();
			resource.getContents().add(recipe);
			RdfPModel model = new RdfPModel(patternModel);
			ReteRecipeCompiler compiler = new ReteRecipeCompiler(Options.builderMethod.layoutStrategy(), model.context);
			for (Pattern pattern : filter(copyOf(input.getAllContents()), Pattern.class)) {
				PQuery query = new RdfPQuery(pattern, model);
				try {
					CompiledQuery compiledQuery = compiler.getCompiledForm(query);
					for (ReteNodeRecipe nodeRecipe : collectRecipes(compiledQuery)) {
						processForSerialization(recipe, nodeRecipe);
					}
				} catch (QueryPlannerException e) {
					propagate(e);
				}
			}
			try {
				String contents = xmlProcessor.saveToString(resource, null);
				fsa.generateFile(input.getURI().trimFileExtension().lastSegment() + ".xmi", contents);
			} catch (IOException e) {
				propagate(e);
			}
		}
	}

	private void processForSerialization(ReteRecipe recipe,	ReteNodeRecipe nodeRecipe) { // XXX
		recipe.getRecipeNodes().add(nodeRecipe);
		if (nodeRecipe instanceof ProductionRecipe) {
			ProductionRecipe productionRecipe = (ProductionRecipe)nodeRecipe;
			productionRecipe.setPattern(null);
		}
	}

	private Set<ReteNodeRecipe> collectRecipes(RecipeTraceInfo recipeTraceInfo) {
		Set<ReteNodeRecipe> result = Sets.newHashSet();
		ReteNodeRecipe nodeRecipe = recipeTraceInfo.getRecipe();
		result.add(nodeRecipe);
		for (RecipeTraceInfo parentRecipeTrace : recipeTraceInfo.getParentRecipeTraces()) {
			Set<ReteNodeRecipe> parentRecipes = collectRecipes(parentRecipeTrace);
			parentRecipes.removeAll(nodeRecipe.eContents());
			result.addAll(parentRecipes);
		}
		return result;
	}

}
