package org.eclipse.incquery.patternlanguage.rdf.tests

import com.google.inject.Inject
import org.eclipse.incquery.patternlanguage.rdf.RdfPatternLanguageInjectorProvider
import org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.RdfClassConstraint
import org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.RdfPatternModel
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
	ParseHelper<RdfPatternModel> parser

	public static val POS_LENGTH_SOURCE = '''
vocabulary <https://opensourceprojects.eu/p/mondo/trainbenchmark/ci/cf1bdd52087e7f5169aa1b1ee300b8eb6e6081b2/tree/src/hu.bme.mit.trainbenchmark.generator.rdf/src/main/resources/railway.owl.clear?format=raw>

base <http://www.semanticweb.org/ontologies/2011/1/TrainRequirementOntology.owl#>
prefix xsd: <http://www.w3.org/2001/XMLSchema#>

pattern posLength(Segment, SegmentLength) {
	Segment(Segment);
	Segment_length(Segment, SegmentLength);
	check('SegmentLength <= 0');
}
'''

	@Test
	def void posLength() {
		val model = parser.parse(POS_LENGTH_SOURCE)
		assertTrue(model.eResource.errors.empty)
		assertEquals("http://www.semanticweb.org/ontologies/2011/1/TrainRequirementOntology.owl#", model.baseIriValue)
		switch firstConstraint : model.patterns.head.bodies.head.constraints.head {
			RdfClassConstraint: assertEquals("Segment", firstConstraint.type.value)
			default: fail
		}
	}

}