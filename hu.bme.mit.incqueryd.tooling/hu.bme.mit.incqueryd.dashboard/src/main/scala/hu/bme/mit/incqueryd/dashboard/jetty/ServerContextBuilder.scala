package hu.bme.mit.incqueryd.dashboard.jetty

import org.eclipse.jetty.server.handler.HandlerCollection
import org.eclipse.jetty.server.session.SessionHandler
import org.eclipse.jetty.servlet.ServletContextHandler
import hu.bme.mit.incqueryd.dashboard.ui.DashboardUIServlet
import org.eclipse.jetty.server.handler.DefaultHandler


/**
 * @author pappi
 */
object ServerContextBuilder {
  
  def buildHandlers() : HandlerCollection = {
    val context = new ServletContextHandler(ServletContextHandler.SESSIONS)
    context.setSessionHandler(new SessionHandler)
    context.setContextPath("/")
    context.addServlet(classOf[DashboardUIServlet], "/*")
    val handlers = new HandlerCollection();
    handlers.setHandlers(Array(context, new DefaultHandler()))
    handlers
  }
  
}