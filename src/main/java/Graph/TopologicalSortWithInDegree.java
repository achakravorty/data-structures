package Graph;

import java.util.*;

public class TopologicalSortWithInDegree {

    //Topological sort technique (Time and space: O(V + E))

    //If there is an edge from U to V, then U <= V
    //(Only for DAGs)

    //Algorithm:
    //
    // -Create a graph representation (adjacency list) and an in
    // degree counter (Map<Integer, Integer>)
    // -Zero them for each vertex
    // -Fill the adjacency list and the in degree counter for each
    // edge
    // -Add in a queue each vertex whose in degree count is 0
    // (source vertex with no parent)
    // -While the queue is not empty, poll a vertex from it then
    // decrement the in degree of its children (no removal)
    //
    // To check if there is a cycle, we must compare the size of
    // the produced array to the number of vertices

    public List<Integer> sort(int vertices, int[][] edges) {

        List<Integer> sorted = new ArrayList<>(vertices);

        //Adjacency list graph
        Map<Integer, List<Integer>> graph = new HashMap<>();
        //Count of incoming edges for each vertex
        Map<Integer, Integer> inDegree = new HashMap<>();

        for (int i = 0; i < vertices; i++) {
            inDegree.put(i, 0);
            graph.put(i, new LinkedList<>());
        }

        //Init graph and inDegree
        for (int[] edge : edges) {
            int parent = edge[0];
            int child = edge[1];

            graph.get(parent).add(child);
            inDegree.put(child, inDegree.get(child) + 1);
        }

        //Create a source queue and add each source (a vertex
        //whose inDegree count is 0)
        Queue<Integer> sources = new LinkedList<>();
        for (Map.Entry<Integer, Integer> entry : inDegree.entrySet()) {
            if (entry.getValue() == 0) {
                sources.add(entry.getKey());
            }
        }

        while (!sources.isEmpty()) {
            int vertex = sources.poll();
            sorted.add(vertex);

            //For each vertex, we will decrease the inDegree count of its children
            List<Integer> children = graph.get(vertex);
            for (int child : children) {
                inDegree.put(child, inDegree.get(child) - 1);
                if (inDegree.get(child) == 0) {
                    sources.add(child);
                }
            }
        }

        //Topological sort is not possible as the graph has a cycle
        if (sorted.size() != vertices) {
            return new ArrayList<>();
        }

        return sorted;

    }
}
