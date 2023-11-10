/**
 * 
 */
package com.dsa.graph.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class Graph {
	int numVertices;
	Map<Integer, ArrayList<Integer>> adjList;

	public Graph(int numVertices) {
		this.numVertices = numVertices;
		this.adjList = new HashMap<Integer, ArrayList<Integer>>();
	}

	public void addVertex(int vertex) {
		this.adjList.put(vertex, new ArrayList<Integer>());
	}

	public void addEdge(int src, int dest) {
		this.adjList.get(src).add(dest);
	}

	public void printGraph() {
		for (Map.Entry<Integer, ArrayList<Integer>> entry : this.adjList.entrySet()) {
			System.out.println(entry);
		}
	}
}

/**
 * 
 *         0
 *          *       3
 *           *     * *
 *            *   *   *
 *             * *     *
 *              2 * * * 1
 */
public class P1_Graph_Implementation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] vertices = { 1, 2, 3, 4 };
		Graph graph = new Graph(vertices.length);
		for (int i = 0; i < vertices.length; i++) {
			graph.addVertex(i);
		}
		graph.addEdge(0, 2);

		graph.addEdge(1, 2);
		graph.addEdge(1, 3);

		graph.addEdge(2, 0);
		graph.addEdge(2, 1);
		graph.addEdge(2, 3);

		graph.addEdge(3, 1);
		graph.addEdge(3, 2);

		graph.printGraph();
	}

}
