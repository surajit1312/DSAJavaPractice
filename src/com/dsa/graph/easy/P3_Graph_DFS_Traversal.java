/**
 * 
 */
package com.dsa.graph.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Coding Ninjas Link: https://www.codingninjas.com/studio/problems/dfs-traversal_630462
 * 
 * Time Complexity : O(Vertices + Edges)
 * Space Complexity : O(Vertices)
 */
public class P3_Graph_DFS_Traversal {

	static class Graph {
		int numVertices;
		Map<Integer, ArrayList<Integer>> adjList;

		public Graph(int numVertices) {
			this.numVertices = numVertices;
			this.adjList = new HashMap<Integer, ArrayList<Integer>>();
		}

		public void addVertex(int vertex) {
			this.adjList.put(vertex, new ArrayList<Integer>());
		}

		public void addEdge(ArrayList<Integer> edge) {
			if (!this.adjList.containsKey(edge.get(0))) {
				addVertex(edge.get(0));
			}
			if (!this.adjList.containsKey(edge.get(1))) {
				addVertex(edge.get(1));
			}
			this.adjList.get(edge.get(0)).add(edge.get(1));
			this.adjList.get(edge.get(1)).add(edge.get(0));
		}

		public void printGraph() {
			for (Map.Entry<Integer, ArrayList<Integer>> entry : this.adjList.entrySet()) {
				System.out.println(entry);
			}
		}
	}

	/**
	 * @param args
	 * Input:
	 * 
	 * 9 7
     * 0 1
     * 0 2
     * 0 5
     * 3 6
     * 7 4
     * 4 8
     * 7 8
	 */
	public static void main(String[] args) {
		int numVertices = 9;
		int numEdges = 7;
		int[][] edgeArr = { { 0, 1 }, { 0, 2 }, { 0, 5 }, { 3, 6 }, { 7, 4 }, { 4, 8 }, { 7, 8 } };
		ArrayList<ArrayList<Integer>> edges = getEdgesFromArray(edgeArr);
		ArrayList<ArrayList<Integer>> dfsPath = depthFirstSearch(numVertices, numEdges, edges);
		System.out.println("DFS Path for given graph with edges " + edges + " : " + dfsPath);
	}

	private static ArrayList<ArrayList<Integer>> getEdgesFromArray(int[][] edges) {
		ArrayList<ArrayList<Integer>> edgeList = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < edges.length; i++) {
			ArrayList<Integer> edgeItem = new ArrayList<Integer>();
			for (int j = 0; j < edges[i].length; j++) {
				edgeItem.add(edges[i][j]);
			}
			edgeList.add(edgeItem);
		}
		return edgeList;
	}

	private static ArrayList<ArrayList<Integer>> depthFirstSearch(int v, int e, ArrayList<ArrayList<Integer>> edges) {
		Graph graph = new Graph(v);
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		boolean[] visited = new boolean[v];
		Arrays.fill(visited, false);
		for (int i = 0; i < edges.size(); i++) {
			graph.addEdge(edges.get(i));
		}
		for (int i = 0; i < visited.length; i++) {
			if (!visited[i]) {
				ArrayList<Integer> dfsPath = new ArrayList<Integer>();
				dfsHelper(graph.adjList, visited, i, dfsPath);
				result.add(dfsPath);
			}
		}
		return result;
	}

	private static void dfsHelper(Map<Integer, ArrayList<Integer>> adjList, boolean[] visited, int current,
			ArrayList<Integer> dfsPath) {
		if (visited[current]) {
			return;
		}
		visited[current] = true;
		dfsPath.add(current);
		if (adjList.get(current) != null) {
			for (int i = 0; i < adjList.get(current).size(); i++) {
				dfsHelper(adjList, visited, adjList.get(current).get(i), dfsPath);
			}
		}
	}

}
