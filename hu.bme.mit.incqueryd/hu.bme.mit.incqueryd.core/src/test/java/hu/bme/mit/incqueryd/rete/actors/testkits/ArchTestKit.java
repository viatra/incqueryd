package hu.bme.mit.incqueryd.rete.actors.testkits;

import hu.bme.mit.incqueryd.rete.actors.ReteActor;
import hu.bme.mit.incqueryd.rete.messages.ActorReply;
import hu.bme.mit.incqueryd.rete.messages.YellowPages;
import hu.bme.mit.incqueryd.util.RecipeSerializer;
import hu.bme.mit.incqueryd.util.ReteNodeConfiguration;
import infrastructure.InfrastructureNode;
import infrastructure.InfrastructurePackage;
import infrastructure.Machine;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.incquery.runtime.rete.recipes.RecipesPackage;
import org.eclipse.incquery.runtime.rete.recipes.ReteNodeRecipe;
import org.eclipse.incquery.runtime.rete.recipes.ReteRecipe;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.testkit.JavaTestKit;
import arch.ArchPackage;
import arch.Configuration;
import arch.InfrastructureMapping;

public class ArchTestKit extends JavaTestKit {

	protected final ActorSystem system;
	protected final String architectureFile;
	protected final JavaTestKit coordinatorActor;
	protected final JavaTestKit targetActor;

	public ArchTestKit(final ActorSystem system, final String architectureFile) throws IOException {
		super(system);
		this.system = system;
		this.architectureFile = architectureFile;

		coordinatorActor = new JavaTestKit(system);
		targetActor = new JavaTestKit(system);
	}

	public void test() throws IOException {
		// initialize extension to factory map
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("arch", new XMIResourceFactoryImpl());

		// initialize package registry
		// initialize the RecipesPackage before the others
		RecipesPackage.eINSTANCE.eClass();
		InfrastructurePackage.eINSTANCE.eClass();
		ArchPackage.eINSTANCE.eClass();

		// load resource
		final ResourceSet resourceSet = new ResourceSetImpl();
		final Resource resource = resourceSet.getResource(URI.createFileURI(architectureFile), true);

		// traverse model
		final EObject o = resource.getContents().get(0);

		if (o instanceof Configuration) {
			final Configuration conf = (Configuration) o;
			processConfiguration(resourceSet, conf);
		}
	}

	
	// Rete recipe <-> IP address mapping
	final Map<ReteNodeRecipe, String> recipeToIp = new HashMap<>();
	// Rete recipe <-> ActorRef
	final Map<ReteNodeRecipe, ActorRef> recipeToActorRef = new HashMap<>();
	// EMF URI <-> Rete recipe
	final Map<String, ReteNodeRecipe> emfUriToRecipe = new HashMap<>();
	// EMF URI <-> ActorRef
	final Map<String, ActorRef> emfUriToActorRef = new HashMap<>();
	// collection of ActorRefs
	final Collection<ActorRef> actorRefs = new HashSet<>();
	
	private void processConfiguration(final ResourceSet resourceSet, final Configuration conf) throws IOException {
		// mapping
		fillRecipeToIp(conf);
		// phase one
		deployActors(conf);
		// mapping
		fillEmfUriToActorRef();
		// phase two
		subscribeActors(conf);
	}

	private void fillRecipeToIp(final Configuration conf) {
		final EList<InfrastructureMapping> mappings = conf.getMappings();
		for (final InfrastructureMapping mapping : mappings) {
			final InfrastructureNode targetElement = mapping.getTargetElement();

			final EList<ReteNodeRecipe> mappedElements = mapping.getMappedElements();
			for (final ReteNodeRecipe reteNodeRecipe : mappedElements) {
				if (targetElement instanceof Machine) {
					final Machine machine = (Machine) targetElement;
					recipeToIp.put(reteNodeRecipe, machine.getIp());
				}
			}
		}
	}

