package Graph.weblab;

import java.util.*;

public class CyclesInDirectedGraphDFS {

    /**
     * Detects cycles in a connected component.
     *
     * @param s        starting vertex in our connected component.
     * @param vertices the vertex that belong to our graph.
     * @return true iff there is a cycle in the connected component the source belongs to.
     */
    public static boolean detectCycle(Vertex s, List<Vertex> vertices) {

        //WITH RECURSION//

        if (s == null) {
            return false;
        }

        // You'll perform a DFS starting from the given node and
        // keep track of the visited nodes and nodes in the current
        // recursion stack.

        HashSet<Vertex> visited = new HashSet<>(); //nodes visited
        HashSet<Vertex> recStack = new HashSet<>(); //nodes in current recursion stack

        return detectCycleUtil(s, visited, recStack);
    }

    public static boolean detectCycleUtil(Vertex s, HashSet<Vertex> visited, HashSet<Vertex> recStack) {
        if (recStack.contains(s)) {
            return true;
        }
        if (visited.contains(s)) {
            return false;
        }

        visited.add(s);
        recStack.add(s);

        for (Vertex neighbour : s.getOutgoingEdges()) {
            if (detectCycleUtil(neighbour, visited, recStack)) {
                return true;
            }
        }

        recStack.remove(s); //back track

        return false;
    }

    /*
    //WITHOUT RECURSION//
    public static boolean detectCycle(Vertex s, List<Vertex> vertices) {

        if (s == null) {
            return false;
        }

        // You'll perform a DFS starting from the given node and
        // keep track of the visited nodes and nodes in the current
        // recursion stack.

        HashSet<Vertex> visited = new HashSet<>(); //nodes visited
        HashSet<Vertex> inStack = new HashSet<>(); //nodes in current recursion track
        Stack<Vertex> stack = new Stack<>();

        stack.push(s);

        // The algorithm iterates until the stack is empty,
        // processing nodes and their neighbors. If it encounters a
        // node that is already in the stack, it means there is a
        // back edge and a cycle exists.
        while (!stack.isEmpty()) {
            Vertex p = stack.pop();
            visited.add(p);
            inStack.add(p);

            for (Vertex neighbour : p.getOutgoingEdges()) {
                if (!visited.contains(neighbour)) {
                    stack.push(neighbour);
                } else if (inStack.contains(neighbour)) {
                    return true;
                }
            }
        }
        return false;
    }
     */


    class Vertex {

        List<Vertex> outgoingEdges;

        int id;

        public Vertex(int id) {
            this.outgoingEdges = new ArrayList<>();
            this.id = id;
        }

        public List<Vertex> getOutgoingEdges() {
            return outgoingEdges;
        }

        public int getId() {
            return id;
        }

        public String toString() {
            return Integer.toString(id);
        }

        @Override
        public int hashCode() {
            return id;
        }
    }

}
