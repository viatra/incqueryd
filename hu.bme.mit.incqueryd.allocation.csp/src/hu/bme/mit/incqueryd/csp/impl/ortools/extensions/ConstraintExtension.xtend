package hu.bme.mit.incqueryd.csp.impl.ortools.extensions

import com.google.ortools.constraintsolver.Constraint
import com.google.ortools.constraintsolver.IntVar
import com.google.ortools.constraintsolver.Solver
import java.util.List

class ConstraintExtension  {
	
	static Solver solver;
	
	new(Solver s) {
		solver = s;
	}
	
	def static makeDefaultSolver(Solver s){
		solver = s;
	}
	
	/**
	 * IntVar Operators
	 * 
	 */
	
	// IntVar == scalar
	def static operator_equals(IntVar a, Integer scalar) {
		return solver.makeEquality(a, scalar)
	}
	
	def static operator_equals(IntVar a, long scalar) {
		return solver.makeEquality(a, scalar)
	}
	
	// IntVar != scalar
	def static operator_notEquals(IntVar a, Integer scalar) {
		return solver.makeNonEquality(a, scalar)
	}
	
	
	// IntVar = IntVar
	def static operator_equals(IntVar a, IntVar b) {
		return solver.makeEquality(a, b)
	}
	
	// IntVar != IntVar
	def static operator_notEquals(IntVar a, IntVar b) {
		return solver.makeNonEquality(a, b)
	}
	
	//IntVar > scalar
	def static operator_greaterThan(IntVar a, int value){
		return solver.makeGreater(a, value)
	}
	
	def static isNull(IntVar a) {
		try{
			a.baseName
		}catch(NullPointerException e){
			return true;
		}
		return false;
		
	}
	
	
	
	/**
	 * Constraints Operators
	 * 
	 */
	
	// arithmConstraint || arithmConstraint
	def static operator_or(Constraint a, Constraint b) {
		return solver.makeMax(a.^var,b.^var);
	}
	
	// arithmConstraint && arithmConstraint
	def static operator_and(Constraint a, Constraint b) {
		return solver.makeMin(a.^var,b.^var);
	}
	
	// solver >> c
	def static operator_doubleGreaterThan(Solver s, Constraint c){
		solver.addConstraint(c);
	}
	
	// if then, Implication
	def static operator_mappedTo(Constraint a, IntVar b){
		if(!isNull(a.^var) && !isNull(b))
			solver.makeLessOrEqual(a.^var,b);
	}
	
	// if then, Implication
	def static operator_doubleArrow(Constraint a, Pair<IntVar, Integer> pair){
		return solver.makeLessOrEqual(a.^var, solver.makeEquality(pair.key, pair.value.intValue).^var);
	}

	// Constraint OR Constraint OR ...
	def static OR(Iterable<Constraint> cs) {
		if(cs.size > 1){
			var List<IntVar> a = newArrayList();
			for(c : cs){
				a.add(c.^var);
			}
			solver.makeMax(a);
		}
		else{
			return cs.head;
		}
	}
	
	// Constraint AND Constraint AND ...
	def static AND(Iterable<IntVar> cs) {
		if(cs.size > 1){
			var List<IntVar> a = newArrayList();
			for(c : cs){
				a.add(c.^var());
			}
			solver.makeMin(a).^var();
		}
		else{
			return cs.head;
		}
	}
	
	
	def static SUM_EQ(IntVar[] row, IntVar sumVar){
//		 var IntVar a1 = solver.makeIsMemberVar(sumVar, #[0,2,4]);
//		 var Constraint eq = solver.makeEquality(sumVar, 1);
//		 var IntExpr ands= solver.makeMin( #[a1]).^var(); // AND
//		solver.makeLessOrEqual(eq.^var, ands); // Implication
		return solver.makeSumEquality(row, sumVar);
	}
	
	def static SUM_EQ(IntVar[] row, int scalar){
		return solver.makeSumEquality(row, scalar);
	}
	
	def static SUM_LE(Iterable<IntVar> row, int scalar){
		return solver.makeSumLessOrEqual(row, scalar);
	}
	
	def static SUM_LE(IntVar[] row, IntVar limit){
		var IntVar sumOfRow = solver.makeSum(row).^var();
		return solver.makeLessOrEqual(sumOfRow, limit)
	}
	
	def static SUM_L(IntVar[] row, int limit){
		var IntVar sumOfRow = solver.makeSum(row).^var();
		return solver.makeLess(sumOfRow, limit)
	}
	
	def static SUM_L(IntVar[] row, IntVar limit){
		var IntVar sumOfRow = solver.makeSum(row).^var();
		return solver.makeLess(sumOfRow, limit)
	}
	
	def static SUM_GE(IntVar[] row, int scalar){
		return solver.makeSumGreaterOrEqual(row, scalar);
	}
	
	def static SUM_GE(Iterable<IntVar> row, int scalar){
		return solver.makeSumGreaterOrEqual(row, scalar);
	}
	
	def static SUM_MIN(IntVar[] row){
		var IntVar sumOfRow = solver.makeSum(row).^var()
		return solver.makeMinimize(sumOfRow, 1)
	}
	
	def static SUM_MIN(List<IntVar> vars){
		var IntVar sumOfRow = solver.makeSum(vars).^var()
		return solver.makeMinimize(sumOfRow, 1)
	}
	
	def static SUM_MAX(IntVar[] row){
		var IntVar sumOfRow = solver.makeSum(row).^var()
		return solver.makeMaximize(sumOfRow, 1)
	}
	
	def static SUM_MAX(List<IntVar> vars){
		var IntVar sumOfRow = solver.makeSum(vars).^var()
		return solver.makeMaximize(sumOfRow, 1)
	}
	
	def static SUM(List<IntVar> vars){
		return solver.makeSum(vars)
	}
	
	def static occures(int value, List<IntVar> vars, int limitLower, int limitUpper){
		return solver.makeCount(vars, value,solver.makeIntVar(limitLower, limitUpper));
	}
		
	
	
}
