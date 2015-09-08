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
import org.wikidata.wdtk.datamodel.interfaces.MonolingualTextValue
import hu.bme.mit.incqueryd.engine.util.DatabaseConnection
import eu.mondo.driver.graph.RDFGraphDriverReadWrite

/**
 * @author pappi
 */
class WikiStreamReceiver(databaseConnection: DatabaseConnection) extends Receiver[Delta](StorageLevel.MEMORY_ONLY) {

  val pool: ExecutorService = Executors.newFixedThreadPool(2)
  val driver = databaseConnection.getDriver

  def onStart() {
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

  def onStop() {
    pool.shutdown()
  }

  class IrcListener(pool: ExecutorService) extends ListenerAdapter[PircBotX] {

    override def onGenericMessage(event: GenericMessageEvent[PircBotX]) {
      parse(event.getMessage).foreach { edit =>
        pool.submit(new Runnable {
          def run() {
            println(s"Processing $edit")
            if (!edit.newPage) {
              val oldDeltas = getOldDeltas(edit.pageTitle)
              apply(oldDeltas)
            }
            val newDeltas = getNewDeltas(edit)
            apply(newDeltas)
          }
        })
      }
    }
    
    def getOldDeltas(itemId: String): List[Delta] = {
      List()
      // TODO
    }

    private def getNewDeltas(edit: WikipediaEdit): List[Delta] = {
      val fetcher = WikibaseDataFetcher.getWikidataDataFetcher
      val document = fetcher.getEntityDocument(edit.pageTitle)
      document match {
        case document: StatementDocument =>
          document.getAllStatements.toList.flatMap { statement =>
            val subjectId = statement.getClaim.getSubject.getId
            val propertyId = statement.getClaim.getMainSnak.getPropertyId.getId
            val inputActorPath = IQDSparkUtils.getInputActorPath(ReteActorKey.fromString(propertyId).internalId)
            statement.getClaim.getMainSnak match {
              case snak: ValueSnak =>
                snak.getValue match {
                  case value: EntityIdValue => Some(EdgeDelta(inputActorPath, ChangeType.POSITIVE, subjectId, propertyId, value.getId))
                  case value: StringValue => Some(AttributeDelta(inputActorPath, ChangeType.POSITIVE, subjectId, propertyId, value.getString))
                  case value: MonolingualTextValue => Some(AttributeDelta(inputActorPath, ChangeType.POSITIVE, subjectId, propertyId, value.getText))
                  // TODO
                  case _ => None
                }
              case _ => None
            }
          }
        case _ => List()
      }
    }
    
    private def apply(deltas: List[Delta]) {
     deltas.foreach { delta =>
        applyToDatabase(delta)
        store(delta)
      }
    }

    private def applyToDatabase(delta: Delta) {
      driver match {
        case driver: RDFGraphDriverReadWrite =>
          delta match {
            case delta: VertexDelta =>
              // TODO
            case delta: EdgeDelta =>
              delta.changeType match {
                case ChangeType.POSITIVE =>
                	driver.insertEdge(delta.subjectId, delta.objectId, delta.propertyId)
                case ChangeType.NEGATIVE =>
                  driver.deleteEdge(delta.subjectId, delta.objectId, delta.propertyId)
              }
            case delta: AttributeDelta =>
              delta.changeType match {
                case ChangeType.POSITIVE =>
                  driver.insertEdge(delta.subjectId, delta.objectValue, delta.propertyId)
                case ChangeType.NEGATIVE =>
                  driver.deleteEdge(delta.subjectId, delta.objectValue, delta.propertyId)
              }
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
