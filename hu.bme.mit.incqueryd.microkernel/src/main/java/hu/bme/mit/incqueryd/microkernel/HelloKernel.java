package hu.bme.mit.incqueryd.microkernel;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.actor.UntypedActor;
import akka.kernel.Bootable;

public class HelloKernel implements Bootable {
    final ActorSystem system = ActorSystem.create("hellokernel");

    public static class HelloActor extends UntypedActor {
        final ActorRef worldActor = getContext().actorOf(Props.create(WorldActor.class));

        @Override
        public void onReceive(final Object message) {
            if (message == "start")
                worldActor.tell("Hello", getSelf());
            else if (message instanceof String)
                System.out.println(String.format("Received message: '%s'", message));
            else
                unhandled(message);
        }
    }

    public static class WorldActor extends UntypedActor {
        @Override
        public void onReceive(final Object message) {
            if (message instanceof String)
                getSender().tell(((String) message).toUpperCase() + " world!", getSelf());
            else
                unhandled(message);
        }
    }

    @Override
    public void startup() {       
        system.actorOf(Props.create(HelloActor.class)).tell("start", null);
    }

    @Override
    public void shutdown() {
        system.shutdown();
    }
}