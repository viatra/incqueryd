package hu.bme.mit.incqueryd.idservice.utils

import hu.bme.mit.incqueryd.idservice.utils.HazelcastUtils._
import com.noctarius.snowcast.SnowcastSequencer
import com.noctarius.snowcast.SnowcastSystem
import com.noctarius.snowcast.Snowcast
import java.util.GregorianCalendar
import com.noctarius.snowcast.SnowcastEpoch
import java.util.Calendar

/**
 * @author pappi
 */
object SnowcastUtils {
  
  val offset = 1388534400000L
  
  val IQD_SEQUENCER_NAME = "idqSequencer"
  
  def getSnowcastInstance() : Snowcast = {
    val hazelcastInstance = getHazelcastInstance()
    SnowcastSystem.snowcast(hazelcastInstance)
  }
  
  def getIQDSequencer() : SnowcastSequencer = {
    val epoch = SnowcastEpoch.byTimestamp(offset)
    getSnowcastInstance().createSequencer(IQD_SEQUENCER_NAME, epoch)
  }
  
}