// count number of paths possible to climb staircase with n stairs for variable jumps at each stair

import java.util.Scanner;

public class climbingStairsWithVarJumps {
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
        dp[n] = 1;
        for(int i = n - 1; i >= 0; i--) {
            for(int j = 1; j <= arr[i] && i + j < dp.length; j++) {
                dp[i] += dp[i + j];
            }
        }
        System.out.println("Number of paths: " + dp[0]);
    }
}
