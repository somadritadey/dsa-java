// print min cost to paint a house if colors to paint with k different colors are given
// no consecutive rooms with same colors!

import java.util.Scanner;

public class paintHouseKColors {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter the number of rooms: ");
        int n = scn.nextInt();
        System.out.print("Enter the number of colors: ");
        int k = scn.nextInt();
        System.out.println("Enter the costs: ");
        int[][] arr = new int[n][k];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < k; j++) {
                arr[i][j] = scn.nextInt();
            }
        }

        int[][] dp = new int[n][k];
        for(int j = 0; j < k; j++) {
            dp[0][j] = arr[0][j];
        }
        for(int i = 1; i < n; i++) {
            for(int j = 0; j < k; j++) {
                int min = Integer.MAX_VALUE;
                for(int c = 0; c < k; c++) {
                    if(c != j && dp[i - 1][c] < min) {
                        min = dp[i - 1][c];
                    }
                }
                dp[i][j] = arr[i][j] + min;
            }
        }
        int min = Integer.MAX_VALUE;
        for(int c = 0; c < k; c++) {
            if(dp[n - 1][c] < min) {
                min = dp[n - 1][c];
            }
        }
        System.out.println("Min cost: " + min);
    }
}
