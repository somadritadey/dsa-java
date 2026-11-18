// in a given graph, find all paths from source to destination in lexicographical order

import java.util.ArrayList;
import java.util.Scanner;

public class findAllPathsInGraph {
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

    public static void printAllPaths(ArrayList<Edge>[] graph, int src, int dest, boolean[] visited, String psf) {
        if(src == dest) {
            System.out.println(psf);
            return;
        }
        visited[src] = true;
        for(Edge edge : graph[src]) { // finds nbrs of src
            if(visited[edge.nbr] == false) {
                printAllPaths(graph, edge.nbr, dest, visited, psf + edge.nbr);
            }
        }
        visited[src] = false; // so that it can revisit a node, or else all paths will not be possible
        // only we don't revisit the same node while printing the same path, for other paths we can revisit
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
        System.out.println("Paths: ");
        printAllPaths(graph, source, destination, visited, source + "");
    }
}
