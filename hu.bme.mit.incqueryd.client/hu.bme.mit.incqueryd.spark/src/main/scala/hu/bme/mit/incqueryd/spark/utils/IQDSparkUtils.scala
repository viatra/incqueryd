package hu.bme.mit.incqueryd.spark.utils

import org.apache.spark.SparkEnv
import hu.bme.mit.incqueryd.engine.rete.dataunits.ChangeSet
import org.apache.spark.util.AkkaUtils
import hu.bme.mit.incqueryd.actorservice.AkkaUtils
import akka.pattern.ask
import hu.bme.mit.incqueryd.engine.rete.actors.PropagateInputState
import java.io.FileWriter
import scala.concurrent.duration._
import scala.concurrent.Await
import hu.bme.mit.incqueryd.actorservice.ActorId
import com.google.common.net.HostAndPort
import hu.bme.mit.incqueryd.yarn.IncQueryDZooKeeper
import hu.bme.mit.incqueryd.actorservice.YarnActorService
import akka.actor.ActorPath
import hu.bme.mit.incqueryd.engine.rete.actors.ReteActorKey

/**
 * @author pappi
 */
object IQDSparkUtils {

  val SEPARATOR = " "

  val DEFAULT_DURATION = 100
  val DEFAULT_TIMEOUT = 300 second
  val DEFAULT_LOAD_TIMEOUT = 900

  val SPARK_HOME = "/usr/local/spark"
  val TARGET_PATH = "/tmp/target"
  val APP_RESOURCE = s"$TARGET_PATH/hu.bme.mit.incqueryd.actorservice.server-1.0.0-SNAPSHOT.jar"
  val MAIN_CLASS = "hu.bme.mit.incqueryd.spark.IQDSparkMain"
  
  def writeln(obj: AnyRef) {
    val writer = new FileWriter("/tmp/spark_iqd.txt", true)
    writer.write(s" | ${obj.toString()}\n")
    writer.close()
  }

  def write(obj: AnyRef) {
    val writer = new FileWriter("/tmp/spark_iqd.txt", true)
    writer.write(s" | ${obj.toString()}")
    writer.close()
  }
  
  def writeException[T]()(fn: => T): T = {
    try {
      fn
    } catch {
      case e: Exception => {
        write("Exception: ")
        writeln(e)
      }
      throw e;
    }
  }
  
  def getJars() : Array[String] = {
    Array(APP_RESOURCE)
  }
  
  def getInputActorPathByTypeName(typeName: String): ActorPath = {
    getInputActorPathByZnodeId(ReteActorKey.fromString(typeName).internalId)
  }

  def getInputActorPathByZnodeId(znodeId: String): ActorPath = {
    val address = HostAndPort.fromString(IncQueryDZooKeeper.getStringData(s"${IncQueryDZooKeeper.inputNodesPath}/$znodeId${IncQueryDZooKeeper.addressPath}"))
    val actorName = IncQueryDZooKeeper.getStringData(s"${IncQueryDZooKeeper.inputNodesPath}/$znodeId${IncQueryDZooKeeper.actorNamePath}")
    val actorId = new ActorId(YarnActorService.actorSystemName, address.getHostText, address.getPort, actorName)
    ActorPath.fromString(AkkaUtils.toActorPath(actorId))
  }

}