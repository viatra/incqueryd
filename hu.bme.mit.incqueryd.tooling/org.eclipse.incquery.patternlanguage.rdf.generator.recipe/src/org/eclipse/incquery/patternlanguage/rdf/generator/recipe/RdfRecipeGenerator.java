package org.eclipse.incquery.patternlanguage.rdf.generator.recipe;

import hu.bme.mit.incqueryd.rdf.RdfUtils;

import org.eclipse.incquery.patternlanguage.patternLanguage.Pattern;
import org.eclipse.incquery.patternlanguage.rdf.RdfPatternLanguageUtils;
import org.eclipse.incquery.patternlanguage.rdf.psystem.RdfPModel;
import org.eclipse.incquery.patternlanguage.rdf.psystem.RdfPQuery;
import org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.RdfPatternModel;
import org.eclipse.incquery.patternlanguage.util.generator.recipe.RecipeGenerator;
import org.eclipse.incquery.runtime.matchers.context.IPatternMatcherContext;
import org.eclipse.incquery.runtime.matchers.psystem.IExpressionEvaluator;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PQuery;
import org.eclipse.incquery.runtime.rete.recipes.BinaryInputRecipe;
import org.eclipse.incquery.runtime.rete.recipes.ConstantRecipe;
import org.eclipse.incquery.runtime.rete.recipes.ExpressionEnforcerRecipe;
import org.eclipse.incquery.runtime.rete.recipes.ProductionRecipe;
import org.eclipse.incquery.runtime.rete.recipes.ReteNodeRecipe;
import org.eclipse.incquery.runtime.rete.recipes.ReteRecipe;
import org.eclipse.incquery.runtime.rete.recipes.UnaryInputRecipe;
import org.openrdf.model.Model;

import com.google.common.base.Joiner;

public class RdfRecipeGenerator extends RecipeGenerator<RdfPatternModel, RdfPModel, Model> {

	// XXX duplication with runtime
	private static final String ATTRIBUTE_DISCRIMINATOR = "attribute";
	private static final String EDGE_DISCRIMINATOR = "edge";
	private static final String VERTEX_DISCRIMINATOR = "vertex";
	private static final String SEPARATOR = " ";

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
		} else if (nodeRecipe instanceof UnaryInputRecipe) {
			UnaryInputRecipe unaryInputRecipe = (UnaryInputRecipe) nodeRecipe;
			unaryInputRecipe.setTraceInfo(VERTEX_DISCRIMINATOR);
		} else if (nodeRecipe instanceof BinaryInputRecipe) {
			BinaryInputRecipe binaryInputRecipe = (BinaryInputRecipe) nodeRecipe;
			org.openrdf.model.Resource propertyUri = RdfPatternLanguageUtils.toRdfResource(binaryInputRecipe.getTypeName());
			if (RdfUtils.isDatatypeProperty(propertyUri, vocabulary)) {
				binaryInputRecipe.setTraceInfo(ATTRIBUTE_DISCRIMINATOR);
			} else if (RdfUtils.isObjectProperty(propertyUri, vocabulary)) {
				binaryInputRecipe.setTraceInfo(EDGE_DISCRIMINATOR);
			}
		} else if (nodeRecipe instanceof ConstantRecipe) {
			ConstantRecipe constantRecipe = (ConstantRecipe) nodeRecipe;
			constantRecipe.setTraceInfo(Joiner.on(SEPARATOR).join(constantRecipe.getConstantValues()));
			constantRecipe.getConstantValues().clear();
		}
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
	protected IPatternMatcherContext getPatternMatcherContext(RdfPModel model) {
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
