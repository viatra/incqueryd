package hu.bme.mit.incqueryd.rete.nodes;

import hu.bme.mit.incqueryd.arch.ArchUtil;
import hu.bme.mit.incqueryd.databases.FourStoreClient;
import hu.bme.mit.incqueryd.rete.dataunits.ChangeSet;
import hu.bme.mit.incqueryd.rete.dataunits.ChangeType;
import hu.bme.mit.incqueryd.rete.dataunits.GraphElement;
import hu.bme.mit.incqueryd.rete.dataunits.Tuple;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.eclipse.incquery.runtime.rete.recipes.UniquenessEnforcerRecipe;

import com.google.common.collect.Multimap;

public class InputNode extends ReteNode {

	protected final String type;
	protected boolean hasAttribute = false;
	protected String attribute;
	protected final GraphElement graphElement;

	InputNode(final UniquenessEnforcerRecipe recipe) {
		super();

		final String traceInfo = recipe.getTraceInfo();
		if (traceInfo.startsWith("UniquenessEnforcerNode#vertex")) {
			graphElement = GraphElement.NODE;

			if (ArchUtil.hasAttribute(traceInfo)) {
				hasAttribute = true;
				attribute = ArchUtil.extractAttribute(traceInfo);
			}
		} else {
			graphElement = GraphElement.EDGE;
		}
		type = ArchUtil.extractType(recipe.getTraceInfo());
	}

	public String getType() {
		return type;
	}

	public GraphElement getGraphElement() {
		return graphElement;
	}

	public ChangeSet initialize() throws IOException {
		Set<Tuple> tuples = null;

		switch (graphElement) {
		case EDGE:
			tuples = initializeForEdges();
			break;
		case NODE:
			tuples = initializeForNodes();
			break;
		default:
			break;
		}

		final ChangeSet changeSet = new ChangeSet(tuples, ChangeType.POSITIVE);
		return changeSet;
	}

	private Set<Tuple> initializeForNodes() throws IOException {
		final FourStoreClient client = new FourStoreClient();

		final Set<Tuple> tuples = new HashSet<>();
		if (hasAttribute) {
			final Map<Long, Integer> verticesWithProperty = client.collectVerticesWithProperty(attribute);
			for (final Entry<Long, Integer> vertexWithProperty : verticesWithProperty.entrySet()) {
				final Tuple tuple = new Tuple(vertexWithProperty.getKey(), vertexWithProperty.getValue());
				tuples.add(tuple);
			}

		} else {
			final List<Long> vertices = client.collectVertices(type);
			for (final Long vertex : vertices) {
				final Tuple tuple = new Tuple(vertex);
				tuples.add(tuple);
			}
		}

		return tuples;
	}

	private Set<Tuple> initializeForEdges() throws IOException {
		final FourStoreClient client = new FourStoreClient();
		final Multimap<Long, Long> edges = client.collectEdges(type);

		final Set<Tuple> tuples = new HashSet<>();
		for (final Map.Entry<Long, Long> entry : edges.entries()) {
			final Tuple tuple = new Tuple(entry.getKey(), entry.getValue());
			tuples.add(tuple);
		}
		return tuples;
	}
	
	

	// @Override
	// public ChangeSet update(final ChangeSet incomingChangeSet) {
	// final EList<Integer> indices = recipe.getIndices();
	//
	// final Set<Tuple> incomingTuples = incomingChangeSet.getTuples();
	// Set<Tuple> resultTuples;
	//
	// if (indices.size() <= 1) {
	// // nothing to compare
	// resultTuples = incomingTuples;
	// } else {
	// resultTuples = new HashSet<Tuple>();
	//
	// for (final Tuple tuple : incomingTuples) {
	// if (checkCondition(tuple, indices)) {
	// resultTuples.add(tuple);
	// }
	// }
	// }
	// final ChangeSet resultChangeSet = new ChangeSet(resultTuples, incomingChangeSet.getChangeType());
	//
	// return resultChangeSet;
	// }

}
