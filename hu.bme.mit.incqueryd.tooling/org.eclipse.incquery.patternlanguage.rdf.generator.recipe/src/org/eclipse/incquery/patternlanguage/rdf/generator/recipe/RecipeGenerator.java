package org.eclipse.incquery.patternlanguage.rdf.generator.recipe;

import static com.google.common.base.Throwables.propagate;
import static com.google.common.collect.ImmutableList.copyOf;
import static com.google.common.collect.Iterables.filter;
import hu.bme.mit.incqueryd.rdf.RdfUtils;
import hu.bme.mit.incqueryd.recipes.RecipeProcessor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceImpl;
import org.eclipse.emf.ecore.xmi.util.XMLProcessor;
import org.eclipse.incquery.patternlanguage.patternLanguage.Pattern;
import org.eclipse.incquery.patternlanguage.rdf.RdfPatternLanguageUtils;
import org.eclipse.incquery.patternlanguage.rdf.psystem.RdfPModel;
import org.eclipse.incquery.patternlanguage.rdf.psystem.RdfPQuery;
import org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.RdfPatternModel;
import org.eclipse.incquery.runtime.matchers.planning.QueryPlannerException;
import org.eclipse.incquery.runtime.matchers.psystem.IExpressionEvaluator;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PQuery;
import org.eclipse.incquery.runtime.rete.construction.plancompiler.ReteRecipeCompiler;
import org.eclipse.incquery.runtime.rete.recipes.BinaryInputRecipe;
import org.eclipse.incquery.runtime.rete.recipes.ExpressionEnforcerRecipe;
import org.eclipse.incquery.runtime.rete.recipes.ProductionRecipe;
import org.eclipse.incquery.runtime.rete.recipes.RecipesFactory;
import org.eclipse.incquery.runtime.rete.recipes.ReteNodeRecipe;
import org.eclipse.incquery.runtime.rete.recipes.ReteRecipe;
import org.eclipse.incquery.runtime.rete.recipes.UnaryInputRecipe;
import org.eclipse.incquery.runtime.rete.traceability.CompiledQuery;
import org.eclipse.incquery.runtime.rete.traceability.RecipeTraceInfo;
import org.eclipse.incquery.runtime.rete.util.Options;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.generator.IGenerator;
import org.openrdf.model.Model;

import com.google.common.collect.Sets;

public class RecipeGenerator implements IGenerator {

	private static final String ATTRIBUTE_DISCRIMINATOR = "attribute";
	private static final String EDGE_DISCRIMINATOR = "edge";
	// the VERTEX_DISCRIMINATOR is not used as a discriminator
	private static final String VERTEX_DISCRIMINATOR = "vertex";

	private int recipeIndex = 0;
	
	@Override
	public void doGenerate(Resource input, IFileSystemAccess fsa) {
		recipeIndex = 0;
		
		XMLProcessor xmlProcessor = new XMLProcessor();
		for (RdfPatternModel patternModel : filter(input.getContents(), RdfPatternModel.class)) {
			XMLResourceImpl resource = new XMLResourceImpl();
			resource.setEncoding("UTF-8");
			ReteRecipe recipe = RecipesFactory.eINSTANCE.createReteRecipe();
			resource.getContents().add(recipe);
			RdfPModel model = new RdfPModel(patternModel);
			ReteRecipeCompiler compiler = new ReteRecipeCompiler(Options.builderMethod.layoutStrategy(), model.context);
			Model vocabulary = RdfPatternLanguageUtils.getVocabulary(patternModel);
			ArrayList<CompiledQuery> compiledQueries = new ArrayList<>();
			for (Pattern pattern : filter(copyOf(input.getAllContents()), Pattern.class)) {
				PQuery query = new RdfPQuery(pattern, model);
				try {
					CompiledQuery compiledQuery = compiler.getCompiledForm(query);
					compiledQueries.add(compiledQuery);
				} catch (QueryPlannerException e) {
					propagate(e);
				}
			}
			Set<ReteNodeRecipe> collectRecipes = new HashSet<>();
			for (CompiledQuery compiledQuery : compiledQueries) {
				collectRecipes.addAll(collectRecipes(compiledQuery));
			}
			for (ReteNodeRecipe nodeRecipe : collectRecipes) {
				processForSerialization(recipe, nodeRecipe, vocabulary);
			}
			try {
				String contents = xmlProcessor.saveToString(resource, null);
				fsa.generateFile(input.getURI().trimFileExtension().appendFileExtension("recipe").lastSegment(),
						contents);
			} catch (IOException e) {
				propagate(e);
			}
		}
	}

	private void processForSerialization(ReteRecipe recipe, ReteNodeRecipe nodeRecipe, Model vocabulary) { // XXX
		nodeRecipe.setTraceInfo("");
		recipe.getRecipeNodes().add(nodeRecipe);
		recipeIndex++;
		
		if (nodeRecipe instanceof ProductionRecipe) {
			ProductionRecipe productionRecipe = (ProductionRecipe) nodeRecipe;
			productionRecipe.setPattern(null);
		} else if (nodeRecipe instanceof ExpressionEnforcerRecipe) {
			ExpressionEnforcerRecipe expressionEnforcerRecipe = (ExpressionEnforcerRecipe) nodeRecipe;
			IExpressionEvaluator evaluator = (IExpressionEvaluator) expressionEnforcerRecipe.getExpression()
					.getEvaluator();
			// XXX use an evaluator shared from runtime
			Object[] evaluationInfo = { evaluator.getShortDescription(), evaluator.getInputParameterNames() };
			expressionEnforcerRecipe.getExpression().setEvaluator(evaluationInfo);
		} else if (nodeRecipe instanceof UnaryInputRecipe) {
			UnaryInputRecipe unaryInputRecipe = (UnaryInputRecipe) nodeRecipe;

			String typeNameSuffix = RecipeProcessor.extractType(unaryInputRecipe).getTypeNameSuffix();
			unaryInputRecipe.setTraceInfo(VERTEX_DISCRIMINATOR + ": " + typeNameSuffix);
		} else if (nodeRecipe instanceof BinaryInputRecipe) {
			BinaryInputRecipe binaryInputRecipe = (BinaryInputRecipe) nodeRecipe;
			org.openrdf.model.Resource propertyUri = RdfPatternLanguageUtils.toRdfResource(binaryInputRecipe.getTypeName());
			
			String typeNameSuffix = RecipeProcessor.extractType(binaryInputRecipe).getTypeNameSuffix();
			if (RdfUtils.isDatatypeProperty(propertyUri, vocabulary)) {
				binaryInputRecipe.setTraceInfo(ATTRIBUTE_DISCRIMINATOR + ": " + typeNameSuffix);
			} else if (RdfUtils.isObjectProperty(propertyUri, vocabulary)) {
				binaryInputRecipe.setTraceInfo(EDGE_DISCRIMINATOR + ": " + typeNameSuffix);
			}
		}
		
		nodeRecipe.setTraceInfo(nodeRecipe.getTraceInfo() + " [recipe " + recipeIndex + "]");
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
