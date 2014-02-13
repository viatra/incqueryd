package hu.bme.mit.incqueryd;

import hu.bme.mit.incqueryd.cache.DistributedCache;
import hu.bme.mit.incqueryd.cache.local.LocalCache;

import com.google.inject.Binder;
import com.google.inject.Module;

public class TestModule implements Module {

	@Override
	public void configure(Binder binder) {
		binder.bind(DistributedCache.class).to(LocalCache.class);
	}

}
