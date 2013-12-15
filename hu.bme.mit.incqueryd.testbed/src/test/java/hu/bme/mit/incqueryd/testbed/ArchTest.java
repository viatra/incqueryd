package hu.bme.mit.incqueryd.testbed;

import static org.junit.Assert.assertTrue;
import hu.bme.mit.incqueryd.databases.DatabaseClientType;
import hu.bme.mit.incqueryd.rete.actors.AntiJoinActor;
import hu.bme.mit.incqueryd.rete.actors.JoinActor;
import hu.bme.mit.incqueryd.rete.configuration.BetaActorConfiguration;
import hu.bme.mit.incqueryd.rete.configuration.UniquenessEnforcerNodeConfiguration;
import hu.bme.mit.incqueryd.rete.dataunits.ReteNodeSlot;
import hu.bme.mit.incqueryd.rete.dataunits.TupleMask;
import hu.bme.mit.incqueryd.rete.nodes.ProductionNode;
import infrastructure.InfrastructureNode;
import infrastructure.InfrastructurePackage;
import infrastructure.Machine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.incquery.runtime.rete.recipes.BetaRecipe;
import org.eclipse.incquery.runtime.rete.recipes.ExistenceJoinRecipe;
import org.eclipse.incquery.runtime.rete.recipes.InputRecipe;
import org.eclipse.incquery.runtime.rete.recipes.JoinRecipe;
import org.eclipse.incquery.runtime.rete.recipes.ProductionRecipe;
import org.eclipse.incquery.runtime.rete.recipes.ProjectionIndexer;
import org.eclipse.incquery.runtime.rete.recipes.RecipesPackage;
import org.eclipse.incquery.runtime.rete.recipes.ReteNodeRecipe;
import org.eclipse.incquery.runtime.rete.recipes.ReteRecipe;
import org.eclipse.incquery.runtime.rete.recipes.TrimmerRecipe;
import org.eclipse.incquery.runtime.rete.recipes.UniquenessEnforcerRecipe;
import org.junit.Test;

import akka.actor.ActorRef;
import akka.actor.Address;
import akka.actor.Deploy;
import akka.remote.RemoteScope;
import arch.ArchPackage;
import arch.Configuration;
import arch.InfrastructureMapping;

public class ArchTest {

    // file paths
    protected final int size = 1;
    protected final String modelFile = "src/test/resources/testBig_User_" + size + ".faunus-graphson";
    protected final String archFile = "src/test/resources/routeSensor-untouched.arch";
    protected DatabaseClientType databaseClientType;
    protected String filename;
    protected ActorContainer productionActor;
    protected final ActorRef coordinator = null;
    final Map<String, ActorContainer> actors = new HashMap<>();

