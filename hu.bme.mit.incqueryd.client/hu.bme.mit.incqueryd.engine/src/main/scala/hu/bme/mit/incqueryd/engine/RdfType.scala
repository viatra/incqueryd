package hu.bme.mit.incqueryd.engine

import eu.mondo.driver.file.FileGraphDriverRead
import org.openrdf.model.Resource

abstract class RdfType() {
  val id: Resource
  val arity: Int
  def getTupleCount(driver: FileGraphDriverRead): Long
}

case class RdfClass(override val id: Resource) extends RdfType {
  override val arity = 1
  override def getTupleCount(driver: FileGraphDriverRead): Long = {
    driver.countVertices(id.stringValue)
  }
}

case class RdfObjectProperty(override val id: Resource) extends RdfType {
  override val arity = 2
  override def getTupleCount(driver: FileGraphDriverRead): Long = {
    driver.countEdges(id.stringValue)
  }
}

case class RdfDatatypeProperty(override val id: Resource) extends RdfType {
  override val arity = 2
  override def getTupleCount(driver: FileGraphDriverRead): Long = {
    driver.countProperties(id.stringValue)
  }
}