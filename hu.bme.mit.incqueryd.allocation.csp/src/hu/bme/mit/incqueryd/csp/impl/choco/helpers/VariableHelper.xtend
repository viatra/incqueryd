package hu.bme.mit.incqueryd.csp.impl.choco.helpers

import solver.Solver
import solver.variables.VariableFactory
import java.util.List
import solver.variables.IntVar

class VariableHelper {
	
	def static matrix(String name, int row, int col, Solver solver){
		return VariableFactory.boolMatrix(name, row, col, solver)
	}
	
	def static bounded(String name, int lower, int upper, Solver solver){
		 return VariableFactory.bounded(name, lower, upper, solver);
	}
	
	def static boundedArray(String name, int size, int lower, int upper, int numberingFrom, Solver solver){
		 //return VariableFactory.boundedArray(name, size, lower, upper, solver);
        var IntVar[] vars = newArrayOfSize(size);
        var num = numberingFrom;
        for ( i : 0 ..< size) {
            vars.set(i, bounded(name + "[" + num + "]", lower, upper, solver)) ;
            num = num + 1;
        }
        return vars;
	}
	
	def static boundedArray(String name, int size, List<Integer> lowers, List<Integer> uppers, Solver solver){
		if(lowers.size != size || uppers.size != size){
			throw new UnsupportedOperationException("Different sizes")
		}
        var IntVar[] vars = newArrayOfSize(size);
        var num = 0;
        for ( i : 0 ..< size) {
            vars.set(i, bounded(name + "[" + num + "]", lowers.get(i), uppers.get(i), solver)) ;
            num = num + 1;
        }
        return vars;
	}
	
	def static boundedArrayWithSections(String name, int size, List<Integer> sizes,List<Integer> lowers, List<Integer> uppers, Solver solver){
		
		var IntVar[] vars = newArrayOfSize(size);
		var prev = 0;
        for (i : 0 ..< sizes.size) {
        	if(sizes.get(i) != 0){
        		val IntVar[] ar = boundedArray(name, sizes.get(i), lowers.get(i), uppers.get(i), prev, solver)
	            if(i == 0){
	            	System.arraycopy(ar, 0, vars, 0, ar.length);
	            	prev = ar.length;
	            }else{
	            	System.arraycopy(ar, 0, vars, prev, ar.length);
	            	prev = prev + ar.length;
	            }
        	}           
        }
        return vars;
	}
	
	def static booledArray(String name, int size, Solver solver){
		 return VariableFactory.boolArray(name, size, solver);
	}
	
	def static fix(String name, int value, Solver solver){
		 return VariableFactory.fixed(name, value, solver)
	}
	
	def static scale(IntVar VAR, int CSTE){
		return VariableFactory.scale(VAR, CSTE);
	}

	def static minus(IntVar VAR){
		return VariableFactory.minus(VAR);
	}
	
	def static offset(IntVar VAR, int CSTE){
		return VariableFactory.offset(VAR, CSTE);
	}
	
	
}