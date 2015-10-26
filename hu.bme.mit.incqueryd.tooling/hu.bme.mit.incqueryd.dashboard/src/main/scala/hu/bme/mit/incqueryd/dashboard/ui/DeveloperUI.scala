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
import com.vaadin.ui.HorizontalLayout
import com.vaadin.ui.Notification
import com.vaadin.ui.UI
import hu.bme.mit.incqueryd.dashboard.controller.DevDashboardController
import hu.bme.mit.incqueryd.dashboard.dev.DevPanelCloseListener
import hu.bme.mit.incqueryd.dashboard.dev.DevPanelConfiguration
import hu.bme.mit.incqueryd.dashboard.dev.GridPosition
import hu.bme.mit.incqueryd.dashboard.panels.AddDevPanelPopup
import hu.bme.mit.incqueryd.dashboard.panels.DeveloperPanel
import hu.bme.mit.incqueryd.dashboard.panels.OpenConfigPanel
import hu.bme.mit.incqueryd.dashboard.panels.SaveConfigPanel
import hu.bme.mit.incqueryd.dashboard.utils.DashboardUtils
import hu.bme.mit.incqueryd.dashboard.dev.DeveloperPanelType
import hu.bme.mit.incqueryd.dashboard.dev.DASHBOARD
import hu.bme.mit.incqueryd.dashboard.dev.OVERVIEW
import hu.bme.mit.incqueryd.dashboard.panels.OverviewPanel
import com.vaadin.ui.PopupView
import javax.servlet.annotation.WebServlet

/**
 * @author pappi
 */
@Theme("iqdtheme")
@Push
@Widgetset("hu.bme.mit.incqueryd.IQDWidgetset")
class DeveloperUI extends UI with Handler {

  val gridLayout = new GridLayout(DevDashboardController.GRID_COLS, DevDashboardController.GRID_ROWS)

  val load_config_action = new ShortcutAction("Load config", ShortcutAction.KeyCode.O, Seq(ShortcutAction.ModifierKey.CTRL): _*)

  val save_config_action = new ShortcutAction("Save config", ShortcutAction.KeyCode.S, Seq(ShortcutAction.ModifierKey.CTRL): _*)

  var gridConfiguration: Map[GridPosition, DevPanelConfiguration] = _;

  def createDeveloperPanel(devPanelConf: DevPanelConfiguration, gridPos: GridPosition, popupView: PopupView) = {
    val devPanelOption = devPanelConf.panelType match {
      case OVERVIEW => Some(new OverviewPanel(devPanelConf, gridPos))
      case _ => None
    }
    devPanelOption.foreach { devPanel =>
      devPanel.addActionHandler(this)
      devPanel.updatePositionAndSize()
      addWindow(devPanel)
      devPanel.focus()
      devPanel.addCloseListener(new DevPanelCloseListener(devPanel, this, popupView))
    }
  }

  def registerDeveloperPanel(panelConf: DevPanelConfiguration, gridPos: GridPosition) {
    gridConfiguration += gridPos -> panelConf
    getSession.setAttribute("config", gridConfiguration)
  }

  def unregisterDeveloperPanel(devPanel: DeveloperPanel) {
    gridConfiguration -= devPanel.gridPosition
    getSession.setAttribute("config", gridConfiguration)
  }

  override def init(request: VaadinRequest) {

    gridConfiguration = getSession.getAttribute("config").asInstanceOf[Map[GridPosition, DevPanelConfiguration]]
    if (gridConfiguration == null) {
      gridConfiguration = Map[GridPosition, DevPanelConfiguration]()
    }

    gridLayout.setSizeFull()
    gridLayout.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER)

    for (rowNum <- 0 to DevDashboardController.GRID_ROWS - 1)
      for (colNum <- 0 to DevDashboardController.GRID_COLS - 1) {
        val gridPos = GridPosition(rowNum, colNum)
        val devPanelConf = gridConfiguration.get(gridPos)
        val popupView = new AddDevPanelPopup(gridPos, this)
        gridLayout.addComponent(popupView, colNum, rowNum)
        if (!devPanelConf.isEmpty) {
          popupView.setVisible(false)
          createDeveloperPanel(devPanelConf.get, gridPos, popupView)
        }
      }

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
    setContent(gridLayout)

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
