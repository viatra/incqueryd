package distributed.constants;

import java.util.HashMap;
import java.util.Map;

import com.typesafe.config.Config;

public class RouteSensorConfiguration {

	public static void  setActorIp(Config config, String actorName) {
		String actorPath = config.getString("akka.actor.deployment.\"/" + actorName + "\".remote");
		String actorIp = actorPath.replace("akka://ReteNet@", "").replace(":2552", "");
		System.out.println(actorName + ": " + actorIp);
		ips.put(actorName, actorIp);
	}

	
	public static void setActorIp(Config config, String actorName, String actorIp) {
		System.out.println(actorName + ": " + actorIp);
		ips.put(actorName, actorIp);
	}
	
	public static String getActorPath(String actorName) {
		String actorPath = "akka://ReteNet@" + ips.get(actorName) + ":2552/remote/ReteNet@" + "127.0.0.1" + ":2554/user/" + actorName;
		System.out.println("returning actorpath: " + actorPath);
		return actorPath;
		//return "akka://ReteNet@" + ips.get(actorName) + ":2552/remote/ReteNet@" + "10.6.21.191" + ":2554/user/" + actorName;
	}

	// <ActorName, IP> map
	public static Map<String, String> ips = new HashMap<>();

}
