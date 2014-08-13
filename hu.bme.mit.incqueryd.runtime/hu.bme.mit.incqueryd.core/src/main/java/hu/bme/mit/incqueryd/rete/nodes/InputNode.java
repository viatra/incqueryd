package hu.bme.mit.incqueryd.rete.nodes;

import hu.bme.mit.bigmodel.fourstore.FourStoreClient;
import hu.bme.mit.incqueryd.cache.TupleCache;
import hu.bme.mit.incqueryd.recipes.RecipeProcessor;
import hu.bme.mit.incqueryd.recipes.TypeInfo;
import hu.bme.mit.incqueryd.rete.dataunits.ChangeSet;
import hu.bme.mit.incqueryd.rete.dataunits.ChangeType;
import hu.bme.mit.incqueryd.rete.dataunits.GraphElement;
import hu.bme.mit.incqueryd.rete.dataunits.Tuple;
import hu.bme.mit.incqueryd.rete.messages.Transformation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;

import javax.naming.OperationNotSupportedException;

import org.eclipse.incquery.runtime.rete.recipes.TypeInputRecipe;
import org.eclipse.incquery.runtime.rete.recipes.UnaryInputRecipe;

import com.carrotsearch.sizeof.RamUsageEstimator;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;

public class InputNode extends ReteNode implements InitializableReteNode {

	public static String EDGE_DISCRIMINATOR = ">edge"; 
	public static String ATTRIBUTE_DISCRIMINATOR = ">attribute"; 
	protected final String typeNameSuffix;
	protected final GraphElement graphElement;
	protected final Set<Tuple> tuples;
	protected final TupleCache cache;
	protected final Random random = new Random(0);
	protected final String ontologyIri;

	/*
	 * Implementing the input nodes introduces the following challenge: - UnaryInputRecipes enumerate graph nodes -
	 * BinaryInputRecipes enumerate node attributes and references as well
	 * 
	 * A temporary solution is the following: add "attribute" or "reference" string to the trace info.
	 */
	InputNode(final TypeInputRecipe recipe, final List<String> cacheMachineIps) {
		super();

		if (recipe instanceof UnaryInputRecipe) {
			graphElement = GraphElement.NODE;
		} else {
			// the recipe is a BinaryInputRecipe
			if (recipe.getTraceInfo().endsWith(EDGE_DISCRIMINATOR)) {
				graphElement = GraphElement.EDGE;
			} else {
				graphElement = GraphElement.ATTRIBUTE;
			}
		}

		cache = new TupleCache(cacheMachineIps);

		final TypeInfo typeInfo = RecipeProcessor.extractType(recipe);
		ontologyIri = typeInfo.ontologyIri();
		typeNameSuffix = typeInfo.typeNameSuffix();

		final String setName = graphElement.toString() + typeNameSuffix;
		tuples = cache.getSet(setName);
	}

	public String getType() {
		return typeNameSuffix;
	}

	public GraphElement getGraphElement() {
		return graphElement;
	}
	
	public int tuples() {
		return tuples.size();
	}
	
	public double getMemoryConsumption() {
		return tuples.size() > 0 ? (double)RamUsageEstimator.sizeOf(tuples)/RamUsageEstimator.ONE_MB : 0;
	}

	@Override
	public ChangeSet initialize() throws IOException {
		switch (graphElement) {
		case NODE:
			initializeForNode();
			break;
		case EDGE:
			initializeForEdge();
			break;
		case ATTRIBUTE:
			initializeForAttribute();
			break;
		}

		final Set<Tuple> tuplesToSend = cache.isDistributed() ? ImmutableSet.copyOf(tuples) : tuples;

		final ChangeSet changeSet = new ChangeSet(tuplesToSend, ChangeType.POSITIVE);
		return changeSet;
	}

	private void initializeForNode() throws IOException {
		final FourStoreClient client = new FourStoreClient("trainbenchmark_cluster", ontologyIri);

		final List<Long> vertices = client.collectVertices(typeNameSuffix);
		for (final Long vertex : vertices) {
			final Tuple tuple = new Tuple(vertex);
			tuples.add(tuple);
		}

		System.err.println("intializeForNodes returns " + tuples.size() + " tuples");
	}

