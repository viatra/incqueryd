package hu.bme.mit.incqueryd.dashboard.dev

import com.vaadin.ui.Window.CloseListener
import com.vaadin.ui.Window.CloseEvent
import com.vaadin.ui.PopupView
import hu.bme.mit.incqueryd.dashboard.ui.DeveloperUI
import hu.bme.mit.incqueryd.dashboard.panels.DeveloperPanel


/**
 * @author pappi
 */
class DevPanelCloseListener(devPanel : DeveloperPanel, devUI : DeveloperUI) extends CloseListener {
  
  override def windowClose(windowClose : CloseEvent) {
    devUI.unregisterDeveloperPanel(devPanel)
    devUI.focus()
  }

}
