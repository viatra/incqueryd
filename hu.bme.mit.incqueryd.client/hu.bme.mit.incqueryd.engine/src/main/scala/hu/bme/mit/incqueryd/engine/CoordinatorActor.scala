package hu.bme.mit.incqueryd.engine

import akka.actor.Actor
import eu.mondo.driver.file.FileGraphDriverRead
import hu.bme.mit.incqueryd.inventory.{ MachineInstance, Inventory }
import org.eclipse.emf.ecore.util.EcoreUtil
import org.openrdf.model.vocabulary.{ OWL, RDF, RDFS }
import org.openrdf.model.{ Model, URI }
import scala.collection.JavaConversions._
import scala.collection.mutable.ListBuffer
import hu.bme.mit.incqueryd.inventory.MachineInstance
import scala.collection.JavaConverters._
import java.util.ArrayList
import hu.bme.mit.incqueryd.actorservice.AkkaUtils
import hu.bme.mit.incqueryd.actorservice.ActorId
import java.security.MessageDigest
import org.apache.commons.codec.digest.DigestUtils
import hu.bme.mit.incqueryd.engine.rete.actors.ReteActor
import org.eclipse.incquery.runtime.rete.recipes.ReteRecipe
import org.eclipse.incquery.runtime.rete.recipes.ReteNodeRecipe
import org.eclipse.incquery.runtime.rete.recipes.RecipesFactory
import scala.collection.mutable
import hu.bme.mit.incqueryd.inventory.MachineInstance
import org.openrdf.model.Statement
import org.openrdf.model.Resource
import org.eclipse.incquery.runtime.rete.recipes.ProductionRecipe
import org.eclipse.incquery.runtime.matchers.psystem.queries.PQuery
import hu.bme.mit.incqueryd.engine.util.RecipeDeserializer
import org.eclipse.incquery.runtime.rete.recipes.TypeInputRecipe
import akka.actor.ActorRef
import akka.actor.PoisonPill
import hu.bme.mit.incqueryd.engine.util.ReteNodeConfiguration
import hu.bme.mit.incqueryd.engine.util.EObjectSerializer
import akka.pattern.{ ask, pipe }
import akka.util.Timeout
import akka.dispatch.Futures
import scala.concurrent.Future
import scala.concurrent.Await
import java.util.concurrent.TimeUnit
import scala.concurrent.duration._
import java.util.HashSet
import hu.bme.mit.incqueryd.engine.rete.nodes.ProductionNode
import hu.bme.mit.incqueryd.engine.rete.actors.GetQueryResults
import hu.bme.mit.incqueryd.engine.rete.actors.RdfType
import hu.bme.mit.incqueryd.engine.rete.actors.RecipeUtils
import hu.bme.mit.incqueryd.engine.rete.actors.EstablishSubscriptions
import hu.bme.mit.incqueryd.engine.rete.actors.Configure
import hu.bme.mit.incqueryd.engine.rete.actors.EstablishSubscriptions
import hu.bme.mit.incqueryd.engine.rete.actors.ReteActorKey
import hu.bme.mit.incqueryd.engine.rete.actors.PropagateState
import hu.bme.mit.incqueryd.yarn.HdfsUtils
import hu.bme.mit.incqueryd.actorservice.YarnActorService
import hu.bme.mit.incqueryd.yarn.IncQueryDZooKeeper
import hu.bme.mit.incqueryd.yarn.AdvancedYarnClient
import org.apache.hadoop.fs.FsUrlStreamHandlerFactory
import java.net.URL
import hu.bme.mit.incqueryd.engine.rete.actors.ActorLookupUtils
import akka.actor.ActorPath
import hu.bme.mit.incqueryd.engine.rete.dataunits.ChangeSet
import hu.bme.mit.incqueryd.engine.rete.actors.UpdateMessage
import hu.bme.mit.incqueryd.engine.rete.actors.PropagateInputState
import hu.bme.mit.incqueryd.spark.client.IQDSparkClient
import eu.mondo.driver.graph.RDFGraphDriverRead
import hu.bme.mit.incqueryd.engine.util.DatabaseConnection

class CoordinatorActor extends Actor {
  
  implicit val timeout: Timeout = Timeout(AkkaUtils.defaultTimeout)
  import context.dispatcher
  