	private void fillEmfUriToActorRef() {
		for (final Map.Entry<String, ReteNodeRecipe> emfURIAndRecipe : emfUriToRecipe.entrySet()) {
			final String emfURI = emfURIAndRecipe.getKey();
			final ReteNodeRecipe recipe = emfURIAndRecipe.getValue();

			final ActorRef akkaUri = recipeToActorRef.get(recipe);

			emfUriToActorRef.put(emfURI, akkaUri);
		}
		for (final Map.Entry<String, ActorRef> entry : emfUriToActorRef.entrySet()) {
			System.out.println(entry.getKey() + " => " + entry.getValue());
		}
	}

	private void deployActors(final Configuration conf)
			throws IOException {
		for (final ReteRecipe rr : conf.getReteRecipes()) {
			for (final ReteNodeRecipe rnr : rr.getRecipeNodes()) {
				System.out.println("[TestKit] Recipe: " + rnr.getClass().getName());

				final String ipAddress = recipeToIp.get(rnr);
				final String emfUri = EcoreUtil.getURI(rnr).toString();
				System.out.println("[TestKit] - IP address:  " + ipAddress);
				System.out.println("[TestKit] - EMF address: " + emfUri);
				emfUriToRecipe.put(emfUri, rnr);

				// create a clone, else we would get a java.util.ConcurrentModificationException
				final ReteNodeRecipe rnrClone = EcoreUtil.copy(rnr);
				final String recipeString = RecipeSerializer.serializeToString(rnrClone);

				// TODO programmatic remote deployment goes here
				final Props props = new Props(ReteActor.class);
				final ActorRef actorRef = system.actorOf(props);
				configure(actorRef, recipeString);

				actorRefs.add(actorRef);
				recipeToActorRef.put(rnr, actorRef);
				System.out.println("[TestKit] Actor configured.");

				// System.out.println(serialized);
				// final EObject deserializeFromString = RecipeDeserializer.deserializeFromString(serialized);
				// System.out.println(deserializeFromString);

				System.out.println();
			}
		}
		System.out.println("[ReteActor] All actors deployed and configured.");
	}

	private void subscribeActors(final Configuration conf) {
		final YellowPages yellowPages = new YellowPages(emfUriToActorRef);
		
		for (final ActorRef actorRef : actorRefs) {
			actorRef.tell(yellowPages, coordinatorActor.getRef());
			coordinatorActor.expectMsgEquals(duration("1 second"), ActorReply.YELLOWPAGES_RECEIVED);
		}
	}

	private void configure(final ActorRef actor, final String recipeString) {
		final ReteNodeConfiguration conf = new ReteNodeConfiguration(recipeString);
		actor.tell(conf, coordinatorActor.getRef());
		coordinatorActor.expectMsgEquals(duration("1 second"), ActorReply.CONFIGURATION_RECEIVED);
	}

