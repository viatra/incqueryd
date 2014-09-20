package hu.bme.mit.incqueryd.csp.impl.choco.extensions

import solver.Solver
import solver.constraints.Constraint
import solver.constraints.IntConstraintFactory
import solver.constraints.LogicalConstraintFactory
import solver.variables.IntVar
import solver.variables.VariableFactory
import hu.bme.mit.incqueryd.csp.impl.choco.helpers.VariableHelper
import java.util.List

class ConstraintExtension  {
	
	def static isNull(Constraint a) {
		try{
			a.getPropagators()
		}catch(NullPointerException e){
			return true;
		}
		return false;
	}
	
	/**
	 * IntVar Operators
	 * 
	 */
	
	// IntVar == scalar
	def static operator_equals(IntVar a, Integer scalar) {
		return IntConstraintFactory.arithm(a, "=", scalar)
	}
	
	// IntVar != scalar
	def static operator_notEquals(IntVar a, Integer scalar) {
		return IntConstraintFactory.arithm(a, "!=", scalar)
	}
	
	
	// IntVar = IntVar
	def static operator_equals(IntVar a, IntVar b) {
		return IntConstraintFactory.arithm(a, "=", b)
	}
	
	// IntVar != IntVar
	def static operator_notEquals(IntVar a, IntVar b) {
		return IntConstraintFactory.arithm(a, "!=", b)
	}
	
	
	
	/**
	 * Constraints Operators
	 * 
	 */
	
	// arithmConstraint || arithmConstraint
	def static operator_or(Constraint a, Constraint b) {
		return LogicalConstraintFactory.or(a,b);
	}
	
	// arithmConstraint && arithmConstraint
	def static operator_and(Constraint a, Constraint b) {
		return LogicalConstraintFactory.and(a,b);
	}
	
	// solver >> c
	def static operator_doubleGreaterThan(Solver s, Constraint c){
		if(c != null)
			s.post(c)
	}
	
	// if then
	def static operator_mappedTo(Constraint a, Constraint b){
		if(a != null && b != null)
			LogicalConstraintFactory.ifThen(a, b);
	}

	// Constraint OR Constraint OR ...
	def static OR(Iterable<Constraint> cs) {
		if(cs.size > 1)
			return LogicalConstraintFactory.or(cs)
		else
			return cs.head;
	}
	
	// Constraint AND Constraint AND ...
	def static AND(Iterable<Constraint> cs) {
		if(cs.size > 1)
			return LogicalConstraintFactory.and(cs)
		else
			return cs.head;
	}
	
	
	def static SUM_EQ(IntVar[] row, IntVar sumVar, Solver solver){
		return IntConstraintFactory.sum(row, sumVar);
	}
	
	def static SUM_EQ(IntVar[] row, int scalar, Solver solver){
		return IntConstraintFactory.sum(row, VariableFactory.fixed(scalar, solver));
	}
	
	def static SUM_LE(Iterable<IntVar> row, int scalar, Solver solver){
		return IntConstraintFactory.sum(row, "<=", VariableFactory.fixed(scalar, solver));
	}
	
	def static SUM_LE(Iterable<IntVar> row, IntVar sum){
		return IntConstraintFactory.sum(row, "<=", sum);
	}
	
	def static SUM_GE(Iterable<IntVar> row, int scalar, Solver solver){
		return IntConstraintFactory.sum(row, ">=", VariableFactory.fixed(scalar, solver));
	}
	
	
	def static occures(int value, List<IntVar> vars, int limitLower, int limitUpper, Solver solver){
		return IntConstraintFactory.count(value, vars, VariableHelper.bounded(value+"_imaCap", limitLower, limitUpper, solver));
	}
	
	def static allDiff(List<IntVar> vars){
		return IntConstraintFactory.alldifferent(vars, "BC");
	}
	
	
	def static ifThenElse(Constraint iif, Constraint then, Constraint elsee){
		return  LogicalConstraintFactory.ifThenElse(iif, then, elsee);
	}
	
	
	def static count(int VALUE, IntVar[] VARS, IntVar LIMIT){
		return IntConstraintFactory.count(VALUE, VARS, LIMIT);
	}
}
