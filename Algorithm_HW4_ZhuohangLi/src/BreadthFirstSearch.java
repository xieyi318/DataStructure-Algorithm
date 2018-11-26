public class BreadthFirstSearch {
    private boolean[] marked;
    private int[] edgeTo;
    private final int s;

    public BreadthFirstSearch(EdgeWeightedGraph G, int s){
        marked=new boolean[G.V()];
        edgeTo=new int[G.V()];
        this.s=s;
        bfs(G,s);
    }

    private void bfs(EdgeWeightedGraph G, int s){
        Queue<Integer> queue=new Queue<Integer>();
        marked[s]=true;
        queue.enqueue(s);
        while (!queue.isEmpty()){
            int v=queue.dequeue();
            for (Edge e:G.adj(v)){
                int w=e.other(v);
                if (!marked[w]){
                    edgeTo[w]=v;
                    marked[w]=true;
                    queue.enqueue(w);
                }
            }
        }
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

