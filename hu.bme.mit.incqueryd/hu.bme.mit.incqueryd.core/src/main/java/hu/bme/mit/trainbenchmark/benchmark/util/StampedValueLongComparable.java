package hu.bme.mit.trainbenchmark.benchmark.util;

import java.util.Comparator;

public class StampedValueLongComparable implements Comparator<StampedValue<Long>>{

	@Override
	public int compare(StampedValue<Long> o1, StampedValue<Long> o2) {
		if (o1.getValue() < o2.getValue()) return -1;
		else if (o1.getValue() > o2.getValue()) return 1;
		return 0;
	}
	
}
