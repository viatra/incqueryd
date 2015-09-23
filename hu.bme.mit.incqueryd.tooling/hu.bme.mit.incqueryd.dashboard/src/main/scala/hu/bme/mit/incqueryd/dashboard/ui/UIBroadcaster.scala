package hu.bme.mit.incqueryd.dashboard.ui

import java.util.concurrent.Executors
import hu.bme.mit.incqueryd.spark.utils.IQDSparkUtils._


/**
 * @author pappi
 */
object UIBroadcaster {

  trait MessageListener {
    def messageReceived(msg: UIMessage)
  }

  val executorService = Executors.newCachedThreadPool()

  var listeners = Set[MessageListener]()

  def addListener(listener: MessageListener) {
    this.synchronized {
      listeners += listener
      println(s"Registered listener! Sum: ${listeners.size}")
    }
  }

  def removeListener(listener: MessageListener) {
    this.synchronized {
      listeners -= listener
      println(s"Remove listener! Sum: ${listeners.size}")
    }
  }

  def update(message: UIMessage) {
    this.synchronized {
      listeners.foreach { listener =>
        executorService.execute(
          new Runnable {
            override def run() {
              listener.messageReceived(message)
            }
         })
      }
    }
  }
}

