package Graph;

import java.util.*;

public class DFSTraversalWithStack {

    //ITERATIVE SOL//
    // Depth-first search is an algorithm for traversing or
    // searching tree or graph data structures. The algorithm
    // starts at the root node (selecting some arbitrary node as
    // the root node in the case of a graph) and explores as far
    // as possible along each branch before backtracking.

    //Algorithm:
    //
    //    1.Created a stack of nodes and visited array.
    //    2.Insert the root in the stack.
    //    3.Run a loop till the stack is not empty.
    //    4.Pop the element from the stack and print the element.
    //    5.For every adjacent and unvisited node of current node,
    //     6.mark the node and insert it in the stack.

    /**
     * Function to return Depth First Traversal of given graph
     * iteratively.
     * @param V the number of vertices
     * @param adj adjacency list
     * @return returns  a list containing the DFS traversal of the
     * graph starting from the 0th vertex from left to right.
     */
    public static ArrayList<Integer> dfsOfGraphIterative(int V, ArrayList<ArrayList<Integer>> adj) {

        //using boolean array to keep track of visited nodes
        boolean[] visited = new boolean[V];
        Deque<Integer> s = new ArrayDeque<>();
        ArrayList<Integer> list = new ArrayList<>();

        s.push(0);

        while (!s.isEmpty()) {

            int p = s.pop();

            //Stack may contain same vertex twice. So
            //we need to add the popped item only
            //if it is not visited.
            if (!visited[p]) {
                visited[p] = true; // add to visited
                list.add(p); //visit action
            }

            //you need to push into the stack from the end to get
            //DFS from left to right
            for (int i = adj.get(p).size() - 1; i >= 0; i--) {
                int neighbor = adj.get(p).get(i);
                if (!visited[neighbor]) {
                    s.push(neighbor);
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < 5; i++) adj.add(new ArrayList<Integer>());
        adj.get(0).add(2);
        adj.get(0).add(3);
        adj.get(0).add(1);
        adj.get(1).add(0);
        adj.get(2).add(0);
        adj.get(2).add(4);
        adj.get(3).add(0);
        adj.get(4).add(2);

        ArrayList<Integer> list = dfsOfGraphIterative(5, adj);

        System.out.println(list.toString());

    }

    //using HashSet to keep track of visited nodes - TIME TOO LONG//
//    public static ArrayList<Integer> dfsOfGraphIterative(int V, ArrayList<ArrayList<Integer>> adj) {
//
//        HashSet<Integer> visited = new HashSet<>();
//        Deque<Integer> s = new ArrayDeque<>();
//        ArrayList<Integer> list = new ArrayList<>();
//
//        s.push(0);
//
//        while (!s.isEmpty()) {
//
//            int p = s.pop();
//
//            // Stack may contain same vertex twice. So
//            // we need to add the popped item only
//            // if it is not visited.
//            if (!visited.contains(p)) {
//                visited.add(p); // add to visited list if
//                list.add(p); //visit action
//            }
//
//            //you need to push into the stack from the end
//            for (int i = adj.get(p).size() - 1; i >= 0; i--) {
//                int neighbor = adj.get(p).get(i);
//                if (!visited.contains(neighbor)) {
//                    s.push(neighbor);
//                }
//            }
//        }
//
//        return list;
//    }

    /*
    //NOT CORRECT//
    //tried to modify BFS algo to DFS directly but that is //
    public static ArrayList<Integer> dfsOfGraphIterativeTest(int V,
                                                          ArrayList<ArrayList<Integer>> adj) {

        HashSet<Integer> visited = new HashSet<>();
        Deque<Integer> s = new ArrayDeque<>();
        ArrayList<Integer> list = new ArrayList<>();

        s.push(0);
        visited.add(0);

        while (!s.isEmpty()) {

            int p = s.poll();
            list.add(p); //visit action

            for (int i = adj.get(p).size() - 1; i >= 0; i--) {
                int neighbor = adj.get(p).get(i);
                if (!visited.contains(neighbor)) {
                    s.push(neighbor);
                    visited.add(neighbor);
                }
            }
        }

        return list;
    }
     */

}
