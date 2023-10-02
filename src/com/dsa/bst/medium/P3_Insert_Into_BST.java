/**
 * 
 */
package com.dsa.bst.medium;

class TreeNodeP3 {
	int val;
	TreeNodeP3 left;
	TreeNodeP3 right;

	TreeNodeP3() {
		this.val = 0;
		this.left = null;
		this.right = null;
	}

	TreeNodeP3(int val) {
		this.val = val;
		this.left = null;
		this.right = null;
	}

	TreeNodeP3(int val, TreeNodeP3 left, TreeNodeP3 right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}

/**
 * 
 * You have been given a root node of the binary search tree and a positive
 * integer value. You need to perform an insertion operation i.e. inserting a
 * new node with the given value in the given binary search tree such that the
 * resultant tree is also a binary search tree.
 * 
 * Link:
 * https://www.codingninjas.com/studio/problems/insert-into-a-binary-search-tree_1279913
 */
public class P3_Insert_Into_BST {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] input1 = { 10, 2, 12, 1, 3, -1, 13, -1, -1, -1, -1, -1, -1 };
		int insert1 = 11;
		TreeNodeP3 root1 = createTree(input1);
		TreeNodeP3 output1 = insertionInBST(root1, insert1);
		System.out.println("BST after insertion of " + insert1 + " is: " + output1);
	}

	private static TreeNodeP3 createTree(int[] arr) {
		return insertLevelOrder(arr, 0);
	}

	private static TreeNodeP3 insertLevelOrder(int[] arr, int index) {
		TreeNodeP3 root = null;
		if (index < arr.length && arr[index] != -1) {
			root = new TreeNodeP3(arr[index]);
			root.left = insertLevelOrder(arr, 2 * index + 1);
			root.right = insertLevelOrder(arr, 2 * index + 2);
		}
		return root;
	}

	private static TreeNodeP3 insertionInBST(TreeNodeP3 root, int val) {
		if (root == null) {
			return new TreeNodeP3(val);
		}
		TreeNodeP3 current = root;
		while (true) {
			if (val > current.val) {
				if (current.right != null) {
					current = current.right;
				} else {
					current.right = new TreeNodeP3(val);
					break;
				}
			}
			if (val < current.val) {
				if (current.left != null) {
					current = current.left;
				} else {
					current.left = new TreeNodeP3(val);
					break;
				}
			}
		}
		return root;
	}

}
