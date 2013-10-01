package clustergraphloader.helper;

public enum Timer {
	instance;
	
	protected long startTime;
	
	public void startTimer() {
		startTime = System.nanoTime();
	}
	
	public void stopTimer() {
		long stopTime = System.nanoTime();
		long delta = stopTime - startTime;
		
		long deltaMs = delta / 1000000; 
		System.out.println("Total time: " + deltaMs / 1000 + "s " + deltaMs % 1000 + "ms");		
	}
}
