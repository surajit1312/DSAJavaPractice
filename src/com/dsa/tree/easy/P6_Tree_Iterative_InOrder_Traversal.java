/**
 * 
 */
package com.dsa.tree.easy;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class BinaryTreeNodeP6<T> {
	T data;
	BinaryTreeNodeP6<T> left;
	BinaryTreeNodeP6<T> right;

	public BinaryTreeNodeP6(T data) {
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
 *           3     4             
 *          / \   / \
 *         5   2 7   6
 *         
 * Return the preorder traversal of the Binary Tree.
 * 
 * Following is the preorder traversal of the given Binary Tree: [1, 3, 4, 5, 2, 7, 6]
 * 
 * Output: The Inorder traversal will be [5, 3, 2, 1, 7, 4, 6].
 * 
 * Link: https://www.codingninjas.com/studio/problems/inorder-traversal_3839605
 * 
 */
public class P6_Tree_Iterative_InOrder_Traversal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = { 1, 3, 4, 5, 2, 7, 6 };
		BinaryTreeNodeP6<Integer> root = createTree(arr, 0);
		System.out.println(root);
		List<Integer> list = preOrder(root);
		System.out.println(list);
	}

	private static BinaryTreeNodeP6<Integer> createTree(int[] arr, int index) {
		BinaryTreeNodeP6<Integer> root = null;
		if (index < arr.length && arr[index] != -1) {
			root = new BinaryTreeNodeP6<Integer>(arr[index]);
			root.left = createTree(arr, 2 * index + 1);
			root.right = createTree(arr, 2 * index + 2);
		}
		return root;
	}

	public static List<Integer> preOrder(BinaryTreeNodeP6<Integer> root) {
		List<Integer> list = new ArrayList<Integer>();
		Stack<BinaryTreeNodeP6<Integer>> stack = new Stack<BinaryTreeNodeP6<Integer>>();
		BinaryTreeNodeP6<Integer> node = root;
		while (true) {
			if (node != null) {
				stack.push(node);
				node = node.left;
			} else {
				if (stack.isEmpty()) {
					break;
				}
				node = stack.pop();
				list.add((Integer) node.data);
				node = node.right;
			}
		}
		return list;
	}

}
