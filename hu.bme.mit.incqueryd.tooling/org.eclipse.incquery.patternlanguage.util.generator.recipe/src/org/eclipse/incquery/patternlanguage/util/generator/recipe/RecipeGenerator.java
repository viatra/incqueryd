package org.eclipse.incquery.patternlanguage.util.generator.recipe;

import static com.google.common.base.Throwables.propagate;
import static com.google.common.collect.ImmutableList.copyOf;
import static com.google.common.collect.Iterables.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceImpl;
import org.eclipse.emf.ecore.xmi.util.XMLProcessor;
import org.eclipse.incquery.patternlanguage.patternLanguage.Pattern;
import org.eclipse.incquery.patternlanguage.patternLanguage.PatternModel;
import org.eclipse.incquery.runtime.matchers.context.IPatternMatcherContext;
import org.eclipse.incquery.runtime.matchers.planning.QueryPlannerException;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PQuery;
import org.eclipse.incquery.runtime.rete.construction.plancompiler.ReteRecipeCompiler;
import org.eclipse.incquery.runtime.rete.recipes.RecipesFactory;
import org.eclipse.incquery.runtime.rete.recipes.ReteNodeRecipe;
import org.eclipse.incquery.runtime.rete.recipes.ReteRecipe;
import org.eclipse.incquery.runtime.rete.traceability.CompiledQuery;
import org.eclipse.incquery.runtime.rete.traceability.RecipeTraceInfo;
import org.eclipse.incquery.runtime.rete.util.Options;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.generator.IGenerator;

import com.google.common.collect.Sets;

public abstract class RecipeGenerator<CustomPatternModel extends PatternModel, PModel, Metamodel> implements IGenerator {

	protected abstract Class<? extends CustomPatternModel> getPatternModelClass();

	protected abstract PModel getPModel(CustomPatternModel patternModel);

	protected abstract IPatternMatcherContext getPatternMatcherContext(PModel model);

	protected abstract PQuery getPQuery(Pattern pattern, PModel model);

	protected abstract Metamodel getMetamodel(CustomPatternModel patternModel);

	protected abstract void processForSerialization(ReteRecipe recipe, ReteNodeRecipe nodeRecipe, Metamodel metamodel, int recipeIndex);

	@Override
	public void doGenerate(Resource input, IFileSystemAccess fsa) {
		int recipeIndex = 0;
		for (CustomPatternModel patternModel : filter(input.getContents(), getPatternModelClass())) {
			ReteRecipe recipe = RecipesFactory.eINSTANCE.createReteRecipe();
			PModel model = getPModel(patternModel);
			ReteRecipeCompiler compiler = new ReteRecipeCompiler(Options.builderMethod.layoutStrategy(), getPatternMatcherContext(model));
			Metamodel metamodel = getMetamodel(patternModel);
			ArrayList<CompiledQuery> compiledQueries = new ArrayList<>();
			for (Pattern pattern : filter(copyOf(input.getAllContents()), Pattern.class)) {
				PQuery query = getPQuery(pattern, model);
				try {
					CompiledQuery compiledQuery = compiler.getCompiledForm(query);
					compiledQueries.add(compiledQuery);
				} catch (QueryPlannerException e) {
					propagate(e);
				}
			}
			Set<ReteNodeRecipe> collectedRecipes = new HashSet<>();
			for (CompiledQuery compiledQuery : compiledQueries) {
				collectedRecipes.addAll(collectRecipes(compiledQuery));
			}
			for (ReteNodeRecipe nodeRecipe : collectedRecipes) {
				recipe.getRecipeNodes().add(nodeRecipe);
				processForSerialization(recipe, nodeRecipe, metamodel, recipeIndex);
				recipeIndex++;
			}
			try {
				XMLResourceImpl resource = new XMLResourceImpl();
				resource.setEncoding("UTF-8");
				resource.getContents().add(recipe);
				XMLProcessor xmlProcessor = new XMLProcessor();
				String contents = xmlProcessor.saveToString(resource, null);
				fsa.generateFile(input.getURI().appendFileExtension("recipe").lastSegment(), contents);
			} catch (IOException e) {
				propagate(e);
			}
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
