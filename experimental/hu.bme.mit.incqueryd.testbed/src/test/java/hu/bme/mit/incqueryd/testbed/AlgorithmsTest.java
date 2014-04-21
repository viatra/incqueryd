package hu.bme.mit.incqueryd.testbed;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.google.common.collect.ImmutableList;

public class AlgorithmsTest {

    @Test
    public void topologicalSortTest() {
        final Collection<Integer> items = ImmutableList.of(1, 2, 3, 4);
        final Map<Integer, Integer> children = new HashMap<>();
        
        children.put(4, 2);
        children.put(2, 1);
        children.put(3, 1);
        
        final List<Integer> sorted = Algorithms.topologicalSort(items, children);
        System.out.println(sorted);        
    }
    
}
