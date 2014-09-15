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

object FourStoreDriverMain {

  def main(args: Array[String]) {
    val architectureDirectory = "/home/szarnyasg/git/incqueryd/hu.bme.mit.incqueryd.queries/arch/"

    load(architectureDirectory + "posLength.arch")
    load(architectureDirectory + "routeSensor.arch")
  }

  def load(architectureFile: String) {
    println(architectureFile)

    val conf = ArchUtil.loadConfiguration(architectureFile)
    val clusterName = conf.getConnectionString().split("://")(1)
    val databaseDriver = new FourStoreDriver(clusterName)

    conf.getMappings.foreach(mapping => {
      mapping.getRoles.foreach(role => role match {
        case reteRole: ReteRole =>
          reteRole.getNodeRecipe match {
            case typeInputRecipe: TypeInputRecipe =>

              val tuples = scala.collection.mutable.Set[Tuple]()
              typeInputRecipe match {
                case binaryInputRecipe: BinaryInputRecipe => {
                  println("binary input recipe: " + binaryInputRecipe)
                  binaryInputRecipe.getTraceInfo match {
                    case "attribute" => {
                      initializeAttribute(databaseDriver, binaryInputRecipe, tuples)
                    }
                    case "edge" => {
                      initializeEdge(databaseDriver, binaryInputRecipe, tuples)
                    }
                  }
                }
                case unaryInputRecipe: UnaryInputRecipe => {
                  println("unary input recipe: " + unaryInputRecipe)
                  initializeVertex(databaseDriver, unaryInputRecipe, tuples)
                }
              }

              println("tuples: " + tuples)
            case _ => {}
          }
        case _ => {}
      })
    })

    println
  }

  def initializeAttribute(databaseDriver: FourStoreDriver, recipe: BinaryInputRecipe, tuples: scala.collection.mutable.Set[Tuple]) = {
    val attributes = databaseDriver.collectVerticesWithProperty(recipe.getTypeName())

    attributes.foreach(attribute => {
      tuples += new Tuple(attribute._1, attribute._2)
    })

    println("attributes: " + attributes)
  }

  def initializeEdge(databaseDriver: FourStoreDriver, recipe: BinaryInputRecipe, tuples: scala.collection.mutable.Set[Tuple]) = {
    val edges = databaseDriver.collectEdges(recipe.getTypeName)

    edges.entries().foreach(edge => {
      tuples += new Tuple(edge.getKey, edge.getValue)
    })

    println("edges: " + edges)
  }

  def initializeVertex(databaseDriver: FourStoreDriver, recipe: UnaryInputRecipe, tuples: scala.collection.mutable.Set[Tuple]) = {
    val vertices = databaseDriver.collectVertices(recipe.getTypeName)
    vertices.foreach(vertex => tuples += new Tuple(vertex))
    
    println("vertices: " + vertices)
  }

}