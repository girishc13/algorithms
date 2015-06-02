package cracking.chap4;

public class TreeNodeHelper {

	public static TreeNode<Integer> createMinimalBST(int[] arr, int start,
			int end) {
		if (end < start)
			return null;

		int mid = (start + end) / 2;
		TreeNode<Integer> root = new TreeNode<Integer>(arr[mid]);
		root.left = createMinimalBST(arr, start, mid - 1);
		root.right = createMinimalBST(arr, mid + 1, end);
		return root;
	}

}
