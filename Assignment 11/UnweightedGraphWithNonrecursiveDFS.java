// Name: Emmanuel Durojaiye
// Class: CS 3305/ W04
// Term: Fall 2024
// Instructor: Carla McManus
// Assignment: 11-Part-1-DFS

import java.util.*;

public class UnweightedGraphWithNonrecursiveDFS<V> extends UnweightedGraph<V> {

    /** Override the dfs method to implement DFS without recursion */
    @Override
    public Tree dfs(int v) {
        List<Integer> searchOrder = new ArrayList<>();
        int[] parent = new int[vertices.size()];
        // Initialise parent[i] to -1
        Arrays.fill(parent, -1);

        // Create a stack for DFS
        Stack<Integer> stack = new Stack<>();
        // Push the start vertex onto the stack
        stack.push(v);

        // Create a visited array
        boolean[] isVisited = new boolean[vertices.size()];

        // Start DFS using the stack
        while (!stack.isEmpty()) {
            // Pop the top vertex from the stack
            int u = stack.pop();

            if (!isVisited[u]) {
                // Mark u as visited
                isVisited[u] = true;
                // Add u to the search order
                searchOrder.add(u);

                // Push unvisited neighbours onto the stack
                for (Edge e : neighbors.get(u)) {
                    if (!isVisited[e.v]) {
                        // Set parent for the neighbor
                        parent[e.v] = u;
                        // Push the neighbour onto the stack
                        stack.push(e.v);
                    }
                }
            }
        }

        // Return a DFS tree
        return new Tree(v, parent, searchOrder);
    }
}

