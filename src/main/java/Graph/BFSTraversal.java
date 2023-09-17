package Graph;

import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;

public class BFSTraversal {

    //GFG//
    //Given a directed graph. The task is to do Breadth First
    //Traversal of this graph starting from 0.
    //Note: One can move from node u to node v only if there's an
    //edge from u to v. Find the BFS traversal of the graph starting
    //from the 0th vertex, from left to right according to the input
    //graph. Also, you should only take nodes directly or indirectly
    //connected from Node 0 in consideration.

    /**
     * Function to return Breadth First Traversal of given graph.
     *
     * @param V   the number of vertices
     * @param adj adjacency list
     * @return returns  a list containing the BFS traversal of the
     * graph starting from the 0th vertex from left to right.
     */
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {

        HashSet<Integer> visited = new HashSet<>();
        Deque<Integer> q = new ArrayDeque<>();
        ArrayList<Integer> list = new ArrayList<>();

        q.add(0);
        visited.add(0);

        while (!q.isEmpty()) {

            int p = q.remove();
            list.add(p);

            for (int neighbor : adj.get(p)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    q.add(neighbor);
                }
            }
        }

        return list;
    }
}
