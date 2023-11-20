/**
 * 
 */
package com.dsa.graph.shortestpath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * CodingNinjas
 * 
 * Link:
 * https://www.codingninjas.com/studio/problems/single-source-shortest-path_8416371
 * 
 * TC: O(n + 2m)
 * SC: O(2n + m)
 */
public class P1_Graph_Single_Source_Shortest_Path {

	static class Pair {
		int node;
		int distance;

		public Pair(int node, int dist) {
			this.node = node;
			this.distance = dist;
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int n = 10; // vertices
		int[][] edges = { { 1, 2 }, { 1, 3 }, { 1, 4 }, { 1, 5 }, { 1, 7 }, { 2, 4 }, { 2, 6 }, { 3, 4 }, { 3, 5 },
				{ 3, 9 }, { 4, 6 }, { 7, 8 }, { 8, 9 } };
		int src = 8;
		int[] minPath = shortestPath(n, edges, src);
		System.out.println("Shortest path to all vertices from " + src + " : " + Arrays.toString(minPath));
	}

	public static int[] shortestPath(int n, int[][] edges, int src) {
		ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>();
		int[] minPath = new int[n];
		Arrays.fill(minPath, -1);
		for (int i = 0; i < n; i++) {
			adjList.add(new ArrayList<Integer>());
		}
		for (int i = 0; i < edges.length; i++) {
			adjList.get(edges[i][0]).add(edges[i][1]);
			adjList.get(edges[i][1]).add(edges[i][0]);
		}

		Queue<Pair> queue = new LinkedList<Pair>();
		for (int i = 0; i < n; i++) {
			if (i == src && minPath[i] == -1) {
				minPath[i] = 0;
				queue.offer(new Pair(i, 0));
				break;
			}
		}
		while (!queue.isEmpty()) {
			Pair currentPair = queue.poll();
			for (Integer it : adjList.get(currentPair.node)) {
				if (minPath[it] == -1) {
					minPath[it] = currentPair.distance + 1;
					queue.offer(new Pair(it, minPath[it]));
				}
			}
		}
		return minPath;
	}

}
