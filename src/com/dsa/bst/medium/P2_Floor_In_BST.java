/**
 * 
 */
package com.dsa.bst.medium;

class BinaryTreeNode<T> {
	public T data;
	BinaryTreeNode<T> left;
	BinaryTreeNode<T> right;

	BinaryTreeNode(T data) {
		this.data = data;
		left = null;
		right = null;
	}
};

/**
 * 
 * Given a binary search tree and an integer.Find the floor value of a key in a
 * binary search tree .
 * 
 * (If k lies in BST then is floor equal to k,else floor is equal to previous
 * greater value).
 * 
 * Note: k would never be less than the minimum element of tree.
 * 
 * 
 * Link: https://www.codingninjas.com/studio/problems/floor-from-bst_625868
 */
public class P2_Floor_In_BST {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] input1 = { 8, 5, 10, 2, 6, -1, -1, -1, -1, -1, 7, -1, -1 };
		int key1 = 4;
		BinaryTreeNode<Integer> root1 = createTree(input1);
		int ceil1 = floor(root1, key1);
		System.out.println("Floor value of " + key1 + " in BST is: " + ceil1);
	}

	private static BinaryTreeNode<Integer> createTree(int[] arr) {
		return insertLevelOrder(arr, 0);
	}

	private static BinaryTreeNode<Integer> insertLevelOrder(int[] arr, int index) {
		BinaryTreeNode<Integer> root = null;
		if (index < arr.length && arr[index] != -1) {
			root = new BinaryTreeNode<Integer>(arr[index]);
			root.left = insertLevelOrder(arr, 2 * index + 1);
			root.right = insertLevelOrder(arr, 2 * index + 2);
		}
		return root;
	}

	/**
	 * Floor value is such that maximum value in BST where floor <= key
	 * 
	 * @param node
	 * @param x
	 * @return
	 */
	private static int floor(BinaryTreeNode<Integer> node, int input) {
		if (node == null) {
			return -1;
		}
		BinaryTreeNode<Integer> result = null;
		while (node != null) {
			if (input == node.data) {
				return node.data;
			} else if (input > node.data) {
				result = node;
				node = node.right;
			} else {
				node = node.left;
			}
		}
		if (result == null) {
			return -1;
		}
		return result.data;
	}

}
