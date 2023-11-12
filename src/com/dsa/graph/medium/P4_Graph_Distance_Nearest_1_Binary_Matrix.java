/**
 * 
 */
package com.dsa.graph.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Coding Ninjas Link: https://www.codingninjas.com/studio/problems/distance-of-nearest-cell-having-1-in-a-binary-matrix_1169913
 * 
 * TC : O(7 x n x m) ~ O(n x m)
 * SC : O(4 x n x m) ~ O(n x m)
 * 
 */
public class P4_Graph_Distance_Nearest_1_Binary_Matrix {

	static class Pair {
		int row;
		int col;
		int distance;

		public Pair(int row, int col, int distance) {
			this.row = row;
			this.col = col;
			this.distance = distance;
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int n = 3, m = 4;
		int[][] input = { { 0, 0, 0, 1 }, { 0, 0, 1, 1 }, { 0, 1, 1, 0 } };
		ArrayList<ArrayList<Integer>> mat = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < n; i++) {
			mat.add(new ArrayList<Integer>());
			for (int j = 0; j < m; j++) {
				mat.get(i).add(input[i][j]);
			}
		}
		ArrayList<ArrayList<Integer>> nearestOneMat = nearest(mat, n, m);
		System.out.println("Matrix with nearest 1's is : " + nearestOneMat);
	}

	public static ArrayList<ArrayList<Integer>> nearest(ArrayList<ArrayList<Integer>> mat, int n, int m) {
		int[][] visited = new int[n][m];
		int[][] matNearest = new int[n][m];
		ArrayList<ArrayList<Integer>> matResult = new ArrayList<ArrayList<Integer>>();
		Queue<Pair> queue = new LinkedList<Pair>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				visited[i][j] = 0;
				matNearest[i][j] = mat.get(i).get(j);
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (mat.get(i).get(j) == 1) {
					queue.add(new Pair(i, j, 0));
					visited[i][j] = 1;
				}
			}
		}
		while (queue.size() > 0) {
			Pair currentPair = queue.poll();
			matNearest[currentPair.row][currentPair.col] = currentPair.distance;
			int[] deltaRow = { 0, -1, 0, 1 };
			int[] deltaCol = { -1, 0, 1, 0 };
			// we can traverse only on 4 non-diagonal directions
			for (int i = 0; i < 4; i++) {
				int traverseRow = currentPair.row + deltaRow[i];
				int traverseCol = currentPair.col + deltaCol[i];
				if (traverseRow >= 0 && traverseRow < n && traverseCol >= 0 && traverseCol < m
						&& visited[traverseRow][traverseCol] == 0 && mat.get(traverseRow).get(traverseCol) == 0) {
					visited[traverseRow][traverseCol] = 1;
					queue.add(new Pair(traverseRow, traverseCol, currentPair.distance + 1));
				}
			}
		}
		for (int i = 0; i < n; i++) {
			matResult.add(new ArrayList<Integer>());
			for (int j = 0; j < m; j++) {
				matResult.get(i).add(matNearest[i][j]);
			}
		}
		return matResult;
	}

}
