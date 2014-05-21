package org.eclipse.incquery.patternlanguage.rdf.validation;

import hu.bme.mit.incqueryd.rdf.RdfUtils
import java.net.URL
import org.eclipse.incquery.patternlanguage.patternLanguage.PatternModel
import org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.RdfPatternLanguagePackage
import org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.Vocabulary
import org.eclipse.xtext.validation.Check

public class RdfPatternLanguageJavaValidator extends AbstractRdfPatternLanguageJavaValidator {

	override checkPackageDeclaration(PatternModel model) {
		// Do not check
	}

	@Check
	def void checkVocabulary(Vocabulary vocabulary) {
		try {
			RdfUtils.load(#{new URL(vocabulary.location)})
		} catch (Exception e) {
			error("Invalid RDF vocabulary", vocabulary, RdfPatternLanguagePackage.eINSTANCE.vocabulary_Location)
		}
	}

}
