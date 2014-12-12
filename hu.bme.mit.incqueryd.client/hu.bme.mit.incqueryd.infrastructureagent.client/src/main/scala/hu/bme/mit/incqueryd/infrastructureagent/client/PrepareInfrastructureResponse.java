package hu.bme.mit.incqueryd.infrastructureagent.client;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PrepareInfrastructureResponse {

	private final boolean master;

	@JsonCreator
	public PrepareInfrastructureResponse(@JsonProperty boolean master) {
		this.master = master;
	}
	
	@JsonProperty
	public boolean isMaster() {
		return master;
	}
	
}
