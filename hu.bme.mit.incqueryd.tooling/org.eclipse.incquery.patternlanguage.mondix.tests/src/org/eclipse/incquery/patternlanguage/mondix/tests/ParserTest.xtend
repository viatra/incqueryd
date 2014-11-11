package org.eclipse.incquery.patternlanguage.mondix.tests

import com.google.inject.Inject
import com.google.inject.Provider
import hu.bme.mit.incqueryd.mondixschema.MondixSchemaFactory
import hu.bme.mit.incqueryd.mondixschema.MondixSchemaPackage
import hu.bme.mit.incqueryd.mondixschema.Relation
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.emf.ecore.resource.impl.ResourceFactoryImpl
import org.eclipse.incquery.patternlanguage.mondix.MondixPatternLanguageInjectorProvider
import org.eclipse.incquery.patternlanguage.mondix.mondixPatternLanguage.MondixPatternModel
import org.eclipse.incquery.patternlanguage.mondix.mondixPatternLanguage.UnaryRelationConstraint
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.junit4.util.ParseHelper
import org.eclipse.xtext.junit4.validation.ValidationTestHelper
import org.eclipse.xtext.resource.XtextResourceSet
import org.junit.Test
import org.junit.runner.RunWith

import static org.junit.Assert.*

@InjectWith(MondixPatternLanguageInjectorProvider)
@RunWith(XtextRunner)
class ParserTest {

	@Inject
	ParseHelper<MondixPatternModel> parser

	@Inject ValidationTestHelper validationTester

	@Inject
	Provider<XtextResourceSet> resourceSetProvider

	static val EXTENSION = "anything"
	static val MONDIX_SCHEMA_URI = '''foo.«EXTENSION»'''
	static val UNARY_RELATION_NAME = "Segment"
	static val BINARY_RELATION_NAME = "Segment_length"
	public static val POS_LENGTH_SOURCE = '''
pattern posLength(Segment, SegmentLength) {
	«UNARY_RELATION_NAME»(Segment);
	«BINARY_RELATION_NAME»(Segment, SegmentLength);
}
'''

	@Test
	def void posLength() {
		val resourceSet = resourceSetProvider.get
		addMondixSchema(resourceSet)
		val model = parser.parse(POS_LENGTH_SOURCE, URI.createURI("bar"), resourceSet)
		validationTester.assertNoIssues(model)
		switch firstConstraint : model.patterns.head.bodies.head.constraints.head {
			UnaryRelationConstraint: assertEquals(UNARY_RELATION_NAME, firstConstraint.relation.name)
			default: fail
		}
	}

	static def void addMondixSchema(ResourceSet resourceSet) {
		MondixSchemaPackage.eINSTANCE.eClass
		resourceSet.resourceFactoryRegistry.extensionToFactoryMap.put(EXTENSION, new ResourceFactoryImpl)
		val resource = resourceSet.createResource(URI.createURI(MONDIX_SCHEMA_URI))
		resource.contents.add(createRelation(UNARY_RELATION_NAME))
		resource.contents.add(createRelation(BINARY_RELATION_NAME))
	}

	static def Relation createRelation(String relationName) {
		MondixSchemaFactory.eINSTANCE.createRelation => [
			name = relationName
		]
	}

}