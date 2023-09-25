/**
 * 
 */
package com.dsa.tree.easy;

class TreeNode {
	int data;
	TreeNode left;
	TreeNode right;

	public TreeNode(int data) {
		this.data = data;
	}
}

/**
 * Form a tree from array 
 * 
 * Input: arr: { 11, 22, 3, 54, 15, 23, 21 }
 * 
 * Output:
 *
 *               11
 *             /   \
 *            /     \
 *           22      3              
 *          /  \    / \
 *         54  15  23 21            
 *         
 * Link: https://www.codingninjas.com/studio/problems/create-binary-tree_8360671
 */
public class P1_Tree_From_Array_Level_Order {

	public static void main(String[] args) {
		int[] arr = { 11, 22, 3, 54, 15, 23, 21 };
		TreeNode root = createTree(arr);
		System.out.println(root);
	}

	/**
	 * @param args
	 */
	private static TreeNode createTree(int[] arr) {
		TreeNode root = insertLevelOrder(arr, 0);
		return root;
	}

	private static TreeNode insertLevelOrder(int[] arr, int index) {
		TreeNode root = null;
		if (index < arr.length) {
			root = new TreeNode(arr[index]);
			root.left = insertLevelOrder(arr, 2 * index + 1);
			root.right = insertLevelOrder(arr, 2 * index + 2);
		}
		return root;
	}
}
