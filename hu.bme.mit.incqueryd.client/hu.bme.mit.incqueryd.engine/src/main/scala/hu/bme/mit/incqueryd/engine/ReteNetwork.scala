package hu.bme.mit.incqueryd.engine

object ReteNetwork {
  final val actorSystemName = "rete"
  final val port = 2553
}

case class ReteNetwork(patterns: Iterable[PatternDescriptor])

case class PatternDescriptor()