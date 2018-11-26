public class DepthFirstSearch {
    private boolean[] marked;
    private int[] edgeTo;
    private final int s;

    public DepthFirstSearch(EdgeWeightedGraph G, int s) {
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        this.s = s;
        dfs(G, s);
    }

    // depth first search from v
    private void dfs(EdgeWeightedGraph G, int s) {
        Stack<Integer> stack = new Stack<Integer>();
        marked[s] = true;
        stack.push(s);

        while (!stack.isEmpty()) {
            int v = stack.pop();
            for (Edge e : G.adj(v)) {
                int w = e.other(v);
                if (!marked[w]) {
                    edgeTo[w]=v;
                    marked[w] = true;
                    stack.push(w);
                }
            }
        }

//        while (!stack.isEmpty()) {
//            int v = stack.pop();
//            marked[v] = true;
//            for (Edge e : G.adj(v)) {
//                int w = e.other(v);
//                if (!marked[w]) {
//                    edgeTo[w] = v;
//                    stack.push(w);
//                }
//            }
//        }

    }

    public boolean hasPathTo(int v){
        return marked[v];
    }

    public Iterable<Integer> pathTo(int v){
        if(!hasPathTo(v)) return null;
        Stack<Integer> path= new Stack<Integer>();
        for (int x=v;x!=s;x=edgeTo[x])
            path.push(x);
        path.push(s);
        return path;
    }

}