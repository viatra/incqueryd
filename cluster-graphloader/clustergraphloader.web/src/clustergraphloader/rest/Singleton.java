package clustergraphloader.rest;

public enum Singleton {
	INSTANCE;
	
	public int n;
	
	public void count() {
		for (int i = 0; i <= 100; i++) {			
			n = i;
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
