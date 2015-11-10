package hu.bme.mit.incqueryd.dashboard.panels

import hu.bme.mit.incqueryd.dashboard.dev.GridPosition
import hu.bme.mit.incqueryd.dashboard.dev.DevPanelConfiguration
import com.vaadin.ui.VerticalLayout
import com.vaadin.ui.Table
import com.vaadin.ui.TextArea
import hu.bme.mit.incqueryd.dashboard.controller.LogController.LogUpdateListener
import hu.bme.mit.incqueryd.dashboard.controller.LogController
import hu.bme.mit.incqueryd.dashboard.dev.GridPosition

class LogPanel(devConfig : DevPanelConfiguration) extends DeveloperPanel(devConfig, new GridPosition(0, 0)) with LogUpdateListener {
  
  val panelLayout = new VerticalLayout
  
  var logContent = new TextArea
  logContent.setEnabled(false)
  logContent.setSizeFull()
  panelLayout.setSizeFull()
  panelLayout.addComponent(logContent)
  setSizeFull();
  setContent(panelLayout)
  
  def appendLog(update : String) {
    logContent.setValue(s"${logContent.getValue}${System.lineSeparator()}$update")
  }
  
  def logUpdateReceived(update : String) {
    this.getUI.access(new Runnable() {
      override def run() {
        appendLog(update)
      }
    })
  }
  
  override def attach() {
    LogController.registerLogUpdateListener(devConfig.source, this)
    appendLog(LogController.getLogFileContent(devConfig.source))
    super.attach()
  }
  
  override def detach() {
    LogController.removeListener(devConfig.source, this)
    super.detach()
  }
  
}
