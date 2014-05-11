package hu.bme.mit.rete

class ChangeSet(val positiveChanges: Set[Int], val negativeChanges: Set[Int]) {
	
	/**
	 * Operation for adding to ChangeSets together.
	 */
	def +(c2: ChangeSet): ChangeSet = {
		val pC = positiveChanges.union(c2.positiveChanges).diff(negativeChanges).diff(c2.negativeChanges)
		val nC = negativeChanges.union(c2.negativeChanges).diff(positiveChanges).diff(c2.positiveChanges)
		new ChangeSet(pC, nC)		
	}

	/**
	 * we get the inverse of a ChangeSet by just switching its positive and negative changes 
	 */
	def -(): ChangeSet = {
	  new ChangeSet(negativeChanges, positiveChanges)
	}
	
	override def toString: String = "+" + positiveChanges + ", " + "-" + negativeChanges
}