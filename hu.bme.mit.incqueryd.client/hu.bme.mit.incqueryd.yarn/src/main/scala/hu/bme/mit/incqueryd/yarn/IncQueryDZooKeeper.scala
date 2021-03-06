package hu.bme.mit.incqueryd.yarn

import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.ObjectInputStream
import java.io.ObjectOutputStream
import java.net.ConnectException
import java.net.URLEncoder
import java.util.Arrays.ArrayList
import scala.collection.mutable
import scala.collection.immutable
import scala.concurrent.Future
import scala.concurrent.Promise
import scala.concurrent.impl.Future
import org.apache.zookeeper.CreateMode
import org.apache.zookeeper.WatchedEvent
import org.apache.zookeeper.Watcher
import org.apache.zookeeper.Watcher.Event.KeeperState
import org.apache.zookeeper.ZooDefs
import org.apache.zookeeper.ZooDefs.Ids
import org.apache.zookeeper.ZooKeeper
import org.apache.zookeeper.ZooKeeper.States
import org.apache.zookeeper.data.Stat
import scala.collection.generic.SetFactory
import org.apache.curator.utils.ZKPaths
import scala.collection.JavaConverters._
import org.apache.zookeeper.Watcher.Event.EventType
import java.net.URL
import scala.concurrent.duration._
import java.io.FileWriter
import java.util.Calendar

object IncQueryDZooKeeper {

  val port = 2181
  val anyVersion = -1

  val reteNodesPath = "/retenodes"  // query nodes
  
  val inputNodesPath = "/inputnodes"
  val nodeType = "/nodetype" 
  val rdfType = "/rdftype" // RDF type
  
  val runningQueries = "/queries"
  
  val coordinatorsPath = "/coordinators"
  val defaultCoordinatorPath = coordinatorsPath + "/default"
  
  val yarnNodesPath = "/yarnnodes"
  val actorNamePath = "/actorname"
  
  val applicationIdPath = "/applicationId"
  val addressPath = "/address"
  val portPath = "/port"
  
  val reteNodeTypePath = "/retenodetype"
  val subscribersPath = "/subscribers"
  
  val propagateSentPath = "/propagate_sent"
  val propagateReceivedPath = "/propagate_received"
  val propagateResponsePath = "/propagate_response_sent"
  val actorSystemPath = "/actorsystem"
  
  val timeout = (300 seconds)

  // Handle ZooKeeper connection
  var zk = create()

  def create(host: String): ZooKeeper = {
    zk = new ZooKeeper(s"$host:$port", 10000, new Watcher {
      def process(event: WatchedEvent) {
      }
    })
    zk
  }

  def create(): ZooKeeper = {
    zk = new ZooKeeper(s"127.0.0.1:$port", 10000, new Watcher {
      def process(event: WatchedEvent) {
      }
    })
    zk
  }

  def connectSync(): Future[Boolean] = {
    val result = Promise[Boolean]()
    zk = new ZooKeeper(s"localhost:$port", 10000, new Watcher {
      def process(event: WatchedEvent) {
        event.getState match {
          case KeeperState.SyncConnected => {
            result.success(true)
          }
          case _ => {
            result.failure(new ConnectException("Unable to connect ZooKeeper on localhost"))
          }
        }
      }
    })
    result.future
  }

  def getConnection(): ZooKeeper = {
    if (zk.getState != States.CONNECTED | zk == null)
      create()
    zk
  }

  def delete(path: String) {
    if (zk.exists(path, false) != null) {
    	zk.delete(path, -1)
    }
  }

  // Handle setting ZooKeeper data
  def setData(path: String, data: Array[Byte]) {
    getConnection()
    if (zk.exists(path, true) == null)
      ZKPaths.mkdirs(zk, path)
    zk.setData(path, data, -1)
  }

  def serializeAndSetData(path: String, data: AnyRef) {
    setData(path, serialize(data))
  }

  // Handle getting ZooKeeper data
  def getChildrenData[A](path: String): Set[A] = {
    getConnection()
    zk.exists(path, true) match {
      case null => {
        immutable.Set.empty[A]
      }
      case _ => {
        var retSet = immutable.Set.empty[A]
        zk.getChildren(path, false).asScala.foreach { child =>
          retSet += getDeserializedData(path + "/" + child)
        }
        retSet
      }
    }
  }

