package org.eclipse.incquery.patternlanguage.rdf.psystem

import org.eclipse.incquery.patternlanguage.patternLanguage.PatternBody
import org.eclipse.incquery.runtime.matchers.psystem.queries.PQuery
import org.eclipse.incquery.runtime.matchers.psystem.PBody
import org.eclipse.incquery.patternlanguage.patternLanguage.Pattern
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.ExportedParameter
import org.eclipse.incquery.runtime.matchers.psystem.PVariable
import org.eclipse.incquery.patternlanguage.patternLanguage.Variable
import org.eclipse.incquery.patternlanguage.patternLanguage.ParameterRef

class RdfPBody {

	static def PBody create(PatternBody body, Pattern pattern, PQuery query) {
		new PBody(query) => [pBody |
			pBody.exportedParameters = pattern.parameters.map[parameter |
				new ExportedParameter(pBody, parameter.toPVariable(pBody), parameter.name)
			]
			pBody.constraints.addAll(pattern.parameters.filter[type != null].map[parameter |
				// TODO type constraint
			])
			pBody.constraints.addAll(body.constraints.map[RdfPConstraint.create(it)])
		]
	}

	static def PVariable toPVariable(Variable variable, PBody pBody) { // TODO this code exists in EPMToBody, move it to generic pattern language project
		switch variable {
			ParameterRef: variable.referredParam.toPVariable(pBody)
			default: pBody.getOrCreateVariableByName(variable.name)
		}
	}

}