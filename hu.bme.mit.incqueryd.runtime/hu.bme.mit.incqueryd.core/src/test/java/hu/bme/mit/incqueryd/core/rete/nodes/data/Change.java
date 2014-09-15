package hu.bme.mit.incqueryd.core.rete.nodes.data;

import hu.bme.mit.incqueryd.core.rete.dataunits.ChangeSet;
import hu.bme.mit.incqueryd.core.rete.dataunits.ReteNodeSlot;

/**
 * 
 * @author makaij
 *
 */
public class Change {

	protected ChangeSet changeSet;
	protected ReteNodeSlot changeSlot;
	
	public Change(final ChangeSet changeSet, final ReteNodeSlot changeSlot) {
		super();
		this.changeSet = changeSet;
		this.changeSlot = changeSlot;
	}
	
	public ChangeSet getChangeSet() {
		return changeSet;
	}
	
	public ReteNodeSlot getChangeSlot() {
		return changeSlot;
	}
	
}
