package hu.bme.mit.rete

object ws {
  val c1p = Set(1, 2)                             //> c1p  : scala.collection.immutable.Set[Int] = Set(1, 2)
  val c1n = Set(3, 4)                             //> c1n  : scala.collection.immutable.Set[Int] = Set(3, 4)

  val c2p = Set(3)                                //> c2p  : scala.collection.immutable.Set[Int] = Set(3)
  val c2n = Set(1)                                //> c2n  : scala.collection.immutable.Set[Int] = Set(1)
  
  val c1 = new ChangeSet(c1p, c1n)                //> c1  : hu.bme.mit.rete.ChangeSet = +Set(1, 2), -Set(3, 4)
  val c2 = new ChangeSet(c2p, c2n)                //> c2  : hu.bme.mit.rete.ChangeSet = +Set(3), -Set(1)
  
  c1 + c2                                         //> res0: hu.bme.mit.rete.ChangeSet = +Set(2), -Set(4)

	val s = Set                               //> s  : scala.collection.immutable.Set.type = scala.collection.immutable.Set$@6
                                                  //| 18e8b78
	

}