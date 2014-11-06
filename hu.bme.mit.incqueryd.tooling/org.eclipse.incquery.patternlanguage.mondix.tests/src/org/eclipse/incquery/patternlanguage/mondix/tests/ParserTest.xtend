package org.eclipse.incquery.patternlanguage.mondix.tests

import com.google.inject.Inject
import org.eclipse.incquery.patternlanguage.mondix.MondixPatternLanguageInjectorProvider
import org.eclipse.incquery.patternlanguage.mondix.mondixPatternLanguage.MondixPatternModel
import org.eclipse.incquery.patternlanguage.mondix.mondixPatternLanguage.NodeConstraint
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.junit4.util.ParseHelper
import org.junit.Test
import org.junit.runner.RunWith

import static org.junit.Assert.*

@InjectWith(MondixPatternLanguageInjectorProvider)
@RunWith(XtextRunner)
class ParserTest {

	@Inject
	ParseHelper<MondixPatternModel> parser

	public static val POS_LENGTH_SOURCE = '''
pattern posLength(Segment, SegmentLength) {
	Segment(Segment);
	Segment_length(Segment, SegmentLength);
}
'''

	@Test
	def void posLength() {
		val model = parser.parse(POS_LENGTH_SOURCE)
		assertTrue(model.eResource.errors.empty)
		switch firstConstraint : model.patterns.head.bodies.head.constraints.head {
			NodeConstraint: assertEquals("Segment", firstConstraint.type)
			default: fail
		}
	}

}