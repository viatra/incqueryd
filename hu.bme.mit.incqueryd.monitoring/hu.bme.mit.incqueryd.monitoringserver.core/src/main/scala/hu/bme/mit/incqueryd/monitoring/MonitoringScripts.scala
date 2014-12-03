package hu.bme.mit.incqueryd.monitoring

import java.text.MessageFormat

object MonitoringScripts {
	private val DIRECTORY = "hu.bme.mit.incqueryd.monitoring/scripts/"
	val START_SERVER = MonitoringScripts.DIRECTORY + "server/start-server.sh"
	def START_OS_AGENT(monitoringServerIp: String) = format(DIRECTORY + "osagent/start.sh {0}", monitoringServerIp)
}