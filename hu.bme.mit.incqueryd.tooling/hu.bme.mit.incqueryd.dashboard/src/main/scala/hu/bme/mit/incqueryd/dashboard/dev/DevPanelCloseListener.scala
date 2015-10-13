package hu.bme.mit.incqueryd.dashboard.dev

import com.vaadin.ui.Window.CloseListener
import com.vaadin.ui.Window.CloseEvent
import com.vaadin.ui.PopupView


/**
 * @author pappi
 */
class DevPanelCloseListener(popupView : PopupView) extends CloseListener {
  
  override def windowClose(windowClose : CloseEvent) {
    popupView.setVisible(true)
    popupView.setPopupVisible(false);
  }

}