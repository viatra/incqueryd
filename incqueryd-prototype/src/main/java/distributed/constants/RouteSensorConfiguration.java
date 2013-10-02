package distributed.constants;

import java.util.HashMap;
import java.util.Map;

import com.typesafe.config.Config;

public class RouteSensorConfiguration {

	public static void setActorIp(final Config config, final String actorName, final String actorIp) {
		System.out.println(actorName + ": " + actorIp);
		ips.put(actorName, actorIp);
	}
	
	public static String getActorPath(final String actorName) {
		final String actorPath = "akka://ReteNet@" + ips.get(actorName) + ":2552/remote/ReteNet@" + "127.0.0.1" + ":2554/user/" + actorName;
		System.out.println("returning actorpath: " + actorPath);
		return actorPath;
	}

	// <ActorName, IP> map
	public static Map<String, String> ips = new HashMap<>();
	
}
