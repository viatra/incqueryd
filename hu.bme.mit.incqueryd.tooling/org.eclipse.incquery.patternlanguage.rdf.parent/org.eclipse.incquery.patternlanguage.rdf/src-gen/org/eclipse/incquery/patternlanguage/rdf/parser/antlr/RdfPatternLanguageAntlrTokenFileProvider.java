/*
 * generated by Xtext 2.9.0.rc2
 */
package org.eclipse.incquery.patternlanguage.rdf.parser.antlr;

import java.io.InputStream;
import org.eclipse.xtext.parser.antlr.IAntlrTokenFileProvider;

public class RdfPatternLanguageAntlrTokenFileProvider implements IAntlrTokenFileProvider {

	@Override
	public InputStream getAntlrTokenFile() {
		ClassLoader classLoader = getClass().getClassLoader();
		return classLoader.getResourceAsStream("org/eclipse/incquery/patternlanguage/rdf/parser/antlr/internal/InternalRdfPatternLanguage.tokens");
	}
}
