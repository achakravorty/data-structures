package Graph.weblab;

import java.util.*;

public class DepthFirstTraversalGraph {

    /**
     * Implements a Depth first traversal of the Graph, starting at
     * constructor vertex v. It should return nodes at most once.
     * If there is a choice between multiple next nodes, always
     * pick the lowest id node.
     */
    public class GraphIterator implements Iterator<Vertex> {

        private Graph g;

        private Vertex v;

        private Stack<Vertex> stack;  //to keep track of nodes

        private Set<Vertex> colored; //visited nodes while traversing

        private int graphSize;

        public GraphIterator(Graph g, Vertex v) {

            if (g == null || v == null) {
                throw new IllegalArgumentException("Graph and starting vertex must not be null");
            }

            this.g = g;
            this.v = v;
            this.stack = new Stack<>();
            this.colored = new TreeSet<>();
            this.graphSize = 0;

            stack.push(v);
//            colored.add(v);
        }

        @Override
        public boolean hasNext() { return !stack.isEmpty(); }

        @Override
        public Vertex next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            Vertex current = stack.pop();

            if (!colored.contains(current)) {
                colored.add(current);
            }

            //you need to push into the stack from the end to get
            //DFS from left to right
            List<Vertex> neighbours = g.getNeighbours(current);
            for (int i = neighbours.size() - 1; i >= 0; i--) {
                Vertex n = neighbours.get(i);
                if (!colored.contains(n)) {
                    stack.push(n);
//                    colored.add(n);
                }
            }

//            for (Vertex n : g.getNeighbours(v)) {
//                if (!colored.contains(n)) {
//                    stack. push(n);
//                }
//            }
            graphSize++;
            return current;
        }
    }

    /*
    public static void main(String[] args) {
        GraphImpl g = new GraphImpl();

//        // Add vertices and edges to the graph
//        Vertex v = new VertexImpl(0);
//        Vertex w = new VertexImpl(1);
//        Vertex x = new VertexImpl(2);
//        Vertex y = new VertexImpl(3);
//        Vertex z = new VertexImpl(4);
//        Vertex a = new VertexImpl(5);
//        g.addVertex(v);
//        g.addVertex(w);
//        g.addVertex(x);
//        g.addVertex(y);
//        g.addVertex(z);
//        g.addVertex(a);
//        g.addEdge(v,w);
//        g.addEdge(w,x);
//        g.addEdge(w,a);
//        g.addEdge(x,y);
//        g.addEdge(x,z);

        Vertex startVertex = v; // Specify your starting vertex
        GraphIterator iterator = new GraphIterator(g, startVertex);

        while (iterator.hasNext()) {
            Vertex vertex = iterator.next();
            System.out.println(vertex);
        }
    }

     */

    interface Vertex extends Comparable<Vertex> {

        int getId();
    }

    /**
     * Interface for a generic graph. You may assume that our implementation is an
     * undirected graph.
     */
    interface Graph {

        /**
         * Returns the neighbours in a sorted collection by id
         *
         * @param v
         *     node to get the neighbours of.
         * @return sorted collection of neighbours.
         */
        List<Vertex> getNeighbours(Vertex v);

        /**
         * @return an unsorted collection of all vertices in the graph.
         */
        Collection<Vertex> getAllVertices();
    }

    class VertexImpl implements Vertex {

        private int id;

        private Set<Vertex> neighbours;

        public VertexImpl(int id) {
            this.id = id;
            neighbours = new HashSet<>();
        }

        public void addNeighbour(Vertex v) {
            neighbours.add(v);
        }

        @Override
        public String toString() {
            return "<Vertex: " + getId() + ">";
        }

        @Override
        public int getId() {
            return id;
        }

        public Collection<Vertex> getNeighbours() {
            return new ArrayList<>(this.neighbours);
        }

        @Override
        public int compareTo(Vertex o) {
            return this.getId() - o.getId();
        }

        @Override
        public int hashCode() {
            return this.getId();
        }

        @Override
        public boolean equals(Object o) {
            return (o instanceof Vertex) && (((Vertex) o).getId() == this.getId());
        }
    }

    class GraphImpl implements Graph {

        private Map<Integer, Vertex> vertices;

        public GraphImpl() {
            this.vertices = new HashMap<>();
        }

        public void addVertex(Vertex v) {
            this.vertices.put(v.getId(), v);
        }

        @Override
        public Collection<Vertex> getAllVertices() {
            return this.vertices.values();
        }

        @Override
        public List<Vertex> getNeighbours(Vertex v) {
            List<Vertex> neigh = new ArrayList<>(((VertexImpl) v).getNeighbours());
            Collections.sort(neigh);
            return neigh;
        }

        public void addEdge(Vertex v, Vertex w) {
            VertexImpl realV = (VertexImpl) v;
            VertexImpl realW = (VertexImpl) w;
            realV.addNeighbour(w);
            realW.addNeighbour(v);
        }
    }


}
