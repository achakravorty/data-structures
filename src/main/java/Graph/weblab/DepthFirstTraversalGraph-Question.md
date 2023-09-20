Implement a lazy iterator for a graph, which yields the nodes of an undirected graph in depth-first order. The iterator should return vertices at most once. The iterator does not necessarily iterate over all vertices in the graph, but only vertices that are connected to the starting vertex.

The following two interfaces are provided, which have full implementations in the library tab.

``` 
interface Vertex {
int getId();
}

interface Graph {
// Gets neighbours of v in this Graph
public List<Vertex> getNeighbours(Vertex v);
// Gets all vertices of this Graph
public Collection<Vertex> getAllVertices();
}
``` 

With this implementation, you cannot label nodes or edges. Instead, you need to maintain the colored nodes in a set colored. This set can be instantiated with a TreeSet, which stores the elements of a set in a height-balanced search tree. To add a node v to the set, you call colored.add(v). To check if a vertex is already contained in the set, you call colored.contains(v).

If there is a choice between multiple nodes, always pick the one with the lowest id.

```
//SOLUTION//
import java.util.*;

/**
 * Implements a Depth first traversal of the Graph, starting at contructor vertex v. It
 * should return nodes at most once. If there is a choice between multiple next nodes,
 * always pick the lowest id node.
 */
class GraphIterator implements Iterator<Vertex> {

    private Graph g;

        private Vertex v;

        private Stack<Vertex> stack;  

        private Set<Vertex> colored; 

        private int graphSize;

        public GraphIterator(Graph g, Vertex v) {
            //TODO
        }

        @Override
        public boolean hasNext() {
            //TODO
        }

        @Override
        public Vertex next() {
            //TODO
        }
}


```

```
//LIBRARY//
import java.util.*;

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

```