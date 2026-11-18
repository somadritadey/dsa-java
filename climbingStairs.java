// count number of paths possible to climb staircase with n stairs. in 1 move either 1, 2 or 3 steps!

import java.util.Scanner;

public class climbingStairs {
    // memoized
    public static int countPaths(int n, int[] memo) {
        if(n == 0) {
            return 1;
        }
        if(n < 0) {
            return 0;
        }
        if(memo[n] > 0) {
            return memo[n];
        }
        int cp = countPaths(n - 1, memo) + countPaths(n - 2, memo) + countPaths(n - 3, memo);
        memo[n] = cp;
        return cp;
    }

    // tabulation
    public static int countPathsTab(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for(int i = 1; i <= n; i++) {
            if(i == 1) {
                dp[i] = dp[i - 1];
            }
            else if(i == 2) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
            else {
                dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter the number of steps: ");
        int n = scn.nextInt();
        System.out.println("Number of paths: " + countPaths(n, new int[n + 1]));
        System.out.println("Number of paths: " + countPathsTab(n));
    }
}
