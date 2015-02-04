package hu.bme.mit.incqueryd.engine

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

  sealed trait Type 
  case object Class extends Type
  case object ObjectProperty extends Type
  case object DatatypeProperty extends Type

  def apply(`type`: Type, id: Resource, driver: FileGraphDriverRead): RdfType = {
    `type` match {
      case Class => RdfType(id, 1, driver.countVertices(id.stringValue))
      case ObjectProperty => RdfType(id, 2, driver.countEdges(id.stringValue))
      case DatatypeProperty => RdfType(id, 2, driver.countProperties(id.stringValue))
    }
  }

}