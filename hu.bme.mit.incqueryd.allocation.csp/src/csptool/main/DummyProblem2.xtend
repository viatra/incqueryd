package csptool.main

import com.google.ortools.constraintsolver.Solver

import static extension hu.bme.mit.incqueryd.csp.impl.ortools.extensions.ConstraintExtension.*
import com.google.ortools.constraintsolver.IntVar
import java.util.List
import com.google.common.collect.Lists
import com.google.ortools.constraintsolver.DecisionBuilder
import hu.bme.mit.incqueryd.csp.impl.ortools.helpers.VariableHelper

class DummyProblem2 {
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
		val IntVar[] e111 = #[x1, y1]
		val c11 = e111.SUM_GE(2200)
		
		solver >> (c11 => (e1 -> 0))
		
		// x1, y2
		val IntVar[] e112 = #[x1, y2]
		val c112 = e112.SUM_GE(2200)
		solver >> (c112 => (e1 -> 5))
		
		// x2, y1
		val IntVar[] e121 = #[x2, y1]
		val c121 = e121.SUM_GE(2200)
		solver >> (c121 => (e1 -> 5))
		
		// x2, y2
		val IntVar[] e122 = #[x2, y2]
		val c122 = e122.SUM_GE(2200)
		solver >> (c122 => (e1 -> 0))
		
		
		// z --> y edge
		val IntVar e2 = VariableHelper.bounded("E2", 0, 10, solver);
		
		// z1, y1
		val IntVar[] e211 = #[z1, y1]
		val c211 = e211.SUM_GE(2300)
		solver >> (c211 => (e2 -> 0))
		
		//z1, y2
		val IntVar[] e212 = #[z1, y2]
		val c212 = e212.SUM_GE(2300)
		solver >> (c212 => (e2 -> 10))
		
		//z2, y1
		val IntVar[] e221 = #[z2, y1]
		val c221 = e221.SUM_GE(2300)
		solver >> (c221 => (e2 -> 10))
		
		// z2, y2
		val IntVar[] e222 = #[z2, y2]
		val c222 = e222.SUM_GE(2300)
		solver >> (c222 => (e2 -> 0))
		
		
		// opt: min {e1 + e2}
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
			//System.out.println("c11:" + c11.^var.value + " c112:" + c112.^var.value + " c121:" + c121.^var.value + " c211:" + c211.^var.value);
			System.out.println("e1:" + e1.value + " e2:" + e2.value + " cost:" + opt.^var.value);
			println
		}
		
		solver.endSearch();
	}
	
}