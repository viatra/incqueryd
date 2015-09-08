package hu.bme.mit.incqueryd.spark.recievers

import org.apache.spark.streaming.receiver.Receiver
import org.apache.spark.storage.StorageLevel
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.Socket
import eu.mondo.driver.file.FileGraphDriverRead
import eu.mondo.driver.graph.RDFGraphDriverRead
import akka.util.Switch
import hu.bme.mit.incqueryd.engine.rete.nodes.TypeInputNode
import java.nio.ByteBuffer
import scala.collection.JavaConversions._
import hu.bme.mit.incqueryd.engine.rete.actors.RecipeUtils
import hu.bme.mit.incqueryd.engine.rete.dataunits.ChangeSet
import hu.bme.mit.incqueryd.engine.rete.dataunits.ChangeType
import org.apache.spark.rdd.RDD
import hu.bme.mit.incqueryd.spark.utils.IQDSparkUtils._
import hu.bme.mit.incqueryd.spark.utils.IQDSparkUtils
import org.apache.hadoop.fs.FsUrlStreamHandlerFactory
import java.net.URL
import hu.bme.mit.incqueryd.yarn.IncQueryDZooKeeper
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import hu.bme.mit.incqueryd.actorservice.ActorId
import com.google.common.net.HostAndPort
import hu.bme.mit.incqueryd.actorservice.YarnActorService
import hu.bme.mit.incqueryd.actorservice.AkkaUtils
import hu.bme.mit.incqueryd.spark.utils.Delta
import akka.actor.ActorPath
import hu.bme.mit.incqueryd.spark.utils.VertexDelta
import hu.bme.mit.incqueryd.spark.utils.EdgeDelta
import hu.bme.mit.incqueryd.spark.utils.AttributeDelta
import hu.bme.mit.incqueryd.engine.util.DatabaseConnection

/**
 * @author pappi
 */
class RDFGraphLoadReceiver(databaseConnection: DatabaseConnection) extends Receiver[Delta](StorageLevel.MEMORY_ONLY) {
  
  var pool: ExecutorService = _
  
  def onStart() {
    
    URL.setURLStreamHandlerFactory(new FsUrlStreamHandlerFactory)
    
    val inputNodes = IncQueryDZooKeeper.getChildPaths(IncQueryDZooKeeper.inputNodesPath)
    pool = Executors.newFixedThreadPool(inputNodes.length)
    
    inputNodes.foreach { inputNode =>
      val rdfTypeName = IncQueryDZooKeeper.getStringData(s"${IncQueryDZooKeeper.inputNodesPath}/$inputNode${IncQueryDZooKeeper.rdfType}")
      val inputType = IncQueryDZooKeeper.getStringData(s"${IncQueryDZooKeeper.inputNodesPath}/$inputNode${IncQueryDZooKeeper.nodeType}")
      val inputActorPath = getInputActorPath(inputNode)
      
      pool.execute(new HDFSLoadWorker(databaseConnection.getDriver, inputType, rdfTypeName, inputActorPath))
    }
    
  }

  def onStop() {
    pool.shutdown()
  }
  
  class HDFSLoadWorker(driver : RDFGraphDriverRead, inputType : String, rdfTypeName : String,  inputActorPath : ActorPath) extends Runnable {
    def run() {
      try {
        inputType match {
          
          case RecipeUtils.VERTEX => 
            val dataset = driver.collectVertices(rdfTypeName)
            dataset.foreach(x => 
              store(VertexDelta(inputActorPath, ChangeType.POSITIVE, x.toString()))
            )
          
          case RecipeUtils.EDGE =>
            val dataset = driver.collectEdges(rdfTypeName)
            dataset.entries().foreach(entry => 
              store(EdgeDelta(inputActorPath, ChangeType.POSITIVE, entry.getKey.toString(), rdfTypeName, entry.getValue.toString()))
            )
          
          case RecipeUtils.ATTRIBUTE =>
            val dataset = driver.collectProperties(rdfTypeName)
            dataset.entries().foreach(entry => 
              store(AttributeDelta(inputActorPath, ChangeType.POSITIVE, entry.getKey.toString(), rdfTypeName, entry.getValue.toString()))
            )
        }
        
      } catch {
        case t: Throwable =>
          restart("Error receiving data", t)
      }
    }
  }
  
}