// find if a graph is connected

import java.util.ArrayList;
import java.util.Scanner;

public class isGraphConnected {
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

    public static void drawTree(ArrayList<Edge>[] graph, int src, ArrayList<Integer> comp, boolean[] visited) {
        visited[src] = true;
        comp.add(src);
        for(Edge edge : graph[src]) { // finds nbrs of src
            if(visited[edge.nbr] == false) {
                drawTree(graph, edge.nbr, comp, visited);
            }
        }
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

        boolean[] visited = new boolean[vertices];
        ArrayList<ArrayList<Integer>> comps = new ArrayList<>();
        System.out.println("Components: ");
        for(int v = 0; v < vertices; v++) {
            if(visited[v] == false) {
                ArrayList<Integer> comp = new ArrayList<>();
                drawTree(graph, v, comp, visited);
                comps.add(comp);
            }
        }
        System.out.println(comps.size() == 1);
    }
}