  def getChildPaths(path: String): List[String] = {
    getConnection()
    zk.exists(path, true) match {
      case null => {
        immutable.List.empty[String]
      }
      case _ => {
        zk.getChildren(path, false).asScala.toList
      }
    }
  }

  def getData(path: String): Array[Byte] = {
    getConnection()
    zk.exists(path, true) match {
      case null => {
        null
      }
      case _ => {
        val stat = new Stat()
        zk.getData(path, true, stat)
      }
    }
  }

  def getStringData(path: String): String = {
    val data = getData(path)
    if (data == null) {
      throw new IllegalArgumentException(s"No znode found at $path")
    }
    new String(data)
  }

  def getDeserializedData[A](path: String): A = {
    deserialize(getData(path)).asInstanceOf[A]
  }

  def getStringDataWithWatcher(path: String, watcher : Watcher) = {
    getConnection()
    zk.getData(path, watcher, new Stat())
  }
  
  def getChildrenWithWatcher(path: String, watcher : Watcher) = {
    getConnection()
    zk.getChildren(path, watcher)
  }
  
  // Helper methods
  private def serialize(obj: AnyRef): Array[Byte] = {
    obj match {
      case null => {
        null
      }
      case _ => {
        val b = new ByteArrayOutputStream()
        val o = new ObjectOutputStream(b)
        o.writeObject(obj)
        val ret = b.toByteArray
        o.flush()
        b.close()
        ret
      }
    }
  }

  private def deserialize(bytes: Array[Byte]): AnyRef = {
    bytes match {
      case null => {
        null
      }
      case _ => {
        val b = new ByteArrayInputStream(bytes)
        val i = new ObjectInputStream(b)
        val ret = i.readObject()
        i.close()
        b.close()
        ret
      }
    }
  }

  def encodeZooPath(path: String): String = {
    URLEncoder.encode(path, "UTF-8")
  }
  
  def normalizePath(path : String) : String = {
    var _path = path
      if(!_path.startsWith("/"))
         _path = "/".concat(_path)
    _path
  }
  
  def writeToFile(obj : Object ) {
    val writer = new FileWriter("/tmp/incquery-zk-debug.txt", true)
        writer.write(s"\n${Calendar.getInstance().getTime()} | ${obj.toString()}")
        writer.close()
  }
  
  // IncQuery-D specific methods
  def getActorsWithAdditionalData[A](path: String): Map[String, A] = {
    getConnection()
    var retMap = immutable.Map.empty[String, A]
    zk.exists(path, true) match {
      case null => {
        retMap
      }
      case _ => {

        val children = zk.getChildren(path, false).asScala
        children.foreach { childPath =>
          val childData = getStringData(path + "/" + childPath)
          val grandChildPath = zk.getChildren(path + "/" + childPath, false).get(0)
          val grandChildData = getDeserializedData[A](path + "/" + childPath + "/" + grandChildPath)

          retMap += (childData -> grandChildData)
        }
        retMap
      }
    }
  }

  def createDir(path: String) {
    getConnection()
    ZKPaths.mkdirs(zk, normalizePath(path))
  }
  
  def createSequential(parent: String, prefix: String) = {
    createDir(parent)
    zk.create(ZKPaths.makePath(parent, prefix), Array(), Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT_SEQUENTIAL)
  }

  def createChildDir(parent : String, child : String) {
    getConnection()
    ZKPaths.mkdirs(zk, parent + child)
  }
  
  def createAndGetPath(path : String) : String = {
    createDir(path)
    path
  }
  
  def registerYarnNodes(nodes : List[String]) {
    nodes.map { node => 
      IncQueryDZooKeeper.createDir(IncQueryDZooKeeper.yarnNodesPath + normalizePath(node))}
  }
  
  def getYarnNodesWithZK() : List[String] = {
   getChildPaths(createAndGetPath(IncQueryDZooKeeper.yarnNodesPath))
  }
  
  def writeApplicationData(nodePath : String) {
    
  }
  
  def getActorPaths(path: String): Set[String] = {
    getConnection()
    var retSet = immutable.Set.empty[String]
    zk.exists(path, true) match {
      case null => {
        retSet
      }
      case _ => {

        zk.getChildren(path, false).asScala.foreach { child =>
          retSet += getStringData(path + "/" + child)
        }
        retSet
      }
    }
  }
  
}
