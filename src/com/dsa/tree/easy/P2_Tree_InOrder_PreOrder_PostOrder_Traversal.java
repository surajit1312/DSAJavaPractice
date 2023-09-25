/**
 * 
 */
package com.dsa.tree.easy;

import java.util.ArrayList;
import java.util.List;

class TreeNodeP2 {
	int data;
	TreeNodeP2 left;
	TreeNodeP2 right;

	public TreeNodeP2(int data) {
		this.data = data;
	}
}

/**
 * 
 * You have been given a Binary Tree of 'N' nodes, where the nodes have integer values. 
 * Your task is to return the ln-Order, Pre-Order, and Post-Order traversals of the given binary tree.
 * 
 * Form a tree from array 
 * 
 * Input: arr: { 1, 3, 4, 5, 2, 7, 6 }
 * 
 * Output:
 * 
 * For the given binary tree:
 *
 *              1
 *             / \
 *            /   \
 *           3     4             
 *          / \   / \
 *         5   2 7   6
 *         
 *                    
 * The Inorder traversal will be [5, 3, 2, 1, 7, 4, 6].
 * The Preorder traversal will be [1, 3, 5, 2, 4, 7, 6].
 * The Postorder traversal will be [5, 2, 3, 7, 6, 4, 1].              
 *         
 * Link: https://www.codingninjas.com/studio/problems/tree-traversal_981269
 */
public class P2_Tree_InOrder_PreOrder_PostOrder_Traversal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = { 1, 3, 4, 5, 2, 7, 6 };
		TreeNodeP2 root = createTree(arr, 0);

		List<List<Integer>> list = new ArrayList<List<Integer>>();

		List<Integer> list1 = new ArrayList<Integer>();
		inOrderTraversal(root, list1);

		List<Integer> list2 = new ArrayList<Integer>();
		preOrderTraversal(root, list2);

		List<Integer> list3 = new ArrayList<Integer>();
		postOrderTraversal(root, list3);

		list.add(list1);
		list.add(list2);
		list.add(list3);
		System.out.println(list);
	}

	private static TreeNodeP2 createTree(int[] arr, int index) {
		TreeNodeP2 root = null;
		if (index < arr.length) {
			root = new TreeNodeP2(arr[index]);
			root.left = createTree(arr, 2 * index + 1);
			root.right = createTree(arr, 2 * index + 2);
		}
		return root;
	}

	/**
	 * Return Left Node Right
	 * 
	 * @param root
	 * @return
	 */
	private static void inOrderTraversal(TreeNodeP2 root, List<Integer> list) {
		if (root == null) {
			return;
		}
		inOrderTraversal(root.left, list);
		list.add(root.data);
		inOrderTraversal(root.right, list);
	}

	/**
	 * Return Node Left Right
	 * 
	 * @param root
	 * @return
	 */
	private static void preOrderTraversal(TreeNodeP2 root, List<Integer> list) {
		if (root == null) {
			return;
		}
		list.add(root.data);
		preOrderTraversal(root.left, list);
		preOrderTraversal(root.right, list);
	}

	/**
	 * Return Left Right Node
	 * 
	 * @param root
	 * @return
	 */
	private static void postOrderTraversal(TreeNodeP2 root, List<Integer> list) {
		if (root == null) {
			return;
		}
		postOrderTraversal(root.left, list);
		postOrderTraversal(root.right, list);
		list.add(root.data);
	}
}