  private var types : Set[RdfType] = _
  
  def receive = AkkaUtils.propagateException(sender) ({
    case LoadData(vocabulary, databaseConnection, rmHostname, fileSystemUri) => {
      types = getTypes(vocabulary, databaseConnection.getDriver)
      val typeInputRecipes: Set[ReteNodeRecipe] = types.map(_.getInputRecipe)
      val actorsByRecipe = deploy(typeInputRecipes, rmHostname, fileSystemUri, IncQueryDZooKeeper.inputNodesPath)
      configure(actorsByRecipe, databaseConnection)
      IQDSparkClient.loadData(databaseConnection)
      sender ! true
    }
    case StartQuery(recipeJson, rmHostname, fileSystemUri) => {
      val recipe = RecipeDeserializer.deserializeFromString(recipeJson).asInstanceOf[ReteRecipe]
      val notTypeInputRecipes = recipe.getRecipeNodes.filterNot(_.isInstanceOf[TypeInputRecipe]).toSet
      val otherActorsByRecipe = deploy(notTypeInputRecipes, rmHostname, fileSystemUri, IncQueryDZooKeeper.reteNodesPath)
      configure(otherActorsByRecipe, null)
      establishSubscriptions(otherActorsByRecipe)
      val typeInputRecipes: Set[ReteNodeRecipe] = types.map(_.getInputRecipe)
      val inputActorsByRecipe = lookup(typeInputRecipes)
      
      propagateInputStates(inputActorsByRecipe, recipe)
      sender ! true
    }
    case PropagateInputChanges(inputChangesMap : Map[String, ChangeSet]) => {
      propagateInputChanges(inputChangesMap)
      sender ! true
    }
    case StartOutputStream(recipeJson, patternName) => {
      val production = getProductionActorPath(recipeJson, patternName)
      IQDSparkClient.startOutputStream(patternName, production.toSerializationFormat)
      sender ! true
    }
    case StopOutputStreams() => {
      IQDSparkClient.stopOutputStreams()
      sender ! true
    }
    case CheckResults(recipeJson, patternName) => {
      val production = getProductionActorPath(recipeJson, patternName)
      AkkaUtils.convertToRemoteActorRef(production, context).ask(GetQueryResults).pipeTo(sender)
    }
    case StopQuery(recipeJson) => {
      val recipe = RecipeDeserializer.deserializeFromString(recipeJson).asInstanceOf[ReteRecipe]
      val notTypeInputRecipes = recipe.getRecipeNodes.filterNot(_.isInstanceOf[TypeInputRecipe]).toSet
      undeploy(notTypeInputRecipes)
      sender ! true
    }
    case Dispose() => {
      val typeInputRecipes: Set[ReteNodeRecipe] = types.map(_.getInputRecipe)
      undeploy(typeInputRecipes)
      sender ! true
    }
    case StartWikidataStream(databaseConnection) => {
      IQDSparkClient.startWikidataStreaming(databaseConnection)
      sender ! true
    }
    case StopWikidataStream => {
      IQDSparkClient.stopWikidataStreaming()
      sender ! true
    }
  })

  def getTypes(vocabulary: Model, driver: RDFGraphDriverRead): Set[RdfType] = {
    val rdfClassStatements = vocabulary.filter(null, RDF.TYPE, RDFS.CLASS).toSet
    val owlClassStatements = vocabulary.filter(null, RDF.TYPE, OWL.CLASS).toSet
    val classes = getUriSubjects(rdfClassStatements union owlClassStatements)
    val classTypes: Set[RdfType] = classes.map(RdfType(RdfType.Class, _, driver))
    val objectProperties = getUriSubjects(vocabulary.filter(null, RDF.TYPE, OWL.OBJECTPROPERTY).toSet union vocabulary.filter(null, RDF.TYPE, RDF.PROPERTY).toSet)
    val objectPropertyTypes: Set[RdfType] = objectProperties.map(RdfType(RdfType.ObjectProperty, _, driver))
    val datatypeProperties = getUriSubjects(vocabulary.filter(null, RDF.TYPE, OWL.DATATYPEPROPERTY).toSet union vocabulary.filter(null, RDF.TYPE, OWL.ANNOTATIONPROPERTY).toSet)
    val datatypePropertyTypes: Set[RdfType] = datatypeProperties.map(RdfType(RdfType.DatatypeProperty, _, driver))
    classTypes union objectPropertyTypes union datatypePropertyTypes
  }
  
