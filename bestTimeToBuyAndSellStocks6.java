// for n days & prices of each day given, find max profit
// k transactions allowed

import java.util.Scanner;

public class bestTimeToBuyAndSellStocks6 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter the number of elements: ");
        int n = scn.nextInt();
        System.out.println("Enter the prices in each day: ");
        int[] prices = new int[n];
        for(int i = 0; i < n; i++) {
            prices[i] = scn.nextInt();
        }
        System.out.print("Enter the number of transactions: ");
        int k = scn.nextInt();

        int[][] dp = new int[k + 1][n];
        // brute force & not well optimized
        /*for(int t = 1; t <= k; t++) {
            for(int d = 1; d < n; d++) {
                int max = dp[t][d - 1];
                for(int pd = 0; pd < d; pd++) {
                    int ptilltm1t = dp[t - 1][pd]; // profit till t-1 transaction
                    int diff = prices[d] - prices[pd];
                    max = Math.max(max, ptilltm1t + diff);
                }
                dp[t][d] = max;
            }
        }*/
        // better & more optimized
        for(int t = 1; t <= k; t++) {
            int maxPrev = -prices[0];
            for(int d = 1; d < n; d++) {
                dp[t][d] = Math.max(dp[t][d - 1], prices[d] + maxPrev);
                maxPrev = Math.max(maxPrev, dp[t - 1][d - 1] - prices[d]);
            }

        }
        System.out.println("Maximum Profit: " + dp[k][n - 1]);
    }
}
