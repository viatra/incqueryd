package hu.bme.mit.incqueryd.engine.rete.actors

import org.eclipse.incquery.runtime.rete.recipes.ReteNodeRecipe
import org.eclipse.incquery.runtime.rete.recipes.TypeInputRecipe
import java.net.URLEncoder
import java.security.MessageDigest

case class ReteActorKey private (val internalId: String)

object ReteActorKey {

  def apply(recipe: ReteNodeRecipe): ReteActorKey = {
    recipe match {
      case recipe: TypeInputRecipe => ReteActorKey(recipe)
      case _ => ReteActorKey(URLEncoder.encode(recipe.eResource().getURIFragment(recipe), "UTF-8"))
    }
  }
  
  def apply(recipe: TypeInputRecipe): ReteActorKey = {
    val inputName = recipe.getTypeName.split("#").last
    ReteActorKey(URLEncoder.encode(inputName, "UTF-8"))
  }
}