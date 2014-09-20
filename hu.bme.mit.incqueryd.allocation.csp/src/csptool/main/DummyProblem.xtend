package csptool.main

import com.google.ortools.constraintsolver.Solver

import static extension hu.bme.mit.incqueryd.csp.impl.ortools.extensions.ConstraintExtension.*
import com.google.ortools.constraintsolver.IntVar
import java.util.List
import com.google.common.collect.Lists
import com.google.ortools.constraintsolver.DecisionBuilder
import hu.bme.mit.incqueryd.csp.impl.ortools.helpers.VariableHelper

class DummyProblem {
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
		
		val IntVar x1 = VariableHelper.enumerated("X1", #[0, 1000], solver);
		val IntVar y1 = VariableHelper.enumerated("Y1", #[0, 1200], solver);
		val IntVar z1 = VariableHelper.enumerated("Z1", #[0, 1100], solver);

		
		val IntVar[] v1 = #[x1, y1, z1]
		
		val c1 = v1.SUM_LE(2300)
		solver >> c1
		
		val IntVar x2 = VariableHelper.enumerated("X2", #[0, 1000], solver);
		val IntVar y2 = VariableHelper.enumerated("Y2", #[0, 1200], solver);
		val IntVar z2 = VariableHelper.enumerated("Z2", #[0, 1100], solver);

		
		val IntVar[] v2 = #[x2, y2, z2]
		
		val c2 = v2.SUM_LE(1100)
		solver >> c2
		
		val IntVar[] v3 = #[x1, x2]
		val c3 = v3.SUM_EQ(1000)
		solver >> c3
		
		val IntVar[] v4 = #[y1, y2]
		val c4 = v4.SUM_EQ(1200)
		solver >> c4
		
		val IntVar[] v5 = #[z1, z2]
		val c5 = v5.SUM_EQ(1100)
		solver >> c5
		
		// x --> y edge
		val IntVar e1 = VariableHelper.bounded("E1", 0, 5, solver);
		val IntVar[] e11 = #[x1, y1]
		val c11 = e11.SUM_L(2200)
		val c13 = e11.SUM_EQ(2200)
		
		solver >> (c11 => (e1 -> 5))
		solver >> (c13 => (e1 -> 0))
		
		val IntVar[] e12 = #[x2, y2]
		val c12 = e12.SUM_L(2200)
		val c14 = e12.SUM_EQ(2200)
		
		//solver >> (c12 => (e1 -> 5))
		//solver >> (c14 => (e1 -> 0))
		
		
		// z --> y edge
		val IntVar e2 = VariableHelper.bounded("E2", 0, 10, solver);
		val IntVar[] e21 = #[z1, y1]
		val c21 = e21.SUM_L(2300)
		val c23 = e21.SUM_EQ(2300)
		
		solver >> (c21 => (e2 -> 10))
		solver >> (c23 => (e2 -> 0))
		
		val IntVar[] cost = #[e1, e2]
		val opt = cost.SUM_MIN
		
		
		
		val List<IntVar> listForSolver = Lists.newArrayList();
		listForSolver.addAll(#[x1, y1, z1, x2, y2, z2]);

		var DecisionBuilder db = solver.makePhase(listForSolver,
                                       Solver::CHOOSE_FIRST_UNBOUND,
                                       Solver::ASSIGN_MIN_VALUE);
		
		solver.newSearch(db);
		
		while (solver.nextSolution()) {
			System.out.println("x1:" + x1.value + " y1:" + y1.value + " z1:" + z1.value);
			System.out.println("x2:" + x2.value + " y2:" + y2.value + " z2:" + z2.value);
			System.out.println("c11:" + c11.^var.value + " c12:" + c12.^var.value + " c21:" + c21.^var.value);
			println(e1.value + "    " + e2.value)
			//System.out.println("e1:" + e1.value + " e2:" + e2.value + " cost:" + opt.^var.value);
			println
		}
		
		solver.endSearch();
	}
	
}