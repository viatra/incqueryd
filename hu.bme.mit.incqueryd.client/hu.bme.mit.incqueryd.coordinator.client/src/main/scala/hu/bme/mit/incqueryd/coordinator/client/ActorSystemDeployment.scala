package hu.bme.mit.incqueryd.yarn

import scala.concurrent.Await
import scala.concurrent.Future
import hu.bme.mit.incqueryd.actorservice.YarnActorService
import scala.concurrent.ExecutionContext.Implicits.global
import hu.bme.mit.incqueryd.engine.rete.actors.ReteActor
import hu.bme.mit.incqueryd.actorservice.RemoteActorService
import hu.bme.mit.incqueryd.engine.RemoteReteActor

/**
 * @author pappi
 */
object ActorSystemDeployment {

  def startActorSystemsOnYarnNodes(client: AdvancedYarnClient) {
    val futureYarnActorServices = YarnActorService.startActorServices(client)
    val yarnActorServices = Await.result(Future.sequence(futureYarnActorServices), IncQueryDZooKeeper.timeout)
    yarnActorServices.foreach { yarnActorService =>
      new RemoteActorService(yarnActorService.ip, yarnActorService.port)
        .startActorSystem(RemoteReteActor.defaultActorId(yarnActorService.ip), classOf[ReteActor])
    }
  }
}
