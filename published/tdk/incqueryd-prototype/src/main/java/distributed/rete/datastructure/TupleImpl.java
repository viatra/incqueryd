package distributed.rete.datastructure;

import com.google.common.collect.ImmutableList;

/**
 * Tuple implementation.
 * @author szarnyasg
 *
 */
public class TupleImpl implements Tuple {

	private static final long serialVersionUID = 1L;
	protected final ImmutableList<?> tuple;
	
	public TupleImpl(Object... tuple) {
		this.tuple = ImmutableList.copyOf(tuple);
	}
	
	@Override
	public Object get(int index) {
		return tuple.get(index);
	}
	
	@Override
	public String toString() {
		String result = "[";
		if (tuple.size() > 0) {
			result += tuple.get(0).toString();
			for (int i = 1; i < tuple.size(); i++) {
				result += ", " + tuple.get(i).toString();
			}	
		}
		result += "]";
		return result;
	}
	
	@Override
	public int hashCode() {
		return tuple.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof TupleImpl)) return false;
		return tuple.equals(((TupleImpl)obj).tuple);
	}

	@Override
	public int size() {
		return tuple.size();
	}

	@Override
	public int compareTo(Tuple o) {
		for (int i = 0; i < o.size(); i++) {
			Long l1 = (Long) get(i);
			Long l2 = (Long) o.get(i);
			
			if (l1 != l2) {
				return l1 < l2 ? -1 : 1;
			} // else continue with the for cycle
		}
		return 0;
	}
	
}
