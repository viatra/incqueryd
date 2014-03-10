package hu.bme.mit.incqueryd.rete.actors;

import hu.bme.mit.incqueryd.arch.ArchUtil;
import hu.bme.mit.incqueryd.rete.dataunits.ChangeSet;
import hu.bme.mit.incqueryd.rete.dataunits.ReteNodeSlot;
import hu.bme.mit.incqueryd.rete.messages.ActorReply;
import hu.bme.mit.incqueryd.rete.messages.ReadyMessage;
import hu.bme.mit.incqueryd.rete.messages.SubscriptionMessage;
import hu.bme.mit.incqueryd.rete.messages.UpdateMessage;
import hu.bme.mit.incqueryd.rete.messages.YellowPages;
import hu.bme.mit.incqueryd.rete.nodes.AlphaNode;
import hu.bme.mit.incqueryd.rete.nodes.BetaNode;
import hu.bme.mit.incqueryd.rete.nodes.ReteNode;
import hu.bme.mit.incqueryd.rete.nodes.ReteNodeFactory;
import hu.bme.mit.incqueryd.util.RecipeDeserializer;
import hu.bme.mit.incqueryd.util.ReteNodeConfiguration;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang.NotImplementedException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.incquery.runtime.rete.recipes.AlphaRecipe;
import org.eclipse.incquery.runtime.rete.recipes.BetaRecipe;
import org.eclipse.incquery.runtime.rete.recipes.ReteNodeRecipe;

import scala.Tuple2;
import scala.collection.immutable.Stack;
import akka.actor.ActorRef;
import akka.actor.UntypedActor;

public class ReteActor extends UntypedActor {

	protected EObject recipe;
	protected ReteNode reteNode;
	protected Map<ActorRef, ReteNodeSlot> subscribers = new HashMap<>();

	public ReteActor() {
		super();
		System.out.println("[ReteActor] Rete actor instantiated.");
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
			recipe = RecipeDeserializer.deserializeFromString(conf.getRecipeString());

			reteNode = ReteNodeFactory.createNode(recipe);
			System.out.println("[ReteActor] " + reteNode.getClass().getName() + " configuration received.");

			getSender().tell(ActorReply.CONFIGURATION_RECEIVED, getSelf());
		} else if (message instanceof UpdateMessage) {
			final UpdateMessage updateMessage = (UpdateMessage) message;
			update(updateMessage);
		} else if (message instanceof YellowPages) {
			final YellowPages yellowPages = (YellowPages) message;
			subscribe(yellowPages);
			getSender().tell(ActorReply.YELLOWPAGES_RECEIVED, getSelf());
		} else if (message instanceof ReadyMessage) {
			final ReadyMessage readyMessage = (ReadyMessage) message;
			terminationProtocol(readyMessage);
		}
	}

	private void subscribe(final YellowPages yellowPages) {
		final Map<String, ActorRef> emfUriToActorRef = yellowPages.getEmfUriToActorRef();

		System.out.println();
		// EcoreUtil.resolveAll(recipe);
		System.out.println("[ReteActor] " + getSelf() + ": " + ArchUtil.justFirstLine(recipe.toString()));

		// alpha and production nodes
		if (recipe instanceof AlphaRecipe) {
			final AlphaRecipe alphaRecipe = (AlphaRecipe) recipe;
			final ReteNodeRecipe parent = alphaRecipe.getParent();

			final String parentUri = ArchUtil.getJsonEObjectUri(parent);
			final ActorRef parentActorRef = emfUriToActorRef.get(parentUri);
			System.out.println("[ReteActor] - parent: " + parentUri + " -> " + parentActorRef);

			subscribeToActor(parentActorRef, ReteNodeSlot.SINGLE);
		}

		// beta nodes
		if (recipe instanceof BetaRecipe) {
			final BetaRecipe betaRecipe = (BetaRecipe) recipe;
			final ReteNodeRecipe primaryParent = betaRecipe.getLeftParent().getParent();
			final ReteNodeRecipe secondaryParent = betaRecipe.getRightParent().getParent();

			final String primaryParentUri = ArchUtil.getJsonEObjectUri(primaryParent);
			System.out.println("[ReteActor] - primary parent URI: " + primaryParentUri + " -> "
					+ emfUriToActorRef.get(primaryParentUri));
			final ActorRef primaryParentActorRef = emfUriToActorRef.get(primaryParentUri);

			final String secondaryParentUri = ArchUtil.getJsonEObjectUri(secondaryParent);
			System.out.println("[ReteActor] - secondary parent URI: " + secondaryParentUri + " -> "
					+ emfUriToActorRef.get(secondaryParentUri));
			final ActorRef secondaryParentActorRef = emfUriToActorRef.get(secondaryParentUri);

			subscribeToActor(primaryParentActorRef, ReteNodeSlot.PRIMARY);
			subscribeToActor(secondaryParentActorRef, ReteNodeSlot.SECONDARY);
		}
	}

	private void update(final UpdateMessage updateMessage) {
		ChangeSet changeSet;

		switch (updateMessage.getNodeSlot()) {
		case SINGLE:
			final AlphaNode alphaNode = (AlphaNode) reteNode;
			changeSet = alphaNode.update(updateMessage.getChangeSet());
			break;
		case PRIMARY: // fall-through
		case SECONDARY:
			final BetaNode betaNode = (BetaNode) reteNode;
			changeSet = betaNode.update(updateMessage.getChangeSet(), updateMessage.getNodeSlot());
			break;
		default:
			throw new NotImplementedException(updateMessage.getNodeSlot() + " slot is not supported.");
		}

		// processing
		sendToSubscribers(changeSet, updateMessage.getSenderStack());
	}

	private void terminationProtocol(final ReadyMessage readyMessage) {
		final Stack<ActorRef> route = readyMessage.getRoute();

		final Tuple2<ActorRef, Stack<ActorRef>> pair = route.pop2();
		final ActorRef readyMessageTarget = pair._1();
		final Stack<ActorRef> readyMessageSenderStack = pair._2();

		final ReadyMessage propagatedReadyMessage = new ReadyMessage(readyMessageSenderStack);
		readyMessageTarget.tell(propagatedReadyMessage, getSelf());

		System.out.println("[ReteActor] Termination protocol sending: " + readyMessageSenderStack + " to "
				+ readyMessageTarget);
	}

	protected void subscribeSender(final ReteNodeSlot slot) {
		final ActorRef sender = getSender();

		subscribers.put(sender, slot);
		sender.tell(ActorReply.SUBSCRIBED, getSelf());
		System.out.println("[ReteActor] " + getSelf() + ": Subscribed: " + sender + " on slot " + slot);
	}

	protected void subscribeToActor(final ActorRef actorRef, final ReteNodeSlot slot) {
		final SubscriptionMessage message = ArchUtil.slotToMessage(slot);
		actorRef.tell(message, getSelf());
		try {
			Thread.sleep(200);
		} catch (final InterruptedException e) {
			e.printStackTrace();
		}
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
