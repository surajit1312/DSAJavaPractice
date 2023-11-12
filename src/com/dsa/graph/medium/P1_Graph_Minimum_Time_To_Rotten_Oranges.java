/**
 * 
 */
package com.dsa.graph.medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * Coding Ninjas Link: https://www.codingninjas.com/studio/problems/rotting-oranges_701655
 * 
 * Time Complexity (5 x n x m) ~ O (n x m), Space Complexity O(2 * n x m) ~ O (n x m)
 */
public class P1_Graph_Minimum_Time_To_Rotten_Oranges {

	static class Pair {

		int row;
		int col;
		int time;

		public Pair(int row, int col, int time) {
			this.row = row;
			this.col = col;
			this.time = time;
		}

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int n = 3;
		int m = 3;
		int[][] grid = { { 2, 1, 1 }, { 1, 1, 0 }, { 0, 1, 1 } };
		int minTime = minTimeToRot(grid, n, m);
		System.out.println("Minimum time to rotten all oranges : " + minTime);
	}

	private static int minTimeToRot(int[][] grid, int n, int m) {
		int[][] visited = new int[n][m];
		int minTime = 0;
		Queue<Pair> queue = new LinkedList<Pair>();
		int numFresh = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (grid[i][j] == 2) {
					visited[i][j] = 2;
					queue.add(new Pair(i, j, 0));
				} else {
					visited[i][j] = 0;
				}
				if (grid[i][j] == 1) {
					numFresh++;
				}
			}
		}

		int countFreshRotten = 0;
		while (queue.size() > 0) {
			Pair currPair = queue.poll();
			int[] rowDelta = { 0, -1, 0, 1 };
			int[] colDelta = { -1, 0, 1, 0 };
			minTime = Math.max(minTime, currPair.time);
			// Capture directions here
			for (int i = 0; i < 4; i++) {
				int traverseRow = currPair.row + rowDelta[i];
				int traverseCol = currPair.col + colDelta[i];
				if (traverseRow >= 0 && traverseRow < n && traverseCol >= 0 && traverseCol < m
						&& visited[traverseRow][traverseCol] == 0 && grid[traverseRow][traverseCol] == 1) {
					visited[traverseRow][traverseCol] = 2;
					queue.add(new Pair(traverseRow, traverseCol, currPair.time + 1));
					countFreshRotten++;
				}
			}
		}
		if (countFreshRotten != numFresh) {
			return -1;
		}
		return minTime;
	}

}
