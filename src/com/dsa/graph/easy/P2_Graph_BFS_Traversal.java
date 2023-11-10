/**
 * 
 */
package com.dsa.graph.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 
 * Coding Ninjas Link:
 * https://www.codingninjas.com/studio/problems/bfs-in-graph_973002
 * 
 * Time Complexity : O(Vertices + Edges)
 * Space Complexity : O(Vertices)
 */
public class P2_Graph_BFS_Traversal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[][] input = { { 1, 2, 3 }, { 4, 7 }, { 5 }, { 6 }, {}, {}, {}, {} };
		List<List<Integer>> adjList = createAdjacencyList(input);
		List<Integer> bfsPath = bfsTraversal(input.length, adjList);
		System.out.println("BFS Traversal of " + adjList + " is : " + bfsPath);
	}

	private static List<List<Integer>> createAdjacencyList(int[][] arr) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		for (int i = 0; i < arr.length; i++) {
			List<Integer> item = new ArrayList<Integer>();
			for (int j = 0; j < arr[i].length; j++) {
				item.add(arr[i][j]);
			}
			result.add(item);
		}
		return result;
	}

	private static List<Integer> bfsTraversal(int n, List<List<Integer>> adj) {
		List<Integer> bfsPath = new ArrayList<Integer>();
		bfsTraversalHelper(n, adj, 0, bfsPath);
		return bfsPath;
	}

	private static void bfsTraversalHelper(int n, List<List<Integer>> adj, int start, List<Integer> bfsPath) {
		boolean[] visited = new boolean[n];
		Arrays.fill(visited, false);
		visited[start] = true;
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(start);
		while (queue.size() > 0) {
			Integer current = queue.poll();
			bfsPath.add(current);
			for (int i = 0; i < adj.get(current).size(); i++) {
				if (!visited[adj.get(current).get(i)]) {
					visited[adj.get(current).get(i)] = true;
					queue.add(adj.get(current).get(i));
				}
			}
		}
	}

}
