import java.util.*;

// Graph class for implementing BFS and DFS
class Graph {
    private int vertices; // Number of vertices
    private LinkedList<Integer>[] adjacencyList; // Adjacency List

    // Constructor to initialize the graph
    public Graph(int vertices) {
        this.vertices = vertices;
        adjacencyList = new LinkedList[vertices];
        for (int i = 0; i < vertices; i++) {
            adjacencyList[i] = new LinkedList<>();
        }
    }

    // Add edge to the graph
    public void addEdge(int v, int w) {
        adjacencyList[v].add(w); // Add w to v's adjacency list
    }

    // BFS algorithm
    public void bfs(int startVertex) {
        boolean[] visited = new boolean[vertices]; // Track visited nodes
        LinkedList<Integer> queue = new LinkedList<>(); // Queue for BFS

        // Start with the startVertex
        visited[startVertex] = true;
        queue.add(startVertex);

        while (!queue.isEmpty()) {
            int vertex = queue.poll(); // Dequeue a vertex
            System.out.print(vertex + " "); // Print the vertex

            // Traverse all neighbors of the dequeued vertex
            for (int neighbor : adjacencyList[vertex]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true; // Mark neighbor as visited
                    queue.add(neighbor); // Enqueue the neighbor
                }
            }
        }
    }

    // DFS algorithm
    public void dfs(int startVertex) {
        boolean[] visited = new boolean[vertices]; // Track visited nodes
        dfsUtil(startVertex, visited); // Call the recursive helper
    }

    // Utility function for DFS
    private void dfsUtil(int vertex, boolean[] visited) {
        visited[vertex] = true; // Mark the vertex as visited
        System.out.print(vertex + " "); // Print the vertex

        // Traverse all neighbors of the vertex
        for (int neighbor : adjacencyList[vertex]) {
            if (!visited[neighbor]) {
                dfsUtil(neighbor, visited); // Recursive call for unvisited neighbors
            }
        }
    }

    // Main function to test the BFS and DFS algorithms
    public static void main(String[] args) {
        Graph graph = new Graph(6); // Create a graph with 6 vertices

        // Add edges to the graph
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 4);
        graph.addEdge(3, 5);
        graph.addEdge(4, 5);

        // Perform BFS
        System.out.println("Breadth-First Search (starting from vertex 0):");
        graph.bfs(0);

        // Perform DFS
        System.out.println("\nDepth-First Search (starting from vertex 0):");
        graph.dfs(0);
    }
}
