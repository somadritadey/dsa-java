// find number of ways to tile a floor of m*n area with each tile being of m*1 area

import java.util.Scanner;

public class tilingWithDominoesMby1 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = scn.nextInt();
        System.out.print("Enter m: ");
        int m = scn.nextInt();
        
        long[] dp = new long[n + 1];
        for(int i = 1; i <= n; i++) {
            if(i < m) {
                dp[i] = 1; // only vertically
            }
            else if(i == m) {
                dp[i] = 2; // vertically + horizontally
            }
            else {
                dp[i] = dp[i - 1] + dp[i - m];
            }
        }
        System.out.println("Number of ways to tile: " + dp[n]);
    }
}
