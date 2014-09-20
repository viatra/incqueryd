package hu.bme.mit.incqueryd.csp.impl.choco.extensions

import solver.variables.IntVar
import java.util.List
import java.util.ArrayList

class MultiDimensionArrayExtensions { // Helpers
	def static cell(IntVar [][] m, int i, int j) {
		if (m.length >= i) {
			val IntVar[] a = (m.get(i) as IntVar[]);
			if (a.length >= j) {
				return a.get(j) as IntVar;
			} ;
	} return null;
	}

	def static col(IntVar [][] m, int j) {
		var List<IntVar> cols = new ArrayList;

		//for (i : 0 ..< F_SIZE) {
		for (i : 0 ..< m.length) {
			var IntVar a = (m.get(i) as IntVar[]).get(j) as IntVar;
			cols.add(a);
		}

		return cols
	}
}
