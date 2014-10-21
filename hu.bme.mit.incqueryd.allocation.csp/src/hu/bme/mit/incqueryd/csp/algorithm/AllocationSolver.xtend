package hu.bme.mit.incqueryd.csp.algorithm

import com.google.common.collect.Lists
import com.google.ortools.constraintsolver.DecisionBuilder
import com.google.ortools.constraintsolver.IntVar
import com.google.ortools.constraintsolver.OptimizeVar
import com.google.ortools.constraintsolver.Solver
import hu.bme.mit.incqueryd.csp.algorithm.data.Allocation
import hu.bme.mit.incqueryd.csp.algorithm.data.Container
import hu.bme.mit.incqueryd.csp.algorithm.data.ContainerTemplate
import hu.bme.mit.incqueryd.csp.algorithm.data.Node
import hu.bme.mit.incqueryd.csp.algorithm.helper.CSPAlgorithmHelper
import hu.bme.mit.incqueryd.csp.impl.ortools.helpers.VariableHelper
import java.util.ArrayList
import java.util.Collections
import java.util.List

import static extension hu.bme.mit.incqueryd.csp.impl.ortools.extensions.ConstraintExtension.*

class AllocationSolver {
	
	val Solver solver;
	var List<List<IntVar>> nodesOnContainersVariables;
	val List<IntVar> edgeWeightVariables;
	val List<IntVar> machineCostVariables;
	var List<Container> containers;
	var List<Node> nodes;
	var OptimizeVar communicationCostFunction;
	var OptimizeVar machineCostFunction;
	
	var long communicationMin = Long.MAX_VALUE
	var long machineCostMin = Long.MAX_VALUE
	var long numberOfSolutions = 0
	
	var Allocation optimalAllocation
	
	new() {
		solver = new Solver("AllocationSolver");
		solver.makeDefaultSolver();
		
		edgeWeightVariables = new ArrayList
		machineCostVariables = new ArrayList 
	}
	
	/**
	 * Builds a model with the containers and their capacities, with the computation nodes and their sizes,
	 * with the edges between nodes and their weights and with the communication overhead multipliers between containers.
	 * <br/>
	 * For example an allocation problem can be stated like this:<br/>
	 * <br/>
	 * List<Container> containers = Lists.newArrayList();<br/>
	 * containers.add(new Container("m1", 2300));<br/>
	 * containers.add(new Container("m2", 1100));<br/>
	 * <br/>
	 * List<Node> nodes = Lists.newArrayList();<br/>
	 * nodes.add(new Node("x", 1000));<br/>
	 * nodes.add(new Node("y", 1200));<br/>
	 * nodes.add(new Node("z", 1100));<br/>
	 * <br/>
	 * int[][] edges = new int[][]{<br/>
	 * {0,5,0},<br/>
	 * {0,0,0},<br/>
	 * {0,10,0}<br/>
	 * };<br/>
	 * <br/>
	 * int[][] overheads = new int[][]{<br/>
	 * {1,5},<br/>
	 * {5,1}<br/>
	 * };<br/>
	 * <br/>
	 *
	 * AllocationSolver solver = new AllocationSolver();<br/>
	 * solver.buildModel(containers, nodes, edges, overheads);<br/>
	 * 
	 * @param containers The container resources with their capacities
	 * @param nodes Nodes to be allocated with their sizes
	 * @param edges Edges with their weights between the nodes, nodes * nodes size, must be in same order as nodes
	 * @param overheads Communication overhead multipliers between containers, must be in same order as containers, must be symmetric to main diagonal
	 */
	def optimizeWithInstances(List<Container> containers, List<Node> nodes, int[][] edges, int[][] overheads, boolean communicationPriority){
		
		this.containers = containers
		this.nodes = nodes

		// set the constraints
		setConstraints(containers, nodes, edges, overheads)
		
		// min {mc1 + mc2 + ... + mcm}
		machineCostFunction = machineCostVariables.SUM_MIN
		
		// min {e1 + e2 + ... + en}
		communicationCostFunction = edgeWeightVariables.SUM_MIN
		
		
		val db = createDecisionBuilder

		if(communicationPriority){
			solver.newSearch(db, communicationCostFunction)
		}
		else solver.newSearch(db, machineCostFunction)
        
        getSolutions(communicationPriority)
        
//        if (optimalAllocation != null) {
//			val AllocationSolver allocationSolver = new AllocationSolver // solve it again with the calculated optimal to get all optimal results
//
//			if (communicationPriority)
//				optimalAllocation = allocationSolver.optimizeWithInstances(containers, nodes, edges, overheads,communicationPriority, optimalAllocation.communication)
//			else
//				optimalAllocation = allocationSolver.optimizeWithInstances(containers, nodes, edges, overheads,communicationPriority, optimalAllocation.cost)
//		}
        
		return optimalAllocation
		
	}
	
