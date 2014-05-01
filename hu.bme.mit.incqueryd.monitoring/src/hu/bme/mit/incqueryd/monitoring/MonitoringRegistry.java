package hu.bme.mit.incqueryd.monitoring;

import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.servlet.ServletContextHandler;

import com.codahale.metrics.Counter;
import com.codahale.metrics.Gauge;
import com.codahale.metrics.Meter;
import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.servlets.MetricsServlet;

public class MonitoringRegistry {

	protected final static MonitoringRegistry instance = new MonitoringRegistry();
	
	protected final static MetricRegistry metricsRegistry = new MetricRegistry();
	
	protected Server server;
		
	protected MonitoringRegistry(){
		
	}
	
	public static MonitoringRegistry getInstance(){
		return instance;
	}
	
	
	public <T>  void registerGauge(String name, Gauge<T> gauge){
		metricsRegistry.register(name, gauge);
	}
	
	public Counter registerCounter(String name){
		return metricsRegistry.counter(name);
	}
	
	public Meter registerMeter(String name){
		return metricsRegistry.meter(name);
	}
	
	public void startHTTPReporting(String host, int port){
		
		server = new Server();
		
		ServerConnector connector = new ServerConnector(server);
		connector.setHost(host);
		connector.setPort(port);
		server.setConnectors(new Connector[] { connector });
		
		HandlerList handlers = new HandlerList();
		ServletContextHandler metricsContextHandler = new ServletContextHandler();
		metricsContextHandler.setContextPath("/rest");
		metricsContextHandler.addEventListener(new MyMetricsServletContextListener(metricsRegistry));
		metricsContextHandler.addServlet(MetricsServlet.class, "/metrics");
		
		handlers.setHandlers(new Handler[]{metricsContextHandler});
		server.setHandler(handlers);
	    try {
			server.start();
		} catch (Exception e) {
			
		}
	}
	
	public void stopHTTPReporting(){
		try {
			server.stop();
		} catch (Exception e) {
			
		}
	}
	
	public void printGauges() {
		for (String key : metricsRegistry.getGauges().keySet()) {
			System.out.println(key + ": " +metricsRegistry.getGauges().get(key).getValue());
		}
	}
}
