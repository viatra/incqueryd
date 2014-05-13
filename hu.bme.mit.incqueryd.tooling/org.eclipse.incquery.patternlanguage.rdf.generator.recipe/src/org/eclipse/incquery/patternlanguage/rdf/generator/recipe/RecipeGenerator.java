package org.eclipse.incquery.patternlanguage.rdf.generator.recipe;

import static com.google.common.base.Throwables.propagate;
import static com.google.common.collect.ImmutableList.copyOf;
import static com.google.common.collect.Iterables.filter;

import java.io.IOException;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.incquery.patternlanguage.patternLanguage.Pattern;
import org.eclipse.incquery.patternlanguage.rdf.psystem.RdfPQuery;
import org.eclipse.incquery.patternlanguage.rdf.psystem.RdfPatternMatcherContext;
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
import org.openrdf.model.Graph;

public class RecipeGenerator implements IGenerator {

	private final ReteRecipeCompiler compiler;
	private final RdfPatternMatcherContext context;

	public RecipeGenerator() {
		Graph metamodel = null; // TODO
		context = new RdfPatternMatcherContext(metamodel);
		compiler = new ReteRecipeCompiler(Options.builderMethod.layoutStrategy(), context);
	}

	private ReteNodeRecipe compile(PQuery query) throws QueryPlannerException {
		return compiler.getCompiledForm(query).getRecipe();
	}

	@Override
	public void doGenerate(Resource input, IFileSystemAccess fsa) {
		ReteRecipe recipe = RecipesFactory.eINSTANCE.createReteRecipe();
		for (RdfPatternModel patternModel : filter(input.getContents(), RdfPatternModel.class)) {
			for (Pattern pattern : filter(copyOf(input.getAllContents()), Pattern.class)) {
				PQuery query = new RdfPQuery(pattern, patternModel, context);
				try {
					ReteNodeRecipe nodeRecipe = compile(query);
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
