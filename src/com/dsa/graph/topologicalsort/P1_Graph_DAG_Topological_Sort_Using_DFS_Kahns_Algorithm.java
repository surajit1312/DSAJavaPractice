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
 * CodingNinjas Link:
 * https://www.codingninjas.com/studio/problems/topological-sorting_973003
 * 
 * TC: O(V + E) SC: O(2V)
 */
public class P1_Graph_DAG_Topological_Sort_Using_DFS_Kahns_Algorithm {

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
		ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>();
		List<Integer> topoSortList = new ArrayList<Integer>();
		for (int i = 0; i < v; i++) {
			adjList.add(new ArrayList<Integer>());
		}
		for (int i = 0; i < edges.length; i++) {
			adjList.get(edges[i][0]).add(edges[i][1]);
		}
		Stack<Integer> st = new Stack<Integer>();
		boolean[] visited = new boolean[v];
		Arrays.fill(visited, false);
		for (int i = 0; i < visited.length; i++) {
			if (!visited[i]) {
				dfsGraphTopo(i, adjList, visited, st);
			}
		}
		while (!st.isEmpty()) {
			topoSortList.add(st.pop());
		}
		return topoSortList;
	}

	private static void dfsGraphTopo(int current, ArrayList<ArrayList<Integer>> adjList, boolean[] visited,
			Stack<Integer> st) {
		visited[current] = true;
		for (int i = 0; i < adjList.get(current).size(); i++) {
			if (!visited[adjList.get(current).get(i)]) {
				dfsGraphTopo(adjList.get(current).get(i), adjList, visited, st);
			}
		}
		st.add(current);
	}

}