	private void initializeForAttribute() throws IOException {
		final FourStoreClient client = new FourStoreClient("trainbenchmark_cluster", ontologyIri);
		final Map<Long, Integer> verticesWithProperty = client.collectVerticesWithProperty(typeNameSuffix);
		for (final Entry<Long, Integer> vertexWithProperty : verticesWithProperty.entrySet()) {
			final Tuple tuple = new Tuple(vertexWithProperty.getKey(), vertexWithProperty.getValue());
			tuples.add(tuple);
		}

		System.err.println("intializeForAttribute returns " + tuples.size() + " " + typeNameSuffix + " tuples");
	}

	private void initializeForEdge() throws IOException {
		final FourStoreClient client = new FourStoreClient("trainbenchmark_cluster", ontologyIri);
		final Multimap<Long, Long> edges = client.collectEdges(typeNameSuffix);
		for (final Entry<Long, Long> entry : edges.entries()) {
			final Tuple tuple = new Tuple(entry.getKey(), entry.getValue());
			tuples.add(tuple);
		}

		System.err.println("intializeForEdges returns " + tuples.size() + " " + typeNameSuffix + " tuples");
	}

	public Collection<ChangeSet> transform(final Transformation transformation) throws IOException, OperationNotSupportedException {
		final List<Tuple> invalids = new ArrayList<>(transformation.getInvalids());

		final FourStoreClient client = new FourStoreClient("trainbenchmark_cluster", ontologyIri);
		Collection<ChangeSet> changeSet = null;
		switch (transformation.getTestCase()) {
		case "PosLength":
			changeSet = posLengthTransformation(invalids, client);
			break;
		case "RouteSensor":
			changeSet = routeSensorTransformation(invalids, client);
			break;
		case "SignalNeighbor":
			changeSet = signalNeighborTransformation(invalids, client);
			break;
		case "SwitchSensor":
			changeSet = switchSensorTransformation(invalids, client);
			break;
		default:
			throw new OperationNotSupportedException("Transformation for query " + transformation.getTestCase() + " not supported.");
		}

		return changeSet;
	}

	private Collection<ChangeSet> posLengthTransformation(final List<Tuple> invalids, final FourStoreClient client)
			throws IOException {
		final int size = invalids.size();
		final Set<Tuple> negativeTuples = new HashSet<>();
		final Set<Tuple> positiveTuples = new HashSet<>();
		final Set<Long> segmentsToFix = new HashSet<>();

		final int nElemToModify = size / 10;
		while (segmentsToFix.size() < nElemToModify) {
			final int rndTarget = random.nextInt(size);
			final Long segment = (Long) invalids.get(rndTarget).get(0);
			segmentsToFix.add(segment);
		}

		final Map<Long, Integer> vertexIdAndPropertyValues = new HashMap<>();
		for (final Tuple tuple : tuples) {
			final long segment = (long) tuple.get(0);

			if (segmentsToFix.contains(segment)) {
				final int length = (int) tuple.get(1);
				final int newLength = -length + 1;
				negativeTuples.add(tuple);
				positiveTuples.add(new Tuple(segment, newLength));

				vertexIdAndPropertyValues.put(segment, newLength);
			}
		}

		// 4s persistence
		// partitioning
		final ArrayList<Long> ids = new ArrayList<>(vertexIdAndPropertyValues.keySet());
		final List<List<Long>> partition = Lists.partition(ids, 500);
		for (final List<Long> list : partition) {

			final Map<Long, Integer> vertexIdAndPropertyValuesChunk = new HashMap<>();
			for (final Long vertexId : list) {
				final Integer value = vertexIdAndPropertyValues.get(vertexId);
				vertexIdAndPropertyValuesChunk.put(vertexId, value);
			}

			client.updateProperties(vertexIdAndPropertyValuesChunk, "Segment_length");
		}
		// --

		final ChangeSet negativeChangeSet = new ChangeSet(negativeTuples, ChangeType.NEGATIVE);
		final ChangeSet positiveChangeSet = new ChangeSet(positiveTuples, ChangeType.POSITIVE);
		System.err.println(negativeTuples.size());
		System.err.println(positiveTuples.size());
		return Arrays.asList(negativeChangeSet, positiveChangeSet);
	}

