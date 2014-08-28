package hu.bme.mit.incqueryd.fourstore
import scala.concurrent.duration._
import java.awt.geom.AffineTransform

object FourStoreDriverMain2 {

  def main(args: Array[String]) {
    println("Hello")

    var architectureDirectory = "/home/szarnyasg/git/incqueryd/hu.bme.mit.incqueryd.queries/arch/"

    load(architectureDirectory + "posLength.arch")
    load(architectureDirectory + "routeSensor.arch")

  }

  def load(architectureFile: String) {
    println(architectureFile)
  }
}