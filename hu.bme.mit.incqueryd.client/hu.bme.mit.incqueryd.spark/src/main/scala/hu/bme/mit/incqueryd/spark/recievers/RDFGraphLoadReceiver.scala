package hu.bme.mit.incqueryd.spark.recievers

import java.net.URL
import java.util.Map.Entry
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import scala.collection.JavaConversions._
import org.apache.hadoop.fs.FsUrlStreamHandlerFactory
import org.apache.spark.storage.StorageLevel
import org.apache.spark.streaming.receiver.Receiver
import org.openrdf.model.Resource
import org.openrdf.model.Value
import eu.mondo.driver.graph.RDFGraphDriverRead
import hu.bme.mit.incqueryd.engine.rete.actors.RecipeUtils
import hu.bme.mit.incqueryd.engine.rete.dataunits.ChangeType
import hu.bme.mit.incqueryd.engine.util.DatabaseConnection
import hu.bme.mit.incqueryd.spark.utils.Delta
import hu.bme.mit.incqueryd.spark.utils.IQDSparkUtils._
import hu.bme.mit.incqueryd.spark.utils.Update
import hu.bme.mit.incqueryd.spark.utils.UpdateAttribute
import hu.bme.mit.incqueryd.spark.utils.UpdateEdge
import hu.bme.mit.incqueryd.spark.utils.UpdateVertex
import hu.bme.mit.incqueryd.yarn.IncQueryDZooKeeper
import hu.bme.mit.incqueryd.spark.utils.SendUpdates
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

/**
 * @author pappi
 */
class RDFGraphLoadReceiver(databaseConnection: DatabaseConnection) extends Receiver[Set[Delta]](StorageLevel.MEMORY_ONLY) {
  
  def onStart() {
    val inputNodes = IncQueryDZooKeeper.getChildPaths(IncQueryDZooKeeper.inputNodesPath)
    val driver = databaseConnection.getDriver
    
    val future = Future.sequence(inputNodes.map{ inputNode =>
      Future {
        val rdfTypeName = IncQueryDZooKeeper.getStringData(s"${IncQueryDZooKeeper.inputNodesPath}/$inputNode${IncQueryDZooKeeper.rdfType}")
        val inputType = IncQueryDZooKeeper.getStringData(s"${IncQueryDZooKeeper.inputNodesPath}/$inputNode${IncQueryDZooKeeper.nodeType}")
        val updates: Set[Update] = inputType match {
          case RecipeUtils.VERTEX => 
            val dataset = driver.collectVertices(rdfTypeName)
            dataset.toSet.map{x: Resource => UpdateVertex(ChangeType.POSITIVE, x.toString(), rdfTypeName)}
          case RecipeUtils.EDGE =>
            val dataset = driver.collectEdges(rdfTypeName)
            dataset.entries().toSet.map{entry: Entry[Resource, Resource] => UpdateEdge(ChangeType.POSITIVE, entry.getKey.toString(), rdfTypeName, entry.getValue.toString())}
          case RecipeUtils.ATTRIBUTE =>
            val dataset = driver.collectProperties(rdfTypeName)
            dataset.entries().toSet.map{entry: Entry[Resource, Value] => UpdateAttribute(ChangeType.POSITIVE, entry.getKey.toString(), rdfTypeName, entry.getValue.toString())} 
        }
        val deltas: Set[Delta] = Set(SendUpdates(updates))
        store(deltas)
      }
    })
    future.onSuccess { case _ =>
      stop("Loading finished")
    }
    future.onFailure { case error =>
      stop("Loading failed", error)
    }
  }

  def onStop() {
  }
  
}