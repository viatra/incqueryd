package hu.bme.mit.incqueryd.engine.rete.actors

import org.eclipse.incquery.runtime.rete.recipes.RecipesFactory
import org.eclipse.incquery.runtime.rete.recipes.TypeInputRecipe
import org.openrdf.model.Resource
import eu.mondo.driver.file.FileGraphDriverRead
import hu.bme.mit.incqueryd.engine.rete.nodes.TypeInputNode
import eu.mondo.driver.graph.RDFGraphDriverRead

case class RdfType(
  id: Resource,
  arity: Int,
  tupleCount: Long,
  traceInfo: String) {

  def getInputRecipe: TypeInputRecipe = {
    val recipe = if (arity == 1) RecipesFactory.eINSTANCE.createUnaryInputRecipe else RecipesFactory.eINSTANCE.createBinaryInputRecipe
    recipe.setTypeKey(id)
    recipe.setTypeName(id.stringValue)
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
      case Class => RdfType(id, 1, driver.countVertices(id.stringValue), TypeInputNode.VERTEX)
      case ObjectProperty => RdfType(id, 2, driver.countEdges(id.stringValue), TypeInputNode.EDGE)
      case DatatypeProperty => RdfType(id, 2, driver.countProperties(id.stringValue), TypeInputNode.ATTRIBUTE)
    }
  }

}