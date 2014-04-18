package graphloader.database.indexers;

import graphloader.database.ClientFacade;
import graphloader.propertygraph.PropertyGraphEdge;

import com.datastax.driver.core.ColumnDefinitions;
import com.datastax.driver.core.ColumnDefinitions.Definition;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;

public class EdgeIndexer {
	
	protected ResultSet edgeResultSet;

	public EdgeIndexer(ClientFacade clientFacade, String criteria) {
		edgeResultSet = runQueryOnEdges(clientFacade, criteria);
	}
	
	public boolean hasNextEdge() {
		return edgeResultSet.iterator().hasNext();
	}
	
	public PropertyGraphEdge nextEdge() {
		Row row = edgeResultSet.iterator().next();	
		return rowToEdge(row);
	}
	
	protected ResultSet runQueryOnEdges(ClientFacade clientFacade, String criteria) {
		String selectEdges = "SELECT * FROM edges";
		if (criteria != null) {
			selectEdges += " WHERE " + criteria + " ALLOW FILTERING";
		}
		ResultSet resultSet = clientFacade.runQuerySync(selectEdges);
		return resultSet;
	}

	protected PropertyGraphEdge rowToEdge(Row row) {
		PropertyGraphEdge edge = new PropertyGraphEdge();
		ColumnDefinitions columnDefinitions = row.getColumnDefinitions();
		for (Definition definition : columnDefinitions) {
			String name = definition.getName();
			String value = row.getString(name);

			if (value != null) {
				switch (name) {
				case "id":
					edge.setId(Integer.parseInt(value));
					break;
				case "sourcevertexid":
					edge.setSourceVertexId(Integer.parseInt(value));
					break;
				case "targetvertexid":
					edge.setTargetVertexId(Integer.parseInt(value));
					break;
				case "label":
					edge.setLabel(value);
					break;
				default:
					edge.setProperty(name, value);
					break;
				}
			}
		}
		return edge;
	}

}
