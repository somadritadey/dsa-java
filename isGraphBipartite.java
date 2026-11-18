// check if a given graph is bipartite

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class isGraphBipartite {
    public static class Pair {
        int v;
        String psf;
        int level;

        Pair(int v, String psf, int level) {
            this.v = v;
            this.psf = psf;
            this.level = level;
        }
    }

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

    public static boolean checkBipartite(ArrayList<Edge>[] graph, int src, int[] visited) {
        ArrayDeque<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair(src, src + "", 0));
        while(queue.size() > 0) {
            // remove, mark/check if marked, print, add to queue
            Pair rem = queue.removeFirst();
            if(visited[rem.v] != -1) {
                if(rem.level != visited[rem.v]) {
                    return false;
                }
            }
            else {
                visited[rem.v] = rem.level;
            }
            for(Edge e : graph[rem.v]) {
                if(visited[e.nbr] == -1) {
                    queue.add(new Pair(e.nbr, rem.psf + e.nbr, rem.level + 1));
                }
            }
        }
        return true;
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

        int[] visited = new int[vertices];
        Arrays.fill(visited, -1);
        for(int v = 0; v < vertices; v++) {
            if(visited[v] != -1) {
                boolean isCompBipartite = checkBipartite(graph, v, visited);
                if(!isCompBipartite) {
                    System.out.println("false");
                    return;
                }
            }
        }
        System.out.println("true");
    }
}
