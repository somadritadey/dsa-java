// find number of permutations of coins to sum upto a given amount

import java.util.Scanner;

public class coinChangePermutations {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter the number of coin values: ");
        int n = scn.nextInt();
        System.out.println("Enter the value of coins: ");
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        System.out.print("Enter the amount: ");
        int tar = scn.nextInt();

        int[] dp = new int[tar + 1];
        dp[0] = 1;
        for(int i = 1; i < dp.length; i++) {
            for(int j = 0; j < arr.length; j++) {
                if(arr[j] <= i) {
                    dp[i] += dp[i - arr[j]];
                }
            }
        }
        System.out.println("Number of permutations: " + dp[tar]);
    }
}
