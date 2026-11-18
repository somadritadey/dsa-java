// for a maze with cost at each cell, find minimum cost path to traverse from start to end of maze

import java.util.Scanner;

public class minimumCostPath {
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
        int[][] dp = new int[n][m]; // we know that we do not need extra space here
        for(int i = n - 1; i >= 0; i--) {
            for(int j = m - 1; j >= 0; j--) {
                if(i == n - 1 && j == m - 1) {
                    // last cell
                    dp[i][j] = arr[i][j];
                }
                else if(i == n - 1) {
                    // last row
                    dp[i][j] = dp[i][j + 1] + arr[i][j];
                }
                else if(j == m - 1) {
                    // last column
                    dp[i][j] = dp[i + 1][j] + arr[i][j];
                }
                else {
                    // rest of the maze
                    dp[i][j] = Math.min(dp[i + 1][j], dp[i][j + 1]) + arr[i][j];
                }
            }
        }
        System.out.println("Minimum cost path: " + dp[0][0]);
    }
}
