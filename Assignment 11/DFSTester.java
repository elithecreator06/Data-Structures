public class DFSTester {
    public static void main(String[] args) {
        // Create a graph with vertices and edges
        Integer[] vertices = {0, 1, 2, 3, 4};
        int[][] edges = {
                {0, 1}, {0, 2}, {1, 3}, {1, 4}, {2, 4}
        };

        // Create the graph using UnweightedGraphWithNonrecursiveDFS
        UnweightedGraphWithNonrecursiveDFS<Integer> graph = new UnweightedGraphWithNonrecursiveDFS<>();
        for (Integer vertex : vertices) {
            graph.addVertex(vertex);
        }
        for (int[] edge : edges) {
            graph.addEdge(edge[0], edge[1]);
        }

        // Perform DFS starting from vertex 0
        AbstractGraph<Integer>.Tree dfsTree = graph.dfs(0);

        // Print the DFS search order
        System.out.println("DFS Search Order: " + dfsTree.getSearchOrder());

        // Print the paths to each vertex from the root (vertex 0)
        for (int i = 0; i < graph.getSize(); i++) {
            dfsTree.printPath(i);
            System.out.println();
        }
    }
}
