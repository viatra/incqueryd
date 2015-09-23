package hu.bme.mit.incqueryd.dashboard.ui

import com.vaadin.ui.Button
import com.vaadin.ui.Button.ClickListener
import com.vaadin.ui.Button.ClickEvent
import com.vaadin.ui.Panel
import com.vaadin.server.Sizeable.Unit
import com.vaadin.ui.Label
import hu.bme.mit.incqueryd.engine.rete.dataunits.Tuple
import sun.awt.HorizBagLayout
import com.vaadin.ui.HorizontalLayout
import com.vaadin.ui.Component
import com.vaadin.ui.Link
import com.vaadin.server.ExternalResource

/**
 * @author pappi
 */
object UIHelper {
  
  def initializeQueryButton(button : Button) : Button = {
    button.setSizeFull()
    button
  }
  
  def buildResultPanel(result : Set[Tuple], newTuples : Long, removedTuple : Long) : Panel = {
    val resultPanel = new Panel
    val rowLayout = new HorizontalLayout
    resultPanel.setHeight(50.0F, Unit.PIXELS)
    resultPanel.setWidth(100.0f, Unit.PERCENTAGE)
    
    //rowLayout.setSizeFull()
    rowLayout.addComponent(buildResultLabel(s"Result size: ${result.size}"))
    rowLayout.addComponent(buildResultLabel(s"New: $newTuples"))
    rowLayout.addComponent(buildResultLabel(s"Removed: $removedTuple"))
    
    result.foreach { tuple => 
      rowLayout.addComponent(buildTuplePanel(tuple))
    }
    
    resultPanel.setContent(rowLayout)
    resultPanel
  }
  
  def buildTuplePanel(tuple : Tuple) : Component = {
    val tuplePanel = new Panel
    val tupleLayout = new HorizontalLayout
    tuplePanel.setHeight(30.0F, Unit.PIXELS)
    tuplePanel.setWidth(50.0F, Unit.PIXELS)
    //tupleLayout.setSizeFull()
    for(i <- 0 to tuple.size()-1) {
      val url = tuple.get(i).toString()
      val name = url // XXX use readable name instead
      tupleLayout.addComponent(buildTupleLink(name, url))
    }
    tuplePanel.setContent(tupleLayout)
    tupleLayout
  }
  
  def buildTupleLink(name : String, url : String) : Link = {
    val link = new Link(name, new ExternalResource(url))
    link.setWidth(50.0F, Unit.PIXELS)
    link
  }
  
  def buildResultLabel(data : String) : Label = {
    val label = new Label(data)
    label.setHeight(1000.0F, Unit.PERCENTAGE)
    label.setWidth(150.0F, Unit.PIXELS)
    label
  }
  
  class QueryButtonListener extends ClickListener {
    def buttonClick(clickEvent : ClickEvent) {
      
    }
  }
}