package hu.bme.mit.incqueryd.yarn

import org.apache.zookeeper.ZooKeeper
import org.apache.zookeeper.WatchedEvent
import org.apache.zookeeper.Watcher

object IncQueryDZooKeeper {

  val port = 2181
  val anyVersion = -1

  def create(zkHostname: String) = {
    new ZooKeeper(s"$zkHostname:$port", 10000, new Watcher {
      def process(event: WatchedEvent) {
      }
    })
  }

}