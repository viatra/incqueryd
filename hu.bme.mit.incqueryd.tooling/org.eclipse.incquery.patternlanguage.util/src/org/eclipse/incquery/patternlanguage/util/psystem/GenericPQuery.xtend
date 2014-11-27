package org.eclipse.incquery.patternlanguage.util.psystem

import java.io.Serializable
import java.util.List
import org.eclipse.incquery.patternlanguage.patternLanguage.Pattern
import org.eclipse.incquery.patternlanguage.patternLanguage.PatternBody
import org.eclipse.incquery.runtime.api.GenericQuerySpecification
import org.eclipse.incquery.runtime.api.IncQueryEngine
import org.eclipse.incquery.runtime.exception.IncQueryException
import org.eclipse.incquery.runtime.matchers.psystem.PBody
import org.eclipse.incquery.runtime.matchers.psystem.queries.PParameter
import org.eclipse.incquery.runtime.matchers.psystem.queries.PQuery

import static extension org.eclipse.incquery.patternlanguage.util.psystem.PUtils.*

abstract class GenericPQuery extends GenericQuerySpecification<GenericPatternMatcher> implements Serializable {
	
	override protected doGetContainedBodies() throws IncQueryException {
		throw new IllegalStateException("Should already be initialized")
	}
			
	override getFullyQualifiedName() {
		pattern.name
	}
		
	// Annotations
//	val List<PAnnotation> annotations
	val Pattern pattern
//
//	override getAllAnnotations() {
//		annotations
//	}
//
//	override getAnnotationsByName(String annotationName) { // TODO extract this unorthogonal logic
//		annotations.filter[name == annotationName].toList
//	}
//
//	override getFirstAnnotationByName(String annotationName) { // TODO extract this unorthogonal logic
//		annotations.findFirst[name == annotationName]
//	}
//
	// Parameters
	val List<PParameter> parameters

	override getParameters() {
		parameters
	}

//	override getParameterNames() { // TODO extract this unorthogonal logic
//		parameters.map[name]
//	}
//
//	override getPositionOfParameter(String parameterName) { // TODO extract this unorthogonal logic
//		val index = parameterNames.indexOf(parameterName)
//		if(index == -1) null else index
//	}
//
//	// Status
//	val status = PQuery.PQueryStatus.OK
//
//	override getStatus() {
//		status
//	}
//
//	// Mutability
//	override isMutable() {
//		false
//	}
//
//	override checkMutability() throws IllegalStateException {
//	}
//
//	// Bodies
//	val PDisjunction disjunction
//
//	override getDisjunctBodies() {
//		disjunction
//	}
//
//	// Referred queries
//	override getDirectReferredQueries() { // TODO extract this unorthogonal logic
//		disjunctBodies.bodies.map [ body |
//			body.constraints.filter(IQueryReference).map[referredQuery]
//		].flatten.toSet
//	}
//
//	override getAllReferredQueries() { // TODO extract this unorthogonal logic
//		val processedQueries = Sets.newHashSet(this as PQuery)
//		val foundQueries = directReferredQueries
//		val newQueries = Sets.newHashSet(foundQueries)
//		while (!processedQueries.containsAll(newQueries)) {
//			val query = newQueries.iterator.next
//			processedQueries.add(query)
//			newQueries.remove(query)
//			val referred = query.directReferredQueries
//			referred.removeAll(processedQueries)
//			foundQueries.addAll(referred)
//			newQueries.addAll(referred)
//		}
//		foundQueries
//	}
//
//	// Name
//	val String fullyQualifiedName
//
//	override getFullyQualifiedName() {
//		fullyQualifiedName
//	}
//
	new(Pattern pattern, (PatternBody, PQuery) => PBody transformBody) {
		this.pattern = pattern
		parameters = pattern.parameters.map[toPParameter]
		pattern.annotations.forEach[toPAnnotation.addAnnotation]
		setBodies(pattern.bodies.map[transformBody.apply(it, this)].toSet)
//		disjunction = new PDisjunction(this, bodies)
//		fullyQualifiedName = pattern.name
	}
	
	override protected instantiate(IncQueryEngine engine) throws IncQueryException {
		GenericPatternMatcher.instantiate(engine, this)
	}
	
//
//	override getPProblems() {
//		#[]
//	}
//
//	override equals(Object q) {
//		if (!(q instanceof GenericPQuery)) false else pattern.equals((q as GenericPQuery).pattern)
//	}
//
//	override hashCode() {
//		pattern.hashCode
//	}

}
