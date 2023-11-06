package Graph.weblab;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdjacencyMatrixAndAdjacencyMap {
    /**
     * Method that transforms a graph in an adjacency matrix data
     * structure to a graph in an adjacency map data structure.
     *
     * @param matrix adjacency map - 2D array of vertices and edges
     *               of a graph.
     * @return adjacency map structure of the graph.
     */
    public static List<Map<Integer, Integer>> toAdjacencyMap(int[][] matrix) {

        List<Map<Integer, Integer>> map = new ArrayList<>(); //list of maps

        //traverse matrix
        for (int i = 0; i < matrix.length; i++) {
            Map<Integer, Integer> vertex = new HashMap<>();
            for (int j = 0; j < matrix[i].length; j++) {
                //for each cell in the matrix, we add to the vertex map
                if (matrix[i][j] != 0) {
                    vertex.put(j, matrix[i][j]);
                }
            }
            map.add(vertex); //add new vertex to adjacency map (list)
        }
        return map;
    }

    public static int[][] toAdjacencyMatrix(List<Map<Integer, Integer>> map) {
        int[][] matrix = new int[map.size()][map.size()];

        for (int i = 0; i < map.size(); i++) {
            Map<Integer, Integer> vertex = map.get(i);

            //iterate through each map
            // Iterating through key-value pairs
            for (Map.Entry<Integer, Integer> entry : vertex.entrySet()) {
                int key = entry.getKey();
                int edgeWeight = entry.getValue();

                matrix[i][key] = edgeWeight;
            }
        }
        return matrix;
    }
}
