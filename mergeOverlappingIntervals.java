// merge overlapping time intervals and print in sorted order of start

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class mergeOverlappingIntervals {
    public static class Pair implements Comparable<Pair> { // compares st & et, used to sort
        int st;
        int et;
        Pair(int st, int et) { // object
            this.st = st;
            this.et = et;
        }
        // this > other, return +ve
        // this = other, return 0
        // this < other, return -ve
        public int compareTo(Pair other) {
            if(this.st != other.st) {
                return this.st - other.st;
            }
            else {
                return this.et - other.et;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter the number of time intervals: ");
        int n = scn.nextInt();
        int[][] arr = new int[n][2];
        System.out.println("Enter the time intervals: ");
        for(int i = 0; i < n; i++) {
            arr[i][0] = scn.nextInt();
            arr[i][1] = scn.nextInt();
        }

        Pair[] pairs = new Pair[n];
        for(int i = 0; i < n; i++) {
            pairs[i] = new Pair(arr[i][0], arr[i][1]);
        }
        Arrays.sort(pairs);

        Stack<Pair> st = new Stack<>();
        for(int i = 0; i < n; i++) {
            if(i == 0) {
                st.push(pairs[i]);
            }
            else {
                Pair top = st.peek();
                if(pairs[i].st > top.et) {
                    st.push(pairs[i]);
                }
                else {
                    top.et = Math.max(top.et, pairs[i].et);
                }
            }
        }
        Stack<Pair> result = new Stack<>();
        while(st.size() > 0) {
            result.push(st.pop());
        }
        System.out.println("Merged Timings: ");
        while(result.size() > 0) {
            Pair p = result.pop();
            System.out.println(p.st + " " + p.et);
        }
    }
}
