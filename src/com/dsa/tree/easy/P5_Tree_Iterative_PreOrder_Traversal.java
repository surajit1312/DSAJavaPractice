/**
 * 
 */
package com.dsa.tree.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class BinaryTreeNode<T> {
	T data;
	BinaryTreeNode<T> left;
	BinaryTreeNode<T> right;

	public BinaryTreeNode(T data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
}

/**
 * 
 * Input: Consider the following Binary Tree:
 * 
 *              1
 *             / \
 *            /   \
 *           2     3             
 *          /     / \
 *         5     6   4
 *         
 * Return the preorder traversal of the Binary Tree.
 * 
 * Following is the preorder traversal of the given Binary Tree: [1, 2, 5, 3, 6, 4]
 * 
 * Link: https://www.codingninjas.com/studio/problems/preorder-binary-tree_5948
 * 
 */
public class P5_Tree_Iterative_PreOrder_Traversal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 5, -1, 6, 4 };
		BinaryTreeNode<Integer> root = createTree(arr, 0);
		System.out.println(root);
		List<Integer> list = preOrder(root);
		System.out.println(list);
	}

	private static BinaryTreeNode<Integer> createTree(int[] arr, int index) {
		BinaryTreeNode<Integer> root = null;
		if (index < arr.length && arr[index] != -1) {
			root = new BinaryTreeNode<Integer>(arr[index]);
			root.left = createTree(arr, 2 * index + 1);
			root.right = createTree(arr, 2 * index + 2);
		}
		return root;
	}

	public static List<Integer> preOrder(BinaryTreeNode<Integer> root) {
		List<Integer> list = new ArrayList<Integer>();
		Stack<BinaryTreeNode<Integer>> stack = new Stack<BinaryTreeNode<Integer>>();
		stack.add(root);
		while (!stack.isEmpty()) {
			BinaryTreeNode<Integer> node = stack.pop();
			list.add((Integer) node.data);
			if (node.right != null) {
				stack.add(node.right);
			}
			if (node.left != null) {
				stack.add(node.left);
			}
		}
		return list;
	}

}
