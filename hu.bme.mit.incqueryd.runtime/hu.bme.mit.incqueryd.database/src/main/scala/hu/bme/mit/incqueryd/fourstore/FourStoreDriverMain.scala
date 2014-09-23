package hu.bme.mit.incqueryd.fourstore

import scala.concurrent.duration._
import hu.bme.mit.incqueryd.arch.util.ArchUtil
import scala.collection.JavaConversions._
import arch.ReteRole
import org.eclipse.incquery.runtime.rete.recipes.InputRecipe
import org.eclipse.incquery.runtime.rete.recipes.BinaryInputRecipe
import org.eclipse.incquery.runtime.rete.recipes.UnaryInputRecipe
import org.eclipse.incquery.runtime.rete.recipes.TypeInputRecipe
import hu.bme.mit.bigmodel.fourstore.FourStoreDriver
import scala.collection.mutable.HashSet
import hu.bme.mit.incqueryd.core.rete.dataunits.Tuple
import hu.bme.mit.bigmodel.fourstore.FourStoreDriverUnique
import hu.bme.mit.bigmodel.rdf.RDFHelper

object FourStoreDriverMain {

  def main(args: Array[String]) {
    val architectureDirectory = "/home/szarnyasg/git/incqueryd/hu.bme.mit.incqueryd.queries/arch/"

    load(architectureDirectory + "posLength.arch")
    //load(architectureDirectory + "routeSensor.arch")
  }

  def load(architectureFile: String) {
    println(architectureFile)
    println

    val conf = ArchUtil.loadConfiguration(architectureFile)
    val clusterName = conf.getConnectionString().split("://")(1)
    val databaseDriver = new FourStoreDriverUnique(clusterName)
    databaseDriver.generateUniques

    conf.getRecipes.foreach(recipe =>
      recipe.getRecipeNodes.foreach(recipeNode => {
        recipeNode match {
          case typeInputRecipe: TypeInputRecipe =>

            val tuples = scala.collection.mutable.Set[Tuple]()
            typeInputRecipe match {
              case binaryInputRecipe: BinaryInputRecipe => {
                println("binary input recipe: " + binaryInputRecipe)
                val traceInfo = binaryInputRecipe.getTraceInfo

                if (traceInfo.startsWith("attribute")) {
                  initializeAttribute(databaseDriver, binaryInputRecipe, tuples)
                } else if (traceInfo.startsWith("edge")) {
                  initializeEdge(databaseDriver, binaryInputRecipe, tuples)
                }
              }
              case unaryInputRecipe: UnaryInputRecipe => {
                println("unary input recipe: " + unaryInputRecipe)
                initializeVertex(databaseDriver, unaryInputRecipe, tuples)
              }
            }

            println("tuples: " + tuples)
            println
          case _ => {}
        }
      }))
  }

  def initializeAttribute(databaseDriver: FourStoreDriverUnique, recipe: BinaryInputRecipe, tuples: scala.collection.mutable.Set[Tuple]) = {
    val typeName = RDFHelper.brackets(recipe.getTypeName())
    val attributes = databaseDriver.collectVerticesWithProperty(typeName)

    attributes.foreach(attribute => {
      val key = attribute._1
      val value = attribute._2
      
      val regex = "\"(.*?)\"\\^\\^<http://www.w3.org/2001/XMLSchema#int>".r
      val intValue = regex.findFirstMatchIn(value).get.group(1)
      tuples += new Tuple(key, intValue)
    })
  }

  def initializeEdge(databaseDriver: FourStoreDriverUnique, recipe: BinaryInputRecipe, tuples: scala.collection.mutable.Set[Tuple]) = {
    val typeName = RDFHelper.brackets(recipe.getTypeName())
    val edges = databaseDriver.collectEdges(typeName)

    edges.entries().foreach(edge => {
      tuples += new Tuple(edge.getKey, edge.getValue)
    })
  }

  def initializeVertex(databaseDriver: FourStoreDriverUnique, recipe: UnaryInputRecipe, tuples: scala.collection.mutable.Set[Tuple]) = {
    val typeName = RDFHelper.brackets(recipe.getTypeName())

    val vertices = databaseDriver.collectVertices(typeName)
    vertices.foreach(vertex => tuples += new Tuple(vertex))
  }

}