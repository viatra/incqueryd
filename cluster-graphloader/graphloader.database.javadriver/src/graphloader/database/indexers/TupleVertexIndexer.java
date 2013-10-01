package graphloader.database.indexers;

import java.util.ArrayList;
import java.util.List;

import graphloader.database.ClientFacade;
import graphloader.propertygraph.PropertyGraphEdge;
import graphloader.propertygraph.PropertyGraphElement;
import graphloader.propertygraph.PropertyGraphVertex;

import com.datastax.driver.core.ColumnDefinitions;
import com.datastax.driver.core.ColumnDefinitions.Definition;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;

public class TupleVertexIndexer {

	protected ResultSet denormalizedVertexResultSet;

	public TupleVertexIndexer(ClientFacade clientFacade, String criteria) {
		denormalizedVertexResultSet = runQueryOnDenormalizedVertices(clientFacade, criteria);
	}
	
	public boolean hasNextDenormalizedVertex() {
		return denormalizedVertexResultSet.iterator().hasNext();
	}
	
	//public List<PropertyGraphElement> nextDenormalizedVertex() {
	public PropertyGraphElement[] nextTuple() {
		Row row = denormalizedVertexResultSet.iterator().next();	
		return rowToTuple(row);
	}

	protected ResultSet runQueryOnDenormalizedVertices(ClientFacade clientFacade, String criteria) {
		String selectDenormalizedVertices = "SELECT * FROM vertex_edges";
		if (criteria != null) {
			selectDenormalizedVertices += " WHERE " + criteria + " ALLOW FILTERING";
		}
		ResultSet resultSet = clientFacade.runQuerySync(selectDenormalizedVertices);
		return resultSet;
	}

	//protected List<PropertyGraphElement> rowToTuple(Row row) {
	protected PropertyGraphElement[] rowToTuple(Row row) {
		PropertyGraphVertex vertex = new PropertyGraphVertex();
		PropertyGraphEdge edge = new PropertyGraphEdge();

		List<PropertyGraphElement> tupleAsList = new ArrayList<>(2);
		tupleAsList.add(vertex);
		tupleAsList.add(edge);
		
		ColumnDefinitions columnDefinitions = row.getColumnDefinitions();
		for (Definition definition : columnDefinitions) {
			String name = definition.getName();
			String value = row.getString(name);

			if (value != null) {
				switch (name) {
				case "vertex_id":
					vertex.setId(Integer.parseInt(value));
					break;
				case "edge_id":
					edge.setId(Integer.parseInt(value));
					break;
				case "edge_sourcevertexid":
					edge.setSourceVertexId(Integer.parseInt(value));
					break;
				case "edge_targetvertexid":
					edge.setTargetVertexId(Integer.parseInt(value));
					break;
				case "edge_label":
					edge.setLabel(value);
					break;					
				default:
					if (name.startsWith("vertex_")) {
						name = name.replaceFirst("vertex_", "");
						vertex.setProperty(name, value);
					}
					if (name.startsWith("edge_")) {
						name = name.replaceFirst("edge_", "");
						edge.setProperty(name, value);
					}
					break;
				}
			}
		}

		PropertyGraphElement[] tupleAsArray = { vertex, edge };		
//		System.out.println("0: " + tupleAsArray[0] + " 1:" + tupleAsArray[1]);
		
		return tupleAsArray;
	}
}
