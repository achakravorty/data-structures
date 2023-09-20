In this assignment, you will implement an algorithm to determine the reachability within a graph using the breadth-first search.

Your input is two vertices, a and b. You must determine if the vertex b is reachable from the vertex a. All vertices in a graph are of class Vertex, and they have the following methods:

```
class Vertex{

  // The constructor of the vertex.
  public Vertex(int id);

  // Returns the id of the vertex.
  public int getId();

  // Adds a new neighbour to the vertex.
  public void addNeighbour(Vertex v);

  // Returns all neighbours of the vertex.
  public Collection<Vertex> getNeighbours();

  // Returns a string representation of the vertex.  
  public String toString();

  // The equals method of the vertex.
  public boolean equals(Object o);

}
```

For the full implementation, look into the check the Library tab.

Note: The graph is undirected. However, it is not guaranteed that it is acyclic.

Example: Consider the graph underneath. This graph contains two disjoint components. Any two vertices in { 0, 1, 2, 3 } are reachable from any of the other in this set, the same applies to { 4, 5, 6 }. For example, 0 reaches 2 and 5 reaches 6. However, 3 does not reach 4, as there is no path between them.

```
0 - 1 - 2     4 - 5
    |          \ /
    3           6
```

```
//SOLUTION//
import java.util.*;

class Solution {

    /**
     * Checks if vertex b is reachable from vertex a.
     *
     * @param a
     *     Vertex to start from.
     * @param b
     *     Vertex to reach.
     * @return true if vertex b is reachable.
     */
    public static boolean solve(Vertex a, Vertex b) {
        // TODO
    }
}
```

```
//LIBRARY
import java.util.*;

class Vertex {

    private int id;

    private Set<Vertex> neighbours;

    public Vertex(int id) {
        this.id = id;
        neighbours = new HashSet<>();
    }

    public int getId() {
        return id;
    }

    public void addNeighbour(Vertex v) {
        neighbours.add(v);
    }

    @Override
    public String toString() {
        return "<vertex: " + id + ">";
    }

    public Collection<Vertex> getNeighbours() {
        return new ArrayList<>(this.neighbours);
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof Vertex && ((Vertex) o).getId() == this.getId();
    }
}

class Graph {

    private Map<Integer, Vertex> vertices = new HashMap<>();

    /**
     * Creates a new graph with n vertices.
     *
     * @param n
     *     Amount of vertices in the graph.
     */
    public Graph(int n) {
        for (int i = 0; i < n; i++) vertices.put(i, new Vertex(i));
    }

    /**
     * Returns the vertex with the given ID.
     *
     * @param id
     *     The ID for the vertex to get.
     * @return The vertex with the given ID.
     * @throws IllegalArgumentException
     *     if no vertex with the given ID is in the graph.
     */
    public Vertex getVertex(int id) throws IllegalArgumentException {
        if (!vertices.containsKey(id)) throw new IllegalArgumentException("Vertex not in graph");
        return vertices.get(id);
    }

    public Collection<Vertex> getAllVertices() {
        return new ArrayList<>(this.vertices.values());
    }

    /**
     * Adds an edge between vertex u and v with the given weight.
     *
     * @param u
     *     First vertex.
     * @param v
     *     Second vertex.
     */
    public void addEdge(Vertex u, Vertex v) {
        u.addNeighbour(v);
        v.addNeighbour(u);
    }

    /**
     * Adds an edge between the vertices with IDs u and v with the given weight.
     *
     * @param u
     *     ID of the first vertex.
     * @param v
     *     ID of the second vertex.
     * @throws IllegalArgumentException
     *     if no vertex with the given ID is in the graph.
     */
    public void addEdge(int u, int v) throws IllegalArgumentException {
        addEdge(getVertex(u), getVertex(v));
    }
}

```