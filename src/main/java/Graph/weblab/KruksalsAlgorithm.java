package Graph.weblab;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class KruksalsAlgorithm {

    /**
     * Builds a Minimum Spanning Tree (MST) using
     * Kruskal's Algorithm (as learned in class).
     * Nodes are numbered from 0 to n - 1.
     *
     * @param n     the amount of nodes in the graph
     * @param edges the edges that comprise the graph
     * @return the list of edges that should be included in the MST
     */
    public static List<Edge> buildMST(int n, List<Edge> edges) {

        List<Edge> tree = new ArrayList<>();

        if (n == 0) {
            return tree;
        }

        //create pq with edges, sorting increasingly on their cost
        PriorityQueue<Edge> pq = new PriorityQueue<>(edges.size(), Edge::compareTo);
        pq.addAll(edges);

//        while(!pq.isEmpty()) {
//            System.out.println(pq.remove().toString());
//        }
//        System.out.println(edges.toString());
//        System.out.println(pq.toString());

        //Initially, each vertex forms a single cluster
        UnionFind clusters = new UnionFind(n);

        //Repeat until tree size == n (we have one single cluster)
        while (tree.size() < n - 1) {
            //Pick an edge (u,v) with the smallest weight/cost
            Edge e = pq.remove();

            int u_id = clusters.find(e.getFrom());
            int v_id = clusters.find(e.getTo());

            //If the clusters of u and v are different, merge both
            //and add edge to MST
            if (clusters.union(u_id, v_id)) {
                tree.add(e);
            }
        }

        return tree;
    }

    static class Edge implements Comparable<Edge> {

        private int from;

        private int to;

        private int cost;

        public Edge(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }

        public int getFrom() {
            return from;
        }

        public int getTo() {
            return to;
        }

        public int getCost() {
            return cost;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.cost, o.cost);
        }

        @Override
        public String toString() {
            return "Edge{" + "from=" + from + ", to=" + to + ", cost=" + cost + '}';
        }
    }

    static class UnionFind {

        private int[] parent;

        private int[] rank;

        // Union Find structure implemented with two arrays for Union by Rank
        public UnionFind(int size) {
            parent = new int[size];
            rank = new int[size];
            for (int i = 0; i < size; i++) parent[i] = i;
        }

        /**
         * Merge two clusters, if they are not already part of the same cluster.
         *
         * @param i a node in the first cluster
         * @param j a node in the second cluster
         * @return true iff i and j had different clusters.
         */
        boolean union(int i, int j) {
            int parent1 = find(i);
            int parent2 = find(j);
            if (parent2 == parent1) return false;
            if (rank[parent1] > rank[parent2]) {
                parent[parent2] = parent1;
            } else if (rank[parent2] > rank[parent1]) {
                parent[parent1] = parent2;
            } else {
                parent[parent2] = parent1;
                rank[parent1]++;
            }
            return true;
        }

        /**
         * This function find the cluster that node i belongs to.
         *
         * @param i index of a node
         * @return the root of the subtree containg i.
         */
        int find(int i) {
            int parent = this.parent[i];
            if (i == parent) {
                return i;
            }
            return this.parent[i] = find(parent);
        }

        // Return the rank of the trees
        public int[] getRank() {
            return rank;
        }

        // Return the parent of the trees
        public int[] getParent() {
            return parent;
        }
    }

}
