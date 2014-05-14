package org.eclipse.incquery.patternlanguage.rdf.psystem

import org.eclipse.incquery.patternlanguage.patternLanguage.ValueReference
import org.eclipse.incquery.patternlanguage.patternLanguage.VariableValue
import org.eclipse.incquery.runtime.matchers.psystem.PBody
import org.eclipse.incquery.runtime.matchers.psystem.PVariable

import static extension org.eclipse.incquery.patternlanguage.rdf.psystem.PUtils.*
import org.eclipse.incquery.patternlanguage.patternLanguage.AggregatedValue

class RdfPVariable {

	static def PVariable toPVariable(ValueReference it, PBody pBody) {
		switch it {
			VariableValue: convertVariableValue(pBody)
			AggregatedValue: convertAggregatedValue(pBody)
			// TODO
			default: throw new IllegalArgumentException('''Unhandled case «it»''')
		}
	}

	static def PVariable convertVariableValue(VariableValue variableValue, PBody pBody) {
		variableValue.value.variable.toPVariable(pBody)
	}

	static def PVariable convertAggregatedValue(AggregatedValue aggregatedValue, PBody pBody) {
		// TODO
	}

}
