package Graph;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class DijkstraAlgorithmImplementation {

    //GFG//

    //Algorithm:
    //    1. Init the shortest distance to MAX except for the initial
    //    node
    //    2. Init a priority queue where the comparator will be on
    //    the total distance so far
    //    3. Init a set to store all visited node
    //    4. Add initial vertex to the priority queue
    //    5. While queue is not empty: Poll a vertex (mark it
    //    visited) and check the total distance to each neighbour
    //    (current distance + distance so far), update shortest
    //    and previous arrays if smaller. If destination was
    //    unvisited, adds it to the queue

    /**
     * Function to find the shortest distance of all the vertices
     * from the source vertex S.
     *
     * @param V   number of vertices
     * @param adj adjacency list (adj[i] contains a list of lists
     *            containing two integers (v,w) where v is the end
     *            vertex of edge and w is edge weight)
     * @param S   source vertex
     * @return a list of integers denoting shortest distance between each node and Source vertex S
     */
    public static int[] dijkstra(int V,
                                 ArrayList<ArrayList<ArrayList<Integer>>> adj, int S) {

        boolean[] visited = new boolean[V];

        //Init the shortest distance to MAX except for the initial
        //node
        int[] distances = new int[V];
        for (int i = 0; i < V; i++) {
            if (i != S) {
                distances[i] = Integer.MAX_VALUE;
            }
        }

        //a PQ to keep track of vertices and their tentative distances
        //Pair: first = weights, second = vertex
        PriorityQueue<Pair> pq =
                new PriorityQueue<>((a, b) -> a.first - b.first);
        pq.offer(new Pair(0,S));

        while (!pq.isEmpty()) {
            //Poll a vertex (mark it visited)
            int u = pq.peek().second;
            int uDist = pq.peek().first;

            pq.poll();
            visited[u] = true;

            for (ArrayList<Integer> e : adj.get(u)) {
                int v = e.get(0);
                int edgeWeight = e.get(1);

                //check the total distance to each neighbour,
                //update if smaller
                if (!visited[v] && distances[u] + edgeWeight < distances[v]) {
                    distances[v] = distances[u] + edgeWeight;
                    pq.offer(new Pair(distances[v], v));
                }
            }
        }
        return distances;
    }

    public static class Pair {
        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
}
