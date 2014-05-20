package org.eclipse.incquery.patternlanguage.rdf.psystem

import com.google.common.cache.Cache
import com.google.common.cache.CacheBuilder
import hu.bme.mit.incqueryd.rdf.RdfUtils
import java.net.URL
import java.util.List
import org.eclipse.incquery.patternlanguage.patternLanguage.Pattern
import org.eclipse.incquery.patternlanguage.patternLanguage.ValueReference
import org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.RdfPatternModel
import org.eclipse.incquery.runtime.matchers.psystem.PBody
import org.eclipse.incquery.runtime.matchers.psystem.queries.PQuery
import org.eclipse.incquery.runtime.matchers.tuple.FlatTuple
import org.eclipse.incquery.runtime.matchers.tuple.Tuple

import static extension org.eclipse.incquery.patternlanguage.rdf.psystem.RdfPVariable.*

class RdfPModel {

	val RdfPatternModel patternModel

	public val RdfPatternMatcherContext context

	val Cache<Pattern, PQuery> queries = CacheBuilder.newBuilder.build[pattern |
		new RdfPQuery(pattern, this)
	]

	def PQuery findQueryOf(Pattern pattern) {
		queries.get(pattern)
	}

	new(RdfPatternModel patternModel) {
		this.patternModel = patternModel
		val vocabulary = RdfUtils.load(patternModel.vocabularies.map[new URL(location)].toSet)
		context = new RdfPatternMatcherContext(vocabulary)
	}

	def Tuple toTuple(List<ValueReference> valueReferences, PBody pBody) {
		val elements = valueReferences.map[toPVariable(pBody, this)]
		new FlatTuple(elements)
	}

}