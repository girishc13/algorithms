package cracking.chap2;

public class chap2_6 {

	public static void main(String[] args) {
		SinglyLinkedList list = createLikedList();
		createLoop(list);
		Node loopHead = fetchStartOfLoop(list);

		if (loopHead == null) {
			System.out.println("Linked is not circular.");
		} else {
			System.out.println("Loop begins at node value: " + loopHead.data);
		}
	}

	private static void createLoop(SinglyLinkedList list) {
		Node loopNode = list.findFromNthToIndexItr(3);
		Node tailNode = list.findFromNthToIndexItr(0);
		tailNode.next = loopNode;
	}

	private static Node fetchStartOfLoop(SinglyLinkedList list) {
		if (list == null || list.head == null || list.head.next == null)
			return null;

		Node fast = list.head;
		Node slow = list.head;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;

			if (slow == fast)
				break;
		}

		if (fast == null || fast.next == null)
			return null;

		slow = list.head;
		while (slow != fast) {
			slow = slow.next;
			fast = fast.next;
		}

		return fast;
	}

	private static SinglyLinkedList createLikedList() {
		SinglyLinkedList list = new SinglyLinkedList();
		list.appendToTail(0);
		list.appendToTail(1);
		list.appendToTail(2);
		list.appendToTail(3);
		list.appendToTail(4);
		list.appendToTail(5);
		return list;
	}
}
