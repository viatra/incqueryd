/*
 * generated by Xtext
 */
package org.eclipse.incquery.patternlanguage.rdf;

import org.eclipse.xtext.junit4.IInjectorProvider;

import com.google.inject.Injector;

public class RdfPatternLanguageUiInjectorProvider implements IInjectorProvider {
	
	@Override
	public Injector getInjector() {
		return org.eclipse.incquery.patternlanguage.rdf.ui.internal.RdfPatternLanguageActivator.getInstance().getInjector("org.eclipse.incquery.patternlanguage.rdf.RdfPatternLanguage");
	}
	
}
