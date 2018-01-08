package Graph;
import java.util.*;
/*
    This class represents a directed graph using
    adjacency list representation

 */
public class DirectedGraph {
    private int v;
    //Array of lists for adjacency list representation
    private LinkedList<Integer>[] adj;
    DirectedGraph(int v) {
        this.v = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    void addEdge(int vertex, int edge) {
        adj[vertex].add(edge);
    }

    void DFSUtil(int v, boolean visited[]) {
        visited[v] = true;
        System.out.print(v + " ");

        //Recur for all vertices, adjacent to this vertex
        Iterator<Integer> iter = adj[v].listIterator();
        while (iter.hasNext()) {
            int next = iter.next();
            if (!visited[next]) {
                DFSUtil(next, visited);
            }
        }

    }

    void DFS(int start) {
        //mark all the verticies as not visited
        boolean[] visited = new boolean[this.v];
        DFSUtil(start, visited);
    }

    // prints BFS traversal from a given source s
    void BFS(int s)
    {
        // Mark all the vertices as not visited(By default
        // set as false)
        boolean visited[] = new boolean[this.v];

        // Create a queue for BFS
        LinkedList<Integer> queue = new LinkedList<Integer>();

        // Mark the current node as visited and enqueue it
        visited[s]=true;
        queue.add(s);

        while (queue.size() != 0)
        {
            // Dequeue a vertex from queue and print it
            s = queue.poll();
            System.out.print(s+" ");

            // Get all adjacent vertices of the dequeued vertex s
            // If a adjacent has not been visited, then mark it
            // visited and enqueue it
            Iterator<Integer> i = adj[s].listIterator();
            while (i.hasNext())
            {
                int n = i.next();
                if (!visited[n])
                {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }



    public static void main(String args[]) {
        DirectedGraph g = new DirectedGraph(4);
        g.addEdge(0,1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2,0);
        g.addEdge(2,3);
        g.addEdge(3,3);

        System.out.println("DFS starting at 2: ");
        g.DFS(2);
        System.out.println("\nBFS startign at 2");
        g.BFS(2);
    }
}
