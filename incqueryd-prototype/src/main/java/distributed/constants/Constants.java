package distributed.constants;

import java.io.IOException;
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
		
	}	
}
