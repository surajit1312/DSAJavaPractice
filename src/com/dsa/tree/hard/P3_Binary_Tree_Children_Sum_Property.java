/**
 * 
 */
package com.dsa.tree.hard;

/**
 * 
 */
public class P3_Binary_Tree_Children_Sum_Property {

	static class Node {
		int data;
		Node left;
		Node right;

		Node(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}

	private static Node createTree(int[] input, int index) {
		Node root = null;
		if (index <= input.length - 1 && input[index] != -1) {
			root = new Node(input[index]);
			root.left = createTree(input, 2 * index + 1);
			root.right = createTree(input, 2 * index + 2);
		}
		return root;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] input = { 5, 3, 2, 3, -1, -1, -1, -1, -1 };
		Node root = createTree(input, 0);
		boolean isNodeSumOfChildren = isParentSum(root);
		System.out.println(isNodeSumOfChildren);
	}
	
	private static boolean isParentSum(Node root) {
		boolean valid = false;
        postOrderSum(root, null, valid);
        return valid;
    }
	
	private static int postOrderSum(Node root, Node parent, boolean valid) {
		if (root == null) {
			return 0;
		}
		int leftSum = 0, rightSum = 0;
		if (root.left != null) {
			leftSum = postOrderSum(root.left, root, valid);
		}
		if (root.right != null) {
			rightSum = postOrderSum(root.right, root, valid);
		}
		valid = parent != null && leftSum + rightSum == parent.data;
		return root.data;
	}

}
