/**
 * 
 */
package com.dsa.tree.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNodeP4<T> {
	int data;
	TreeNodeP4<T> left;
	TreeNodeP4<T> right;

	public TreeNodeP4(int data) {
		this.data = data;
	}
}

/**
 * 
 * You have been given a Binary Tree of 'N' nodes, where the nodes have integer values.
 * Your task is to print the zigzag traversal of the given tree.
 * 
 * Note:
 * 
 * In zigzag order, level 1 is printed from left to right fashion, level 2 is printed
 * from right to left. and level 3 is printed from left to right again, and so on… .
 * 
 * Input: Consider the following Binary Tree:
 * 
 *              1
 *             / \
 *            /   \
 *           3     4             
 *          / \   / \
 *         5   2 7   6
 * 
 * Output: The zigzag  traversal is [1, 4, 3, 5, 2, 7, 6]
 * 
 * Link: https://www.codingninjas.com/studio/problems/zig-zag-traversal_1062662
 * 
 */
public class P4_Tree_ZigZag_Level_Order_Traversal {

	public static void main(String[] args) {
		int[] arr = { 1, 3, 4, 5, 2, 7, 6 };
		TreeNodeP4<Integer> root = createTreeNode(arr, 0);
		System.out.println(root);
		List<Integer> list = zigZagTraversal(root);
		System.out.println(list);
	}

	private static TreeNodeP4<Integer> createTreeNode(int[] arr, int index) {
		TreeNodeP4<Integer> root = null;
		if (index < arr.length && arr[index] != -1) {
			root = new TreeNodeP4<Integer>(arr[index]);
			root.left = createTreeNode(arr, 2 * index + 1);
			root.right = createTreeNode(arr, 2 * index + 2);
		}
		return root;
	}

	private static List<Integer> zigZagTraversal(TreeNodeP4<Integer> root) {
		List<Integer> list = new ArrayList<Integer>();
		list = levelOrderZigzagTraversal(root, list);
		return list;
	}

	private static List<Integer> levelOrderZigzagTraversal(TreeNodeP4<Integer> root, List<Integer> list) {
		if (root == null) {
			return null;
		}
		Queue<TreeNodeP4<Integer>> queue = new LinkedList<TreeNodeP4<Integer>>();
		queue.add(root);
		boolean rightToLeft = false;
		while (!queue.isEmpty()) {
			int numQueue = queue.size();
			List<Integer> subList = new ArrayList<Integer>(numQueue);

			for (int i = 0; i < numQueue; i++) {
				TreeNodeP4<Integer> node = queue.poll();
				if (node.left != null) {
					queue.add(node.left);
				}
				if (node.right != null) {
					queue.add(node.right);
				}
				if (rightToLeft) {
					subList.add(0, node.data);
				} else {
					subList.add(node.data);
				}
			}

			rightToLeft = !rightToLeft;
			list.addAll(subList);
		}
		return list;
	}

}
