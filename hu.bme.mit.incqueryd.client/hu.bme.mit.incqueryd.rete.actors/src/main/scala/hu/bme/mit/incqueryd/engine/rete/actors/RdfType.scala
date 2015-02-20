package hu.bme.mit.incqueryd.engine.rete.actors

import org.eclipse.incquery.runtime.rete.recipes.RecipesFactory
import org.eclipse.incquery.runtime.rete.recipes.TypeInputRecipe
import org.openrdf.model.Resource
import eu.mondo.driver.file.FileGraphDriverRead

case class RdfType(
  id: Resource,
  arity: Int,
  tupleCount: Long) {

  def getInputRecipe: TypeInputRecipe = {
    val recipe = if (arity == 1) RecipesFactory.eINSTANCE.createUnaryInputRecipe else RecipesFactory.eINSTANCE.createBinaryInputRecipe
    recipe.setTypeKey(id)
    recipe.setTypeName(id.stringValue)
    recipe
  }

}

object RdfType {

  sealed trait Kind 
  case object Class extends Kind
  case object ObjectProperty extends Kind
  case object DatatypeProperty extends Kind

  def apply(kind: Kind, id: Resource, driver: FileGraphDriverRead): RdfType = {
    kind match {
      case Class => RdfType(id, 1, driver.countVertices(id.stringValue))
      case ObjectProperty => RdfType(id, 2, driver.countEdges(id.stringValue))
      case DatatypeProperty => RdfType(id, 2, driver.countProperties(id.stringValue))
    }
  }

}