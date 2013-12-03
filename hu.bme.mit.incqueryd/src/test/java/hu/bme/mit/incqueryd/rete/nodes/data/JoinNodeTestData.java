package hu.bme.mit.incqueryd.rete.nodes.data;

import hu.bme.mit.incqueryd.rete.dataunits.ChangeSet;
import hu.bme.mit.incqueryd.rete.dataunits.Tuple;
import hu.bme.mit.incqueryd.rete.dataunits.TupleMask;

import java.util.Set;

/**
 * 
 * @author szarnyasg
 *
 */
public class JoinNodeTestData {

	protected Set<Tuple> primaryTuples;
	protected Set<Tuple> secondaryTuples;
	protected TupleMask primaryMask;
	protected TupleMask secondaryMask;

	protected ChangeSet antiJoinExpectedResults;
	protected ChangeSet joinExpectedResults;

	public JoinNodeTestData(final Set<Tuple> primaryTuples, final Set<Tuple> secondaryTuples, final TupleMask primaryMask,
			final TupleMask secondaryMask, final ChangeSet expectedResults, final ChangeSet antiJoinExpectedResults) {
		super();
		this.primaryTuples = primaryTuples;
		this.secondaryTuples = secondaryTuples;
		this.primaryMask = primaryMask;
		this.secondaryMask = secondaryMask;
		this.antiJoinExpectedResults = antiJoinExpectedResults;
		this.joinExpectedResults = expectedResults;
	}

	public Set<Tuple> getPrimaryTuples() {
		return primaryTuples;
	}

	public Set<Tuple> getSecondaryTuples() {
		return secondaryTuples;
	}

	public TupleMask getPrimaryMask() {
		return primaryMask;
	}

	public TupleMask getSecondaryMask() {
		return secondaryMask;
	}

	public ChangeSet getAntiJoinExpectedResults() {
		return antiJoinExpectedResults;
	}
	
	public ChangeSet getJoinExpectedResults() {
		return joinExpectedResults;
	}

}
