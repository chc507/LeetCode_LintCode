package Graph;
import java.util.*;

public class UndirectedGraph {
    int vertex;
    List<Integer>[] adj;

    UndirectedGraph(int vertex) {
        this.vertex = vertex;
        adj = new List[vertex];
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new ArrayList<Integer>();
        }
    }
    void addEdge(int v, int e) {
        adj[v].add(e);
        adj[e].add(v);
    }

    boolean isCylicHelper(int v, int parent, boolean[] visited ) {

        visited[v] = true;

        for (int neighbour : adj[v]) {
            if (visited[neighbour] && neighbour != parent) {
                return true;
            }

            if (!visited[neighbour] && isCylicHelper(neighbour, v, visited)) {
                return true;
            }
        }
        return false;
    }

    boolean isCylic() {
        boolean[] visited = new boolean[vertex];
        for (int i = 0; i < vertex; i++) {
            if (visited[i]) {
                continue;
            }
            if (isCylicHelper(i, -1, visited)) {
                return true;
            }
        }
        return false;
    }
}
