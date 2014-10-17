package hu.bme.mit.incqueryd.csp.main;

import hu.bme.mit.incqueryd.arch.util.ArchUtil;
import hu.bme.mit.incqueryd.csp.stats.StatsUtil;
import hu.bme.mit.incqueryd.csp.util.data.ReteNet;

import java.io.IOException;
import java.util.Map;

import org.apache.commons.cli.ParseException;
import org.eclipse.incquery.runtime.rete.recipes.ReteRecipe;

public class AllocationMain {
	
	public static void main(String[] args) throws IOException, ParseException {
		System.loadLibrary("jniortools");
		AllocationConfiguration allocationConfiguration = new AllocationConfiguration(args);
		
		Map<String, Long> stats = StatsUtil.loadStats(allocationConfiguration.getStats());
		System.out.println(stats);
		
		ReteRecipe recipe = ArchUtil.loadRecipe(allocationConfiguration.getRecipe());
		ReteNet net = new ReteNet(recipe, stats);
		net.create();
		
//		ReteAllocator allocator = new ReteAllocator(allocationConfiguration.isOptimizeForCost(), allocationConfiguration.getRecipe(), allocationConfiguration.getInventory(), allocationConfiguration.getArchitecture());
//		if (allocator.allocate()) {
//			System.out.println("Your arch file is ready");
//		} else {
//			System.out.println("The problem can not be solved with the current resource set!");
//		}
	}

}
