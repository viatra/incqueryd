package org.eclipse.incquery.patternlanguage.rdf.psystem

import java.util.List
import org.eclipse.incquery.patternlanguage.patternLanguage.Pattern
import org.eclipse.incquery.runtime.matchers.psystem.annotations.PAnnotation
import org.eclipse.incquery.runtime.matchers.psystem.queries.PParameter
import org.eclipse.incquery.runtime.matchers.psystem.queries.PQuery
import org.eclipse.incquery.runtime.matchers.psystem.queries.PQuery.PQueryStatus
import org.eclipse.incquery.runtime.matchers.psystem.queries.PDisjunction
import org.eclipse.incquery.patternlanguage.patternLanguage.Annotation
import org.eclipse.incquery.patternlanguage.patternLanguage.ValueReference
import org.eclipse.incquery.patternlanguage.patternLanguage.BoolValue
import org.eclipse.incquery.patternlanguage.patternLanguage.DoubleValue
import org.eclipse.incquery.patternlanguage.patternLanguage.IntValue
import org.eclipse.incquery.patternlanguage.patternLanguage.StringValue
import org.eclipse.incquery.patternlanguage.patternLanguage.VariableReference
import org.eclipse.incquery.patternlanguage.patternLanguage.VariableValue
import org.eclipse.incquery.patternlanguage.patternLanguage.ListValue
import org.eclipse.incquery.patternlanguage.patternLanguage.Variable
import org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.RdfPatternModel
import org.eclipse.incquery.runtime.matchers.psystem.IQueryReference
import com.google.common.collect.Sets

class RdfPQuery implements PQuery {

	// Annotations

	val List<PAnnotation> annotations

	override getAllAnnotations() {
		annotations
	}

	override getAnnotationsByName(String annotationName) {
		annotations.filter[name == annotationName].toList
	}

	override getFirstAnnotationByName(String annotationName) {
		annotations.findFirst[name == annotationName]
	}

	static def PAnnotation toPAnnotation(Annotation annotation) {
		new PAnnotation(annotation.name) => [
			for (parameter : annotation.parameters) {
				addAttribute(parameter.name, getValue(parameter.value))
			}
		]
    }

    static def Object getValue(ValueReference it) { // TODO this code exists in EPMToBody, move it to generic pattern language project
    	switch it {
    		BoolValue: value
    		DoubleValue: value
    		IntValue: value
    		StringValue: value
    		VariableReference: ^var
    		VariableValue: value.^var
    		ListValue: values.map[value]
    		default: throw new IllegalArgumentException("Unknown attribute parameter type")
    	}
    }

	// Parameters

	val List<PParameter> parameters

	override getParameters() {
		parameters
	}

	override getParameterNames() {
		parameters.map[name]
	}

	override getPositionOfParameter(String parameterName) {
		val index = parameterNames.indexOf(parameterName)
		if (index == -1) null else index
	}

	static def PParameter toPParameter(Variable parameter) {
		new PParameter(parameter.name, parameter.type.typename)
	}

	// Status

	val PQueryStatus status

	override getStatus() {
		status
	}

	// Mutability

	override isMutable() {
		false
	}

	override checkMutability() throws IllegalStateException {
	}

	// Bodies

	val PDisjunction disjunction

	override getDisjunctBodies() {
		disjunction
	}

	// Referred queries

	override getDirectReferredQueries() { // TODO this code exists in BaseQuerySpecification, move it to generic pattern language project
		disjunctBodies.bodies.map[body |
			body.constraints.filter(IQueryReference).map[referredQuery]
		].flatten.toSet
	}

	override getAllReferredQueries() { // TODO this code exists in BaseQuerySpecification, move it to generic pattern language project
		val processedQueries = Sets.newHashSet(this as PQuery)
        val foundQueries = getDirectReferredQueries()
        val newQueries = Sets.newHashSet(foundQueries)

        while (!processedQueries.containsAll(newQueries)) {
			val query = newQueries.iterator().next()
			processedQueries.add(query)
			newQueries.remove(query)
			val referred = query.getDirectReferredQueries()
			referred.removeAll(processedQueries)
			foundQueries.addAll(referred)
			newQueries.addAll(referred)
		}
        foundQueries
	}

	// Name

	val String fullyQualifiedName

	override getFullyQualifiedName() {
		fullyQualifiedName
	}

	new(Pattern pattern, RdfPatternModel patternModel) {
		parameters = pattern.parameters.map[toPParameter]
		annotations = pattern.annotations.map[toPAnnotation]
		disjunction = new PDisjunction(this, pattern.bodies.map[body | RdfPBody.create(body, pattern, this)].toSet)
		status = PQueryStatus.OK
		fullyQualifiedName = pattern.name
	}

}