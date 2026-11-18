// solve unbounded knapsack problem, where n number of items are present with corresponding weights and we have to put them in a bag of given max capacity
// each item can be put in any number of times

import java.util.Scanner;

public class knapsackProblemUnbounded {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter the number of elements: ");
        int n = scn.nextInt();
        int[] vals = new int[n];
        System.out.println("Enter values: ");
        for(int i = 0; i < n; i++) {
            vals[i] = scn.nextInt();
        }
        int[] wts = new int[n];
        System.out.println("Enter weights: ");
        for(int i = 0; i < n; i++) {
            wts[i] = scn.nextInt();
        }
        System.out.print("Enter the capacity of bag: ");
        int cap = scn.nextInt();

        int[] dp = new int[cap + 1];
        dp[0] = 0;
        for(int c = 1; c <= cap; c++) { // cap = dp.length
            for(int i = 0; i < n; i++) {
                int max = 0;
                if(c >= wts[i]) {
                    int remC = c - wts[i];
                    int remVal = dp[remC];
                    int tVal = remVal + vals[i];
                    if(tVal > max) {
                        max = tVal;
                    }
                }
                dp[c] = max;
            }
        }
        System.out.println("Max weight: " + dp[cap]);
    }
}
