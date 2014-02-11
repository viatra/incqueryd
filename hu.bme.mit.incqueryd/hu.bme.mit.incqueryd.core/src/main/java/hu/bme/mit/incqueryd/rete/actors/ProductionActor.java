//package hu.bme.mit.incqueryd.rete.actors;
//
//import hu.bme.mit.incqueryd.rete.configuration.IncQueryDConfiguration;
//import hu.bme.mit.incqueryd.rete.configuration.ProductionActorConfiguration;
//import hu.bme.mit.incqueryd.rete.dataunits.Tuple;
//import hu.bme.mit.incqueryd.rete.messages.ActorMessage;
//import hu.bme.mit.incqueryd.rete.messages.UpdateMessage;
//
//import java.util.HashSet;
//import java.util.Set;
//
//import akka.actor.ActorRef;
//
///**
// * 
// * @author szarnyasg
// *
// */
//public class ProductionActor extends AlphaActor {
//
//    protected Set<Tuple> memory = new HashSet<>();
//    protected ActorRef coordinator;
//
//    public ProductionActor() {
//        super();
//    }
//
//    @Override
//    protected void configure(final IncQueryDConfiguration incQueryDConfiguration) {
//        final ProductionActorConfiguration configuration = (ProductionActorConfiguration) incQueryDConfiguration;
//
//        this.coordinator = configuration.getCoordinator();
//        
//        super.configure(configuration);
//    }
//
//    @Override
//    public void onReceive(final Object message) throws Exception {
//        super.onReceive(message);
//
//        if (message instanceof UpdateMessage) {
//            final UpdateMessage updateMessage = (UpdateMessage) message;
//            update(updateMessage);
//        }
//
//        else if (message == ActorMessage.GETRESULT) {
//            sendResult();
//        }
//
//        else if (message instanceof ProductionActorConfiguration) {
//            final ProductionActorConfiguration configuration = (ProductionActorConfiguration) message;
//            configure(configuration);
//        }
//    }
//
//    protected void sendResult() {
////        logger.info(actorString() + " sending " + memory.size() + ".");
////        final UpdateMessage result = new UpdateMessage(null, null, memory);
////        getSender().tell(result, getSelf());
//    }
//
//    protected void update(final UpdateMessage updateMessage) {
////        final Collection<Tuple> updateTuples = updateMessage.getTuples();
////
////        switch (updateMessage.getUpdateType()) {
////        case POSITIVE:
////            for (final Tuple tuple : updateTuples) {
////                memory.add(tuple);
////            }
////            break;
////        case NEGATIVE:
////            for (final Tuple tuple : updateTuples) {
////                memory.remove(tuple);
////            }
////            break;
////        }
////        readyImmediately(updateMessage);
//    }
//
//}
