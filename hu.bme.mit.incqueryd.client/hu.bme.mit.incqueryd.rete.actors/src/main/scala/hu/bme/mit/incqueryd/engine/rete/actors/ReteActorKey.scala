package hu.bme.mit.incqueryd.engine.rete.actors

import org.eclipse.incquery.runtime.rete.recipes.ReteNodeRecipe
import org.eclipse.incquery.runtime.rete.recipes.TypeInputRecipe
import java.net.URLEncoder
import java.security.MessageDigest

case class ReteActorKey private (val internalId: String)

object ReteActorKey {

  def apply(recipe: ReteNodeRecipe): ReteActorKey = {
    recipe match {
      case recipe: TypeInputRecipe => fromString(recipe.getTypeName)
      case _ => fromString(recipe.eResource().getURIFragment(recipe))
    }
  }
  
  def fromString(keyId: String): ReteActorKey = {
    ReteActorKey(URLEncoder.encode(keyId, "UTF-8"))
  }
}