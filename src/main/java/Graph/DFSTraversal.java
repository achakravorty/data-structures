package Graph;

import java.util.ArrayList;
import java.util.HashSet;

public class DFSTraversal {

    //GFG//
    ///You are given a connected undirected graph. Perform a Depth
    //First Traversal of the graph.
    //Note: Use the recursive approach to find the DFS traversal of
    //the graph starting from the 0th vertex from left to right
    //according to the graph.



    /**
     * Function to return a list containing the DFS traversal of
     * the graph.
     * @param V the number of vertices
     * @param adj adjacency list
     * @return a list containing the DFS traversal of the graph
     * starting from the 0th vertex from left to right according to the graph.
     */
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        HashSet<Integer> visited = new HashSet<>();
        ArrayList<Integer> list = new ArrayList<>();

        dfs(0, adj, visited, list);

        return list;
    }

    static void dfs(int vertex, ArrayList<ArrayList<Integer>> adj
            , HashSet<Integer> visited, ArrayList<Integer> list) {

        visited.add(vertex);
        list.add(vertex);

        for (int neighbor : adj.get(vertex)) {
            if (!visited.contains(neighbor)) {
                dfs(neighbor, adj, visited, list);
            }
        }
    }
}
