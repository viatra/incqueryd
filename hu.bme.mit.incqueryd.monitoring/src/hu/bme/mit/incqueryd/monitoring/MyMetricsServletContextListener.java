package hu.bme.mit.incqueryd.monitoring;

import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.servlets.MetricsServlet;

public class MyMetricsServletContextListener extends MetricsServlet.ContextListener {
	
	private MetricRegistry metricRegistry;
    public MyMetricsServletContextListener(MetricRegistry metricRegistry) {
        this.metricRegistry = metricRegistry;
    }

	@Override
	protected MetricRegistry getMetricRegistry() {
		return metricRegistry;
	}

}
