package hu.bme.mit.incqueryd.spark.recievers

import scala.reflect.ClassTag

import org.apache.spark.streaming.receiver.ActorHelper

import akka.actor.Actor
import hu.bme.mit.incqueryd.engine.rete.actors.SubscribeReceiver
import hu.bme.mit.incqueryd.engine.rete.actors.UnsubscribeReceiver
import hu.bme.mit.incqueryd.spark.utils.IQDSparkUtils

/**
 * @author pappi
 */
class ProductionReceiver[T: ClassTag](productionActorPath : String) extends Actor with ActorHelper {
  
  lazy private val productionActor = context.actorFor(productionActorPath)
  
  override def preStart(): Unit = productionActor ! SubscribeReceiver(context.self)
  
  def receive = IQDSparkUtils.writeException()({
    case msg => store(msg.asInstanceOf[T])
  })
  
  override def postStop(): Unit = productionActor ! UnsubscribeReceiver(context.self)

}
