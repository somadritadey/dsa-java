// find no. of ways in which n elements can be partitioned into k non-empty subsets

import java.util.Scanner;

public class partitionIntoSubsets {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = scn.nextInt();
        System.out.print("Enter k: ");
        int k = scn.nextInt();

        long[][] dp = new long[k + 1][n + 1];
        for(int i = 1; i <= k; i++) {
            for(int j = 1; j <= n; j++) {
                if(i > j) {
                    dp[i][j] = 0;
                }
                else if(i == j) {
                    dp[i][j] = 1;
                }
                else {
                    dp[i][j] = dp[i - 1][j - 1] + i * dp[i][j - 1];
                }
            }
        }
        System.out.println("Number of ways: " + dp[k][n]);
    }
}
