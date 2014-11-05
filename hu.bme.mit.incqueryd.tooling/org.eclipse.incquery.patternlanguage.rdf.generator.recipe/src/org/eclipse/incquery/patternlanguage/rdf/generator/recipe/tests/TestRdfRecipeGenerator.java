package org.eclipse.incquery.patternlanguage.rdf.generator.recipe.tests;

import org.eclipse.incquery.patternlanguage.rdf.RdfPatternLanguageInjectorProvider;
import org.eclipse.incquery.patternlanguage.rdf.generator.recipe.RdfRecipeGenerator;
import org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.RdfPatternModel;
import org.eclipse.incquery.patternlanguage.rdf.tests.ParserTest;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.generator.InMemoryFileSystemAccess;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.junit4.util.ParseHelper;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.inject.Inject;

@InjectWith(RdfPatternLanguageInjectorProvider.class)
@RunWith(XtextRunner.class)
public class TestRdfRecipeGenerator {

	@Inject
	ParseHelper<RdfPatternModel> parser;

	@Test
	public void posLength() throws Exception {
		RdfRecipeGenerator recipeGenerator = new RdfRecipeGenerator();
		RdfPatternModel model = parser.parse(ParserTest.POS_LENGTH_SOURCE);
		IFileSystemAccess fsa = new InMemoryFileSystemAccess();
		recipeGenerator.doGenerate(model.eResource(), fsa);
	}

}