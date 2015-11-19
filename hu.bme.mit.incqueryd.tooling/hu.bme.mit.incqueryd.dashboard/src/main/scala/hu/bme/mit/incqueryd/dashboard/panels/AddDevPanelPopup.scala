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
import com.vaadin.ui.PopupView.PopupVisibilityListener
import com.vaadin.ui.VerticalLayout
import hu.bme.mit.incqueryd.dashboard.dev.DevPanelConfiguration
import hu.bme.mit.incqueryd.dashboard.dev.PanelPositionAndSize
import hu.bme.mit.incqueryd.dashboard.ui.DeveloperUI
import com.vaadin.ui.PopupView.PopupVisibilityEvent
import hu.bme.mit.incqueryd.dashboard.dev.PanelPositionAndSize
import hu.bme.mit.incqueryd.dashboard.dev.PanelPositionAndSize
import hu.bme.mit.incqueryd.dashboard.dev.PanelPositionAndSize
import hu.bme.mit.incqueryd.dashboard.dev.PanelPositionAndSize
import hu.bme.mit.incqueryd.dashboard.dev.PanelPositionAndSize

/**
 * @author pappi
 */
class AddDevPanelPopup(devUI : DeveloperUI) extends PopupView {
   var posAndSize : PanelPositionAndSize = _
   val popupContent = new AddDevPanelPopupContent(this, devUI)
   setContent(popupContent)
   setVisible(false)
   setPopupVisible(false)
   addPopupVisibilityListener(new PopupVisibilityListener() {
     override def popupVisibilityChange(event : PopupVisibilityEvent) {
       if(!event.isPopupVisible()) {
         setVisible(false)
       }
     }
   })
   
   def showPopup(_posAndSize : PanelPositionAndSize) {
     posAndSize = _posAndSize
     setVisible(true)
     setPopupVisible(true)
   }
}

class AddDevPanelPopupContent(popupView : AddDevPanelPopup, devUI : DeveloperUI) extends PopupView.Content {

  val verticalLayout = new VerticalLayout
  verticalLayout.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER)
  
  DeveloperPanel.getTypes().foreach { panelType => 
    val typeButton = new Button(panelType.toString())
    typeButton.setSizeFull()
    typeButton.setStyleName("selectbutton")
    typeButton.addClickListener(new ClickListener() {
      override def buttonClick(clickEvent : ClickEvent) {
    	  popupView.setVisible(false);
    	  val devPanelConf = new DevPanelConfiguration(panelType.toString(), panelType, "", popupView.posAndSize)
        devUI.createDeveloperPanel(devPanelConf)
      }
    })
    verticalLayout.addComponent(typeButton)
  }

  override def getPopupComponent(): Component = {
    verticalLayout
  }

  override def getMinimizedValueAsHTML(): String = {
    ""
  }

}
