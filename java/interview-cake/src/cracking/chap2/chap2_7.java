package cracking.chap2;

import java.util.Stack;

public class chap2_7 {

	public static void main(String[] args) {
		SinglyLinkedList list = createList();
		// boolean isPalindrome = checkIfPalindromeItr(list);
		boolean isPalindrome = checkIfPalindromeRec(list);
		String word = isPalindrome ? "a" : "not a";
		System.out.println("The list is " + word + " palindrome.");
	}

	private static boolean checkIfPalindromeRec(SinglyLinkedList list) {
		PalindromeResult p = isPalindromeRecurse(list.head, list.length);
		return p.result;
	}

	private static PalindromeResult isPalindromeRecurse(Node head, int length) {
		if (head == null || length == 0) {
			return new PalindromeResult(null, true);
		} else if (length == 1) {
			return new PalindromeResult(head.next, true);
		} else if (length == 2) {
			return new PalindromeResult(head.next.next,
					head.data == head.next.data);
		}

		PalindromeResult res = isPalindromeRecurse(head.next, length - 2);
		if (!res.result || res.node == null) {
			return res;
		} else {
			res.result = head.data == res.node.data;
			res.node = res.node.next;
			return res;
		}
	}

	private static boolean checkIfPalindromeItr(SinglyLinkedList list) {

		Node slow = list.head;
		Node fast = list.head;
		Stack<Integer> firstHalf = new Stack<Integer>();
		while (fast != null && fast.next != null) {
			firstHalf.push(slow.data);
			slow = slow.next;
			fast = fast.next.next;
		}

		Node secondHalfBeg = null;
		if (fast != null) {
			secondHalfBeg = slow.next;
		} else {
			secondHalfBeg = slow;
		}

		while (secondHalfBeg != null) {
			int stackElem = firstHalf.pop().intValue();

			if (stackElem != secondHalfBeg.data) {
				return false;
			}
			secondHalfBeg = secondHalfBeg.next;
		}

		return true;
	}

	private static SinglyLinkedList createList() {
		SinglyLinkedList list = new SinglyLinkedList();
		list.appendToTail(1);
		list.appendToTail(2);
		list.appendToTail(3);
		list.appendToTail(2);
		list.appendToTail(1);
		return list;
	}
}
