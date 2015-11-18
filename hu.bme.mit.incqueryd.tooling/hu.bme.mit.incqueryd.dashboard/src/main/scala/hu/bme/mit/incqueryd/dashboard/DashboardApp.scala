package hu.bme.mit.incqueryd.dashboard

import org.apache.hadoop.fs.Path
import hu.bme.mit.incqueryd.dashboard.controller.DashboardController
import hu.bme.mit.incqueryd.dashboard.mqtt.MQTTReceiver
import hu.bme.mit.incqueryd.dashboard.mqtt.MQTTSubscriber
import hu.bme.mit.incqueryd.dashboard.utils.DashboardUtils._
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

  val BROKER_URL = "tcp://yarn-rm.docker:9876"

  def main(args: Array[String]) {

    // Start UI thread
    DashboardController.startUIThread()

  }

}