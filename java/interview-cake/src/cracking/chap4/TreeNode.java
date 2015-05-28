package cracking.chap4;

public class TreeNode<T> {

	T key;
	TreeNode<T> parent;
	TreeNode<T> left;
	TreeNode<T> right;

	public TreeNode() {
		key = null;
		parent = null;
		left = null;
		right = null;
	}

	public TreeNode(T key) {
		this.key = key;
		parent = null;
		left = null;
		right = null;
	}
}
