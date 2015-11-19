package hu.bme.mit.incqueryd.dashboard.panels

import java.util.Date
import java.util.Timer
import java.util.TimerTask

import scala.collection.JavaConversions.asScalaBuffer

import org.apache.hadoop.yarn.api.records.ApplicationId
import org.apache.hadoop.yarn.api.records.ContainerReport
import org.apache.hadoop.yarn.api.records.ContainerState
import org.apache.hadoop.yarn.api.records.NodeState
import org.apache.hadoop.yarn.client.api.YarnClient
import org.apache.log4j.helpers.ISO8601DateFormat

import com.vaadin.server.ExternalResource
import com.vaadin.server.Sizeable.Unit
import com.vaadin.ui.AbstractComponent
import com.vaadin.ui.Button
import com.vaadin.ui.Button.ClickEvent
import com.vaadin.ui.Button.ClickListener
import com.vaadin.ui.HorizontalLayout
import com.vaadin.ui.Label
import com.vaadin.ui.Link
import com.vaadin.ui.ProgressBar
import com.vaadin.ui.TreeTable
import com.vaadin.ui.UI
import com.vaadin.ui.VerticalSplitPanel
import com.vaadin.ui.Window.CloseEvent
import com.vaadin.ui.Window.CloseListener

import hu.bme.mit.incqueryd.coordinator.client.IQDYarnClient
import hu.bme.mit.incqueryd.dashboard.controller.LogController
import hu.bme.mit.incqueryd.dashboard.dev.DevPanelConfiguration
import hu.bme.mit.incqueryd.dashboard.dev.DevPanelConfiguration
import hu.bme.mit.incqueryd.dashboard.dev.LOG
import hu.bme.mit.incqueryd.dashboard.dev.PanelPositionAndSize
import hu.bme.mit.incqueryd.dashboard.ui.DeveloperUI
import hu.bme.mit.incqueryd.yarn.AdvancedYarnClient
import org.apache.hadoop.yarn.api.records.ApplicationAttemptReport
import org.apache.hadoop.yarn.api.records.YarnApplicationAttemptState

/**
 * 
 * @author pappi
 * 
 */

class OverviewPanel(devConfig : DevPanelConfiguration) extends DeveloperPanel(devConfig) {

  val client = new AdvancedYarnClient(IQDYarnClient.DEFAULT_RM_HOST, IQDYarnClient.DEFAULT_HDFS_URL).client

  val applicationTable = treeTable("Applications")
  applicationTable.setSizeFull()
  val idPropertyId = "ID"
  applicationTable.addContainerProperty(idPropertyId, classOf[String], null)
  applicationTable.addContainerProperty("Name", classOf[String], null)
  applicationTable.addContainerProperty("Type", classOf[String], null)
  applicationTable.addContainerProperty("Start time", classOf[String], null)
  applicationTable.addContainerProperty("Finish time", classOf[String], null)
  applicationTable.addContainerProperty("State", classOf[String], null)  
  applicationTable.addContainerProperty("Final status", classOf[String], null)
  applicationTable.addContainerProperty("Progress", classOf[ProgressBar], null)
  applicationTable.addContainerProperty("Tracking UI", classOf[Link], null)
  applicationTable.addContainerProperty("View logs", classOf[AbstractComponent], null)
  applicationTable.addContainerProperty("Actions", classOf[AbstractComponent], null)
  applicationTable.setSortContainerPropertyId(idPropertyId)
  
  val nodeTable = treeTable("Nodes")
  nodeTable.addContainerProperty(idPropertyId, classOf[String], null)
  nodeTable.addContainerProperty("HTTP address", classOf[Link], null)
  nodeTable.addContainerProperty("Containers", classOf[Integer], null)
  nodeTable.addContainerProperty("Memory used", classOf[Integer], null)
  nodeTable.addContainerProperty("Memory available", classOf[Integer], null)
  nodeTable.addContainerProperty("Virtual cores used", classOf[Integer], null)
  nodeTable.addContainerProperty("Virtual cores available", classOf[Integer], null)
  nodeTable.setSortContainerPropertyId(idPropertyId)
  
