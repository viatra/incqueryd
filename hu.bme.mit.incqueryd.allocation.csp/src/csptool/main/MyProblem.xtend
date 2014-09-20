package csptool.main

import com.google.ortools.constraintsolver.Solver

import static extension hu.bme.mit.incqueryd.csp.impl.ortools.extensions.ConstraintExtension.*
import com.google.ortools.constraintsolver.IntVar
import com.google.common.collect.ImmutableList
import java.util.List
import com.google.common.collect.Lists
import com.google.ortools.constraintsolver.DecisionBuilder
import hu.bme.mit.incqueryd.csp.impl.ortools.helpers.VariableHelper

class MyProblem {
	
	def static void main(String[] args) {
		
		try{
			System.loadLibrary("jniortools_64");
		}catch(UnsatisfiedLinkError e){
			System.err.println(e.message)
			try{
				System.loadLibrary("jniortools_32");
			}catch(UnsatisfiedLinkError e2){
				println("ERROR: Cannot load or-tools native library");
			}
		}
			
		val Solver solver = new Solver("ALS");
		solver.makeDefaultSolver();
		
		val IntVar b = VariableHelper.enumerated("B", #[0,3], solver);
		//val IntVar b = VariableHelper.bounded("B", 0, 3, solver);
		
		val a = VariableHelper.boundedArray("A", 2, ImmutableList.of(1,1), ImmutableList.of(4,3), solver);
		val c = a.SUM_GE(7);
		
		solver >> c
		
		solver >> (c => (b -> 3))
		
		val List<IntVar> listForSolver = Lists.newArrayList(b);
		listForSolver.addAll(a);

		var DecisionBuilder db = solver.makePhase(listForSolver,
                                       Solver::CHOOSE_FIRST_UNBOUND,
                                       Solver::ASSIGN_MIN_VALUE);
		
		solver.newSearch(db);
		
		while (solver.nextSolution()) {
			a.forEach[p1, p2| print(p1.value+", ")];
			println();
			println("B:"+b.value);
			println();
		}
		
		solver.endSearch();
	}
	
}