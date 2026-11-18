// return all the ways possible to go from start to end position of a maze (using v's and h's)

import java.util.ArrayList;
import java.util.Scanner;

public class getMazePaths {
    public static ArrayList<String> getMazePaths(int sr, int sc, int dr, int dc) {
        if(sr == dr && sc == dc) {
            ArrayList<String> bres = new ArrayList<>();
            bres.add("");
            return bres;
        }
        ArrayList<String> hpaths = new ArrayList<>();
        ArrayList<String> vpaths = new ArrayList<>();
        if(sc < dc) { // ensures that we aren't in last column
            hpaths = getMazePaths(sr, sc + 1, dr, dc);
        }
        if(sr < dr) { // ensures that we aren't in last row
            vpaths = getMazePaths(sr + 1, sc, dr, dc);
        }
        ArrayList<String> paths = new ArrayList<>();
        for(String hpath: hpaths) {
            paths.add("h" + hpath);
        }
        for(String vpath: vpaths) {
            paths.add("v" + vpath);
        }
        return paths;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter number of rows: ");
        int n = scn.nextInt();
        System.out.print("Enter number of columns: ");
        int m = scn.nextInt();
        ArrayList<String> paths = getMazePaths(1, 1, n, m);
        System.out.println(paths);
    }
}
