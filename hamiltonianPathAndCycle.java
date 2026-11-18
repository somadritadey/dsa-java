// in a graph find all hamiltonian paths & cycles

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class hamiltonianPathAndCycle {
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

    public static void hamiltonian(ArrayList<Edge>[] graph, int src, HashSet<Integer> visited, String psf, int osrc) {
        if(visited.size() == graph.length - 1) {
            System.out.print(psf);
            boolean closingEdgeFound = false;
            for(Edge edge : graph[src]) {
                if(edge.nbr == osrc) {
                    closingEdgeFound = true;
                    break;
                }
            }
            if(closingEdgeFound == true) {
                System.out.println("*");
            }
            else {
                System.out.println(".");
            }
            return;
        }
        visited.add(src);
        for(Edge edge : graph[src]) {
            if(visited.contains(edge.nbr) == false) {
                hamiltonian(graph, edge.nbr, visited, psf + edge.nbr, osrc);
            }
        }
        visited.remove(src);
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

        HashSet<Integer> visited = new HashSet<>(); // for o(1) complexity of operations
        hamiltonian(graph, source, visited, source + "", source);
    }
}
