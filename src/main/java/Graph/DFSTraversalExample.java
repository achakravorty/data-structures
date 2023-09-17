package Graph;

import java.util.LinkedList;

public class DFSTraversalExample {

    static class Graph {
        private int V; // Number of vertices
        private LinkedList<Integer>[] adjList; // Array of linked lists to represent adjacency list

        // Constructor
        public Graph(int v) {
            V = v;
            adjList = new LinkedList[v];
            for (int i = 0; i < v; ++i)
                adjList[i] = new LinkedList<>();
        }

        // Add an edge to the graph
        void addEdge(int v, int w) {
            adjList[v].add(w);
        }

        // Depth First Search
        void dfs(int v, boolean[] visited) {
            visited[v] = true;
            System.out.print(v + " ");

            for (Integer neighbor : adjList[v]) {
                if (!visited[neighbor]) {
                    dfs(neighbor, visited);
                }
            }
        }

        // DFS starting from a specific vertex
        void dfs(int v) {
            boolean[] visited = new boolean[V];
            dfs(v, visited);
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(4);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);

        System.out.println("Depth First Traversal starting from vertex 2:");
        graph.dfs(2);
    }


    /*
    //DFS//

    static HashSet<Vertex> visited;
    static Deque<Vertex> q;
    static List<Integer> list;
    static Graph graph;
    traverseDepthFirst(Graph g, Vertex v) {
        //List<Integer> vertices = new ArrayList<>();
        visited = new HashSet<>();
        list = new ArrayList<>();
        graph = g;
        visit(v);
        return list;
    }
    static void visit(Vertex v) {
        visited.add(v);
        list.add(v.getId());
        for (Vertex neighbour : v.getNeighbours()) {
            if (!visited.contains(neighbour))
                visit(neighbour);
        }
    }
     */

}
