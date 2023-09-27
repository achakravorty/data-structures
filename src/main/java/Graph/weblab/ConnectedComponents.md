Implement the method numberOfConnectedComponents(g) which returns the number of connected components in an undirected graph g.

The following two interfaces are provided, which have full implementations in the hidden library code.

```
interface Vertex {
  int getId();
}

interface Graph {
  // Gets neighbours of v in this Graph
  List<Vertex> getNeighbours(Vertex v);
  // Gets all vertices of this Graph
  Collection<Vertex> getAllVertices();
}
```

The library code also has a full implementation of a depth-first iterator. This iterator can be instantiated using new GraphIterator(Graph g, Vertex v). Furthermore, note that the iterator implements the Iterator<Vertex> interface, whose description can be found in the Java API documentation.

IMPORTANT: You are required to use the GraphIterator in your solution. In an exam setting, this would be checked manually.

Again, you cannot label nodes or edges. Instead, you need to maintain the unexplored nodes in a collection unexplored, which can be initialized with g.getAllVertices(). To remove an explored node v from unexplored, you call unexplored.remove(v). To get the next unexplored node, you call unexplored.iterator().next().

NOTE: Java does not allow you to modify a data structure while you are iterating it. Therefore, you cannot iterate over the elements from unexplored with a for loop, i.e. for (Vertex v: unexplored) will not work, since you need to be able to remove elements from unexplored during the loop.

```
//SOLUTION//

import java.util.*;

class Solution {

    public static int numberOfConnectedComponents(Graph g) {
        // TODO
    }
}
```
