package hu.bme.mit.incqueryd.actorservice.server

import hu.bme.mit.incqueryd.actorservice.ActorId
import hu.bme.mit.incqueryd.actorservice.AkkaUtils
import hu.bme.mit.incqueryd.yarn.IncQueryDZooKeeper
import upickle._
import eu.mondo.utils.NetworkUtils
import hu.bme.mit.incqueryd.actorservice.YarnActorService
import akka.actor.Props
import hu.bme.mit.incqueryd.actorservice.DeployActor

object ActorSystemApplication {
  
  def main(args: Array[String]) {
    val zkApplicationPath = args(0)
    val ip = NetworkUtils.getLocalIpAddress
    val port = YarnActorService.port
    val actorSystem = AkkaUtils.getRemotingActorSystem(YarnActorService.actorSystemName, ip, port)
    actorSystem.actorOf(Props[DeployActor], YarnActorService.deployActorName)
    IncQueryDZooKeeper.setData(IncQueryDZooKeeper.yarnNodesPath + zkApplicationPath, s"$ip:$port".getBytes)
  }

}