package org.eclipse.incquery.patternlanguage.util.generator.recipe;

import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.xtext.builder.BuilderParticipant;
import org.eclipse.xtext.builder.IXtextBuilderParticipant;
import org.eclipse.xtext.generator.IGenerator;
import org.eclipse.xtext.generator.IOutputConfigurationProvider;
import org.eclipse.xtext.service.AbstractGenericModule;

import com.google.inject.Binder;

public class RecipeGeneratorModule extends AbstractGenericModule {
	private final AbstractUIPlugin plugin;
	private final Class<? extends RecipeGenerator<?, ?, ?>> generatorClass;

	public RecipeGeneratorModule(AbstractUIPlugin plugin, Class<? extends RecipeGenerator<?, ?, ?>> generatorClass) {
		this.plugin = plugin;
		this.generatorClass = generatorClass;
	}

	@Override
	public void configure(Binder binder) {
		super.configure(binder);
		binder.bind(AbstractUIPlugin.class).toInstance(plugin);
		binder.bind(IDialogSettings.class).toInstance(plugin.getDialogSettings());
		binder.bind(IOutputConfigurationProvider.class).to(RecipeGeneratorOutputConfigurationProvider.class);
	}

	public Class<? extends IGenerator> bindIGenerator() {
		return generatorClass;
	}

	public Class<? extends IXtextBuilderParticipant> bindIXtextBuilderParticipant() {
		return BuilderParticipant.class;
	}

}