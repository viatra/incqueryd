package hu.bme.mit.incqueryd.core

import java.text.MessageFormat

object CoreScripts {
  private val DIRECTORY = "hu.bme.mit.incqueryd.core/scripts/"
  val START_COORDINATOR = DIRECTORY + "coordinator/start-coordinator.sh"
  private val AKKA_DIRECTORY = DIRECTORY + "components/akka/"
  def GENERATE_CONFIGS(ports: Iterable[Int]) = format(AKKA_DIRECTORY + "generate-configs.sh {0}", ports.mkString(" "))
  def START_MICROKERNEL(port: Int, memory: Int) = format(AKKA_DIRECTORY + "start-akka.sh {0} {1}", port, memory)
}