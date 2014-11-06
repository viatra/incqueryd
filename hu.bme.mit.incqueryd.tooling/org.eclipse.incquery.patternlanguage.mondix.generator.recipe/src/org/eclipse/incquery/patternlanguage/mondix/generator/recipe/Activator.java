package org.eclipse.incquery.patternlanguage.mondix.generator.recipe;

import static com.google.inject.Guice.createInjector;
import static org.eclipse.xtext.util.Modules2.mixin;

import org.eclipse.incquery.patternlanguage.mondix.MondixPatternLanguageRuntimeModule;
import org.eclipse.incquery.patternlanguage.mondix.ui.MondixPatternLanguageUiModule;
import org.eclipse.incquery.patternlanguage.util.generator.recipe.RecipeGeneratorModule;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.xtext.ui.shared.SharedStateModule;
import org.osgi.framework.BundleContext;

import com.google.inject.Injector;

public class Activator extends AbstractUIPlugin {

	private Injector injector;

	public Injector getInjector() {
		return injector;
	}

	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		INSTANCE = this;
		injector = createInjector(mixin(
			new MondixPatternLanguageRuntimeModule(),
			new SharedStateModule(),
			new MondixPatternLanguageUiModule(this),
			new RecipeGeneratorModule(this, MondixRecipeGenerator.class)));
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		injector = null;
		super.stop(context);
	}

	private static Activator INSTANCE;

	public static Activator getInstance() {
		return INSTANCE;
	}

}