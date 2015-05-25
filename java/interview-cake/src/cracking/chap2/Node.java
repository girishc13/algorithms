package cracking.chap2;

public class Node {

	public Node next = null;
	public Node prev = null;
	public int data;

	public Node(int d) {
		data = d;
	}

	void appendToTail(int d) {
		Node end = new Node(d);
		Node n = this;

		while (n.next != null) {
			n = n.next;
		}
		n.next = end;
	}

	@Override
	public String toString() {
		return "Data: " + data;
	}
}
