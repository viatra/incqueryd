package org.eclipse.incquery.patternlanguage.rdf.psystem

import java.util.List
import org.eclipse.incquery.patternlanguage.patternLanguage.Pattern
import org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.PatternModel
import org.eclipse.incquery.runtime.matchers.psystem.annotations.PAnnotation
import org.eclipse.incquery.runtime.matchers.psystem.queries.PParameter
import org.eclipse.incquery.runtime.matchers.psystem.queries.PQuery
import org.eclipse.incquery.runtime.matchers.psystem.queries.PQuery.PQueryStatus
import org.eclipse.incquery.runtime.matchers.psystem.PBody

class RdfPQuery implements PQuery {

	val Pattern pattern
	val List<PParameter> parameters
	val List<PAnnotation> annotations
	val PQueryStatus status
	val List<PBody> bodies

	new(Pattern pattern, PatternModel patternModel) {
		this.pattern = pattern
		parameters = pattern.parameters.map[parameter |
			new PParameter(parameter.name, parameter.type.typename)
		]
		annotations = pattern.annotations.map[annotation |
			new PAnnotation(annotation.name) => [
				// TODO
			]
		]
		bodies = pattern.bodies.map[body |
			new PBody(this) => [
				// TODO
			]
		]
		status = PQueryStatus.OK
	}

	override checkMutability() throws IllegalStateException {
	}

	override getAllAnnotations() {
		annotations
	}

	override getAllReferredQueries() {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}

	override getAnnotationsByName(String annotationName) {
		annotations.filter[name == annotationName].toList
	}

	override getDirectReferredQueries() {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}

	override getFirstAnnotationByName(String annotationName) {
		annotations.findFirst[name == annotationName]
	}

	override getFullyQualifiedName() {
		pattern.name
	}

	override getParameterNames() {
		parameters.map[name]
	}

	override getParameters() {
		parameters
	}

	override getPositionOfParameter(String parameterName) {
		val index = parameterNames.indexOf(parameterName)
		if (index == -1) null else index
	}

	override getStatus() {
		status
	}

	override isMutable() {
		false
	}

	override getDisjunctBodies() {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}

}