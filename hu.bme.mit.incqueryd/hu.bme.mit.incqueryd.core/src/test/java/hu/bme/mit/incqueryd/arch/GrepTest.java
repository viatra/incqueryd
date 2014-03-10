package hu.bme.mit.incqueryd.arch;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class GrepTest {

	@Test
	public void test() {
		final String traceInfo = "UniquenessEnforcerNode : TrackElement_sensor :  [0]";
		assertEquals("TrackElement_sensor", ArchUtil.extractType(traceInfo));		
	}

}
