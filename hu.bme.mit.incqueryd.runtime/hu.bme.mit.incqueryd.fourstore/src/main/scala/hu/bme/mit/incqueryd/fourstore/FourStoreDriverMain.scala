package hu.bme.mit.incqueryd.fourstore

import scala.concurrent.duration._
import hu.bme.mit.incqueryd.arch.util.ArchUtil
import scala.collection.JavaConversions._
import arch.ReteRole
import org.eclipse.incquery.runtime.rete.recipes.InputRecipe
import org.eclipse.incquery.runtime.rete.recipes.BinaryInputRecipe
import org.eclipse.incquery.runtime.rete.recipes.UnaryInputRecipe
import hu.bme.mit.bigmodel.fourstore.FourStoreClient
import org.eclipse.incquery.runtime.rete.recipes.TypeInputRecipe

object FourStoreDriverMain2 {

  def main(args: Array[String]) {
    val architectureDirectory = "/home/szarnyasg/git/incqueryd/hu.bme.mit.incqueryd.queries/arch/"

    load(architectureDirectory + "posLength.arch")
    load(architectureDirectory + "routeSensor.arch")
  }

  def load(architectureFile: String) {
	println(architectureFile)
    
    val ontologyIri = "http://www.semanticweb.org/ontologies/2011/1/TrainRequirementOntology.owl"
	val conf = ArchUtil.loadConfiguration(architectureFile)
    val clusterName = conf.getConnectionString().split("://")(1)
   	val client = new FourStoreClient(clusterName, ontologyIri)
    
    conf.getMappings.foreach(mapping => {
      mapping.getRoles.foreach(role => role match {
        case reteRole: ReteRole =>
          reteRole.getNodeRecipe match {
            case typeInputRecipe: TypeInputRecipe =>
              val typeNameSuffix = typeInputRecipe.getTypeName.split("#")(1)
              
              typeInputRecipe match {
                case binaryInputRecipe: BinaryInputRecipe =>
                  println("binary input recipe: " + binaryInputRecipe)
                  
                  binaryInputRecipe.getTraceInfo match {
                    case "attribute" => {
                      val attributes = client.collectVerticesWithProperty(typeNameSuffix)
                      println(attributes)
                    }
                    case "edge" => {println("ed")
                      val edges = client.collectEdges(typeNameSuffix)
                      println(edges)
                    }
                  }
                  
                case unaryInputRecipe: UnaryInputRecipe => {
                  val vertices = client.collectVertices(typeNameSuffix)
                  println(vertices)
                }
              }
            case _ => {}
          }
        case _ => {}
      })  
    })
    
    println
  }
}