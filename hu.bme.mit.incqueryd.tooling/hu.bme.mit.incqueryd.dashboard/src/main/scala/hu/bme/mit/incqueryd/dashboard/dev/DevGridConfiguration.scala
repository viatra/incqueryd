package hu.bme.mit.incqueryd.dashboard.dev

import hu.bme.mit.incqueryd.dashboard.ui.DeveloperUI
import upickle._
import upickle.Implicits
import upickle.default._
import hu.bme.mit.incqueryd.dashboard.utils.DashboardUtils
import com.vaadin.ui.Notification
import java.io.PrintWriter
import java.io.File

/**
 * @author pappi
 */

sealed trait DeveloperPanelType
case object OVERVIEW extends DeveloperPanelType
case object LOG extends DeveloperPanelType
case object DASHBOARD extends DeveloperPanelType

case class DevPanelConfiguration(name: String, panelType: DeveloperPanelType, source : String, posAndSize : PanelPositionAndSize)

case class PanelPositionAndSize(var positionX: Int, var positionY: Int, var width: Float, var height : Float)

object DevGridConfiguration {

  def saveConfiguration(devUI: DeveloperUI, filename: String) {

    try {
      devUI.gridConfiguration = devUI.devPanels.map { _.updateConfPositionAndSize() }
      val serializedGrid = write(devUI.gridConfiguration)
      val filepath = s"${DashboardUtils.getConfigFolderPath()}$filename${DashboardUtils.DEVELOPER_DASHBOARD_CONFIGFILE_EXTENSION}"
      new PrintWriter(filepath) { write(serializedGrid); close }
      Notification.show("Configuration saved successfully!")
    } catch {
      case e: Exception => Notification.show("Error", "Error while saving configuration!", Notification.Type.ERROR_MESSAGE);
    }

  }

  def loadConfiguration(devUI: DeveloperUI, filename: String) {
    try {

      val filepath = DashboardUtils.getConfigFolderPath() + filename
      val confSource = scala.io.Source.fromFile(filepath).mkString
      devUI.gridConfiguration = read[Set[DevPanelConfiguration]](confSource)
      devUI.reload()

      Notification.show("Configuration loaded successfully!")
    } catch {
      case e: Exception => {
        e.printStackTrace()
        Notification.show("Error while loading configuration!", e.getMessage, Notification.Type.ERROR_MESSAGE);
      }
    }

  }

}