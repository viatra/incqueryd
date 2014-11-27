/*******************************************************************************
 * Copyright (c) 2010-2014, Gabor Szarnyas, Istvan Rath and Daniel Varro
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * Gabor Szarnyas - initial API and implementation
 *******************************************************************************/
package hu.bme.mit.incqueryd.engine.arch;

import hu.bme.mit.incqueryd.arch.util.ArchUtil;
import infrastructure.Machine;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import arch.Configuration;
import arch.InfrastructureMapping;

public class ExtractMachineTest {

	@Test
	public void testMachine() throws IOException {
		final File architectureFile = new File("src/test/resources/arch/poslength.arch");
		final Configuration conf = ArchUtil.loadConfiguration(architectureFile);

		final List<Machine> machines = new ArrayList<>();
		for (final InfrastructureMapping mapping : conf.getMappings()) {
			machines.add(mapping.getProcess().getMachine());
		}
	}

}