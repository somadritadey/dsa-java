// abc -> abc, acb, bac, bca, cab, cba

import java.util.Scanner;

public class permutationsOfString {
    public static int factorial(int n) {
        if(n == 0) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter the string: ");
        String str = scn.next();

        System.out.println("Permutations: ");
        int n = str.length();
        int f = factorial(n);
        for(int i = 0; i < f; i++) {
            StringBuilder sb = new StringBuilder(str);
            int temp = i;
            for(int div = n; div >= 1; div--) {
                int q = temp / div;
                int r = temp % div;
                System.out.print(sb.charAt(r));
                sb.deleteCharAt(r);
                temp = q;
            }
            System.out.println("");
        }
    }
}
