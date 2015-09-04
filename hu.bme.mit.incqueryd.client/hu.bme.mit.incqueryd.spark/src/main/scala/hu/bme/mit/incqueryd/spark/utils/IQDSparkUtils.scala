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

/**
 * @author pappi
 */
object IQDSparkUtils {

  val SEPARATOR = " "

  val DEFAULT_DURATION = 100
  val DEFAULT_TIMEOUT = 300 second

  val SPARK_HOME = "/usr/local/spark"
  val APP_RESOURCE = "/tmp/target/hu.bme.mit.incqueryd.actorservice.server-1.0.0-SNAPSHOT.jar"
  val MAIN_CLASS = "hu.bme.mit.incqueryd.spark.IQDSparkMain"

  def propagateToInput(actorPath: ActorPath, changeSet: ChangeSet) {
    val inputActor = SparkEnv.get.actorSystem.actorFor(actorPath)
    inputActor ! PropagateInputState(changeSet)
  }
  
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
  
  def getInputActorPath(inputNodeZnodeId: String): ActorPath = {
    val address = HostAndPort.fromString(IncQueryDZooKeeper.getStringData(s"${IncQueryDZooKeeper.inputNodesPath}/$inputNodeZnodeId${IncQueryDZooKeeper.addressPath}"))
    val actorName = IncQueryDZooKeeper.getStringData(s"${IncQueryDZooKeeper.inputNodesPath}/$inputNodeZnodeId${IncQueryDZooKeeper.actorNamePath}")
    val actorId = new ActorId(YarnActorService.actorSystemName, address.getHostText, address.getPort, actorName)
    ActorPath.fromString(AkkaUtils.toActorPath(actorId))
  }

}