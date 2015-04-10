package cracking.chap2;

public class chap2_2 {

	public static void main(String[] args) {
		SinglyLinkedList list = createNewList();

		int k = 4;
		Node fromK = list.findFromIndexItr(k);
		System.out.println("From K.data: " + fromK.data);
	}

	private static SinglyLinkedList createNewList() {
		SinglyLinkedList list = new SinglyLinkedList(0);
		list.appendToTail(1);
		list.appendToTail(2);
		list.appendToTail(3);
		list.appendToTail(4);
		return list;
	}
}
