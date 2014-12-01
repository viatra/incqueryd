package hu.bme.mit.incqueryd.agent;

import hu.bme.mit.incqueryd.engine.util.EObjectDeserializer;
import inventory.Inventory;
import inventory.InventoryPackage;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.MessageFormat;
import java.util.Collections;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import org.mondo.eu.utils.UnixUtils;

import com.codahale.metrics.annotation.Timed;
import com.google.common.collect.ImmutableSet;

@Path("/prepare")
public class PrepareInfrastructureResource {

	private static final String MONITORING_SCRIPTS = "hu.bme.mit.incqueryd.monitoring/scripts/";

	@GET
	@Timed
	public Response execute(@QueryParam("infrastructure") String inventoryJson) throws IOException {
		Inventory inventory = parseInventory(inventoryJson);
		if (thisMachineIsMaster(inventory)) {
			startCoordinator(inventory);
			startMonitoring();
		}
		startOsAgent(inventory);
		return Response.ok().build();
	}

	private Inventory parseInventory(String inventoryJson) throws IOException {
		return (Inventory) EObjectDeserializer.deserializeFromString(inventoryJson, ImmutableSet.of(InventoryPackage.eINSTANCE));
	}

	private boolean thisMachineIsMaster(Inventory inventory) throws UnknownHostException {
		String ipAddress = InetAddress.getLocalHost().getHostAddress();
		return ipAddress.equals(inventory.getMaster().getIp());
	}

	private void startCoordinator(Inventory inventory) throws IOException {
		String command = "hu.bme.mit.incqueryd.engine/scripts/coordinator/start-coordinator.sh"; // XXX script path
		// TODO pass inventory
		// TODO pass interface?
		UnixUtils.exec(command, Collections.<String, String>emptyMap());
	}

	private void startMonitoring() throws IOException {
		String command = MONITORING_SCRIPTS + "server/start-server.sh"; // XXX script path
		UnixUtils.exec(command, Collections.<String, String>emptyMap());
	}

	private void startOsAgent(Inventory inventory) throws IOException {
		String command = MessageFormat.format(MONITORING_SCRIPTS + "osagent/start.sh {0}", inventory.getMaster().getIp()); // XXX script path
		UnixUtils.exec(command, Collections.<String, String>emptyMap());
	}

}