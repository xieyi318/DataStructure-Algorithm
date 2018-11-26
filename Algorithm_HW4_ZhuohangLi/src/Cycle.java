public class Cycle {
    private boolean[] marked;
    private boolean hasCycle;

    public Cycle(EdgeWeightedGraph G){
        marked = new boolean[G.V()];
        for (int s=0; s<G.V();s++)
            if (!marked[s])
                dfs(G, s, s);
    }

    public void dfs (EdgeWeightedGraph G, int v, int u){
        marked[v]=true;
        for (Edge e:G.adj(v)) {
            if (!marked[e.other(v)])
                 dfs(G,e.other(v),v);
            else if(e.other(v)!=u) hasCycle=true;

        }
    }

    public boolean hasCycle(){
        return hasCycle;
    }
}