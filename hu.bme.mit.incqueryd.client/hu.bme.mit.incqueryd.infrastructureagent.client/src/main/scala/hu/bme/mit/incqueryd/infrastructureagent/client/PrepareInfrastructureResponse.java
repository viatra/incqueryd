package hu.bme.mit.incqueryd.infrastructureagent.client;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PrepareInfrastructureResponse {

	public PrepareInfrastructureResponse() {
	}

	public PrepareInfrastructureResponse(boolean master) {
		this.master = master;
	}

	private boolean master;

	@JsonProperty
	public void setMaster(boolean master) {
		this.master = master;
	}
	
	@JsonProperty
	public boolean isMaster() {
		return master;
	}
	
}
