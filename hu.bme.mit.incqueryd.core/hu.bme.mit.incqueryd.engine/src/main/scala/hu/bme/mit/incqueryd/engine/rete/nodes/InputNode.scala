package hu.bme.mit.incqueryd.engine.rete.nodes

import org.eclipse.incquery.runtime.rete.recipes.TypeInputRecipe
import java.util.HashSet
import hu.bme.mit.incqueryd.engine.rete.dataunits.Tuple
import java.lang.management.ManagementFactory
import hu.bme.mit.incqueryd.engine.rete.dataunits.ChangeSet
import hu.bme.mit.incqueryd.engine.rete.dataunits.ChangeType
import org.eclipse.incquery.runtime.rete.recipes.BinaryInputRecipe
import org.eclipse.incquery.runtime.rete.recipes.UnaryInputRecipe
import hu.bme.mit.bigmodel.rdf.RDFHelper
import hu.bme.mit.bigmodel.fourstore.FourStoreDriverTrainBenchmark
import scala.collection.JavaConversions.asScalaBuffer
import scala.collection.JavaConversions.asScalaSet
import scala.collection.JavaConversions.collectionAsScalaIterable
import scala.collection.JavaConversions.mapAsScalaMap
import scala.collection.JavaConversions.seqAsJavaList
import scala.collection.immutable.Stack
import hu.bme.mit.incqueryd.engine.rete.messages.UpdateMessage
import hu.bme.mit.incqueryd.engine.rete.dataunits.ReteNodeSlot

class InputNode(recipe: TypeInputRecipe) extends AlphaNode {

  val typeName = recipe.getTypeName().split("#")(1)
  val tuples = new HashSet[Tuple]

  val databaseDriver = new FourStoreDriverTrainBenchmark("trainbenchmark_cluster", false)

  def getMemoryConsumption() = {
    val memoryMXBean = ManagementFactory.getMemoryMXBean();
    memoryMXBean.getHeapMemoryUsage().getUsed() / (1024 * 1024);
  }

  def update(changeSet: ChangeSet) = {
    val incomingTuples = changeSet.getTuples
    changeSet.getChangeType() match {
      case ChangeType.POSITIVE => tuples.addAll(incomingTuples)
      case ChangeType.NEGATIVE => tuples.removeAll(incomingTuples)
    }
    changeSet
  }

  def initialize() = {
    recipe match {
      case binaryInputRecipe: BinaryInputRecipe => {
        val traceInfo = binaryInputRecipe.getTraceInfo
        if (traceInfo.startsWith("attribute")) {
          initializeAttribute(binaryInputRecipe)
        } else if (traceInfo.startsWith("edge")) {
          initializeEdge(binaryInputRecipe)
        }
      }
      case unaryInputRecipe: UnaryInputRecipe => {
        initializeVertex(unaryInputRecipe)
      }
    }

    val changeSet = new ChangeSet(tuples, ChangeType.POSITIVE)
    changeSet
  }

  def initializeAttribute(recipe: BinaryInputRecipe) = {
    val typeName = RDFHelper.brackets(recipe.getTypeName)
    val attributes = databaseDriver.collectVerticesWithProperty(typeName)

    attributes.foreach(attribute => {
      val key = attribute._1
      val value = attribute._2

      val regex = "\"(.*?)\"\\^\\^<http://www.w3.org/2001/XMLSchema#int>".r
      val intValue = regex.findFirstMatchIn(value).get.group(1)
      tuples += new Tuple(key, intValue)
    })
  }

  def initializeEdge(recipe: BinaryInputRecipe) = {
    val typeName = RDFHelper.brackets(recipe.getTypeName)
    val edges = databaseDriver.collectEdges(typeName)

    edges.entries.foreach(edge => {
      tuples += new Tuple(edge.getKey, edge.getValue)
    })
  }

  def initializeVertex(recipe: UnaryInputRecipe) = {
    val vertices = databaseDriver.collectVertices(RDFHelper.brackets(recipe.getTypeName))
    vertices.foreach(vertex => tuples += new Tuple(vertex))
  }
}
