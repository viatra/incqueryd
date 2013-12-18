package hu.bme.mit.incqueryd.microkernel;

import hu.bme.mit.incqueryd.microkernel.HelloKernel.HelloActor;
import hu.bme.mit.incqueryd.microkernel.IncQueryDKernel.ReteActor;

import java.util.Collection;

import org.junit.Test;

import akka.actor.ActorRef;
import akka.actor.Address;
import akka.actor.Deploy;
import akka.actor.Props;
import akka.remote.RemoteScope;

import com.google.common.collect.ImmutableList;

public class IncQueryDKernelTest {

    @Test
    public void test() throws InterruptedException {
        final IncQueryDKernel kernel = new IncQueryDKernel();
        kernel.system.actorOf(Props.create(ReteActor.class)).tell("Alpha node", null);
        kernel.system.actorOf(Props.create(ReteActor.class)).tell("Beta node", null);

        // final ActorRef a1 = kernel.system.actorOf(Props.create(AlphaActor.class));
        // a1.tell("A1", null);
        //
        // final ActorRef a2 = kernel.system.actorOf(Props.create(AlphaActor.class));
        // a2.tell("A2", null);
        //
        // final ActorRef j1 = kernel.system.actorOf(Props.create(JoinActor.class));
        // j1.tell("B1", null);
        //
        // final ActorRef j2 = kernel.system.actorOf(Props.create(AntiJoinActor.class));
        // j2.tell("B2", null);

        // final String name = "A";

        // final String host = "127.0.0.1";
        // final String host = "10.6.21.231";
        // final Address addr = new Address("akka", "incqueryd-kernel", host, 2552);
        // System.out.println(addr);

        // final Deploy deploy = new Deploy(new RemoteScope(addr));
        // System.out.println("Deploying " + name + " to " + host);

        // final ActorRef actor = system.actorOf(new Props(actorClass).withDeploy(deploy), name);

        // saving the reference for later use
        // final ActorRef actorRef = kernel.system.actorOf(Props.create(JoinActor.class).withDeploy(deploy), name);

        //final String host = "127.0.0.1";
//        final String host = "10.6.21.231";
//        final String host = "vcl0";
        final Collection<String> hosts = ImmutableList.of("10.6.21.231", "10.6.21.233", "10.6.21.235","10.6.21.237");
        
        
        for (final String host : hosts) {
            final Address addr = new Address("akka.tcp", "incqueryd-kernel", host, 2554);
            final ActorRef ref = kernel.system.actorOf(Props.create(HelloActor.class).withDeploy(new Deploy(new RemoteScope(addr))));
            ref.tell(addr.host().toString(), null);
            System.out.println("Actor reference: " + ref);            
        }
        
        

        Thread.sleep(5000);
    }

}
