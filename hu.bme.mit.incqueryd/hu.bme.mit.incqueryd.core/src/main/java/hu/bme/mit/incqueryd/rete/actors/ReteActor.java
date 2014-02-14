package hu.bme.mit.incqueryd.rete.actors;

import hu.bme.mit.incqueryd.rete.dataunits.ChangeSet;
import hu.bme.mit.incqueryd.rete.dataunits.ReteNodeSlot;
import hu.bme.mit.incqueryd.rete.messages.ActorReply;
import hu.bme.mit.incqueryd.rete.messages.ReadyMessage;
import hu.bme.mit.incqueryd.rete.messages.SubscriptionMessage;
import hu.bme.mit.incqueryd.rete.messages.UpdateMessage;
import hu.bme.mit.incqueryd.rete.nodes.AlphaNode;
import hu.bme.mit.incqueryd.rete.nodes.AntiJoinNode;
import hu.bme.mit.incqueryd.rete.nodes.EqualityNode;
import hu.bme.mit.incqueryd.rete.nodes.InequalityNode;
import hu.bme.mit.incqueryd.rete.nodes.JoinNode;
import hu.bme.mit.incqueryd.rete.nodes.ReteNode;
import hu.bme.mit.incqueryd.rete.nodes.TrimmerNode;
import hu.bme.mit.incqueryd.util.RecipeSerializer;
import hu.bme.mit.incqueryd.util.ReteNodeConfiguration;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang.NotImplementedException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.incquery.runtime.rete.recipes.BetaRecipe;
import org.eclipse.incquery.runtime.rete.recipes.EqualityFilterRecipe;
import org.eclipse.incquery.runtime.rete.recipes.InequalityFilterRecipe;
import org.eclipse.incquery.runtime.rete.recipes.JoinRecipe;
import org.eclipse.incquery.runtime.rete.recipes.TrimmerRecipe;

import scala.Tuple2;
import scala.collection.immutable.Stack;
import akka.actor.ActorRef;
import akka.actor.UntypedActor;

public class ReteActor extends UntypedActor {

	protected ReteNode reteNode;
	protected Map<ActorRef, ReteNodeSlot> subscribers = new HashMap<>();

	public ReteActor() {
		System.out.println("Rete actor instantiated.");
	}

	@Override
	public void onReceive(final Object message) throws Exception {

		if (message == SubscriptionMessage.SUBSCRIBE_SINGLE) {
			subscribeSender(ReteNodeSlot.SINGLE);
		} else if (message == SubscriptionMessage.SUBSCRIBE_PRIMARY) {
			subscribeSender(ReteNodeSlot.PRIMARY);
		} else if (message == SubscriptionMessage.SUBSCRIBE_SECONDARY) {
			subscribeSender(ReteNodeSlot.SECONDARY);
		} else if (message instanceof ReteNodeConfiguration) {
			
			final ReteNodeConfiguration conf = (ReteNodeConfiguration) message;
			final EObject recipe = RecipeSerializer.deserializeFromString(conf.getJsonRecipe());
						
			switch (conf.getType()) {
			case ANTIJOIN_NODE:
				reteNode = new AntiJoinNode((BetaRecipe)recipe);
				break;
			case EQUALITY_NODE:
				reteNode = new EqualityNode((EqualityFilterRecipe)recipe);
				break;
			case INEQUALITY_NODE:
				reteNode = new InequalityNode((InequalityFilterRecipe)recipe);
				break;
			case JOIN_NODE:
				reteNode = new JoinNode((JoinRecipe)recipe);
				break;
			case TRIMMER_NODE:
				reteNode = new TrimmerNode((TrimmerRecipe)recipe);
				break;
			default:
				throw new NotImplementedException(message.getClass().getSimpleName()
						+ " recipe class is not supported.");
			}
			getSender().tell(ActorReply.RECIPE_RECEIVED, getSelf());
			
//		} else if (message instanceof ReteNodeRecipe) {
//			// Rete nodes
//
//			// Alpha node recipes
//			if (message instanceof TrimmerRecipe) {
//				final TrimmerRecipe recipe = (TrimmerRecipe) message;
//				reteNode = new TrimmerNode(recipe);
//			} else if (message instanceof EqualityFilterRecipe) {
//				final EqualityFilterRecipe recipe = (EqualityFilterRecipe) message;
//				reteNode = new EqualityNode(recipe);
//			} else if (message instanceof InequalityFilterRecipe) {
//				final InequalityFilterRecipe recipe = (InequalityFilterRecipe) message;
//				reteNode = new InequalityNode(recipe);
//			} // Beta node recipes
//			else if (message instanceof JoinRecipe) {
//				final JoinRecipe recipe = (JoinRecipe) message;
//				reteNode = new JoinNode(recipe);
//			} else if (message instanceof AntiJoinRecipe) {
//				final AntiJoinRecipe recipe = (AntiJoinRecipe) message;
//				reteNode = new AntiJoinNode(recipe);
//			} // unsupported recipe
//			else {
//				throw new NotImplementedException(message.getClass().getSimpleName()
//						+ " recipe class is not supported.");
//			}
//
//			getSender().tell(ActorReply.RECIPE_RECEIVED, getSelf());
		} else if (message instanceof UpdateMessage) {
			final UpdateMessage updateMessage = (UpdateMessage) message;

			// processing
			final AlphaNode alphaNode = (AlphaNode) reteNode;
			final ChangeSet changeSet = alphaNode.update(updateMessage.getChangeSet());
			sendToSubscribers(changeSet, updateMessage.getSenderStack());
		} else if (message instanceof ReadyMessage) {
			final ReadyMessage readyMessage = (ReadyMessage) message;
			terminationProtocol(readyMessage);
		}

	}

	private void terminationProtocol(final ReadyMessage readyMessage) {
		final Stack<ActorRef> route = readyMessage.getRoute();

		final Tuple2<ActorRef, Stack<ActorRef>> pair = route.pop2();
		final ActorRef readyMessageTarget = pair._1();
		final Stack<ActorRef> readyMessageSenderStack = pair._2();

		final ReadyMessage propagatedReadyMessage = new ReadyMessage(readyMessageSenderStack);
		readyMessageTarget.tell(propagatedReadyMessage, getSelf());

		System.out.println();
		System.out.println("Termination protocol sending: " + readyMessageSenderStack);
	}

	protected void subscribeSender(final ReteNodeSlot slot) {
		final ActorRef sender = getSender();

		subscribers.put(sender, slot);
		sender.tell(ActorReply.SUBSCRIBED, getSelf());
		System.out.println("Subscribed: " + sender);
	}

	protected void sendToSubscribers(final ChangeSet changeSet, final Stack<ActorRef> senderStack) {
		for (final Entry<ActorRef, ReteNodeSlot> entry : subscribers.entrySet()) {
			final ActorRef subscriber = entry.getKey();
			final ReteNodeSlot slot = entry.getValue();

			final Stack<ActorRef> propagatedSenderStack = senderStack.push(getSelf());
			final UpdateMessage updateMessage = new UpdateMessage(changeSet, slot, propagatedSenderStack);
			subscriber.tell(updateMessage, getSelf());
		}
	}

}
