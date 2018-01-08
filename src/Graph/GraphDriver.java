package Graph;

public class GraphDriver {

    public static void main (String[] args) {
        /*
        UndirectedGraph ug = new UndirectedGraph(5);
        ug.addEdge(1,0);
        ug.addEdge(0,2);
        ug.addEdge(2,0);
        ug.addEdge(0,3);
        ug.addEdge(3,4);
        if (ug.isCylic()) {
            System.out.println("Contains Circle");
        } else {
            System.out.println("No Circle");
        }

        UndirectedGraph ug2 = new UndirectedGraph(3);
        ug2.addEdge(0,1);
        ug2.addEdge(1,2);
        if (ug2.isCylic()) {
            System.out.println("Contains Circle");
        } else {
            System.out.println("No Circle");
        }

        DirectedGraphCycle lg = new DirectedGraphCycle(4);
        lg.addEdge(0,1);
        lg.addEdge(0,2);
        lg.addEdge(1,2);
        lg.addEdge(2,0);
        lg.addEdge(2,3);
        lg.addEdge(3,3);

        if (lg.isCyclic()) {
            System.out.println("Contains cycle");
        } else {
            System.out.println("Does not contain cycle");
        }

        */
        Topological g = new Topological(6);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);

        System.out.println("Following is a Topological " +
                "sort of the given graph");
        g.topologicalSort();
    }
}
