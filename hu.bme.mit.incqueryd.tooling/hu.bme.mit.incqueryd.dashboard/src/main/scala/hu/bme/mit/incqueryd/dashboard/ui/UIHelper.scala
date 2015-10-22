package hu.bme.mit.incqueryd.dashboard.ui

import com.vaadin.ui.Button
import com.vaadin.ui.Button.ClickListener
import com.vaadin.ui.Button.ClickEvent
import com.vaadin.ui.Panel
import com.vaadin.server.Sizeable.Unit
import com.vaadin.ui.Label
import hu.bme.mit.incqueryd.engine.rete.dataunits.Tuple
import hu.bme.mit.incqueryd.dashboard.utils.DashboardUtils._
import com.vaadin.ui.HorizontalLayout
import com.vaadin.ui.Component
import com.vaadin.ui.Link
import com.vaadin.server.ExternalResource
import com.vaadin.ui.VerticalLayout
import com.vaadin.ui.PopupView
import java.util.Calendar
import java.text.SimpleDateFormat
import com.vaadin.ui.TextArea
import hu.bme.mit.incqueryd.yarn.IncQueryDZooKeeper
import com.vaadin.ui.Alignment

/**
 * @author pappi
 */
object UIHelper {

  val timeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS")

  def initializePatternButton(patternId: String): Button = {
    val button = new Button(resolvePattern(patternId))
    button.setDisableOnClick(true)
    button.setSizeFull()
    button
  }

  def initializeQueryPanel(query : String): Panel = {
    val panel = new Panel
    panel.setWidth(100.0F, Unit.PERCENTAGE)
    val panelLayout = new VerticalLayout
    panelLayout.setWidth(100.0F, Unit.PERCENTAGE)
    val queryPopup = new PopupView(new QueryContent(query))
    panelLayout.addComponent(queryPopup)
    panelLayout.setComponentAlignment(queryPopup, Alignment.MIDDLE_CENTER)
    panel.setContent(panelLayout)
    panel
  }

  class QueryContent(query : String) extends PopupView.Content {
    val queryTextArea = new TextArea
    val queryText = IncQueryDZooKeeper.getStringData(s"${IncQueryDZooKeeper.runningQueries}/$query")
    queryTextArea.setValue(queryText)
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
  
  def buildResultPanel(patternName : String, resultSet: Set[Tuple], newTuples: Long, removedTuple: Long): Panel = {
    val resultPanel = new Panel
    val rowLayout = new HorizontalLayout
    rowLayout.setSizeFull()
    resultPanel.setHeight(50.0F, Unit.PIXELS)
    resultPanel.setWidth(100.0f, Unit.PERCENTAGE)

    val resultTime = timeFormat.format(Calendar.getInstance().getTime())
    
    rowLayout.addComponent(buildResultLabel(resultTime))
    rowLayout.addComponent(buildResultLabel(s"Result set size: ${resultSet.size}"))
    rowLayout.addComponent(buildResultLabel(s"New: $newTuples"))
    rowLayout.addComponent(buildResultLabel(s"Removed: $removedTuple"))
    rowLayout.addComponent(new PopupView(new ResultSetContent(patternName, resultTime, resultSet)))

    resultPanel.setContent(rowLayout)
    resultPanel
  }

  class ResultSetContent(patternName: String, timestamp: String, resultSet: Set[Tuple]) extends PopupView.Content {

    val resultPanel = new Panel(s"$patternName results at $timestamp")
    resultPanel.setWidth(800, Unit.PIXELS)
    resultPanel.setHeight(600, Unit.PIXELS)
    val resultsLayout = new VerticalLayout
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
      "Show results"
    }
  }

  def buildTuplePanel(rowNum : Int, tuple: Tuple): Component = {
    val tuplePanel = new Panel
    tuplePanel.setSizeFull()
    val tupleLayout = new HorizontalLayout
    val rowLabel = new Label(s"${rowNum}. ")
    tupleLayout.addComponent(rowLabel)
    tupleLayout.setComponentAlignment(rowLabel, Alignment.MIDDLE_LEFT)
    for (i <- 0 to tuple.size() - 1) {
      val url = tuple.get(i).toString()
      val name = url.split("/").last // XXX use label instead
      val tupleLink = buildTupleLink(name, url)
      tupleLayout.addComponent(tupleLink)
      tupleLayout.setComponentAlignment(rowLabel, Alignment.MIDDLE_CENTER)
    }
    tuplePanel.setContent(tupleLayout)
    tupleLayout
  }

  def buildTupleLink(name: String, url: String): Link = {
    val link = new Link(name, new ExternalResource(url))
    link
  }

  def buildResultLabel(data: String): Label = {
    val label = new Label(data)
    label.setHeight(100.0F, Unit.PERCENTAGE)
    label.setWidth(250.0F, Unit.PIXELS)
    label
  }

  class QueryButtonListener extends ClickListener {
    def buttonClick(clickEvent: ClickEvent) {

    }
  }
}