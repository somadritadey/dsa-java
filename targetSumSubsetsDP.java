// find if an array has at least one subset that adds upto a given target

import java.util.Scanner;

public class targetSumSubsetsDP {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter the number of elements: ");
        int n = scn.nextInt();
        System.out.println("Enter the elements: ");
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        System.out.print("Enter the target sum: ");
        int tar = scn.nextInt();

        boolean[][] dp = new boolean[n + 1][tar + 1];
        for(int i = 0; i < dp.length; i++) {
            for(int j = 0; j < dp[0].length; j++) {
                if(i == 0 && j == 0) {
                    // cell 1
                    dp[i][j] = true;
                }
                else if(i == 0) {
                    // row 1
                    dp[i][j] = false;
                }
                else if(j == 0) {
                    // column 1
                    dp[i][j] = true;
                }
                else {
                    // rest of the array
                    if(dp[i - 1][j] == true) {
                        dp[i][j] = true; // if upper is true, it is also true
                    }
                    else {
                        int val = arr[i - 1];
                        if(j >= val) {
                            if(dp[i - 1][j - val] == true) {
                                dp[i][j] = true;
                            }
                        }
                    }
                }
            }
        }
        System.out.println("Value present? " + dp[arr.length][tar]);
    }
}