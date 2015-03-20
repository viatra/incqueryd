package hu.bme.mit.incqueryd.engine.rete.actors

sealed trait ReteReply
case object ConfigurationFinished extends ReteReply
case object SubscriptionFinished extends ReteReply
case object SubscriberRegistered extends ReteReply
case object StatePropagated extends ReteReply