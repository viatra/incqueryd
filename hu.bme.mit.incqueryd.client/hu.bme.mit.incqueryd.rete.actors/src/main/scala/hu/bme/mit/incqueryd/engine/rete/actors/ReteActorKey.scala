package hu.bme.mit.incqueryd.engine.rete.actors

import org.eclipse.incquery.runtime.rete.recipes.ReteNodeRecipe

case class ReteActorKey private (val internalId: String)

object ReteActorKey {

  def apply(recipe: ReteNodeRecipe): ReteActorKey = {
    ReteActorKey(recipe.eResource().getURIFragment(recipe))
  }
 
}