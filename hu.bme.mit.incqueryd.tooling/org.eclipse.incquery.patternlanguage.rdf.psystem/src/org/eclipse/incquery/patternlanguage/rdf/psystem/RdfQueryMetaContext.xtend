package org.eclipse.incquery.patternlanguage.rdf.psystem

import com.google.common.collect.Iterables
import java.util.List
import org.eclipse.incquery.runtime.matchers.context.IInputKey
import org.eclipse.incquery.runtime.matchers.context.IQueryMetaContext
import org.eclipse.incquery.runtime.matchers.context.InputKeyImplication
import org.openrdf.model.Model
import org.openrdf.model.Resource
import org.openrdf.model.URI
import org.openrdf.model.vocabulary.RDFS

class RdfQueryMetaContext implements IQueryMetaContext {

	val Model vocabulary

	new(Model vocabulary) {
		this.vocabulary = vocabulary
	}

	override isEnumerable(IInputKey key) {
		key.enumerable
	}
	
	override isStateless(IInputKey key) {
		true
	}

	override getFunctionalDependencies(IInputKey key) {
		switch key {
			RdfInputKey: {
				if (isFeatureMultiplicityToOne(key))
	    			#{#{0} -> #{1}}
	    		else if (isFeatureMultiplicityOneTo(key))
	    			#{#{0} -> #{1}}
	    		else
	    			emptyMap
			}
			default: {
				emptyMap
			}
		}
	}

	def isFeatureMultiplicityToOne(RdfInputKey key) {
		false // TODO SPARQL? based on http://www.w3.org/TR/owl-guide/#owl_cardinality
    }

    def isFeatureMultiplicityOneTo(RdfInputKey key) {
		false // TODO SPARQL? based on http://www.w3.org/TR/owl-guide/#owl_cardinality
    }
	
	override getImplications(IInputKey implyingKey) {
		switch implyingKey {
			RdfInputKey: {
				switch implyingKey.arity {
					case 1: {
						val directSupertypes = implyingKey.query(RDFS.SUBCLASSOF).toImplications(implyingKey, #[0])
						directSupertypes
					}
					case 2: {
						val sourceTypes = implyingKey.query(RDFS.DOMAIN).toImplications(implyingKey, #[0])
						val targetTypes = implyingKey.query(RDFS.RANGE).toImplications(implyingKey, #[1])
						val directEdgesSupertypes = implyingKey.query(RDFS.SUBPROPERTYOF).toImplications(implyingKey, #[0, 1])
						Iterables.concat(sourceTypes, targetTypes, directEdgesSupertypes).toSet
					}
				}
			}
			default: {
				emptySet
			}
		}
	}

	private def query(RdfInputKey key, URI predicate) {
		vocabulary.filter(key.wrappedKey, predicate, null).map[object].filter(Resource)
	}
	
	private def toImplications(Iterable<Resource> resources, RdfInputKey implyingKey, List<Integer> indices) {
		resources.map[new InputKeyImplication(implyingKey, new RdfInputKey(it, 1), indices)].toSet
	}

}