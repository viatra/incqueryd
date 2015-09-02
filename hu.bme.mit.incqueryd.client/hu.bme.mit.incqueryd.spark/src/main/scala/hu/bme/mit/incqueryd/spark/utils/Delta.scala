package hu.bme.mit.incqueryd.spark.utils

import hu.bme.mit.incqueryd.engine.rete.dataunits.ChangeType

case class Delta(data: Array[String], changeType: ChangeType, inputType: String, inputActorPath: String)