/**
 * 
 */
package com.dsa.tree.hard;

/**
 * 
 * CodingNinjas
 * 
 * Link: https://www.codingninjas.com/studio/problems/lca-of-binary-tree_920541
 * 
 */
public class P1_LCA_Binary_Tree {

	static class TreeNode<T> {
		T data;
		TreeNode<T> left;
		TreeNode<T> right;

		TreeNode(T data) {
			this.data = data;
			left = null;
			right = null;
		}
	}

	static class Pair {
		TreeNode<Integer> node;
		int parent;

		public Pair(TreeNode<Integer> node, int parent) {
			this.node = node;
			this.parent = parent;
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] input = { 1, 2, 3, 4, 7, -1, -1, -1, -1, -1, -1 };
		TreeNode<Integer> root = createTree(input, 0);
		int x = 4;
		int y = 7;
		int lca = lowestCommonAncestor(root, x, y);
		System.out.println("Lowest Common Ancestor of " + x + " and " + y + " is : " + lca);
	}

	private static TreeNode<Integer> createTree(int[] input, int index) {
		TreeNode<Integer> root = null;
		if (index <= input.length - 1 && input[index] != -1) {
			root = new TreeNode<Integer>(input[index]);
			root.left = createTree(input, 2 * index + 1);
			root.right = createTree(input, 2 * index + 2);
		}
		return root;
	}

	private static int lowestCommonAncestor(TreeNode<Integer> root, int x, int y) {
		return findLCA(root, x, y).data;
	}

	private static TreeNode<Integer> findLCA(TreeNode<Integer> root, int x, int y) {
		if (root == null || root.data == x || root.data == y) {
			return root;
		}
		TreeNode<Integer> left = null, right = null;
		if (root.left != null) {
			left = findLCA(root.left, x, y);
		}
		if (root.right != null) {
			right = findLCA(root.right, x, y);
		}
		if (left == null) {
			return right;
		}
		if (right == null) {
			return left;
		}
		return root;
	}

}
