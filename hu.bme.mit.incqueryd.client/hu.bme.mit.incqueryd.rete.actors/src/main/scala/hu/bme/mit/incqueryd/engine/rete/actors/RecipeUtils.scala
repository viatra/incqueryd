package hu.bme.mit.incqueryd.engine.rete.actors

import org.eclipse.emf.ecore.EObject
import org.eclipse.incquery.runtime.rete.recipes.BetaRecipe
import org.eclipse.incquery.runtime.rete.recipes.CheckRecipe
import org.eclipse.incquery.runtime.rete.recipes.ConstantRecipe
import org.eclipse.incquery.runtime.rete.recipes.MultiParentNodeRecipe
import org.eclipse.incquery.runtime.rete.recipes.ReteNodeRecipe
import org.eclipse.incquery.runtime.rete.recipes.TrimmerRecipe
import org.eclipse.incquery.runtime.rete.recipes.InputRecipe
import scala.collection.JavaConversions._
import org.eclipse.incquery.runtime.rete.recipes.ReteRecipe
import org.eclipse.incquery.runtime.rete.recipes.ProductionRecipe
import org.eclipse.incquery.runtime.rete.recipes.RecipesPackage
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl
import org.apache.commons.io.FilenameUtils
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.common.util.URI
import scala.collection.mutable.Buffer

object RecipeUtils {

  val VERTEX = "vertex";
  val EDGE = "edge";
  val ATTRIBUTE = "attribute";
  
  def getNodeType(recipe: ReteNodeRecipe): String = {
    recipe match {
      case recipe: InputRecipe => {
        recipe.getKeyArity match {
          case 1 => VERTEX
          case 2 => {
            if(recipe.getTraceInfo.startsWith(EDGE))
              EDGE
            else if(recipe.getTraceInfo.startsWith(ATTRIBUTE))
              ATTRIBUTE
            else
              ""
          }
          case _ => ""
        }
      }
      case _ => recipe.getClass.getSimpleName
    }
  }
  
  def getName(recipe: ReteNodeRecipe): String = {
    recipe match {
      case recipe: InputRecipe => recipe.getKeyID
      // TODO more cases
      case _ => recipe.toString
    }
  }

  def findRecipe(recipe: ReteRecipe, key: ReteActorKey): Option[ReteNodeRecipe] = {
    recipe.getRecipeNodes.find(ReteActorKey(_) == key)
  }
  
  def getPatternNamesFromRecipe(recipe : ReteRecipe) : Set[String] = {
    val productionRecipes = getProductionRecipes(recipe)
    var patternNames : Set[String] = Set[String]()
    productionRecipes.foreach { productionRecipe => 
      patternNames+=(productionRecipe.getTraceInfo.split("\\[")(0).trim())
    }
    patternNames
  }
  
  def findProductionRecipe(recipe: ReteRecipe, patternName: String): Option[ProductionRecipe] = {
    getProductionRecipes(recipe).find(_.getTraceInfo.startsWith(patternName)) // XXX relying on naming convention
  }
  
  def getProductionRecipes(recipe : ReteRecipe) : Buffer[ProductionRecipe] = {
    recipe.getRecipeNodes.collect { case productionRecipe: ProductionRecipe => productionRecipe }
  }

  def loadRecipe(filename: String): ReteRecipe = {
    val extension = FilenameUtils.getExtension(filename)
    val url = getClass.getClassLoader.getResource(filename)
    RecipesPackage.eINSTANCE.eClass
    val resourceSet = new ResourceSetImpl
    Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap.put(extension, new XMIResourceFactoryImpl)
    val resource = resourceSet.createResource(URI.createURI(url.toString))
    resource.load(Map[Object, Object]())
    resource.getContents.get(0).asInstanceOf[ReteRecipe]
  }

}