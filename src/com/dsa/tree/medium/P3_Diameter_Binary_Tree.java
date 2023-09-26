/**
 * 
 */
package com.dsa.tree.medium;

class TreeNodeP3<T> {
	int data;
	TreeNodeP3<T> left;
	TreeNodeP3<T> right;

	public TreeNodeP3(int data) {
		this.data = data;
	}
}

/**
 * 
 * You are given a Binary Tree.
 * Return the length of the diameter of the tree.
 * 
 * Note: 
 * 
 * The diameter of a binary tree is the length of the longest path between any two end nodes in a tree.
 * The number of edges between two nodes represents the length of the path between them.
 * 
 * Link: https://www.codingninjas.com/studio/problems/diameter-of-binary-tree_920552
 * 
 *              1
 *             / \
 *            /   \
 *           2     3             
 *                / \
 *               4   6
 *              /     \
 *             5       7
 *            /         \
 *           9           8
 */
public class P3_Diameter_Binary_Tree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, -1, -1, 4, 6, -1, -1, -1, -1, 5, -1, -1, 7, -1, -1, -1, -1, -1, -1, -1, -1, 9, -1, -1,
				-1, -1, -1, -1, 8 };
		TreeNodeP3<Integer> root = createTreeNode(arr, 0);
		System.out.println(root);
		System.out.println("Diameter of Binary Tree is : " + diameterOfBinaryTree(root));
	}

	private static TreeNodeP3<Integer> createTreeNode(int[] arr, int index) {
		TreeNodeP3<Integer> root = null;
		if (index < arr.length && arr[index] != -1) {
			root = new TreeNodeP3<Integer>(arr[index]);
			root.left = createTreeNode(arr, 2 * index + 1);
			root.right = createTreeNode(arr, 2 * index + 2);
		}
		return root;
	}

	private static int diameterOfBinaryTree(TreeNodeP3<Integer> root) {
		int[] diameter = new int[1];
		checkHeightBT(root, diameter);
		return diameter[0];
	}

	private static int checkHeightBT(TreeNodeP3<Integer> root, int[] max) {
		if (root == null) {
			return 0;
		}
		int lh = checkHeightBT(root.left, max);
		int rh = checkHeightBT(root.right, max);
		max[0] = Math.max(max[0], lh + rh);
		return 1 + Math.max(lh, rh);
	}

}
