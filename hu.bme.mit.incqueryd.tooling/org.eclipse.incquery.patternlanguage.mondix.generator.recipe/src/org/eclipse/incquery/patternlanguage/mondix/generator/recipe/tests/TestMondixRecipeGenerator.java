package org.eclipse.incquery.patternlanguage.mondix.generator.recipe.tests;

import org.eclipse.incquery.patternlanguage.mondix.MondixPatternLanguageInjectorProvider;
import org.eclipse.incquery.patternlanguage.mondix.generator.recipe.MondixRecipeGenerator;
import org.eclipse.incquery.patternlanguage.mondix.mondixPatternLanguage.MondixPatternModel;
import org.eclipse.incquery.patternlanguage.mondix.tests.ParserTest;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.generator.InMemoryFileSystemAccess;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.junit4.util.ParseHelper;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.inject.Inject;

@InjectWith(MondixPatternLanguageInjectorProvider.class)
@RunWith(XtextRunner.class)
public class TestMondixRecipeGenerator {

	@Inject
	ParseHelper<MondixPatternModel> parser;

	@Test
	public void posLength() throws Exception {
		MondixRecipeGenerator recipeGenerator = new MondixRecipeGenerator();
		MondixPatternModel model = parser.parse(ParserTest.POS_LENGTH_SOURCE);
		IFileSystemAccess fsa = new InMemoryFileSystemAccess();
		recipeGenerator.doGenerate(model.eResource(), fsa);
	}

}