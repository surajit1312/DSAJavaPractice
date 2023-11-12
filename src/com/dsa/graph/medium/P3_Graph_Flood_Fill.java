/**
 * 
 */
package com.dsa.graph.medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Coding Ninjas Link:
 * https://www.codingninjas.com/studio/problems/flood-fill-_1082141 
 * 
 * TC: O(5 x n x m) ~ O(n x m) 
 * SC: O(2 x n x m) ~ O(n x m)
 */
public class P3_Graph_Flood_Fill {

	static class Pair {
		int row;
		int col;

		public Pair(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[][] image = { { 7, 1, 1, 1 }, { 1, 7, 7, 7 }, { 7, 7, 7, 0 }, { 7, 7, 7, 4 }, { 4, 4, 4, 4 } };
		int n = 5;
		int m = 4;
		int x = 2;
		int y = 2;
		int p = 5;
		int[][] resultImage = floodFill(image, n, m, x, y, p);
		System.out.println("Flood fill image after pixel replacement looks like : " + Arrays.deepToString(resultImage));
	}

	private static int[][] floodFill(int[][] image, int n, int m, int x, int y, int p) {
		int targetValue = image[x][y];
		int[][] visited = new int[n][m];
		Queue<Pair> queue = new LinkedList<Pair>();
		queue.add(new Pair(x, y));
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (image[i][j] == targetValue) {
					visited[i][j] = 0;
				} else {
					visited[i][j] = image[i][j];
				}
			}
		}
		while (queue.size() > 0) {
			Pair currentPair = queue.poll();
			int[] deltaRow = { 0, -1, 0, 1 };
			int[] deltaCol = { -1, 0, 1, 0 };
			image[currentPair.row][currentPair.col] = p;
			// Checking and converting cells for all four non-diagonal directions
			for (int i = 0; i < 4; i++) {
				int visitRow = currentPair.row + deltaRow[i];
				int visitCol = currentPair.col + deltaCol[i];

				if (visitRow >= 0 && visitRow < n && visitCol >= 0 && visitCol < m && visited[visitRow][visitCol] == 0
						&& image[visitRow][visitCol] == targetValue) {
					visited[visitRow][visitCol] = 1;
					queue.add(new Pair(visitRow, visitCol));
				}
			}
		}
		return image;
	}

}