  private def getProductionActorPath(recipeJson : String, patternName : String) : ActorPath = {
    val recipe = RecipeDeserializer.deserializeFromString(recipeJson).asInstanceOf[ReteRecipe]
    val productionRecipeOption = RecipeUtils.findProductionRecipe(recipe, patternName)
    val productionRecipe = productionRecipeOption.get // XXX Option.get
    val actorPath = ActorLookupUtils.findActor(productionRecipe).get // XXX Option.get
    IncQueryDZooKeeper.setData(s"${IncQueryDZooKeeper.runningQueries}/$patternName", actorPath.toSerializationFormat.getBytes)
    actorPath
  }
  
  def getUriSubjects(statements: Set[Statement]): Set[Resource] = {
    statements.map(_.getSubject).filter(_.isInstanceOf[URI]) // Discard blank nodes
  }

  def lookup(recipes: Set[ReteNodeRecipe]): Map[ReteNodeRecipe, ActorPath] = {
    recipes.map { recipe => recipe -> ActorLookupUtils.findActor(recipe).getOrElse(null) }
      .filter { case (key, value) => value != null }.toMap
  }

  def deploy(recipes: Set[ReteNodeRecipe], rmHostname: String, fileSystemUri: String, zkParentPath : String): Map[ReteNodeRecipe, ActorPath] = {

    val client = new AdvancedYarnClient(rmHostname, fileSystemUri)
    recipes.foreach { recipe => 
      val zkActorPath = ActorLookupUtils.getZKActorPath(recipe)
      IncQueryDZooKeeper.setData(s"$zkActorPath${IncQueryDZooKeeper.actorNamePath}", RemoteReteActor.reteActorName(recipe).getBytes)
      IncQueryDZooKeeper.setData(s"$zkActorPath${IncQueryDZooKeeper.nodeType}", RecipeUtils.getNodeType(recipe).getBytes)
      IncQueryDZooKeeper.setData(s"$zkActorPath${IncQueryDZooKeeper.rdfType}", RecipeUtils.getName(recipe).getBytes)
    }
    
    // Wait until actors start
    wait(YarnActorService.startActors(client, zkParentPath, classOf[ReteActor]))

    lookup(recipes)
  }

  def undeploy(recipes: Set[ReteNodeRecipe]): Unit = {
    val actorsByRecipe = lookup(recipes)
    for (actor <- actorsByRecipe.values) {
      AkkaUtils.convertToRemoteActorRef(actor, context) ! PoisonPill
    }
  }

  def configure(actorsByRecipe: Map[ReteNodeRecipe, ActorPath], databaseConnection: DatabaseConnection): Unit = {
    wait(actorsByRecipe.map { case (recipe, actor) =>
      AkkaUtils.convertToRemoteActorRef(actor, context).ask(Configure(new ReteNodeConfiguration(recipe, databaseConnection)))
    })
  }

  def establishSubscriptions(actorsByRecipe: Map[ReteNodeRecipe, ActorPath]): Unit = {
    wait(actorsByRecipe.values.map { actor =>
      AkkaUtils.convertToRemoteActorRef(actor, context).ask(EstablishSubscriptions())
    })
  }
  
  def propagateInputStates(actorsByRecipe: Map[ReteNodeRecipe, ActorPath], recipe: ReteRecipe): Unit = {
    wait(actorsByRecipe.values.map { actor =>
      val children = ActorLookupUtils.getChildrenConnections(actor, recipe)
      AkkaUtils.convertToRemoteActorRef(actor, context).ask(PropagateState(children))
    })
  }

  def propagateInputChanges(inputChangesMap : Map[String, ChangeSet]) {
    wait(inputChangesMap.map{case (inputTypeId, changeSet) => 
      val inputActorPath = ActorLookupUtils.findInputActor(inputTypeId).get
      AkkaUtils.convertToRemoteActorRef(inputActorPath, context).ask(PropagateInputState(changeSet))})
  }
  
  private def wait(futures: Iterable[Future[Any]]) { // XXX don't use this, compose Futures
    Await.result(Future.sequence(futures), timeout.duration)
  }
  
}