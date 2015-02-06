package hu.bme.mit.incqueryd.engine

import org.eclipse.incquery.runtime.rete.recipes.TypeInputRecipe
import org.eclipse.incquery.runtime.rete.recipes.ReteNodeRecipe
import org.eclipse.incquery.runtime.rete.recipes.TrimmerRecipe
import org.eclipse.incquery.runtime.rete.recipes.AlphaRecipe
import org.eclipse.incquery.runtime.rete.recipes.CheckRecipe
import org.eclipse.incquery.runtime.rete.recipes.JoinRecipe
import org.eclipse.incquery.runtime.rete.recipes.BetaRecipe
import org.eclipse.incquery.runtime.rete.recipes.AntiJoinRecipe
import org.eclipse.incquery.runtime.rete.recipes.ConstantRecipe
import org.eclipse.incquery.runtime.rete.recipes.MultiParentNodeRecipe
import scala.collection.JavaConversions._
import org.eclipse.incquery.runtime.rete.recipes.ProductionRecipe
import org.eclipse.incquery.runtime.matchers.psystem.queries.PQuery
import org.eclipse.emf.ecore.EObject

object RecipeUtils {

  def getNormalizedTupleCount(recipe: ReteNodeRecipe, types: Set[RdfType]): Long = {
    recipe match {
      case recipe: TypeInputRecipe => {
        val arity = recipe.getArity
        val tupleCount: Long = findType(types, recipe).map(_.tupleCount).getOrElse(0)
        arity * tupleCount
      }
      case recipe: TrimmerRecipe => {
    	val arity = recipe.getArity
        val tupleCount = (getEstimatedMemoryUsageMb(recipe.getParent, types) * 0.9).toLong
        arity * tupleCount
      }
      case recipe: CheckRecipe => {
        val arity = recipe.getArity
        val tupleCount = (getEstimatedMemoryUsageMb(recipe.getParent, types) * 0.1).toLong
        arity * tupleCount
      }
      case recipe: BetaRecipe => {
        val leftArity = recipe.getLeftParent.getParent.getArity
        val leftTuples = getNormalizedTupleCount(recipe.getLeftParent, types)
        val rightArity = recipe.getRightParent.getParent.getArity
        val rightTuples = getNormalizedTupleCount(recipe.getRightParent, types)
        leftArity * leftTuples + rightArity * rightTuples
      }
      case recipe: ConstantRecipe => recipe.getArity
      case recipe: MultiParentNodeRecipe => { // TODO better heuristics later
    	val arity = recipe.getParents.map(_.getArity).max
    	val tupleCount = recipe.getParents.map(getNormalizedTupleCount(_, types)).sum
    	arity * tupleCount
      }
      case _ => 0
    }
  }

  def getEstimatedMemoryUsageMb(recipe: ReteNodeRecipe, types: Set[RdfType]): Long = {
    val normalizedTupleCount = getNormalizedTupleCount(recipe, types)
    val memoryUsage = Math.ceil((0.0003 * normalizedTupleCount + 52.969) * 1.4).toLong
    Math.max(128, memoryUsage)
  }

  def getName(recipe: ReteNodeRecipe): String = {
    recipe match {
      case recipe: TypeInputRecipe => recipe.getTypeName
      // TODO more cases
      case _ => recipe.toString
    }
  }
  
  def findType(types: Set[RdfType], recipe: TypeInputRecipe): Option[RdfType] = {
    types.find(_.id.stringValue == recipe.getTypeName)
  }

  def getEmfId(eObject: EObject): String = {
    eObject.eResource().getURIFragment(eObject)
  }

}