  val panelContent = new VerticalSplitPanel(new HorizontalLayout(applicationTable), new HorizontalLayout(nodeTable)) // workaround for https://dev.vaadin.com/ticket/11055
  panelContent.setSplitPosition(75, Unit.PERCENTAGE)
  setContent(panelContent)
  refreshTables()
  val refreshingTimer = new Timer()
  refreshingTimer.scheduleAtFixedRate(new TimerTask() {
    override def run() {
      refreshTables()
    }
  }, 0, 5 * 1000)
  addCloseListener(new CloseListener() {
    override def windowClose(event: CloseEvent) {
      refreshingTimer.cancel()
    }
  })

  def refreshTables() {
    UI.getCurrent.access(new Runnable() {
      override def run() {
      	applicationTable.removeAllItems()
      	client.getApplications.foreach { application =>
        	val applicationId: String = application.getApplicationId.toString
        	val name: String = application.getName
        	val appType: String = application.getApplicationType
        	val startTime: String = displayTimestamp(application.getStartTime)
        	val finishTime: String = displayTimestamp(application.getFinishTime)
        	val state: String = application.getYarnApplicationState.toString
        	val finalStatus: String = application.getFinalApplicationStatus.toString
        	val progress: ProgressBar = new ProgressBar(application.getProgress)
        	val trackingLink: Link = link("Application", application.getTrackingUrl)
        	val viewLogs: AbstractComponent = new Label
        	val actions: AbstractComponent = killButton(application.getApplicationId)
        	applicationTable.addItem(Array(applicationId, name, appType, startTime, finishTime, state, finalStatus, progress, trackingLink, viewLogs, actions), applicationId)
        	client.getContainers(application.getCurrentApplicationAttemptId).foreach { container =>
        	  val containerId: String = container.getContainerId.toString
        	  val containerName: String = s"Container on ${container.getAssignedNode}"
        	  val containerStartTime: String = displayTimestamp(container.getCreationTime)
        	  val containerFinishTime: String = displayTimestamp(container.getFinishTime)
        	  val containerState: String = container.getContainerState.toString
        	  val containerFinalStatus: String = getFinalStatus(container)
        	  val containerProgress: ProgressBar = new ProgressBar(getProgress(container))
        	  val containerTrackingLink: Link = link("Container", getTrackingUrl(container, client))
        	  val containerViewLogs: AbstractComponent = getLogPaths(applicationId, containerId)
        	  containerViewLogs.setWidth(100.0f, Unit.PIXELS)
        	  val containerActions: AbstractComponent = new Label()
        	  applicationTable.addItem(Array(containerId, containerName, appType, containerStartTime, containerFinishTime, containerState, containerFinalStatus, containerProgress, containerTrackingLink, containerViewLogs, containerActions), containerId)
        	  applicationTable.setParent(containerId, applicationId)
        	}
      	}
      	applicationTable.sort()

      	nodeTable.removeAllItems()
      	val containers = client.getApplications.flatMap { application => client.getContainers(application.getCurrentApplicationAttemptId) }
      	client.getNodeReports(NodeState.RUNNING).foreach { node =>
        	val nodeId: String = node.getNodeId.toString
        	val httpAddress: Link = link("Node", node.getHttpAddress)
        	val numContainers: Integer = node.getNumContainers
        	val memoryUsed: Integer = node.getUsed.getMemory
        	val memoryAvailable: Integer = node.getCapability.getMemory
        	val virtualCoresUsed: Integer = node.getUsed.getVirtualCores
        	val virtualCoresAvailable: Integer = node.getCapability.getVirtualCores
        	nodeTable.addItem(Array(nodeId, httpAddress, numContainers, memoryUsed, memoryAvailable, virtualCoresUsed, virtualCoresAvailable), nodeId)
        	containers.filter { container => container.getAssignedNode.toString == nodeId }.foreach { container =>
        	  val containerId: String = container.getContainerId.toString
          	val containerHttpAddress: Link = link("Container", getTrackingUrl(container, client))
          	val containerNumContainers: Integer = 1
          	val containerMemoryUsed: Integer = container.getAllocatedResource.getMemory
          	val containerVirtualCoresUsed: Integer = container.getAllocatedResource.getVirtualCores
          	nodeTable.addItem(Array(containerId, containerHttpAddress, containerNumContainers, containerMemoryUsed, memoryAvailable, containerVirtualCoresUsed, virtualCoresAvailable), containerId)
          	nodeTable.setParent(containerId, nodeId)
        	}
      	}
      	nodeTable.sort()
      }
    })
  }
  
