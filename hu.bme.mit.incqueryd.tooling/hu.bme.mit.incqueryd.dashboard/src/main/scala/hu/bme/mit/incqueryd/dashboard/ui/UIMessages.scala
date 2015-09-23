package hu.bme.mit.incqueryd.dashboard.ui

import com.vaadin.ui.Button
import hu.bme.mit.incqueryd.engine.rete.dataunits.Tuple

/**
 * @author pappi
 */

trait UIMessage
case class AddQuery(query : String) extends UIMessage
case class RemoveQuery(query : String) extends UIMessage
case class QueryResult(queryName : String, result : Set[Tuple], newTuples : Long, removedTuples : Long) extends UIMessage
