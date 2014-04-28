package hu.bme.mit.incqueryd.arch;

import hu.bme.mit.incqueryd.util.RecipeSerializer;
import infrastructure.Cluster;
import infrastructure.Machine;

import java.io.IOException;

import org.eclipse.emf.common.util.EList;
import org.junit.Test;

import arch.Configuration;

public class ExtractMachineTest {

	@Test
	public void testMachine() throws IOException {
		final String architectureFile = "src/test/resources/arch/routesensor.arch";
		final Configuration conf = ArchUtil.loadConfiguration(architectureFile);	
		
		final Cluster cluster = conf.getClusters().get(0);
		final EList<Machine> reteMachines = cluster.getReteMachines();
				
		final String clusterJSON = RecipeSerializer.serializeToString(cluster);
		System.out.println(clusterJSON);
	}
	
}
