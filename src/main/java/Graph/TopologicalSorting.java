package Graph;

import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSorting {

    //GFG//

    /*
    In topological sorting:

    -We use a temporary stack.
    -We don’t print the vertex immediately,
    -We first recursively call topological sorting for all its
    adjacent vertices, then push it to a stack.
    -Finally, print the contents of the stack.
     */

    public static void topologicalSort(int V, ArrayList<ArrayList<Integer>> adj) {

        //Create a stack
        Stack<Integer> s = new Stack<>();
        //Initialize visited array of size N
        boolean[] visited = new boolean[V];

        //Call the recursive function for topological sort for
        //every node
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                topologicalSortUtil(i, visited, s, adj);
            }
        }

        //Print contents of stack
        while (!s.empty())
            System.out.print(s.pop() + " ");
    }

    public static void topologicalSortUtil(int v, boolean[] visited, Stack<Integer> stack, ArrayList<ArrayList<Integer>> adj) {
        visited[v] = true;

        for (int i : adj.get(v)) {
            if (!visited[i]) {
                topologicalSortUtil(i, visited, stack, adj);
            }
        }

        //Push the current node in the stack.
        stack.push(v);
    }


    public static void main(String[] args) {
        // Create a graph given in the above diagram
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < 6; i++) adj.add(new ArrayList<Integer>());
        adj.get(5).add(2);
        adj.get(5).add(0);
        adj.get(4).add(0);
        adj.get(4).add(1);
        adj.get(2).add(3);
        adj.get(3).add(1);

        topologicalSort(6, adj);
    }

}
