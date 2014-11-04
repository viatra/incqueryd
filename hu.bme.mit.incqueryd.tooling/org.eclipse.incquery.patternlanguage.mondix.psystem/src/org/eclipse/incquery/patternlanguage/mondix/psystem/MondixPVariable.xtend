package org.eclipse.incquery.patternlanguage.mondix.psystem

import org.eclipse.incquery.patternlanguage.patternLanguage.AggregatedValue
import org.eclipse.incquery.patternlanguage.patternLanguage.BoolValue
import org.eclipse.incquery.patternlanguage.patternLanguage.CountAggregator
import org.eclipse.incquery.patternlanguage.patternLanguage.DoubleValue
import org.eclipse.incquery.patternlanguage.patternLanguage.IntValue
import org.eclipse.incquery.patternlanguage.patternLanguage.StringValue
import org.eclipse.incquery.patternlanguage.patternLanguage.ValueReference
import org.eclipse.incquery.patternlanguage.patternLanguage.VariableValue
import org.eclipse.incquery.runtime.matchers.psystem.PBody
import org.eclipse.incquery.runtime.matchers.psystem.PVariable
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.PatternMatchCounter

import static extension org.eclipse.incquery.patternlanguage.util.psystem.PUtils.*

class MondixPVariable {

	static def PVariable toPVariable(ValueReference it, PBody pBody, MondixPModel model) {
		switch it {
			IntValue: convertLiteralValue(value, pBody)
			DoubleValue: convertLiteralValue(value, pBody)
			BoolValue: convertLiteralValue(value, pBody)
			StringValue: convertLiteralValue(value, pBody)
			VariableValue: convertVariableValue(pBody)
			AggregatedValue: convertAggregatedValue(pBody, model)
			default: throw new IllegalArgumentException('''Unhandled case «it»''')
		}
	}

	def static convertLiteralValue(Object value, PBody pBody) {
		pBody.newConstantVariable(value)
	}

	static def PVariable convertVariableValue(VariableValue variableValue, PBody pBody) {
		variableValue.value.variable.toPVariable(pBody)
	}

	static def PVariable convertAggregatedValue(AggregatedValue aggregatedValue, PBody pBody, MondixPModel model) {
		val result = pBody.newVirtualVariable
        val call = aggregatedValue.call
        val patternRef = call.patternRef
        val calledQuery = model.findQueryOf(patternRef)
        val tuple = model.toTuple(call.parameters, pBody)
        switch aggregator : aggregatedValue.aggregator {
        	CountAggregator: new PatternMatchCounter(pBody, tuple, calledQuery, result) // XXX side-effect
        	default: throw new RuntimeException('''Unsupported aggregator expression «aggregator»''')
        }
        result
	}

}