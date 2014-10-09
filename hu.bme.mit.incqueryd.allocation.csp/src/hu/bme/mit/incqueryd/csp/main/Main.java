package hu.bme.mit.incqueryd.csp.main;

import hu.bme.mit.incqueryd.csp.util.ReteAllocator;

import java.io.IOException;

import org.apache.commons.cli.ParseException;

public class Main {
	
	public static void main(String[] args) throws IOException, ParseException {
		System.loadLibrary("jniortools");
		AllocationConfiguration allocationConfiguration = new AllocationConfiguration(args);
		
		ReteAllocator allocator = new ReteAllocator(allocationConfiguration);
		if (allocator.allocate()) {
			System.out.println("Your arch file is ready");
		} else {
			System.out.println("The problem can not be solved with the current resource set!");
		}
	}

}
