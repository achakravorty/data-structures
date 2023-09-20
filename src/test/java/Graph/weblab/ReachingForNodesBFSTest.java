package Graph.weblab;

import Graph.weblab.ReachingForNodesBFS.*;
import java.util.concurrent.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

class ReachingForNodesBFSTest {

    public boolean solve(Graph g, int a, int b) {
        return ReachingForNodesBFS.solve(g.getVertex(a), g.getVertex(b));
    }

    /**
     * Tests the following graph
     * 0 - 1 - 2
     */
    @Test
    @Timeout(value = 200, unit = TimeUnit.MILLISECONDS)
    public void testLine() {
        Graph g = new Graph(4);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        // Path from 0 to 1 is reachable
        assertTrue(ReachingForNodesBFS.solve(g.getVertex(0), g.getVertex(1)));
        // Path from 1 to 2 is reachable
        assertTrue(ReachingForNodesBFS.solve(g.getVertex(1), g.getVertex(2)));
        // Path from 0 to 2 is reachable
        assertTrue(ReachingForNodesBFS.solve(g.getVertex(0), g.getVertex(2)));
        // Path from 2 to 0 is reachable
        assertTrue(ReachingForNodesBFS.solve(g.getVertex(2), g.getVertex(0)));
    }

    /**
     * Tests the following graph:
     * 0 - 1 - 3
     * |    \  |
     * |     \ |
     * 2  ---  4    (5)
     */
    @Test
    @Timeout(value = 450, unit = TimeUnit.MILLISECONDS)
    public void testWeighted() {
        Graph g = new Graph(6);
        g.addEdge(0, 1);
        g.addEdge(1, 3);
        g.addEdge(3, 4);
        g.addEdge(1, 4);
        g.addEdge(0, 2);
        g.addEdge(2, 4);
        // Path is 0-1-4
        assertTrue(ReachingForNodesBFS.solve(g.getVertex(0), g.getVertex(4)));
        // Path is 0-1-4-3
        assertTrue(ReachingForNodesBFS.solve(g.getVertex(0), g.getVertex(3)));
        // Path is 2-4
        assertTrue(ReachingForNodesBFS.solve(g.getVertex(2), g.getVertex(4)));
        // Path is 2-4-1-0
        assertTrue(ReachingForNodesBFS.solve(g.getVertex(2), g.getVertex(0)));
        // No path
        assertFalse(ReachingForNodesBFS.solve(g.getVertex(0), g.getVertex(5)));
        assertFalse(ReachingForNodesBFS.solve(g.getVertex(1), g.getVertex(5)));
        assertFalse(ReachingForNodesBFS.solve(g.getVertex(2), g.getVertex(5)));
        assertFalse(ReachingForNodesBFS.solve(g.getVertex(3), g.getVertex(5)));
        assertFalse(ReachingForNodesBFS.solve(g.getVertex(4), g.getVertex(5)));
    }
}