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
import hu.bme.mit.incqueryd.dashboard.utils.DashboardUtils._
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
import scala.collection.mutable.HashMap
import scala.collection.mutable.HashSet
import com.vaadin.ui.Button.ClickListener
import com.vaadin.ui.Button.ClickEvent

/**
 * @author pappi
 */

@Theme("valo")
@Push
class DashboardUI extends UI with UIBroadcaster.MessageListener {

  val streamBtn = new Button("Body")
  val headerLabel = new Label("IncQuery-D Dashboard")
  val footerLabel = new Label("Powered by IncQuery Labs Ltd.")
  val metricsPanel = new Panel("Metrics")

  // Stream 
  val streamLayout = new VerticalLayout
  val streamPanel = new Panel

  // Pattern selection
  val queriesLayout = new VerticalLayout
  var queryPanels: HashMap[String, Panel] = HashMap[String, Panel]()
  var patternBtns: HashMap[String, Button] = HashMap[String, Button]()
  var selectedPatternId: String = _

  def selectPattern(patternId: String) {
    streamLayout.removeAllComponents()
    selectedPatternId = patternId;
    patternBtns.foreach {
      case (patternId, button) =>
        if (patternId.equals(selectedPatternId))
          button.setEnabled(false)
        else
          button.setEnabled(true)
    }
  }

  def addPatternButtonListener(button: Button, patternId: String) {
    button.addClickListener(new ClickListener() {
      override def buttonClick(clickEvent: ClickEvent) {
        selectPattern(patternId)
      }
    })
  }

  def configureWidgets() {
    headerLabel.setSizeFull()
    headerLabel.setStyleName(ValoTheme.LABEL_H2)
    headerLabel.setStyleName(ValoTheme.LABEL_BOLD)
  }

  def initLayout() {

    // Header panel
    // XXX not used yet
    val headerPanel = new Panel(headerLabel)
    headerPanel.setSizeFull()

    // Queries panel
    val queriesPanel = new Panel("Queries")
    queriesPanel.setContent(queriesLayout)

    val patternIds = DashboardController.getRunningPatterns()
    patternIds.foreach { patternId =>
      val query = resolveQuery(patternId)
      val pattern = resolvePattern(patternId)
      val queryPanel = queryPanels.getOrElseUpdate(query, initializeQueryPanel(query))
      queryPanel.addStyleName(ValoTheme.PANEL_WELL)
      val patternBtn = patternBtns.getOrElseUpdate(patternId, initializePatternButton(patternId))
      addPatternButtonListener(patternBtn, patternId)
      queryPanel.getContent.asInstanceOf[VerticalLayout].addComponent(patternBtn)
    }

    queryPanels.foreach {
      case (query: String, panel: Panel) =>
        queriesLayout.addComponent(panel)
    }

    // Stream data layout
    streamPanel.setSizeFull()
    streamPanel.setContent(streamLayout)

    // Metrics
    metricsPanel.setSizeFull()

    // Body
    val bodyLayout = new HorizontalLayout(queriesPanel, streamPanel, metricsPanel)
    bodyLayout.setSizeFull
    bodyLayout.setExpandRatio(queriesPanel, 1.2F)
    bodyLayout.setExpandRatio(streamPanel, 6)
    bodyLayout.setExpandRatio(metricsPanel, 3)
    bodyLayout.setComponentAlignment(queriesPanel, Alignment.TOP_CENTER)
    bodyLayout.setComponentAlignment(streamPanel, Alignment.TOP_CENTER)
    bodyLayout.setComponentAlignment(metricsPanel, Alignment.TOP_CENTER)

    // Main
    val mainPanel = new Panel("IncQuery-D Dashboard")
    val mainLayout = new VerticalLayout(headerLabel, bodyLayout, footerLabel)
    mainLayout.setSizeFull
    mainLayout.setExpandRatio(headerLabel, 2)
    mainLayout.setExpandRatio(bodyLayout, 16)
    mainLayout.setExpandRatio(footerLabel, 1)
    mainLayout.setComponentAlignment(headerLabel, Alignment.TOP_CENTER)
    mainLayout.setComponentAlignment(bodyLayout, Alignment.MIDDLE_CENTER)
    mainLayout.setComponentAlignment(footerLabel, Alignment.MIDDLE_CENTER)
    setContent(mainLayout)

  }

  def messageReceived(msg: UIMessage) {
    msg match {
      case AddPattern(pattern, query) => {
        access(new Runnable() {
          override def run() {
            val isNew = !queryPanels.contains(query)
            val patternId = createPatternId(pattern, query)
            val patternBtn = patternBtns.getOrElseUpdate(patternId, initializePatternButton(patternId))
            addPatternButtonListener(patternBtn, patternId)
            val panel = queryPanels.getOrElseUpdate(query, initializeQueryPanel(query))
            panel.getContent.asInstanceOf[VerticalLayout].addComponent(patternBtn)
            if (isNew)
              queriesLayout.addComponent(panel)
          }
        })
      }
      case RemovePattern(pattern, query) => {
        access(new Runnable() {
          override def run() {
            if (patternBtns.contains(createPatternId(pattern, query)) && queryPanels.contains(query)) {
              val patternBtn = patternBtns.get(createPatternId(pattern, query)).get
              val panel = queryPanels.get(query).get
              val layout = panel.getContent.asInstanceOf[VerticalLayout]
              layout.removeComponent(patternBtn)
              patternBtns.remove(pattern)
              if (layout.getComponentCount == 0) {
                queriesLayout.removeComponent(panel)
                queryPanels.remove(query)
              }

            }
          }
        })
      }
      case QueryResult(patternId, result, newTuples, removedTuples) => {
        access(new Runnable() {
          override def run() {
            if (patternId.equals(selectedPatternId))
              streamLayout.addComponentAsFirst(buildResultPanel(resolvePattern(patternId), result, newTuples, removedTuples))
          }
        })
      }
    }
  }

  override def init(request: VaadinRequest) {
    println("Dashboard initialization started...")
    configureWidgets

    initLayout

    selectPattern(patternBtns.keySet.head)
    UIBroadcaster.addListener(this)
  }

  override def detach() {
    UIBroadcaster.removeListener(this)
    super.detach()
  }

}

class QueryPanelClickListener extends com.vaadin.event.MouseEvents.ClickListener {
  override def click(clickEvent : com.vaadin.event.MouseEvents.ClickEvent) {
    println("Panel clicked!")
  }
}

@WebServlet(urlPatterns = Array("/*"))
@VaadinServletConfiguration(ui = classOf[DashboardUI], productionMode = false)
class DashboardUIServlet extends VaadinServlet {}
