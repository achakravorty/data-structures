package Graph;

import java.util.*;

import static Graph.testDFS.DFSByIterative.dfsByIterative;

public class testDFS {

    static public class DFSByIterative {
        public static void dfsByIterative(GraphUndirectedByAdjacencyList g, int v) {
            boolean[] visited = new boolean[g.getV()];
            Deque<Integer> stack = new ArrayDeque<>();
            stack.push(v);

            while (!stack.isEmpty()) {
                v = stack.pop();

                if (!visited[v]) {
                    visited[v] = true;
                    System.out.printf("%d ", v);

                    for (Integer w : g.getAdjacencyList().get(v)) {
                        stack.push(w);
                    }
                }
            }
        }

    }

    public static void main(String[] args) {
        GraphUndirectedByAdjacencyList g = new GraphUndirectedByAdjacencyList(5);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(1, 0);
        g.addEdge(1, 3);
        g.addEdge(2, 4);
//        g.addEdge(0,2);
//        g.addEdge(0,3);
//        g.addEdge(0,1);
//        g.addEdge(2, 4);

        dfsByIterative(g, 0);
    }



    static public class GraphUndirectedByAdjacencyList {
        private int V;
        private List<List<Integer>> adjacencyList;

        public GraphUndirectedByAdjacencyList(int V) {
            this.V = V;

            adjacencyList = new ArrayList<>(V);
            for (int i = 0; i < V; i++) {
                adjacencyList.add(new ArrayList<>());
            }
        }

        public Integer getV() {
            return this.V;
        }

        public List<List<Integer>> getAdjacencyList() {
            return this.adjacencyList;
        }

        public void addEdge(int source, int dest) {
            adjacencyList.get(source).add(dest);
            adjacencyList.get(dest).add(source);
        }

        public void printAdjacencyList() {
            for (int i = 0; i < V; i++) {
                System.out.printf("Adjacency list of vertex %d is %s %s", i,
                        adjacencyList.get(i), System.lineSeparator());
            }
        }
    }
}
