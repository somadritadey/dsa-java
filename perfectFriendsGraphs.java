// for n students k clubs, find no. of ways to select pair of students not from same club

import java.util.ArrayList;
import java.util.Scanner;

public class perfectFriendsGraphs {
    public static class Edge {
        int v;
        int n;

        Edge(int v, int n) {
            this.v = v;
            this.n = n;
        }
    }
    
    public static void drawAndCreateComp(ArrayList<Edge>[] graph, int src, ArrayList<Integer> comp, boolean[] visited) {
        visited[src] = true;
        comp.add(src);
        for(Edge e : graph[src]) {
            if(!visited[e.n]) {
                drawAndCreateComp(graph, e.n, comp, visited);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = scn.nextInt();
        System.out.print("Enter k: ");
        int k = scn.nextInt();
        ArrayList<Edge>[] graph = new ArrayList[n];
        for(int v = 0; v < n; v++) {
            graph[v] = new ArrayList<>();
        }
        for(int e = 0; e < k; e++) {
            int v1 = scn.nextInt();
            int v2 = scn.nextInt();
            graph[v1].add(new Edge(v1, v2));
            graph[v2].add(new Edge(v2, v1));
        }

        boolean[] visited = new boolean[n];
        ArrayList<ArrayList<Integer>> comps = new ArrayList<>();
        for(int v = 0; v < n; v++) {
            if(!visited[v]) {
                ArrayList<Integer> comp = new ArrayList<>();
                drawAndCreateComp(graph, v, comp, visited);
                comps.add(comp);
            }
        }
        int pairs = 0;
        for(int i = 0; i < comps.size(); i++) {
            for(int j = i + 1; j < comps.size(); j++) {
                pairs += (comps.get(i).size() * comps.get(j).size());
            }
        }
        System.out.println(pairs);
    }
}