    @Test
    public void testApp() {
        assertTrue(true);

        final Map<ReteNodeRecipe, String> names = new HashMap<>();
        final Map<ReteNodeRecipe, ReteNodeRecipe> children = new HashMap<>();
        final Map<ReteNodeRecipe, ReteNodeSlot> childrenSides = new HashMap<>();

        // initialize extension to factory map
        Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("arch", new XMIResourceFactoryImpl());
        // initialize package registry
        ArchPackage.eINSTANCE.eClass();
        InfrastructurePackage.eINSTANCE.eClass();
        RecipesPackage.eINSTANCE.eClass();

        // load resource
        final ResourceSet rs = new ResourceSetImpl();
        final Resource res = rs.getResource(URI.createFileURI(archFile), true);

        // traverse model
        final EObject o = res.getContents().get(0);

        if (o instanceof Configuration) {

            // reference
            final Map<ReteNodeRecipe, String> ips = new HashMap<>();

            final EList<InfrastructureMapping> mappings = ((Configuration) o).getMappings();
            for (final InfrastructureMapping mapping : mappings) {
                final InfrastructureNode targetElement = mapping.getTargetElement();

                final EList<ReteNodeRecipe> mappedElements = mapping.getMappedElements();
                for (final ReteNodeRecipe reteNodeRecipe : mappedElements) {
                    if (targetElement instanceof Machine) {
                        final Machine machine = (Machine) targetElement;
                        ips.put(reteNodeRecipe, machine.getIp());
                    }
                }
            }

            // ------------------------------------------------------------------------------------------------------------------
            // first iteration
            // ------------------------------------------------------------------------------------------------------------------
            for (final ReteRecipe rc : ((Configuration) o).getReteRecipes()) {
                System.out.println("Processing rete recipe " + rc.toString());

                int n = 0;
                for (final ReteNodeRecipe r : rc.getRecipeNodes()) {

                    n++;
                    final String name = "ReteNode" + n;
                    names.put(r, name);

                    // System.out.println(r.getTraceInfo());

                    final String address = ips.get(r);

                    // Beta recipes: natural join and antijoin
                    if (r instanceof BetaRecipe) {
                        System.out.println("- BetaRecipe");
                        System.out.println("# address: " + address);

                        if (r instanceof ExistenceJoinRecipe) {
                            final ExistenceJoinRecipe ejr = (ExistenceJoinRecipe) r;
                            System.out.println("  - ExistenceJoinRecipe: " + ejr);

                            // joinnode's start signal is set to false
                            actors.put(name, new ActorContainer(false, address, AntiJoinActor.class));
                        }

                        if (r instanceof JoinRecipe) {
                            final JoinRecipe jr = (JoinRecipe) r;
                            System.out.println("  - JoinRecipe: " + jr);

                            // joinnode's start signal is set to false
                            actors.put(name, new ActorContainer(false, address, JoinActor.class));
                        }

                        final BetaRecipe br = (BetaRecipe) r;

                        final ReteNodeRecipe leftGrandParent = br.getLeftParent().getParent();
                        final ReteNodeRecipe rightGrandParent = br.getRightParent().getParent();

                        final ReteNodeRecipe leftAncestor = getDistributedAncestor(leftGrandParent);
                        final ReteNodeRecipe rightAncestor = getDistributedAncestor(rightGrandParent);

                        children.put(leftAncestor, br);
                        childrenSides.put(leftAncestor, ReteNodeSlot.PRIMARY);
                        System.out.println("    LEFT> " + leftAncestor);
                        System.out.println("    # address: " + ips.get(leftAncestor));
                        children.put(rightAncestor, br);
                        childrenSides.put(rightAncestor, ReteNodeSlot.SECONDARY);
                        System.out.println("    RIGHT> " + rightAncestor);
                        System.out.println("    # address: " + ips.get(rightAncestor));
                    }

                    // Input recipes
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

                    // Production recipes
                    if (r instanceof ProductionRecipe) {

                        if (address != null) {
                            final ProductionRecipe pr = (ProductionRecipe) r;
                            System.out.println("- ProductionRecipe: " + pr);
                            System.out.println("# address: " + address);

                            final TrimmerRecipe tr = (TrimmerRecipe) pr.getParents().get(0);
                            // final UniquenessEnforcerRecipe uer = (UniquenessEnforcerRecipe) tr.getParent();
                            // final ReteNodeRecipe ancestor = uer.getParents().get(0);

                            children.put(tr.getParent(), r);

                            // joinnode's start signal is set to false
                            final ActorContainer actor = new ActorContainer(false, address, ProductionNode.class);
                            actors.put(name, actor);

                            productionActor = actor;
                        }
                    }

                }

                deployActors();
                System.out.println("### deployed");

            }

            // emitting actorContainers
            for (final Map.Entry<String, ActorContainer> actorEntry : actors.entrySet()) {
                System.out.println(actorEntry.getKey());
                System.out.println(actorEntry.getValue());
            }

            // emitting children
            for (final Map.Entry<ReteNodeRecipe, ReteNodeRecipe> entry : children.entrySet()) {
                final String key = names.get(entry.getKey());
                final String value = names.get(entry.getValue());

                System.out.println(key + " --> " + value);
            }

            // emitting children with class names
            for (final Map.Entry<ReteNodeRecipe, ReteNodeRecipe> entry : children.entrySet()) {
                final String key = names.get(entry.getKey());
                final String value = names.get(entry.getValue());

                System.out.println(key + " " + entry.getKey().getClass() + " --> " + value + " "
                        + entry.getValue().getClass());
            }

            // ------------------------------------------------------------------------------------------------------------------
            // second iteration
            // ------------------------------------------------------------------------------------------------------------------
            for (final ReteRecipe rc : ((Configuration) o).getReteRecipes()) {
                System.out.println("Processing rete recipe " + rc.toString());

                final int n = 0;
                for (final ReteNodeRecipe r : rc.getRecipeNodes()) {

                    final String address = ips.get(r);

                    // Beta recipes: join and antijoin
                    if (r instanceof BetaRecipe) {
                        System.out.println("- BetaRecipe");
                        System.out.println("# address: " + address);

                        final String name = names.get(r);
                        final ReteNodeRecipe childRecipe = children.get(r);
                        final String childName = names.get(childRecipe);

                        // System.out.println("name: " + name + " childrenname : " + childName);

                        final BetaRecipe br = (BetaRecipe) r;

                        final ArrayList<Integer> leftMaskList = extractMask(br.getLeftParent());
                        final ArrayList<Integer> rightMaskList = extractMask(br.getRightParent());

                        System.out.println(leftMaskList);
                        System.out.println(rightMaskList);

                        // JoinNode: JoinNode1
                        final TupleMask leftMask = new TupleMask(leftMaskList); // [Sp], Sw
                        final TupleMask rightMask = new TupleMask(rightMaskList); // R, [Sp]

                        System.out.println("left mask: " + leftMaskList);
                        System.out.println("right mask: " + rightMaskList);

                        final ReteNodeSlot childReteNodeSlot = childrenSides.get(r);
                        System.out.println("child name: " + childName + ", join side: " + childReteNodeSlot);

                        final BetaActorConfiguration joinNodeConfiguration = new BetaActorConfiguration(coordinator,
                                actors.get(childName).actorRef, childReteNodeSlot, leftMask, rightMask);

                        actors.get(name).configuration = joinNodeConfiguration;
                        System.out.println("---");

                        //
                        // if (r instanceof ExistenceJoinRecipe) {
                        // final ExistenceJoinRecipe ejr = (ExistenceJoinRecipe) r;
                        // System.out.println("  - ExistenceJoinRecipe: " + ejr);
                        //
                        // }
                        //
                        // if (r instanceof JoinRecipe) {
                        // final JoinRecipe jr = (JoinRecipe) r;
                        // System.out.println("  - JoinRecipe: " + jr);
                        //
                        // }

                    }

                    // Input recipes
                    if (r instanceof InputRecipe) {
                        final InputRecipe ir = (InputRecipe) r;

                        final ReteNodeRecipe childRecipe = children.get(ir);
                        final String childName = names.get(childRecipe);

                        final ReteNodeSlot childReteNodeSlot = childrenSides.get(r);
                        System.out.println("child name: " + childName + ", join side: " + childReteNodeSlot);

                        final String label = ir.getTypeIdentifier();
                        final UniquenessEnforcerNodeConfiguration config = new UniquenessEnforcerNodeConfiguration(
                                coordinator, actors.get(childName).actorRef, childReteNodeSlot, label,
                                databaseClientType, filename);
                        final String actorName = names.get(ir);
                        actors.get(actorName).configuration = config;
                    }

                    // Production recipes
                    if (r instanceof ProductionRecipe) {

                        // if (address != null) {
                        // final ProductionRecipe pr = (ProductionRecipe) r;
                        //
                        // final productionNodeConfiguration productionNodeConfiguration = new
                        // ProductionNodeConfiguration(coordinator);
                        // final String actorName = names.get(pr);
                        // actors.get(actorName).configuration = productionNodeConfiguration;
                        // }
                    }
                }
            }

            configureActors();
            System.out.println("### configured");

            System.out.println(childrenSides);

        }

    }

