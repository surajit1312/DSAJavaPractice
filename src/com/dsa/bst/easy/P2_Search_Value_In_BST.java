/**
 * 
 * There is a Binary Search Tree (BST) consisting of 'N' nodes. Each node of this BST has some integer data.
 * You are given the root node of this BST, and an integer 'X'. 
 * 
 * Return true if there is a node in BST having data equal to ‘X’, otherwise return false.
 * 
 * Note:
 * 
 * A binary search tree (BST) is a binary tree data structure that has the following properties:
 * 
 * 1. The left subtree of a node contains only nodes with data less than the node’s data.
 * 2. The right subtree of a node contains only nodes with data greater than the node’s data.
 * 3. The left and right subtrees must also be binary search trees.
 * 
 * Link: https://www.codingninjas.com/studio/problems/search-in-bst_1402878
 */
package com.dsa.bst.easy;

class BinaryTreeNode {
	int data;
	BinaryTreeNode left;
	BinaryTreeNode right;

	BinaryTreeNode() {
		this.data = 0;
		this.left = null;
		this.right = null;
	}

	BinaryTreeNode(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}

	BinaryTreeNode(int data, BinaryTreeNode left, BinaryTreeNode right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}
};

/**
 * 
 */
public class P2_Search_Value_In_BST {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] input1 = { 4, 2, 6, 1, 3, 5, 7, -1, -1, -1, -1, -1, -1, -1, -1 };
		int target1 = 5;
		BinaryTreeNode root1 = createTree(input1);
		System.out.println(root1);
		boolean output1 = searchInBST(root1, target1);
		System.out.println("Is target " + target1 + " present in BST: " + output1);

		int[] input2 = { 3, 1, 5, -1, 2, -1, -1, -1, -1 };
		int target2 = 4;
		BinaryTreeNode root2 = createTree(input2);
		System.out.println(root2);
		boolean output2 = searchInBST(root2, target2);
		System.out.println("Is target " + target2 + " present in BST: " + output2);
	}

	private static BinaryTreeNode createTree(int[] arr) {
		return insertLevelOrder(arr, 0);
	}

	private static BinaryTreeNode insertLevelOrder(int[] arr, int index) {
		BinaryTreeNode root = null;
		if (index < arr.length) {
			root = new BinaryTreeNode(arr[index]);
			root.left = insertLevelOrder(arr, 2 * index + 1);
			root.right = insertLevelOrder(arr, 2 * index + 2);
		}
		return root;
	}

	private static boolean searchInBST(BinaryTreeNode root, int x) {
		if (root == null) {
			return false;
		}
		while (root != null && root.data != -1) {
			if (root.data == x) {
				return true;
			}
			root = root.data > x ? root.left : root.right;
		}
		return false;
	}

}
