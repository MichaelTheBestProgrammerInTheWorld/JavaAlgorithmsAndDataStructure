package graph;

import java.util.LinkedList;

public class AdjListGraph {

    private LinkedList<Integer>[] adj;
    private int V;  //number of vertices
    private int E;  //number of edges

    public AdjListGraph(int nodes) {
        this.V = nodes;
        this.E = 0;
        this.adj = new LinkedList[nodes];
        for (int v=0; v < V; v++){
            adj[v] = new LinkedList<>();
        }
    }

    public void addEdge(int u, int v){
        adj[u].add(v);
        adj[v].add(u);
        E++;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(V + " vertices " + E + " edges " + "\n");
        for (int v=0; v < V; v++){
            sb.append(v + " : ");
            for (int w : adj[v]){
                sb.append(w + " ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        AdjListGraph alg = new AdjListGraph(4);
        alg.addEdge(0, 1);
        alg.addEdge(1, 2);
        alg.addEdge(2, 3);
        alg.addEdge(3, 0);
        System.out.println(alg);
    }
}
