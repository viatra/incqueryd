package hu.bme.mit.incqueryd.spark.recievers

import java.net.InetAddress

import scala.collection.JavaConversions.asScalaIterator

import org.apache.spark.annotation.DeveloperApi
import org.apache.spark.storage.StorageLevel
import org.apache.spark.streaming.receiver.Receiver
import org.pircbotx.Configuration
import org.pircbotx.PircBotX
import org.pircbotx.hooks.ListenerAdapter
import org.pircbotx.hooks.types.GenericMessageEvent
import org.wikidata.wdtk.datamodel.interfaces.EntityIdValue
import org.wikidata.wdtk.datamodel.interfaces.MonolingualTextValue
import org.wikidata.wdtk.datamodel.interfaces.StatementDocument
import org.wikidata.wdtk.datamodel.interfaces.StringValue
import org.wikidata.wdtk.datamodel.interfaces.ValueSnak
import org.wikidata.wdtk.wikibaseapi.WikibaseDataFetcher

import eu.mondo.driver.graph.RDFGraphDriverRead
import eu.mondo.driver.graph.RDFGraphDriverReadWrite
import hu.bme.mit.incqueryd.engine.rete.dataunits.ChangeType
import hu.bme.mit.incqueryd.engine.util.DatabaseConnection
import hu.bme.mit.incqueryd.spark.utils.UpdateAttribute
import hu.bme.mit.incqueryd.spark.utils.Update
import hu.bme.mit.incqueryd.spark.utils.Delta
import hu.bme.mit.incqueryd.spark.utils.UpdateEdge
import hu.bme.mit.incqueryd.spark.utils.NoChange
import hu.bme.mit.incqueryd.spark.utils.Reset
import hu.bme.mit.incqueryd.spark.utils.SendUpdates
import hu.bme.mit.incqueryd.spark.utils.UpdateVertex

/**
 * @author pappi
 */
class WikidataStreamReceiver(databaseConnection: DatabaseConnection) extends Receiver[Set[Delta]](StorageLevel.MEMORY_ONLY) {

  def onStart() {
    def configuration = new Configuration.Builder()
      .setName(s"iqd-wikichanges-${InetAddress.getLocalHost().getHostAddress().replace('.', '-')}")
      .setServerHostname("irc.wikimedia.org")
      .addAutoJoinChannel("#wikidata.wikipedia")
      .addListener(new IrcListener)
      .buildConfiguration
    val bot = new PircBotX(configuration)
    bot.startBot()
  }

  def onStop() {
  }

  class IrcListener extends ListenerAdapter[PircBotX] {

    override def onGenericMessage(event: GenericMessageEvent[PircBotX]) {
      parse(event.getMessage).foreach { edit =>
        if (!edit.robot && edit.pageTitle.startsWith("Q")) { // Bot edits come too frequently
        	println(s"Processing $edit")
          val driver = databaseConnection.getDriver
          val oldDelta = getOldDelta(edit)
          val newDelta = getNewDelta(edit)
          apply(Set(oldDelta, newDelta), driver)
        }
      }
    }

  }

  private def parse(message: String): Option[WikipediaEdit] = {
    val regex = """\u000314\[\[\u000307(.+?)\u000314\]\]\u00034 (.*?)\u000310.*\u000302(.*?)\u0003.+\u000303(.+?)\u0003.+\u0003 .+([+-]\d+).+ \u000310(.*)\u0003.*""".r
    message match {
      case regex(pageTitle, flags, diffUrl, userName, diffSizeString, comment) => {
        val robot = flags.contains('B')
        val newPage = flags.contains('N')
        val unpatrolled = flags.contains('!')
        val diffSize = diffSizeString.toInt
        val edit = WikipediaEdit(pageTitle, robot, newPage, unpatrolled, diffUrl, userName, diffSize, comment)
        Some(edit)
      }
      case _ => {
        None
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
    comment: String)

  private def getOldDelta(edit: WikipediaEdit): Delta = {
    if (edit.newPage) {
      NoChange
    } else {
    	Reset(s"http://www.wikidata.org/entity/${edit.pageTitle}")
    }
  }

  private def getNewDelta(edit: WikipediaEdit): Delta = {
    val fetcher = WikibaseDataFetcher.getWikidataDataFetcher
    val document = fetcher.getEntityDocument(edit.pageTitle)
    val updates: Set[Update] = document match {
      case document: StatementDocument =>
        document.getAllStatements.flatMap { statement =>
          val subjectId = statement.getClaim.getSubject.getIri
          val propertyId = s"http://www.wikidata.org/prop/direct/${statement.getClaim.getMainSnak.getPropertyId.getId}"
  			  statement.getClaim.getMainSnak match {
  			  case snak: ValueSnak =>
    			  snak.getValue match {
      			  case value: EntityIdValue =>
        			  Some(UpdateEdge(ChangeType.POSITIVE, subjectId, propertyId, value.getIri))
    			    case value: StringValue =>
    			      Some(UpdateAttribute(ChangeType.POSITIVE, subjectId, propertyId, value.getString))
    			    case value: MonolingualTextValue =>
    			      Some(UpdateAttribute(ChangeType.POSITIVE, subjectId, propertyId, value.getText))
      			  // TODO
      			  case _ => None
    			  }
  			    case _ => None
      	  }
        }.toSet
      case _ => Set()
    }
    SendUpdates(updates)
  }

  private def apply(deltas: Set[Delta], driver: RDFGraphDriverRead) {
    deltas.foreach { delta =>
      applyToDatabase(delta, driver)
    }
    store(deltas)
  }

  private def applyToDatabase(delta: Delta, driver: RDFGraphDriverRead) {
    driver match {
      case driver: RDFGraphDriverReadWrite =>
        delta match {
          case delta: UpdateVertex =>
            {} // TODO
          case delta: UpdateEdge =>
            delta.changeType match {
              case ChangeType.POSITIVE =>
                driver.insertEdge(delta.subjectId, delta.objectId, delta.rdfTypeId)
              case ChangeType.NEGATIVE =>
                driver.deleteEdge(delta.subjectId, delta.objectId, delta.rdfTypeId)
            }
          case delta: UpdateAttribute =>
            delta.changeType match {
              case ChangeType.POSITIVE =>
                driver.insertEdge(delta.subjectId, delta.objectValue, delta.rdfTypeId)
              case ChangeType.NEGATIVE =>
                driver.deleteEdge(delta.subjectId, delta.objectValue, delta.rdfTypeId)
            }
        }
      case _ => {}
    }
  }
}
