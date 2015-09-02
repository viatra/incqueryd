package hu.bme.mit.incqueryd.spark.recievers

import java.net.InetAddress
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

import org.apache.spark.annotation.DeveloperApi
import org.apache.spark.storage.StorageLevel
import org.apache.spark.streaming.receiver.Receiver
import org.pircbotx.Configuration
import org.pircbotx.PircBotX
import org.pircbotx.hooks.ListenerAdapter
import org.pircbotx.hooks.types.GenericMessageEvent

import hu.bme.mit.incqueryd.spark.utils.Delta

/**
 * @author pappi
 */
class WikiStreamReceiver extends Receiver[Delta](StorageLevel.MEMORY_ONLY) {

  def onStart() {
    val pool: ExecutorService = Executors.newFixedThreadPool(2)
    def configuration = new Configuration.Builder()
      .setName(s"iqd-wikichanges-${InetAddress.getLocalHost().getHostName()}")
      .setServerHostname("irc.wikimedia.org")
      .addAutoJoinChannel("#hu.wikipedia")
      .addListener(new IrcListener(pool))
      .buildConfiguration
    val bot = new PircBotX(configuration)
    bot.startBot()
    pool.shutdown()
  }

  def onStop() {}
  class IrcListener(pool: ExecutorService) extends ListenerAdapter[PircBotX] {
    override def onGenericMessage(event: GenericMessageEvent[PircBotX]) {
      parse(event.getMessage).foreach { edit => pool.submit(new Worker(edit)) }
    }
    
    def parse(message: String): Option[WikipediaEdit] = {
      val regex = """\u000314\[\[\u000307(.+?)\u000314\]\]\u00034 (.*?)\u000310.*\u000302(.*?)\u0003.+\u000303(.+?)\u0003.+\u0003 .+([+-]\d+).+ \u000310(.*)\u0003.*""".r
      message match {
        case regex(pageTitle, flags, diffUrl, userName, diffSizeString, comment) => 
          val robot = flags.contains('B')
          val newPage = flags.contains('N')
          val unpatrolled = flags.contains('!')
          val diffSize = diffSizeString.toInt
          Some(WikipediaEdit(pageTitle, robot, newPage, unpatrolled, diffUrl, userName, diffSize, comment))
        case _ => None
      }
    }
  }

  case class WikipediaEdit(
    pageTitle: String,
    robot: Boolean,
    newPage: Boolean,
    unpatrolled: Boolean,
    diffUrl: String,
    userName: String,
    diffSize: Int,
    comment: String
  )
  
  class Worker(edit: WikipediaEdit) extends Runnable {
	  def run() {
      println(edit)
      // TODO transform edit to delta and store it
	  }
  }

}

object Sandbox {
  def main(args: Array[String]) {
    new WikiStreamReceiver().onStart()
  }
}