/**
 * 
 */
package com.dsa.tree.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Coding Ninjas
 * 
 * Link:
 * https://www.codingninjas.com/studio/problems/all-root-to-leaf-paths-in-binary-tree._983599
 * 
 */
public class P2_Binary_Tree_All_Root_To_Leaf_Paths {

	static class BinaryTreeNode {
		int data;
		BinaryTreeNode left;
		BinaryTreeNode right;

		BinaryTreeNode(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}

	private static BinaryTreeNode createTree(int[] input, int index) {
		BinaryTreeNode root = null;
		if (index <= input.length - 1 && input[index] != -1) {
			root = new BinaryTreeNode(input[index]);
			root.left = createTree(input, 2 * index + 1);
			root.right = createTree(input, 2 * index + 2);
		}
		return root;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] input = { 1, 2, 3, 4, -1, 5, 6, -1, 7, -1, -1, -1, -1, -1, -1 };
		BinaryTreeNode root = createTree(input, 0);
		List<String> paths = allRootToLeaf(root);
		System.out.println("All Leaf Paths from root : " + paths);
	}

	private static List<String> allRootToLeaf(BinaryTreeNode root) {
		List<String> paths = new ArrayList<String>();
		String currentPath = "";
		nodeTraverse(root, paths, currentPath);
		return paths;
	}

	private static void nodeTraverse(BinaryTreeNode root, List<String> paths, String currentPath) {
		if (root == null) {
			return;
		}
		currentPath += currentPath == "" ? Integer.toString(root.data) : " " + Integer.toString(root.data);
		// check for leaf node
		if (root.left == null && root.right == null) {
			paths.add(currentPath);
		}
		nodeTraverse(root.left, paths, currentPath);
		nodeTraverse(root.right, paths, currentPath);
	}

}
