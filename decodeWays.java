// count the number of ways a string can be written (from number str to letter str)
// ex.- str = 123 o/p: 3 (abc, aw, lc)

import java.util.Scanner;

public class decodeWays {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter the string: ");
        String str = scn.next();

        int[] dp = new int[str.length()];
        dp[0] = 1;
        if(str.charAt(0) == '0') {
            dp[0] = 0;
        }
        for(int i = 1; i < dp.length; i++) {
            if(str.charAt(i - 1) == '0' && str.charAt(i) == '0') {
                dp[i] = 0; // no str possible
            }
            else if(str.charAt(i - 1) == '0' && str.charAt(i) != '0') {
                dp[i] = dp[i - 1]; // no new str can be possible
            }
            else if(str.charAt(i - 1) != '0' && str.charAt(i) == '0') {
                if(str.charAt(i - 1) == '1' || str.charAt(i - 1) == '2') { // then it is less than 26
                    dp[i] = (i >= 2 ? dp[i - 2] : 1); // go 2 steps back to create str
                }
                else {
                    dp[i] = 0; // no new str can be possible
                }
            }
            else {
                if(Integer.parseInt(str.substring(i - 1, i + 1)) <= 26) {
                    dp[i] = dp[i - 1] + (i >= 2 ? dp[i - 2] : 1);
                }
                else {
                    dp[i] = dp[i - 1]; // no new str can be possible
                }
            }
        }
        System.out.println("Number of ways: " + dp[str.length() - 1]);
    }
}