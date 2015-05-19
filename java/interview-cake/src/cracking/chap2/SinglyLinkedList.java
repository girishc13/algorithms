package cracking.chap2;

import java.util.HashSet;
import java.util.Set;

public class SinglyLinkedList {

	Node head = null;
	int length = 0;

	public SinglyLinkedList() {
	}

	public SinglyLinkedList(int d) {
		head = new Node(d);
		length++;
	}

	void appendToTail(int d) {
		if (head == null) {
			head = new Node(d);
			length++;
			return;
		}

		Node end = new Node(d);
		Node n = head;

		while (n.next != null) {
			n = n.next;
		}
		n.next = end;
		length++;
	}

	void deleteNode(int d) {
		Node n = head;

		if (n.data == d) {
			head = head.next;
		}

		while (n.next != null) {
			if (n.next.data == d) {
				n.next = n.next.next;
				length--;
			}
			n = n.next;
		}
	}

	void printList() {
		Node n = head;

		while (n != null) {
			System.out.print("" + n.data + " ");
			n = n.next;
		}
		System.out.println();
	}

	void removeDupWithBuf() {
		if (head.next == null)
			return;

		Set<Integer> buffer = new HashSet<Integer>();
		Node prev = null;
		Node n = head;

		while (n != null) {
			if (buffer.contains(n.data)) {
				prev.next = n.next;
				length--;
			} else {
				buffer.add(n.data);
				prev = n;
			}
			n = n.next;
		}
	}

	void removeDupsNoBuf() {
		if (head.next == null)
			return;

		Node current = head;
		while (current != null) {

			Node runner = current;
			while (runner.next != null) {
				if (runner.next.data == current.data) {
					runner.next = runner.next.next;
					length--;
				} else {
					runner = runner.next;
				}
			}

			current = current.next;
		}
	}

	public Node findFromNthToIndexItr(int k) {
		if (k < 0)
			return null;

		Node p1 = head;
		Node p2 = head;
		for (int i = 0; i < k; i++) {
			if (p2.next == null)
				return null;
			p2 = p2.next;
		}

		if (p2 == null)
			return null;

		while (p2.next != null) {
			p1 = p1.next;
			p2 = p2.next;
		}

		return p1;
	}

	class IndexWrapper {
		int value = -1;
	}

	public Node findFromNthToIndexRec(int k) {
		if (k < 0)
			return null;

		IndexWrapper index = new IndexWrapper();
		return nthToLast(head, k, index);
	}

	private Node nthToLast(Node n, int k, IndexWrapper index) {
		if (n == null)
			return null;

		Node node = nthToLast(n.next, k, index);
		index.value = index.value + 1;
		if (index.value == k) {
			return n;
		}

		return node;
	}

	public static SinglyLinkedList createNewListWithDefaultVals() {
		SinglyLinkedList list = new SinglyLinkedList(0);
		list.appendToTail(1);
		list.appendToTail(2);
		list.appendToTail(3);
		list.appendToTail(4);
		return list;
	}

	public boolean deleteNode(Node deleteNode) {
		if (deleteNode == null || deleteNode.next == null)
			return false;

		Node nextNode = deleteNode.next;
		deleteNode.data = nextNode.data;
		deleteNode.next = nextNode.next;
		length--;
		return true;
	}

	public int length() {
		return length;
	}

	public static void printFromNode(Node beg) {
		Node n = beg;

		while (n != null) {
			System.out.print("" + n.data + " ");
			n = n.next;
		}
		System.out.println();
	}
}
