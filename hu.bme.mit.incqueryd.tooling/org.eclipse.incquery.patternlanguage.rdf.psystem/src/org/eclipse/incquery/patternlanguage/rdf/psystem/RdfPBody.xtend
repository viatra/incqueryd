package org.eclipse.incquery.patternlanguage.rdf.psystem

import org.eclipse.incquery.patternlanguage.patternLanguage.Pattern
import org.eclipse.incquery.patternlanguage.patternLanguage.PatternBody
import org.eclipse.incquery.runtime.matchers.psystem.PBody
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.ExportedParameter
import org.eclipse.incquery.runtime.matchers.psystem.queries.PQuery

import static extension org.eclipse.incquery.patternlanguage.rdf.psystem.PUtils.*

class RdfPBody {

	static def PBody create(PatternBody body, Pattern pattern, PQuery query, RdfPatternMatcherContext context) {
		new PBody(query) => [pBody |
			pBody.exportedParameters = pattern.parameters.map[parameter |
				new ExportedParameter(pBody, parameter.toPVariable(pBody), parameter.name)
			]
			pBody.constraints.addAll(pattern.parameters.map[parameter |
				parameter.toTypeConstraint(pBody, context)
			].filterNull)
			pBody.constraints.addAll(body.constraints.map[constraint |
				RdfPConstraint.create(constraint, pBody, context)
			])
		]
	}

}