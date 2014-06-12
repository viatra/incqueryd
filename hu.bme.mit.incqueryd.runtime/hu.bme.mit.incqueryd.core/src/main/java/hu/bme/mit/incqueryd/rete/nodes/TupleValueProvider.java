package hu.bme.mit.incqueryd.rete.nodes;

import hu.bme.mit.incqueryd.rete.dataunits.Tuple;

import java.util.Map;

import org.eclipse.incquery.runtime.matchers.psystem.IValueProvider;

public class TupleValueProvider implements IValueProvider {

    final Tuple tuple;
    final Map<String, Integer> indexMapping;

    /**
     * Wraps a tuple with an index mapping
     * @param tuple
     * @param indexMapping
     */
    public TupleValueProvider(Tuple tuple, Map<String, Integer> indexMapping) {
        super();
        this.tuple = tuple;
        this.indexMapping = indexMapping;
    }

    @Override
    public Object getValue(String variableName) {
        Integer index = indexMapping.get(variableName);
        if (index == null) {
            throw new IllegalArgumentException(String.format("Variable %s is not present in mapping.", variableName));
        }
        Object value = tuple.get(index);
        if (value == null) {
            throw new IllegalArgumentException(String.format("Variable %s is not found using index %d.", variableName, index));
        }
        return value;
    }

}
