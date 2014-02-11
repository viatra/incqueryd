//package hu.bme.mit.incqueryd.rete.actors;
//
//import hu.bme.mit.incqueryd.rete.configuration.IncQueryDConfiguration;
//import hu.bme.mit.incqueryd.rete.configuration.ReteActorConfiguration;
//import hu.bme.mit.incqueryd.rete.messages.UpdateMessage;
//import hu.bme.mit.incqueryd.rete.nodes.AntiJoinNode;
//import hu.bme.mit.incqueryd.rete.nodes.FilterNode;
//import hu.bme.mit.incqueryd.rete.nodes.ReteNode;
//import scala.collection.immutable.Stack;
//import akka.actor.ActorRef;
//
///**
// *
// * @author szarnyasg
// *
// */
//public abstract class ReteActor extends IncQueryDActor {
//
//    /**
//     * Each Rete actor incorporates a Rete node, which is responsible for the appropriate operation, e.g. an
//     * {@link AntiJoinActor} contains an {@link AntiJoinNode}, a {@link FilterActor} contains a {@link FilterNode}, etc.
//     * These nodes can be accessed by typesafe private getters in the descendants, e.g. an {@link AntiJoinActor} has a
//     * getAntiJoinNode(), a {@link FilterActor} has a getFilterNode() method.
//     */
//	// TODO make generic
//	// TODO make final
//    protected ReteNode reteNode;
//    // TODO a ReteActor may send the update message to multiple targets
//    protected ActorRef targetActorRef;
//
//    @Override
//    protected void configure(final IncQueryDConfiguration incQueryDConfiguration) {
//        final ReteActorConfiguration configuration = (ReteActorConfiguration) incQueryDConfiguration;
//
//        this.targetActorRef = configuration.getTargetActorRef();
//        this.coordinator = configuration.getCoordinator();
//    };
//
//    protected void sendUpdateMessage(final Stack<ActorRef> senderStack, final UpdateMessage message) {
//        logger.info(actorString() + " Source stack is: " + senderStack);
//
//        final Stack<ActorRef> propagatedSenderStack = senderStack.push(getSelf());
//
//        logger.info(actorString() + " Sending " + message.getChangeSet().getTuples().size() + " tuples to " + targetActorRef
//                + ", nodeSlot = " + message.getNodeSlot() + ", propagated update type = " + message.getChangeSet().getChangeType()
//                + ", sender stack is: " + propagatedSenderStack);
//
//        // pushing this actor to the top of the sender stack
//        message.getSenderStack().push(getSelf());
//
//        // sentUpdates.put(targetActor, senderStack);
//        targetActorRef.tell(message, getSelf());
//    }
//
//}
