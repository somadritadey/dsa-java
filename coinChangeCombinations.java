// find number of combinations of coins to sum upto a given amount

import java.util.Scanner;

public class coinChangeCombinations {
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
        int amt = scn.nextInt();

        int[] dp = new int[amt + 1];
        dp[0] = 1;
        for(int i = 0; i < n; i++) {
            for(int j = arr[i]; j < dp.length; j++) { // j starts from arr[i] as it will remain as it is before arr[i] steps
                dp[j] += dp[j - arr[i]];
            }
        }
        System.out.println("Number of combinations: " + dp[amt]);
    }
}