	private Collection<ChangeSet> routeSensorTransformation(final List<Tuple> invalids, final FourStoreClient client)
			throws IOException {
		final int size = invalids.size();
		final Set<Tuple> tuplesToRemove = new HashSet<>();
		final List<Long> sensorsToRemove = new ArrayList<>();
		final int nElemToModify = size / 10;
		for (int i = 0; i < nElemToModify; i++) {
			final int rndTarget = random.nextInt(size);
			final Long sensor = (Long) invalids.get(rndTarget).get(0);
			sensorsToRemove.add(sensor);
		}

		// 4s persistence
		// partitioning
		final List<List<Long>> partition = Lists.partition(sensorsToRemove, 500);
		for (final List<Long> sensorsToRemoveChunk : partition) {
			client.deleteVertices(sensorsToRemoveChunk);
		}

		for (final Tuple tuple : tuples) {
			final Long sensor = (Long) tuple.get(1);
			if (sensorsToRemove.contains(sensor)) {
				tuplesToRemove.add(tuple);
			}
		}
		final ChangeSet changeSet = new ChangeSet(tuplesToRemove, ChangeType.NEGATIVE);
		return Arrays.asList(changeSet);
	}

	private Collection<ChangeSet> signalNeighborTransformation(final List<Tuple> invalids, final FourStoreClient client)
			throws IOException {
		final int size = invalids.size();
		final Set<Tuple> tuplesToRemove = new HashSet<>();
		final Collection<Long> selectedRoutes = new HashSet<>();
		final int nElemToModify = size / 3;

		for (int i = 0; i < nElemToModify; i++) {
			final int rndTarget = random.nextInt(size);
			final Long route = (Long) invalids.get(rndTarget).get(0);
			selectedRoutes.add(route);
		}

		final Multimap<Long, Long> edgesToRemove = ArrayListMultimap.create();
		for (final Tuple tuple : tuples) {
			final Long route = (Long) tuple.get(0);
			if (selectedRoutes.contains(route)) {
				tuplesToRemove.add(tuple);

				// 4s persistence
				final Long signal = (Long) tuple.get(1);
				edgesToRemove.put(route, signal);
			}
		}

		// partitioning
		final ArrayList<Long> sourceVertices = new ArrayList<>(edgesToRemove.keySet());
		final List<List<Long>> partition = Lists.partition(sourceVertices, 500);
		for (final List<Long> sourceVerticesChunk : partition) {

			final Multimap<Long, Long> edgesToRemoveChunk = ArrayListMultimap.create();
			for (final Long sourceVertexId : sourceVerticesChunk) {
				final Collection<Long> targetVertexIds = edgesToRemove.get(sourceVertexId);
				edgesToRemoveChunk.putAll(sourceVertexId, targetVertexIds);
			}

			client.deleteEdges(edgesToRemoveChunk, "Route_exit");
		}

		final ChangeSet changeSet = new ChangeSet(tuplesToRemove, ChangeType.NEGATIVE);
		return Arrays.asList(changeSet);
	}

	private Collection<ChangeSet> switchSensorTransformation(final List<Tuple> invalids, final FourStoreClient client)
			throws IOException {
		final int size = invalids.size();
		final Set<Tuple> changeSetTuples = new HashSet<>();
		final int nElemToModify = size / 10;

		// TODO will work only for a single transformation
		long id = 1000000000;

		final Multimap<Long, Long> edges = ArrayListMultimap.create();
		for (int i = 0; i < nElemToModify; i++) {
			final int rndTarget = random.nextInt(size);
			final Long switchId = (Long) invalids.get(rndTarget).get(0);
			// new edge
			final long sensorId = id++;
			changeSetTuples.add(new Tuple(switchId, sensorId));

			// 4s persistence
			edges.put(switchId, sensorId);
		}

		// partitioning
		final ArrayList<Long> sourceVertices = new ArrayList<>(edges.keySet());
		final List<List<Long>> partition = Lists.partition(sourceVertices, 500);
		for (final List<Long> sourceVerticesChunk : partition) {

			final Multimap<Long, Long> edgesChunk = ArrayListMultimap.create();
			for (final Long sourceVertexId : sourceVerticesChunk) {
				final Collection<Long> targetVertexIds = edges.get(sourceVertexId);
				edgesChunk.putAll(sourceVertexId, targetVertexIds);
			}

			client.insertEdgesWithVertex(edgesChunk, "TrackElement_sensor", "Sensor");
		}

		final ChangeSet changeSet = new ChangeSet(changeSetTuples, ChangeType.POSITIVE);
		return Arrays.asList(changeSet);
	}
}
