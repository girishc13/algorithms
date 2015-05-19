package cracking.chap2;

public class chap2_3 {

	public static void main(String[] args) {
		SinglyLinkedList list = SinglyLinkedList.createNewListWithDefaultVals();

		System.out.println("Initial List:");
		list.printList();

		Node deleteNode = list.findFromNthToIndexItr(2);
		list.deleteNode(deleteNode);
		System.out.println("List after deleting 2:");
		list.printList();
	}
}
