package hu.bme.mit.incqueryd.monitoringserver.core.processing;

import static akka.pattern.Patterns.ask;
import hu.bme.mit.incqueryd.monitoringserver.core.ReteActorHandler;
import hu.bme.mit.incqueryd.retemonitoring.metrics.MonitoringMessage;
import hu.bme.mit.incqueryd.retemonitoring.metrics.ReteNodeMetrics;

import java.util.ArrayList;
import java.util.List;

import scala.concurrent.Await;
import scala.concurrent.Future;
import scala.concurrent.duration.Duration;
import akka.actor.ActorRef;
import akka.util.Timeout;

public class ReteMonitoringWorker extends Thread {
	
	private List<ReteNodeMetrics> reteMetrics;
	
	protected final Timeout timeout = new Timeout(Duration.create(3, "seconds"));
	
	private boolean success;
	
	public ReteMonitoringWorker() {
		reteMetrics = new ArrayList<>();
		
		success = false;
	}
	
	public void run() {
		for (ActorRef actorRef: ReteActorHandler.getActors()) {
			final Future<Object> future = ask(actorRef, MonitoringMessage.MONITOR, timeout);
			try {
				final ReteNodeMetrics result = (ReteNodeMetrics) Await.result(future, timeout.duration());
				reteMetrics.add(result);
			} catch (Exception e) {
				
			}
		}
		
		success = true;
	}
	
	public boolean successful() {
		return success;
	}
	
	public List<ReteNodeMetrics> getReteMetrics() {
		return reteMetrics;
	}
	
}
