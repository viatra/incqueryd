package hu.bme.mit.incqueryd.yarn

import org.apache.hadoop.yarn.api.records.ApplicationId

case class YarnApplication(ip: String, port: Int, applicationId: ApplicationId)