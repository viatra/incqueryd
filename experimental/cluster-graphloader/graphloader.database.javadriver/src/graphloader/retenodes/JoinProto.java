package graphloader.retenodes;

import java.util.LinkedList;
import java.util.List;

import com.datastax.driver.core.querybuilder.Insert;
import com.datastax.driver.core.querybuilder.QueryBuilder;

import graphloader.database.ClientFacade;
import graphloader.database.indexers.IndexerFactory;
import graphloader.database.indexers.TupleVertexIndexer;
import graphloader.propertygraph.PropertyGraphElement;

public class JoinProto {

	public static void query(ClientFacade clientFacade) {
		IndexerFactory indexerFactory = new IndexerFactory(clientFacade);

		// List<List<PropertyGraphElement>> tuplesForGods = new LinkedList<>();
		int[] patternMaskForGods = { 1 };
		List<PropertyGraphElement[]> tuplesForGods = new LinkedList<>();
		TupleVertexIndexer tupleVertexIndexerForGods = indexerFactory.createTupleVertexIndexer(clientFacade, "vertex_type = 'god' AND edge_label = 'lives'");
		System.out.println("gods:");
		while (tupleVertexIndexerForGods.hasNextDenormalizedVertex()) {
			// List<PropertyGraphElement> tuple = tuplesForLocations.nextDenormalizedVertex();
			PropertyGraphElement[] tuple = tupleVertexIndexerForGods.nextTuple();
			tuplesForGods.add(tuple);

			System.out.println(">> " + tuple[0] + " >> " + tuple[1]);
		}

		// List<List<PropertyGraphElement>> tuplesForLocations = new LinkedList<>();
		int[] patternMaskForLocations = { 1 };
		List<PropertyGraphElement[]> tuplesForLocations = new LinkedList<>();
		TupleVertexIndexer tupleVertexIndexerForLocations = indexerFactory.createTupleVertexIndexer(clientFacade,
				"vertex_type = 'location' AND edge_label = 'lives'");
		System.out.println("location:");
		while (tupleVertexIndexerForLocations.hasNextDenormalizedVertex()) {
			// List<PropertyGraphElement> tuple = tuplesForLocations.nextDenormalizedVertex();
			PropertyGraphElement[] tuple = tupleVertexIndexerForLocations.nextTuple();
			tuplesForLocations.add(tuple);

			System.out.println(">> " + tuple[0] + " >> " + tuple[1]);
		}

		System.out.println("matched:");
		for (PropertyGraphElement[] tupleForGods : tuplesForGods) {
			for (PropertyGraphElement[] tupleForLocations : tuplesForLocations) {
				if (Matcher.match(tupleForGods, tupleForLocations, patternMaskForGods, patternMaskForLocations)) {
					PropertyGraphElement[] joinedTuple = Matcher.join(tupleForGods, tupleForLocations, patternMaskForGods, patternMaskForLocations);
					System.out.println(Matcher.tupleToString(joinedTuple));
				}
			}
		}

		// Collection<DenormalizedVertex> denormalizedVerticesForLocations = new
		// LinkedList<>();
		// DenormalizedVertexIndexer denormalizedVertexIndexerForLocations =
		// indexerFactory.createDenormalizedVertexIndexer(clientFacade,
		// "vertex_type = 'location' AND edge_label = 'lives'");
		// while (denormalizedVertexIndexerForLocations.hasNextDenormalizedVertex()) {
		// DenormalizedVertex denormalizedVertex =
		// denormalizedVertexIndexerForLocations.nextDenormalizedVertex();
		// System.out.println(denormalizedVertex);
		// denormalizedVerticesForLocations.add(denormalizedVertex);
		// }
		//
		// Collection<DenormalizedVertex> denormalizedVerticesForGods = new
		// LinkedList<>();
		// DenormalizedVertexIndexer denormalizedVertexIndexerForGods =
		// indexerFactory.createDenormalizedVertexIndexer(clientFacade,
		// "vertex_type = 'god' AND edge_label = 'lives'");
		// while (denormalizedVertexIndexerForGods.hasNextDenormalizedVertex())
		// {
		// DenormalizedVertex denormalizedVertex =
		// denormalizedVertexIndexerForGods.nextDenormalizedVertex();
		// System.out.println(denormalizedVertex);
		// denormalizedVerticesForGods.add(denormalizedVertex);
		// }
		//
		// for (DenormalizedVertex denormalizedVertexForGods : denormalizedVerticesForGods) {
		// for (DenormalizedVertex denormalizedVertexForLocations : denormalizedVerticesForLocations) {
		// if (denormalizedVertexForGods.getEdge().getId() == denormalizedVertexForLocations.getEdge().getId()) {
		// System.out.println(denormalizedVertexForGods.getVertex() + "   " +
		// denormalizedVertexForLocations.getVertex());
		// }
		// }
		// }

	}

}
