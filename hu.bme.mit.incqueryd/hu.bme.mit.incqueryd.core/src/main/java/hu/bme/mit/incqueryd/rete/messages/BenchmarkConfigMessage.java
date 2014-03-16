package hu.bme.mit.incqueryd.rete.messages;

import java.io.Serializable;

public class BenchmarkConfigMessage implements Serializable {

	private static final long serialVersionUID = 1L;
	protected int size;
	protected int series;

	public BenchmarkConfigMessage(final int size, final int series) {
		super();
		this.size = size;
		this.series = series;
	}

	public int getSize() {
		return size;
	}

	public int getSeries() {
		return series;
	}

}
