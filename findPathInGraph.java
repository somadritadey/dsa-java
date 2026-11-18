// in a given graph, find if any path exists from source to destination

import java.util.ArrayList;
import java.util.Scanner;

public class findPathInGraph {
    public static class Edge {
        int src;
        int nbr;
        int wt;

        Edge(int src, int nbr, int wt) {
            this.src = src;
            this.nbr = nbr;
            this.wt = wt;
        }
    }

    public static boolean hasPath(ArrayList<Edge>[] graph, int src, int dest, boolean[] visited) {
        if(src == dest) {
            return true;
        }
        visited[src] = true;
        for(Edge edge : graph[src]) { // finds nbrs of src
            if(visited[edge.nbr] == false) {
                boolean hasNbrPath = hasPath(graph, edge.nbr, dest, visited);
                if(hasNbrPath) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter number of vertices: ");
        int vertices = scn.nextInt();
        ArrayList<Edge>[] graph = (ArrayList<Edge>[]) new ArrayList[vertices]; // type casted
        for(int i = 0; i < vertices; i++) {
            graph[i] = new ArrayList<>();
        }
        System.out.print("Enter number of edges: ");
        int edges = scn.nextInt();
        System.out.println("Enter elements of graph: ");
        for(int i = 0; i < edges; i++) {
            int v1 = scn.nextInt();
            int v2 = scn.nextInt();
            int wt = scn.nextInt();
            graph[v1].add(new Edge(v1, v2, wt));
            graph[v2].add(new Edge(v2, v1, wt));
        }
        System.out.print("Enter source: ");
        int source = scn.nextInt();
        System.out.print("Enter destination: ");
        int destination = scn.nextInt();

        boolean[] visited = new boolean[vertices];
        System.out.println("Has Path? " + hasPath(graph, source, destination, visited));
    }
}