	def optimizeWithInstances(List<Container> containers, List<Node> nodes, int[][] edges, int[][] overheads, boolean communicationPriority, long objectiveValue){
		this.containers = containers
		this.nodes = nodes

		// set the constraints
		setConstraints(containers, nodes, edges, overheads)
		
		// min {mc1 + mc2 + ... + mcm}
		machineCostFunction = machineCostVariables.SUM_MIN
		
		// min {e1 + e2 + ... + en}
		communicationCostFunction = edgeWeightVariables.SUM_MIN
		
		val db = createDecisionBuilder

		if(communicationPriority){
			solver >> (communicationCostFunction.^var == objectiveValue)
			solver.newSearch(db, machineCostFunction);
			
		}
		else {
			solver >> (machineCostFunction.^var == objectiveValue)
			solver.newSearch(db, communicationCostFunction);
		}
		
        
        getSolutions(communicationPriority)
        
		return optimalAllocation
	}
	
	/**
	 * This private method sets the constraints for the problem
	 */
	private def setConstraints(List<Container> containers, List<Node> nodes, int[][] edges, int[][] overheads){
		nodesOnContainersVariables = new ArrayList(nodes.length)
		for (i : 0 ..< nodes.length) {
			nodesOnContainersVariables.add(new ArrayList)
		}
		
		for (i : 0 ..< containers.length) {
			val container = containers.get(i);
			val IntVar[] procVars = newArrayOfSize(nodes.length);
			for (j : 0 ..< nodes.length) {
				val node = nodes.get(j);
				val IntVar procSizeVar = VariableHelper.enumerated(node.name + i, #[0, node.size], solver);
				procVars.set(j, procSizeVar);
				
				//add each processes variables to an array to add constraint later that each process should be placed
				nodesOnContainersVariables.get(j).add(procSizeVar);
			}
			// xi + yi + ... + zi <= c
			solver >> procVars.SUM_LE(container.memoryCapacity)
		}
		
		// post constraints that each nodes should be placed to one container
		// x0 + x1 + ... + xm = xs
		for (i : 0 ..< nodesOnContainersVariables.length) {
			var IntVar[] nodeVarArray = newArrayOfSize(nodesOnContainersVariables.get(i).length)
			nodesOnContainersVariables.get(i).toArray(nodeVarArray)
			val nodeConstraint = nodeVarArray.SUM_EQ(nodes.get(i).size)
			solver >> nodeConstraint
		}
		
		// Go through the edges and if it's weight is non-zero then add a variable for it with a weight
		for (i : 0 ..< edges.length) {
			var row = edges.get(i)
			for(j : 0 ..< row.length){
				if(row.get(j) != 0){
					
					val sumNodeWeight = nodes.get(i).size + nodes.get(j).size
					val edgeWeight = row.get(j)
					
					println("sumweight: " + sumNodeWeight + " ,edge weight: " + edgeWeight)
					
					val IntVar edgeWeightVar = VariableHelper.bounded("e" + i + j, -1, Long.MAX_VALUE, solver)
					edgeWeightVariables.add(edgeWeightVar)
					
					for(k : 0 ..< nodesOnContainersVariables.get(i).length){
						for(l : 0 ..< nodesOnContainersVariables.get(j).length){
							
							val IntVar[] edgeVars = #[nodesOnContainersVariables.get(i).get(k), nodesOnContainersVariables.get(j).get(l)]
							// xi + yj >= xs + ys
							val edgeWeightConstraint = edgeVars.SUM_GE(sumNodeWeight)
							val weightWithOverhead = edgeWeight*overheads.get(k).get(l)
							// if : xi + yj >= xs + ys then: edgeWeightVar = weightWithOverhead
							solver >> (edgeWeightConstraint => (edgeWeightVar -> weightWithOverhead))
							
							println(nodesOnContainersVariables.get(i).get(k).name + "," + nodesOnContainersVariables.get(j).get(l).name + " -> weight: " +  weightWithOverhead)
						}
					}

				}
			}
		}
		
		for(i : 0 ..< nodesOnContainersVariables.get(0).length){
			val IntVar machineCostVar = VariableHelper.enumerated("mc" + i, #[0, containers.get(i).cost], solver)
			machineCostVariables.add(machineCostVar)
		}
		
		for(i : 0 ..< nodesOnContainersVariables.length){
			val nodesOnContainer = nodesOnContainersVariables.get(i)
			
			for(j : 0 ..< nodesOnContainer.length){
				val isNodeOnMachine = nodesOnContainer.get(j) > 0
				solver >> (isNodeOnMachine => (machineCostVariables.get(j) -> containers.get(j).cost))
			}
			
		}
	}
	
	
	private def createDecisionBuilder(){
		val List<IntVar> listForSolver = Lists.newArrayList();
		
		for (i : 0 ..< nodesOnContainersVariables.length) {
			nodesOnContainersVariables.get(i).forEach[ variable | listForSolver.add(variable)]
		}
		
		machineCostVariables.forEach[variable | listForSolver.add(variable)]
		edgeWeightVariables.forEach[variable | listForSolver.add(variable)]

		var DecisionBuilder db = solver.makePhase(listForSolver,
                                       Solver::CHOOSE_FIRST_UNBOUND,
                                       Solver::ASSIGN_MIN_VALUE)
                                       
        return db
	}
	
	private def getSolutions(boolean communicationPriority){
		
		var int j = 1
		
		while (solver.nextSolution()) {
//			System.out.println(j + ". solution")
//			for (i : 0 ..< nodesOnContainersVariables.length) {
//				nodesOnContainersVariables.get(i).forEach[ variable | print(variable.name + ": " + variable.value + ", ")]
//				println
//			}
			
//			edgeWeightVariables.forEach[edgeWeight | print(edgeWeight.name + ": " + edgeWeight.value + ", ")]
//			println
//			println("communication cost: " + communicationCostFunction.^var.value)
//			println("machine cost: " + machineCostFunction.^var.value)
//			println
			j=j+1;
			
			if (communicationPriority) {
				isThisSolutionBetterWithCommunicationCostPriority
			} else
				isThisSolutionBetterWithMachineCostPriority
		}
		
		solver.endSearch();
		
		numberOfSolutions = solver.solutions()
		
		System.out.println("Solutions: " + solver.solutions());
		System.out.println("Failures: " + solver.failures());
		System.out.println("Branches: " + solver.branches());
		System.out.println("Wall time: " + solver.wallTime() + "ms");
		
	}
	
	private def isThisSolutionBetterWithCommunicationCostPriority() {
		if (communicationCostFunction.^var.value < communicationMin) {
			communicationMin = communicationCostFunction.^var.value
			optimalAllocation = createAllocation
		} else if (communicationCostFunction.^var.value == communicationMin) {
			if (machineCostFunction.^var.value < machineCostMin) {
				machineCostMin = machineCostFunction.^var.value
				optimalAllocation = createAllocation
			}
		}
	}
	
	private def isThisSolutionBetterWithMachineCostPriority() {
		if (machineCostFunction.^var.value < machineCostMin) {
			machineCostMin = machineCostFunction.^var.value
			optimalAllocation = createAllocation
		} else if (machineCostFunction.^var.value == machineCostMin) {
			if (communicationCostFunction.^var.value < communicationMin) {
				communicationMin = communicationCostFunction.^var.value
				optimalAllocation = createAllocation
			}
		}
	}
	
	private def createAllocation(){
		val Allocation allocation = new Allocation
		for (i : 0 ..< nodesOnContainersVariables.length) {
			val nodeVars = nodesOnContainersVariables.get(i)
			for (k : 0 ..< nodeVars.length) {
				if (nodeVars.get(k).value > 0) {
					allocation.addNode(containers.get(k).name, nodes.get(i))
				}
			}
		}
		allocation.setCommunication(communicationCostFunction.^var.value)
		allocation.setCost(machineCostFunction.^var.value)
		
		return allocation
	}
	
	
	def canBeAllocated() {
		return numberOfSolutions > 0;
	}
	
	def getCommunicationCost(){
		return communicationMin
	}
	
	def getMachineCost(){
		return machineCostMin
	}
	
	
	// Cost minimizer with container templates
	def optimizeWithTemplates(List<ContainerTemplate> containers, List<Node> nodes, int[][] edges, int[][] overheads, boolean optimizeForCommunication){
		Collections.sort(containers) // sort the container templates according to their price-value ratio
		
				
		// Iterative approach to minimize allocation cost with the other algorithm
		val Integer[] containerAmounts = newArrayOfSize(containers.size)
		// Initially we use 5 of each machine templates
		for(i : 0 ..< containerAmounts.length){
			containerAmounts.set(i, 3)
		}
		
		for (i : 0 ..< containers.length) {
			var boolean nextRound // to determine if we run a next round with the incrementation of the instances of this container type
			do {
				nextRound = false
				
				containerAmounts.set(i, containerAmounts.get(i) + 2) // increment the amount of usable instances of current template if we decide to take next round
				
				val List<Container> containerList = new ArrayList
				containers.forEach [ containerTemplate, k |
					for (j : 0 ..< containerAmounts.get(k)) {
						containerList.add(new Container(containerTemplate.memoryCapacity, containerTemplate.cost,"10.0." + containerTemplate.id + "." + j))
					}
				]

				val int[][] containerOverheads = CSPAlgorithmHelper.createOverheadMatrixForSolver(containers.size,containerList.size, overheads, containerAmounts)

				val AllocationSolver allocationSolver = new AllocationSolver
				
				var currentAllocation = allocationSolver.optimizeWithInstances(containerList, nodes, edges,containerOverheads, optimizeForCommunication)
				
				if (allocationSolver.canBeAllocated()) {
					if(optimizeForCommunication){
						if (allocationSolver.communicationCost < communicationMin) {
							communicationMin = allocationSolver.communicationCost
							optimalAllocation = currentAllocation
							nextRound = true // IF the cost was less then we take next round
						} else if (allocationSolver.communicationCost == communicationMin) {
							if (allocationSolver.machineCost < machineCostMin) {
								machineCostMin = allocationSolver.machineCost
								optimalAllocation = currentAllocation
							}
						}
					}
					else {
						if (allocationSolver.machineCost < machineCostMin) {
							machineCostMin = allocationSolver.machineCost
							optimalAllocation = currentAllocation
							nextRound = true // IF the cost was less then we take next round
						} else if (allocationSolver.machineCost == machineCostMin) {
							if (allocationSolver.communicationCost < communicationMin) {
								communicationMin = allocationSolver.communicationCost
								optimalAllocation = currentAllocation
							}
						}
					}
				}
				else nextRound = true; // IF we couldn't allocated then we alse take next round

			} while (nextRound)
		}
		
		
		return optimalAllocation
	}
	
}