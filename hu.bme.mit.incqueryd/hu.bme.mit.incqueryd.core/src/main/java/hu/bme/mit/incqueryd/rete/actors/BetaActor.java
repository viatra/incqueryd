//package hu.bme.mit.incqueryd.rete.actors;
//
//import hu.bme.mit.incqueryd.rete.configuration.BetaActorConfiguration;
//import hu.bme.mit.incqueryd.rete.configuration.IncQueryDConfiguration;
//import hu.bme.mit.incqueryd.rete.dataunits.ChangeSet;
//import hu.bme.mit.incqueryd.rete.messages.UpdateMessage;
//import hu.bme.mit.incqueryd.rete.nodes.BetaNode;
//
//import org.apache.cassandra.transport.messages.ReadyMessage;
//
///**
// * 
// * @author szarnyasg
// *
// */
//public abstract class BetaActor extends ReteActor {
//
//    private BetaNode getBetaNode() {
//        return (BetaNode) reteNode;
//    }
//    public BetaActor() {
//        super();
//    }
//
//    @Override
//    protected void configure(final IncQueryDConfiguration incQueryDConfiguration) {
//        final BetaActorConfiguration configuration = (BetaActorConfiguration) incQueryDConfiguration;
//        super.configure(configuration);
//    }
//
//    @Override
//    public void onReceive(final Object message) throws Exception {
//        super.onReceive(message);
//
//        if (message instanceof UpdateMessage) {
//            final UpdateMessage incomingUpdateMessage = (UpdateMessage) message;
//            incomingUpdate(incomingUpdateMessage);
//        }
//
//        else if (message instanceof ReadyMessage) {
//            logger.info(actorString() + " ReadyMessage received");
//        }
//    }
//
//    protected void incomingUpdate(final UpdateMessage updateMessage) {        
//        final ChangeSet resultChangeSet = getBetaNode().update(updateMessage.getChangeSet(), updateMessage.getNodeSlot());
//                
//        if (resultChangeSet.getTuples().isEmpty()) {
//            // if there was nothing to send, we are immediately ready
//            readyImmediately(updateMessage);
//        } else {
//            // if there is something to send, we send it to the approriate actor
//            final UpdateMessage propagatedUpdateMessage = new UpdateMessage(resultChangeSet, null, updateMessage.getSenderStack());
//            sendUpdateMessage(updateMessage.getSenderStack(), propagatedUpdateMessage);
//        }
//    }
//
//}
