// solve 0-1 knapsack problem, where n number of items are present with corresponding weights and we have to put them in a bag of given max capacity
// each item can be put in either 0 or 1 times

import java.util.Scanner;

public class knapsackProblem01 {
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

        int[][] dp = new int[n + 1][cap + 1];
        for(int i = 1; i < dp.length; i++) {
            for(int j = 1; j < dp[0].length; j++) {
                if(j >= wts[i - 1]) {
                    int rCap = j - wts[i - 1];
                    if(dp[i - 1][rCap] + vals[i - 1] >= dp[i - 1][j]) {
                        dp[i][j] = dp[i - 1][rCap] + vals[i - 1];
                    }
                    else {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
                else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        System.out.println("Max weight: " + dp[n][cap]);
    }
}