package hu.bme.mit.incqueryd.engine.rete.actors

import org.eclipse.incquery.runtime.rete.recipes.RecipesFactory
import org.eclipse.incquery.runtime.rete.recipes.InputRecipe
import org.openrdf.model.Resource
import eu.mondo.driver.file.FileGraphDriverRead
import hu.bme.mit.incqueryd.engine.rete.nodes.InputNode
import eu.mondo.driver.graph.RDFGraphDriverRead

case class RdfType(
  id: Resource,
  arity: Int,
  tupleCount: Long,
  traceInfo: String) {

  def getInputRecipe: InputRecipe = {
    val recipe = RecipesFactory.eINSTANCE.createInputRecipe
    recipe.setKeyArity(arity)
    recipe.setInputKey(id)
    recipe.setKeyID(id.stringValue)
    recipe.setTraceInfo(traceInfo)
    recipe
  }

}

object RdfType {

  sealed trait Kind 
  case object Class extends Kind
  case object ObjectProperty extends Kind
  case object DatatypeProperty extends Kind

  def apply(kind: Kind, id: Resource, driver: RDFGraphDriverRead): RdfType = {
    kind match {
      case Class => RdfType(id, 1, driver.countVertices(id.stringValue), InputNode.VERTEX)
      case ObjectProperty => RdfType(id, 2, driver.countEdges(id.stringValue), InputNode.EDGE)
      case DatatypeProperty => RdfType(id, 2, driver.countProperties(id.stringValue), InputNode.ATTRIBUTE)
    }
  }

}