package hu.bme.mit.incqueryd.infrastructureagent.client

import hu.bme.mit.incqueryd.coordinator.client.CoordinatorClient

case class Infrastructure(
    coordinator: Option[CoordinatorClient]
)