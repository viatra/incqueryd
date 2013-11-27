package hu.bme.mit.incqueryd.main;

import java.util.ArrayList;
import java.util.Collection;

import com.google.common.collect.ImmutableList;

import hu.bme.mit.incqueryd.rete.dataunits.ChangeSet;
import hu.bme.mit.incqueryd.rete.dataunits.ChangeType;
import hu.bme.mit.incqueryd.rete.dataunits.JoinSide;
import hu.bme.mit.incqueryd.rete.dataunits.Tuple;
import hu.bme.mit.incqueryd.rete.dataunits.TupleImpl;
import hu.bme.mit.incqueryd.rete.dataunits.TupleMask;
import hu.bme.mit.incqueryd.rete.nodes.JoinNode;

public class Main {
	public static void main(String[] args) {
		System.out.println("IncQuery-D main");
		
		TupleMask leftMask = new TupleMask(ImmutableList.of(2));
		TupleMask rightMask = new TupleMask(ImmutableList.of(0));
		
		JoinNode joinNode = new JoinNode(leftMask, rightMask);
		
		Collection<Tuple> leftTuples = new ArrayList<>();
		leftTuples.add(new TupleImpl(5, 6, 7));
		leftTuples.add(new TupleImpl(10, 11, 7));
		
		Collection<Tuple> rightTuples = new ArrayList<>();
		rightTuples.add(new TupleImpl(7, 8));
		
		ChangeSet leftChangeSet = new ChangeSet(leftTuples, ChangeType.POSITIVE);
		ChangeSet rightChangeSet = new ChangeSet(rightTuples, ChangeType.POSITIVE);
		
		joinNode.joinNewTuples(leftChangeSet, JoinSide.PRIMARY);
		ChangeSet joinedTuples = joinNode.joinNewTuples(rightChangeSet, JoinSide.SECONDARY);
		
		System.out.println(joinedTuples.getTuples());
		

		
	}
}
