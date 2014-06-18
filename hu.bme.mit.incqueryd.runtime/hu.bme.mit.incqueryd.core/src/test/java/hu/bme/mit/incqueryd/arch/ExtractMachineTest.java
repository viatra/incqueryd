package hu.bme.mit.incqueryd.arch;

import infrastructure.Machine;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import arch.Configuration;
import arch.InfrastructureMapping;

public class ExtractMachineTest {

	@Test
	public void testMachine() throws IOException {
		final String architectureFile = "src/test/resources/arch/posLength.arch";
		final Configuration conf = ArchUtil.loadConfiguration(architectureFile);

		final List<Machine> machines = new ArrayList<>();
		for (InfrastructureMapping mapping : conf.getMappings()) {
			machines.add(mapping.getMachine());
		}
	}

}