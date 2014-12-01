package hu.bme.mit.incqueryd.agent;

import hu.bme.mit.incqueryd.engine.util.EObjectDeserializer;
import infrastructure.Process;

import java.io.IOException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import arch.ArchPackage;
import arch.Configuration;

import com.codahale.metrics.annotation.Timed;
import com.google.common.collect.ImmutableSet;

@Path("/start")
public class StartMicrokernelsResource {

	@GET
	@Timed
	public Response execute(@QueryParam("architecture") String architectureJson) throws IOException {
		Configuration configuration = parseArchitecture(architectureJson);
		for (Process process : getLocalProcesses(configuration)) {
			startMicrokernel(process);
		}
		return Response.ok().build();
	}

	private Configuration parseArchitecture(String architectureJson) throws IOException {
		return (Configuration) EObjectDeserializer.deserializeFromString(architectureJson, ImmutableSet.of(ArchPackage.eINSTANCE));
	}

	private Iterable<infrastructure.Process> getLocalProcesses(Configuration configuration) {
		// TODO Auto-generated method stub
		return null;
	}

	private void startMicrokernel(Process process) {
		// TODO Auto-generated method stub
	}

}
