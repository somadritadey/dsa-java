// traverse a graph using iterative dfs

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class iterativeDFSGraph {
    public static class Pair {
        int v;
        String psf;

        Pair(int v, String psf) {
            this.v = v;
            this.psf = psf;
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
        System.out.print("Enter source: ");
        int src = scn.nextInt();

        boolean[] visited = new boolean[vertices];
        Stack<Pair> st = new Stack<>();
        st.push(new Pair(src, src + ""));
        while(st.size() > 0) {
            // remove, mark/check if marked, print, add to queue
            Pair rem = st.pop();
            if(visited[rem.v] == true) {
                continue;
            }
            visited[rem.v] = true;
            System.out.println(rem.v + "@" + rem.psf);
            for(Edge e : graph[rem.v]) {
                if(!visited[e.nbr]) {
                    st.push(new Pair(e.nbr, rem.psf + e.nbr));
                }
            }
        }
    }
}
