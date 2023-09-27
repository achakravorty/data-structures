package Graph.weblab;

import java.util.*;

public class ConnetcedComponents {

    /**
     *
     * @param g given graph
     * @return the number of connected components in an undirected graph g
     */
    public static int numberOfConnectedComponents(Graph g) {
        List<Vertex> unexplored = (List<Vertex>) g.getAllVertices();

        int num = 0;

        while (unexplored.iterator().hasNext()) {
            Vertex v = unexplored.iterator().next();
            GraphIterator iterator = new GraphIterator(g, v);
            num++;
            while (iterator.hasNext()) {
                Vertex n = iterator.next();
//                if (unexplored.contains(n)) {
                    unexplored.remove(n);
//                }
            }

        }
        return num;
    }

    /**
     * Implements a Depth first traversal of the Graph, starting at
     * constructor vertex v. It should return nodes at most once.
     * If there is a choice between multiple next nodes, always
     * pick the lowest id node.
     */
    static public class GraphIterator implements Iterator<Vertex> {

        private Graph g;

        private Vertex v;

        private Stack<Vertex> stack;  //to keep track of nodes

        private Set<Vertex> colored; //visited nodes while traversing

        private int graphSize;

        public GraphIterator(Graph g, Vertex v) {

//            if (g == null || v == null) {
//                throw new IllegalArgumentException("Graph and starting vertex must not be null");
//            }

            this.g = g;
            this.v = v;
            this.stack = new Stack<>();
            this.colored = new TreeSet<>();
            this.graphSize = g.getAllVertices().size();

            stack.push(v);
            colored.add(v);
        }

        @Override
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        @Override
        public Vertex next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            Vertex current = stack.pop();

            //why is it wrong to add this??? it gives the same solution
            // if (!colored.contains(current)) {
            //     colored.add(current);
            // }

            //you need to push into the stack from the end to get
            //DFS from left to right
            List<Vertex> neighbours = g.getNeighbours(current);
            for (int i = neighbours.size() - 1; i >= 0; i--) {
                Vertex n = neighbours.get(i);
                if (!colored.contains(n)) {
                    stack.push(n);
                    colored.add(n);
                }
            }
            return current;
        }
    }

    interface Vertex {
        int getId();
    }

    interface Graph {
        // Gets neighbours of v in this Graph
        List<Vertex> getNeighbours(Vertex v);
        // Gets all vertices of this Graph
        Collection<Vertex> getAllVertices();
    }
}




