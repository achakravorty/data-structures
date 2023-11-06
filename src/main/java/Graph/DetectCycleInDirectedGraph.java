package Graph;

import java.util.ArrayList;

public class DetectCycleInDirectedGraph {

    //GFG//

    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // Using DFS by marking the visited nodes, there is a cycle
        // if a visited node is also part of the current stack

        boolean[] visited = new boolean[V];
        boolean[] stack = new boolean[V];

        for (int i=0; i < V; i++) {
            if (isCyclisUtil(adj,i, visited, stack)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isCyclisUtil(ArrayList<ArrayList<Integer>> adj, int u, boolean[] visited, boolean[] stack) {

        if (stack[u]) { return true; }
        if (visited[u]) { return false; }

        stack[u] = true;
        visited[u] = true;

        //for each edge
        for (int v : adj.get(u)) {
            //if we encounter the vertex we are looking for
            if (isCyclisUtil(adj, v, visited, stack)) {
                return true;
            }
        }
        //pop it from stack
        stack[u] = false;

        return false;
    }

    //IDEA of algorithm
    //    1.Initialize a set to keep track of visited vertices and a
    //    stack for DFS traversal.
    //
    //    2.Start from an arbitrary vertex and mark it as visited.
    //
    //    3.For the current vertex, visit all its unvisited
    //    neighbors recursively.
    //
    //    4.While visiting a neighbor, if you encounter a vertex
    //    that is already in the stack, it means you've found a back edge, indicating a cycle.
    //
    //    5.Once you've finished visiting all neighbors of the
    //    current vertex, pop it from the stack.
    //
    //    6.Repeat steps 2-5 for all unvisited vertices until the
    //    entire graph is traversed.
}
