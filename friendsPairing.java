// find number of combinations possible if a digit can be single or pair with a friend for n friends given

import java.util.Scanner;

public class friendsPairing {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = scn.nextInt();

        long[] dp = new long[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + (i - 1) * dp[i - 2];
        }
        System.out.println("Number of ways to pair: " + dp[n]);
    }
}
