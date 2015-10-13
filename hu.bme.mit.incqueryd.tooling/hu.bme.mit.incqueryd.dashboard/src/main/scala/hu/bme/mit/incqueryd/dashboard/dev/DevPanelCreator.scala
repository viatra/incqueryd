package hu.bme.mit.incqueryd.dashboard.dev

import com.vaadin.ui.Button
import com.vaadin.ui.UI
import hu.bme.mit.incqueryd.dashboard.panels.DeveloperPanel
import com.vaadin.ui.Button.ClickListener
import com.vaadin.ui.Button.ClickEvent

/**
 * @author pappi
 */
class DevPanelCreator extends Button {
  
  var name : String = _
  var panelType : DeveloperPanel.PanelType = _ 
  var gridRow : Int = _
  var gridCol : Int = _
  var devPanel : DeveloperPanel = _

  setVisible(false)
  
  def createDevPanel(name : String, panelType : DeveloperPanel.PanelType, gridRow : Int, gridCol : Int) : DeveloperPanel = {
    
    this.name = name
    this.panelType = panelType
    this.gridRow = gridRow
    this.gridCol = gridCol
    
    this.click()
    
    devPanel
  }
  
  addClickListener(new ClickListener() {
      override def buttonClick(clickEvent : ClickEvent) {
        devPanel = new DeveloperPanel(name, panelType, gridRow, gridCol)
        devPanel.updatePositionAndSize()
        UI.getCurrent.addWindow(devPanel)
      }
    })
  
  
}