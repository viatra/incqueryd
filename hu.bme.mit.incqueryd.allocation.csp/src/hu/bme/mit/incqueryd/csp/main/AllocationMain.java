package hu.bme.mit.incqueryd.csp.main;

import hu.bme.mit.incqueryd.csp.stats.StatsUtil;
import hu.bme.mit.incqueryd.csp.util.AllocationOptimizer;

import java.io.IOException;
import java.util.Map;

import org.apache.commons.cli.ParseException;

public class AllocationMain {
	
	public static void main(String[] args) throws IOException, ParseException {
		System.loadLibrary("jniortools");
		AllocationConfiguration allocationConfiguration = new AllocationConfiguration(args);
		
		Map<String, Long> stats = StatsUtil.loadStats(allocationConfiguration.getStats());
		System.out.println(stats);
		
		
		AllocationOptimizer allocator = new AllocationOptimizer(allocationConfiguration.isOptimizeForCost(), allocationConfiguration.getRecipe(), allocationConfiguration.getInventory(), allocationConfiguration.getArchitecture(), stats);
		if (allocator.allocate()) {
			System.out.println("Your arch file is ready");
		} else {
			System.out.println("The problem can not be solved with the current resource set!");
		}
	}

}
