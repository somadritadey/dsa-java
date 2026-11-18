// find path of shortest weight from src to destinations

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class dijkstraAlgorithm {
    public static class Pair implements Comparable<Pair> {
        int v;
        String psf;
        int wsf;

        Pair(int v, String psf, int wsf) {
            this.v = v;
            this.psf = psf;
            this.wsf = wsf;
        }

        public int compareTo(Pair o) {
            return this.wsf - o.wsf;
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
        System.out.println("Enter source: ");
        int src = scn.nextInt();

        PriorityQueue<Pair> queue = new PriorityQueue<>();
        queue.add(new Pair(src, src + "", 0));
        boolean[] visited = new boolean[vertices];
        while(queue.size() > 0) {
            // remove, mark/check if marked, print, add to queue
            Pair rem = queue.remove();
            if(visited[rem.v] == true) {
                continue;
            }
            visited[rem.v] = true;
            System.out.println(rem.v + "via" + rem.psf + "@" + rem.wsf);
            for(Edge e : graph[rem.v]) {
                if(visited[e.nbr] == false) {
                    queue.add(new Pair(e.nbr, rem.psf + e.nbr, rem.wsf + e.wt));
                }
            }
        }
    }
}
