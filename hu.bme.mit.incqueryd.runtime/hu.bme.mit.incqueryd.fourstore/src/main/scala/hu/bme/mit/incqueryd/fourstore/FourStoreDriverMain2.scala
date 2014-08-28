package hu.bme.mit.incqueryd.fourstore

import scala.concurrent.duration._
import hu.bme.mit.incqueryd.arch.util.ArchUtil
import scala.collection.JavaConversions._

object FourStoreDriverMain2 {

  def main(args: Array[String]) {
    println("Hello")

    val architectureDirectory = "/home/szarnyasg/git/incqueryd/hu.bme.mit.incqueryd.queries/arch/"

    load(architectureDirectory + "posLength.arch")
    load(architectureDirectory + "routeSensor.arch")

  }

  def load(architectureFile: String) {
    val conf = ArchUtil.loadConfiguration(architectureFile)

    val mappings = conf.getMappings
    mappings.foreach(mapping => {
      val process = mapping.getProcess
      val machine = process.getMachine

    })
  }
}