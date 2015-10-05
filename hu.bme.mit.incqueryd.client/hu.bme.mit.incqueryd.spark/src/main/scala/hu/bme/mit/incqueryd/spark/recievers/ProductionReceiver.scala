package hu.bme.mit.incqueryd.spark.recievers

import scala.reflect.ClassTag
import org.apache.spark.streaming.receiver.ActorHelper
import akka.actor.Actor
import hu.bme.mit.incqueryd.engine.rete.actors.SubscribeReceiver
import hu.bme.mit.incqueryd.engine.rete.actors.UnsubscribeReceiver
import hu.bme.mit.incqueryd.spark.utils.IQDSparkUtils
import hu.bme.mit.incqueryd.engine.rete.dataunits.Tuple
import hu.bme.mit.incqueryd.engine.rete.actors.ReteCommunicationMessage
import akka.actor.ActorRef
import akka.actor.ActorPath

/**
 * @author pappi
 */
class ProductionReceiver(productionActorPath : String) extends Actor with ActorHelper {
  
  private lazy val productionActor : ActorRef = context.actorFor(productionActorPath)
  
  override def preStart(): Unit = productionActor ! SubscribeReceiver(context.self)
  
  def receive() = {
    case msg => store(msg)
  }
  
  override def postStop(): Unit = productionActor ! UnsubscribeReceiver(context.self)

}
