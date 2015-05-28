package cracking.chap4;

public class chap4_1 {

	private static final int INVALID_HEIGHT = -1;

	public static void main(String[] args) {
		TreeNode<Integer> root = createNewTree();
		boolean isBalanced = isBalanced(root);
		if (isBalanced)
			System.out.println("Tree is balanced.");
		else
			System.out.println("Tree is not balanced.");
	}

	private static boolean isBalanced(TreeNode<Integer> root) {
		int height = checkHeight(root);
		if (height == INVALID_HEIGHT)
			return false;
		return true;
	}

	private static int checkHeight(TreeNode<Integer> root) {
		if (root == null)
			return 0;

		int leftHeight = checkHeight(root.left);
		if (leftHeight == INVALID_HEIGHT)
			return INVALID_HEIGHT;

		int rightHeight = checkHeight(root.right);
		if (rightHeight == INVALID_HEIGHT)
			return -INVALID_HEIGHT;

		int heightDiff = leftHeight - rightHeight;
		if (Math.abs(heightDiff) > 1)
			return -1;
		else
			return Math.max(leftHeight, rightHeight) + 1;
	}

	private static TreeNode<Integer> createNewTree() {
		TreeNode<Integer> root = new TreeNode<Integer>(1);
		TreeNode<Integer> left1 = addNewLeftNode(root, 2);
		TreeNode<Integer> left2 = addNewLeftNode(left1, 4);
		addNewLeftNode(left2, 5);
		addNewRightNode(root, 2);
		return root;
	}

	private static TreeNode<Integer> addNewRightNode(TreeNode<Integer> root,
			int key) {
		TreeNode<Integer> child = new TreeNode<Integer>(key);
		root.right = child;
		child.parent = root;
		return child;
	}

	private static TreeNode<Integer> addNewLeftNode(TreeNode<Integer> root,
			int key) {
		TreeNode<Integer> child = new TreeNode<Integer>(key);
		root.left = child;
		child.parent = root;
		return child;
	}
}
