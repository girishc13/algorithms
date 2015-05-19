package cracking.chap2;

public class chap2_5 {

	public static void main(String[] args) {
		sumInReverseOrder();
		sumInForwardOrder();
	}

	private static void sumInForwardOrder() {
		SinglyLinkedList num1 = createFirstNumberListInForwardOrder();
		SinglyLinkedList num2 = createSecondNumberListInForwardOrder();

		int len1 = num1.length();
		int len2 = num2.length();

		if (len1 < len2) {
			num1.head = padList(num1.head, len2 - len1);
		} else {
			num2.head = padList(num2.head, len1 - len2);
		}

		PartialSum sum = addListHelper(num1.head, num2.head);
		System.out.println("Sum in forward order: ");
		SinglyLinkedList.printFromNode(sum.sum);
	}

	private static PartialSum addListHelper(Node l1, Node l2) {
		if (l1 == null || l2 == null) {
			PartialSum sum = new PartialSum();
			return sum;
		}

		// add smaller digits recursively
		PartialSum sum = addListHelper(l1.next, l2.next);

		// add carry to current data
		int val = sum.carry + l1.data + l2.data;

		// insert sum before current digits
		Node full_result = insertBefore(sum.sum, val % 10);

		sum.sum = full_result;
		sum.carry = val / 10;

		return sum;
	}

	private static Node insertBefore(Node currentBeg, int data) {
		Node newBeg = new Node(data);
		if (currentBeg != null) {
			currentBeg.prev = newBeg;
			newBeg.next = currentBeg;
		}
		return newBeg;
	}

	private static Node padList(Node node, int padLen) {
		Node head = node;
		for (int i = 0; i < padLen; i++) {
			Node padNode = new Node(0);
			head.prev = padNode;
			padNode.next = head;
			head = padNode;
		}
		return head;
	}

	private static SinglyLinkedList createFirstNumberListInForwardOrder() {
		SinglyLinkedList list = new SinglyLinkedList();
		list.appendToTail(6);
		list.appendToTail(1);
		list.appendToTail(7);
		return list;
	}

	private static SinglyLinkedList createSecondNumberListInForwardOrder() {
		SinglyLinkedList list = new SinglyLinkedList();
		list.appendToTail(2);
		list.appendToTail(9);
		list.appendToTail(5);
		return list;
	}

	private static void sumInReverseOrder() {
		SinglyLinkedList num1 = createFirstNumberList();
		SinglyLinkedList num2 = createSecondNumberList();

		SinglyLinkedList sumList = sumLinkedLists(num1, num2);
		System.out.println("Sum when calculated in reverse order: ");
		sumList.printList();
	}

	private static SinglyLinkedList sumLinkedLists(SinglyLinkedList num1,
			SinglyLinkedList num2) {
		if (num1.head == null || num2.head == null)
			return null;

		SinglyLinkedList sumList = new SinglyLinkedList();
		int carry = 0;
		int digitSum;

		Node digit1 = num1.head;
		Node digit2 = num2.head;
		while (digit1 != null || digit2 != null) {
			digitSum = carry;
			if (digit1 != null) {
				digitSum += digit1.data;
			}
			if (digit2 != null) {
				digitSum += digit2.data;
			}

			carry = digitSum >= 10 ? 1 : 0;
			sumList.appendToTail(digitSum % 10);

			digit1 = digit1 == null ? null : digit1.next;
			digit2 = digit2 == null ? null : digit2.next;
		}

		return sumList;
	}

	private static SinglyLinkedList createSecondNumberList() {
		SinglyLinkedList list = new SinglyLinkedList();
		list.appendToTail(5);
		list.appendToTail(9);
		list.appendToTail(2);
		return list;
	}

	private static SinglyLinkedList createFirstNumberList() {
		SinglyLinkedList list = new SinglyLinkedList();
		list.appendToTail(7);
		list.appendToTail(1);
		list.appendToTail(6);
		return list;
	}
}
