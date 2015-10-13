package hu.bme.mit.incqueryd.dashboard.panels

import com.vaadin.ui.PopupView
import com.vaadin.ui.VerticalLayout
import com.vaadin.ui.Button
import com.vaadin.ui.Component
import com.vaadin.ui.Panel
import com.vaadin.ui.Alignment
import com.vaadin.ui.Button.ClickListener
import com.vaadin.ui.Button.ClickEvent
import com.vaadin.ui.UI
import hu.bme.mit.incqueryd.dashboard.controller.DevDashboardController
import hu.bme.mit.incqueryd.dashboard.ui.DeveloperUI
import hu.bme.mit.incqueryd.dashboard.dev.DevPanelCloseListener

/**
 * @author pappi
 */
class AddDevPanelPopup(gridRow : Int, gridCol : Int, devUI : DeveloperUI) extends PopupView {
   val popupContent = new AddDevPanelPopupContent(gridRow, gridCol, this, devUI)
   setContent(popupContent)   
}

class AddDevPanelPopupContent(gridRow : Int, gridCol : Int, popupView : PopupView, devUI : DeveloperUI) extends PopupView.Content {

  val verticalLayout = new VerticalLayout
  verticalLayout.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER)
  
  DeveloperPanel.values.foreach { panelType => 
    
    val typeButton = new Button(panelType.toString())
    typeButton.addClickListener(new ClickListener() {
      override def buttonClick(clickEvent : ClickEvent) {
        val devPanel = devUI.createDeveloperPanel(panelType.toString(), panelType, gridRow, gridCol)
        devPanel.addCloseListener(new DevPanelCloseListener(popupView))
        popupView.setVisible(false);
      }
    })
    verticalLayout.addComponent(typeButton)
  }

  override def getPopupComponent(): Component = {
    verticalLayout
  }

  override def getMinimizedValueAsHTML(): String = {
    "Add panel"
  }

}
