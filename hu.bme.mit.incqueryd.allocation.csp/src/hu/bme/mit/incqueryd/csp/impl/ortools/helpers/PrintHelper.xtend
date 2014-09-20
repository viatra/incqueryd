package hu.bme.mit.incqueryd.csp.impl.ortools.helpers

import java.util.List
import com.google.ortools.constraintsolver.IntVar

class PrintHelper {
	def static printFancyMatrix(IntVar[][] m, int cols1, int cols2, String col1Title, String col2Title, String rowTitle) {
		println("Function allocations:");

		print("        ")
		val spaces = (cols2 + cols1).ensureMaxSpace;
		for (i : 1 ..< cols2 + cols1 + 1) {
			var spacesHeader = spaces.cut(i)
			if (i <= cols1)
				print(col1Title + i + spacesHeader)
			else
				print(col2Title + (i-cols1) + spacesHeader)
		}
		println()
		var int i = 0
		for (row : m) {
			print(rowTitle + i + i.ensurePlusSpace + "| ")
			for (e : row) {
				print(e.value + spaces);
			}
			println();
			i = i + 1;
		}
		println()
	}

	def static cut(String s, Integer i) {
		if (i < 10)
			s.substring(0, s.length - 1)
		else if (i < 100)
			s.substring(0, s.length - 2)
		else
			s.substring(0, s.length - 3)
	}

	def static ensurePlusSpace(int num) {
		if (num < 10)
			return "    "
		else if (num < 100)
			return "   "
		else
			return "  "
	}

	def static ensureMaxSpace(int num) {
		if (num < 10)
			return "   "
		else if (num < 100)
			return "     "
		else
			return "       "
	}

	def static ensureSpaceHeader(int num) {
		if (num < 10)
			return "    "
		else if (num < 100)
			return "   "
		else
			return "  "
	}
	
	
	 ////////
	//Array
	def static printFancyArray(List<IntVar> arr, String label){
		arr.forEach[e,i | 
					println(label+"["+i+"]"+ " = " + e.value());
		]
	}
	
}
