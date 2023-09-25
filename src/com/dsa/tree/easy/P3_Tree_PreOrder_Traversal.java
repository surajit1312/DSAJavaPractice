/**
 * 
 */
package com.dsa.tree.easy;

import java.util.ArrayList;

class TreeNodeP3<T> {
	T data;
	TreeNodeP3<T> left;
	TreeNodeP3<T> right;

	public TreeNodeP3(T data) {
		this.data = data;
	}
}

/**
 * 
 */
public class P3_Tree_PreOrder_Traversal {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 5, 4, 6, 7, -1, -1, -1, -1, -1, -1, -1, -1 };
		TreeNodeP3<Integer> root = createTree(arr, 0);
		System.out.println(root);
		int[] result = preOrder(root);
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + " ");
		}
	}

	private static TreeNodeP3<Integer> createTree(int[] arr, int index) {
		TreeNodeP3<Integer> root = null;
		if (index < arr.length && arr[index] != -1) {
			root = new TreeNodeP3<Integer>(arr[index]);
			root.left = createTree(arr, 2 * index + 1);
			root.right = createTree(arr, 2 * index + 2);
		}
		return root;
	}
	
	public static int[] preOrder(TreeNodeP3<Integer> root) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		preOrderTraversal(root, list);
		int[] result = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			result[i] = list.get(i);
		}
		return result;
	}

	private static void preOrderTraversal(TreeNodeP3<Integer> root, ArrayList<Integer> list) {
		if (root == null) {
			return;
		}
		if (root.data != -1) {
			list.add(root.data);			
		}
		preOrderTraversal(root.left, list);
		preOrderTraversal(root.right, list);
	}

}
