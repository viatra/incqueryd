package hu.bme.mit.trainbenchmark.benchmark.util;

import java.util.ArrayList;
import java.util.Random;

public class UniqRandom extends Random {
	
	private static final long serialVersionUID = 1L;
	
	ArrayList<Integer> ints = new ArrayList<Integer>();
	
	public UniqRandom(final long random) {
		super(random);
	}
	
	@Override
	public int nextInt(final int n) {
		int newInt = super.nextInt(n);
		if (ints.size() == n)
			ints = new ArrayList<Integer>();
		while (ints.contains(new Integer(newInt))) {
			newInt = super.nextInt(n);
		}
		ints.add(new Integer(newInt));
		return newInt;
	}
}
