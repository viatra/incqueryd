package hu.bme.mit.incqueryd.rete.actors;

import hu.bme.mit.incqueryd.arch.ArchUtil;
import hu.bme.mit.incqueryd.rete.dataunits.ChangeSet;
import hu.bme.mit.incqueryd.rete.dataunits.ReteNodeSlot;
import hu.bme.mit.incqueryd.rete.messages.ActorReply;
import hu.bme.mit.incqueryd.rete.messages.CoordinatorMessage;
import hu.bme.mit.incqueryd.rete.messages.SubscriptionMessage;
import hu.bme.mit.incqueryd.rete.messages.TerminationMessage;
import hu.bme.mit.incqueryd.rete.messages.UpdateMessage;
import hu.bme.mit.incqueryd.rete.messages.YellowPages;
import hu.bme.mit.incqueryd.rete.nodes.AlphaNode;
import hu.bme.mit.incqueryd.rete.nodes.BetaNode;
import hu.bme.mit.incqueryd.rete.nodes.InitializableReteNode;
import hu.bme.mit.incqueryd.rete.nodes.InputNode;
import hu.bme.mit.incqueryd.rete.nodes.ProductionNode;
import hu.bme.mit.incqueryd.rete.nodes.ReteNode;
import hu.bme.mit.incqueryd.rete.nodes.ReteNodeFactory;
import hu.bme.mit.incqueryd.util.RecipeDeserializer;
import hu.bme.mit.incqueryd.util.ReteNodeConfiguration;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang.NotImplementedException;
import org.eclipse.emf.common.util.EList;
import org.eclipse.incquery.runtime.rete.recipes.AlphaRecipe;
import org.eclipse.incquery.runtime.rete.recipes.BetaRecipe;
import org.eclipse.incquery.runtime.rete.recipes.ProductionRecipe;
import org.eclipse.incquery.runtime.rete.recipes.ReteNodeRecipe;

import scala.Tuple2;
import scala.collection.immutable.Stack;
import scala.collection.immutable.Stack$;
import akka.actor.ActorRef;
import akka.actor.UntypedActor;

public class ReteActor extends UntypedActor {

	protected ReteNodeRecipe recipe;
	protected ReteNode reteNode;
	protected Map<ActorRef, ReteNodeSlot> subscribers = new HashMap<>();
	protected int pendingTerminationMessages;
	protected ActorRef coordinatorRef;

	public ReteActor() {
		super();
		System.out.println("[ReteActor] Rete actor instantiated.");
	}

	@Override
	public void onReceive(final Object message) throws Exception {
		// subscription messages
		if (message == SubscriptionMessage.SUBSCRIBE_SINGLE) {
			subscribeSender(ReteNodeSlot.SINGLE);
		} else if (message == SubscriptionMessage.SUBSCRIBE_PRIMARY) {
			subscribeSender(ReteNodeSlot.PRIMARY);
		} else if (message == SubscriptionMessage.SUBSCRIBE_SECONDARY) {
			subscribeSender(ReteNodeSlot.SECONDARY);
		} // configuration
		else if (message instanceof ReteNodeConfiguration) {
			System.out.println(">>>>>>>>>>>>>>>>>>>>>> Self: " + getSelf() + "; coordinator: " + getSender());
			
			final ReteNodeConfiguration conf = (ReteNodeConfiguration) message;
			recipe = (ReteNodeRecipe) RecipeDeserializer.deserializeFromString(conf.getRecipeString());

			reteNode = ReteNodeFactory.createNode(recipe);
			System.out.println("[ReteActor] " + reteNode.getClass().getName() + " configuration received.");

			// sending CONFIGURATION_RECEIVED to the coordinator
			getSender().tell(ActorReply.CONFIGURATION_RECEIVED, getSelf());
		} // update
		else if (message instanceof UpdateMessage) {
			final UpdateMessage updateMessage = (UpdateMessage) message;
			update(updateMessage);

			if (reteNode instanceof ProductionNode) {
				terminationProtocol(new TerminationMessage(updateMessage.getSenderStack()));
			}
		} // yellowpages
		else if (message instanceof YellowPages) {
			final YellowPages yellowPages = (YellowPages) message;
			subscribe(yellowPages);
			getSender().tell(ActorReply.YELLOWPAGES_RECEIVED, getSelf());
		} // ready message
		else if (message instanceof TerminationMessage) {
			final TerminationMessage terminationMessage = (TerminationMessage) message;
			terminationProtocol(terminationMessage);
		} // initialize
		else if (message == CoordinatorMessage.INITIALIZE) {
			coordinatorRef = getSender();
			
			System.out.println("[ReteActor] " + getSelf() + ": INITIALIZE received");
			final InitializableReteNode node = (InitializableReteNode) reteNode;
			final ChangeSet changeSet = node.initialize();
			final Stack<ActorRef> emptyStack = Stack$.MODULE$.<ActorRef> empty();
			sendToSubscribers(changeSet, emptyStack);			
		}
	}

