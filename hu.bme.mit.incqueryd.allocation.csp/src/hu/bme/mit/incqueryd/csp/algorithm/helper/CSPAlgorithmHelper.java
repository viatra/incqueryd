package hu.bme.mit.incqueryd.csp.algorithm.helper;


public class CSPAlgorithmHelper {
	
	public static int[][] createOverheadMatrixForSolver(int containerTemplatesSize, int containersSize, int[][] overheads, Integer[] containerAmounts){
		int[][] containerOverheads = new int[containersSize][containersSize];
		
		int columnCounter = 0;
		int rowCounter = 0;
		
		for (int j = 0; j < containerAmounts.length; j++) {
			int[] containerOverhead = overheads[j]; // overheads of one machine
			int amount = containerAmounts[j]; // how many we use of this machine
												// type
			for (int l = 0; l < amount; l++) {

				for (int k = 0; k < containerAmounts.length; k++) {
					int amount2 = containerAmounts[k];
					int overhead = containerOverhead[k];
					for (int m = 0; m < amount2; m++) {
						containerOverheads[rowCounter][columnCounter] = overhead;
						columnCounter++;
					}
				}
				columnCounter = 0;
				rowCounter++;
			}
		}

		for(int i = 0; i < containerOverheads.length; i++){
			int[] js = containerOverheads[i];
			for(int j = 0; j < js.length; j++){
				System.out.print(js[j] + ", ");
			}
			System.out.println();
		}
		
		return containerOverheads;
	}

}
