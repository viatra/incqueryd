package graphloader.database.helper;

public enum Timer {
	instance;
	
	protected long startTime;
	
	public void startTimer() {
		startTime = System.currentTimeMillis();
	}
	
	public void stopTimer() {
		long stopTime = System.currentTimeMillis();
		long delta = stopTime - startTime;
		System.out.println("Total time: " + delta / 1000 + "s " + delta % 1000 + "ms");
	}
}
