/**
 * 
 */
package com.dsa.graph.medium;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Coding Ninjas Link: https://www.codingninjas.com/studio/problems/detect-cycle-in-an-undirected-graph-_75896
 * TC: O(2V + 2E) ~ O(V + E)
 * SC: O(2V) ~ O(V)
 */
public class P7_Graph_DFS_Undirected_Cycle_Detection {

	/**
	 * @param args
	 * 
	 *        0 * * * * 1 
	 *         *         *
	 *          *         *
	 *           *         *
	 *            *         2 
	 *             *       *
	 *              *     *
	 *               *   * 
	 *                * * 
	 *                 3
	 * 
	 */
	public static void main(String[] args) {
		int V = 4; // Graph vertices are 0 based index ({0, 1, 2, 3}
		int[][] edges = { { 0, 1 }, { 1, 2 }, { 2, 3 }, { 3, 0 } };
		ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < V; i++) {
			adj.add(new ArrayList<Integer>());
		}
		for (int i = 0; i < V; i++) {
			if (adj.get(edges[i][0]) == null) {
				adj.set(edges[i][0], new ArrayList<Integer>());
			}
			if (adj.get(edges[i][1]) == null) {
				adj.set(edges[i][1], new ArrayList<Integer>());
			}
			adj.get(edges[i][0]).add(edges[i][1]);
			adj.get(edges[i][1]).add(edges[i][0]);
		}

		boolean graphHasCycle = detectCycle(V, adj);
		System.out.println("The Graph has been detected with a cycle : " + graphHasCycle);
	}

	private static boolean detectCycle(int V, ArrayList<ArrayList<Integer>> adj) {
		int[] visited = new int[V];
		Arrays.fill(visited, -1);
		for (int i = 0; i < visited.length; i++) {
			if (visited[i] == -1 && dfsDetectCycle(i, -1, adj, visited)) {
				return true;
			}
		}
		return false;
	}

	private static boolean dfsDetectCycle(int current, int parent, ArrayList<ArrayList<Integer>> adj, int[] visited) {
		visited[current] = 0;
		for (Integer i : adj.get(current)) {
			if (visited[i] == -1) {
				if (dfsDetectCycle(i, current, adj, visited)) {
					return true;
				}
			} else if (i != parent) {
				return true;
			}
		}
		return false;
	}


}
