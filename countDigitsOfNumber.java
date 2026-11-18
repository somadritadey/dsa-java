// count the number of digits in a given number

import java.util.Scanner;

public class countDigitsOfNumber {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter the number: ");
        int n = scn.nextInt();

        int dig = 0;
        while(n != 0) {
            n = n / 10;
            dig++;
        }
        System.out.println("Number of digits is " + dig);
    }
}
