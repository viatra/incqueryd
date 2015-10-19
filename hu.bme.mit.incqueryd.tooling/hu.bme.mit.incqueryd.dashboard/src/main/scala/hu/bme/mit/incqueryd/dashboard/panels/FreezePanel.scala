package hu.bme.mit.incqueryd.dashboard.panels

import com.vaadin.event.MouseEvents.ClickEvent
import com.vaadin.event.MouseEvents.ClickListener
import com.vaadin.server.Sizeable.Unit
import com.vaadin.server.ThemeResource
import com.vaadin.ui.Image
import hu.bme.mit.incqueryd.dashboard.ui.DashboardUI
import com.vaadin.ui.Panel
import com.vaadin.ui.AbsoluteLayout

/**
 * @author pappi
 */
class FreezePanel(dashUI : DashboardUI) extends Panel {
  
  setStyleName("freeze")
  setWidth(64.0f, Unit.PIXELS)
  setHeight(64.0f, Unit.PIXELS)
  val layout = new AbsoluteLayout
  
  val freezeImage = new Image("Freeze", new ThemeResource("../iqdtheme/icons/freeze.png"))
  val continueImage = new Image("Continue", new ThemeResource("../iqdtheme/icons/continue.png"))
  
  freezeImage.setStyleName("freeze")
  continueImage.setStyleName("freeze")
  
  freezeImage.setWidth(64.0f, Unit.PIXELS)
  freezeImage.setHeight(64.0f, Unit.PIXELS)
  
  continueImage.setWidth(64.0f, Unit.PIXELS)
  continueImage.setHeight(64.0f, Unit.PIXELS)
  
  layout.addComponent(freezeImage, "top: 0; left: 0;")
  layout.addComponent(continueImage, "top: 0; left: 0;")
  
  continueImage.setVisible(false)
  
  addClickListener(new ClickListener() {
    override def click(clickEvent : ClickEvent) {
      if(dashUI.freezed) {
        freezeImage.setVisible(true)
        continueImage.setVisible(false)
        dashUI.setFreezed(false)
      } else {
        freezeImage.setVisible(false)
        continueImage.setVisible(true)
        dashUI.setFreezed(true)
      }
    }
  })
  
  setContent(layout)
}