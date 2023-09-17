package Graph;

import java.util.ArrayList;

public class SumOfDependenciesInAGraph {

    //GFG//
    //Given a directed graph with V nodes and E edges. If there is an
    //edge from u to v then u depends on v. Find out the sum of
    //dependencies for every node. Duplicate edges should be counted
    //as separate edges.
    //https://practice.geeksforgeeks.org/problems/sum-of-dependencies-in-a-graph5311/1

    //Expected Time Complexity:O(V)
    //Expected Auxillary Space:O(1)

    /**
     *
     * @param adj adjacency list of graph
     * @param V no. of nodes
     * @return he total sum of dependencies of all nodes
     */
    public int sumOfDependencies(ArrayList<ArrayList<Integer>> adj, int V) {

        //IDEA - for ever vertex check how many edges it has
        //add the no. of edges of the vertex to the total sum
        int sum = 0;

        for (ArrayList<Integer> vertex : adj) {
            sum+= vertex.size();
        }

        return sum;
    }
}
