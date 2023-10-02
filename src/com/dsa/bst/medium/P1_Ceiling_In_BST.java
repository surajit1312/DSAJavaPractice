/**
 * 
 */
package com.dsa.bst.medium;

class TreeNode<T> {
	public T data;
	TreeNode<T> left;
	TreeNode<T> right;

	TreeNode(T data) {
		this.data = data;
		left = null;
		right = null;
	}
};

/**
 * 
 * Ninja is given a binary search tree and an integer. Now he is given a
 * particular key in the tree and returns its ceil value. Can you help Ninja
 * solve the problem?
 * 
 * Ceil of an integer is the closest integer greater than or equal to a given
 * number. For example: arr[] = {1, 2, 5, 7, 8, 9}, key = 3. The closest integer
 * greater than 3 in the given array is 5. So, its ceil value in the given array
 * is 5.
 * 
 * Link: https://www.codingninjas.com/studio/problems/ceil-from-bst_920464
 */
public class P1_Ceiling_In_BST {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] input1 = { 1, 2, 5, 7, 8, 9 };
		int key1 = 3;
		TreeNode<Integer> root1 = createTree(input1);
		int ceil1 = findCeil(root1, key1);
		System.out.println("Ceiling value of " + key1 + " in BST is: " + ceil1);
	}

	private static TreeNode<Integer> createTree(int[] arr) {
		return insertLevelOrder(arr, 0);
	}

	private static TreeNode<Integer> insertLevelOrder(int[] arr, int index) {
		TreeNode<Integer> root = null;
		if (index < arr.length && arr[index] != -1) {
			root = new TreeNode<Integer>(arr[index]);
			root.left = insertLevelOrder(arr, 2 * index + 1);
			root.right = insertLevelOrder(arr, 2 * index + 2);
		}
		return root;
	}

	/**
	 * Ceiling value is such that minimum value in BST where ceil >= key
	 * 
	 * @param node
	 * @param x
	 * @return
	 */
	private static int findCeil(TreeNode<Integer> node, int x) {
		if (node == null) {
			return -1;
		}
		TreeNode<Integer> result = null;
		while (node != null) {
			if (node.data == x) {
				return node.data;
			} else if (node.data < x) {
				node = node.right;
			} else {
				result = node;
				node = node.left;
			}
		}
		if (result == null) {
			return -1;
		}
		return result.data;
	}

}
