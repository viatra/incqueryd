package hu.bme.mit.incqueryd.main

import hu.bme.mit.incqueryd.rete.dataunits.ScalaChangeSet
import hu.bme.mit.incqueryd.rete.dataunits.Tuple
import java.util.HashSet

object IncQueryDMain {

  def main(args: Array[String]) {
    val engine = new IncQueryDEngine

    engine initialize (args(0), true, args(1))

  }
 }