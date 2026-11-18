// out of all paths, find the one with minimum number of moves

import java.util.Scanner;

public class climbingStairsWithMinMoves {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter number of stairs: ");
        int n = scn.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter max jumps for each stair: ");
        for(int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }
        int[] dp = new int[n + 1];
        dp[n] = 0;
        for(int i = n - 1; i >= 0; i--) {
            if(arr[i] > 0) {
                int min = Integer.MAX_VALUE;
                for(int j = 1; j <= arr[i] && i + j < dp.length; j++) {
                    if(dp[i + j] != Integer.MAX_VALUE) {
                        min = Math.min(min, dp[i + j]);
                    }
                }
                if(min != Integer.MAX_VALUE) {
                    dp[i] = min + 1;
                }
            }
        }
        System.out.println("Minimum paths value: " + dp[0]);
    }
}
