package hu.bme.mit.incqueryd.csp.util;

import hu.bme.mit.incqueryd.arch.util.ArchUtil;
import hu.bme.mit.incqueryd.csp.algorithm.AllocationSolver;
import hu.bme.mit.incqueryd.csp.algorithm.data.Allocation;
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

import java.io.File;
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

	private final Map<Integer, List<ReteNodeRecipe>> processes = new HashMap<>();

	private boolean optimizeForCommunication;
	private String recipeFile;
	private String inventoryFile;
	private String architectureFile;

	private Inventory inventory;

	public ReteAllocator(boolean optimizeForCost, String recipeFile, String inventoryFile, String architectureFile) {
		this.optimizeForCommunication = optimizeForCost;
		this.recipeFile = recipeFile;
		this.inventoryFile = inventoryFile;
		this.architectureFile = architectureFile;
	}

	public boolean allocate() throws IOException {
		processInventory(inventoryFile);

		ReteRecipe recipe = ArchUtil.loadRecipe(recipeFile);

		createProcesses(recipe);

		createNodesAndEdges(recipe);

		boolean optimizedAllocation = optimizedAllocation();

		return optimizedAllocation;
	}

	private void createProcesses(ReteRecipe recipe) throws IOException {
		EList<ReteNodeRecipe> recipeNodes = recipe.getRecipeNodes();

		for (ReteNodeRecipe reteNodeRecipe : recipeNodes) {
			System.out.println(reteNodeRecipe.getClass().getSimpleName() + " "
					+ ArchUtil.getJsonEObjectUri(reteNodeRecipe));
		}
		System.out.println();

		List<ReteNodeRecipe> remainingReteNodes = new ArrayList<>();

		Set<ReteNodeRecipe> recipesToDelete = new HashSet<>();

		int id_counter = 1;

		for (int i = 0; i < recipeNodes.size(); i++) {
			ReteNodeRecipe reteNodeRecipe = recipeNodes.get(i);
			// These node types have memory --> go to separate jvm
			if (reteNodeRecipe instanceof BetaRecipe || reteNodeRecipe instanceof ProductionRecipe
					|| reteNodeRecipe instanceof TypeInputRecipe) {
				List<ReteNodeRecipe> nodes = new ArrayList<>();
				nodes.add(reteNodeRecipe);
				processes.put(id_counter, nodes);
				id_counter++;
			} else {
				remainingReteNodes.add(reteNodeRecipe);
			}
		}

		for (ReteNodeRecipe node : remainingReteNodes) {
			System.out.println(node.getClass().getSimpleName() + " " + ArchUtil.getJsonEObjectUri(node));
		}

		while (!remainingReteNodes.isEmpty()) {
			for (int i = 0; i < remainingReteNodes.size(); i++) {
				ReteNodeRecipe parent = null;
				ReteNodeRecipe _this = null;
				_this = remainingReteNodes.get(i);
				if (_this instanceof AlphaRecipe) {
					AlphaRecipe alphaRecipe = (AlphaRecipe) _this; // it is alpha as all betas were removed in first
																	// iteration as they have memory
					parent = alphaRecipe.getParent(); // parent of this node
				} else if (_this instanceof MultiParentNodeRecipe) {
					MultiParentNodeRecipe multiParentRecipe = (MultiParentNodeRecipe) _this; // it is alpha as all betas
																								// were removed in first
																								// iteration as they
																								// have memory
					parent = multiParentRecipe.getParents().get(0); // parent of this node
				}

				String uriOfParent = ArchUtil.getJsonEObjectUri(parent);
				for (Integer jvmID : processes.keySet()) {
					// if its parent was in this jvm then add it to the jvm's 1st place
					if (uriOfParent.equals(ArchUtil.getJsonEObjectUri(processes.get(jvmID).get(0)))) {
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
		for (Integer jvmID : processes.keySet()) {
			System.out.println(jvmID + ". jvm:");
			for (ReteNodeRecipe node : processes.get(jvmID)) {
				System.out.println(node.getClass().getSimpleName() + " " + ArchUtil.getJsonEObjectUri(node));
			}
			System.out.println();
		}
	}

	private void createNodesAndEdges(ReteRecipe recipe) {

		Set<Integer> processSet = processes.keySet();
		for (Integer process : processSet) {
			Node node = new Node(process.intValue(), process.toString(), 1000);
			nodes.add(node);
		}

		edges = new int[nodes.size()][nodes.size()];
		for (int i = 0; i < edges.length; i++) {
			int[] row = edges[i];
			for (int j = 0; j < row.length; j++) {
				edges[i][j] = 0;
			}
		}

		EList<ReteNodeRecipe> recipeNodes = recipe.getRecipeNodes();
		for (ReteNodeRecipe reteNodeRecipe : recipeNodes) {
			int processId = getProcessOfReteNode(reteNodeRecipe);

			if (reteNodeRecipe instanceof BetaRecipe) {
				BetaRecipe betaRecipe = (BetaRecipe) reteNodeRecipe;
				int[] processesOfParents = getProcessesOfParents(betaRecipe, betaRecipe.getLeftParent().getParent(),
						betaRecipe.getRightParent().getParent());
				for (int l : processesOfParents) {
					System.out.println(processId + " <--- " + l);
					edges[l - 1][processId - 1] = 100;
				}
			} else if (reteNodeRecipe instanceof AlphaRecipe) {
				int[] processesOfParents = getProcessesOfParents(reteNodeRecipe,
						((AlphaRecipe) reteNodeRecipe).getParent());
				for (int l : processesOfParents) {
					System.out.println(processId + " <--- " + l);
					edges[l - 1][processId - 1] = 100;
				}
			} else if (reteNodeRecipe instanceof MultiParentNodeRecipe) {
				MultiParentNodeRecipe multiParentNodeRecipe = ((MultiParentNodeRecipe) reteNodeRecipe);
				EList<ReteNodeRecipe> parents = multiParentNodeRecipe.getParents();
				ReteNodeRecipe[] parentsArray = parents.toArray(new ReteNodeRecipe[parents.size()]);
				int[] processesOfParents = getProcessesOfParents(reteNodeRecipe, parentsArray);
				for (int l : processesOfParents) {
					System.out.println(processId + " <--- " + l);
					edges[l - 1][processId - 1] = 100;
				}
			}
		}

		for (int i = 0; i < edges.length; i++) {
			int[] row = edges[i];
			for (int j = 0; j < row.length; j++) {
				System.out.print(edges[i][j] + ", ");
			}
			System.out.println();
		}

	}

	private int[] getProcessesOfParents(ReteNodeRecipe child, ReteNodeRecipe... parents) {
		int[] parentProcessIds = new int[parents.length];

		int childProcess = getProcessOfReteNode(child);

		int i = 0;

		Set<Integer> processSet = processes.keySet();

		for (ReteNodeRecipe parent : parents) {
			String uriOfParent = ArchUtil.getJsonEObjectUri(parent);
			for (Integer process : processSet) {
				List<ReteNodeRecipe> nodesInProcess = processes.get(process);
				for (ReteNodeRecipe reteNodeRecipe : nodesInProcess) {
					if (uriOfParent.equals(ArchUtil.getJsonEObjectUri(reteNodeRecipe)) && process != childProcess) {
						parentProcessIds[i] = process.intValue();
						i++;
						break;
					}
				}
			}
		}

		// This last part is for eliminating the same process edges
		int notNullElements = 0;

		for (int id : parentProcessIds) {
			if (id != 0)
				notNullElements++;
		}

		int[] processes = new int[notNullElements];

		int j = 0;
		for (int id : parentProcessIds) {
			if (id != 0) {
				processes[j] = id;
				j++;
			}
		}

		return processes;
	}

	private int getProcessOfReteNode(ReteNodeRecipe node) {
		Set<Integer> processSet = processes.keySet();
		String uriOfNode = ArchUtil.getJsonEObjectUri(node);

		for (Integer process : processSet) {
			List<ReteNodeRecipe> nodesInProcess = processes.get(process);
			for (ReteNodeRecipe reteNodeRecipe : nodesInProcess) {
				if (uriOfNode.equals(ArchUtil.getJsonEObjectUri(reteNodeRecipe))) {
					return process.intValue();
				}
			}
		}

		return 0;
	}

	private void processInventory(String inventoryFile) throws IOException {
		inventory = ArchUtil.loadInventory(new File(inventoryFile));

		MachineSet machineSet = inventory.getMachineSet();

		if (machineSet instanceof TemplateSet) {
			TemplateSet templateSet = (TemplateSet) machineSet;

			EList<MachineTemplate> machineTemplates = templateSet.getMachineTemplates();
			overheads = new int[machineTemplates.size()][machineTemplates.size()];

			for (int i = 0; i < machineTemplates.size(); i++) {
				MachineTemplate machineTemplate = machineTemplates.get(i);
				ContainerTemplate containerTemplate = new ContainerTemplate(getMemoryInMBs(
						machineTemplate.getMemoryUnit(), machineTemplate.getMemorySize()), machineTemplate.getCost(),
						machineTemplate.getIdentifier());
				containerTemplates.add(containerTemplate);
				for (int j = 0; j < machineTemplate.getOverheads().size(); j++) {
					overheads[i][j] = machineTemplate.getOverheads().get(j).intValue();
				}
			}

		} else {
			InstanceSet instanceSet = (InstanceSet) machineSet;

			EList<MachineInstance> machineInstances = instanceSet.getMachineInstances();
			overheads = new int[machineInstances.size()][machineInstances.size()];

			for (int i = 0; i < machineInstances.size(); i++) {
				MachineInstance machineInstance = machineInstances.get(i);
				Container container = new Container(getMemoryInMBs(machineInstance.getMemoryUnit(),
						machineInstance.getMemorySize()), machineInstance.getCost(), machineInstance.getIp());
				containers.add(container);
				for (int j = 0; j < machineInstance.getOverheads().size(); j++) {
					overheads[i][j] = machineInstance.getOverheads().get(j).intValue();
				}
			}

		}
	}

	private static int getMemoryInMBs(MemoryUnit memUnit, int memorySize) {
		switch (memUnit) {
		case MB:
			return (int)(memorySize * 0.9);

		case GB:
			return (int)(1024 * memorySize * 0.9);

		default:
			return 0;
		}
	}

	private boolean optimizedAllocation() throws IOException {
		boolean useInstances = !containers.isEmpty();

		if (useInstances) {
			AllocationSolver solver = new AllocationSolver();
			Allocation allocation = solver.optimizeWithInstances(containers, nodes, edges, overheads,
					optimizeForCommunication);

			if (!solver.canBeAllocated()) {
				return false;
			}
			System.out.println();
			System.out.println(allocation);
			createArch(allocation);
		} else {
			AllocationSolver solver = new AllocationSolver();
			Allocation allocation = solver.optimizeWithTemplates(containerTemplates, nodes, edges, overheads,
					optimizeForCommunication);

			if (!solver.canBeAllocated()) {
				return false;
			}
			System.out.println();
			System.out.println(allocation);
			createArch(allocation);
		}

		return true;
	}

	private void createArch(Allocation allocation) throws IOException {
		ReteRecipe recipe = ArchUtil.loadRecipe(recipeFile);

		final Configuration configuration = ArchFactory.eINSTANCE.createConfiguration();
		configuration.setConnectionString(inventory.getConnectionString());
		configuration.getRecipes().add(recipe);

		Map<String, List<Node>> allocations = allocation.getAllocations();
		Set<String> machines = allocations.keySet();

		boolean firstMachine = true; // This will have the coordinator and the monitoring server
		for (String ip : machines) {
			final Machine machine = InfrastructureFactory.eINSTANCE.createMachine();
			machine.setIp(ip);
			machine.setName(ip);

			configuration.getMachines().add(machine);
			if (firstMachine) {
				configuration.setCoordinatorMachine(machine);
				configuration.setMonitoringMachine(machine);
				firstMachine = false;
			}

			int port_counter = 2552;
			List<Node> nodesOnMachines = allocations.get(ip);
			for (Node node : nodesOnMachines) {
				final Process process = InfrastructureFactory.eINSTANCE.createProcess();
				process.setPort(port_counter);
				process.setMemory(Math.max(256, node.getSize()));
				process.setTraceInfo(ip + ":" + port_counter);
				port_counter++;

				machine.getProcesses().add(process);

				InfrastructureMapping infrastructureMapping = ArchFactory.eINSTANCE.createInfrastructureMapping();
				infrastructureMapping.setProcess(process);

				List<ReteNodeRecipe> reteNodesInProcess = processes.get(node.getId());

				for (ReteNodeRecipe reteNodeRecipe : reteNodesInProcess) {
					ReteRole reteRole = ArchFactory.eINSTANCE.createReteRole();
					reteRole.setNodeRecipe(reteNodeRecipe);
					infrastructureMapping.getRoles().add(reteRole);
				}

				configuration.getMappings().add(infrastructureMapping);
			}
		}

		ResourceSet resSet = new ResourceSetImpl();
		Resource resource = resSet.createResource(URI.createFileURI(architectureFile));
		resource.getContents().add(configuration);

		resource.save(Collections.EMPTY_MAP);
	}

	// The unoptimized allocator, this method is static
	public static void allocateUnoptimized(String recipeFile, String outputFile) throws IOException {
		ReteRecipe recipe = ArchUtil.loadRecipe(recipeFile);

		final Configuration configuration = ArchFactory.eINSTANCE.createConfiguration();
		configuration.setConnectionString("fourstore://trainbenchmark_cluster");

		final Machine machine = InfrastructureFactory.eINSTANCE.createMachine();
		machine.setIp("127.0.0.1");
		machine.setName("local");

		final Process process = InfrastructureFactory.eINSTANCE.createProcess();
		process.setPort(2552);
		process.setMemory(2048);

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

		resource.save(Collections.EMPTY_MAP);
	}

}
