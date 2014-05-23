package org.eclipse.incquery.patternlanguage.rdf.validation;

import hu.bme.mit.incqueryd.rdf.RdfUtils
import java.net.URL
import org.eclipse.incquery.patternlanguage.patternLanguage.PatternModel
import org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.Iri
import org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.RdfClassConstraint
import org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.RdfPatternLanguagePackage
import org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.RdfPropertyConstraint
import org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.Vocabulary
import org.eclipse.xtext.validation.Check
import org.openrdf.model.impl.URIImpl

import static extension org.eclipse.incquery.patternlanguage.rdf.RdfPatternLanguageUtils.*

public class RdfPatternLanguageJavaValidator extends AbstractRdfPatternLanguageJavaValidator {

	override checkPackageDeclaration(PatternModel model) {
		// Do not check
	}

	@Check
	def void checkIri(Iri iri) {
		try {
			new URIImpl(iri.asString)
		} catch (Exception e) {
			error("Invalid IRI, consider specifying a base IRI", iri, RdfPatternLanguagePackage.eINSTANCE.iri_Value)
		}
	}

	@Check
	def void checkVocabulary(Vocabulary vocabulary) {
		try {
			RdfUtils.load(#{new URL(vocabulary.location)})
		} catch (Exception e) {
			warning("Can't load RDF vocabulary", vocabulary, RdfPatternLanguagePackage.eINSTANCE.vocabulary_Location)
		}
	}

	@Check
	def void checkClassConstraint(RdfClassConstraint classConstraint) {
		val vocabulary = classConstraint.vocabulary
		val type = classConstraint.type.toRdfResource
		if (!RdfUtils.isClass(type, vocabulary)) {
			warning('''Class «classConstraint.type.asString» not found in any vocabulary''', classConstraint, RdfPatternLanguagePackage.eINSTANCE.rdfClassConstraint_Type)
		}
	}

	@Check
	def void checkPropertyConstraint(RdfPropertyConstraint propertyConstraint) {
		val vocabulary = propertyConstraint.vocabulary
		val refType = propertyConstraint.refType.toRdfResource
		if (!RdfUtils.isProperty(refType, vocabulary)) {
			warning('''Property «propertyConstraint.refType.asString» not found in any vocabulary''', propertyConstraint, RdfPatternLanguagePackage.eINSTANCE.rdfPropertyConstraint_RefType)
		}
	}

}
