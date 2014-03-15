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

public class InputNode extends ReteNode implements InitializableReteNode {

	protected final String type;
	protected boolean hasAttribute = false;
	protected String attribute;
	protected final GraphElement graphElement;
	protected final Set<Tuple> tuples = new HashSet<>();

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

	@Override
	public ChangeSet initialize() throws IOException {
		switch (graphElement) {
		case EDGE:
			initializeForEdges();
			break;
		case NODE:
			initializeForNodes();
			break;
		default:
			break;
		}

		final ChangeSet changeSet = new ChangeSet(tuples, ChangeType.POSITIVE);
		return changeSet;
	}

	private void initializeForNodes() throws IOException {
		final FourStoreClient client = new FourStoreClient();

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

		System.out.println("intializeForNodes returns " + tuples.size() + " tuples");
	}

	private void initializeForEdges() throws IOException {
		final FourStoreClient client = new FourStoreClient();
		final Multimap<Long, Long> edges = client.collectEdges(type);

		for (final Entry<Long, Long> entry : edges.entries()) {
			final Tuple tuple = new Tuple(entry.getKey(), entry.getValue());
			tuples.add(tuple);
		}

		System.out.println("intializeForEdges returns " + tuples.size() + " " + type + " tuples");
	}

	public ChangeSet transform() {
		final Set<Tuple> changeSetTuples = new HashSet<>();
		final ChangeSet changeSet = new ChangeSet(changeSetTuples, ChangeType.NEGATIVE);
		for (final Tuple tuple : tuples) {
			System.out.println(tuple);
			
			final int length = (int)tuple.get(1);
			if (length < 0) {
				final int newLength = -length + 1;
				System.out.println(newLength);
				
				changeSetTuples.add(tuple);
				return changeSet;
			}
		}
		return null;
	}
}
