package hu.bme.mit.incqueryd.testbed;

import static org.junit.Assert.assertTrue;
import hu.bme.mit.incqueryd.databases.DatabaseClientType;
import hu.bme.mit.incqueryd.io.GraphSonLoader;
import hu.bme.mit.incqueryd.rete.dataunits.ReteNodeSlot;
import hu.bme.mit.incqueryd.rete.dataunits.Tuple;
import hu.bme.mit.incqueryd.rete.dataunits.TupleMask;
import hu.bme.mit.incqueryd.rete.nodes.AntiJoinNode;
import hu.bme.mit.incqueryd.rete.nodes.JoinNode;
import hu.bme.mit.incqueryd.rete.nodes.ReteNode;
import infrastructure.InfrastructurePackage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.incquery.runtime.rete.recipes.BetaRecipe;
import org.eclipse.incquery.runtime.rete.recipes.ExistenceJoinRecipe;
import org.eclipse.incquery.runtime.rete.recipes.JoinRecipe;
import org.eclipse.incquery.runtime.rete.recipes.ProjectionIndexer;
import org.eclipse.incquery.runtime.rete.recipes.RecipesPackage;
import org.eclipse.incquery.runtime.rete.recipes.ReteNodeRecipe;
import org.eclipse.incquery.runtime.rete.recipes.ReteRecipe;
import org.eclipse.incquery.runtime.rete.recipes.UniquenessEnforcerRecipe;
import org.junit.Test;

import akka.actor.ActorRef;
import akka.actor.Address;
import akka.actor.Deploy;
import akka.remote.RemoteScope;
import arch.ArchPackage;
import arch.Configuration;

/**
 * Testing a pure Java Rete network (without Akka) based on the architecture (arch) descriptor files.
 * 
 * @author szarnyasg
 * 
 */
public class ArchTest {

    // file paths
    protected final int size = 1;
    protected final String modelFile = "src/test/resources/testBig_User_" + size + ".faunus-graphson";
    protected final String archFile = "src/test/resources/routeSensor-untouched.arch";
    // protected final String archFile = "src/test/resources/routeSensor-vcl.arch";
    protected DatabaseClientType databaseClientType;
    protected String filename;
    protected ActorContainer productionActor;
    protected final ActorRef coordinator = null;
    final Map<String, ActorContainer> actors = new HashMap<>();

