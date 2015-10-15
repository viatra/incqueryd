package hu.bme.mit.incqueryd.dashboard.panels

import com.vaadin.ui.Button
import com.vaadin.ui.Button.ClickEvent
import com.vaadin.ui.Button.ClickListener
import com.vaadin.ui.Panel
import com.vaadin.ui.VerticalLayout
import com.vaadin.ui.Window
import com.vaadin.server.Sizeable.Unit
import hu.bme.mit.incqueryd.dashboard.utils.DashboardUtils
import hu.bme.mit.incqueryd.dashboard.ui.DeveloperUI
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.scala.DefaultScalaModule
import java.io.File
import com.vaadin.ui.Notification
import upickle.default._
import hu.bme.mit.incqueryd.dashboard.dev.DevGridConfiguration

/**
 * @author pappi
 */

class OpenConfigPanel(devUI: DeveloperUI) extends Window("Open configuration") {

  setClosable(true)
  setResizable(false)
  setDraggable(false)
  setModal(true)

  center();

  val configPanel = new Panel
  configPanel.setHeight(300, Unit.PIXELS)
  configPanel.setWidth(400, Unit.PIXELS)

  val configFileList = new VerticalLayout
  configFileList.setWidth(100.0f, Unit.PERCENTAGE)

  configPanel.setContent(configFileList)

  DashboardUtils.getConfigFiles().foreach { filename =>
    val configButton = new Button(filename)
    configButton.setStyleName("selectbutton")
    configButton.setWidth(100.0f, Unit.PERCENTAGE)
    configButton.addClickListener(new ClickListener() {
      override def buttonClick(clickEvent: ClickEvent) {
        loadConfiguration(filename)
      }
    })
    configFileList.addComponent(configButton)
  }

  def loadConfiguration(filename: String) {
    DevGridConfiguration.loadConfiguration(devUI, filename)
    this.close()
  }

  setContent(configPanel)

}