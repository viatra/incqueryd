package hu.bme.mit.incqueryd.dashboard.controller

import scala.collection.mutable.HashMap
import hu.bme.mit.incqueryd.dashboard.panels.DeveloperPanel
import com.vaadin.ui.UI

/**
 * @author pappi
 */
object DevDashboardController {
  
  val GRID_ROWS = 2
  val GRID_COLS = 3;
  
}

case class GridItem(row : Int, col : Int)