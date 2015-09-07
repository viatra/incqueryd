package hu.bme.mit.incqueryd.idservice

import hu.bme.mit.incqueryd.idservice.utils.SnowcastUtils._
import hu.bme.mit.incqueryd.idservice.utils.HazelcastUtils._
import java.lang.Long
import com.noctarius.snowcast.SnowcastNodeConfigurator
/**
 * @author pappi
 */
object IDService {

  def lookupID(value: String): Long = {
    var ret = Option(getValueMap().get(value))
    if (ret.isDefined) {
      ret.get
    } else {
      val id = getIQDSequencer().next()
      getIDMap().put(id, value)
      getValueMap().put(value, id)
      id
    }
  }

  def resolveID(id: Long): String = {
    getIDMap().get(id)
  }
  
  def remove(id : Long) : String = {
    throw new UnsupportedOperationException("Not implemented yet")
  }
  
  def remove(value : String) : Long = {
    throw new UnsupportedOperationException("Not implemented yet")
  }
}