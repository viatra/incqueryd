package clustergraphloader.graphml;

import java.io.Serializable;

/**
 * ({@code <node>} or {@code <edge>} elements)
 * @author szarnyasg
 *
 */
public class XmlSegment implements Serializable {

	private static final long serialVersionUID = 1L;
	protected int offset;
	protected int count;

	public XmlSegment(int offset, int count) {
		super();
		this.offset = offset;
		this.count = count;
	}

	public int getOffset() {
		return offset;
	}

	public int getCount() {
		return count;
	}

	@Override
	public String toString() {
		return "XmlSegment [offset=" + offset + ", count=" + count + "]";
	}

}
