package clustergraphloader.data;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Status {

	protected int percent;
	
	/**
	 * Default no-arg constructor.
	 */
	public Status() {
		
	}
	
	public Status(int percent) {
		super();
		this.percent = percent;
	}

	public int getPercent() {
		return percent;
	}	

	public void setPercent(int percent) {
		this.percent = percent;
	}

}