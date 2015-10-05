package hu.bme.mit.incqueryd.dashboard.ui

import com.vaadin.ui.Button
import hu.bme.mit.incqueryd.engine.rete.dataunits.Tuple

/**
 * @author pappi
 */

trait UIMessage
case class AddPattern(pattern : String, query : String) extends UIMessage
case class RemovePattern(pattern : String, query : String) extends UIMessage
case class QueryResult(patternId : String, result : Set[Tuple], newTuples : Long, removedTuples : Long) extends UIMessage
