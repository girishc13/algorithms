package cracking.chap4;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;

public class chap4_4 {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6, 7 };
		TreeNode<Integer> root = createMinimalBST(arr);
		Map<Integer, LinkedList<TreeNode<Integer>>> nodeDepthMap = new HashMap<Integer, LinkedList<TreeNode<Integer>>>();
		createLinkedListForDepth(root, 0, nodeDepthMap);
		System.out.println("Depth: " + nodeDepthMap.keySet().size());
		for (Entry<Integer, LinkedList<TreeNode<Integer>>> entry : nodeDepthMap
				.entrySet()) {
			System.out.println("Nodes at Depth: " + entry.getKey());
			LinkedList<TreeNode<Integer>> value = entry.getValue();
			for (TreeNode<Integer> treeNode : value) {
				System.out.print(treeNode.key + ", ");
			}
			System.out.println();
		}
	}

	private static void createLinkedListForDepth(TreeNode<Integer> root,
			int currDepth,
			Map<Integer, LinkedList<TreeNode<Integer>>> nodeDepthMap) {

		if (root == null)
			return;

		LinkedList<TreeNode<Integer>> currDepthLinkedList = fetchLinkedListForDepth(
				nodeDepthMap, currDepth);
		currDepthLinkedList.add(root);
		int nextDepth = currDepth + 1;
		createLinkedListForDepth(root.left, nextDepth, nodeDepthMap);
		createLinkedListForDepth(root.right, nextDepth, nodeDepthMap);
	}

	private static LinkedList<TreeNode<Integer>> fetchLinkedListForDepth(
			Map<Integer, LinkedList<TreeNode<Integer>>> nodeDepthMap,
			int currDepth) {
		if (!nodeDepthMap.containsKey(currDepth)) {
			nodeDepthMap.put(currDepth, new LinkedList<TreeNode<Integer>>());
		}
		return nodeDepthMap.get(currDepth);
	}

	private static TreeNode<Integer> createMinimalBST(int[] arr) {
		return TreeNodeHelper.createMinimalBST(arr, 0, arr.length - 1);
	}
}
