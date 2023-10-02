/**
 * 
 */
package com.dsa.bst.easy;

class Node {
	public int data;
	public Node left;
	public Node right;

	Node() {
		this.data = 0;
		this.left = null;
		this.right = null;
	}

	Node(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}

	Node(int data, Node left, Node right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}
}

/**
 * You are given a Binary Search Tree (BST)
 * Find the minimum value in it.
 * 
 * Note: All the values in the given binary search tree are unique.
 * 
 * Input : 6 4 7 2 5 N N
 * 
 * Output: 2
 * 
 * Explanation:
 * 
 * For the given input BST is:
 *
 *      6
 *     / \
 *    4    7
 *   / \
 *  2   5
 *  
 *  Minimum value in this tree is ‘2’.
 *  
 *  Link: https://www.codingninjas.com/studio/problems/minimum-element-in-bst_8160462
 *  
 */
public class P3_Minimum_Element_In_BST {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] input1 = { 6, 4, 7, 2, 5, -1, -1 };
		Node root1 = createTree(input1);
		int min1 = minValue(root1);
		System.out.println("Minimum value in BST is: " + min1);

		int[] input2 = { 8, 5, -1, 3, 6 };
		Node root2 = createTree(input2);
		int min2 = minValue(root2);
		System.out.println("Minimum value in BST is: " + min2);
	}

	private static Node createTree(int[] arr) {
		return insertLevelOrder(arr, 0);
	}

	private static Node insertLevelOrder(int[] arr, int index) {
		Node root = null;
		if (index < arr.length && arr[index] != -1) {
			root = new Node(arr[index]);
			root.left = insertLevelOrder(arr, 2 * index + 1);
			root.right = insertLevelOrder(arr, 2 * index + 2);
		}
		return root;
	}

	private static int minValue(Node root) {
		if (root == null) {
			return -1;
		}
		while (root != null && root.left != null) {
			root = root.left;
		}
		return root.data;
	}

}
