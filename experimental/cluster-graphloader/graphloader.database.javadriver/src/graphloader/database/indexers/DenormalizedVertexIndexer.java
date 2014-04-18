//package graphloader.database.indexers;
//
//import graphloader.database.ClientFacade;
//
//import com.datastax.driver.core.ColumnDefinitions;
//import com.datastax.driver.core.ColumnDefinitions.Definition;
//import com.datastax.driver.core.ResultSet;
//import com.datastax.driver.core.Row;
//
//public class DenormalizedVertexIndexer {
//
//	protected ResultSet denormalizedVertexResultSet;
//
//	public DenormalizedVertexIndexer(ClientFacade clientFacade, String criteria) {
//		denormalizedVertexResultSet = runQueryOnDenormalizedVertices(clientFacade, criteria);
//	}
//	
//	public boolean hasNextDenormalizedVertex() {
//		return denormalizedVertexResultSet.iterator().hasNext();
//	}
//	
//	public DenormalizedVertex nextDenormalizedVertex() {
//		Row row = denormalizedVertexResultSet.iterator().next();	
//		return rowToDenormalizedVertex(row);
//	}
//
//	protected ResultSet runQueryOnDenormalizedVertices(ClientFacade clientFacade, String criteria) {
//		String selectDenormalizedVertices = "SELECT * FROM vertex_edges";
//		if (criteria != null) {
//			selectDenormalizedVertices += " WHERE " + criteria + " ALLOW FILTERING";
//		}
//		ResultSet resultSet = clientFacade.runQuery(selectDenormalizedVertices);
//		return resultSet;
//	}
//
//	protected DenormalizedVertex rowToDenormalizedVertex(Row row) {
//		DenormalizedVertex denormalizedVertex = new DenormalizedVertex();
//		ColumnDefinitions columnDefinitions = row.getColumnDefinitions();
//		for (Definition definition : columnDefinitions) {
//			String name = definition.getName();
//			String value = row.getString(name);
//
//			if (value != null) {
//				switch (name) {
//				case "vertex_id":
//					denormalizedVertex.getVertex().setId(Integer.parseInt(value));
//					break;
//				case "edge_id":
//					denormalizedVertex.getEdge().setId(Integer.parseInt(value));
//					break;
//				case "edge_sourcevertexid":
//					denormalizedVertex.getEdge().setSourceVertexId(Integer.parseInt(value));
//					break;
//				case "edge_targetvertexid":
//					denormalizedVertex.getEdge().setTargetVertexId(Integer.parseInt(value));
//					break;
//				case "edge_label":
//					denormalizedVertex.getEdge().setLabel(value);
//					break;					
//				default:
//					if (name.startsWith("vertex_")) {
//						name = name.replaceFirst("vertex_", "");
//						denormalizedVertex.getVertex().setProperty(name, value);
//					}
//					if (name.startsWith("edge_")) {
//						name = name.replaceFirst("edge_", "");
//						denormalizedVertex.getEdge().setProperty(name, value);
//					}
//					break;
//				}
//			}
//		}
//		return denormalizedVertex;
//	}
//}
