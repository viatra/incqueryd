package hu.bme.mit.incqueryd.tooling.ide.util;

import hu.bme.mit.incqueryd.arch.util.ArchUtil;
import hu.bme.mit.incqueryd.csp.algorithm.data.Container;
import hu.bme.mit.incqueryd.csp.algorithm.data.ContainerTemplate;
import hu.bme.mit.incqueryd.csp.algorithm.data.Node;
import infrastructure.InfrastructureFactory;
import infrastructure.Machine;
import infrastructure.Process;
import inventory.InstanceSet;
import inventory.Inventory;
import inventory.MachineInstance;
import inventory.MachineSet;
import inventory.MachineTemplate;
import inventory.MemoryUnit;
import inventory.TemplateSet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.incquery.runtime.rete.recipes.AlphaRecipe;
import org.eclipse.incquery.runtime.rete.recipes.BetaRecipe;
import org.eclipse.incquery.runtime.rete.recipes.MultiParentNodeRecipe;
import org.eclipse.incquery.runtime.rete.recipes.ProductionRecipe;
import org.eclipse.incquery.runtime.rete.recipes.ReteNodeRecipe;
import org.eclipse.incquery.runtime.rete.recipes.ReteRecipe;
import org.eclipse.incquery.runtime.rete.recipes.TypeInputRecipe;

import arch.ArchFactory;
import arch.Configuration;
import arch.InfrastructureMapping;
import arch.ReteRole;

public class ReteAllocator {
	
	private int[][] overheads;
	private final List<Container> containers = new ArrayList<>();
	private final List<ContainerTemplate> containerTemplates = new ArrayList<>();
	
	private int[][] edges;
	private final List<Node> nodes = new ArrayList<>();
	
	private final Map<Long, List<ReteNodeRecipe>> processes = new HashMap<>();
	
	private boolean optimizeForCost;
	private String recipeFile;
	private String inventoryFile;
	 private String outputFile;
	
	public ReteAllocator(boolean optimizeForCost, String recipeFile, String inventoryFile, String outputFile) {
		this.optimizeForCost = optimizeForCost;
		this.recipeFile = recipeFile;
		this.inventoryFile = inventoryFile;
		this.outputFile = outputFile;
	}
	
	public void allocate () throws IOException {
		processInventory(inventoryFile);
		
		ReteRecipe recipe = ArchUtil.loadRecipe(recipeFile);
		
		createProcesses(recipe);
		
		createNodesAndEdges(recipe);
	}

