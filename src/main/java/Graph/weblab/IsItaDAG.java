package Graph.weblab;

import java.util.*;

public class IsItaDAG {

    /*
     Write a method isDAG(List<Map<Integer,Integer>> graph, int
     vertex) that determines whether the graph 'graph' is a directed
     acyclic graph.
    */

    public static boolean isDAG(List<Map<Integer, Integer>> graph) {

        // check if there are no cycles - acyclic
        Set<Integer> visited = new HashSet<>();
        Set<Integer> recStack = new HashSet<>();

        for (int i = 0; i < graph.size(); i++) {
            if (detectCycle(graph, i, visited, recStack)) {
                return false;
            }
        }

        return true; //if no cycle found then its acyclic
    }


    /**
     * Helper function to detect cycles in graph using DFS.
     *
     * @param graph    graph to be checked
     * @param vertex   start vertex of DFS
     * @param visited  set of nodes visited
     * @param recStack set of nodes in recursion stack
     * @return true if cycle is found in graph
     */
    public static boolean detectCycle(List<Map<Integer, Integer>> graph, int vertex, Set<Integer> visited, Set<Integer> recStack) {

        if (recStack.contains(vertex)) {
            return true;
        }

        if (visited.contains(vertex)) {
            return false;
        }

        visited.add(vertex);
        recStack.add(vertex);

        for (int neighbour : graph.get(vertex).keySet()) {
            if (detectCycle(graph, neighbour, visited, recStack)) {
                return true;
            }
        }

        recStack.remove(vertex); //back track

        return false;
    }
}
