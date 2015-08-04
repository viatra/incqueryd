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

  var filesystem: FileSystem = null
  var advancedYarnClient: AdvancedYarnClient = null
  var coordinator: Coordinator = null
  var metamodel: Model = null

  var queries : scala.collection.mutable.Map[String, ReteRecipe] = scala.collection.mutable.Map()

  def connect() {
    filesystem = HdfsUtils.getDistributedFileSystem(DEFAULT_HDFS_URL)
    advancedYarnClient = new AdvancedYarnClient(DEFAULT_RM_HOST, DEFAULT_HDFS_URL)
  }

  def startActorSystems() {
    Await.result(Future.sequence(YarnActorService.startActorSystems(advancedYarnClient)), DEFAULT_TIMEOUT)
  }

  def startCoordinator() {
    coordinator = Await.result(Coordinator.create(advancedYarnClient), DEFAULT_TIMEOUT)
  }
  
  def loadMetamodel(metamodelURL: URL) {
    metamodel = new LinkedHashModel
    val urlString = metamodelURL.toString
    val format = Rio.getParserFormatForFileName(urlString)
    val parser = Rio.createParser(format)
    parser.setRDFHandler(new StatementCollector(metamodel))
    val inputStream = metamodelURL.openStream
    parser.parse(inputStream, urlString)
  }

  def loadInitialData(modelURL: URL) {
    val modelFile = new File(modelURL.getPath)
    val modelFilePath = s"$DEFAULT_HDFS_URL/test/${modelFile.getName}"
    HdfsUtils.upload(filesystem, modelFile, modelFilePath)
    coordinator.loadData(metamodel, modelFilePath, DEFAULT_RM_HOST, DEFAULT_HDFS_URL)
  }
  
  def loadChanges(changesMap : java.util.Map[String, ChangeSet]) {
    coordinator.sendChangesToInputs(changesMap.toMap)
  }
  
  def startQuery(reteRecipe: ReteRecipe) {
    coordinator.startQuery(reteRecipe, DEFAULT_RM_HOST, DEFAULT_HDFS_URL)
  }

  def checkQuery(reteRecipe: ReteRecipe, patternName: String): java.util.Collection[Tuple] = {
    if (!queries.keySet.contains(patternName)) {
      startQuery(reteRecipe)
      queries.put(patternName, reteRecipe)
    }
    asJavaCollection(coordinator.checkResults(reteRecipe, patternName))
  }

  def dispose() {
    queries.values.foreach { recipe =>  coordinator.stopQuery(recipe, DEFAULT_RM_HOST)}
    coordinator.dispose
    YarnActorService.stopActorSystems()
  }

}
