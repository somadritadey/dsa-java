// find number of ways to tile a floor of 2*n area with each tile being of 2*1 area

import java.util.Scanner;

public class tilingWithDominoes2by1 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = scn.nextInt();
        
        long[] dp = new long[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        System.out.println("Number of ways to tile: " + dp[n]);
    }
}
