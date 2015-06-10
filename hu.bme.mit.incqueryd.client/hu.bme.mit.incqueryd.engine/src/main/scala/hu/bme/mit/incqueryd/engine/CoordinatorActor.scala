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
import hu.bme.mit.incqueryd.actorservice.RemoteActorService
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
import hu.bme.mit.incqueryd.engine.rete.actors.YellowPages
import hu.bme.mit.incqueryd.engine.rete.actors.ReteActorKey
import hu.bme.mit.incqueryd.engine.rete.actors.YellowPagesUtils
import hu.bme.mit.incqueryd.engine.rete.actors.PropagateState
import hu.bme.mit.incqueryd.yarn.HdfsUtils
import hu.bme.mit.incqueryd.actorservice.YarnActorService
import hu.bme.mit.incqueryd.yarn.IncQueryDZooKeeper
import hu.bme.mit.incqueryd.yarn.AdvancedYarnClient

class CoordinatorActor extends Actor {
  
  implicit val timeout: Timeout = Timeout(AkkaUtils.defaultTimeout)
  import context.dispatcher

  def receive = AkkaUtils.propagateException(sender) ({
    case LoadData(vocabulary, hdfsPath, rmHostname, fileSystemUri) => {
      val types = getTypes(vocabulary, hdfsPath)
      val typeInputRecipes: Set[ReteNodeRecipe] = types.map(_.getInputRecipe)
      val actorsByRecipe = deploy(typeInputRecipes, rmHostname, fileSystemUri, IncQueryDZooKeeper.inputNodesPath)
      configure(actorsByRecipe, hdfsPath)
      sender ! true
    }
    case StartQuery(recipeJson, rmHostname, fileSystemUri) => {
      val recipe = RecipeDeserializer.deserializeFromString(recipeJson).asInstanceOf[ReteRecipe]
      val notTypeInputRecipes = recipe.getRecipeNodes.filterNot(_.isInstanceOf[TypeInputRecipe]).toSet
      val otherActorsByRecipe = deploy(notTypeInputRecipes, rmHostname, fileSystemUri, IncQueryDZooKeeper.reteNodesPath)
      configure(otherActorsByRecipe, "")
      establishSubscriptions(otherActorsByRecipe)
      val typeInputRecipes = recipe.getRecipeNodes.filter(_.isInstanceOf[TypeInputRecipe]).toSet
      val inputActorsByRecipe = lookup(typeInputRecipes)
      propagateInputStates(inputActorsByRecipe, recipe)
      sender ! true
    }
    case CheckResults(recipeJson, patternName) => {
      val recipe = RecipeDeserializer.deserializeFromString(recipeJson).asInstanceOf[ReteRecipe]
      val productionRecipeOption = RecipeUtils.findProductionRecipe(recipe, patternName)
      val productionRecipe = productionRecipeOption.get // XXX Option.get
      val production = YellowPagesUtils.findActorUsingZooKeeper(productionRecipe).get // XXX Option.get
      production.ask(GetQueryResults).pipeTo(sender)
    }
    case StopQuery(recipeJson) => {
      val recipe = RecipeDeserializer.deserializeFromString(recipeJson).asInstanceOf[ReteRecipe]
      val notTypeInputRecipes = recipe.getRecipeNodes.filterNot(_.isInstanceOf[TypeInputRecipe]).toSet
      undeploy(notTypeInputRecipes)
      sender ! true
    }
  })

  def getTypes(vocabulary: Model, hdfsPath: String): Set[RdfType] = {
    val hdfs = HdfsUtils.getDistributedFileSystem(hdfsPath)
    val driver = new FileGraphDriverRead(hdfsPath)
    val rdfClassStatements = vocabulary.filter(null, RDF.TYPE, RDFS.CLASS).toSet
    val owlClassStatements = vocabulary.filter(null, RDF.TYPE, OWL.CLASS).toSet
    val classes = getUriSubjects(rdfClassStatements union owlClassStatements)
    val classTypes: Set[RdfType] = classes.map(RdfType(RdfType.Class, _, driver))
    val objectProperties = getUriSubjects(vocabulary.filter(null, RDF.TYPE, OWL.OBJECTPROPERTY).toSet)
    val objectPropertyTypes: Set[RdfType] = objectProperties.map(RdfType(RdfType.ObjectProperty, _, driver))
    val datatypeProperties = getUriSubjects(vocabulary.filter(null, RDF.TYPE, OWL.DATATYPEPROPERTY).toSet)
    val datatypePropertyTypes: Set[RdfType] = datatypeProperties.map(RdfType(RdfType.DatatypeProperty, _, driver))
    classTypes union objectPropertyTypes union datatypePropertyTypes
  }
  
  def getUriSubjects(statements: Set[Statement]): Set[Resource] = {
    statements.map(_.getSubject).filter(_.isInstanceOf[URI]) // Discard blank nodes
  }

  def lookup(recipes: Set[ReteNodeRecipe]): Map[ReteNodeRecipe, ActorRef] = {
    recipes.map { recipe => recipe -> YellowPagesUtils.findActorUsingZooKeeper(recipe).getOrElse(null) }
      .filter { case (key, value) => value != null }.toMap
  }

  def deploy(recipes: Set[ReteNodeRecipe], rmHostname: String, fileSystemUri: String, zkAMPath : String): Map[ReteNodeRecipe, ActorRef] = {

    val client = new AdvancedYarnClient(rmHostname, fileSystemUri)
    recipes.foreach { recipe => 
      var zkRecipePath = "/"
      recipe match {
        case recipe: TypeInputRecipe => zkRecipePath = IncQueryDZooKeeper.inputNodesPath + "/" + ReteActorKey(recipe).internalId
        case _ => zkRecipePath = IncQueryDZooKeeper.reteNodesPath + "/" + ReteActorKey(recipe).internalId
      }
      IncQueryDZooKeeper.createDir(zkRecipePath)
    }
    wait(YarnActorService.create(client, zkAMPath))
    //TODO: start RemoteActorServices and store ActorPaths in ZK
    lookup(recipes)
  }

  def undeploy(recipes: Set[ReteNodeRecipe]): Unit = {
    val actorsByRecipe = lookup(recipes)
    for (actor <- actorsByRecipe.values) {
      actor ! PoisonPill
    }
  }

  def configure(actorsByRecipe: Map[ReteNodeRecipe, ActorRef], hdfsPath: String): Unit = {
    wait(actorsByRecipe.map { case (recipe, actor) =>
      actor.ask(Configure(new ReteNodeConfiguration(recipe, List(), hdfsPath)))
    })
  }

  def establishSubscriptions(actorsByRecipe: Map[ReteNodeRecipe, ActorRef]): Unit = {
    wait(actorsByRecipe.values.map { actor =>
      actor.ask(EstablishSubscriptions())
    })
  }
  
  def propagateInputStates(actorsByRecipe: Map[ReteNodeRecipe, ActorRef], recipe: ReteRecipe): Unit = {
    wait(actorsByRecipe.values.map { actor =>
      val children = YellowPagesUtils.getChildrenConnections(actor, recipe, YellowPages(Map(), Map()))
      actor.ask(PropagateState(children))
    })
  }

  private def wait(futures: Iterable[Future[Any]]) { // XXX don't use this, compose Futures
    Await.result(Future.sequence(futures), timeout.duration)
  }
  
}