package clustergraphloader.rest;

import java.io.File;
import java.io.IOException;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;

import scala.concurrent.Await;
import scala.concurrent.Future;
import scala.concurrent.duration.Duration;
import akka.actor.ActorRef;
import akka.pattern.Patterns;
import akka.util.Timeout;
import clustergraphloader.data.ClusterConfiguration;
import clustergraphloader.data.Status;
import clustergraphloader.messages.ActorMessage;

@Path("")
@Produces(MediaType.TEXT_HTML)
public class RestAPI {

	protected final Logger logger = Logger.getLogger(RestAPI.class);
	
	@GET
	@Path("")
	public String webui() {
		logger.info("Web UI page opened.");
		
		String page = "";
		final String path = "/home/szarnyasg/workspace_java/clustergraphloader/WebContent/webui.html";
		File file = new File(path);

		try {
			page = FileUtils.readFileToString(file);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return page;
	}

	@GET
	@Path("status")
	@Produces(MediaType.APPLICATION_JSON)
	public Status status() {
		ActorRef coordinator = RestState.instance.getCoordinator();
		
		if (coordinator == null) {
			return new Status(0);
		}

		Status status;
		Timeout timeout = new Timeout(Duration.create(10, "seconds"));
		Future<Object> future = Patterns.ask(coordinator, ActorMessage.STATUS, timeout);
		try {
			status = (Status) Await.result(future, timeout.duration());
		} catch (Exception e) {	
			e.printStackTrace();
			status = new Status(0);
		}
		
		return status;
	}

	@POST
	@Path("load")
	@Consumes(MediaType.APPLICATION_JSON)
	public void configure(ClusterConfiguration configuration) {
		logger.info("Load initiated.");

		RestState.instance.process(configuration);
	}

}