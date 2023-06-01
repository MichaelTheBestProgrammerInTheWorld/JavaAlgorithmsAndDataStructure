package graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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

    public void bfs(int startingPoint){
        boolean[] visited = new boolean[V];
        Queue<Integer> q = new LinkedList<>();
        visited[startingPoint] = true;
        q.offer(startingPoint);
        while (!q.isEmpty()){
            int u = q.poll();
            System.out.print(u + " ");
            for (int v : adj[u]){
                if (!visited[v]){
                    visited[v] = true;
                    q.offer(v);
                }
            }
        }
        System.out.println();
    }

    public void dfs(int startingPoint){
        boolean[] visited = new boolean[V];
        Stack<Integer> stack = new Stack<>();
        stack.push(startingPoint);
        while (!stack.isEmpty()){
            int u = stack.pop();
            if (!visited[u]){
                visited[u] = true;
                System.out.print(u + " ");
                for (int v : adj[u]){
                    if (!visited[v]){
                        stack.push(v);
                    }
                }
            }
        }
        System.out.println();
    }

    public void dfs() {
        boolean[] visited = new boolean[V];
        for (int v = 0; v < V; v++) {
            if (!visited[v]) {
                dfs(v, visited);
            }
        }
    }

    private void dfs(int v, boolean[] visited) {
        visited[v] = true;
        System.out.print(v + " ");
        for (int w : adj[v]) {
            if (!visited[w]) {
                dfs(w, visited);
            }
        }
    }

    //return the count of connected nodes in a graph
    public int countConnectedNodes(){
        boolean[] visited = new boolean[V];
        int[] compId = new int[V];
        int count = 0;
        for (int v = 0; v < V; v++) {
            if (!visited[v]) {
                dfs(v, visited, compId, count);
                count++;
            }
        }
        return count;
    }

    private void dfs(int v, boolean[] visited, int[] compId, int count) {
        visited[v] = true;
        compId[v] = count;
        for (int w : adj[v]) {
            if (!visited[w]) {
                dfs(w, visited, compId, count);
            }
        }
    }

    public static void main(String[] args) {
        AdjListGraph alg = new AdjListGraph(5);
        alg.addEdge(0, 1);
        alg.addEdge(1, 2);
        alg.addEdge(2, 3);
        alg.addEdge(3, 0);
        alg.addEdge(2, 4);
        System.out.println(alg);
        alg.bfs(0);
        alg.dfs(0);
        System.out.println("recursive dfs");
        alg.dfs();
        System.out.println();
        System.out.println("connected nodes or vertices");
        System.out.println(alg.countConnectedNodes());
    }
}
