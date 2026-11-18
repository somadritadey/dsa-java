// print the digits of a given number in reverse order

import java.util.Scanner;

public class reverseOfNumber {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter the number: ");
        int n = scn.nextInt();

        System.out.println("Digits in reversed order are: ");
        while(n != 0) {
            int rem = n % 10;
            System.out.println(rem);
            n = n / 10;
        }
    }
}