	private void subscribe(final YellowPages yellowPages) {
		final Map<String, ActorRef> emfUriToActorRef = yellowPages.getEmfUriToActorRef();

		System.out.println();
		// EcoreUtil.resolveAll(recipe);
		System.out.println("[ReteActor] " + getSelf() + ", " + reteNode.getClass().getName() + ": "
				+ ArchUtil.oneLiner(recipe.toString()));

		// alpha nodes
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
			final ActorRef primaryParentActorRef = emfUriToActorRef.get(primaryParentUri);
			System.out
					.println("[ReteActor] - primary parent URI: " + primaryParentUri + " -> " + primaryParentActorRef);

			final String secondaryParentUri = ArchUtil.getJsonEObjectUri(secondaryParent);
			final ActorRef secondaryParentActorRef = emfUriToActorRef.get(secondaryParentUri);
			System.out.println("[ReteActor] - secondary parent URI: " + secondaryParentUri + " -> "
					+ secondaryParentActorRef);

			subscribeToActor(primaryParentActorRef, ReteNodeSlot.PRIMARY);
			subscribeToActor(secondaryParentActorRef, ReteNodeSlot.SECONDARY);
		}

		// production nodes
		if (recipe instanceof ProductionRecipe) {
			final ProductionRecipe productionRecipe = (ProductionRecipe) recipe;
			final EList<ReteNodeRecipe> parents = productionRecipe.getParents();

			for (final ReteNodeRecipe parent : parents) {
				final String parentUri = ArchUtil.getJsonEObjectUri(parent);
				final ActorRef parentActorRef = emfUriToActorRef.get(parentUri);
				System.out.println("[ReteActor] - parent URI: " + parentUri + " -> " + parentActorRef);

				subscribeToActor(parentActorRef, ReteNodeSlot.SINGLE);
			}
		}
	}

	private void update(final UpdateMessage updateMessage) {
		System.out.println("[ReteActor] " + getSelf() + ", " + reteNode.getClass().getName()
				+ ": update message received, " + updateMessage.getChangeSet().getChangeType() + " "
				+ updateMessage.getNodeSlot());

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

	private void terminationProtocol(final TerminationMessage readyMessage) {
		final Stack<ActorRef> route = readyMessage.getRoute();

		if (reteNode instanceof InputNode) {
			if (route.isEmpty()) {
				pendingTerminationMessages--;
			}

			if (pendingTerminationMessages == 0) {
				coordinatorRef.tell(CoordinatorMessage.TERMINATED, getSelf());

				System.out.println(coordinatorRef);
				
				System.out.println("+======================================+");
				System.out.println("|          you're terminated           |");
				System.out.println("+======================================+");
			}
			
			return;
		}

		final Tuple2<ActorRef, Stack<ActorRef>> pair = route.pop2();
		final ActorRef readyMessageTarget = pair._1();
		final Stack<ActorRef> readyMessageSenderStack = pair._2();

		final TerminationMessage propagatedReadyMessage = new TerminationMessage(readyMessageSenderStack);
		readyMessageTarget.tell(propagatedReadyMessage, getSelf());

		System.out.println("[ReteActor] Termination protocol sending: " + readyMessageSenderStack + " to "
				+ readyMessageTarget);

		return;

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
		if (reteNode instanceof InputNode) {
			pendingTerminationMessages = subscribers.entrySet().size();
		}
		
		for (final Entry<ActorRef, ReteNodeSlot> entry : subscribers.entrySet()) {
			final ActorRef subscriber = entry.getKey();
			final ReteNodeSlot slot = entry.getValue();

			final Stack<ActorRef> propagatedSenderStack = senderStack.push(getSelf());
			final UpdateMessage updateMessage = new UpdateMessage(changeSet, slot, propagatedSenderStack);

			System.out.println("[ReteActor] " + getSelf() + ", " + reteNode.getClass().getName() + ", "
					+ ArchUtil.oneLiner(recipe.getTraceInfo()) + ": Sending to " + subscriber + "\n" + "            - "
					+ changeSet.getChangeType() + " changeset, tuple size: " + changeSet.getTuples().size() + "\n"
					+ "            - with sender stack: " + propagatedSenderStack + "\n" + "            - "
					+ pendingTerminationMessages + " pending");
			subscriber.tell(updateMessage, getSelf());
		}
	}
}
