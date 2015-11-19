package hu.bme.mit.incqueryd.dashboard.panels

import com.vaadin.server.Sizeable.Unit
import com.vaadin.shared.ui.MarginInfo
import com.vaadin.ui.Alignment
import com.vaadin.ui.Button
import com.vaadin.ui.Button.ClickEvent
import com.vaadin.ui.Button.ClickListener
import com.vaadin.ui.Label
import com.vaadin.ui.TextField
import com.vaadin.ui.VerticalLayout
import com.vaadin.ui.Window

import hu.bme.mit.incqueryd.dashboard.dev.DevGridConfiguration
import hu.bme.mit.incqueryd.dashboard.ui.DeveloperUI


/**
 * @author pappi
 */
class SaveConfigPanel(devUI : DeveloperUI) extends Window("Save configuration") {
  
  setClosable(true)
  setResizable(false)
  setDraggable(false)
  setModal(true)
  center();
  
  val verticalLayout = new VerticalLayout
  verticalLayout.setSizeFull()
  
  setHeight(200.0f, Unit.PIXELS)
  setWidth(300.0f, Unit.PIXELS)
  
  val label = new Label("Enter a filename: ")
  val input = new TextField
  val button = new Button("Save")
  
  input.setWidth(100.0f, Unit.PERCENTAGE)
  
  verticalLayout.addComponent(label)
  verticalLayout.addComponent(input)
  verticalLayout.addComponent(button)
  
  val margin = new MarginInfo(true, true, true, true)
  verticalLayout.setMargin(margin)
  
  verticalLayout.setComponentAlignment(label, Alignment.TOP_LEFT)
  verticalLayout.setComponentAlignment(input, Alignment.MIDDLE_LEFT)
  verticalLayout.setComponentAlignment(button, Alignment.BOTTOM_RIGHT)  
  
  button.addClickListener(new ClickListener() {
    override def buttonClick(clickEvent : ClickEvent) {
      saveConfiguration(input.getValue)
    }
  })
  
  def saveConfiguration(filename : String) {
    DevGridConfiguration.saveConfiguration(devUI, filename)
    this.close()
  }
  
  setContent(verticalLayout)
  
}
