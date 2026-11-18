// find minimum length of wire required to connect all pcs

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class primAlgorithm {
    public static class Pair implements Comparable<Pair> {
        int v;
        int av;
        int wt;

        Pair(int v, int av, int wt) {
            this.v = v;
            this.av = av;
            this.wt = wt;
        }

        public int compareTo(Pair o) {
            return this.wt - o.wt;
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

        PriorityQueue<Pair> queue = new PriorityQueue<>();
        queue.add(new Pair(0, -1, 0));
        boolean[] visited = new boolean[vertices];
        while(queue.size() > 0) {
            // remove, mark/check if marked, print, add to queue
            Pair rem = queue.remove();
            if(visited[rem.v] == true) {
                continue;
            }
            visited[rem.v] = true;
            if(rem.av != -1) {
                System.out.println("[" + rem.v + "-" + rem.av + "@" + rem.wt + "]");
            }
            for(Edge e : graph[rem.v]) {
                if(visited[e.nbr] == false) {
                    queue.add(new Pair(e.nbr, rem.v, e.wt));
                }
            }
        }
    }
}
