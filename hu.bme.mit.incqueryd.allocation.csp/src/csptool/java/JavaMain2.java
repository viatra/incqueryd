package csptool.java;

import hu.bme.mit.incqueryd.csp.algorithm.AllocationSolver;
import hu.bme.mit.incqueryd.csp.algorithm.data.Allocation;
import hu.bme.mit.incqueryd.csp.algorithm.data.Container;
import hu.bme.mit.incqueryd.csp.algorithm.data.Node;

import java.util.List;

import com.google.common.collect.Lists;


public class JavaMain2 {

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
		
		
		List<Container> containers = Lists.newArrayList();
		containers.add(new Container(2000, 10, "10.0.0.1"));
		containers.add(new Container(2000, 10, "10.0.0.2"));
		containers.add(new Container(2000, 10, "10.0.0.3"));
		
		List<Node> nodes = Lists.newArrayList();
//		nodes.add(new Node(1, "a", 500));
//		nodes.add(new Node(2, "b", 900));
//		nodes.add(new Node(3, "c", 600));
//		nodes.add(new Node(4, "d", 1200));
//		nodes.add(new Node(5, "e", 1100));
		
		nodes.add(new Node(1, "a", 500));
		nodes.add(new Node(2, "b", 900));
		nodes.add(new Node(3, "c", 600));
		nodes.add(new Node(4, "d", 1000));
		nodes.add(new Node(5, "e", 1000));
		
		//process*process
		//edges between processes
		//must be same order as processes
		int[][] edges = new int[][]{
			{0,200,90,0,0},
			{0,0,250,120,0},
			{0,150,0,0,0},
			{0,0,0,0,500},
			{300,0,0,0,0},
		};
		
		//machines*machines
		//overhead matrix between machines, it should be symmetric to main diagonal
		//must be same order as machines
		int[][] overheads = new int[][]{
				{1,5,2},
				{5,1,4},
				{2,4,1},
		};
		
		AllocationSolver solver = new AllocationSolver();
		Allocation solutions = solver.optimizeWithInstances(containers, nodes, edges, overheads, false);
		//Allocation solutions = solver.optimizeWithInstances(containers, nodes, edges, overheads, false, 20);
		
		if (!solver.canBeAllocated()) {
			System.err.println("The problem can not be solved with the current resource set!");
		}
		
		System.out.println();
		System.out.println(solutions);

	}

}