	// @formatter:off
	/**
	 * 
	 *  (coordinatorActor) <--------------> (reteActor)
     *                          (A) >
     *                          (B) <
     * 
     *  (A) ! ReteNodeConfiguration
     *  (B) ? CONFIGURATION_RECEIVED
	 */
	// @formatter:on
	public void configure(final ActorRef testedActor, final ReteNodeConfiguration conf) {
		// Act
		// message (A)
		testedActor.tell(conf, coordinatorActor.getRef());
		// Assert
		// message (B)
		coordinatorActor.expectMsgEquals(duration("1 second"), ActorReply.CONFIGURATION_RECEIVED);
	}
	
//	private EObject getEObjectFromURI(final ResourceSet resourceSet, final String uriString) {
//		final URI uri = URI.createURI(uriString);
//		final EObject eObject = resourceSet.getEObject(uri, true);
//		return eObject;
//	}
	// //
	// ------------------------------------------------------------------------------------------------------------------
	// // first iteration
	// //
	// ------------------------------------------------------------------------------------------------------------------
	// for (final ReteRecipe rc : ((Configuration) o).getReteRecipes()) {
	// System.out.println("Processing rete recipe " + rc.toString());
	//
	// int n = 0;
	// for (final ReteNodeRecipe r : rc.getRecipeNodes()) {
	//
	// n++;
	// final String name = "ReteNode" + n;
	// names.put(r, name);
	//
	// // System.out.println(r.getTraceInfo());
	//
	// final String address = ips.get(r);
	//
	// // Beta recipes: natural join and antijoin
	// if (r instanceof BetaRecipe) {
	// System.out.println("- BetaRecipe");
	// System.out.println("# address: " + address);
	//
	// if (r instanceof ExistenceJoinRecipe) {
	// final ExistenceJoinRecipe ejr = (ExistenceJoinRecipe) r;
	// System.out.println("  - ExistenceJoinRecipe: " + ejr);
	//
	// // joinnode's start signal is set to false
	// actors.put(name, new ActorContainer(false, address, ExistenceNode.class));
	// }
	//
	// if (r instanceof JoinRecipe) {
	// final JoinRecipe jr = (JoinRecipe) r;
	// System.out.println("  - JoinRecipe: " + jr);
	//
	// // joinnode's start signal is set to false
	// actors.put(name, new ActorContainer(false, address, NaturalJoinNode.class));
	// }
	//
	// final BetaRecipe br = (BetaRecipe) r;
	//
	// final ReteNodeRecipe leftGrandParent = br.getLeftParent().getParent();
	// final ReteNodeRecipe rightGrandParent = br.getRightParent().getParent();
	//
	// final ReteNodeRecipe leftAncestor = getDistributedAncestor(leftGrandParent);
	// final ReteNodeRecipe rightAncestor = getDistributedAncestor(rightGrandParent);
	//
	// children.put(leftAncestor, br);
	// childrenSides.put(leftAncestor, JoinSide.PRIMARY);
	// System.out.println("    LEFT> " + leftAncestor);
	// System.out.println("    # address: " + ips.get(leftAncestor));
	// children.put(rightAncestor, br);
	// childrenSides.put(rightAncestor, JoinSide.SECONDARY);
	// System.out.println("    RIGHT> " + rightAncestor);
	// System.out.println("    # address: " + ips.get(rightAncestor));
	// }
	//
	// // Input recipes
	// if (r instanceof InputRecipe) {
	// final InputRecipe ir = (InputRecipe) r;
	// System.out.println("- InputRecipe: " + ir);
	// System.out.println("# address: " + address);
	//
	// // inputnode's start signal is set to true
	// final ActorContainer actor = new ActorContainer(true, address, InputNode.class);
	// actors.put(name, actor);
	//
	// if (ir.getTypeIdentifier().equals("Route_routeDefinition")) {
	// route_routeDefinitionActor = actor;
	// }
	// }
	//
	// // Production recipes
	// if (r instanceof ProductionRecipe) {
	//
	// if (address != null) {
	// final ProductionRecipe pr = (ProductionRecipe) r;
	// System.out.println("- ProductionRecipe: " + pr);
	// System.out.println("# address: " + address);
	//
	// final TrimmerRecipe tr = (TrimmerRecipe) pr.getParents().get(0);
	// // final UniquenessEnforcerRecipe uer = (UniquenessEnforcerRecipe) tr.getParent();
	// // final ReteNodeRecipe ancestor = uer.getParents().get(0);
	//
	// children.put(tr.getParent(), r);
	//
	// // joinnode's start signal is set to false
	// final ActorContainer actor = new ActorContainer(false, address, ProductionNode.class);
	// actors.put(name, actor);
	//
	// productionNode = actor;
	// }
	// }
	//
	// }
	//
	// deployActors();
	// System.out.println("### deployed");
	//
	// }
	//
	// // emitting actorContainers
	// for (final Map.Entry<String, ActorContainer> actorEntry : actors.entrySet()) {
	// System.out.println(actorEntry.getKey());
	// System.out.println(actorEntry.getValue());
	// }
	//
	// // emitting children
	// for (final Map.Entry<ReteNodeRecipe, ReteNodeRecipe> entry : children.entrySet()) {
	// final String key = names.get(entry.getKey());
	// final String value = names.get(entry.getValue());
	//
	// System.out.println(key + " --> " + value);
	// }
	//
	// // emitting children with class names
	// for (final Map.Entry<ReteNodeRecipe, ReteNodeRecipe> entry : children.entrySet()) {
	// final String key = names.get(entry.getKey());
	// final String value = names.get(entry.getValue());
	//
	// System.out.println(key + " " + entry.getKey().getClass() + " --> " + value + " " +
	// entry.getValue().getClass());
	// }
	//
	// //
	// ------------------------------------------------------------------------------------------------------------------
	// // second iteration
	// //
	// ------------------------------------------------------------------------------------------------------------------
	// for (final ReteRecipe rc : ((Configuration) o).getReteRecipes()) {
	// System.out.println("Processing rete recipe " + rc.toString());
	//
	// final int n = 0;
	// for (final ReteNodeRecipe r : rc.getRecipeNodes()) {
	//
	// final String address = ips.get(r);
	//
	// // Beta recipes: natural join and antijoin
	// if (r instanceof BetaRecipe) {
	// System.out.println("- BetaRecipe");
	// System.out.println("# address: " + address);
	//
	// final String name = names.get(r);
	// final ReteNodeRecipe childRecipe = children.get(r);
	// final String childName = names.get(childRecipe);
	//
	// //System.out.println("name: " + name + " childrenname : " + childName);
	//
	// final BetaRecipe br = (BetaRecipe) r;
	//
	// final ArrayList<Integer> leftMaskList = extractMask(br.getLeftParent());
	// final ArrayList<Integer> rightMaskList = extractMask(br.getRightParent());
	//
	// System.out.println(leftMaskList);
	// System.out.println(rightMaskList);
	//
	// // JoinNode: JoinNode1
	// final TupleMask leftMask = new TupleMask(leftMaskList, null); // [Sp], Sw
	// final TupleMask rightMask = new TupleMask(rightMaskList, null); // R, [Sp]
	//
	// System.out.println("left mask: " + leftMaskList);
	// System.out.println("right mask: " + rightMaskList);
	//
	// final JoinSide childJoinSide = childrenSides.get(r);
	// System.out.println("child name: " + childName + ", join side: " + childJoinSide);
	//
	// final JoinNodeConfiguration joinNodeConfiguration = new JoinNodeConfiguration(coordinator, leftMask,
	// rightMask,
	// actors.get(childName).actorRef.path().toString(), childJoinSide);
	//
	//
	// actors.get(name).configuration = joinNodeConfiguration;
	// System.out.println("---");
	//
	//
	// //
	// // if (r instanceof ExistenceJoinRecipe) {
	// // final ExistenceJoinRecipe ejr = (ExistenceJoinRecipe) r;
	// // System.out.println("  - ExistenceJoinRecipe: " + ejr);
	// //
	// // }
	// //
	// // if (r instanceof JoinRecipe) {
	// // final JoinRecipe jr = (JoinRecipe) r;
	// // System.out.println("  - JoinRecipe: " + jr);
	// //
	// // }
	//
	// }
	//
	// // Input recipes
	// if (r instanceof InputRecipe) {
	// final InputRecipe ir = (InputRecipe) r;
	//
	// final ReteNodeRecipe childRecipe = children.get(ir);
	// final String childName = names.get(childRecipe);
	//
	// final JoinSide childJoinSide = childrenSides.get(r);
	// System.out.println("child name: " + childName + ", join side: " + childJoinSide);
	//
	// final String label = ir.getTypeIdentifier();
	// final UniquenessEnforcerNodeConfiguration config = new UniquenessEnforcerNodeConfiguration(
	// coordinator, actors.get(childName).actorRef.path().toString(),
	// label, childJoinSide, databaseClientType, filename);
	// final String actorName = names.get(ir);
	// actors.get(actorName).configuration = config;
	// }
	//
	// // Production recipes
	// if (r instanceof ProductionRecipe) {
	//
	// if (address != null) {
	// final ProductionRecipe pr = (ProductionRecipe) r;
	//
	// final ProductionNodeConfiguration productionNodeConfiguration = new ProductionNodeConfiguration(coordinator);
	// final String actorName = names.get(pr);
	// actors.get(actorName).configuration = productionNodeConfiguration;
	// }
	// }
	// }
	// }

//	// @formatter:off
//	/**
//	 *   (testedActor)
//	 *         ^
//	 *         |
//	 *         | (A) ^
//	 *         | (B) V
//	 *         |
//	 *         V
//	 *   (targetActor) 
//	 * 
//	 *  (A) ! SUBSCRIBE_SINGLE
//	 *  (B) ? SUBSCRIBED
//	 */
//	// @formatter:on
	// public void subscribe(final JavaTestKit targetActor, final ActorRef testedActor) {
	// // Act
	// // message (A)
	// testedActor.tell(SubscriptionMessage.SUBSCRIBE_SINGLE, targetActor.getRef());
	// // Assert
	// // message (B)
	// targetActor.expectMsgEquals(duration("1 second"), ActorReply.SUBSCRIBED);
	// }
	//
//	// @formatter:off
//	/**
//	 *   (parentActor)
//	 *         ^
//	 *         |
//	 *         |  (A) V
//	 *         |  (D) ^
//	 *         |
//	 *         V
//	 *   (testedActor)
//	 *         ^
//	 *         |
//	 *         |  (B) V
//	 *         |  (C) ^
//	 *         |
//	 *         V
//	 *   (targetActor) 
//	 *     
//	 *  (A) ! UpdateMessage, stack: [parentActor] 
//	 *  (B) ? UpdateMessage, stack: [parentActor, testedActor]
//	 *  (C) ! ReadyMessage, stack: [parentActor]
//	 *  (D) ? ReadyMessage, stack: []
//	 */
//	// @formatter:on
	// public void testComputation(final JavaTestKit parentActor, final ActorRef testedActor,
	// final JavaTestKit targetActor, final ChangeSet incomingChangeSet, final ChangeSet expectedChangeSet,
	// final ReteNodeSlot targetSlot) {
	// // Act
	// // message (A) !
	// final Stack<ActorRef> messageAStack = Stack$.MODULE$.empty().push(parentActor.getRef());
	// final UpdateMessage messageA = new UpdateMessage(incomingChangeSet, targetSlot, messageAStack);
	// testedActor.tell(messageA, parentActor.getRef());
	//
	// // Assert
	// // message (B) ?
	// final Stack<ActorRef> messageBStack = messageAStack.push(testedActor);
	// final UpdateMessage expectedMessageB = new UpdateMessage(expectedChangeSet, ReteNodeSlot.SINGLE, messageBStack);
	// final UpdateMessage actualMessageB = targetActor.expectMsgClass(duration("1 second"), UpdateMessage.class);
	//
	// // System.out.println("exp: " + expectedMessageB);
	// // System.out.println("act: " + actualMessageB);
	//
	// assertEquals(expectedMessageB, actualMessageB);
	//
	// // termination protocol
	// // Act
	// // message (C) !
	// final Tuple2<ActorRef, Stack<ActorRef>> pair = actualMessageB.getSenderStack().pop2();
	// final ActorRef terminationActorRef = pair._1();
	// final Stack<ActorRef> messageCStack = pair._2();
	// final ReadyMessage messageC = new ReadyMessage(messageCStack);
	// terminationActorRef.tell(messageC, targetActor.getRef());
	//
	// // Assert
	// // message (D) ?
	// // we expect a ReadyMessage with an empty stack as the sender route
	// final ReadyMessage expectedMessageD = new ReadyMessage(Stack$.MODULE$.empty());
	// final ReadyMessage actualMessageD = parentActor.expectMsgClass(duration("1 second"), ReadyMessage.class);
	// assertEquals(expectedMessageD, actualMessageD);
	// }

	// final String uriString = "src/test/resources/arch/routeSensor.arch#//@reteRecipes.0/@recipeNodes.2";
	// final EObject eObject = getEObjectFromURI(resourceSet, uriString);
	// System.out.println(eObject);
	// final String ip = ips.get(eObject);
	// System.out.println(ip);

	// for (final Entry<ReteNodeRecipe, String> entry : ips.entrySet()) {
	// System.out.println("Recipe");
	// System.out.println("======");
	// System.out.println("trace info: " + entry.getKey());
	// System.out.println("ip address: " + entry.getValue());
	// System.out.println();
	// }
	// System.out.println();

	// System.out.println("RNR:  " + EcoreUtil.getURI(rnr) + "        --->     " + address);
	// System.out.println("RNRC: " + EcoreUtil.getURI(rnrClone) + "           " + ips.get(rnrClone));
	// System.out.println(rnrClone);

}
