/**
 * 
 */
package com.dsa.tree.medium;

class TreeNodeP2<T> {
	int data;
	TreeNodeP2<T> left;
	TreeNodeP2<T> right;

	public TreeNodeP2(int data) {
		this.data = data;
	}
}

/**
 *  
 *              1
 *             / \
 *            /   \
 *           2     4             
 *          /     / \
 *         3     5   6
 *        /           \
 *       9             7
 *                      \
 *                       8
 */
public class P2_Is_Balanced_Binary_Tree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = { 1, 2, 4, 3, -1, 5, 6, 9, -1, -1, -1, -1, -1, -1, 7, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
				-1, -1, -1, -1, 8 };
		TreeNodeP2<Integer> root = createTreeNode(arr, 0);
		System.out.println(root);
		System.out.println("Is Binary tree balanced : " + isBalancedBT(root));
	}

	private static TreeNodeP2<Integer> createTreeNode(int[] arr, int index) {
		TreeNodeP2<Integer> root = null;
		if (index < arr.length && arr[index] != -1) {
			root = new TreeNodeP2<Integer>(arr[index]);
			root.left = createTreeNode(arr, 2 * index + 1);
			root.right = createTreeNode(arr, 2 * index + 2);
		}
		return root;
	}

	private static boolean isBalancedBT(TreeNodeP2<Integer> root) {
		return checkHeight(root) != -1;
	}

	private static int checkHeight(TreeNodeP2<Integer> root) {
		if (root == null) {
			return 0;
		}
		int lh = checkHeight(root.left);
		if (lh == -1) {
			return -1;
		}
		int rh = checkHeight(root.right);
		if (rh == -1) {
			return -1;
		}
		if (Math.abs(rh - lh) > 1) {
			return -1;
		}
		return Math.max(lh, rh) + 1;
	}

}
