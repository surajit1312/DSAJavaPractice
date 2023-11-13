/**
 * 
 */
package com.dsa.array.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Coding Ninjas Link:
 * https://www.codingninjas.com/studio/problems/spiral-matrix_6922069
 * 
 * TC: O(n x m) 
 * SC: O(n x m)
 */
public class P14_Print_Spriral_Traversal_Matrix {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[][] MATRIX = { { 1, 3, 7 }, { 10, 12, 15 }, { 19, 20, 21 } };
		int[] spiralTraversalPath = spiralMatrix(MATRIX);
		System.out.println("Spiral Traversal Path of Matrix is : " + Arrays.toString(spiralTraversalPath));
	}

	private static int[] spiralMatrix(int[][] MATRIX) {
		int rows = MATRIX.length;
		int cols = MATRIX[0].length;
		List<Integer> result = new ArrayList<Integer>();
		int[] spiralTraversal = new int[rows * cols];
		int direction = 0;
		int top = 0, bottom = rows - 1, left = 0, right = cols - 1;
		while (left <= right && top <= bottom) {
			if (direction == 0) {
				// left to right
				for (int i = left; i <= right; i++) {
					result.add(MATRIX[top][i]);
				}
				top = top + 1; // for inner spiral traversal left to right
			} else if (direction == 1) {
				// top to bottom
				for (int i = top; i <= bottom; i++) {
					result.add(MATRIX[i][right]);
				}
				right = right - 1; // for inner spiral traversal top to bottom
			} else if (direction == 2) {
				// right to left
				for (int i = right; i >= left; i--) {
					result.add(MATRIX[bottom][i]);
				}
				bottom = bottom - 1; // for inner spiral traversal right to left
			} else if (direction == 3) {
				// bottom to top
				for (int i = bottom; i >= top; i--) {
					result.add(MATRIX[i][left]);
				}
				left = left + 1;
			}
			direction = (1 + direction) % 4;
		}
		for (int i = 0; i < result.size(); i++) {
			spiralTraversal[i] = result.get(i);
		}
		return spiralTraversal;
	}

}
