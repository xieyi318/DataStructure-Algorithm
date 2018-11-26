public class Q6 {
    public static void main(String[] args) {
        In in = new In("4a.txt");
        EdgeWeightedDigraph G = new EdgeWeightedDigraph(in);

        int s=1;
        DijkstraSP sp = new DijkstraSP(G,s);

        for (int t = 0; t < G.V(); t++) {
            if (sp.hasPathTo(t)) {
                StdOut.printf("%d to %d (%.2f)  ", s, t, sp.distTo(t));
                for (DirectedEdge e : sp.pathTo(t)) {
                    StdOut.print(e + "   ");
                }
                StdOut.println();
            }
            else {
                StdOut.printf("%d to %d         no path\n", s, t);
            }
        }


    }
}
