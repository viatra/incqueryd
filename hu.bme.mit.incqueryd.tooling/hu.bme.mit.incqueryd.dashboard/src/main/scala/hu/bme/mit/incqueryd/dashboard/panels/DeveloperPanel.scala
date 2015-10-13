package hu.bme.mit.incqueryd.dashboard.panels

import com.vaadin.ui.Window
import com.vaadin.server.Page
import hu.bme.mit.incqueryd.dashboard.controller.DevDashboardController
import com.vaadin.server.Sizeable.Unit
import com.vaadin.ui.UI
import com.vaadin.ui.Window.CloseListener
import com.vaadin.ui.Window.CloseEvent
import com.vaadin.shared.ui.window.WindowMode
import com.vaadin.ui.themes.ValoTheme


/**
 * @author pappi
 */
class DeveloperPanel(name : String, panelType : DeveloperPanel.PanelType, gridRow : Int, gridCol : Int) extends Window(name) {
  
  setClosable(true)
  setResizable(false)
  setDraggable(false)
  
  def updatePositionAndSize() {
    
    val panelWidth = Page.getCurrent().getBrowserWindowWidth / DevDashboardController.GRID_COLS
    val panelHeight = Page.getCurrent().getBrowserWindowHeight / DevDashboardController.GRID_ROWS
    
    super.setPositionX(panelWidth * gridCol)
    super.setPositionY(panelHeight * gridRow)
    
    super.setWidth(panelWidth, Unit.PIXELS)
    super.setHeight(panelHeight, Unit.PIXELS)
    
    println(s"Panel: ${gridCol * panelWidth}, ${gridRow * panelHeight}, $panelWidth, $panelHeight")
  }
  
}

object DeveloperPanel extends Enumeration {
   type PanelType = Value
   val OVERVIEW, LOG, DASHBOARD = Value
}