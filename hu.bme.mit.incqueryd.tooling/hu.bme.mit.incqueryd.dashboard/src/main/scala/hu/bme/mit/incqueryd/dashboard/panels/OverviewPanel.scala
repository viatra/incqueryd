package hu.bme.mit.incqueryd.dashboard.panels

import hu.bme.mit.incqueryd.dashboard.dev.DevPanelConfiguration
import hu.bme.mit.incqueryd.dashboard.dev.GridPosition
import org.apache.hadoop.yarn.api.records.NodeState
import com.vaadin.ui.VerticalLayout
import com.vaadin.ui.Label
import com.vaadin.ui.ComponentContainer
import com.vaadin.ui.VerticalSplitPanel
import com.vaadin.ui.Table
import java.util.Date
import com.vaadin.ui.ProgressBar
import com.vaadin.ui.Link
import org.apache.hadoop.yarn.api.records.ApplicationReport
import com.vaadin.ui.Button
import com.vaadin.server.ExternalResource
import scala.collection.JavaConversions._
import hu.bme.mit.incqueryd.yarn.AdvancedYarnClient
import hu.bme.mit.incqueryd.coordinator.client.IQDYarnClient

/**
 * 
 * @author pappi
 * 
 */

class OverviewPanel(devConfig : DevPanelConfiguration, gridPos : GridPosition) extends DeveloperPanel(devConfig, gridPos) {

  val client = new AdvancedYarnClient(IQDYarnClient.DEFAULT_RM_HOST, IQDYarnClient.DEFAULT_HDFS_URL).client
  val applicationReports = client.getApplications
  val nodeReports = client.getNodeReports(NodeState.RUNNING)
  
  val applicationTable = new Table("Applications")
  applicationTable.addContainerProperty("ID", classOf[String], null)
  applicationTable.addContainerProperty("Name", classOf[String], null)
  applicationTable.addContainerProperty("Type", classOf[String], null)
  applicationTable.addContainerProperty("Start time", classOf[Date], null)
  applicationTable.addContainerProperty("Finish time", classOf[Date], null)
  applicationTable.addContainerProperty("State", classOf[String], null)  
  applicationTable.addContainerProperty("Final status", classOf[String], null)
  applicationTable.addContainerProperty("Progress", classOf[ProgressBar], null)
  applicationTable.addContainerProperty("Tracking UI", classOf[Link], null)
  applicationTable.addContainerProperty("View logs", classOf[Button], null)
  applicationTable.addContainerProperty("Kill", classOf[Button], null)

  applicationReports.foreach { application =>
    val id = application.getApplicationId
    val name = application.getName
    val appType = application.getApplicationType
    val startTime = new Date(application.getStartTime)
    val finishTime = new Date(application.getFinishTime)
    val state = application.getYarnApplicationState.toString
    val finalStatus = application.getFinalApplicationStatus.toString
    val progress = new ProgressBar(application.getProgress)
    val trackingLink = link(application.getTrackingUrl)
    val viewLogs = new Button("View logs")
    val kill = new Button("Kill")
    applicationTable.addItem(Array(id, name, appType, startTime, finishTime, state, finalStatus, progress, trackingLink, viewLogs, kill), id)
  }
  
  def link(url: String) = new Link(url, new ExternalResource(url))
  
  val nodeTable = new Table("Nodes")
  nodeTable.addContainerProperty("ID", classOf[String], null)
  nodeTable.addContainerProperty("HTTP address", classOf[Link], null)
  nodeTable.addContainerProperty("Containers", classOf[Integer], null)
  nodeTable.addContainerProperty("Memory used", classOf[Integer], null)
  nodeTable.addContainerProperty("Memory available", classOf[Integer], null)
  nodeTable.addContainerProperty("Virtual cores used", classOf[Integer], null)
  nodeTable.addContainerProperty("Virtual cores available", classOf[Integer], null)

  nodeReports.foreach { node =>
    val id = node.getNodeId.toString
    val httpAddress = link(node.getHttpAddress)
    val numContainers: Integer = node.getNumContainers
    val memoryUsed: Integer = node.getUsed.getMemory
    val memoryAvailable: Integer = node.getCapability.getMemory
    val virtualCoresUsed: Integer = node.getUsed.getVirtualCores
    val virtualCoresAvailable: Integer = node.getCapability.getVirtualCores
    nodeTable.addItem(Array(id, httpAddress, numContainers, memoryUsed, memoryAvailable, virtualCoresUsed, virtualCoresAvailable), id)
  }
  
  val panelContent = new VerticalSplitPanel(applicationTable, nodeTable)
  setContent(panelContent)
}
