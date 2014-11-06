package hu.bme.mit.incqueryd.monitoringserver.core.processing;

import static akka.pattern.Patterns.ask;
import hu.bme.mit.incqueryd.jvmmonitoring.metrics.JVMMetrics;
import hu.bme.mit.incqueryd.monitoringserver.core.MonitoringAddressStore;
import hu.bme.mit.incqueryd.retemonitoring.metrics.MonitoringMessage;

import java.util.ArrayList;
import java.util.List;

import scala.concurrent.Await;
import scala.concurrent.Future;
import scala.concurrent.duration.Duration;
import akka.actor.ActorRef;
import akka.util.Timeout;

public class JVMMonitoringWorker extends Thread {

	private List<JVMMetrics> jvmMetrics;
	
	protected final Timeout timeout = new Timeout(Duration.create(20, "seconds"));
	
	
	public JVMMonitoringWorker() {
		jvmMetrics = new ArrayList<>();
		
	}
	
	public void run() {
		for (ActorRef actorRef: MonitoringAddressStore.getJvmActors()) {
			final Future<Object> future = ask(actorRef, MonitoringMessage.MONITOR, timeout);
			try {
				final JVMMetrics result = (JVMMetrics) Await.result(future, timeout.duration());
				jvmMetrics.add(result);
			} catch (Exception e) {
				
			}
		}
	}
	
	public List<JVMMetrics> getJvmMetrics() {
		return jvmMetrics;
	}
}
