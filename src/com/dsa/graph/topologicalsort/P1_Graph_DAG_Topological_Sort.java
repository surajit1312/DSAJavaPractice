/**
 * 
 */
package com.dsa.graph.topologicalsort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 
 * CodingNinjas Link: https://www.codingninjas.com/studio/problems/topological-sorting_973003
 * 
 * TC: O(V + E) 
 * SC: O(2V)
 */
public class P1_Graph_DAG_Topological_Sort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int V = 5; // Graph vertices are 0 based index ({ 0, 1, 2, 3, 4 }
		int E = 4;
		int[][] edges = { { 0, 2 }, { 1, 2 }, { 3, 1 }, { 0, 4 } };
		List<Integer> sortedList = topologicalSort(edges, E, V);
		System.out.println("Topological Sorting of Graph " + Arrays.deepToString(edges) + " is: " + sortedList);
	}

	private static List<Integer> topologicalSort(int[][] edges, int e, int v) {
		ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
		List<Integer> topoSortList = new ArrayList<Integer>();
		for (int i = 0; i < v; i++) {
			adj.add(new ArrayList<Integer>());
		}
		for (int i = 0; i < e; i++) {
			adj.get(edges[i][0]).add(edges[i][1]);
		}
		boolean[] visited = new boolean[v];
		Stack<Integer> st = new Stack<Integer>();
		for (int i = 0; i < v; i++) {
			if (!visited[i]) {
				dfsGraph(i, adj, visited, st);
			}
		}
		while (!st.isEmpty()) {
			topoSortList.add(st.pop());
		}
		return topoSortList;
	}

	private static void dfsGraph(int current, ArrayList<ArrayList<Integer>> adj, boolean[] visited, Stack<Integer> st) {
		visited[current] = true;
		for (Integer adjItem : adj.get(current)) {
			if (!visited[adjItem]) {
				dfsGraph(adjItem, adj, visited, st);
			}
		}
		st.push(current);
	}

}
