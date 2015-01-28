package hu.bme.mit.incqueryd.actorservice

case class ActorId(
  val actorSystemName: String,
  val ip: String,
  val port: Int,
  val name: String)