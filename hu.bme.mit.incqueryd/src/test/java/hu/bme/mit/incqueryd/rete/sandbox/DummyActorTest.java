package hu.bme.mit.incqueryd.rete.sandbox;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.testkit.JavaTestKit;

/**
 * Dummy test case for playing with Akka's JavaTestKit.
 * 
 * @author szarnyasg
 * 
 */
public class DummyActorTest {

    static ActorSystem system;

    @BeforeClass
    public static void setup() {
        system = ActorSystem.create();
    }

    @AfterClass
    public static void teardown() {
        system.shutdown();
    }

    @Test
    public void test() {
        new JavaTestKit(system) {
            {
                // Arrange
                final Props props = new Props(DummyActor.class);
                final ActorRef actor = system.actorOf(props);

                // Act
                actor.tell(new DummyMessage(1), getRef());
                // Assert
                final DummyMessage expectedMessage1 = expectMsgClass(duration("1 second"), DummyMessage.class);
                assertEquals(expectedMessage1.getX(), 2);

                // Act                
                actor.tell(new DummyMessage(3), getRef());
                // Assert
                final DummyMessage expectedMessage2 = expectMsgClass(duration("1 second"), DummyMessage.class);
                assertEquals(expectedMessage2.getX(), 4);
            }
        };
    }

}