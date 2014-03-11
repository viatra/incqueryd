package hu.bme.mit.incqueryd.rete.nodes;

import hu.bme.mit.incqueryd.arch.ArchUtil;
import hu.bme.mit.incqueryd.databases.FourStoreClient;
import hu.bme.mit.incqueryd.rete.dataunits.ChangeSet;
import hu.bme.mit.incqueryd.rete.dataunits.ChangeType;
import hu.bme.mit.incqueryd.rete.dataunits.GraphElement;
import hu.bme.mit.incqueryd.rete.dataunits.Tuple;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.incquery.runtime.rete.recipes.UniquenessEnforcerRecipe;

import com.google.common.collect.Multimap;

public class InputNode extends ReteNode {

	protected final String type;
    protected final GraphElement graphElement;
    protected Multimap<Long, Long> edges; 
    
    InputNode(final UniquenessEnforcerRecipe recipe) {
        super();
        type = ArchUtil.extractType(recipe.getTraceInfo());
        graphElement = GraphElement.EDGE;
    }

    public String getType() {
        return type;
    }
    
    /**
     * only for testing purposes
     * @return
     */
    public Multimap<Long, Long> getEdges() {
		return edges;
	}
    
    public GraphElement getGraphElement() {
		return graphElement;
	}
    
    public ChangeSet initialize() throws IOException {
    	final Set<Tuple> tuples = new HashSet<>();
    	
    	final FourStoreClient client = new FourStoreClient();
    	edges = client.collectEdges(type);
    	
		final ChangeSet changeSet = new ChangeSet(tuples, ChangeType.POSITIVE);
		return changeSet;
    }
    
//	@Override
//	public ChangeSet update(final ChangeSet incomingChangeSet) {
//		final EList<Integer> indices = recipe.getIndices();
//
//		final Set<Tuple> incomingTuples = incomingChangeSet.getTuples();
//		Set<Tuple> resultTuples;
//
//		if (indices.size() <= 1) {
//			// nothing to compare
//			resultTuples = incomingTuples;
//		} else {
//			resultTuples = new HashSet<Tuple>();
//
//			for (final Tuple tuple : incomingTuples) {
//				if (checkCondition(tuple, indices)) {
//					resultTuples.add(tuple);
//				}
//			}
//		}
//		final ChangeSet resultChangeSet = new ChangeSet(resultTuples, incomingChangeSet.getChangeType());
//
//		return resultChangeSet;
//	}


}
