package distributed.constants;

import java.util.HashMap;
import java.util.Map;

import com.typesafe.config.Config;

public class RouteSensorConfiguration {

	public static void setActorIp(final Config config, final String actorName, final String actorIp) {
		System.out.println(actorName + ": " + actorIp);
		ips.put(actorName, actorIp);
	}
	
	public static String getActorPath(final String actorName, final String hostAddress) {
//		try {
//			hostAddress = InetAddress.getLocalHost().getHostAddress();
//		} catch (final UnknownHostException e) {
//			e.printStackTrace();
//		}
		
		final String actorPath = "akka://ReteNet@" + ips.get(actorName) + ":2552/remote/ReteNet@" + hostAddress + ":2554/user/" + actorName;
		System.out.println("returning actor path: " + actorPath);
		return actorPath;
	}

	// <ActorName, IP> map
	public static Map<String, String> ips = new HashMap<>();
	
}
