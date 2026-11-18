// in a given graph, find paths acc to weight: smallest, largest, ceil, floor, kth largest

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class graphMultisolverUsingDFS {
    public static class Pair implements Comparable<Pair> {
        int wsf;
        String psf;

        Pair(int wsf, String psf) {
            this.wsf = wsf;
            this.psf = psf;
        }

        @Override
        public int compareTo(Pair other) {
            return this.wsf - other.wsf;
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

    static String spath, lpath, cpath, fpath;
    static Integer spathwt = Integer.MAX_VALUE;
    static Integer lpathwt = Integer.MIN_VALUE;
    static Integer cpathwt = Integer.MAX_VALUE;
    static Integer fpathwt = Integer.MIN_VALUE;
    static PriorityQueue<Pair> pq = new PriorityQueue<>();
    public static void multisolver(ArrayList<Edge>[] graph, int src, int dest, boolean[] visited, int criteria, int k, String psf, int wsf) {
        if(src == dest) {
            if(wsf < spathwt) {
                spathwt = wsf;
                spath = psf;
            }
            if(wsf > lpathwt) {
                lpathwt = wsf;
                lpath = psf;
            }
            // ceil = min among larger
            if(wsf > criteria && wsf < cpathwt) {
                cpathwt = wsf;
                cpath = psf;
            }
            // floor = max among smaller
            if(wsf < criteria && wsf > fpathwt) {
                fpathwt = wsf;
                fpath = psf;
            }
            // kth largest
            if(pq.size() < k) {
                pq.add(new Pair(wsf, psf));
            }
            else {
                if(wsf > pq.peek().wsf) {
                    pq.remove();
                    pq.add(new Pair(wsf, psf));
                }
            }
            return;
        }
        visited[src] = true;
        for(Edge edge : graph[src]) { // finds nbrs of src
            if(visited[edge.nbr] == false) {
                multisolver(graph, edge.nbr, dest, visited, criteria, k, psf + edge.nbr, wsf + edge.wt);
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
        System.out.print("Enter weight criteria: ");
        int criteria = scn.nextInt();
        System.out.print("Enter k: ");
        int k = scn.nextInt();

        boolean[] visited = new boolean[vertices];
        multisolver(graph, source, destination, visited, criteria, k, source + "", 0);
        System.out.println("Smallest: " + spath + "@" + spathwt);
        System.out.println("Largest: " + lpath + "@" + lpathwt);
        System.out.println("Ceil: " + cpath + "@" + cpathwt);
        System.out.println("Floor: " + fpath + "@" + fpathwt);
        System.out.println(k + "th largest: " + pq.peek().psf + "@" + pq.peek().wsf);
    }
}
