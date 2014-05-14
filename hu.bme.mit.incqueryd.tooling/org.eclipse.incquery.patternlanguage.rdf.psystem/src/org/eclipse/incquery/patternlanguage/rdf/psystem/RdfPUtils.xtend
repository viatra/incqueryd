package org.eclipse.incquery.patternlanguage.rdf.psystem

import java.util.List
import org.eclipse.incquery.patternlanguage.patternLanguage.Pattern
import org.eclipse.incquery.patternlanguage.patternLanguage.ValueReference
import org.eclipse.incquery.runtime.matchers.psystem.PBody
import org.eclipse.incquery.runtime.matchers.psystem.queries.PQuery
import org.eclipse.incquery.runtime.matchers.tuple.FlatTuple
import org.eclipse.incquery.runtime.matchers.tuple.Tuple

import static extension org.eclipse.incquery.patternlanguage.rdf.psystem.RdfPVariable.*

class RdfPUtils {

	static def Tuple toTuple(List<ValueReference> valueReferences, PBody pBody) {
		val elements = valueReferences.map[toPVariable(pBody)]
		new FlatTuple(elements)
	}

	static def PQuery findQueryOf(Pattern pattern) {
		// TODO
	}

}