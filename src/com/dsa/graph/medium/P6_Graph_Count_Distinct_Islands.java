/**
 * 
 */
package com.dsa.graph.medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 */
public class P6_Graph_Count_Distinct_Islands {

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
		int[][] arr = { { 1, 1, 0, 1, 1 }, { 1, 0, 0, 0, 0 }, { 0, 0, 0, 0, 1 }, { 1, 1, 0, 1, 1 } };
		int n = 4;
		int m = 5;
		int countOfIslands = distinctIsland(arr, n, m);
		System.out.println("Number of Islands found : " + countOfIslands);
	}

	private static int distinctIsland(int[][] arr, int n, int m) {
		boolean[][] visited = new boolean[n][m];
		int count = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (arr[i][j] == 1 && !visited[i][j]) {
					bfsGraph(arr, n, m, visited, new Pair(i, j));
					count++;
				}
			}
		}
		System.out.println(Arrays.deepToString(visited));
		return count;
	}

	private static void bfsGraph(int[][] arr, int n, int m, boolean[][] visited, Pair item) {
		Queue<Pair> queue = new LinkedList<Pair>();
		visited[item.row][item.col] = true;
		queue.add(item);
		while (queue.size() > 0) {
			Pair current = queue.poll();
			int[] deltaRow = {0, -1, -1, -1, 0, 1, 1, 1};
			int[] deltaCol = {-1, -1, 0, 1, 1, 1, 0, -1};
			// 8 possible directions for cells to be explored in traversal
			for (int i = 0; i < 8; i++) {
				int rowTraversed = current.row + deltaRow[i];
				int colTraversed = current.col + deltaCol[i];
				if (rowTraversed >= 0 && rowTraversed < n &&
						colTraversed >= 0 && colTraversed < m &&
							!visited[rowTraversed][colTraversed] &&
								arr[rowTraversed][colTraversed] == 1) {
					visited[rowTraversed][colTraversed] = true;
					queue.add(new Pair(rowTraversed, colTraversed));
				}
			}
		}
	}

}
