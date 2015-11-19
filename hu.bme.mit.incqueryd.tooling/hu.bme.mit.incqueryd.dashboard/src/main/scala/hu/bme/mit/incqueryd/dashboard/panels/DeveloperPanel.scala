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
import hu.bme.mit.incqueryd.dashboard.dev.LOG
import hu.bme.mit.incqueryd.dashboard.dev.OVERVIEW
import com.vaadin.shared.ui.window.WindowMode
import com.vaadin.ui.UI
import hu.bme.mit.incqueryd.dashboard.dev.DevPanelConfiguration

/**
 * 
 * @author pappi
 * 
 */
abstract class DeveloperPanel(val devConfig : DevPanelConfiguration) extends Window(devConfig.name) {
  
  setClosable(true)
  setResizable(true)
  setDraggable(true)
  
  setStyleName("devpanel")

  def updatePositionAndSize() {

    val panelWidth = Page.getCurrent().getBrowserWindowWidth / DevDashboardController.GRID_COLS
    val panelHeight = Page.getCurrent().getBrowserWindowHeight / DevDashboardController.GRID_ROWS
    
    // XXX calculate position and size in proportion to page size
    super.setPositionX(devConfig.posAndSize.positionX)
    super.setPositionY(devConfig.posAndSize.positionY)
    
    super.setWidth(devConfig.posAndSize.width, Unit.PIXELS)
    super.setHeight(devConfig.posAndSize.height, Unit.PIXELS)
  }
  
  def updateConfPositionAndSize() : DevPanelConfiguration = {
    devConfig.posAndSize.height = super.getHeight
    devConfig.posAndSize.width = super.getWidth
    devConfig.posAndSize.positionX = super.getPositionX
    devConfig.posAndSize.positionY = super.getPositionY
    devConfig
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
  val DEFAULT_SIZE_X = 400
  val DEFAULT_SIZE_Y = 400
  def getTypes() : Set[DeveloperPanelType] = {
    Set(OVERVIEW, DASHBOARD, LOG)
  }
}
