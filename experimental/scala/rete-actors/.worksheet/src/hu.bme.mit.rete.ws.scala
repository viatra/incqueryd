package hu.bme.mit.rete

object ws {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(58); 
  val c1p = Set(1, 2);System.out.println("""c1p  : scala.collection.immutable.Set[Int] = """ + $show(c1p ));$skip(22); 
  val c1n = Set(3, 4);System.out.println("""c1n  : scala.collection.immutable.Set[Int] = """ + $show(c1n ));$skip(20); 

  val c2p = Set(3);System.out.println("""c2p  : scala.collection.immutable.Set[Int] = """ + $show(c2p ));$skip(19); 
  val c2n = Set(1);System.out.println("""c2n  : scala.collection.immutable.Set[Int] = """ + $show(c2n ));$skip(38); 
  
  val c1 = new ChangeSet(c1p, c1n);System.out.println("""c1  : hu.bme.mit.rete.ChangeSet = """ + $show(c1 ));$skip(35); 
  val c2 = new ChangeSet(c2p, c2n);System.out.println("""c2  : hu.bme.mit.rete.ChangeSet = """ + $show(c2 ));$skip(13); val res$0 = 
  
  c1 + c2;System.out.println("""res0: hu.bme.mit.rete.ChangeSet = """ + $show(res$0));$skip(14); 

	val s = Set;System.out.println("""s  : scala.collection.immutable.Set.type = """ + $show(s ))}
	

}
