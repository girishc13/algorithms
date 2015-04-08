package cracking.chap2;

import java.util.HashSet;
import java.util.Set;

public class SinglyLinkedList {

	Node head = null;

	public SinglyLinkedList(int d) {
		head = new Node(d);
	}

	void appendToTail(int d) {
		Node end = new Node(d);
		Node n = head;

		while (n.next != null) {
			n = n.next;
		}
		n.next = end;
	}

	void deleteNode(int d) {
		Node n = head;

		if (n.data == d) {
			head = head.next;
		}

		if (n.next != null) {
			if (n.next.data == d) {
				n.next = n.next.next;
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
				} else {
					runner = runner.next;
				}
			}

			current = current.next;
		}
	}
}
