/**
 * 
 */
package com.dsa.tree.easy;

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
 */
public class P4_Tree_Level_Order_Traversal {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 5, -1, 6, 4 };
		TreeNodeP4<Integer> root = createTree(arr, 0);
		System.out.println(root);
		levelOrder(root);
	}

	private static TreeNodeP4<Integer> createTree(int[] arr, int index) {
		TreeNodeP4<Integer> root = null;
		if (index < arr.length && arr[index] != -1) {
			root = new TreeNodeP4<Integer>((Integer) arr[index]);
			root.left = createTree(arr, 2 * index + 1);
			root.right = createTree(arr, 2 * index + 2);
		}
		return root;
	}
	
	public static List<Integer> levelOrder(TreeNodeP4<Integer> root){
        List<Integer> list = new ArrayList<Integer>();
        levelOrderTraversal(root, list);
        System.out.println(list);
        return list;
    }
	
	private static void levelOrderTraversal(TreeNodeP4<Integer> root, List<Integer> list) {
		Queue<TreeNodeP4<Integer>> queue = new LinkedList<TreeNodeP4<Integer>>();
		queue.add(root);
		while (!queue.isEmpty()) {
			TreeNodeP4<Integer> node = queue.poll();
			list.add(node.data);
			if (node.left != null) {
				queue.add(node.left);				
			}
			if (node.right != null) {
				queue.add(node.right);				
			}
		}
	}

}
