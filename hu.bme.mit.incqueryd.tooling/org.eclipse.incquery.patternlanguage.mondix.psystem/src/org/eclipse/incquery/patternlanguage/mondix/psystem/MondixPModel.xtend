package org.eclipse.incquery.patternlanguage.mondix.psystem

import com.google.common.cache.CacheBuilder
import com.google.common.cache.LoadingCache
import java.util.List
import org.eclipse.incquery.patternlanguage.patternLanguage.Pattern
import org.eclipse.incquery.patternlanguage.patternLanguage.ValueReference
import org.eclipse.incquery.runtime.matchers.psystem.PBody
import org.eclipse.incquery.runtime.matchers.psystem.PVariable
import org.eclipse.incquery.runtime.matchers.psystem.queries.PQuery
import org.eclipse.incquery.runtime.matchers.tuple.FlatTuple
import org.eclipse.incquery.runtime.matchers.tuple.Tuple

import static extension org.eclipse.incquery.patternlanguage.mondix.psystem.MondixPQuery.*
import static extension org.eclipse.incquery.patternlanguage.mondix.psystem.MondixPVariable.*
import org.eclipse.incquery.patternlanguage.mondix.mondixPatternLanguage.MondixPatternModel
import eu.mondo.mondix.incquery.runtime.MondixPatternMatcherContext
import org.eclipse.incquery.runtime.api.IQuerySpecification
import org.eclipse.incquery.patternlanguage.util.psystem.GenericPQuery

public class MondixPModel {

	val MondixPatternModel patternModel

	public val MondixPatternMatcherContext context

	val LoadingCache<Pattern, GenericPQuery> queries = CacheBuilder.newBuilder.build[toPQuery(this)] // XXX due to this solution, recursive patterns are not supported

	def GenericPQuery findQueryOf(Pattern pattern) {
		queries.get(pattern)
	}

	new(MondixPatternModel patternModel) {
		this.patternModel = patternModel
		context = MondixPatternMatcherContext.STATIC_INSTANCE
	}

	def Tuple toTuple(List<ValueReference> valueReferences, PBody pBody) {
		val PVariable[] elements = valueReferences.map[toPVariable(pBody, this)]
		new FlatTuple(elements)
	}

}