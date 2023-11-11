/**
 * 
 */
package com.dsa.graph.easy;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Coding Ninjas Link:
 * https://www.codingninjas.com/studio/problems/creating-and-printing_1214551
 * Time Complexity: O(2n + m) ~ O(n), Space Complexity: O(n)
 */
public class P5_Graph_Print_Adjacency_List_From_Edges {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int n = 4;
		int m = 3;
		int[][] edges = { { 1, 2 }, { 0, 3 }, { 2, 3 } }; // 0 based indexing vertices = {0, 1, 2, 3};
		int[][] adjList = printAdjacency(n, m, edges);
		System.out.println(Arrays.deepToString(adjList));
	}

	public static int[][] printAdjacency(int n, int m, int[][] edges) {
		@SuppressWarnings("unchecked")
		ArrayList<Integer>[] adjArr = new ArrayList[n];
		int[][] result = new int[n][];
		for (int i = 0; i < n; i++) {
			adjArr[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < m; i++) {
			adjArr[edges[i][0]].add(edges[i][1]);
			adjArr[edges[i][1]].add(edges[i][0]);
		}
		for (int i = 0; i < adjArr.length; i++) {
			int size = adjArr[i].size() + 1;
			result[i] = new int[size];
			for (int j = 0; j < size; j++) {
				if (j == 0) {
					result[i][j] = i;
				} else {
					result[i][j] = adjArr[i].get(j - 1);
				}
			}
		}
		return result;
	}
}
