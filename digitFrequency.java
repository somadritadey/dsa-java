// for a given number n, find the frequency of the digit d in n

import java.util.Scanner;

public class digitFrequency {
    public static int getDigitFrequency(int n, int d) {
        int freq = 0;
        while(n != 0) {
            int dig = n % 10;
            n = n / 10;
            if(dig == d) {
                freq++;
            }
        }
        return freq;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter the number: ");
        int n = scn.nextInt();
        System.out.println("Enter the digit: ");
        int d = scn.nextInt();

        System.out.println("Frequency of the digit in given number is: ");
        System.out.println(getDigitFrequency(n, d));
    }
}
