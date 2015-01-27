package hu.bme.mit.incqueryd.engine

case class RdfTypeInfo(val rdfType: RdfType, tupleCount: Long) {

  def getEstimatedMemoryUsageMb(): Long = {
    val normalizedTupleCount = rdfType.arity * tupleCount
    val memoryUsage = Math.ceil((0.0003 * normalizedTupleCount + 52.969) * 1.4)
    Math.max(128, memoryUsage.toLong)
  }

}
