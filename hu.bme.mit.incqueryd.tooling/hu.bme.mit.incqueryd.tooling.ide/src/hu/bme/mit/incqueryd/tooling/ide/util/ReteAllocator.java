package hu.bme.mit.incqueryd.tooling.ide.util;

import hu.bme.mit.incqueryd.arch.util.ArchUtil;
import infrastructure.InfrastructureFactory;
import infrastructure.Machine;
import infrastructure.Process;
import inventory.InstanceSet;
import inventory.Inventory;
import inventory.MachineInstance;
import inventory.MachineSet;
import inventory.MachineTemplate;
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
import org.eclipse.incquery.runtime.rete.recipes.ProductionRecipe;
import org.eclipse.incquery.runtime.rete.recipes.ReteNodeRecipe;
import org.eclipse.incquery.runtime.rete.recipes.ReteRecipe;
import org.eclipse.incquery.runtime.rete.recipes.TypeInputRecipe;

import arch.ArchFactory;
import arch.Configuration;
import arch.InfrastructureMapping;
import arch.ReteRole;

public class ReteAllocator {
	
	public static void allocate (String recipeFile) throws IOException {
		ReteRecipe recipe = ArchUtil.loadRecipe(recipeFile);
		
		EList<ReteNodeRecipe> recipeNodes = recipe.getRecipeNodes();
		
		for (ReteNodeRecipe reteNodeRecipe : recipeNodes) {
			System.out.println(reteNodeRecipe.getClass().getSimpleName() + " " + ArchUtil.getJsonEObjectUri(reteNodeRecipe));
		}
		System.out.println();
		
		List<ReteNodeRecipe> remainingReteNodes = new ArrayList<>();
		Map<Long, List<ReteNodeRecipe>> jvms = new HashMap<>();
		
		Set<ReteNodeRecipe> recipesToDelete = new HashSet<>();
		
		long id_counter = 1;
		
		for(int i = 0; i < recipeNodes.size(); i++) {
			ReteNodeRecipe reteNodeRecipe = recipeNodes.get(i);
			// These node types have memory --> go to separate jvm
			if(reteNodeRecipe instanceof BetaRecipe || reteNodeRecipe instanceof ProductionRecipe || reteNodeRecipe instanceof TypeInputRecipe) {
				List<ReteNodeRecipe> nodes = new ArrayList<>();
				nodes.add(reteNodeRecipe);
				jvms.put(id_counter, nodes);
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
				AlphaRecipe alphaRecipe = (AlphaRecipe)remainingReteNodes.get(i); // it is alpha as all betas were removed in first iteration as they have memory
				ReteNodeRecipe parent = alphaRecipe.getParent(); // parent of this node
				String uriOfParent = ArchUtil.getJsonEObjectUri(parent);
				for (Long jvmID : jvms.keySet()) {
					// if its parent was in this jvm then add it to the jvm's 1st place
					if(uriOfParent.equals(ArchUtil.getJsonEObjectUri(jvms.get(jvmID).get(0)))) {
						jvms.get(jvmID).add(0, alphaRecipe);
						recipesToDelete.add(alphaRecipe);
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
		for (Long jvmID : jvms.keySet()) {
			System.out.println(jvmID + ". jvm:");
			for (ReteNodeRecipe node : jvms.get(jvmID)) {
				System.out.println(node.getClass().getSimpleName() + " " + ArchUtil.getJsonEObjectUri(node));
			}
			System.out.println();
		}
		
	}
	
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
		      e.printStackTrace();
		}
		System.out.println(outputFile);
	}
	
	public static void processInventory (String inventoryFile) throws IOException {
		Inventory inventory = ArchUtil.loadInventory(inventoryFile);
		
		MachineSet machineSet = inventory.getMachineSet();
		
		if(machineSet instanceof TemplateSet) {
			TemplateSet templateSet = (TemplateSet)machineSet;
			
			EList<MachineTemplate> machineTemplates = templateSet.getMachineTemplates();
			int[][] overheads = new int[machineTemplates.size()][machineTemplates.size()];
			
			for(int i=0; i < machineTemplates.size(); i++) {
				MachineTemplate machineTemplate = machineTemplates.get(i);
				for(int j = 0; j < machineTemplate.getOverheads().size(); j++) {
					overheads[i][j] = machineTemplate.getOverheads().get(j).intValue();
				}
			}
			
		}
		else {
			InstanceSet instanceSet = (InstanceSet)machineSet;
			
			EList<MachineInstance> machineInstances = instanceSet.getMachineInstances();
			int[][] overheads = new int[machineInstances.size()][machineInstances.size()];
			
			for(int i=0; i < machineInstances.size(); i++) {
				MachineInstance machineInstance = machineInstances.get(i);
				for(int j = 0; j < machineInstance.getOverheads().size(); j++) {
					overheads[i][j] = machineInstance.getOverheads().get(j).intValue();
				}
			}
			
		}
	}
	
}
