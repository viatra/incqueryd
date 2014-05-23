package org.eclipse.incquery.patternlanguage.rdf

import hu.bme.mit.incqueryd.rdf.RdfUtils
import java.net.URL
import org.eclipse.emf.ecore.EObject
import org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.Iri
import org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.RdfPatternModel
import org.openrdf.model.Model
import org.openrdf.model.Resource
import org.openrdf.model.impl.URIImpl

import static extension org.eclipse.xtext.EcoreUtil2.*

class RdfPatternLanguageUtils {

	static def String asString(Iri iri) {
		val prefix = iri.prefix?.value ?: iri.getContainerOfType(RdfPatternModel)?.baseIriValue
		'''«prefix»«iri.value»'''
	}

	static def Resource toRdfResource(Iri iri) {
		new URIImpl(iri.asString)
	}

	static def Model getVocabulary(EObject object) {
		val patternModel = object.getContainerOfType(RdfPatternModel)
		RdfUtils.load(patternModel.vocabularies.map[new URL(location)].toSet)
	}

}