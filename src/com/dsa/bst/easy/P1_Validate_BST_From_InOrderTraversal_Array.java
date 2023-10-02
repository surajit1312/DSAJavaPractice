/**
 * 
 */
package com.dsa.bst.easy;

/**
 * 
 * You are given an array ‘order’ which represents the inorder traversal of a binary search tree.
 * Find out if this traversal is valid or not.
 * Note: All values in the BST must be unique.
 * 
 * For Example:
 * ‘order’ = {1, 2, 3, 4,5} is a valid inorder traversal for the following binary search tree:
 * 
 *     4
 *    / \
 *   2   5
 *  / \
 * 1   3
 * 
 * Input Format:
 * 
 * The first line contains an integer ‘N’, denoting the number of elements in array ‘order’. 
 * The next line contains ‘N’ integers, denoting the elements of array ‘order’.
 * 
 * 
 * Output Format:
 * 
 * Return true if the given order is a valid inorder traversal of a BST and false otherwise.
 * Note: You don’t need to print anything, it has already been taken care of, just complete the given function. 
 * 
 * Link: https://www.codingninjas.com/studio/problems/binary-search-trees_8160443
 * 
 */
public class P1_Validate_BST_From_InOrderTraversal_Array {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] input1 = { 1, 2, 3, 4, 5 };
		boolean output1 = isValidBST(input1);
		System.out.println("Is valid BST: " + output1);

		int[] input2 = { 1, 2, 1, 4 };
		boolean output2 = isValidBST(input2);
		System.out.println("Is valid BST: " + output2);
	}

	/**
	 * The in-order traversal will only be valid if array is sorted
	 * 
	 * @param order
	 * @return
	 */
	public static boolean isValidBST(int[] order) {
		return isArraySorted(order);
	}

	private static boolean isArraySorted(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] >= arr[i + 1]) {
				return false;
			}
		}
		return true;
	}

}
