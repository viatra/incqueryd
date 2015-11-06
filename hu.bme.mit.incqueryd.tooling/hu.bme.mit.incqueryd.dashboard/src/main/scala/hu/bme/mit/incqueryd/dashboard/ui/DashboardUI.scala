package hu.bme.mit.incqueryd.dashboard.ui

import scala.collection.mutable.HashMap
import org.vaadin.jouni.animator.Animator
import org.vaadin.jouni.dom.client.Css
import com.vaadin.annotations.Push
import com.vaadin.annotations.Theme
import com.vaadin.annotations.VaadinServletConfiguration
import com.vaadin.annotations.Widgetset
import com.vaadin.server.Sizeable.Unit
import com.vaadin.server.VaadinRequest
import com.vaadin.server.VaadinServlet
import com.vaadin.ui.AbsoluteLayout
import com.vaadin.ui.Alignment
import com.vaadin.ui.Button
import com.vaadin.ui.Button.ClickEvent
import com.vaadin.ui.Button.ClickListener
import com.vaadin.ui.HorizontalLayout
import com.vaadin.ui.Label
import com.vaadin.ui.OptionGroup
import com.vaadin.ui.Panel
import com.vaadin.ui.UI
import com.vaadin.ui.VerticalLayout
import com.vaadin.ui.themes.ValoTheme
import hu.bme.mit.incqueryd.dashboard.controller.DashboardController
import hu.bme.mit.incqueryd.dashboard.panels.FreezePanel
import hu.bme.mit.incqueryd.dashboard.ui.UIHelper.buildResultPanel
import hu.bme.mit.incqueryd.dashboard.ui.UIHelper.initializePatternButton
import hu.bme.mit.incqueryd.dashboard.ui.UIHelper.initializeQueryPanel
import hu.bme.mit.incqueryd.dashboard.utils.DashboardUtils.createPatternId
import hu.bme.mit.incqueryd.dashboard.utils.DashboardUtils.resolvePattern
import hu.bme.mit.incqueryd.dashboard.utils.DashboardUtils.resolveQuery
import com.vaadin.server.ThemeResource
import com.vaadin.ui.Image
import javax.servlet.annotation.WebServlet

/**
 * @author pappi
 */

@Theme("iqdtheme")
@Push
@Widgetset("hu.bme.mit.incqueryd.IQDWidgetset")
class DashboardUI extends UI with UIBroadcaster.MessageListener {

  val streamBtn = new Button("Body")
  val headerLabel = new Label("IncQuery-D Wikidata Demo")
  val footerLabel = new Label("Powered by IncQuery Labs Ltd.")
  
  
  // Display mode
   val displayMode = new OptionGroup
   
  // Stream 
  val streamLayout = new VerticalLayout
  val streamPanel = new Panel
  
  // Pattern selection
  val queriesLayout = new VerticalLayout
  
  var queryPanels: HashMap[String, Panel] = HashMap[String, Panel]()
  var patternBtns: HashMap[String, Button] = HashMap[String, Button]()
  var selectedPatternId: String = _

  var freezed : Boolean = false
  
  def setFreezed(value : Boolean) {
    freezed = value;
  }
  
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
    headerLabel.setStyleName("headerlabel")
  }
  
  def initLayout() {
    
    // Header
    val headerPanel = new Panel
    headerPanel.setStyleName("headerpanel")
    val headerLayout = new HorizontalLayout
    headerLayout.setSizeFull()
    headerLayout.addComponent(headerLabel)
    headerLayout.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER)
    headerPanel.setHeight(50.0f, Unit.PIXELS)
    headerPanel.setWidth(99.0f, Unit.PERCENTAGE)
    headerPanel.setContent(headerLayout)
    
    // Settings panel
    val settingsPanel = new Panel
    settingsPanel.setStyleName("dashsettings")
    
   
    displayMode.setStyleName("horizontal")
    val modeLabel = new Label("Display: ")
    modeLabel.setStyleName("dashmodelabel")
    settingsPanel.setHeight(40.0f, Unit.PIXELS)
    settingsPanel.setWidth(99.0f, Unit.PERCENTAGE)

    displayMode.addItems(ALLCHANGES, POSITIVECHANGES, NEGATIVECHANGES)
    
    displayMode.select(ALLCHANGES)
    displayMode.setItemCaption(ALLCHANGES, "All changes")
    displayMode.setItemCaption(POSITIVECHANGES, "Positive changes")
    displayMode.setItemCaption(NEGATIVECHANGES, "Negative changes")
    
    val settingsLayout = new HorizontalLayout
    
    settingsLayout.setHeight(100.0f, Unit.PERCENTAGE)
    settingsLayout.setDefaultComponentAlignment(Alignment.MIDDLE_LEFT)
    settingsLayout.addComponent(modeLabel)
    settingsLayout.addComponent(displayMode)
    settingsPanel.setContent(settingsLayout)
    
    // Queries panel
    val queriesPanel = new Panel("Queries")
    queriesPanel.setContent(queriesLayout)
    queriesPanel.setWidth(280.0f, Unit.PIXELS)
    queriesPanel.setStyleName("queriespanel")

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
    streamPanel.setStyleName("stream")
    streamPanel.setContent(streamLayout)
    streamPanel.setHeight(100.0f, Unit.PERCENTAGE)
    streamPanel.setWidth(99.0f, Unit.PERCENTAGE)
    
    // Main
    val mainPanel = new Panel("IncQuery-D Dashboard")
    val mainLayout = new AbsoluteLayout
    mainLayout.setSizeFull
    mainLayout.addComponent(new FreezePanel(this), "bottom: 50; right: 50")
    mainLayout.addComponent(headerPanel, "top: 0px; left: 10px")
    mainLayout.addComponent(settingsPanel, "top: 50px; left: 300px;")
    mainLayout.addComponent(streamPanel, "top: 90px; left: 300px;")
    mainLayout.addComponent(queriesPanel, "top: 50px; left: 10px;")
    
    
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
            if (patternId.equals(selectedPatternId) && !freezed) {
              val mode = displayMode.getValue.asInstanceOf[DisplayMode]
              
              if(mode == ALLCHANGES || 
                  (mode == POSITIVECHANGES && newTuples.size > 0) || 
                  (mode == NEGATIVECHANGES && removedTuples.size > 0)) {
                
                val resultPanel = buildResultPanel(resolvePattern(patternId), result, newTuples, removedTuples)
              
                val resultpanelIt = streamLayout.iterator()

                streamLayout.addComponentAsFirst(resultPanel)
                Animator.animate(resultPanel, new Css().opacity(1)).duration(1000)
              }
            }
          }
        })
      }
    }
  }

  override def init(request: VaadinRequest) {
    
    DashboardController.initialize()
    
    println("Dashboard initialization started...")
    configureWidgets
    
    initLayout
    
    if(patternBtns.size > 0)
      selectPattern(patternBtns.keySet.head)
    
    UIBroadcaster.addListener(this)
  }

  override def detach() {
    UIBroadcaster.removeListener(this)
    super.detach()
  }

}

sealed trait DisplayMode
case object ALLCHANGES extends DisplayMode
case object NEGATIVECHANGES extends DisplayMode
case object POSITIVECHANGES extends DisplayMode

class QueryPanelClickListener extends com.vaadin.event.MouseEvents.ClickListener {
  override def click(clickEvent : com.vaadin.event.MouseEvents.ClickEvent) {
    println("Panel clicked!")
  }
}

@VaadinServletConfiguration(ui = classOf[DashboardUI], productionMode = false)
class DashboardUIServlet extends VaadinServlet {}
