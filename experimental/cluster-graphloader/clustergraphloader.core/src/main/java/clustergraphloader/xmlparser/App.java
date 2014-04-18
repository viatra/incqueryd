package clustergraphloader.xmlparser;

import java.util.Arrays;

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
    	loader.start();
    }
}