	private void createProcesses(ReteRecipe recipe) {
		EList<ReteNodeRecipe> recipeNodes = recipe.getRecipeNodes();
		
		for (ReteNodeRecipe reteNodeRecipe : recipeNodes) {
			System.out.println(reteNodeRecipe.getClass().getSimpleName() + " " + ArchUtil.getJsonEObjectUri(reteNodeRecipe));
		}
		System.out.println();
		
		List<ReteNodeRecipe> remainingReteNodes = new ArrayList<>();
		
		Set<ReteNodeRecipe> recipesToDelete = new HashSet<>();
		
		long id_counter = 1;
		
		for(int i = 0; i < recipeNodes.size(); i++) {
			ReteNodeRecipe reteNodeRecipe = recipeNodes.get(i);
			// These node types have memory --> go to separate jvm
			if(reteNodeRecipe instanceof BetaRecipe || reteNodeRecipe instanceof ProductionRecipe || reteNodeRecipe instanceof TypeInputRecipe) {
				List<ReteNodeRecipe> nodes = new ArrayList<>();
				nodes.add(reteNodeRecipe);
				processes.put(id_counter, nodes);
				id_counter++;
			}
			else {
				remainingReteNodes.add(reteNodeRecipe);
			}
		}
		
		for (ReteNodeRecipe node : remainingReteNodes) {
			System.out.println(node.getClass().getSimpleName() + " " + ArchUtil.getJsonEObjectUri(node));
		}
		
		while(!remainingReteNodes.isEmpty()) {
			for(int i = 0; i < remainingReteNodes.size(); i++) {
				ReteNodeRecipe parent = null;
				ReteNodeRecipe _this = null;
				_this = remainingReteNodes.get(i);
				if(_this instanceof AlphaRecipe) {
					AlphaRecipe alphaRecipe = (AlphaRecipe)_this; // it is alpha as all betas were removed in first iteration as they have memory
					parent = alphaRecipe.getParent(); // parent of this node
				}
				else if(_this instanceof MultiParentNodeRecipe) {
					MultiParentNodeRecipe multiParentRecipe = (MultiParentNodeRecipe)_this; // it is alpha as all betas were removed in first iteration as they have memory
					parent = multiParentRecipe.getParents().get(0); // parent of this node
				}
				
				String uriOfParent = ArchUtil.getJsonEObjectUri(parent);
				for (Long jvmID : processes.keySet()) {
					// if its parent was in this jvm then add it to the jvm's 1st place
					if(uriOfParent.equals(ArchUtil.getJsonEObjectUri(processes.get(jvmID).get(0)))) {
						processes.get(jvmID).add(0, _this);
						recipesToDelete.add(_this);
						break;
					}
				}
			}
			// delete recently allocated Rete nodes
			for (ReteNodeRecipe toDelete : recipesToDelete) {
				remainingReteNodes.remove(toDelete);
			}
			recipesToDelete.clear();
			// continue until there are unallocated nodes
		}
		
		System.out.println();
		for (Long jvmID : processes.keySet()) {
			System.out.println(jvmID + ". jvm:");
			for (ReteNodeRecipe node : processes.get(jvmID)) {
				System.out.println(node.getClass().getSimpleName() + " " + ArchUtil.getJsonEObjectUri(node));
			}
			System.out.println();
		}
	}
	
	
	private void createNodesAndEdges(ReteRecipe recipe) {
		
		Set<Long> processSet = processes.keySet();
		for (Long process : processSet) {
			Node node = new Node(process.longValue(), process.toString(), 1000);
			nodes.add(node);
		}
		
		edges = new int[nodes.size()][nodes.size()];
		for(int i = 0; i < edges.length; i++) {
			int[] row = edges[i];
			for(int j = 0; j < row.length; j++) {
				edges[i][j] = 0;
			}
		}
		
		EList<ReteNodeRecipe> recipeNodes = recipe.getRecipeNodes();
		for (ReteNodeRecipe reteNodeRecipe : recipeNodes) {
			if(reteNodeRecipe instanceof BetaRecipe) {
				BetaRecipe betaRecipe = (BetaRecipe) reteNodeRecipe;
				long[] processesOfParents = getProcessesOfParents(betaRecipe.getLeftParent().getParent(),betaRecipe.getRightParent().getParent());
				for (long l : processesOfParents) {
					System.out.println(l);
				}
			}
			else if(reteNodeRecipe instanceof AlphaRecipe) {
				long[] processesOfParents = getProcessesOfParents(((AlphaRecipe) reteNodeRecipe).getParent());
				for (long l : processesOfParents) {
					System.out.println(l);
				}
			}
		}
		
	}
	
	private long[] getProcessesOfParents(ReteNodeRecipe... parents) {
		long[] parentProcessIds = new long[parents.length];
		
		int i = 0;
		
		Set<Long> processSet = processes.keySet();
		for (ReteNodeRecipe parent : parents) {
			String uriOfParent = ArchUtil.getJsonEObjectUri(parent);
			for (Long process : processSet) {
				List<ReteNodeRecipe> nodesInProcess = processes.get(process);
				for (ReteNodeRecipe reteNodeRecipe : nodesInProcess) {
					if(uriOfParent.equals(ArchUtil.getJsonEObjectUri(reteNodeRecipe))) {
						parentProcessIds[i] = process.longValue();
						i++;
						break;
					}
				}
			}
		}
		
		return parentProcessIds;
	}
	
