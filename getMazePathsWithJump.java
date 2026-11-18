// return all the ways possible to go from start to end position of a maze (using vi's hi's di's jumps)

import java.util.ArrayList;
import java.util.Scanner;

public class getMazePathsWithJump {
    public static ArrayList<String> getMazePaths(int sr, int sc, int dr, int dc) {
        if(sr == dr && sc == dc) {
            ArrayList<String> bres = new ArrayList<>();
            bres.add("");
            return bres;
        }
        ArrayList<String> paths = new ArrayList<>();
        // horizontal moves
        for(int ms = 1; ms <= dc - sc; ms++) {
            ArrayList<String> hpaths = getMazePaths(sr, sc + ms, dr, dc);
            for(String hpath: hpaths) {
                paths.add("h" + ms + hpath);
            }
        }
        // vertical moves
        for(int ms = 1; ms <= dr - sr; ms++) {
            ArrayList<String> vpaths = getMazePaths(sr + ms, sc, dr, dc);
            for(String vpath: vpaths) {
                paths.add("v" + ms + vpath);
            }
        }
        // diagonal moves
        for(int ms = 1; ms <= dc - sc && ms <= dr - sr; ms++) {
            ArrayList<String> dpaths = getMazePaths(sr + ms, sc + ms, dr, dc);
            for(String dpath: dpaths) {
                paths.add("d" + ms + dpath);
            }
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
        System.out.println(paths);;
    }
}
