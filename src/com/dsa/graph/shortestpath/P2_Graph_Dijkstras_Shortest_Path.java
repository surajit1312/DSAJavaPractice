/**
 * 
 */
package com.dsa.graph.shortestpath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 
 * CodingNinjas:
 * 
 * Link:
 * https://www.codingninjas.com/studio/problems/dijkstra's-shortest-path_985358
 * 
 * TC: O(ElogV) where E = Edges and V = Vertices 
 * SC: O(3V + 2E)
 * 
 */
public class P2_Graph_Dijkstras_Shortest_Path {

	static class Edge {
		int dest;
		int weight;

		public Edge(int dest, int weight) {
			this.dest = dest;
			this.weight = weight;
		}
	}

	static class Pair {
		int distance;
		int node;

		public Pair(int dist, int node) {
			this.distance = dist;
			this.node = node;
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[][] edge = { { 0, 1, 7 }, { 0, 2, 1 }, { 0, 3, 2 }, { 1, 2, 3 }, { 1, 3, 5 }, { 1, 4, 1 }, { 3, 4, 7 } };
		int vertices = 5, edges = 7, source = 0;
		List<Integer> shortestPath = dijkstra(edge, vertices, edges, source);
		System.out.println("Shortest path from source node " + source + " to all nodes : " + shortestPath);
	}

	public static List<Integer> dijkstra(int[][] edge, int vertices, int edges, int source) {
		List<Integer> shortestPath = new ArrayList<Integer>();
		ArrayList<ArrayList<Edge>> adjList = new ArrayList<ArrayList<Edge>>();
		for (int i = 0; i < vertices; i++) {
			adjList.add(new ArrayList<Edge>());
		}
		for (int i = 0; i < edges; i++) {
			adjList.get(edge[i][0]).add(new Edge(edge[i][1], edge[i][2]));
			adjList.get(edge[i][1]).add(new Edge(edge[i][0], edge[i][2]));
		}
		int[] path = new int[vertices];
		Arrays.fill(path, Integer.MAX_VALUE);

		PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x, y) -> x.distance - y.distance);

		for (int i = 0; i < path.length; i++) {
			if (i == source) {
				path[i] = 0;
				pq.offer(new Pair(0, i));
				break;
			}
		}

		while (pq.size() != 0) {
			Pair currentPair = pq.poll();
			int currentNode = currentPair.node;
			int distance = currentPair.distance;

			for (int i = 0; i < adjList.get(currentNode).size(); i++) {
				int edgeNode = adjList.get(currentNode).get(i).dest;
				int edgeWeight = adjList.get(currentNode).get(i).weight;
				if (distance + edgeWeight < path[edgeNode]) {
					path[edgeNode] = distance + edgeWeight;
					pq.add(new Pair(distance + edgeWeight, edgeNode));
				}
			}
		}
		for (int i = 0; i < path.length; i++) {
			if (path[i] == Integer.MAX_VALUE) {
				path[i] = -1;
			}
			shortestPath.add(path[i]);
		}
		return shortestPath;
	}

}
