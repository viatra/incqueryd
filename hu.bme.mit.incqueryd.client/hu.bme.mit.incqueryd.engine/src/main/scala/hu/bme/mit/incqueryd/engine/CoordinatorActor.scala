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

class CoordinatorActor extends Actor {
  
  implicit val timeout: Timeout = Timeout(AkkaUtils.defaultTimeout)
  import context.dispatcher

  def receive = AkkaUtils.propagateException(sender) ({
    case LoadData(hdfsPath, vocabulary, inventory) => {
      val types = getTypes(vocabulary, hdfsPath)
      val typeInputRecipes = types.map(_.getInputRecipe)
      val plan = allocate(typeInputRecipes, types, inventory)
      val index = deploy(plan, types)
      configureIndex(index, hdfsPath)
      sender ! index
    }
    case StartQuery(recipeJson, index) => {
      val recipe = RecipeDeserializer.deserializeFromString(recipeJson).asInstanceOf[ReteRecipe]
      val notTypeInputRecipes = recipe.getRecipeNodes.filterNot(_.isInstanceOf[TypeInputRecipe])
      val types = index.yellowPages.inputActorsByType.keySet
      val plan = allocate(notTypeInputRecipes, types, index.deployedInventory)
      val deploymentResult = deploy(plan, types)
      val network = DeploymentResult(YellowPages(index.yellowPages.inputActorsByType, deploymentResult.yellowPages.otherActorsByKey), deploymentResult.deployedInventory)
      configureNetwork(network, recipe)
      establishSubscriptions(network)
      propagateInputStates(network, recipe)
      sender ! network
    }
    case CheckResults(recipeJson, network, patternName) => {
      val recipe = RecipeDeserializer.deserializeFromString(recipeJson).asInstanceOf[ReteRecipe]
      val productionRecipeOption = RecipeUtils.findProductionRecipe(recipe, patternName)
      val productionKey = ReteActorKey(productionRecipeOption.get) // XXX Option.get
      val production = network.yellowPages.otherActorsByKey.get(productionKey).get // XXX Option.get
      production.ask(GetQueryResults).pipeTo(sender)
    }
    case StopQuery(network) => {
      undeploy(network)
      sender ! "Ready"
    }
  })

  def getPatternName(recipe: ReteNodeRecipe): Option[String] = {
    recipe match {
      case recipe: ProductionRecipe => recipe.getPattern match { // XXX it is Object :(
        case pattern: PQuery => Some(pattern.getFullyQualifiedName)
        case _ => None
      }
      case _ => None
    }
  }

  def getTypes(vocabulary: Model, hdfsPath: String): Set[RdfType] = {
    val hdfs = HdfsUtils.getDistributedFileSystem(hdfsPath)
    val inputStream = HdfsUtils.download(hdfs, hdfsPath)
    val driver = new FileGraphDriverRead(hdfsPath, inputStream)
    inputStream.close
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

  def allocate(recipes: Iterable[ReteNodeRecipe], types: Set[RdfType], inventory: Inventory): DeploymentPlan = {
    val recipesSorted = recipes.toList.sortBy(-RecipeUtils.getEstimatedMemoryUsageMb(_, types))
    val allocation = mutable.Map[ReteNodeRecipe, MachineInstance]()
    val allocatedInstances = new ArrayList(inventory.machineInstances)
    for (recipe <- recipesSorted) {
      val memoryUsageMb = RecipeUtils.getEstimatedMemoryUsageMb(recipe, types)
      val goodInstances = allocatedInstances.filter(_.memoryMb > memoryUsageMb)
      if (goodInstances.isEmpty) {
        throw new IllegalArgumentException(s"Can't allocate ${RecipeUtils.getName(recipe)} on any machine!") // XXX return Option instead?
      } else {
        val selectedInstance = goodInstances.head
        allocation.put(recipe, selectedInstance)
        val allocatedInstance = selectedInstance.copy(memoryMb = selectedInstance.memoryMb - memoryUsageMb)
        allocatedInstances.remove(selectedInstance)
        allocatedInstances.add(allocatedInstance)
      }
    }
    val deployedInventory = inventory.copy(machineInstances = allocatedInstances.toList)
    DeploymentPlan(allocation.toMap, deployedInventory)
  }

  def deploy(deploymentPlan: DeploymentPlan, types: Set[RdfType]): DeploymentResult = {
	val inputActorsByType = mutable.Map[RdfType, ActorRef]()
	val otherActorsByKey = mutable.Map[ReteActorKey, ActorRef]()
    for ((recipe, instance) <- deploymentPlan.allocation) {
      val actorId = RemoteReteActor.actorId(recipe, instance) 
      val actor = new RemoteActorService(instance.ip).start(actorId, classOf[ReteActor])
      recipe match {
        case recipe: TypeInputRecipe => inputActorsByType.put(RecipeUtils.findType(types, recipe).get, actor) // XXX Option.get
        case _ => otherActorsByKey.put(ReteActorKey(recipe), actor)
      }
    }
    DeploymentResult(YellowPages(inputActorsByType.toMap, otherActorsByKey.toMap), deploymentPlan.deployedInventory)
  }

  def undeploy(deploymentResult: DeploymentResult): Unit = {
    for (actor <- deploymentResult.yellowPages.inputActorsByType.values ++ deploymentResult.yellowPages.otherActorsByKey.values) {
      actor ! PoisonPill
    }
  }

  def configureIndex(index: DeploymentResult, hdfsPath: String): Unit = {
    wait(index.yellowPages.inputActorsByType.map { case (rdfType, actor) =>
      val nodeRecipe = rdfType.getInputRecipe
      actor.ask(Configure(new ReteNodeConfiguration(nodeRecipe, List(), hdfsPath)))
    })
  }

  def configureNetwork(network: DeploymentResult, recipe: ReteRecipe): Unit = {
    wait(network.yellowPages.otherActorsByKey.map { case (key, actor) =>
      val nodeRecipe = RecipeUtils.findRecipe(recipe, key).get // XXX Option.get
      actor.ask(Configure(new ReteNodeConfiguration(nodeRecipe, List(), "")))
    })
  }

  def establishSubscriptions(network: DeploymentResult): Unit = {
    wait(network.yellowPages.otherActorsByKey.values.map { actor =>
      actor.ask(EstablishSubscriptions(network.yellowPages))
    })
  }
  
  def propagateInputStates(network: DeploymentResult, recipe: ReteRecipe): Unit = {
    wait(network.yellowPages.inputActorsByType.map { case (rdfType, actor) =>
      val children = YellowPagesUtils.getChildrenConnections(actor, recipe, network.yellowPages)
      actor.ask(PropagateState(children))
    })
  }

  private def wait(futures: Iterable[Future[Any]]) { // XXX don't use this, compose Futures
    Await.result(Future.sequence(futures), timeout.duration)
  }
  
}