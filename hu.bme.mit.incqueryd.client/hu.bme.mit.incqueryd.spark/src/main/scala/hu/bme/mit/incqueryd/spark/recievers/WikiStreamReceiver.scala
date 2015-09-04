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
import org.wikidata.wdtk.wikibaseapi.WikibaseDataFetcher
import org.wikidata.wdtk.datamodel.interfaces.EntityDocument
import org.wikidata.wdtk.datamodel.interfaces.StatementDocument
import scala.collection.JavaConversions._
import hu.bme.mit.incqueryd.engine.rete.dataunits.ChangeType
import hu.bme.mit.incqueryd.engine.rete.actors.RecipeUtils
import hu.bme.mit.incqueryd.spark.utils.IQDSparkUtils
import hu.bme.mit.incqueryd.spark.utils.VertexDelta
import org.wikidata.wdtk.datamodel.interfaces.ValueSnak
import org.wikidata.wdtk.datamodel.interfaces.EntityIdValue
import hu.bme.mit.incqueryd.spark.utils.EdgeDelta
import org.wikidata.wdtk.datamodel.interfaces.StringValue
import hu.bme.mit.incqueryd.spark.utils.AttributeDelta
import hu.bme.mit.incqueryd.engine.rete.actors.ReteActorKey

/**
 * @author pappi
 */
class WikiStreamReceiver extends Receiver[Delta](StorageLevel.MEMORY_ONLY) {

  def onStart() {
    val pool: ExecutorService = Executors.newFixedThreadPool(2)
    def configuration = new Configuration.Builder()
      .setName(s"iqd-wikichanges-${InetAddress.getLocalHost().getHostName()}")
      .setServerHostname("irc.wikimedia.org")
      .addAutoJoinChannel("#wikidata.wikipedia")
      .addListener(new IrcListener(pool))
      .buildConfiguration
    val bot = new PircBotX(configuration)
    bot.startBot()
    pool.shutdown()
  }

  def onStop() {}

  class IrcListener(pool: ExecutorService) extends ListenerAdapter[PircBotX] {

    override def onGenericMessage(event: GenericMessageEvent[PircBotX]) {
      parse(event.getMessage).foreach { edit =>
        pool.submit(new Runnable {
          def run() {
            println(edit)
            if (!edit.newPage) {
              removeStatements(edit)
            }
            addStatements(edit)
          }
        })
      }
    }

    private def removeStatements(edit: WikipediaEdit) {
      // TODO
    }

    private def addStatements(edit: WikipediaEdit) {
      val fetcher = WikibaseDataFetcher.getWikidataDataFetcher
      val document = fetcher.getEntityDocument(edit.pageTitle)
      document match {
        case document: StatementDocument =>
          for (statement <- document.getAllStatements) {
            val propertyId = statement.getClaim.getMainSnak.getPropertyId.getId
            val inputActorPath = IQDSparkUtils.getInputActorPath(ReteActorKey.fromString(propertyId).internalId)
            val subjectName = statement.getClaim.getSubject.getId
            val deltaOption = statement.getClaim.getMainSnak match {
              case snak: ValueSnak =>
                snak.getValue match {
                  case value: EntityIdValue => Some(EdgeDelta(inputActorPath, ChangeType.POSITIVE, subjectName, value.getId))
                  case value: StringValue => Some(AttributeDelta(inputActorPath, ChangeType.POSITIVE, subjectName, value.getString))
                  // TODO
                  case _ => None
                }
              case _ => None
            }
            deltaOption.foreach(delta => store(delta))
          }
      }
    }

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
  
}
