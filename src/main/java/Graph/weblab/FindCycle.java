package Graph.weblab;

import java.util.*;

public class FindCycle {

    // Write a method inCycle(List<Map<Integer,Integer>> graph, int
    // vertex) that determines whether the vertex 'vertex' in the
    // graph 'graph' is part of a cycle.

    public static boolean inCycle(List<Map<Integer,Integer>> graph, int vertex) {
        //here graph is represented as a weighted adjacency map
        //a list of maps - each vertex is a map

        Set<Integer> visited = new HashSet<>();

        return helper(graph, vertex, vertex, visited);
    }

    //using DFS traversal
    public static boolean helper(List<Map<Integer,Integer>> graph, int vertex, int current, Set<Integer> visited) {
        visited.add(current);

        //for each edge
        for (int next : graph.get(current).keySet()) {
            //if we encounter the vertex we are looking for
            if (next == vertex) {
                return true;
            }
            if (!visited.contains(next)) {
                //only if it is true, then return true
                if (helper(graph, vertex, next, visited)) {
                    return true;
                }
            }
        }

        return false; //if we didnt find it
    }
}
