package cracking.chap2;

public class chap2_1 {

	public static void main(String[] args) {
		SinglyLinkedList list = createSinglyLinkedList();
		System.out.println("Origianl List: ");
		list.printList();

		System.out.println("After removing duplicates with buffer: ");
		list.removeDupWithBuf();
		list.printList();

		System.out.println("After removing duplicates without buffer: ");
		list = createSinglyLinkedList();
		list.removeDupsNoBuf();
		list.printList();

		// for (int i = 0; i < 100; i++) {
		// System.out.println("" + (100 - i));
		// }
	}

	private static SinglyLinkedList createSinglyLinkedList() {
		SinglyLinkedList singlyLinkedList = new SinglyLinkedList(1);
		singlyLinkedList.appendToTail(7);
		singlyLinkedList.appendToTail(1);
		singlyLinkedList.appendToTail(2);
		singlyLinkedList.appendToTail(12);
		singlyLinkedList.appendToTail(1);
		singlyLinkedList.appendToTail(78);
		singlyLinkedList.appendToTail(0);
		singlyLinkedList.appendToTail(0);
		return singlyLinkedList;

	}
}
