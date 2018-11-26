public class Q5 {
    public static void main(String[] args) {
        In in = new In("NYC.txt");
        EdgeWeightedGraph G = new EdgeWeightedGraph(in);
        DepthFirstSearch dfs = new DepthFirstSearch(G, 1);
        BreadthFirstSearch bfs =new BreadthFirstSearch(G, 1);
        System.out.println("DFS: "+dfs.pathTo(10));
        System.out.println("BFS: "+bfs.pathTo(10));
    }
}
