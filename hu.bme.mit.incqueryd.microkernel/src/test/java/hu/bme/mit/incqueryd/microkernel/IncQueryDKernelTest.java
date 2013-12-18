package hu.bme.mit.incqueryd.microkernel;

import hu.bme.mit.incqueryd.microkernel.HelloKernel.HelloActor;
import hu.bme.mit.incqueryd.microkernel.IncQueryDKernel.ReteActor;

import java.util.Collection;

import org.junit.Test;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Address;
import akka.actor.Deploy;
import akka.actor.Props;
import akka.remote.RemoteScope;

import com.google.common.collect.ImmutableList;

public class IncQueryDKernelTest {

    @Test
    public void test() throws InterruptedException {
        final ActorSystem system = ActorSystem.create();
        system.actorOf(Props.create(ReteActor.class)).tell("Alpha node", null);
        system.actorOf(Props.create(ReteActor.class)).tell("Beta node", null);

        final Collection<String> hosts = ImmutableList.of("10.6.21.231", "10.6.21.233", "10.6.21.235", "10.6.21.237");

        for (final String host : hosts) {
            final Address addr = new Address("akka.tcp", "incqueryd-kernel", host, 2554);
            final ActorRef ref = system.actorOf(Props.create(HelloActor.class).withDeploy(
                    new Deploy(new RemoteScope(addr))));
            ref.tell("hello", null);
            System.out.println("Actor reference: " + ref);
        }

        Thread.sleep(5000);
    }

}
