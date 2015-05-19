package cracking.chap2;

public class Node {

	Node next = null;
	Node prev = null;
	int data;

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
}
