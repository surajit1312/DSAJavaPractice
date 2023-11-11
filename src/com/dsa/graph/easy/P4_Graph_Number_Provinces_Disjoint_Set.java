/**
 * 
 */
package com.dsa.graph.easy;

import java.util.Arrays;

/**
 * 
 */
public class P4_Graph_Number_Provinces_Disjoint_Set {

	/**
	 * @param args
	 * 
	 * Coding Ninjas Link: https://www.codingninjas.com/studio/problems/find-the-number-of-states_1377943
	 * Time Complexity : O(Vertices^2)
	 * Space Complexity : O(Vertices)
	 */
	public static void main(String[] args) {
		int cities1 = 4;
		int[][] roads1 = { { 1, 1, 1, 0 }, { 1, 1, 1, 0 }, { 1, 1, 1, 0 }, { 0, 0, 0, 1 } };
		int numProvinces1 = findNumOfProvinces(roads1, cities1);
		System.out.println("Number of province(s) (disconnected components) is(are) : " + numProvinces1);

		int cities2 = 5;
		int[][] roads2 = { { 1, 0, 1, 1, 1 }, { 0, 1, 0, 1, 0 }, { 0, 0, 1, 0, 0 }, { 0, 1, 0, 1, 0 },
				{ 1, 1, 1, 0, 1 } };
		int numProvinces2 = findNumOfProvinces(roads2, cities2);
		System.out.println("Number of province(s) (disconnected components) is(are) : " + numProvinces2);
	}

	private static int findNumOfProvinces(int[][] roads, int n) {
		boolean[] visited = new boolean[n];
		int numProvinces = 0;
		Arrays.fill(visited, false);
		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				numProvinces++;
				dfsHelper(roads, n, visited, i);
			}
		}
		return numProvinces;
	}

	private static void dfsHelper(int[][] roads, int n, boolean[] visited, int current) {
		visited[current] = true;
		for (int i = 0; i < n; i++) {
			if (!visited[i] && i != current && roads[current][i] == 1) {
				visited[i] = true;
				dfsHelper(roads, n, visited, i);
			}
		}
	}

}
