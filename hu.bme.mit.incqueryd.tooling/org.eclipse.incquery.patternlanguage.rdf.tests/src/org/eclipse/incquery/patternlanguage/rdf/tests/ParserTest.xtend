package org.eclipse.incquery.patternlanguage.rdf.tests

import com.google.inject.Inject
import org.eclipse.incquery.patternlanguage.rdf.RdfPatternLanguageInjectorProvider
import org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.RdfPatternModel
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.junit4.util.ParseHelper
import org.junit.Test
import org.junit.runner.RunWith

import static org.junit.Assert.*
import org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.RdfClassConstraint
import org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.RdfClass

@InjectWith(RdfPatternLanguageInjectorProvider)
@RunWith(XtextRunner)
class ParserTest {

	@Inject
	ParseHelper<RdfPatternModel> parser

	@Test
	def void posLength() {
		val model = parser.parse('''
base <http://www.semanticweb.org/ontologies/2011/1/TrainRequirementOntology.owl#>
prefix xsd: <http://www.w3.org/2001/XMLSchema#>

pattern posLength(Segment, SegmentLength) {
	Segment(Segment);
	Segment_length(Segment, SegmentLength);
	check('SegmentLength <= "0"^^xsd:integer');
}
''')
		assertEquals("http://www.semanticweb.org/ontologies/2011/1/TrainRequirementOntology.owl#", model.baseIriValue)
		switch firstConstraint : model.patterns.head.bodies.head.constraints.head {
			RdfClassConstraint: switch type : firstConstraint.type {
				RdfClass: assertEquals("Segment", type.class_.value)
				default: fail
			}
			default: fail
		}
	}

}