public class Q1 {
    public static void main(String[] args) {
        In in = new In("mediumEWG.txt");
        EdgeWeightedGraph G = new EdgeWeightedGraph(in);
        Cycle C = new Cycle(G);
        if(C.hasCycle())
            System.out.println("This graph has cycle.");
        else
            System.out.println("This graph does not have any cycle.");
    }
}
