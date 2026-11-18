// print all the prime factors of a given number from smallest to largest

import java.util.Scanner;

public class primeFactorization {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter the number: ");
        int n = scn.nextInt();

        System.out.println("Factors are: ");
        for(int div = 2; div * div <= n; div++) {
            while(n % div == 0) {
                n = n / div;
                System.out.println(div);
            }
        }
        // if n!=1 yet, remaining number also must be its factor (this case due to range till root  n)
        if(n != 1) {
            System.out.println(n);
        }
    }
}
