package org.eclipse.incquery.patternlanguage.util.generator.recipe;

import java.util.Set;

import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.generator.IOutputConfigurationProvider;
import org.eclipse.xtext.generator.OutputConfiguration;

import com.google.common.collect.ImmutableSet;

public class RecipeGeneratorOutputConfigurationProvider implements IOutputConfigurationProvider {

	@Override
	public Set<OutputConfiguration> getOutputConfigurations() {
		OutputConfiguration defaultOutput = new OutputConfiguration(IFileSystemAccess.DEFAULT_OUTPUT);
		defaultOutput.setDescription("Output Folder");
		defaultOutput.setOutputDirectory("./recipes");
		defaultOutput.setOverrideExistingResources(true);
		defaultOutput.setCreateOutputDirectory(true);
		defaultOutput.setCleanUpDerivedResources(false);
		defaultOutput.setSetDerivedProperty(false); // XXX because if another builder participant comes after ours, it might delete those
		defaultOutput.setKeepLocalHistory(true);
		return ImmutableSet.of(defaultOutput);
	}

}
