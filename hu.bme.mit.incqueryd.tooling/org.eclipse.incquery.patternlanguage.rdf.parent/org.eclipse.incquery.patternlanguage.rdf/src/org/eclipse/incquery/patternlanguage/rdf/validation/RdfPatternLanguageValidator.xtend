package org.eclipse.incquery.patternlanguage.rdf.validation

import hu.bme.mit.incqueryd.rdf.RdfUtils
import org.apache.log4j.Logger
import org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.Iri
import org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.RdfClassConstraint
import org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.RdfPatternLanguagePackage
import org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.RdfPropertyConstraint
import org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.Vocabulary
import org.eclipse.xtext.validation.Check
import org.eclipse.xtext.validation.CheckType
import org.openrdf.model.impl.URIImpl
import static extension org.eclipse.incquery.patternlanguage.rdf.RdfPatternLanguageUtils.*

/**
 * Custom validation rules.
 *
 * see http://www.eclipse.org/Xtext/documentation.html#validation
 */
class RdfPatternLanguageValidator extends AbstractRdfPatternLanguageValidator {
	static val logger = Logger.getLogger(RdfPatternLanguageValidator)

	@Check
	def void checkIri(Iri iri) {
		try {
			new URIImpl(iri.asString)
		} catch (Exception e) {
			error("Invalid IRI, consider specifying a base IRI", iri, RdfPatternLanguagePackage.eINSTANCE.iri_Value)
		}
	}

	@Check(CheckType.NORMAL)
	def void checkVocabulary(Vocabulary vocabulary) {
		try {
			RdfUtils.load(#{vocabulary.url})
		} catch (Exception e) {
			warning("Can't load RDF vocabulary", vocabulary, RdfPatternLanguagePackage.eINSTANCE.vocabulary_Location)
		}
	}

	@Check(CheckType.NORMAL)
	def void checkClassConstraint(RdfClassConstraint classConstraint) {
		try {
			val vocabulary = classConstraint.vocabulary
			val type = classConstraint.type.toRdfResource
			if (!RdfUtils.isClass(type, vocabulary)) {
				warning('''Class «classConstraint.type.asString» not found in any vocabulary''', classConstraint, RdfPatternLanguagePackage.eINSTANCE.rdfClassConstraint_Type)
			}
		} catch (Exception e) {
			logger.warn(e)
		}
	}

	@Check(CheckType.NORMAL)
	def void checkPropertyConstraint(RdfPropertyConstraint propertyConstraint) {
		try {
			val vocabulary = propertyConstraint.vocabulary
			val refType = propertyConstraint.refType.toRdfResource
			if (!RdfUtils.isProperty(refType, vocabulary)) {
				warning('''Property «propertyConstraint.refType.asString» not found in any vocabulary''', propertyConstraint, RdfPatternLanguagePackage.eINSTANCE.rdfPropertyConstraint_RefType)
			}
		} catch (Exception e) {
			logger.warn(e)
		}
	}

}
