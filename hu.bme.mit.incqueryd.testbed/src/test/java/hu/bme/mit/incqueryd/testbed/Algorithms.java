package hu.bme.mit.incqueryd.testbed;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;



public class Algorithms {
    
    /**
     * Naive topological sort algorithm.
     * Note that using a Map for storing the children relations is a bad idea.
     * This way, each node in the graph has a maximum outdegree of 1. 
     * @param children parent-child map
     * @return
     */
    public static <T> List<T> topologicalSort(final Collection<T> items, final Map<T, T> children) {
        final List<T> input = new ArrayList<>(items);
        final Map<T, T> relations = new HashMap<>(children);
        
        final LinkedList<T> output = new LinkedList<T>();
        
//        System.out.println(input);
//        System.out.println(children);
        
        while (input.size() > 0) {
            
            for (final T item : input) {
//                System.out.println(item);
                // if the item is not a child of any parent 
                if (!relations.values().contains(item)) {
                    // we add it to the result list
                    output.add(item);
                    
                    // and remove it from the input item list and the graph
                    input.remove(item);
                    relations.remove(item);
                    
                    break;
                }
            }
//            System.out.println();
        }
        
        return output;
    }
}
