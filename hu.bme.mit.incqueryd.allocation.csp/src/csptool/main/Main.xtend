package csptool.main

import com.google.ortools.constraintsolver.Solver
import static extension hu.bme.mit.incqueryd.csp.impl.ortools.extensions.ConstraintExtension.*
import com.google.ortools.constraintsolver.IntVar
import java.util.ArrayList
import java.util.List
import com.google.ortools.constraintsolver.DecisionBuilder
import hu.bme.mit.incqueryd.csp.impl.ortools.helpers.VariableHelper

class Main {
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
		

		val Solver solver = new Solver("AllocationSolver")
		solver.makeDefaultSolver()
		
		val IntVar x1 = VariableHelper.bounded("x1", 0, 1000, solver)
		val IntVar x2 = VariableHelper.bounded("x2", 0, 1000, solver)
		
		val constraint = #[x1, x2].SUM_LE(1000)
		
		solver >> constraint
		
		val objective = solver.makeWeightedMaximize(#[x1, x2], #[1, 5] as int[], 1)
//		val x1_ = solver.makeProd(x1,1)
//		val x2_ = solver.makeProd(x2,5)
//		val weightedSum = solver.makeSum(x1_, x2_)
//		
//		val objective = solver.makeMaximize(weightedSum.^var(), 1)
		
		val List<IntVar> listForSolver = new ArrayList;
		listForSolver.add(x1)
		listForSolver.add(x2)
		
		var DecisionBuilder db = solver.makePhase(listForSolver,
                                       Solver::CHOOSE_FIRST_UNBOUND,
                                       Solver::ASSIGN_MAX_VALUE)
        
                                       
        solver.newSearch(db, objective);
        
        var int j
        while (solver.nextSolution()) {
			System.out.println(j + ". solution")
			
			println("x1: " + x1.value)
			println("x2: " + x2.value)
			//println("weighted sum: " + weightedSum.^var().value)
			println
			j=j+1;
			
		}
        
		solver.endSearch();
		
		
	}
	
}