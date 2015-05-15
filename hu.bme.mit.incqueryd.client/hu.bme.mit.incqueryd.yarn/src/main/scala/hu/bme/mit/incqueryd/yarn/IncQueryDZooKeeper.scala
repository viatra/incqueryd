package hu.bme.mit.incqueryd.yarn

import org.apache.zookeeper.ZooKeeper
import org.apache.zookeeper.WatchedEvent
import org.apache.zookeeper.Watcher

object IncQueryDZooKeeper {

  val port = 2181
  val ipPath = "/ip"
  val anyVersion = -1

  def create(host: String) = {
    new ZooKeeper(s"$host:$port", 10000, new Watcher {
      def process(event: WatchedEvent) {
      }
    })
  }

}