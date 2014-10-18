package hu.bme.mit.incqueryd.csp.util;

import hu.bme.mit.incqueryd.arch.util.ArchUtil;
import hu.bme.mit.incqueryd.csp.algorithm.AllocationSolver;
import hu.bme.mit.incqueryd.csp.algorithm.data.Allocation;
import hu.bme.mit.incqueryd.csp.algorithm.data.Container;
import hu.bme.mit.incqueryd.csp.algorithm.data.ContainerTemplate;
import hu.bme.mit.incqueryd.csp.algorithm.data.Node;
import hu.bme.mit.incqueryd.csp.util.data.ReteNet;
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
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.incquery.runtime.rete.recipes.ReteNodeRecipe;
import org.eclipse.incquery.runtime.rete.recipes.ReteRecipe;

import arch.ArchFactory;
import arch.Configuration;
import arch.InfrastructureMapping;
import arch.ReteRole;

public class AllocationOptimizer {
	
	private ReteNet reteNet;

	private int[][] overheads;
	private final List<Container> containers = new ArrayList<>();
	private final List<ContainerTemplate> containerTemplates = new ArrayList<>();
	private int[][] edges;
	private List<Node> nodes;
	
	private boolean optimizeForCommunication;
	private String recipeFile;
	private String inventoryFile;
	private String architectureFile;

	private Inventory inventory;

	public AllocationOptimizer(boolean optimizeForCost, String recipeFile, String inventoryFile, String architectureFile, Map<String, Long> inputStats) throws IOException {
		this.optimizeForCommunication = optimizeForCost;
		this.recipeFile = recipeFile;
		this.inventoryFile = inventoryFile;
		this.architectureFile = architectureFile;
		
		ReteRecipe recipe = ArchUtil.loadRecipe(recipeFile);
		reteNet = new ReteNet(recipe, inputStats);
	}
	
	public boolean allocate() throws IOException {
		processInventory();

		reteNet.create();
		edges = reteNet.getEdges();
		nodes = reteNet.getProcessNodes();

		boolean optimizedAllocation = createOptimizedAllocation();

		return optimizedAllocation;
	}
	
	private boolean createOptimizedAllocation() throws IOException {
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

				List<ReteNodeRecipe> reteNodesInProcess = reteNet.getReteNodeRecipesByProcessId(node.getId());

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
	
	
	
	
	
	
	
	private void processInventory() throws IOException {
		inventory = ArchUtil.loadInventory(inventoryFile);

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
}
