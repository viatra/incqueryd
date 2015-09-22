package hu.bme.mit.incqueryd.coordinator.client

import hu.bme.mit.incqueryd.yarn.HdfsUtils
import org.apache.hadoop.fs.FileSystem
import hu.bme.mit.incqueryd.yarn.AdvancedYarnClient
import scala.concurrent.Await
import scala.concurrent.duration._
import java.net.URL
import java.io.File
import org.eclipse.incquery.runtime.rete.recipes.ReteRecipe
import hu.bme.mit.incqueryd.actorservice.YarnActorService
import org.openrdf.rio.Rio
import org.openrdf.model.impl.LinkedHashModel
import org.openrdf.model.Model
import scala.concurrent.Future
import org.openrdf.rio.helpers.StatementCollector
import scala.concurrent.ExecutionContext.Implicits.global
import hu.bme.mit.incqueryd.engine.rete.dataunits.Tuple
import scala.collection.JavaConversions._
import scala.collection.JavaConverters._
import hu.bme.mit.incqueryd.engine.rete.dataunits.ChangeSet
import hu.bme.mit.incqueryd.engine.util.DatabaseConnection
import hu.bme.mit.incqueryd.yarn.IncQueryDZooKeeper

/**
 *
 * @author pappi
 *
 * Initial client for IQD YARN prototype
 *
 */
class IQDYarnClient {

  val DEFAULT_RM_HOST = "yarn-rm.docker"
  val DEFAULT_HDFS_URL = s"hdfs://$DEFAULT_RM_HOST:9000"
  val DEFAULT_TIMEOUT = 900 seconds

  val filesystem: FileSystem = HdfsUtils.getDistributedFileSystem(DEFAULT_HDFS_URL)
  val advancedYarnClient: AdvancedYarnClient = new AdvancedYarnClient(DEFAULT_RM_HOST, DEFAULT_HDFS_URL)
  Await.result(Future.sequence(YarnActorService.startActorSystems(advancedYarnClient)), DEFAULT_TIMEOUT)
  val coordinator: Coordinator = Await.result(Coordinator.create(advancedYarnClient), DEFAULT_TIMEOUT)

  def uploadFile(modelURL: URL): String = {
    val modelFile = new File(modelURL.getPath)
    val modelFilePath = s"$DEFAULT_HDFS_URL/test/${modelFile.getName}"
    HdfsUtils.upload(filesystem, modelFile, modelFilePath)
    modelFilePath
  }

  def loadMetamodel(metamodelURL: URL): Model = {
    val metamodel = new LinkedHashModel
    val urlString = metamodelURL.toString
    val format = Rio.getParserFormatForFileName(urlString)
    val parser = Rio.createParser(format)
    parser.setRDFHandler(new StatementCollector(metamodel))
    val inputStream = metamodelURL.openStream
    parser.parse(inputStream, urlString)
    metamodel
  }

  def loadInitialData(metamodel: Model, databaseConnection: DatabaseConnection) {
    coordinator.loadData(metamodel, databaseConnection, DEFAULT_RM_HOST, DEFAULT_HDFS_URL)
  }
  
  def loadChanges(changesMap : Map[String, ChangeSet]) {
    coordinator.sendChangesToInputs(changesMap)
  }

  private def startQuery(reteRecipe: ReteRecipe) {
    coordinator.startQuery(reteRecipe, DEFAULT_RM_HOST, DEFAULT_HDFS_URL)
  }
  
  private def startOutputStream(reteRecipe: ReteRecipe, patternName : String) {
    coordinator.startOutputStream(reteRecipe, patternName)
  }
  
  def checkQuery(reteRecipe: ReteRecipe, patternName: String): Set[Tuple] = {
    if (IncQueryDZooKeeper.getData(s"${IncQueryDZooKeeper.runningQueries}/$patternName") == null) {
      startQuery(reteRecipe)
      startOutputStream(reteRecipe, patternName)
    }
    coordinator.checkResults(reteRecipe, patternName)
  }

  
  
  def dispose() {
    coordinator.dispose
    YarnActorService.stopActorSystems()
  }

}
