package org.eclipse.incquery.patternlanguage.rdf.psystem

import org.eclipse.incquery.patternlanguage.patternLanguage.ParameterRef
import org.eclipse.incquery.patternlanguage.patternLanguage.Pattern
import org.eclipse.incquery.patternlanguage.patternLanguage.PatternBody
import org.eclipse.incquery.patternlanguage.patternLanguage.Variable
import org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.RdfClass
import org.eclipse.incquery.runtime.matchers.psystem.PBody
import org.eclipse.incquery.runtime.matchers.psystem.PVariable
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.ExportedParameter
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeUnary
import org.eclipse.incquery.runtime.matchers.psystem.queries.PQuery

class RdfPBody {

	static def PBody create(PatternBody body, Pattern pattern, PQuery query, RdfPatternMatcherContext context) {
		new PBody(query) => [pBody |
			pBody.exportedParameters = pattern.parameters.map[parameter |
				new ExportedParameter(pBody, parameter.toPVariable(pBody), parameter.name)
			]
			pBody.constraints.addAll(pattern.parameters.map[parameter |
				switch type : parameter.type {
					RdfClass: {
						val pVariable = parameter.toPVariable(pBody)
						#[new TypeUnary(pBody, pVariable, type, context.printType(type))]
					}
					default: #[]
				}
			].flatten)
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