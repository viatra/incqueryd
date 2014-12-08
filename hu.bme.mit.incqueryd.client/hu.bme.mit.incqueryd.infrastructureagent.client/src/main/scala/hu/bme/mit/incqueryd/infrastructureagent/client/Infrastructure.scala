package hu.bme.mit.incqueryd.infrastructureagent.client

import hu.bme.mit.incqueryd.monitoringserver.client.MonitoringServer
import hu.bme.mit.incqueryd.coordinator.client.Coordinator

case class Infrastructure(
    coordinator: Option[Coordinator],
    monitoringServer: Option[MonitoringServer]
)