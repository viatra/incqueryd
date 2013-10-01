package graphloader.propertygraph;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public abstract class PropertyGraphElement {

	protected int id;
	protected Map<String, String> properties = new HashMap<>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProperty(String arg0) {
		return properties.get(arg0);
	}

	public Set<String> getPropertyKeys() {
		return properties.keySet();
	}

	public Object removeProperty(String arg0) {
		return properties.remove(arg0);
	}

	public void setProperty(String key, String value) {
		properties.put(key, value);		
	}
	
	public Map<String, String> getProperties() {
		return properties;
	}
	
	public void setProperties(Map<String, String> properties) {
		this.properties = properties;
	}

	public boolean isIdentical(PropertyGraphElement propertyGraphElement) {
		return this.getId() == propertyGraphElement.getId();
	}
	
}
