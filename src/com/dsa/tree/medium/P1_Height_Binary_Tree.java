/**
 * 
 */
package com.dsa.tree.medium;

class TreeNode {
	int data;
	TreeNode left;
	TreeNode right;

	public TreeNode(int data) {
		this.data = data;
	}
}

/**
 * 
 * The height of a tree is equal to the number of nodes on the longest path from the root to a leaf.
 * You are given an arbitrary binary tree consisting of 'n' nodes where each node is associated with 
 * a certain value.
 * 
 * Find out the height of the tree.
 * 
 * Link: https://www.codingninjas.com/studio/problems/height-of-binary-tree_4609628
 * 
 * Input: Consider the following Binary Tree:
 * 
 *              1
 *             / \
 *            /   \
 *           3     4             
 *          /     / \
 *         5     2   7
 */
public class P1_Height_Binary_Tree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = { 1, 3, 4, 5, -1, 2, 7 };
		TreeNode root = createTree(arr, 0);
		System.out.println(root);
		int height = heightOfBinaryTree(root);
		System.out.println("Height of Binary tree is : " + height);
	}

	private static TreeNode createTree(int[] arr, int index) {
		TreeNode root = null;
		if (index < arr.length && arr[index] != -1) {
			root = new TreeNode(arr[index]);
			root.left = createTree(arr, 2 * index + 1);
			root.right = createTree(arr, 2 * index + 2);
		}
		return root;
	}

	private static int heightOfBinaryTree(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return Math.max(heightOfBinaryTree(root.left), heightOfBinaryTree(root.right)) + 1;
	}

}
