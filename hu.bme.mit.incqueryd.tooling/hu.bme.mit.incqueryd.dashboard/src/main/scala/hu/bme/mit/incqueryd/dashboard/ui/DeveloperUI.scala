package hu.bme.mit.incqueryd.dashboard.ui

import com.vaadin.annotations.Push
import com.vaadin.annotations.Theme
import com.vaadin.annotations.VaadinServletConfiguration
import com.vaadin.server.Page
import com.vaadin.server.Page.BrowserWindowResizeListener
import com.vaadin.server.VaadinRequest
import com.vaadin.server.VaadinServlet
import com.vaadin.shared.ui.window.WindowMode
import com.vaadin.ui.GridLayout
import com.vaadin.ui.UI
import com.vaadin.ui.Window
import com.vaadin.ui.Window.ResizeEvent
import com.vaadin.ui.Window.ResizeListener
import javax.servlet.annotation.WebServlet
import com.vaadin.server.Page.BrowserWindowResizeEvent
import com.vaadin.server.Sizeable.Unit
import hu.bme.mit.incqueryd.dashboard.panels.AddDevPanelPopupContent
import com.vaadin.ui.PopupView
import hu.bme.mit.incqueryd.dashboard.controller.DevDashboardController
import com.vaadin.ui.Alignment
import hu.bme.mit.incqueryd.dashboard.panels.DeveloperPanel
import com.vaadin.ui.Button
import com.vaadin.ui.Button.ClickListener
import com.vaadin.ui.Button.ClickEvent
import hu.bme.mit.incqueryd.dashboard.panels.AddDevPanelPopup
import hu.bme.mit.incqueryd.dashboard.controller.GridItem
import com.vaadin.server.SessionInitListener
import com.vaadin.server.SessionDestroyListener
import com.vaadin.server.SessionInitEvent
import com.vaadin.server.SessionDestroyEvent
import scala.collection.mutable.HashMap
import com.vaadin.ui.VerticalLayout
import hu.bme.mit.incqueryd.dashboard.dev.DevPanelCreator

/**
 * @author pappi
 */
@Theme("valo")
@Push
class DeveloperUI extends UI {
  
  val verticalLayout = new VerticalLayout
  val gridLayout = new GridLayout(DevDashboardController.GRID_COLS, DevDashboardController.GRID_ROWS)
  val panelCreator = new DevPanelCreator
  
  def createDeveloperPanel(name : String, panelType : DeveloperPanel.PanelType, gridRow : Int, gridCol : Int) : DeveloperPanel = {
    panelCreator.createDevPanel(name, panelType, gridRow, gridCol)
  }
  
  override def init(request: VaadinRequest) {
    
    verticalLayout.setSizeFull()
    gridLayout.setSizeFull()
    gridLayout.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER)

    verticalLayout.addComponent(gridLayout)
    verticalLayout.addComponent(panelCreator)
    
    for(rowNum<- 0 to DevDashboardController.GRID_ROWS - 1)
      for(colNum<- 0 to DevDashboardController.GRID_COLS - 1) {
          gridLayout.addComponent(new AddDevPanelPopup(rowNum, colNum, this), colNum, rowNum)
      }

    Page.getCurrent().addBrowserWindowResizeListener(new BrowserWindowResizeListener() {
      override def browserWindowResized(event : BrowserWindowResizeEvent) {
        val windowsIt = UI.getCurrent.getWindows.iterator()
        while(windowsIt.hasNext()) {
          val window = windowsIt.next()
          if(window.isInstanceOf[DeveloperPanel])
           window.asInstanceOf[DeveloperPanel].updatePositionAndSize()
        }
      }
    })
    
    setContent(verticalLayout)

  }

}

@VaadinServletConfiguration(ui = classOf[DeveloperUI], productionMode = false)
class DeveloperUIServlet extends VaadinServlet with SessionInitListener with SessionDestroyListener {
  
  override def servletInitialized() {
    super.servletInitialized();
    getService().addSessionInitListener(this);
    getService().addSessionDestroyListener(this)
  }
  
  override def sessionInit(event : SessionInitEvent) {
    
  }
  
  override def sessionDestroy(event : SessionDestroyEvent) {
    println("Session destroyed: " + event.getSession)
  }
  
  
}
