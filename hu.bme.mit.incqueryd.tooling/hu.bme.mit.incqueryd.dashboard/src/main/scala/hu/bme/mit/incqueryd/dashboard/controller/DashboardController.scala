package hu.bme.mit.incqueryd.dashboard.controller

import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import hu.bme.mit.incqueryd.dashboard.jetty.JettyServer
import hu.bme.mit.incqueryd.dashboard.utils.DashboardUtils._
import hu.bme.mit.incqueryd.dashboard.ui.UIBroadcaster
import com.vaadin.ui.Button
import scala.collection.mutable.HashSet
import hu.bme.mit.incqueryd.dashboard.ui.AddQuery
import hu.bme.mit.incqueryd.engine.rete.dataunits.Tuple
import hu.bme.mit.incqueryd.dashboard.ui.QueryResult
import org.eclipse.paho.client.mqttv3.MqttMessage
import org.eclipse.paho.client.mqttv3.MqttCallback
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken
import scala.collection.mutable.HashMap
import hu.bme.mit.incqueryd.dashboard.mqtt.MQTTSubscriber
import hu.bme.mit.incqueryd.spark.utils.IQDSparkUtils._
import org.apache.zookeeper.WatchedEvent
import org.apache.zookeeper.Watcher.Event.EventType
import org.apache.zookeeper.Watcher
import hu.bme.mit.incqueryd.yarn.IncQueryDZooKeeper
import hu.bme.mit.incqueryd.dashboard.ui.RemoveQuery

/**
 * @author pappi
 */
object DashboardController {
  
  lazy val executorService: ExecutorService = Executors.newCachedThreadPool()
  
  private var runningQueries = new HashSet[String]()
  private var previousResultSet : Set[Tuple] = Set[Tuple]()
  
  var subscribers: HashMap[String, MQTTSubscriber] = new HashMap[String, MQTTSubscriber]()

  def startSubscriber(topic: String) {
    val subscriber = subscribers.getOrElseUpdate(topic, new MQTTSubscriber(BROKER_URL))
    if (!subscriber.isActive()) {
      val callback = new MqttCallback() {

        override def messageArrived(topic: String, message: MqttMessage) {
          DashboardController.pushQueryResult(topic, deserializeProductionMessage[Set[Tuple]](message.getPayload()))
        }

        override def deliveryComplete(token: IMqttDeliveryToken) {}

        override def connectionLost(cause: Throwable) {}

      }
      subscriber.start(topic, callback)
    }
  }
  
  def removeSubscriber(topic : String) {
    val subscriber = subscribers.get(topic).get
    if(subscriber != null) {
      subscriber.stop()
      subscribers.remove(topic)
    }
  }
  
  def registerQuery(queryName : String) {
    this.synchronized {
      runningQueries += queryName
      UIBroadcaster.update(AddQuery(queryName))
    }
  }
  
  def unregisterQuery(queryName : String) {
    this.synchronized {
      runningQueries.remove(queryName)
      UIBroadcaster.update(RemoveQuery(queryName))
    }
  }
  
  def getRunningQueries() : scala.collection.immutable.HashSet[String] = {
    this.synchronized {
      val queries = scala.collection.immutable.HashSet[String]() ++ runningQueries
      queries
    }
  }
  
  private def updateQueries(queries : List[String]) {
    queries.toSet[String].foreach { query =>
      if(!runningQueries.contains(query)) {
        registerQuery(query)
        startSubscriber(query)
      }
    }
    runningQueries.foreach { query => 
      if(!queries.contains(query)) {
        unregisterQuery(query)
        removeSubscriber(query)
      }
    }
  }
  
  def pushQueryResult(queryName : String, results : Set[Tuple]) {
    this.synchronized {
      var removedTuples = 0
      var newTuples = 0;
      previousResultSet.foreach { tuple =>
        if(!results.contains(tuple))
          removedTuples += 1
      }
      results.foreach { tuple => 
         if(!previousResultSet.contains(tuple))
           newTuples += 1;
      }
      previousResultSet = results
      if(newTuples > 0 || removedTuples > 0)
        UIBroadcaster.update(QueryResult(queryName, results, newTuples, removedTuples))
    }
  }
  
  def watchForQueryChanges() {
    val watcher = new Watcher() {
      def process(event: WatchedEvent) {
        event.getType() match {
          case EventType.NodeChildrenChanged => {
            updateQueries(IncQueryDZooKeeper.getChildPaths(IncQueryDZooKeeper.runningQueries))
            watchForQueryChanges()
          }
          case _ => {
            watchForQueryChanges()
          }
        }
      }
    }
    IncQueryDZooKeeper.getChildrenWithWatcher(IncQueryDZooKeeper.runningQueries, watcher)
  }
  
  val uiThread : Thread = new Thread() {
    override def run() {
        val jettyServer : JettyServer = new JettyServer(JETTY_PORT)
        jettyServer.startServer()
      }
  }
  
  def startUIThread() {
    executorService.execute(uiThread);
  }
  
  def stopUIThread() {
    uiThread.stop()
  }
  
  def restartUIThread() {
    stopUIThread()
    startUIThread()
  }
}