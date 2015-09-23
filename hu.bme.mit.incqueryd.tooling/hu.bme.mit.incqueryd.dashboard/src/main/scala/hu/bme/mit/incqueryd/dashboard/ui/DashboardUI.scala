package hu.bme.mit.incqueryd.dashboard.ui

import com.vaadin.annotations.Theme
import com.vaadin.annotations.VaadinServletConfiguration
import com.vaadin.data.util.IndexedContainer
import com.vaadin.server.VaadinRequest
import com.vaadin.server.VaadinServlet
import com.vaadin.ui.Alignment
import com.vaadin.ui.Button
import com.vaadin.ui.HorizontalLayout
import com.vaadin.ui.Label
import com.vaadin.ui.UI
import com.vaadin.ui.VerticalLayout
import hu.bme.mit.incqueryd.dashboard.controller.DashboardController
import hu.bme.mit.incqueryd.dashboard.ui.UIHelper._
import javax.servlet.annotation.WebInitParam
import javax.servlet.annotation.WebServlet
import scala.collection.JavaConverters._
import com.vaadin.annotations.Push
import com.codahale.metrics.Metric
import com.vaadin.ui.Panel
import com.vaadin.ui.Grid.Header
import com.vaadin.addon.charts.model.style.Style
import com.vaadin.ui.themes.ValoTheme
import com.vaadin.ui.themes.Runo

/**
 * @author pappi
 */

@Theme("valo")
@Push
class DashboardUI extends UI with UIBroadcaster.MessageListener {

  val headLabel = new Label("TeqBox Web Console");

  val streamBtn = new Button("Body")
  val headerLabel = new Label("IncQuery-D Dashboard")
  val footerLabel = new Label("Powered by IncQuery Labs Ltd.")
  val metricsPanel = new Panel("Metrics")

  // Stream 
  val streamLayout = new VerticalLayout
  val streamPanel = new Panel

  // Query selection layout
  val queriesLayout = new VerticalLayout

  def configureWidgets() {
    headerLabel.setSizeFull()
    headerLabel.setStyleName(ValoTheme.LABEL_H2)
  }

  def initLayout() {
    
    // Header panel
    val headerPanel = new Panel(headerLabel)
    headerPanel.setStyleName(Runo.PANEL_LIGHT)
    headerPanel.setSizeFull()
    
    // Queries panel
    val queries = DashboardController.getRunningQueries()
    queries.foreach { query => queriesLayout.addComponent(initializeQueryButton(new Button(query))) }

    // Stream data layout
    streamPanel.setSizeFull()
    streamPanel.setContent(streamLayout)

    // Metrics
    metricsPanel.setSizeFull()
    
    // Body
    val bodyLayout = new HorizontalLayout(queriesLayout, streamPanel, metricsPanel)
    bodyLayout.setSizeFull
    bodyLayout.setExpandRatio(queriesLayout, 1)
    bodyLayout.setExpandRatio(streamPanel, 6)
    bodyLayout.setExpandRatio(metricsPanel, 3)
    bodyLayout.setComponentAlignment(queriesLayout, Alignment.TOP_CENTER)
    bodyLayout.setComponentAlignment(streamPanel, Alignment.TOP_CENTER)
    bodyLayout.setComponentAlignment(metricsPanel, Alignment.TOP_CENTER)

    // Main
    val mainPanel = new Panel("IncQuery-D Dashboard")
    val mainLayout = new VerticalLayout(headerPanel, bodyLayout, footerLabel)
    mainLayout.setSizeFull
    mainLayout.setExpandRatio(headerPanel, 2)
    mainLayout.setExpandRatio(bodyLayout, 16)
    mainLayout.setExpandRatio(footerLabel, 1)
    mainLayout.setComponentAlignment(headerPanel, Alignment.TOP_CENTER)
    mainLayout.setComponentAlignment(bodyLayout, Alignment.MIDDLE_CENTER)
    mainLayout.setComponentAlignment(footerLabel, Alignment.MIDDLE_CENTER)
    setContent(mainLayout)

  }

  def messageReceived(msg: UIMessage) {
    msg match {
      case AddQuery(query) => {
        access(new Runnable() {
          override def run() {
            queriesLayout.addComponent(initializeQueryButton(new Button(query)))
          }
        })
      }
      case RemoveQuery(query) => {
        // TODO: implement it!
      }
      case QueryResult(queryName, result, newTuples, removedTuples) => {
        access(new Runnable() {
          override def run() {
            streamLayout.addComponentAsFirst(buildResultPanel(result, newTuples, removedTuples))
          }
        })
      }
    }
  }

  override def init(request: VaadinRequest) {
    println("Dashboard initialization started...")
    configureWidgets

    initLayout

    UIBroadcaster.addListener(this)
  }

  override def detach() {
    UIBroadcaster.removeListener(this)
    super.detach()
  }

}

@WebServlet(urlPatterns = Array("/*"))
@VaadinServletConfiguration(ui = classOf[DashboardUI], productionMode = false)
class DashboardUIServlet extends VaadinServlet {}
