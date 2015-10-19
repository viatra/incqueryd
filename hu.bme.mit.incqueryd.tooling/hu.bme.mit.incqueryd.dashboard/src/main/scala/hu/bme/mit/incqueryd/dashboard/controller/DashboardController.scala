package hu.bme.mit.incqueryd.dashboard.controller

import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

import scala.collection.mutable.HashMap
import scala.collection.mutable.HashSet

import org.apache.zookeeper.WatchedEvent
import org.apache.zookeeper.Watcher
import org.apache.zookeeper.Watcher.Event.EventType
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken
import org.eclipse.paho.client.mqttv3.MqttCallback
import org.eclipse.paho.client.mqttv3.MqttMessage

import hu.bme.mit.incqueryd.dashboard.jetty.JettyServer
import hu.bme.mit.incqueryd.dashboard.mqtt.MQTTSubscriber
import hu.bme.mit.incqueryd.dashboard.ui.AddPattern
import hu.bme.mit.incqueryd.dashboard.ui.QueryResult
import hu.bme.mit.incqueryd.dashboard.ui.RemovePattern
import hu.bme.mit.incqueryd.dashboard.ui.UIBroadcaster
import hu.bme.mit.incqueryd.dashboard.utils.DashboardUtils._
import hu.bme.mit.incqueryd.engine.rete.dataunits.Tuple
import hu.bme.mit.incqueryd.spark.utils.IQDSparkUtils._
import hu.bme.mit.incqueryd.yarn.IncQueryDZooKeeper

/**
 * @author pappi
 */
object DashboardController {
  
  lazy val executorService: ExecutorService = Executors.newCachedThreadPool()
  
  private var runningPatterns = new HashSet[String]()
  private var previousResultSets : HashMap[String, Set[Tuple]] = HashMap[String, Set[Tuple]]()
  
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
  
  def registerPattern(pattern : String, query : String) {
    this.synchronized {
      runningPatterns += createPatternId(pattern, query)
      UIBroadcaster.update(AddPattern(pattern, query))
    }
  }
  
  def unregisterPattern(pattern : String, query : String) {
    this.synchronized {
      runningPatterns.remove(createPatternId(pattern, query))
      UIBroadcaster.update(RemovePattern(pattern, query))
    }
  }
  
  def getRunningPatterns() : scala.collection.immutable.HashSet[String] = {
    this.synchronized {
      val patternIds = scala.collection.immutable.HashSet[String]() ++ runningPatterns
      patternIds
    }
  }
  
  private def updatePatterns(patterns : Set[String], query : String) {
    patterns.foreach { pattern =>
      val patternId = createPatternId(pattern, query)
      if(!runningPatterns.contains(patternId)) {
        registerPattern(pattern, query)
        startSubscriber(patternId)
      }
    }
    val patternIds = patterns.map { createPatternId(_, query) }
    runningPatterns.foreach { patternId => 
      if(patternId.startsWith(query) && !patternIds.contains(patternId)) {
        unregisterPattern(resolvePattern(patternId), query)
        removeSubscriber(patternId)
      }
    }
  }
  
  def pushQueryResult(patternId : String, results : Set[Tuple]) {
    this.synchronized {
      var removedTuples = Set[Tuple]()
      var newTuples = Set[Tuple]();
      val prevResultSet = previousResultSets.getOrElseUpdate(patternId, Set[Tuple]())
      prevResultSet.foreach { tuple =>
        if(!results.contains(tuple))
          removedTuples += tuple
      }
      results.foreach { tuple => 
         if(!prevResultSet.contains(tuple))
           newTuples += tuple;
      }
      previousResultSets(patternId) = results
      if(newTuples.size > 0 || removedTuples.size > 0)
        UIBroadcaster.update(QueryResult(patternId, results, newTuples, removedTuples))
    }
  }
  
  def watchForQueryChanges() {
    
    // Watch for query changes
    val watcher = new Watcher() {
      def process(event: WatchedEvent) {
        event.getType() match {
          case EventType.NodeChildrenChanged => {
            watchForQueryChanges()
            val queries = IncQueryDZooKeeper.getChildPaths(event.getPath)
            queries.foreach { query => 
              val patterns = IncQueryDZooKeeper.getChildPaths(s"${event.getPath}/${query}")
              updatePatterns(patterns.toSet[String], query)  
              watchForPatternChanges(query)
            }
          }
          case _ => {
            watchForQueryChanges()
          }
        }
      }
    }
    IncQueryDZooKeeper.getChildrenWithWatcher(IncQueryDZooKeeper.runningQueries, watcher)
    
    // Watch for pattern changes
    val queries = IncQueryDZooKeeper.getChildPaths(IncQueryDZooKeeper.runningQueries)
    queries.foreach { query => 
      watchForPatternChanges(query)
    }
  }
  
  def watchForPatternChanges(query : String) {
    val watcher = new Watcher() {
      def process(event: WatchedEvent) {
        event.getType() match {
          case EventType.NodeChildrenChanged => {
            watchForPatternChanges(query)
            val patterns = IncQueryDZooKeeper.getChildPaths(event.getPath)
            updatePatterns(patterns.toSet[String], query)
          }
          case _ => {
            watchForPatternChanges(event.getPath)
          }
        }
      }
    }
    
    IncQueryDZooKeeper.getChildrenWithWatcher(s"${IncQueryDZooKeeper.runningQueries}/$query", watcher)
  }
  
  def watchForPatternChanges() {
    val watcher = new Watcher() {
      def process(event: WatchedEvent) {
        event.getType() match {
          case EventType.NodeChildrenChanged => {
            watchForQueryChanges()
            val queries = IncQueryDZooKeeper.getChildPaths(IncQueryDZooKeeper.runningQueries)
            
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