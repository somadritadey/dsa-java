// given a goldmine, to dig from left to right wall, find path with max gold

import java.util.Scanner;

public class goldmine {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter number of rows & columns: ");
        int n = scn.nextInt();
        int m = scn.nextInt();
        System.out.println("Enter elements: ");
        int[][] arr = new int[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                arr[i][j] = scn.nextInt();
            }
        }
        int[][] dp = new int[n][m];
        for(int j = m - 1; j >= 0; j--) {
            for(int i = n - 1; i >= 0; i--) {
                if(j == m - 1) {
                    // last column
                    dp[i][j] = arr[i][j];
                }
                else if(i == 0) {
                    // first row
                    dp[i][j] = arr[i][j] + Math.max(dp[i][j + 1], dp[i + 1][j + 1]);
                }
                else if(i == n - 1) {
                    // last row
                    dp[i][j] = arr[i][j] + Math.max(dp[i][j + 1], dp[i - 1][j + 1]);
                }
                else {
                    // rest of the goldmine
                    dp[i][j] = arr[i][j] + Math.max(dp[i][j + 1], Math.max(dp[i + 1][j + 1], dp[i - 1][j + 1]));
                }
            }
        }
        int max = dp[0][0];
        for(int i = 1; i < n; i++) {
            if(dp[i][0] > max) {
                max = dp[i][0];
            }
        }
        System.out.println("Goldmine Maximum Gold Path's total gold: " + max);
    }
}
