package hu.bme.mit.train.util;

import java.util.ArrayList;
import java.util.Random;

public class UniqRandom extends Random {
	
	private static final long serialVersionUID = 1L;
	
	ArrayList<Integer> ints = new ArrayList<Integer>();
	
	public UniqRandom(long random) {
		super(random);
	}
	
	@Override
	public int nextInt(int n) {
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
