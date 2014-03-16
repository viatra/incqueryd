package hu.bme.mit.trainbenchmark.benchmark.util;

/**
 * Stores memory usage results.
 */
public class Memory {
	private long rss;
	
	
	public long getRss() {
		return rss;
	}
	public void setRss(long rss) {
		this.rss = rss;
	}
	
	public long getMemory() {
		return rss; // this is the default
	}
}
