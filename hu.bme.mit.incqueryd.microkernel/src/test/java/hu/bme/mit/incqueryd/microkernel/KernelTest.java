package hu.bme.mit.incqueryd.microkernel;

import hu.bme.mit.incqueryd.microkernel.HelloKernel.HelloActor;

import org.junit.Test;

import akka.actor.Props;

public class KernelTest
{
    @Test
    public void test() throws InterruptedException {
        final HelloKernel kernel = new HelloKernel();
        kernel.system.actorOf(Props.create(HelloActor.class)).tell("start", null);
        
        Thread.sleep(1000);
    }
}
