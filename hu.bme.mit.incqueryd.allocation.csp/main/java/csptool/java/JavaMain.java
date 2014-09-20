package csptool.java;

import hu.bme.mit.incqueryd.csp.algorithm.AllocationSolver;
import hu.bme.mit.incqueryd.csp.algorithm.data.Container;
import hu.bme.mit.incqueryd.csp.algorithm.data.Node;

import java.util.List;

import com.google.common.collect.Lists;


public class JavaMain {

	public static void main(String[] args) {
		try{
			System.loadLibrary("jniortools_64");
		}catch(UnsatisfiedLinkError e){
			System.err.println(e.getMessage());
			try{
				System.loadLibrary("jniortools_32");
			}catch(UnsatisfiedLinkError e2){
				System.out.println("ERROR: Cannot load or-tools native library");
			}
		}
		
		List<Container> containers = Lists.newArrayList();
		containers.add(new Container(2300, 10, "m1"));
		containers.add(new Container(1100, 10, "m2"));
		
		List<Node> nodes = Lists.newArrayList();
		nodes.add(new Node(1, "x", 1000));
		nodes.add(new Node(2, "y", 1200));
		nodes.add(new Node(3, "z", 1100));
		
		//process*process
		//edges between processes
		//must be same order as processes
		int[][] edges = new int[][]{
			{0,5,0},
			{0,0,0},
			{0,10,0}
		};
		
		//machines*machines
		//overhead matrix between machines, it should be symmetric to main diagonal
		//must be same order as machines
		int[][] overheads = new int[][]{
				{1,5},
				{5,1}
			};
		
		AllocationSolver solver = new AllocationSolver();
		solver.optimizeWithInstances(containers, nodes, edges, overheads, true);
		
		if (!solver.canBeAllocated()) {
			System.err.println("The problem can not be solved with the current resource set!");
		}

	}

}
