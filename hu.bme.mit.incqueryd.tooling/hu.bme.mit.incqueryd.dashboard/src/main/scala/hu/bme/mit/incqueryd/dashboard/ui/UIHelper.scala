package hu.bme.mit.incqueryd.dashboard.ui

import java.text.SimpleDateFormat
import java.util.Calendar
import com.vaadin.server.ExternalResource
import com.vaadin.server.Sizeable.Unit
import com.vaadin.ui.Alignment
import com.vaadin.ui.Button
import com.vaadin.ui.Button.ClickEvent
import com.vaadin.ui.Button.ClickListener
import com.vaadin.ui.Component
import com.vaadin.ui.HorizontalLayout
import com.vaadin.ui.Label
import com.vaadin.ui.Link
import com.vaadin.ui.Panel
import com.vaadin.ui.PopupView
import com.vaadin.ui.TextArea
import com.vaadin.ui.VerticalLayout
import hu.bme.mit.incqueryd.dashboard.utils.DashboardUtils._
import hu.bme.mit.incqueryd.engine.rete.dataunits.Tuple
import hu.bme.mit.incqueryd.yarn.IncQueryDZooKeeper
import org.vaadin.jouni.animator.Animator

/**
 * @author pappi
 */
object UIHelper {

  val timeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")

  def initializePatternButton(patternId: String): Button = {
    val button = new Button(resolvePattern(patternId))
    button.setStyleName("pattern")
    button.setDisableOnClick(true)
    button.setSizeFull()
    button
  }

  def initializeQueryPanel(query : String): Panel = {
    val panel = new Panel
    panel.setStyleName("query");
    panel.setWidth(100.0F, Unit.PERCENTAGE)
    val panelLayout = new VerticalLayout
    panelLayout.setWidth(100.0F, Unit.PERCENTAGE)
    val queryPopup = new PopupView(new QueryContent(query))
    queryPopup.setStyleName("query")
    panelLayout.addComponent(queryPopup)
    panelLayout.setComponentAlignment(queryPopup, Alignment.MIDDLE_CENTER)
    panel.setContent(panelLayout)
    panel
  }

  class QueryContent(query : String) extends PopupView.Content {
    val queryText = IncQueryDZooKeeper.getStringData(s"${IncQueryDZooKeeper.runningQueries}/$query")
    val queryTextArea = new TextArea("", queryText)
    queryTextArea.setReadOnly(true)
    queryTextArea.setSizeFull()
    queryTextArea.setRows(60)
    queryTextArea.setImmediate(true)
    queryTextArea.setWidth(600.0F, Unit.PIXELS)
    queryTextArea.setHeight(400.0F, Unit.PIXELS)
    override def getPopupComponent() : Component = {
      queryTextArea
    }
    
    override def getMinimizedValueAsHTML() : String = {
      query
    }
  }
  
