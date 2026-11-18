// find npr and ncr

import java.util.Scanner;

public class permutationAndCombination {
    public static int factorial(int x) {
        int fact = 1;
        if(x == 0) {
            return 1;
        }
        else {
            for(int i = 1; i <= x; i++) {
                fact = fact * i;
            }
            return fact;
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter the number: ");
        int n = scn.nextInt();
        System.out.println("Enter the base number: ");
        int r = scn.nextInt();

        int npr = factorial(n) / factorial(n - r);
        int ncr = npr / factorial(r);

        System.out.println("NPR = " + npr);
        System.out.println("NCR = " + ncr);
    }
}
