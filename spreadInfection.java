// how many people will get infected in a time period

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Scanner;

public class spreadInfection {
    public static class Pair {
        int v;
        int time;

        Pair(int v, int time) {
            this.v = v;
            this.time = time;
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
        System.out.println("Enter time: ");
        int t = scn.nextInt();

        ArrayDeque<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair(src, 1));
        int[] visited = new int[vertices];
        int count = 0;
        while(queue.size() > 0) {
            // remove, mark/check if marked, print, add to queue
            Pair rem = queue.removeFirst();
            if(visited[rem.v] > 0) {
                continue;
            }
            visited[rem.v] = rem.time;
            if(rem.time > t) {
                break;
            }
            count++;
            for(Edge e : graph[rem.v]) {
                if(visited[e.nbr] == 0) {
                    queue.add(new Pair(e.nbr, rem.time + 1));
                }
            }
        }
        System.out.println(count);
    }
}
