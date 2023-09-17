package Graph;

import java.util.LinkedList;

public class GraphExample {


    //Representing a Directed Graph using Adjacency List//
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

        // Print the graph
        void printGraph() {
            for (int i = 0; i < V; ++i) {
                System.out.println("Adjacency list of vertex " + i);
                for (Integer vertex : adjList[i]) {
                    System.out.print(" -> " + vertex);
                }
                System.out.println();
            }
        }
    }



}
