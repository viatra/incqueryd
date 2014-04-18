package graphloader.main;

import graphloader.database.ClientFacade;
import graphloader.database.GraphMLParser;
import graphloader.database.helper.Timer;
import graphloader.database.indexers.EdgeIndexer;
import graphloader.database.indexers.IndexerFactory;
import graphloader.database.indexers.VertexIndexer;
import graphloader.propertygraph.PropertyGraphEdge;
import graphloader.propertygraph.PropertyGraphVertex;
import graphloader.retenodes.JoinProto;

import java.io.IOException;
import java.util.Collection;
import java.util.LinkedList;

public class MainTestClient {
	public static void main(String[] args) throws IOException {
		try {
			run();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(0);
		}
	}

	protected static void run() throws IOException {
		Timer.instance.startTimer();
		ClientFacade clientFacade = new ClientFacade("localhost");

		GraphMLParser graphMLParser = new GraphMLParser(clientFacade);
		graphMLParser.loadGraphML("graph-of-the-gods.xml");
		// graphMLParser.loadGraphML("testBig_User_1.xml");

		IndexerFactory indexerFactory = new IndexerFactory(clientFacade);
		
		//normalizedQueries(indexerFactory);
		graphMLParser.prejoin();

		JoinProto.query(clientFacade);
		// clientFacade.selectSandbox();

		Timer.instance.stopTimer();
		System.exit(0);
	}

	private static void normalizedQueries(IndexerFactory indexerFactory) {
		System.out.println("gods");
		System.out.println("----");
		Collection<PropertyGraphVertex> gods = new LinkedList<>();
		VertexIndexer vertexIndexerForGods =
				indexerFactory.createVertexIndexer("type = 'god'");
		while (vertexIndexerForGods.hasNextVertex()) {
			PropertyGraphVertex vertex = vertexIndexerForGods.nextVertex();
			System.out.println(vertex);
			gods.add(vertex);
		}

		System.out.println("locations");
		System.out.println("---------");
		Collection<PropertyGraphVertex> locations = new LinkedList<>();
		VertexIndexer vertexIndexerForLocations =
				indexerFactory.createVertexIndexer("type = 'location'");
		while (vertexIndexerForLocations.hasNextVertex()) {
			PropertyGraphVertex vertex = vertexIndexerForLocations.nextVertex();
			System.out.println(vertex);
			locations.add(vertex);
		}

		Collection<PropertyGraphEdge> lives = new LinkedList<>();
		EdgeIndexer edgeIndexer =
				indexerFactory.createEdgeIndexer("label = 'lives'");
		while (edgeIndexer.hasNextEdge()) {
			PropertyGraphEdge edge = edgeIndexer.nextEdge();
			System.out.println(edge);
			lives.add(edge);
		}

		System.out.println("========================");
		System.out.println();
		for (PropertyGraphEdge livesEdge : lives) {
			for (PropertyGraphVertex godVertex : gods) {
				for (PropertyGraphVertex locationVertex : locations) {
					// (God)--[lives]-->(Location)
					if (livesEdge.getSourceVertexId() == godVertex.getId() &&
							livesEdge.getTargetVertexId() == locationVertex.getId()) {
						System.out.println(godVertex + "   " + livesEdge + "   " +
								locationVertex);
					}
				}
			}
		}
	}

}
