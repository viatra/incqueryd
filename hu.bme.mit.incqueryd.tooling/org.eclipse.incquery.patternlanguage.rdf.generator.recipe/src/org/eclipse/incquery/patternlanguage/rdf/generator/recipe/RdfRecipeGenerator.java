package org.eclipse.incquery.patternlanguage.rdf.generator.recipe;

import hu.bme.mit.incqueryd.rdf.RdfUtils;

import org.eclipse.incquery.patternlanguage.patternLanguage.Pattern;
import org.eclipse.incquery.patternlanguage.rdf.RdfPatternLanguageUtils;
import org.eclipse.incquery.patternlanguage.rdf.psystem.RdfPModel;
import org.eclipse.incquery.patternlanguage.rdf.psystem.RdfPQuery;
import org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.RdfPatternModel;
import org.eclipse.incquery.patternlanguage.util.generator.recipe.RecipeGenerator;
import org.eclipse.incquery.runtime.matchers.context.IQueryMetaContext;
import org.eclipse.incquery.runtime.matchers.psystem.IExpressionEvaluator;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PQuery;
import org.eclipse.incquery.runtime.rete.recipes.ExpressionEnforcerRecipe;
import org.eclipse.incquery.runtime.rete.recipes.InputRecipe;
import org.eclipse.incquery.runtime.rete.recipes.ProductionRecipe;
import org.eclipse.incquery.runtime.rete.recipes.ReteNodeRecipe;
import org.eclipse.incquery.runtime.rete.recipes.ReteRecipe;
import org.openrdf.model.Model;

public class RdfRecipeGenerator extends RecipeGenerator<RdfPatternModel, RdfPModel, Model> {

	private static final String VERTEX_DISCRIMINATOR = "vertex";
	private static final String ATTRIBUTE_DISCRIMINATOR = "attribute";
	private static final String EDGE_DISCRIMINATOR = "edge";

	@Override
	protected void processForSerialization(ReteRecipe recipe, ReteNodeRecipe nodeRecipe, Model vocabulary, int recipeIndex) { // XXX
		if (nodeRecipe instanceof ProductionRecipe) {
			ProductionRecipe productionRecipe = (ProductionRecipe) nodeRecipe;
			nodeRecipe.setTraceInfo(((PQuery) productionRecipe.getPattern()).getFullyQualifiedName());
			productionRecipe.setPattern(null);
		} else if (nodeRecipe instanceof ExpressionEnforcerRecipe) {
			ExpressionEnforcerRecipe expressionEnforcerRecipe = (ExpressionEnforcerRecipe) nodeRecipe;
			IExpressionEvaluator evaluator = (IExpressionEvaluator) expressionEnforcerRecipe.getExpression().getEvaluator();
			// XXX use an evaluator shared from runtime
			Object[] evaluationInfo = { evaluator.getShortDescription(), evaluator.getInputParameterNames() };
			expressionEnforcerRecipe.getExpression().setEvaluator(evaluationInfo);
		} else if (nodeRecipe instanceof InputRecipe) {
			InputRecipe inputRecipe = (InputRecipe) nodeRecipe;
			String typeName = inputRecipe.getKeyID();
			org.openrdf.model.Resource typeResource = RdfPatternLanguageUtils.toRdfResource(typeName);
			if (RdfUtils.isClass(typeResource, vocabulary) || RdfUtils.isDatatype(typeResource, vocabulary)) {
				inputRecipe.setTraceInfo(VERTEX_DISCRIMINATOR + ": " + typeName);
			} else if (RdfUtils.isDatatypeProperty(typeResource, vocabulary)) {
				inputRecipe.setTraceInfo(ATTRIBUTE_DISCRIMINATOR + ": " + typeName);
			} else if (RdfUtils.isObjectProperty(typeResource, vocabulary)) {
				inputRecipe.setTraceInfo(EDGE_DISCRIMINATOR + ": " + typeName);
			}
		}
		nodeRecipe.setTraceInfo(nodeRecipe.getTraceInfo() + " [recipe " + recipeIndex + "]");
	}

	@Override
	protected Class<? extends RdfPatternModel> getPatternModelClass() {
		return RdfPatternModel.class;
	}

	@Override
	protected RdfPModel getPModel(RdfPatternModel patternModel) {
		return new RdfPModel(patternModel);
	}

	@Override
	protected IQueryMetaContext getQueryMetaContext(RdfPModel model) {
		return model.context;
	}

	@Override
	protected PQuery getPQuery(Pattern pattern, RdfPModel model) {
		return RdfPQuery.toPQuery(pattern, model);
	}

	@Override
	protected Model getMetamodel(RdfPatternModel patternModel) {
		return RdfPatternLanguageUtils.getVocabulary(patternModel);
	}

}
