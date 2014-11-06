package hu.bme.mit.incqueryd.monitoringserver.core.data;

import java.util.ArrayList;
import java.util.List;

public class StringTuple{
	
	protected final List<String> tuple;
	
	public StringTuple(String values) {
		tuple = new ArrayList<>();
		
		String[] split = values.split(":");
		for (String value : split) {
			tuple.add(value);
		}
	}
	
	public List<String> getTuple() {
		return tuple;
	}
	
	public int size() {
        return tuple.size();
    }
	
	@Override
    public boolean equals(Object obj) {
        if (!(obj instanceof StringTuple))
            return false;
        
        StringTuple other = (StringTuple) obj;
        
        if(tuple.size() != other.tuple.size()) return false;
        
        for(int i = 0; i < tuple.size(); i++) {
        	if(! tuple.get(i).equals(other.tuple.get(i))) {
        		return false;
        	}
        }
        
        return true;
	}
	
	@Override
	public String toString() {
		String result = "<";
        if (tuple.size() > 0) {
            result += tuple.get(0);
            for (int i = 1; i < tuple.size(); i++) {
                result += ", " + tuple.get(i);
            }
        }
        result += ">";
        return result;
	}
	
    @Override
    public int hashCode() {
        return tuple.hashCode();
    }
	
}
