package hu.bme.mit.incqueryd.dashboard

import org.apache.hadoop.fs.Path
import org.apache.spark.streaming.ObjectInputStreamWithLoader
import hu.bme.mit.incqueryd.dashboard.controller.DashboardController
import hu.bme.mit.incqueryd.dashboard.mqtt.MQTTReceiver
import hu.bme.mit.incqueryd.dashboard.mqtt.MQTTSubscriber
import hu.bme.mit.incqueryd.spark.recievers.ProductionReceiver
import hu.bme.mit.incqueryd.spark.utils.IQDSparkUtils._
import hu.bme.mit.incqueryd.yarn.IncQueryDZooKeeper
import hu.bme.mit.incqueryd.yarn.YarnApplication
import org.apache.zookeeper.WatchedEvent
import org.apache.zookeeper.Watcher
import org.apache.zookeeper.Watcher.Event.EventType
import com.google.common.net.HostAndPort

/**
 * @author pappi
 */
object DashboardApp {

  val queryResultsFilter = (x: Path) => x.toString().startsWith("part")
  val patternName = "switchSensor"
  val RESULT_BASE_DIR = "hdfs://172.17.2.171:9000/QUERYRESULTS"
  val BROKER_URL = "tcp://yarn-rm.docker:9876"

  def main(args: Array[String]) {

    // Start UI thread
    DashboardController.startUIThread()

    // Read queries
    var queries = IncQueryDZooKeeper.getChildPaths(s"${IncQueryDZooKeeper.runningQueries}")

    // Start streams 

    queries.foreach { query =>
      DashboardController.registerQuery(query)
      DashboardController.startSubscriber(query)
    }

    // Add queries zNode if not exist
    if (queries.size == 0)
      IncQueryDZooKeeper.createDir(s"${IncQueryDZooKeeper.runningQueries}")
    
    // Looking for new or removed queries
    DashboardController.watchForQueryChanges()
    
  }

}