package org.eclipse.incquery.patternlanguage.rdf

import org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.Iri
import org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.RdfPatternModel
import static extension org.eclipse.xtext.EcoreUtil2.*

class IriUtils {

	static def String getValue(Iri iri) {
		val prefix = iri.prefix?.iri ?: iri.getContainerOfType(RdfPatternModel)?.base?.iri
		'''«prefix»«iri.iri»'''
	}

}