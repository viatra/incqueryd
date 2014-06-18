package hu.bme.mit.incqueryd.main

import hu.bme.mit.incqueryd.rete.dataunits.ScalaChangeSet
import hu.bme.mit.incqueryd.rete.dataunits.Tuple
import java.util.HashSet

object IncQueryDMain {
	def main(args: Array[String]) {
		println("We're running scala..")
		
		var t1 = new Tuple(new Integer(1))
		var t2 = new Tuple(new Integer(2))
		var t3 = new Tuple(new Integer(3))
		var t4 = new Tuple(new Integer(4))
		
		var cs1 = new ScalaChangeSet(Set(t1, t2), Set(t3, t4))
		
		var t5 = new Tuple(new Integer(3))
		var t6 = new Tuple(new Integer(5))
		var t7 = new Tuple(new Integer(2))
		
		var cs2 = new ScalaChangeSet(Set(t5, t6), Set(t7))
		
		println(cs1 + cs2)
		
		var s1 = new HashSet[Tuple]()
		s1.add(t1)
		s1.add(t2)
		var s2 = new HashSet[Tuple]()
		s2.add(t3)
		s2.add(t4)
		var cs3 = new ScalaChangeSet(s1, s2)
		
		println(cs3 + cs2)
		
		var t11 = new Tuple(new Integer(7))
		var t10 = new Tuple(new Integer(9))
		
		var cs11 = new ScalaChangeSet(Set(t10), Set(t11))
		
		var t15 = new Tuple(new Integer(4))
		var t16 = new Tuple(new Integer(5))
		var t17 = new Tuple(new Integer(6))
		
		var cs12 = new ScalaChangeSet(Set(t15, t16), Set(t17))
		
		var t12 = new Tuple(new Integer(7))
		var t14 = new Tuple(new Integer(8))
		var t13 = new Tuple(new Integer(5))
		
		var cs13 = new ScalaChangeSet(Set(t12, t14), Set(t13))
		
		println(cs11 + cs12 + cs13)
	}
 }