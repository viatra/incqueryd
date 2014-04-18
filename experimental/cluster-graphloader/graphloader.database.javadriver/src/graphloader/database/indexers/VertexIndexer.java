package graphloader.database.indexers;

import graphloader.database.ClientFacade;
import graphloader.propertygraph.PropertyGraphVertex;

import com.datastax.driver.core.ColumnDefinitions;
import com.datastax.driver.core.ColumnDefinitions.Definition;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;

public class VertexIndexer {	

	protected ResultSet vertexResultSet;

	public VertexIndexer(ClientFacade clientFacade, String criteria) {
		vertexResultSet = runQueryOnVertices(clientFacade, criteria);
	}
	
	public boolean hasNextVertex() {
		return vertexResultSet.iterator().hasNext();
	}
	
	public PropertyGraphVertex nextVertex() {
		Row row = vertexResultSet.iterator().next();	
		return rowToVertex(row);
	}

	protected ResultSet runQueryOnVertices(ClientFacade clientFacade, String criteria) {
		String selectVertices = "SELECT * FROM vertices";
		if (criteria != null) {
			selectVertices += " WHERE " + criteria + " ALLOW FILTERING";
		}
		ResultSet resultSet = clientFacade.runQuerySync(selectVertices);
		return resultSet;
	}

	protected PropertyGraphVertex rowToVertex(Row row) {
		PropertyGraphVertex vertex = new PropertyGraphVertex();
		ColumnDefinitions columnDefinitions = row.getColumnDefinitions();
		for (Definition definition : columnDefinitions) {
			String name = definition.getName();
			String value = row.getString(name);

			if (value != null) {
				switch (name) {
				case "id":
					vertex.setId(Integer.parseInt(value));
					break;
				default:
					vertex.setProperty(name, value);
					break;
				}
			}
		}
		return vertex;
	}
	
}
