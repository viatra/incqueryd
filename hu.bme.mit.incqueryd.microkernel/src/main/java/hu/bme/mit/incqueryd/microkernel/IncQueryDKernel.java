package hu.bme.mit.incqueryd.microkernel;

import akka.actor.ActorSystem;
import akka.actor.UntypedActor;
import akka.kernel.Bootable;

public class IncQueryDKernel implements Bootable {
    final ActorSystem system = ActorSystem.create("incqueryd-kernel");

    public static class ReteActor extends UntypedActor {
        @Override
        public void onReceive(final Object message) {
            if (message instanceof String) {
                final String string = (String) message;
                System.out.println(String.format("Received message: \"%s\"", string));
            } else {
                unhandled(message);
            }
        }
    }

    @Override
    public void startup() {
        System.out.println("IncQuery-D kernel started.");
    }

    @Override
    public void shutdown() {
        system.shutdown();
    }

}
