package Graph.weblab;

import Graph.weblab.ShortestPathDijkstra.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


class ShortestPathDijkstraTest {

    /**
     * Tests the following graph with all edges having weight 1
     * 1 - 0 - 2 - 3
     */
    @Test
    public void testUnweightedLine() {
        Graph g = new Graph(4);
        g.addEdge(0, 1, 1);
        g.addEdge(0, 2, 1);
        g.addEdge(2, 3, 1);
        // Path from 1 to 3 is
        List<Vertex> path = new ArrayList<>();
        path.add(g.getVertex(1));
        path.add(g.getVertex(0));
        path.add(g.getVertex(2));
        path.add(g.getVertex(3));
        assertEquals(path, ShortestPathDijkstra.shortestPath(g,
                g.getVertex(1),
                g.getVertex(3)));
    }

    /**
     * Tests the following graph with all edges having weight 1
     * 1 - 0 - 3 - 5
     *    /      /
     * 2 ------ 4
     */
    @Test
    public void testUnweighted() {
        Graph g = new Graph(6);
        g.addEdge(0, 1, 1);
        g.addEdge(0, 2, 1);
        g.addEdge(2, 4, 1);
        g.addEdge(0, 3, 1);
        g.addEdge(3, 5, 1);
        g.addEdge(4, 5, 1);
        // Path from 0 to 4 is
        List<Vertex> path = new ArrayList<>();
        path.add(g.getVertex(0));
        path.add(g.getVertex(2));
        path.add(g.getVertex(4));
        assertEquals(path, ShortestPathDijkstra.shortestPath(g, g.getVertex(0), g.getVertex(4)));
        // Path from 1 to 2
        path = new ArrayList<>();
        path.add(g.getVertex(1));
        path.add(g.getVertex(0));
        path.add(g.getVertex(2));
        assertEquals(path, ShortestPathDijkstra.shortestPath(g, g.getVertex(1), g.getVertex(2)));
        // Path from 3 to 4
        path = new ArrayList<>();
        path.add(g.getVertex(3));
        path.add(g.getVertex(5));
        path.add(g.getVertex(4));
        assertEquals(path, ShortestPathDijkstra.shortestPath(g, g.getVertex(3), g.getVertex(4)));
        // Path from 3 to 1
        path = new ArrayList<>();
        path.add(g.getVertex(3));
        path.add(g.getVertex(0));
        path.add(g.getVertex(1));
        assertEquals(path, ShortestPathDijkstra.shortestPath(g, g.getVertex(3), g.getVertex(1)));
    }

}