package org.eclipse.incquery.patternlanguage.rdf.psystem

import com.google.common.cache.CacheBuilder
import com.google.common.cache.LoadingCache
import java.util.List
import org.eclipse.incquery.patternlanguage.patternLanguage.Pattern
import org.eclipse.incquery.patternlanguage.patternLanguage.ValueReference
import org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.RdfPatternModel
import org.eclipse.incquery.runtime.matchers.psystem.PBody
import org.eclipse.incquery.runtime.matchers.psystem.PVariable
import org.eclipse.incquery.runtime.matchers.psystem.queries.PQuery
import org.eclipse.incquery.runtime.matchers.tuple.FlatTuple
import org.eclipse.incquery.runtime.matchers.tuple.Tuple

import static extension org.eclipse.incquery.patternlanguage.rdf.RdfPatternLanguageUtils.*
import static extension org.eclipse.incquery.patternlanguage.rdf.psystem.RdfPQuery.*
import static extension org.eclipse.incquery.patternlanguage.rdf.psystem.RdfPVariable.*

class RdfPModel {

	val RdfPatternModel patternModel

	public val RdfPatternMatcherContext context

	val LoadingCache<Pattern, PQuery> queries = CacheBuilder.newBuilder.build[toPQuery(this)] // XXX due to this solution, recursive patterns are not supported

	def PQuery findQueryOf(Pattern pattern) {
		queries.get(pattern)
	}

	new(RdfPatternModel patternModel) {
		this.patternModel = patternModel
		val vocabulary = patternModel.vocabulary
		context = new RdfPatternMatcherContext(vocabulary)
	}

	def Tuple toTuple(List<ValueReference> valueReferences, PBody pBody) {
		val PVariable[] elements = valueReferences.map[toPVariable(pBody, this)]
		new FlatTuple(elements)
	}

}