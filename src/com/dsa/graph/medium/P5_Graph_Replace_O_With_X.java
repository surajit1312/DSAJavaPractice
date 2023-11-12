/**
 * 
 */
package com.dsa.graph.medium;

import java.util.Arrays;

/**
 * 
 * Coding Ninjas Link:
 * https://www.codingninjas.com/studio/problems/replace-%E2%80%98o%E2%80%99-with-%E2%80%98x%E2%80%99_630517
 * 
 * TC : O(4 x n x m + 2n + 2m) ~ O(n x m)
 * SC : O(n x m)
 */
public class P5_Graph_Replace_O_With_X {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		char[][] matrix = { 
							{ 'X', 'X', 'O', 'O' },
							{ 'X', 'O', 'X', 'X' }, 
							{ 'X', 'O', 'O', 'X' },
							{ 'X', 'O', 'X', 'X' }, 
							{ 'X', 'X', 'X', 'X' }
		};
		replaceOWithX(matrix);
	}

	private static void replaceOWithX(char matrix[][]) {
		int n = matrix.length;
		int m = matrix[0].length;
		int[][] visited = new int[n][m];
		int[] deltaRow = { 0, 1, 0, -1 };
		int[] deltaCol = { -1, 0, 1, 0 };
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				visited[i][j] = 0;
			}
		}
		// 1st row
		for (int i = 0; i < m; i++) {
			if (matrix[0][i] == 'O' && visited[0][i] == 0) {
				dfsTraverse(0, i, matrix, visited, deltaRow, deltaCol);
			}
		}
		// last row
		for (int i = 0; i < m; i++) {
			if (matrix[n - 1][i] == 'O' && visited[n - 1][i] == 0) {
				dfsTraverse(n - 1, i, matrix, visited, deltaRow, deltaCol);
			}
		}
		// 1st column
		for (int i = 0; i < n; i++) {
			if (matrix[i][0] == 'O' && visited[i][0] == 0) {
				dfsTraverse(i, 0, matrix, visited, deltaRow, deltaCol);
			}
		}
		// last column
		for (int i = 0; i < n; i++) {
			if (matrix[i][m - 1] == 'O' && visited[i][m - 1] == 0) {
				dfsTraverse(i, m - 1, matrix, visited, deltaRow, deltaCol);
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (visited[i][j] == 0 && matrix[i][j] == 'O') {
					matrix[i][j] = 'X';
				}
			}
		}
		System.out.println(Arrays.deepToString(matrix));
	}

	private static void dfsTraverse(int row, int col, char[][] matrix, int[][] visited, int[] deltaRow,
			int[] deltaCol) {
		int n = matrix.length;
		int m = matrix[0].length;
		visited[row][col] = 1;
		// cells can be traversed in non-diagonal directions
		for (int i = 0; i < 4; i++) {
			int traverseRow = row + deltaRow[i];
			int traverseCol = col + deltaCol[i];
			if (traverseRow >= 0 && traverseRow < n && traverseCol >= 0 && traverseCol < m
					&& visited[traverseRow][traverseCol] == 0 && matrix[traverseRow][traverseCol] == 'O') {
				dfsTraverse(traverseRow, traverseCol, matrix, visited, deltaRow, deltaCol);
			}
		}
	}

}
