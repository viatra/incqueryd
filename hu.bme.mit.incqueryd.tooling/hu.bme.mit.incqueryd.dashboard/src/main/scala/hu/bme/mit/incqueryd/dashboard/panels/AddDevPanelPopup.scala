package hu.bme.mit.incqueryd.dashboard.panels

import com.vaadin.annotations.Push
import com.vaadin.annotations.Theme
import com.vaadin.annotations.Widgetset
import com.vaadin.ui.Alignment
import com.vaadin.ui.Button
import com.vaadin.ui.Button.ClickEvent
import com.vaadin.ui.Button.ClickListener
import com.vaadin.ui.Component
import com.vaadin.ui.PopupView
import com.vaadin.ui.VerticalLayout
import hu.bme.mit.incqueryd.dashboard.dev.DevPanelCloseListener
import hu.bme.mit.incqueryd.dashboard.dev.GridPosition
import hu.bme.mit.incqueryd.dashboard.ui.DeveloperUI
import hu.bme.mit.incqueryd.dashboard.dev.DevPanelConfiguration
import hu.bme.mit.incqueryd.dashboard.dev.DeveloperPanelType
import hu.bme.mit.incqueryd.dashboard.dev.DeveloperPanelType

/**
 * @author pappi
 */
class AddDevPanelPopup(gridPos : GridPosition, devUI : DeveloperUI) extends PopupView {
   val popupContent = new AddDevPanelPopupContent(gridPos, this, devUI)
   setContent(popupContent)   
}

class AddDevPanelPopupContent(gridPos : GridPosition, popupView : PopupView, devUI : DeveloperUI) extends PopupView.Content {

  val verticalLayout = new VerticalLayout
  verticalLayout.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER)
  
  DeveloperPanel.getTypes().foreach { panelType => 
    val typeButton = new Button(panelType.toString())
    typeButton.setSizeFull()
    typeButton.setStyleName("selectbutton")
    typeButton.addClickListener(new ClickListener() {
      override def buttonClick(clickEvent : ClickEvent) {
    	  popupView.setVisible(false);
    	  val devPanelConf = new DevPanelConfiguration(panelType.toString(), panelType, "")
        devUI.createDeveloperPanel(devPanelConf, gridPos, popupView)
        devUI.registerDeveloperPanel(devPanelConf, gridPos)
      }
    })
    verticalLayout.addComponent(typeButton)
  }

  override def getPopupComponent(): Component = {
    verticalLayout
  }

  override def getMinimizedValueAsHTML(): String = {
    "<h3 style=\"color: grey\">Add panel</h3>"
  }

}
