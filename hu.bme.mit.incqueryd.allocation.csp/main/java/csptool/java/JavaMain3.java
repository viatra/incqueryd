package csptool.java;

import hu.bme.mit.incqueryd.csp.algorithm.AllocationSolver;
import hu.bme.mit.incqueryd.csp.algorithm.data.Allocation;
import hu.bme.mit.incqueryd.csp.algorithm.data.ContainerTemplate;
import hu.bme.mit.incqueryd.csp.algorithm.data.Node;

import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.Lists;


public class JavaMain3 {
	
	public static void main(String[] args) {
		
		try{
			System.loadLibrary("jniortools");
		}catch(UnsatisfiedLinkError e){
			System.err.println(e.getMessage());
			try{
				System.loadLibrary("jniortools_32");
			}catch(UnsatisfiedLinkError e2){
				System.out.println("ERROR: Cannot load or-tools native library");
			}
		}
		
		List<ContainerTemplate> containers = new ArrayList<>();
		containers.add(new ContainerTemplate(2048, 4, 1));
		containers.add(new ContainerTemplate(4096, 5, 0));
		containers.add(new ContainerTemplate(6000, 6, 2));
		
		List<Node> nodes = Lists.newArrayList();
		nodes.add(new Node(1, "a", 1600));
		nodes.add(new Node(2, "b", 900));
		nodes.add(new Node(3, "c", 1600));
		nodes.add(new Node(4, "d", 1200));
		nodes.add(new Node(6, "e", 1100));
		nodes.add(new Node(7, "f", 1800));
		nodes.add(new Node(8, "g", 2200));
		nodes.add(new Node(9, "h", 1900));
		
		int[][] edges = new int[][]{
				{0,200,90,0,0},
				{0,0,250,120,0},
				{0,150,0,0,0},
				{0,0,0,0,500},
				{300,0,0,0,0},
		};
			
		int[][] overheads = new int[][]{
				{1,5,2},
				{5,1,4},
				{2,4,1},
		};
		
		AllocationSolver solver = new AllocationSolver();
		
		Allocation optimizeForCost = solver.optimizeWithTemplates(containers, nodes, edges, overheads, true);
		
		System.out.println();
		System.out.println(optimizeForCost);
		
	}

}
