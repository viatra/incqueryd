package org.eclipse.incquery.patternlanguage.rdf.psystem

import com.google.common.collect.Sets
import java.util.List
import org.eclipse.incquery.patternlanguage.patternLanguage.Pattern
import org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.RdfPatternModel
import org.eclipse.incquery.runtime.matchers.psystem.IQueryReference
import org.eclipse.incquery.runtime.matchers.psystem.annotations.PAnnotation
import org.eclipse.incquery.runtime.matchers.psystem.queries.PDisjunction
import org.eclipse.incquery.runtime.matchers.psystem.queries.PParameter
import org.eclipse.incquery.runtime.matchers.psystem.queries.PQuery

import static extension org.eclipse.incquery.patternlanguage.rdf.psystem.PUtils.*

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

	// Status

	val status = PQuery.PQueryStatus.OK

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

	new(Pattern pattern, RdfPatternModel patternModel, RdfPatternMatcherContext context) {
		parameters = pattern.parameters.map[toPParameter]
		annotations = pattern.annotations.map[toPAnnotation]
		disjunction = new PDisjunction(this, pattern.bodies.map[body | RdfPBody.create(body, pattern, this, context)].toSet)
		fullyQualifiedName = pattern.name
	}

}