package hu.bme.mit.incqueryd.recipes;

public class TypeInfo {
	protected String ontologyIri;
	protected String typeNameSuffix;

	public TypeInfo(String ontologyIri, String typeNameSuffix) {
		super();
		this.ontologyIri = ontologyIri;
		this.typeNameSuffix = typeNameSuffix;
	}

	public String getOntologyIri() {
		return ontologyIri;
	}

	public String getTypeNameSuffix() {
		return typeNameSuffix;
	}
}