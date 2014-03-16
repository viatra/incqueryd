package hu.bme.mit.incqueryd.rete.nodes;

import hu.bme.mit.incqueryd.arch.ArchUtil;
import hu.bme.mit.incqueryd.databases.FourStoreClient;
import hu.bme.mit.incqueryd.rete.dataunits.ChangeSet;
import hu.bme.mit.incqueryd.rete.dataunits.ChangeType;
import hu.bme.mit.incqueryd.rete.dataunits.GraphElement;
import hu.bme.mit.incqueryd.rete.dataunits.Tuple;
import hu.bme.mit.incqueryd.rete.messages.Transformation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
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

	final Random random = new Random(0);

	public Collection<ChangeSet> transform(final Transformation transformation) {
		final List<Tuple> invalids = new ArrayList<>(transformation.getInvalids());
		final int size = invalids.size();

		Collection<ChangeSet> changeSet = null;
		switch (transformation.getTestCase()) {
		case "PosLength":
			changeSet = posLengthTransformation(invalids, size);
			break;
		case "RouteSensor":
			changeSet = routeSensorTransformation(invalids, size);
			break;
		case "SignalNeighbor":
			changeSet = signalNeighborTransformation(invalids, size);
			break;
		case "SwitchSensor":
			changeSet = switchSensorTransformation(invalids, size);
			break;
		default:
			break;
		}

		return changeSet;
	}

	private Collection<ChangeSet> posLengthTransformation(final List<Tuple> invalids, final int size) {
		final Set<Tuple> negativeTuples = new HashSet<>();
		final Set<Tuple> positiveTuples = new HashSet<>();

		final Set<Long> segmentsToFix = new HashSet<>();

		final int nElemToModify = size / 10;
		//for (int i = 0; i < nElemToModify; i++) {
		while (segmentsToFix.size() < nElemToModify) {
			final int rndTarget = random.nextInt(size);
			final Long segment = (Long) invalids.get(rndTarget).get(0);
			segmentsToFix.add(segment);
		}

		for (final Tuple tuple : tuples) {
			final long segment = (long) tuple.get(0);

			if (segmentsToFix.contains(segment)) {
				final int length = (int) tuple.get(1);
				final int newLength = -length + 1;
				negativeTuples.add(tuple);
				positiveTuples.add(new Tuple(segment, newLength));
			}
		}

		final ChangeSet negativeChangeSet = new ChangeSet(negativeTuples, ChangeType.NEGATIVE);
		final ChangeSet positiveChangeSet = new ChangeSet(positiveTuples, ChangeType.POSITIVE);
		System.out.println(negativeTuples.size());
		System.out.println(positiveTuples.size());
		return Arrays.asList(negativeChangeSet, positiveChangeSet);
	}

	private Collection<ChangeSet> routeSensorTransformation(final List<Tuple> invalids, final int size) {
		final Set<Tuple> tuplesToRemove = new HashSet<>();
		final Set<Long> sensorsToRemove = new HashSet<>();
		final int nElemToModify = size / 10;
		for (int i = 0; i < nElemToModify; i++) {
			final int rndTarget = random.nextInt(size);
			final Long sensor = (Long) invalids.get(rndTarget).get(0);
			sensorsToRemove.add(sensor);
		}
		// System.out.println(sensorsToRemove);

		for (final Tuple tuple : tuples) {
			final Long sensor = (Long) tuple.get(1);
			if (sensorsToRemove.contains(sensor)) {
				tuplesToRemove.add(tuple);
			}
		}
		final ChangeSet changeSet = new ChangeSet(tuplesToRemove, ChangeType.NEGATIVE);
		return Arrays.asList(changeSet);
	}

	private Collection<ChangeSet> signalNeighborTransformation(final List<Tuple> invalids, final int size) {
		final Set<Tuple> tuplesToRemove = new HashSet<>();
		final Collection<Long> selectedRoutes = new HashSet<>();
		final int nElemToModify = size / 3;

		for (int i = 0; i < nElemToModify; i++) {
			final int rndTarget = random.nextInt(size);
			final Long route = (Long) invalids.get(rndTarget).get(0);
			selectedRoutes.add(route);
		}

		for (final Tuple tuple : tuples) {
			final Long route = (Long) tuple.get(0);
			if (selectedRoutes.contains(route)) {
				tuplesToRemove.add(tuple);
			}
		}

		final ChangeSet changeSet = new ChangeSet(tuplesToRemove, ChangeType.NEGATIVE);
		return Arrays.asList(changeSet);
	}

	private Collection<ChangeSet> switchSensorTransformation(final List<Tuple> invalids, final int size) {
		final Set<Tuple> changeSetTuples = new HashSet<>();
		final int nElemToModify = size / 10;

		long x = 1000000000;
		for (int i = 0; i < nElemToModify; i++) {
			final int rndTarget = random.nextInt(size);
			final Long aSwitch = (Long) invalids.get(rndTarget).get(0);
			// new edge
			changeSetTuples.add(new Tuple(aSwitch, x++));
		}

		final ChangeSet changeSet = new ChangeSet(changeSetTuples, ChangeType.POSITIVE);
		return Arrays.asList(changeSet);
	}
}
