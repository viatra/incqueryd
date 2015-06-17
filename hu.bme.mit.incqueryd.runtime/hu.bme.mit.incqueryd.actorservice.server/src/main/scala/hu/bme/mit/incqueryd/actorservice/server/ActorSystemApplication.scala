package hu.bme.mit.incqueryd.actorservice.server

import hu.bme.mit.incqueryd.actorservice.ActorId
import hu.bme.mit.incqueryd.actorservice.AkkaUtils
import hu.bme.mit.incqueryd.yarn.IncQueryDZooKeeper
import upickle._
import eu.mondo.utils.NetworkUtils
import hu.bme.mit.incqueryd.actorservice.YarnActorService

object ActorSystemApplication {

  def main(args: Array[String]) {
    val zkApplicationPath = args(0)
    val ip = NetworkUtils.getLocalIpAddress
    val port = YarnActorService.port
    AkkaUtils.getRemotingActorSystem(YarnActorService.actorSystemName, ip, port)
    IncQueryDZooKeeper.setData(IncQueryDZooKeeper.yarnNodesPath + zkApplicationPath, s"$ip:$port".getBytes)
  }

}