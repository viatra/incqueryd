package clustergraphloader.data;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ClusterConfiguration {

	protected String fileName;
	protected String[] ips;
	
	/**
	 * Default no-arg constructor.
	 */
	public ClusterConfiguration() {
		
	}
	
	public ClusterConfiguration(String fileName, String[] ips) {
		super();
		this.fileName = fileName;
		this.ips = ips;
	}

	public String getFileName() {
		return fileName;
	}
	
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	public String[] getIps() {
		return ips;
	}
	
	public void setIps(String[] ips) {
		this.ips = ips;
	}
	
}
