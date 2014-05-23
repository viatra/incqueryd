package org.eclipse.incquery.patternlanguage.rdf.validation;

import hu.bme.mit.incqueryd.rdf.RdfUtils
import java.net.URL
import org.eclipse.incquery.patternlanguage.patternLanguage.PatternModel
import org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.RdfPatternLanguagePackage
import org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.Vocabulary
import org.eclipse.xtext.validation.Check
import org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.Iri
import static extension org.eclipse.incquery.patternlanguage.rdf.IriUtils.*
import org.openrdf.model.impl.URIImpl

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

	@Check
	def void checkIri(Iri iri) {
		try {
			new URIImpl(iri.asString)
		} catch (Exception e) {
			error("Invalid IRI, consider specifying a base IRI", iri, RdfPatternLanguagePackage.eINSTANCE.iri_Value)
		}
	}

}
