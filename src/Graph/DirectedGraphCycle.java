package Graph;
import java.util.*;
//Dectecting cycle in a directed graph
public class DirectedGraphCycle {
    int vertex;
    ArrayList<Integer>[] adj;
    DirectedGraphCycle(int vertex) {
        this.vertex = vertex;
        adj = new ArrayList[vertex];
        for (int i = 0; i < vertex; i++) {
            adj[i] = new ArrayList<>();
        }
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    boolean isCyclicUtil(int vertex, boolean[] visited, boolean[] resStack) {
        if (visited[vertex] == false) {
            visited[vertex] = true;
            resStack[vertex] = true;
        }
        //recursion for all the vertices adjacent to this vertex
        for (Integer neighbour : adj[vertex]) {
            if (!visited[neighbour] && isCyclicUtil(neighbour,visited, resStack)) {
                return true;
            }
            if (resStack[neighbour]) {
                return true;
            }
        }
        //backtrack
        resStack[vertex] = false;
        return false;
    }

    boolean isCyclic() {
        boolean[] visited = new boolean[vertex];
        boolean[] resStack = new boolean[vertex];

        for (int i = 0; i < vertex; i++) {
            if (isCyclicUtil(i,visited, resStack)) {
                return true;
            }
        }
        return false;
    }

}
