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
		
	val Pattern pattern

	val List<PParameter> parameters

	override getParameters() {
		parameters
	}

	new(Pattern pattern, (PatternBody, PQuery) => PBody transformBody) {
		this.pattern = pattern
		parameters = pattern.parameters.map[toPParameter]
		pattern.annotations.forEach[toPAnnotation.addAnnotation]
		setBodies(pattern.bodies.map[transformBody.apply(it, this)].toSet)
	}
	
	override protected instantiate(IncQueryEngine engine) throws IncQueryException {
		GenericPatternMatcher.instantiate(engine, this)
	}

}
