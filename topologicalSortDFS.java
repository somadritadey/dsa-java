// in a DAG, print vertices in topological sort order

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class topologicalSortDFS {
    public static class Edge {
        int src;
        int nbr;

        Edge(int src, int nbr) {
            this.src = src;
            this.nbr = nbr;
        }
    }

    public static void topologicalSort(ArrayList<Edge>[] graph, int src, boolean[] visited, Stack<Integer> st) {
        visited[src] = true;
        for(Edge e : graph[src]) {
            if(!visited[e.nbr]) {
                topologicalSort(graph, e.nbr, visited, st);
            }
        }
    }
    
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter vertices: ");
        int vertices = scn.nextInt();
        System.out.print("Enter edges: ");
        int edges = scn.nextInt();
        ArrayList<Edge>[] graph = new ArrayList[vertices];
        for(int v = 0; v < vertices; v++) {
            graph[v] = new ArrayList<>();
        }
        for(int e = 0; e < edges; e++) {
            int v1 = scn.nextInt();
            int v2 = scn.nextInt();
            graph[v1].add(new Edge(v1, v2));
        }

        boolean[] visited = new boolean[vertices];
        Stack<Integer> st = new Stack<>();
        for(int v = 0; v < vertices; v++) {
            if(!visited[v]) {
                topologicalSort(graph, v, visited, st);
            }
        }
        while(st.size() > 0) {
            System.out.println(st.pop());
        }
    }
}
