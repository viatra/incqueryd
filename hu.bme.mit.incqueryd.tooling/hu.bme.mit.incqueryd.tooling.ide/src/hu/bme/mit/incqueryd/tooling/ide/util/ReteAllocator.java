package hu.bme.mit.incqueryd.tooling.ide.util;

import hu.bme.mit.incqueryd.arch.util.ArchUtil;
import inventory.InstanceSet;
import inventory.Inventory;
import inventory.MachineInstance;
import inventory.MachineSet;
import inventory.MachineTemplate;
import inventory.TemplateSet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.incquery.runtime.rete.recipes.AlphaRecipe;
import org.eclipse.incquery.runtime.rete.recipes.BetaRecipe;
import org.eclipse.incquery.runtime.rete.recipes.ProductionRecipe;
import org.eclipse.incquery.runtime.rete.recipes.ReteNodeRecipe;
import org.eclipse.incquery.runtime.rete.recipes.ReteRecipe;
import org.eclipse.incquery.runtime.rete.recipes.TypeInputRecipe;

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
			// These node types have memory --> go to sepaarte jvm
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
