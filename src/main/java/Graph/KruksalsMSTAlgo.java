package Graph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class KruksalsMSTAlgo {

    //GFG//
    //How to find MST using Kruskal’s algorithm?
    //
    //1. Sort all the edges in non-decreasing order of their weight.
    //2. Pick the smallest edge. Check if it forms a cycle with the
    //   spanning tree formed so far. If the cycle is not formed,
    //   include this edge. Else, discard it.
    //3. Repeat step#2 until there are (V-1) edges in the spanning
    //   tree.

    //Step 2 uses the Union-Find algorithm to detect cycles.


    // Function to find the MST
    private static Edge[] kruskals(int V, List<Edge> edges) {

        int j = 0;
        int noOfEdges = 0;

        // Allocate memory for creating V subsets
        Subset[] subsets = new Subset[V];

        // Allocate memory for results
        Edge[] results = new Edge[V];

        // Create V subsets with single elements
        for (int i =0; i < V; i++) {
            subsets[i] = new Subset(i, 0);
        }

        // Sort the edges in non-decreasing order
        edges.sort(new Comparator<>() {
            @Override public int compare(Edge o1, Edge o2)
            {
                return o1.weight - o2.weight;
            }
        });

        while (noOfEdges < V-1) {

            //Pick the smallest edge
            Edge e = edges.get(j);
            int x = findRoot(subsets, e.src);
            int y = findRoot(subsets, e.dest);

            if (x!=y) {
                results[noOfEdges] = e;
                union(subsets, x, y);
                noOfEdges++;
            }

            j++;

        }

        return results;
    }

    // Starting point of program execution
    public static void main(String[] args)
    {
        int V = 4;
        List<Edge> graphEdges = new ArrayList<>(
                List.of(new Edge(0, 1, 10), new Edge(0, 2, 6),
                        new Edge(0, 3, 5), new Edge(1, 3, 15),
                        new Edge(2, 3, 4)));


        Edge[] results = kruskals(V, graphEdges);
        resultString(results);
    }

    //LIBARY//

    // Defines edge structure
    static class Edge {
        int src, dest, weight;

        public Edge(int src, int dest, int weight)
        {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }

    // Defines subset element structure
    static class Subset {
        int parent, rank;

        public Subset(int parent, int rank)
        {
            this.parent = parent;
            this.rank = rank;
        }
    }

    // Function to unite two disjoint sets
    private static void union(Subset[] subsets, int x,
                              int y)
    {
        int rootX = findRoot(subsets, x);
        int rootY = findRoot(subsets, y);

        if (subsets[rootY].rank < subsets[rootX].rank) {
            subsets[rootY].parent = rootX;
        }
        else if (subsets[rootX].rank
                < subsets[rootY].rank) {
            subsets[rootX].parent = rootY;
        }
        else {
            subsets[rootY].parent = rootX;
            subsets[rootX].rank++;
        }
    }

    // Function to find parent of a set
    private static int findRoot(Subset[] subsets, int i)
    {
        if (subsets[i].parent == i)
            return subsets[i].parent;

        subsets[i].parent
                = findRoot(subsets, subsets[i].parent);
        return subsets[i].parent;
    }

    public static void resultString(Edge[] results) {
        // Print the contents of result[] to display the
        // built MST
        System.out.println(
                "Following are the edges of the constructed MST:");
        int minCost = 0;
        for (int i = 0; i < results.length - 1; i++) {
            System.out.println(results[i].src + " -- "
                    + results[i].dest + " == "
                    + results[i].weight);
            minCost += results[i].weight;
        }
        System.out.println("Total cost of MST: " + minCost);
    }
}
