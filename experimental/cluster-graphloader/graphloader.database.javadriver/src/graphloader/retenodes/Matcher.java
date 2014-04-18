package graphloader.retenodes;

import graphloader.propertygraph.PropertyGraphElement;

public class Matcher {

	public static boolean match(PropertyGraphElement[] tuple1, PropertyGraphElement[] tuple2, int[] pattern1, int[] pattern2) {
		if (tuple1.length != tuple2.length) {
			return false;
		}

		boolean identical = true;
		for (int i = 0; i < pattern1.length; i++) {
			int indexForGods = pattern1[i];
			int indexForLocations = pattern2[i];

			if (!tuple1[indexForGods].isIdentical(tuple2[indexForLocations])) {
				identical = false;
			}
		}
		return identical;
	}

	public static PropertyGraphElement[] join(PropertyGraphElement[] tuple1, PropertyGraphElement[] tuple2, int[] pattern1, int[] pattern2) {
		int size = tuple1.length + tuple2.length - pattern2.length;
		PropertyGraphElement[] joinedTuple = new PropertyGraphElement[size];
		
		for (int i = 0; i < tuple1.length; i++) {
			joinedTuple[i] = tuple1[i];
		}
		
		int j = 0;
		int k = 0;
		for (int i = 0; i < tuple2.length; i++) {
			if (pattern2[k] == i) {
				// skip duplicate attributes
				k++; // step to the next index in the pattern2
			} else {
				joinedTuple[tuple1.length + j] = tuple2[i];
			}
			j++; // step to the next item in tuple2
		}		
		
		return joinedTuple;	
	}
	
	public static String tupleToString(PropertyGraphElement[] tuple) {
		String string = "";
		for (PropertyGraphElement propertyGraphElement : tuple) {
			string += propertyGraphElement + " ";
		}
		
		return string;
	}
}
