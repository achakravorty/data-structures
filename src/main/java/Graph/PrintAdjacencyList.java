package Graph;

import java.util.ArrayList;
import java.util.List;

public class PrintAdjacencyList {

    //GFG//
    // Given an undirected graph with V nodes and E edges, create
    // and return an adjacency list of the graph. 0-based indexing
    // is followed everywhere.
    // Your task is to complete the function printGraph() which
    // takes the integer V denoting the number of vertices and
    // edges as input parameters and returns the list of list
    // denoting the adjacency list.

    /**
     * Function to print adjacency list of graph.
     *
     * @param V     number of vertices of graph
     * @param edges edges of graph
     * @return adjacency list denoting graph
     */
    public List<List<Integer>> printGraph(int V, int[][] edges) {

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            result.add(new ArrayList<>());
        }

        //traversing edges list that has 2 columns and many rows
        for (int[] edge : edges) {
            int firstElement = edge[0];
            int secondElement = edge[1];

            result.get(firstElement).add(secondElement);
            result.get(secondElement).add(firstElement);
        }
        return result;
    }
}