	private void processInventory (String inventoryFile) throws IOException {
		Inventory inventory = ArchUtil.loadInventory(inventoryFile);
		
		MachineSet machineSet = inventory.getMachineSet();
		
		if(machineSet instanceof TemplateSet) {
			TemplateSet templateSet = (TemplateSet)machineSet;
			
			EList<MachineTemplate> machineTemplates = templateSet.getMachineTemplates();
			overheads = new int[machineTemplates.size()][machineTemplates.size()];
			
			for(int i=0; i < machineTemplates.size(); i++) {
				MachineTemplate machineTemplate = machineTemplates.get(i);
				ContainerTemplate containerTemplate = new ContainerTemplate(getMemoryInMBs(machineTemplate.getMemoryUnit(), machineTemplate.getMemorySize()), machineTemplate.getCost(), machineTemplate.getIdentifier());
				containerTemplates.add(containerTemplate);
				for(int j = 0; j < machineTemplate.getOverheads().size(); j++) {
					overheads[i][j] = machineTemplate.getOverheads().get(j).intValue();
				}
			}
			
		}
		else {
			InstanceSet instanceSet = (InstanceSet)machineSet;
			
			EList<MachineInstance> machineInstances = instanceSet.getMachineInstances();
			overheads = new int[machineInstances.size()][machineInstances.size()];
			
			for(int i=0; i < machineInstances.size(); i++) {
				MachineInstance machineInstance = machineInstances.get(i);
				Container container = new Container(getMemoryInMBs(machineInstance.getMemoryUnit(), machineInstance.getMemorySize()), machineInstance.getCost(), machineInstance.getIp());
				containers.add(container);
				for(int j = 0; j < machineInstance.getOverheads().size(); j++) {
					overheads[i][j] = machineInstance.getOverheads().get(j).intValue();
				}
			}
			
		}
	}
	
	private static int getMemoryInMBs(MemoryUnit memUnit, int memorySize) {
		switch (memUnit) {
		case MB:
			return memorySize;
			
		case GB:
			return 1024 * memorySize;

		default:
			return 0;
		}
	}
	
	
	// The NULL allocator, this method is static
	public static void allocateNull (String recipeFile, String outputFile) throws IOException {
		ReteRecipe recipe = ArchUtil.loadRecipe(recipeFile);
		
		final Configuration configuration = ArchFactory.eINSTANCE.createConfiguration();
		configuration.setConnectionString("fourstore://trainbenchmark_cluster");
		
		final Machine machine = InfrastructureFactory.eINSTANCE.createMachine();
		machine.setIp("127.0.0.1");
		machine.setName("local");
		
		final Process process = InfrastructureFactory.eINSTANCE.createProcess();
		process.setPort(2552);
		
		machine.getProcesses().add(process);
		
		configuration.getMachines().add(machine);
		configuration.getRecipes().add(recipe);
		configuration.setCoordinatorMachine(machine);
		configuration.setMonitoringMachine(machine);
		
		InfrastructureMapping infrastructureMapping = ArchFactory.eINSTANCE.createInfrastructureMapping();
		infrastructureMapping.setProcess(process);
		
		EList<ReteNodeRecipe> recipeNodes = recipe.getRecipeNodes();
		
		for (ReteNodeRecipe reteNodeRecipe : recipeNodes) {
			ReteRole reteRole = ArchFactory.eINSTANCE.createReteRole();
			reteRole.setNodeRecipe(reteNodeRecipe);
			infrastructureMapping.getRoles().add(reteRole);
		}
		
		configuration.getMappings().add(infrastructureMapping);
		
		ResourceSet resSet = new ResourceSetImpl();
		Resource resource = resSet.createResource(URI.createFileURI(outputFile));
		resource.getContents().add(configuration);
		
		try {
		      resource.save(Collections.EMPTY_MAP);
		} catch (IOException e) {
			
		}
	}
	
}
