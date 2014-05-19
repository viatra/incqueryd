package org.eclipse.incquery.patternlanguage.rdf

import org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.Iri
import org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.RdfPatternModel
import static extension org.eclipse.xtext.EcoreUtil2.*

class IriUtils {

	static def String asString(Iri iri) {
		val prefix = iri.prefix?.value ?: iri.getContainerOfType(RdfPatternModel)?.baseIriValue
		'''«prefix»«iri.value»'''
	}

}