    protected ArrayList<Integer> extractMask(final ProjectionIndexer pI) {
        final EList<Integer> eLeftMask = pI.getMask().getSourceIndices();
        final ArrayList<Integer> mask = new ArrayList<>();
        for (final Integer integer : eLeftMask) {
            mask.add(integer);
        }
        return mask;
    }

    protected ReteNodeRecipe getDistributedAncestor(final ReteNodeRecipe recipe) {
        if (recipe instanceof UniquenessEnforcerRecipe) {
            final UniquenessEnforcerRecipe uer = (UniquenessEnforcerRecipe) recipe;
            final ReteNodeRecipe ancestor = uer.getParents().get(0);
            return getDistributedAncestor(ancestor);
        }

        if (recipe instanceof ProductionRecipe) {
            final ProductionRecipe pr = (ProductionRecipe) recipe;
            final ReteNodeRecipe ancestor = pr.getParents().get(0);
            return getDistributedAncestor(ancestor);
        }

        if (recipe instanceof TrimmerRecipe) {
            final TrimmerRecipe tr = (TrimmerRecipe) recipe;
            final ReteNodeRecipe ancestor = tr.getParent();
            return getDistributedAncestor(ancestor);
        }

        return recipe;
    }

    protected void deployActors() {
        for (final Map.Entry<String, ActorContainer> actorContainerPair : actors.entrySet()) {

            final String name = actorContainerPair.getKey();
            final ActorContainer actor = actorContainerPair.getValue();

            final String host = actor.host;
            final Class actorClass = actor.actorClass;
            final Address addr = new Address("akka", "ReteNet", host, 2552);
            final Deploy deploy = new Deploy(new RemoteScope(addr));
//            logger.info("Deploying " + name + " to " + host);
            // final ActorRef actor = system.actorOf(new Props(actorClass).withDeploy(deploy), name);

            // saving the reference for later use
//            actor.actorRef = getContext().actorOf(new Props(actorClass).withDeploy(deploy), name);
            // TODO fix this
        }
    }

    private void configureActors() {
        // telling the configuration object to each actor
        for (final ActorContainer actor : actors.values()) {
            System.out.println("Configuring: " + actor);
            actor.actorRef.tell(actor.configuration, null);
        }
    }

}
