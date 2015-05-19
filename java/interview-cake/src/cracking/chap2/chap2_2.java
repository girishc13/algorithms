package cracking.chap2;

public class chap2_2 {

	public static void main(String[] args) {
		SinglyLinkedList list = SinglyLinkedList.createNewListWithDefaultVals();

		int k = 4;
		Node fromKItr = list.findFromNthToIndexItr(k);
		System.out.println("Iterative Solution: " + fromKItr.data);

		Node fromKthRec = list.findFromNthToIndexRec(k);
		System.out.println("Recursive Solution: " + fromKthRec.data);
	}

}
