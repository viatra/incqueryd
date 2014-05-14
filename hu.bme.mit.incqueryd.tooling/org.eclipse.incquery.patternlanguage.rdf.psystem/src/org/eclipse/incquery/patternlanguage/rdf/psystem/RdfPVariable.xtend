package org.eclipse.incquery.patternlanguage.rdf.psystem

import org.eclipse.incquery.patternlanguage.patternLanguage.AggregatedValue
import org.eclipse.incquery.patternlanguage.patternLanguage.BoolValue
import org.eclipse.incquery.patternlanguage.patternLanguage.CountAggregator
import org.eclipse.incquery.patternlanguage.patternLanguage.DoubleValue
import org.eclipse.incquery.patternlanguage.patternLanguage.IntValue
import org.eclipse.incquery.patternlanguage.patternLanguage.StringValue
import org.eclipse.incquery.patternlanguage.patternLanguage.ValueReference
import org.eclipse.incquery.patternlanguage.patternLanguage.VariableValue
import org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.RdfLiteral
import org.eclipse.incquery.runtime.matchers.psystem.PBody
import org.eclipse.incquery.runtime.matchers.psystem.PVariable
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.PatternMatchCounter

import static extension org.eclipse.incquery.patternlanguage.rdf.psystem.PUtils.*
import static extension org.eclipse.incquery.patternlanguage.rdf.psystem.RdfPUtils.*

class RdfPVariable {

	static def PVariable toPVariable(ValueReference it, PBody pBody) {
		switch it {
			IntValue: convertLiteralValue(value, pBody)
			DoubleValue: convertLiteralValue(value, pBody)
			BoolValue: convertLiteralValue(value, pBody)
			StringValue: convertLiteralValue(value, pBody)
			RdfLiteral: convertLiteralValue(it, pBody)
			VariableValue: convertVariableValue(pBody)
			AggregatedValue: convertAggregatedValue(pBody)
			default: throw new IllegalArgumentException('''Unhandled case «it»''')
		}
	}

	def static convertLiteralValue(Object value, PBody pBody) {
		pBody.newConstantVariable(value)
	}

	static def PVariable convertVariableValue(VariableValue variableValue, PBody pBody) {
		variableValue.value.variable.toPVariable(pBody)
	}

	static def PVariable convertAggregatedValue(AggregatedValue aggregatedValue, PBody pBody) {
		val result = pBody.newVirtualVariable
        val call = aggregatedValue.call
        val patternRef = call.patternRef
        val calledQuery = findQueryOf(patternRef)
        val tuple = call.parameters.toTuple(pBody)
        switch aggregatedValue.aggregator {
        	CountAggregator: new PatternMatchCounter(pBody, tuple, calledQuery, result) // XXX side-effect
        	default: throw new RuntimeException("Unsupported aggregator expression")
        }
        result
	}

}
