package hu.bme.mit.incqueryd.dashboard.dev

import com.vaadin.ui.Button
import com.vaadin.ui.UI
import hu.bme.mit.incqueryd.dashboard.panels.DeveloperPanel
import com.vaadin.ui.Button.ClickListener
import com.vaadin.ui.Button.ClickEvent

/**
 * 
 * @author pappi
 * 
 */
class DevPanelCreator extends Button {
  
  var devPanelConf : DevPanelConfiguration = _
  var gridPos : GridPosition = _
  var devPanel : DeveloperPanel = _

  setVisible(false)
  
  def createDevPanel(devPanelConf : DevPanelConfiguration, gridPos : GridPosition) : DeveloperPanel = {
    
    this.devPanelConf = devPanelConf
    this.gridPos = gridPos
    
    this.click()
    
    devPanel
  }
  
  addClickListener(new ClickListener() {
      override def buttonClick(clickEvent : ClickEvent) {
        devPanel = new DeveloperPanel(devPanelConf, gridPos)
        devPanel.updatePositionAndSize()
        UI.getCurrent.addWindow(devPanel)
      }
    })
  
  
}