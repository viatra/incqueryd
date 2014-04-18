package clustergraphloader.data;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Status implements Serializable {

	private static final long serialVersionUID = 1L;
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