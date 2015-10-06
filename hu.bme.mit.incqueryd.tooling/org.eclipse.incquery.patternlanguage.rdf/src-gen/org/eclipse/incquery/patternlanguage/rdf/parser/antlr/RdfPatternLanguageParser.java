/*
 * generated by Xtext
 */
package org.eclipse.incquery.patternlanguage.rdf.parser.antlr;

import com.google.inject.Inject;

import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.incquery.patternlanguage.rdf.services.RdfPatternLanguageGrammarAccess;

public class RdfPatternLanguageParser extends org.eclipse.xtext.parser.antlr.AbstractAntlrParser {
	
	@Inject
	private RdfPatternLanguageGrammarAccess grammarAccess;
	
	@Override
	protected void setInitialHiddenTokens(XtextTokenStream tokenStream) {
		tokenStream.setInitialHiddenTokens("RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT");
	}
	
	@Override
	protected org.eclipse.incquery.patternlanguage.rdf.parser.antlr.internal.InternalRdfPatternLanguageParser createParser(XtextTokenStream stream) {
		return new org.eclipse.incquery.patternlanguage.rdf.parser.antlr.internal.InternalRdfPatternLanguageParser(stream, getGrammarAccess());
	}
	
	@Override 
	protected String getDefaultRuleName() {
		return "RdfPatternModel";
	}
	
	public RdfPatternLanguageGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}
	
	public void setGrammarAccess(RdfPatternLanguageGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
	
}
