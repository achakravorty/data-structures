package Graph;

import java.util.LinkedList;
import java.util.Queue;

public class BFSTraversalExample {

    class Graph {
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

        // Breadth First Search
        void bfs(int startVertex) {
            boolean[] visited = new boolean[V];
            Queue<Integer> queue = new LinkedList<>();

            visited[startVertex] = true;
            queue.add(startVertex);

            while (!queue.isEmpty()) {
                int currentVertex = queue.poll();
                System.out.print(currentVertex + " ");

                for (Integer neighbor : adjList[currentVertex]) {
                    if (!visited[neighbor]) {
                        visited[neighbor] = true;
                        queue.add(neighbor);
                    }
                }
            }
        }
    }


    public void main(String[] args) {
        Graph graph = new Graph(4);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);

        System.out.println("Breadth First Traversal starting from vertex 2:");
        graph.bfs(  2);
    }

    /*
    //BFS//
    static HashSet<Vertex> visited;
    static Deque<Vertex> q;
    static List<Vertex> list;
    public static boolean solve(Vertex a, Vertex b) {
        visited = new HashSet<>();
        q = new LinkedList<>();
        q.add(a);

        while (!q.isEmpty()) {
            Vertex temp = q.remove();
            visited.add(temp);
            if(temp == b) return true;
            for (Vertex n : temp.getNeighbours()) {
                if (!visited.contains(n)) {
                    q.add(n);
                }
            }
        }
        return false;
    }

    static void breadthFirstSearch(Vertex v){
        q.add(v);
        while (!q.isEmpty()){
            Vertex temp = q.remove();
            visited.add(temp);
            for (Vertex n : temp.getNeighbours()) {
                if (!visited.contains(n)) {
                    q.add(n);
                }
            }
        }
    }
     */
}
