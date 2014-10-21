package hu.bme.mit.incqueryd.csp.util.heuristics;

public class HeuristicsHelper {
	
	public static int getEstimatedMemoryUsage(long normalizedTupleIn, long normalizedTupleOut) {
		double memorySize = 0.0003 * normalizedTupleIn + 52.969;
		//memorySize += (0.0003 * normalizedTupleOut);
		int memory = Math.max(128, ((int) Math.ceil(memorySize * 1.4)));
		return memory;
	}

}
