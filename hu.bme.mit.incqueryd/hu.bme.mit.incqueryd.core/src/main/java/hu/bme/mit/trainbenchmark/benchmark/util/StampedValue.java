package hu.bme.mit.trainbenchmark.benchmark.util;

public class StampedValue<T> {
	long timeStamp;
	T value;
	
	public StampedValue() {
		timeStamp = -1;
		value = null;
	}
	
	public StampedValue(final T value) {
		timeStamp = System.nanoTime();
		this.value = value;
	}
	
	public void setValue(final T value) {
		timeStamp = System.nanoTime();
		this.value = value;
	}
	public T getValue() {
		return value;
	}
	public long getTimeStamp() {
		return timeStamp;
	}
	
	@Override
	public String toString() {
		return getValue().toString();
	}
	
}
