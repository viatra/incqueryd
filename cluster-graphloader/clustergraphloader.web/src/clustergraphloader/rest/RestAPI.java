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

import clustergraphloader.data.ClusterConfiguration;
import clustergraphloader.data.Status;
import clustergraphloader.xmlparser.ClusterGraphLoader;


@Path("")
@Produces(MediaType.TEXT_HTML)
public class RestAPI {

	@GET
	@Path("")
	public String sayHello() {
		String page = "";
		final String path = "/home/szarnyasg/workspace_java/clustergraphloader.web/WebContent/webui.html";
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
		
		Status status = new Status();
		status.setPercent(Singleton.INSTANCE.n);
		return status;
	}
	
	@GET
	@Path("count")
	public void count() {
		Singleton.INSTANCE.count();
	}

	@POST
	@Path("load")
	@Consumes(MediaType.APPLICATION_JSON)
	public void configure(ClusterConfiguration configuration) {		
    	ClusterGraphLoader loader = new ClusterGraphLoader(configuration);
    	loader.start();		
	}
	
}