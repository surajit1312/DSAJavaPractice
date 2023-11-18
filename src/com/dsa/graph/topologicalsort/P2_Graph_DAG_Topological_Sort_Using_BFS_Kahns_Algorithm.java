/**
 * 
 */
package com.dsa.graph.topologicalsort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 
 * CodingNinjas Link:
 * https://www.codingninjas.com/studio/problems/topological-sorting_973003
 * 
 * TC: O(V + E) SC: O(2V)
 * 
 */
public class P2_Graph_DAG_Topological_Sort_Using_BFS_Kahns_Algorithm {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int V = 6; // Graph vertices are 0 based index ({ 0, 1, 2, 3, 4, 5 }
		int E = 6;
		int[][] edges = { { 5, 0 }, { 4, 0 }, { 5, 2 }, { 4, 1 }, { 2, 3 }, { 3, 1 } };
		List<Integer> sortedList = topologicalSort(edges, E, V);
		System.out.println("Topological Sorting of Graph " + Arrays.deepToString(edges) + " is: " + sortedList);
	}

	private static List<Integer> topologicalSort(int[][] edges, int e, int v) {
		ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>();
		List<Integer> topoSortBFS = new ArrayList<Integer>();
		int[] indegrees = new int[v];
		Arrays.fill(indegrees, 0);
		for (int i = 0; i < v; i++) {
			adjList.add(new ArrayList<Integer>());
		}
		for (int i = 0; i < e; i++) {
			adjList.get(edges[i][0]).add(edges[i][1]);
		}
		for (int i = 0; i < v; i++) {
			for (Integer it : adjList.get(i)) {
				indegrees[it]++;
			}
		}
		Queue<Integer> queue = new LinkedList<Integer>();
		// add the items in the queue which has indegree = 0
		for (int i = 0; i < indegrees.length; i++) {
			if (indegrees[i] == 0) {
				queue.add(i);
			}
		}
		while (!queue.isEmpty()) {
			int current = queue.poll();
			topoSortBFS.add(current);
			for (Integer it : adjList.get(current)) {
				if (--indegrees[it] == 0) {
					queue.add(it);
				}
			}
		}
		return topoSortBFS;
	}

}
