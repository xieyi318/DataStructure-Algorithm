public class Q2 {
    public static void main(String[] args) {
        In in = new In("mediumEWG.txt");
        EdgeWeightedGraph G = new EdgeWeightedGraph(in);

        long start1,end1,start2,end2;
        start1 = System.currentTimeMillis();

        LazyPrimMST prim = new LazyPrimMST(G);
        System.out.println("Prim's Algorithm total weights: " + prim.weight());

        end1 = System.currentTimeMillis();
        System.out.println("Prim's Run Time:" + (end1 - start1) + "(ms)");

        start2 = System.currentTimeMillis();

        KruskalMST krus = new KruskalMST(G);
        System.out.println("Kruskal's Algorithm total weights: " + krus.weight());
        end2 = System.currentTimeMillis();
        System.out.println("Kruskal's Run Time:" + (end2 - start2) + "(ms)");

    }
}
