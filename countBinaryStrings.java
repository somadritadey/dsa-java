// count no. of binary strings of length n each with no consecutive 0's

import java.util.Scanner;

public class countBinaryStrings {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter the length of each string: ");
        int n = scn.nextInt();

        int[] dp0 = new int[n + 1];
        int[] dp1 = new int[n + 1];
        dp0[1] = 1;
        dp1[1] = 1;
        for(int i = 2; i <= n; i++) {
            dp0[i] = dp1[i - 1];
            dp1[i] = dp0[i - 1] + dp1[i - 1];
        }
        System.out.println("Number of required strings: " + (dp0[n] + dp1[n]));
    }
}