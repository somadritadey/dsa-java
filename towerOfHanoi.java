// print instructions to move disks from tower 1 to 2 using 3
// move 1 disk at a time; never place smaller under larger disk; only move top disk

import java.util.Scanner;

public class towerOfHanoi {
    public static void toh(int n, int t1id, int t2id, int t3id) { // A to B using C
        if(n == 0) {
            return;
        }
        toh(n - 1, t1id, t3id, t2id); // firstly A to C using B
        System.out.println(n + " [ " + t1id + " -> " + t2id + " ] "); // print instruction
        toh(n - 1, t3id, t2id, t1id); // put the remaining back from C to B using A
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter number of discs: ");
        int n = scn.nextInt();
        System.out.println("Enter number of tower 1: ");
        int t1d = scn.nextInt();
        System.out.println("Enter number of tower 2: ");
        int t2d = scn.nextInt();
        System.out.println("Enter number of tower 3: ");
        int t3d = scn.nextInt();
        toh(n, t1d, t2d, t3d);
    }
}
