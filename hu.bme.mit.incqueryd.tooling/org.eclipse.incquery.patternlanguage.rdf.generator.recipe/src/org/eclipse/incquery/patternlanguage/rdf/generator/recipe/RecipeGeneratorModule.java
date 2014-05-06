package org.eclipse.incquery.patternlanguage.rdf.generator.recipe;

import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.xtext.service.AbstractGenericModule;

import com.google.inject.Binder;

public class RecipeGeneratorModule extends AbstractGenericModule {
	private final AbstractUIPlugin plugin;

	public RecipeGeneratorModule(AbstractUIPlugin plugin) {
		this.plugin = plugin;
	}

	@Override
	public void configure(Binder binder) {
		super.configure(binder);
		binder.bind(AbstractUIPlugin.class).toInstance(plugin);
		binder.bind(IDialogSettings.class).toInstance(plugin.getDialogSettings());
	}

	public Class<? extends org.eclipse.xtext.generator.IGenerator> bindIGenerator() {
		return RecipeGenerator.class;
	}

	public Class<? extends org.eclipse.xtext.builder.IXtextBuilderParticipant> bindIXtextBuilderParticipant() {
		return RecipeGeneratorBuilderParticipant.class;
	}

}