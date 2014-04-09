package org.eclipse.incquery.patternlanguage.rdf.tests

import com.google.inject.Inject
import org.eclipse.incquery.patternlanguage.rdf.RdfPatternLanguageInjectorProvider
import org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.PatternModel
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.junit4.util.ParseHelper
import org.junit.Test
import org.junit.runner.RunWith

import static org.junit.Assert.*

@InjectWith(RdfPatternLanguageInjectorProvider)
@RunWith(XtextRunner)
class ParserTest {

	@Inject
	ParseHelper<PatternModel> parser

	@Test
	def void base() {
		val expectedBaseIri = "<http://example.org/>"
		val model = parser.parse('''base «expectedBaseIri»''')
		assertEquals(expectedBaseIri, model.base.iri)
	}

}