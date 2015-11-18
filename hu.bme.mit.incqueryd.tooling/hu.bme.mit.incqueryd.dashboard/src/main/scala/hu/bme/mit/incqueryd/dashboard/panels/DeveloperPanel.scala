package hu.bme.mit.incqueryd.dashboard.panels

import com.vaadin.server.Page
import com.vaadin.server.Sizeable.Unit
import com.vaadin.ui.Window
import com.vaadin.ui.Window.WindowModeChangeEvent
import com.vaadin.ui.Window.WindowModeChangeListener
import hu.bme.mit.incqueryd.dashboard.controller.DevDashboardController
import hu.bme.mit.incqueryd.dashboard.dev.DASHBOARD
import hu.bme.mit.incqueryd.dashboard.dev.DevPanelConfiguration
import hu.bme.mit.incqueryd.dashboard.dev.DeveloperPanelType
import hu.bme.mit.incqueryd.dashboard.dev.GridPosition
import hu.bme.mit.incqueryd.dashboard.dev.LOG
import hu.bme.mit.incqueryd.dashboard.dev.OVERVIEW
import com.vaadin.shared.ui.window.WindowMode
import com.vaadin.ui.UI


/**
 * 
 * @author pappi
 * 
 */

abstract class DeveloperPanel(devConfig : DevPanelConfiguration, val gridPosition : GridPosition) extends Window(devConfig.name) {
  
  setClosable(true)
  setResizable(true)
  setDraggable(false)
  
  setStyleName("devpanel")

  def updatePositionAndSize() {
    
    val panelWidth = Page.getCurrent().getBrowserWindowWidth / DevDashboardController.GRID_COLS
    val panelHeight = Page.getCurrent().getBrowserWindowHeight / DevDashboardController.GRID_ROWS
    
    super.setPositionX(panelWidth * gridPosition.gridCol)
    super.setPositionY(panelHeight * gridPosition.gridRow)
    
    super.setWidth(panelWidth, Unit.PIXELS)
    super.setHeight(panelHeight, Unit.PIXELS)
  }
  
  addWindowModeChangeListener(new WindowModeChangeListener() {
    override def windowModeChanged(event : WindowModeChangeEvent) {
      if(event.getWindowMode == WindowMode.NORMAL) {
        updatePositionAndSize()
      }
    }
  })
}

object DeveloperPanel {
  def getTypes() : Set[DeveloperPanelType] = {
    Set(OVERVIEW, DASHBOARD, LOG)
  }
}
