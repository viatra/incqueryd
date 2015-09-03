package hu.bme.mit.incqueryd.idservice.utils

import com.hazelcast.core.HazelcastInstance
import com.hazelcast.core.IMap
import com.hazelcast.client.HazelcastClient

import com.hazelcast.client.HazelcastClient

/**
 * @author pappi
 */
object HazelcastUtils {
  
  val IQD_IDMAP_NAME = "IQD_ID_MAP"
  val IQD_VALUEMAP_NAME = "IQD_VALUE_MAP"
  
  var client : HazelcastInstance = _
  
  def getHazelcastInstance() : HazelcastInstance = {
    if(client == null)
      client = HazelcastClient.newHazelcastClient()
    client
  }
  
  // XXX use BiMap instead of two IMaps in the future
  def getIDMap() : IMap[Long, String] = {
    getHazelcastInstance().getMap[Long, String](IQD_IDMAP_NAME)
  }
  
  def getValueMap() : IMap[String, Long] = {
    getHazelcastInstance().getMap[String, Long](IQD_VALUEMAP_NAME)
  }
  
  def close() {
    client.shutdown()
    client = null
  }
}
