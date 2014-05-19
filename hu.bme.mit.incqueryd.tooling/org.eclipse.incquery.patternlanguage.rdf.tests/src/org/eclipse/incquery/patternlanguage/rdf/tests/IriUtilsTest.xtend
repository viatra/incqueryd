package org.eclipse.incquery.patternlanguage.rdf.tests

import org.junit.Test
import org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.RdfPatternLanguageFactory
import static org.junit.Assert.*
import static extension org.eclipse.incquery.patternlanguage.rdf.IriUtils.*
import org.eclipse.incquery.patternlanguage.patternLanguage.PatternLanguageFactory

class IriUtilsTest {

	extension val PatternLanguageFactory factory = PatternLanguageFactory.eINSTANCE
	extension val RdfPatternLanguageFactory rdfFactory = RdfPatternLanguageFactory.eINSTANCE

	@Test
	def void simple() {
		val iriValue = "iri"
		val iri = createIri => [
			value = iriValue
		]
		assertEquals(iriValue, iri.asString)
	}

	@Test
	def void prefixed() {
		val iriPrefixValue = "prefix"
		val iriPrefix = createIriPrefix => [
			value = iriPrefixValue
		]
		val iriValue = "iri"
		val iri = createIri => [
			value = iriValue
			prefix = iriPrefix
		]
		assertEquals(iriPrefixValue + iriValue, iri.asString)
	}

	@Test
	def void base() {
		val iriValue = "iri"
		val iri = createIri => [
			value = iriValue
		]
		val modelBaseIriValue = "base"
		createRdfPatternModel => [
			baseIriValue = modelBaseIriValue
			patterns.add(createPattern => [
				bodies.add(createPatternBody => [
					constraints.add(createRdfClassConstraint => [
						type = iri
					])
				])
			])
		]
		assertEquals(modelBaseIriValue + iriValue, iri.asString)
	}

}