package cracking.chap4;

public class chap4_3 {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6, 7 };
		TreeNode<Integer> root = createMinimalBST(arr);
		System.out.println("Root key: " + root.key);
	}

	private static TreeNode<Integer> createMinimalBST(int[] arr) {
		return TreeNodeHelper.createMinimalBST(arr, 0, arr.length - 1);
	}
}
