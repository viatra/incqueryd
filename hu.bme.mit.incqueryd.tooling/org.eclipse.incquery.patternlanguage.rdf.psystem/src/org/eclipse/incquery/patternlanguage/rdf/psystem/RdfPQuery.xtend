package org.eclipse.incquery.patternlanguage.rdf.psystem

import com.google.common.collect.Sets
import java.util.List
import org.eclipse.incquery.patternlanguage.patternLanguage.Pattern
import org.eclipse.incquery.runtime.matchers.psystem.IQueryReference
import org.eclipse.incquery.runtime.matchers.psystem.annotations.PAnnotation
import org.eclipse.incquery.runtime.matchers.psystem.queries.PDisjunction
import org.eclipse.incquery.runtime.matchers.psystem.queries.PParameter
import org.eclipse.incquery.runtime.matchers.psystem.queries.PQuery

import static extension org.eclipse.incquery.patternlanguage.util.psystem.PUtils.*
import static extension org.eclipse.incquery.patternlanguage.rdf.psystem.RdfPBody.*
import java.io.Serializable

class RdfPQuery implements PQuery, Serializable {

	// Annotations
	val List<PAnnotation> annotations
	val Pattern pattern

	override getAllAnnotations() {
		annotations
	}

	override getAnnotationsByName(String annotationName) { // TODO extract this unorthogonal logic
		annotations.filter[name == annotationName].toList
	}

	override getFirstAnnotationByName(String annotationName) { // TODO extract this unorthogonal logic
		annotations.findFirst[name == annotationName]
	}

	// Parameters
	val List<PParameter> parameters

	override getParameters() {
		parameters
	}

	override getParameterNames() { // TODO extract this unorthogonal logic
		parameters.map[name]
	}

	override getPositionOfParameter(String parameterName) { // TODO extract this unorthogonal logic
		val index = parameterNames.indexOf(parameterName)
		if(index == -1) null else index
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
	override getDirectReferredQueries() { // TODO extract this unorthogonal logic
		disjunctBodies.bodies.map [ body |
			body.constraints.filter(IQueryReference).map[referredQuery]
		].flatten.toSet
	}

	override getAllReferredQueries() { // TODO extract this unorthogonal logic
		val processedQueries = Sets.newHashSet(this as PQuery)
		val foundQueries = directReferredQueries
		val newQueries = Sets.newHashSet(foundQueries)
		while (!processedQueries.containsAll(newQueries)) {
			val query = newQueries.iterator.next
			processedQueries.add(query)
			newQueries.remove(query)
			val referred = query.directReferredQueries
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

	new(Pattern pattern, RdfPModel model) {
		this.pattern = pattern
		parameters = pattern.parameters.map[toPParameter]
		annotations = pattern.annotations.map[toPAnnotation]
		val bodies = pattern.bodies.map[toPBody(pattern, this, model)].toSet
		disjunction = new PDisjunction(this, bodies)
		fullyQualifiedName = pattern.name
	}

	override getPProblems() {
		#[]
	}

	override equals(Object q) {
		if (!(q instanceof RdfPQuery)) return false

		pattern.equals((q as RdfPQuery).pattern)
	}

	override hashCode() {
		return pattern.hashCode
	}

}
