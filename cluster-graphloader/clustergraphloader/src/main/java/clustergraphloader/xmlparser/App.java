package clustergraphloader.xmlparser;

import java.util.Arrays;

import akka.actor.ActorSystem;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

import clustergraphloader.data.ClusterConfiguration;

/**
 * Class for the {@code main} method.
 * @author szarnyasg
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	if (args.length < 2) {
    		System.out.println("Usage: clustergraphloader FILENAME IP_ADDRESS...");
    		return;
    	}

    	String fileName = args[0];
    	String[] ips = Arrays.copyOfRange(args, 1, args.length);
		
    	ClusterConfiguration configuration = new ClusterConfiguration(fileName, ips);
    	ClusterGraphLoader loader = new ClusterGraphLoader(configuration);
		Config remoteCreationConfig = ConfigFactory.load().getConfig("remotecreation");
		ActorSystem system = ActorSystem.create("ReteNet", remoteCreationConfig);
		loader.start(system, 0);
    }
}
