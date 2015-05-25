package cracking.chap3;

public class Node {

	public Node below = null;
	public Node above = null;
	public Object data;

	public Node(Object d) {
		data = d;
	}

	void appendToTail(Object d) {
		Node end = new Node(d);
		Node n = this;

		while (n.below != null) {
			n = n.below;
		}
		n.below = end;
	}

	@Override
	public String toString() {
		return "Data: " + data;
	}
}
