package Graph;

import java.util.ArrayList;

public class DetectCycleInUnDirectedGraph {

    //GFG//
    // Given an undirected graph with V vertices and E edges, check
    // whether it contains any cycle or not. Graph is in the form
    // of adjacency list where adj[i] contains all the nodes ith
    // node is having edge with.

    public boolean isCycle(int V,
                           ArrayList<ArrayList<Integer>> adj) {

        // Using DFS
        // Idea: for every visited vertex v, if there is an
        // adjacent u such that u is already visited and u is not
        // the parent of v, then there is a cycle

        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (isCycleUtil(adj, i, -1, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isCycleUtil(
            ArrayList<ArrayList<Integer>> adj,
            int u, int prev, boolean[] visited) {
        visited[u] = true;

        for (int v : adj.get(u)) {
            if (!visited[v]) {
                if (isCycleUtil(adj, v, u, visited))
                    return true;
            } else if (v != prev) {
                return true;
            }
        }
        return false;
    }
}