  def buildResultPanel(patternName : String, resultSet: Set[Tuple], newTuples: Set[Tuple], removedTuples: Set[Tuple]): Panel = {
    val resultPanel = new Panel
    val rowLayout = new HorizontalLayout
    rowLayout.setSizeFull()
    rowLayout.setHeight(100.0f, Unit.PERCENTAGE)
    
    resultPanel.setHeight(50.0F, Unit.PIXELS)
    resultPanel.setWidth(100.0f, Unit.PERCENTAGE)
    
    val resultTime = timeFormat.format(Calendar.getInstance().getTime())
    
    val resultTimeLabel = new Label(resultTime)
    resultTimeLabel.setStyleName("resultmeta")
    
    val newTuplesLabel = new Label("Added: ")
    newTuplesLabel.setStyleName("resultmeta")
    val newPopup = new PopupView(new ResultSetContent(s"${patternName} results : added tuples at ${resultTime}", newTuples))
    
    val removedTuplesLabel = new Label("Removed: ")
    removedTuplesLabel.setStyleName("resultmeta")
    val removedPopup = new PopupView(new ResultSetContent(s"${patternName} results : removed tuples at ${resultTime}", removedTuples))
    
    val resultSizeLabel = new Label(s"Size: ")
    resultSizeLabel.setStyleName("resultmeta")
    val fullPopup = new PopupView(new ResultSetContent(s"${patternName} results at ${resultTime}", resultSet))
    
    rowLayout.addComponent(resultTimeLabel)
    rowLayout.setExpandRatio(resultTimeLabel, 1.5f)
    rowLayout.setComponentAlignment(resultTimeLabel, Alignment.MIDDLE_LEFT)
    
    rowLayout.addComponent(newTuplesLabel)
    rowLayout.setExpandRatio(newTuplesLabel, 1.0f)
    rowLayout.setComponentAlignment(newTuplesLabel, Alignment.MIDDLE_RIGHT)
    rowLayout.addComponent(newPopup)
    rowLayout.setExpandRatio(newPopup, 1.0f)
    rowLayout.setComponentAlignment(newPopup, Alignment.MIDDLE_CENTER)
    
    rowLayout.addComponent(removedTuplesLabel)
    rowLayout.setExpandRatio(removedTuplesLabel, 1.0f)
    rowLayout.setComponentAlignment(removedTuplesLabel, Alignment.MIDDLE_RIGHT)
    rowLayout.addComponent(removedPopup)
    rowLayout.setExpandRatio(removedPopup, 1.0f)
    rowLayout.setComponentAlignment(removedPopup, Alignment.MIDDLE_CENTER)
    
    rowLayout.addComponent(resultSizeLabel)
    rowLayout.setExpandRatio(resultSizeLabel, 1.0f)
    rowLayout.setComponentAlignment(resultSizeLabel, Alignment.MIDDLE_RIGHT)
    rowLayout.addComponent(fullPopup)
    rowLayout.setExpandRatio(fullPopup, 1.0f)
    rowLayout.setComponentAlignment(fullPopup, Alignment.MIDDLE_CENTER)
    
    resultPanel.setContent(rowLayout)
    resultPanel.addStyleName("resultpanel")
    
    resultPanel
  }

  class ResultSetContent(panelName: String, resultSet: Set[Tuple]) extends PopupView.Content {
    
    val resultPanel = new Panel(panelName)
    resultPanel.setWidth(800, Unit.PIXELS)
    resultPanel.setHeight(600, Unit.PIXELS)
    val resultsLayout = new VerticalLayout
    resultsLayout.setWidth(100.0f, Unit.PERCENTAGE)
    
    var i = 1;
    resultSet.foreach { tuple =>
        val tuplePanel = buildTuplePanel(i, tuple)
        resultsLayout.addComponent(tuplePanel)
        resultsLayout.setComponentAlignment(tuplePanel, Alignment.MIDDLE_LEFT)
        i += 1
    }
    resultPanel.setContent(resultsLayout)
    
    override def getPopupComponent(): Component = {
       resultPanel
    }
    
    override def getMinimizedValueAsHTML(): String = {
      s"${resultSet.size.toString()} tuples"
    }
  }

  def buildTuplePanel(rowNum : Int, tuple: Tuple): Component = {
    val tuplePanel = new Panel
    tuplePanel.setStyleName("tuplepanel")
    tuplePanel.setWidth(100.0f, Unit.PERCENTAGE)
    tuplePanel.setHeight(30.0f, Unit.PIXELS)
    
    val tupleLayout = new HorizontalLayout
    tupleLayout.setHeight(100.0f, Unit.PERCENTAGE)
    tupleLayout.setDefaultComponentAlignment(Alignment.MIDDLE_LEFT)
    
    val rowLabel = new Label(s"${rowNum}. ")
    tupleLayout.addComponent(rowLabel)
    tupleLayout.setExpandRatio(rowLabel, 1.0f)
    
    for (i <- 0 to tuple.size() - 1) {
      val url = tuple.get(i).toString()
      val name = url.split("/").last // XXX use label instead
      val tupleLink = buildTupleLink(name, url)
      tupleLayout.addComponent(tupleLink)
      tupleLayout.setComponentAlignment(tupleLink, Alignment.MIDDLE_CENTER)
      tupleLayout.setExpandRatio(tupleLink, 9.0f)
    }
    tuplePanel.setContent(tupleLayout)
    tuplePanel
  }

  def buildTupleLink(name: String, url: String): Link = {
    val link = new Link(name, new ExternalResource(url))
    link
  }

  class QueryButtonListener extends ClickListener {
    def buttonClick(clickEvent: ClickEvent) {

    }
  }
}