package org.eclipse.incquery.patternlanguage.mondix.generator.recipe;

import org.eclipse.incquery.patternlanguage.mondix.mondixPatternLanguage.MondixPatternModel;
import org.eclipse.incquery.patternlanguage.mondix.psystem.MondixPModel;
import org.eclipse.incquery.patternlanguage.mondix.psystem.MondixPQuery;
import org.eclipse.incquery.patternlanguage.patternLanguage.Pattern;
import org.eclipse.incquery.patternlanguage.util.generator.recipe.RecipeGenerator;
import org.eclipse.incquery.runtime.matchers.context.IPatternMatcherContext;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PQuery;
import org.eclipse.incquery.runtime.rete.recipes.ProductionRecipe;
import org.eclipse.incquery.runtime.rete.recipes.ReteNodeRecipe;
import org.eclipse.incquery.runtime.rete.recipes.ReteRecipe;

public class MondixRecipeGenerator extends RecipeGenerator<MondixPatternModel, MondixPModel, Void> {

	@Override
	protected Class<? extends MondixPatternModel> getPatternModelClass() {
		return MondixPatternModel.class;
	}

	@Override
	protected MondixPModel getPModel(MondixPatternModel patternModel) {
		return new MondixPModel(patternModel);
	}

	@Override
	protected IPatternMatcherContext getPatternMatcherContext(MondixPModel model) {
		return model.context;
	}

	@Override
	protected PQuery getPQuery(Pattern pattern, MondixPModel model) {
		return MondixPQuery.toPQuery(pattern, model);
	}

	@Override
	protected Void getMetamodel(MondixPatternModel patternModel) {
		return null;
	}

	@Override
	protected void processForSerialization(ReteRecipe recipe, ReteNodeRecipe nodeRecipe, Void metamodel, int recipeIndex) {
		if (nodeRecipe instanceof ProductionRecipe) {
			ProductionRecipe productionRecipe = (ProductionRecipe) nodeRecipe;
			nodeRecipe.setTraceInfo(((PQuery) productionRecipe.getPattern()).getFullyQualifiedName());
			productionRecipe.setPattern(null);
		}
	}

}
