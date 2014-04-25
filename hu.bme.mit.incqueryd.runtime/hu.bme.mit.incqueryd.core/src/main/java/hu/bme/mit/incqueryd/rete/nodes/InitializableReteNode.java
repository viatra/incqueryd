package hu.bme.mit.incqueryd.rete.nodes;

import hu.bme.mit.incqueryd.rete.dataunits.ChangeSet;

import java.io.IOException;

public interface InitializableReteNode {
	public ChangeSet initialize() throws IOException;
}
