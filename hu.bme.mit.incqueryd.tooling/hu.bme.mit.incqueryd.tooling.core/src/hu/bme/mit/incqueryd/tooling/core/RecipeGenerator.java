package hu.bme.mit.incqueryd.tooling.core;

import static com.google.common.base.Throwables.propagate;
import static com.google.common.collect.ImmutableList.copyOf;
import static com.google.common.collect.Iterables.filter;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.incquery.patternlanguage.patternLanguage.Pattern;
import org.eclipse.incquery.patternlanguage.rdf.psystem.RdfPQuery;
import org.eclipse.incquery.patternlanguage.rdf.psystem.RdfPatternMatcherContext;
import org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.RdfPatternModel;
import org.eclipse.incquery.runtime.matchers.planning.QueryPlannerException;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PQuery;
import org.eclipse.incquery.runtime.rete.construction.plancompiler.ReteRecipeCompiler;
import org.eclipse.incquery.runtime.rete.recipes.ReteNodeRecipe;
import org.eclipse.incquery.runtime.rete.util.Options;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.generator.IGenerator;

public class RecipeGenerator implements IGenerator {

	private final ReteRecipeCompiler compiler;

	public RecipeGenerator() {
		compiler = new ReteRecipeCompiler(
				Options.builderMethod.layoutStrategy(),
				new RdfPatternMatcherContext());
	}

	private ReteNodeRecipe compile(PQuery query) throws QueryPlannerException {
		return compiler.getCompiledForm(query).getRecipe();
	}

	@Override
	public void doGenerate(Resource input, IFileSystemAccess fsa) {
		for (RdfPatternModel patternModel : filter(input.getContents(), RdfPatternModel.class)) {
			for (Pattern pattern : filter(copyOf(input.getAllContents()), Pattern.class)) {
				PQuery query = new RdfPQuery(pattern, patternModel);
				try {
					ReteNodeRecipe nodeRecipe = compile(query);
					// TODO
				} catch (QueryPlannerException e) {
					propagate(e);
				}
			}
		}
	}
}