  def treeTable(caption: String): TreeTable = {
    val treeTable = new TreeTable(caption)
    treeTable.setColumnReorderingAllowed(true)
    treeTable
  }

  def killButton(applicationId: ApplicationId) = {
    val button = new Button("Kill")
    button.addClickListener(new ClickListener() {
      override def buttonClick(clickEvent : ClickEvent) {
        client.killApplication(applicationId)
        refreshTables()
      }
    })
    button
  }

  def displayTimestamp(timestamp: Long): String = {
    if (timestamp == 0) "N/A" else new ISO8601DateFormat().format(new Date(timestamp))
  }

  def link(caption: String, url: String): Link = {
    val link = new Link(caption, new ExternalResource(url))
    link.setTargetName("_blank");
    link
  }

  def getFinalStatus(container: ContainerReport): String = {
    container.getContainerState match {
      case ContainerState.COMPLETE => container.getContainerExitStatus.toString
      case _ => "N/A"
    }
  }

  def getProgress(container: ContainerReport): Float = {
    container.getContainerState match {
      case ContainerState.NEW => 0
      case ContainerState.RUNNING => 0.5f
      case ContainerState.COMPLETE => 1
    }
  }
  
  def getTrackingUrl(container: ContainerReport, client: YarnClient): String = { // XXX
    val nodeId = container.getAssignedNode
    val nodeOption = client.getNodeReports(NodeState.RUNNING).find { node => node.getNodeId == nodeId }
    nodeOption
      .map { node => s"http://${node.getHttpAddress}/node/container/${container.getContainerId}" }
      .getOrElse(container.getLogUrl)
  }

  def getLogPaths(applicationId : String, containerId : String) = {
    val stdout = getLogButton(s"${LogController.HDFS_LOG_MOUNT_POINT}/$applicationId/$containerId/stdout", "stdout")
    val stderr = getLogButton(s"${LogController.HDFS_LOG_MOUNT_POINT}/$applicationId/$containerId/stderr", "stderr")
    new HorizontalLayout(stdout, stderr)
  }
  
  def getLogButton(logPath : String, name : String) : Button = {
    val button = new Button(name)
    button.addClickListener(new ClickListener {
      override def buttonClick(clickEvent : ClickEvent) {
        addLogPanel(logPath)
      }
    })
    button
  }
  
  def addLogPanel(logPath : String) = {
      val devConf = new DevPanelConfiguration("LOG", LOG, logPath, PanelPositionAndSize(getPositionX + 100, getPositionY + 100, 300, 300))
		  this.getUI().asInstanceOf[DeveloperUI].createDeveloperPanel(devConf)
  }
  
  def getLogLinks(logUrl: String) = {
    val stdout = getLogLink(logUrl, "stdout")
    val separator = new Label("/")
    val stderr = getLogLink(logUrl, "stderr")
    new HorizontalLayout(stdout, separator, stderr)
  }

  def getLogLink(logUrl: String, postfix: String): Link = {
    link(postfix, s"$logUrl/$postfix/?start=0")
  }

}