    @Test
    public void testApp() throws IOException {
        assertTrue(true);

        final Map<ReteNodeRecipe, String> names = new HashMap<>();

        // parent-children pairs
        final Map<ReteNodeRecipe, ReteNodeRecipe> children = new HashMap<>();
        // parent-slot pairs
        final Map<ReteNodeRecipe, ReteNodeSlot> childrenSlots = new HashMap<>();

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

            // // reference
            // final Map<ReteNodeRecipe, String> ips = new HashMap<>();
            //
            // final EList<InfrastructureMapping> mappings = ((Configuration) o).getMappings();
            // for (final InfrastructureMapping mapping : mappings) {
            // final InfrastructureNode targetElement = mapping.getTargetElement();
            //
            // final EList<ReteNodeRecipe> mappedElements = mapping.getMappedElements();
            // for (final ReteNodeRecipe reteNodeRecipe : mappedElements) {
            // if (targetElement instanceof Machine) {
            // final Machine machine = (Machine) targetElement;
            // ips.put(reteNodeRecipe, machine.getIp());
            // }
            // }
            // }

            // vertex type and properties
            final Map<String, Collection<String>> vertexTypesAndProperties = new HashMap<>();

            // edge labels
            final Collection<String> edgeLabels = new LinkedList<>();

            // ------------------------------------------------------------------------------------------------------------------
            // first iteration
            // ------------------------------------------------------------------------------------------------------------------
            for (final ReteRecipe rc : ((Configuration) o).getReteRecipes()) {
                System.out.println("Processing Rete recipe " + rc.toString());

                int n = 0;
                for (final ReteNodeRecipe r : rc.getRecipeNodes()) {
                    n++;
                    final String name = "ReteNode" + n;
                    names.put(r, name);

                    ReteNode reteNode = null;

                    // UniquenessEnforcer recipes
                    if (r instanceof UniquenessEnforcerRecipe) {
                        System.out.println("- UniquenessEnforcer recipe");

                        final UniquenessEnforcerRecipe uer = (UniquenessEnforcerRecipe) r;

                        // traceInfo looks something like "UniquenessEnforcerNode : Route_routeDefinition :  [0]"
                        final String traceInfo = uer.getTraceInfo();
                        // extracting the type information from the traceInfo
                        // TODO add a separate field for this to the architecture's Xcore file
                        final String patternString = ": (\\w*) :";

                        final Pattern pattern = Pattern.compile(patternString);
                        final Matcher m = pattern.matcher(traceInfo);
                        String edgeLabel;
                        if (m.find()) {
                            edgeLabel = m.group(1);
                        } else {
                            throw new RuntimeException("Invalid UniquenessEnforcerRecipe");
                        }

                        edgeLabels.add(edgeLabel);
                    }

                    // Beta recipes: join and antijoin
                    if (r instanceof BetaRecipe) {
                        System.out.println("- Beta recipe");

                        final BetaRecipe br = (BetaRecipe) r;

                        // extract indexer masks
                        final TupleMask primaryMask = new TupleMask(br.getLeftParent().getMask().getSourceIndices());
                        final TupleMask secondaryMask = new TupleMask(br.getRightParent().getMask().getSourceIndices());

                        // Rete node parents
                        final ReteNodeRecipe primaryParent = br.getLeftParent().getParent();
                        final ReteNodeRecipe secondaryParent = br.getRightParent().getParent();

                        // adding reverse references to the children
                        children.put(primaryParent, r);
                        childrenSlots.put(primaryParent, ReteNodeSlot.PRIMARY);

                        children.put(secondaryParent, r);
                        childrenSlots.put(secondaryParent, ReteNodeSlot.SECONDARY);

                        
                        if (br instanceof JoinRecipe) {
                            final JoinRecipe jr = (JoinRecipe) r;
                            System.out.println("  - Join recipe: " + jr);

                            reteNode = new JoinNode(primaryMask, secondaryMask);
                        }

                        if (br instanceof ExistenceJoinRecipe) {
                            final ExistenceJoinRecipe ejr = (ExistenceJoinRecipe) r;
                            System.out.println("  - ExistenceJoin recipe: " + ejr);

                            reteNode = new AntiJoinNode(primaryMask, secondaryMask);
                        }


                    }

                }

                // loading the graph
                final GraphSonLoader graphSonLoader = new GraphSonLoader(modelFile, vertexTypesAndProperties,
                        edgeLabels);
                final Map<String, Set<Tuple>> vertexTuplesMap = graphSonLoader.getVertexTuplesMap();
                final Map<String, Set<Tuple>> edgeTuplesMap = graphSonLoader.getEdgeTuplesMap();

                System.out.println("vertex tuples");
                for (final Entry<String, Set<Tuple>> entry : vertexTuplesMap.entrySet()) {
                    System.out.println(entry);
                }

                System.out.println("edge tuples");
                for (final Entry<String, Set<Tuple>> entry : edgeTuplesMap.entrySet()) {
                    System.out.println(entry);
                }

                // final ReteNodeRecipe childRecipe = children.get(uer);
                // final String childName = names.get(childRecipe);
                //
                // System.out.println("child name: " + childName + ", join side: " + childReteNodeSlot);

                // final String label = ir.getTypeIdentifier();
                // final UniquenessEnforcerNodeConfiguration config = new UniquenessEnforcerNodeConfiguration(
                // coordinator, actors.get(childName).actorRef, childReteNodeSlot, label,
                // databaseClientType, filename);
                // final String actorName = names.get(ir);
                // actors.get(actorName).configuration = config;

                //
                // final Map<String, Collection<String>> vertexTypesAndProperties = new HashMap<>();
                // final Collection<String> edgeLabels = ImmutableList.of(Route_routeDefinition, Route_switchPosition,
                // SwitchPosition_switch, TrackElement_sensor);
                // load(vertexTypesAndProperties, edgeLabels);

                // // vertex type and properties
                // final Map<String, Collection<String>> vertexTypesAndProperties = new HashMap<>();
                // vertexTypesAndProperties.put("Segment", ImmutableList.of("a", "b"));
                //
                // // edge labels
                // final Collection<String> edgeLabels = ImmutableList.of("e1", "e2");

                // loading the graph
                // final GraphSonLoader graphSonLoader = new GraphSonLoader(modelFile, vertexTypesAndProperties,
                // edgeLabels);
                // final Map<String, Set<Tuple>> vertexTuplesMap = graphSonLoader.getVertexTuplesMap();
                // final Map<String, Set<Tuple>> edgeTuplesMap = graphSonLoader.getEdgeTuplesMap();
                //
                // System.out.println(vertexTuplesMap);
                // System.out.println(edgeTuplesMap);

                // final ReteNodeRecipe childRecipe = children.get(uer);
                // final String childName = names.get(childRecipe);
                //
                // final ReteNodeSlot childReteNodeSlot = childrenSides.get(r);
                // System.out.println("child name: " + childName + ", join side: " + childReteNodeSlot);

                // final String label = ir.getTypeIdentifier();
                // final UniquenessEnforcerNodeConfiguration config = new UniquenessEnforcerNodeConfiguration(
                // coordinator, actors.get(childName).actorRef, childReteNodeSlot, label,
                // databaseClientType, filename);
                // final String actorName = names.get(ir);
                // actors.get(actorName).configuration = config;

                //
                // final Map<String, Collection<String>> vertexTypesAndProperties = new HashMap<>();
                // final Collection<String> edgeLabels = ImmutableList.of(Route_routeDefinition, Route_switchPosition,
                // SwitchPosition_switch, TrackElement_sensor);
                // load(vertexTypesAndProperties, edgeLabels);

                // final Set<Tuple> route_routeDefinitionTuples = edgeTuplesMap.get(Route_routeDefinition); //
                // Route, Sensor
                // final Set<Tuple> route_switchPositionTuples = edgeTuplesMap.get(Route_switchPosition); // Route,
                // SwitchPosition
                // final Set<Tuple> switchPosition_switchTuples = edgeTuplesMap.get(SwitchPosition_switch); //
                // SwitchPosition,
                // // Switch
                // final Set<Tuple> trackElement_sensorTuples = edgeTuplesMap.get(TrackElement_sensor); // Switch,
                // Sensor
                // final ChangeSet route_routeDefinitionChangeSet = new ChangeSet(route_routeDefinitionTuples,
                // ChangeType.POSITIVE);
                // final ChangeSet route_switchPositionChangeSet = new ChangeSet(route_switchPositionTuples,
                // ChangeType.POSITIVE);
                // final ChangeSet switchPosition_switchChangeSet = new ChangeSet(switchPosition_switchTuples,
                // ChangeType.POSITIVE);
                // final ChangeSet trackElement_sensorChangeSet = new ChangeSet(trackElement_sensorTuples,
                // ChangeType.POSITIVE);
                //
                // logMessage("Route_switchPosition JOIN SwitchPosition_switch");
                // logMessage("<Route, SwitchPosition, Switch>");
                // final TupleMask leftMask1 = new TupleMask(ImmutableList.of(1));
                // final TupleMask rightMask1 = new TupleMask(ImmutableList.of(0));
                // final JoinNode joinNode1 = new JoinNode(leftMask1, rightMask1);
                // final ChangeSet resultChangeSet1 = Algorithms.join(joinNode1, route_switchPositionChangeSet,
                // switchPosition_switchChangeSet);
                // logResult(resultChangeSet1.getTuples().toString());
                // logMessage(resultChangeSet1.getTuples().size() + " tuples");
                //
                // logMessage("Route_switchPosition JOIN SwitchPosition_switch JOIN TrackElement_sensor");
                // logMessage("<Route, SwitchPosition, Switch, Sensor>");
                // final TupleMask leftMask2 = new TupleMask(ImmutableList.of(2));
                // final TupleMask rightMask2 = new TupleMask(ImmutableList.of(0));
                // final JoinNode joinNode2 = new JoinNode(leftMask2, rightMask2);
                // final ChangeSet resultChangeSet2 = Algorithms.join(joinNode2, resultChangeSet1,
                // trackElement_sensorChangeSet);
                // logResult(resultChangeSet2.getTuples().toString());
                // logMessage(resultChangeSet2.getTuples().size() + " tuples");
                //
                // logMessage("Route_switchPosition JOIN SwitchPosition_switch JOIN TrackElement_sensor ANTIJOIN Route_routeDefinition");
                // logMessage("<Route, SwitchPosition, Switch, Sensor>");
                // final TupleMask leftMask3 = new TupleMask(ImmutableList.of(3));
                // final TupleMask rightMask3 = new TupleMask(ImmutableList.of(1));
                // final AntiJoinNode joinNode3 = new AntiJoinNode(leftMask3, rightMask3);
                // final ChangeSet resultChangeSet3 = Algorithms.join(joinNode3, resultChangeSet2,
                // route_routeDefinitionChangeSet);
                // logResult(resultChangeSet3.getTuples().toString());
                // logMessage(resultChangeSet3.getTuples().size() + " tuples");
                //
                // logMessage("PROJECTION_{0} (");
                // logMessage("Route_switchPosition JOIN SwitchPosition_switch JOIN TrackElement_sensor ANTIJOIN Route_routeDefinition");
                // logMessage("<Route>");
                // final TupleMask projectionMask = new TupleMask(ImmutableList.of(0));
                // final TrimmerNode trimmerNode = new TrimmerNode(projectionMask);
                // final ChangeSet resultChangeSet4 = trimmerNode.update(resultChangeSet3);
                // logResult(resultChangeSet4.getTuples().toString());
                // logMessage(resultChangeSet4.getTuples().size() + " tuples");
                //
                // assertEquals(12, resultChangeSet4.getTuples().size());

                // deployActors();
                // System.out.println("# deployed");

                // }

            }
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

    protected void deployActors() {
        for (final Map.Entry<String, ActorContainer> actorContainerPair : actors.entrySet()) {

            final String name = actorContainerPair.getKey();
            final ActorContainer actor = actorContainerPair.getValue();

            final String host = actor.host;
            final Class actorClass = actor.actorClass;
            final Address addr = new Address("akka", "ReteNet", host, 2552);
            final Deploy deploy = new Deploy(new RemoteScope(addr));
            // logger.info("Deploying " + name + " to " + host);
            // final ActorRef actor = system.actorOf(new Props(actorClass).withDeploy(deploy), name);

            // saving the reference for later use
            // actor.actorRef = getContext().actorOf(new Props(actorClass).withDeploy(deploy), name);
            // TODO fix this
        }
    }

    // private void configureActors() {
    // // telling the configuration object to each actor
    // for (final ActorContainer actor : actors.values()) {
    // System.out.println("Configuring: " + actor);
    // actor.actorRef.tell(actor.configuration, null);
    // }
    // }

}
