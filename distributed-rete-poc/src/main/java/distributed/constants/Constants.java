package distributed.constants;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public enum Constants {
	INSTANCE;
	
	private Constants() {		
		Properties prop = new Properties();
		try {
			prop.load(Constants.class.getResourceAsStream("/config.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		// huge mess here
		GRAPHML_PREFIX = prop.getProperty("GRAPHML_PREFIX");
		GRAPHML_EXTENSION = prop.getProperty("GRAPHML_EXTENSION");
		
		// ip addresses
		List<String> vmIps = new ArrayList<>(Arrays.asList(
				prop.getProperty("VM0"),
				prop.getProperty("VM1"),
				prop.getProperty("VM2"),
				prop.getProperty("VM3")
				));

		VMs = new ArrayList<>();
		for (String vmIp : vmIps) {
			vmIp = "http://" + vmIp + ":7474/db/data";
			VMs.add(vmIp);
		}
		
	}
	
	public void initializeModelSize(int modelSize) {	
		// graphml files
		final String GRAPHML0 = GRAPHML_PREFIX + modelSize + "_A" + GRAPHML_EXTENSION;
		final String GRAPHML1 = GRAPHML_PREFIX + modelSize + "_B" + GRAPHML_EXTENSION;
		final String GRAPHML2 = GRAPHML_PREFIX + modelSize + "_C" + GRAPHML_EXTENSION;
		final String GRAPHML3 = GRAPHML_PREFIX + modelSize + "_D" + GRAPHML_EXTENSION;

		GRAPHMLs = new ArrayList<>(Arrays.asList(GRAPHML0, GRAPHML1, GRAPHML2, GRAPHML3));		
	}

	public List<String> VMs = null;
	public List<String> GRAPHMLs = null;
	protected String GRAPHML_PREFIX;
	protected String GRAPHML_EXTENSION;
	
}
