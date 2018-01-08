package Graph;
import java.util.*;
public class Topological {
    private int V;
    private LinkedList<Integer> adj[];
    Topological(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    };

    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    void topologicalSortUtil(int current, Stack stack, boolean[] visited) {
        visited[current] = true;
        for (int i = 0; i < adj[current].size(); i++) {
            if (!visited[adj[current].get(i)]) {
                topologicalSortUtil(adj[current].get(i), stack, visited);
            }
        }

        stack.push(current);
    }
    void topologicalSort() {
        Stack stack = new Stack();
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            visited[i] = false;
        }

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                topologicalSortUtil(i, stack, visited);
            }
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }

}
