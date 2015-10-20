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
import com.vaadin.ui.Button.ClickListener
import com.vaadin.ui.Button.ClickEvent
import org.apache.hadoop.yarn.api.records.ApplicationId
import com.vaadin.server.Sizeable.Unit
import com.vaadin.ui.Window.CloseListener
import com.vaadin.ui.Window.CloseEvent
import com.vaadin.ui.UI
import com.vaadin.ui.TreeTable
import java.util.TimerTask
import java.util.Timer

/**
 * 
 * @author pappi
 * 
 */

class OverviewPanel(devConfig : DevPanelConfiguration, gridPos : GridPosition) extends DeveloperPanel(devConfig, gridPos) {

  val client = new AdvancedYarnClient(IQDYarnClient.DEFAULT_RM_HOST, IQDYarnClient.DEFAULT_HDFS_URL).client

  val applicationTable = new TreeTable("Applications")
  applicationTable.addContainerProperty("ID", classOf[String], null)
  applicationTable.addContainerProperty("Name", classOf[String], null)
  applicationTable.addContainerProperty("Type", classOf[String], null)
  applicationTable.addContainerProperty("Start time", classOf[String], null)
  applicationTable.addContainerProperty("Finish time", classOf[String], null)
  applicationTable.addContainerProperty("State", classOf[String], null)  
  applicationTable.addContainerProperty("Final status", classOf[String], null)
  applicationTable.addContainerProperty("Progress", classOf[ProgressBar], null)
  applicationTable.addContainerProperty("Tracking UI", classOf[Link], null)
  applicationTable.addContainerProperty("View logs", classOf[Button], null)
  applicationTable.addContainerProperty("Kill", classOf[Button], null)

  val nodeTable = new TreeTable("Nodes")
  nodeTable.addContainerProperty("ID", classOf[String], null)
  nodeTable.addContainerProperty("HTTP address", classOf[Link], null)
  nodeTable.addContainerProperty("Containers", classOf[Integer], null)
  nodeTable.addContainerProperty("Memory used", classOf[Integer], null)
  nodeTable.addContainerProperty("Memory available", classOf[Integer], null)
  nodeTable.addContainerProperty("Virtual cores used", classOf[Integer], null)
  nodeTable.addContainerProperty("Virtual cores available", classOf[Integer], null)
  
  val panelContent = new VerticalSplitPanel(applicationTable, nodeTable)
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
        	val id: String = application.getApplicationId.toString
        	val name: String = application.getName
        	val appType: String = application.getApplicationType
        	val startTime: String = displayTimestamp(application.getStartTime)
        	val finishTime: String = displayTimestamp(application.getFinishTime)
        	val state: String = application.getYarnApplicationState.toString
        	val finalStatus: String = application.getFinalApplicationStatus.toString
        	val progress: ProgressBar = new ProgressBar(application.getProgress)
        	val trackingLink: Link = link(application.getTrackingUrl)
        	val viewLogs: Button = new Button("View logs")
        	val kill: Button = killButton(application.getApplicationId)
        	applicationTable.addItem(Array(id, name, appType, startTime, finishTime, state, finalStatus, progress, trackingLink, viewLogs, kill), id)
      	}
    
      	nodeTable.removeAllItems()
      	client.getNodeReports(NodeState.RUNNING).foreach { node =>
        	val id: String = node.getNodeId.toString
        	val httpAddress: Link = link(node.getHttpAddress)
        	val numContainers: Integer = node.getNumContainers
        	val memoryUsed: Integer = node.getUsed.getMemory
        	val memoryAvailable: Integer = node.getCapability.getMemory
        	val virtualCoresUsed: Integer = node.getUsed.getVirtualCores
        	val virtualCoresAvailable: Integer = node.getCapability.getVirtualCores
        	nodeTable.addItem(Array(id, httpAddress, numContainers, memoryUsed, memoryAvailable, virtualCoresUsed, virtualCoresAvailable), id)
      	}       
      }
    })
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
    if (timestamp == 0) "N/A" else new Date(timestamp).toString()
  }

  def link(url: String) = new Link(url, new ExternalResource(url))

}
