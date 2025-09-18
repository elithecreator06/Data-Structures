// Name: Emmanuel Durojaiye
// Class: CS 3305/Wo4
// Term: Fall 2024
// Instructor: Carla McManus
// Assignment: 12-Part-1-Prims

public class DurojaiyeA12Part1Prims {
    // Number of vertices in the graph
    private static final int nodes = 8;

    // Function to find the vertex with the minimum key value
    public int minKey(int[] key, boolean[] mstSet){
        int min = Integer.MAX_VALUE, minIndex = -1;

        for(int i = 0; i < nodes; i++){
            if(!mstSet[i] && key[i] < min){
                min = key[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

    // Function to print the constructed MST
    public void printMST(int[] parent, int[][] graph){
        System.out.println("Edge \tWeight");
        for(int i = 1; i < nodes; i++){
            System.out.println(parent[i] + " - " + i + "\t" + graph[i][parent[i]]);
        }
    }

    // Function that implements Prims algorithm for an adjacency matrix
    public void primMST(int[][] graph){
        // Array to store the constructed MST
        int[] parent = new int[nodes];
        // Key values to pick minimum weight edges
        int[] key = new int[nodes];
        // Track vertices included in the MST
        boolean[] mstSet = new boolean[nodes];

        // Initialize all keys as infinite
        for(int i = 0; i < nodes; i++){
            key[i] = Integer.MAX_VALUE;
            mstSet[i] = false;
        }

        // Always start from the first vertex
        key[0] = 0;
        parent[0] = -1;


        for(int count = 0; count < nodes - 1; count++){
            int u = minKey(key, mstSet);
            mstSet[u] = true;

            // Update key values and parent index of adjacent vertices
            for(int i = 0; i < nodes; i++){
                if(graph[u][i] != 0 && !mstSet[i] && graph[u][i] < key[i]){
                    parent[i] = u;
                    key[i] = graph[u][i];
                }
            }
        }
        printMST(parent, graph);
    }

    public static void main(String[] args) {
        DurojaiyeA12Part1Prims pa = new DurojaiyeA12Part1Prims();
        int[][] graph = {
                {0, 0, 4, 0, 0, 2, 0, 0}, // A
                {0, 0, 0, 0, 9, 0, 0, 3}, // B
                {4, 0, 0, 3, 0, 0, 0, 0}, // C
                {0, 0, 3, 0, 3, 0, 7, 0}, // D
                {0, 9, 0, 3, 0, 0, 2, 0}, // E
                {2, 0, 0, 0, 0, 0, 8, 0}, // F
                {0, 0, 0, 7, 2, 8, 0, 3}, // G
                {0, 3, 0, 0, 0, 0, 3, 0}  // H
        };
        pa.primMST(graph);
    }
}
