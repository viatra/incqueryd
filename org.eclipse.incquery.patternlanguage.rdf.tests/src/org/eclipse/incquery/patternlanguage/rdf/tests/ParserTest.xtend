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
	def void posLength() {
		val expectedBaseIri = "<http://example.org/>"
		val model = parser.parse('''
base «expectedBaseIri»
prefix train: <http://train.org/>
prefix xsd: <http://www.w3.org/2001/XMLSchema#>
pattern posLength(Source, Target) = {
	<Segment>(Source);
	train:<Segment_length>(Source, Target);
	check((Target as Integer) <= 0);
}
''')
		assertEquals(expectedBaseIri, model.base.iri)
	}

}