package hu.bme.mit.incqueryd.dashboard.ui

import com.vaadin.annotations.Push
import com.vaadin.annotations.Theme
import com.vaadin.annotations.VaadinServletConfiguration
import com.vaadin.annotations.Widgetset
import com.vaadin.event.Action
import com.vaadin.event.Action.Handler
import com.vaadin.event.ShortcutAction
import com.vaadin.server.Page
import com.vaadin.server.Page.BrowserWindowResizeEvent
import com.vaadin.server.Page.BrowserWindowResizeListener
import com.vaadin.server.VaadinRequest
import com.vaadin.server.VaadinServlet
import com.vaadin.ui.Alignment
import com.vaadin.ui.GridLayout
import com.vaadin.ui.PopupView
import com.vaadin.ui.UI
import hu.bme.mit.incqueryd.dashboard.controller.DevDashboardController
import hu.bme.mit.incqueryd.dashboard.dev.DevPanelCloseListener
import hu.bme.mit.incqueryd.dashboard.dev.DevPanelConfiguration
import hu.bme.mit.incqueryd.dashboard.dev.DeveloperPanelType
import hu.bme.mit.incqueryd.dashboard.dev.LOG
import hu.bme.mit.incqueryd.dashboard.dev.OVERVIEW
import hu.bme.mit.incqueryd.dashboard.panels.AddDevPanelPopup
import hu.bme.mit.incqueryd.dashboard.panels.DeveloperPanel
import hu.bme.mit.incqueryd.dashboard.panels.LogPanel
import hu.bme.mit.incqueryd.dashboard.panels.OpenConfigPanel
import hu.bme.mit.incqueryd.dashboard.panels.OverviewPanel
import hu.bme.mit.incqueryd.dashboard.panels.SaveConfigPanel
import com.vaadin.ui.AbsoluteLayout
import com.vaadin.event.LayoutEvents.LayoutClickListener
import com.vaadin.event.LayoutEvents.LayoutClickEvent
import hu.bme.mit.incqueryd.dashboard.dev.PanelPositionAndSize

/**
 * @author pappi
 */
@Theme("iqdtheme")
@Push
@Widgetset("hu.bme.mit.incqueryd.IQDWidgetset")
class DeveloperUI extends UI with Handler {

  val mainLayout = new AbsoluteLayout

  val load_config_action = new ShortcutAction("Load config", ShortcutAction.KeyCode.O, Seq(ShortcutAction.ModifierKey.CTRL): _*)

  val save_config_action = new ShortcutAction("Save config", ShortcutAction.KeyCode.S, Seq(ShortcutAction.ModifierKey.CTRL): _*)
  
  var popupView : AddDevPanelPopup = _
  
  var devPanels : Set[DeveloperPanel] = _
  var gridConfiguration: Set[DevPanelConfiguration] = _;
    
  def createDeveloperPanel(devPanelConf: DevPanelConfiguration) = {
    val devPanelOption = devPanelConf.panelType match {
      case OVERVIEW => Some(new OverviewPanel(devPanelConf))
      case LOG => Some(new LogPanel(devPanelConf))
      case _ => None
    }
    devPanelOption.foreach { devPanel =>
      devPanel.addActionHandler(this)
      devPanel.updatePositionAndSize()
      addWindow(devPanel)
      devPanel.focus()
      devPanel.addCloseListener(new DevPanelCloseListener(devPanel, this))
      registerDeveloperPanel(devPanel)
    }
  }

  def registerDeveloperPanel(devPanel: DeveloperPanel) {
    devPanels += devPanel
    gridConfiguration += devPanel.devConfig
    getSession.setAttribute("config", gridConfiguration)
  }

  def unregisterDeveloperPanel(devPanel: DeveloperPanel) {
    gridConfiguration -= devPanel.devConfig
    getSession.setAttribute("config", gridConfiguration)
  }

  override def init(request: VaadinRequest) {

    gridConfiguration = getSession.getAttribute("config").asInstanceOf[Set[DevPanelConfiguration]]
    if (gridConfiguration == null) {
      gridConfiguration = Set[DevPanelConfiguration]()
    }

    devPanels = Set[DeveloperPanel]()
    
    mainLayout.setSizeFull()
    
    gridConfiguration.foreach { devPanelConf => 
        createDeveloperPanel(devPanelConf)
    }
    
    popupView = new AddDevPanelPopup(this)
    mainLayout.addComponent(popupView, "top: 50%; left: 50%")
    mainLayout.addLayoutClickListener(new LayoutClickListener() {
      override def layoutClick( event : LayoutClickEvent) {
        println("Layout clicked!")
        mainLayout.removeComponent(popupView)
        mainLayout.addComponent(popupView, s"top: ${event.getClientY}px; left: ${event.getClientX}px")
        popupView.showPopup(PanelPositionAndSize(event.getClientX - 50, event.getClientY - 50, DeveloperPanel.DEFAULT_SIZE_X, DeveloperPanel.DEFAULT_SIZE_Y))
      }
    })

    Page.getCurrent().addBrowserWindowResizeListener(new BrowserWindowResizeListener() {
      override def browserWindowResized(event: BrowserWindowResizeEvent) {
        val windowsIt = UI.getCurrent.getWindows.iterator()
        while (windowsIt.hasNext()) {
          val window = windowsIt.next()
          if (window.isInstanceOf[DeveloperPanel])
            window.asInstanceOf[DeveloperPanel].updatePositionAndSize()
        }
      }
    })

    addActionHandler(this);
    setContent(mainLayout)

  }

  def reload() {
    getSession.setAttribute("config", gridConfiguration)
    Page.getCurrent.reload();
  }

  override def getActions(target: Any, sender: Any): Array[Action] = {
    Array(load_config_action, save_config_action)
  }

  override def handleAction(action: Action, sender: Any, target: Any) {
    if (action == load_config_action) {
      addWindow(new OpenConfigPanel(this))
    }
    if (action == save_config_action) {
      addWindow(new SaveConfigPanel(this))
    }
  }

}

@VaadinServletConfiguration(ui = classOf[DeveloperUI], productionMode = false)
class DeveloperUIServlet extends VaadinServlet {}
