// find fibonacci series upto nth number

import java.util.Scanner;

public class fibonacciNumbers {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter the total number of values of series: ");
        int n = scn.nextInt();

        System.out.println("The Fibonacci Numbers are: ");
        int a = 0;
        int b = 1;
        for(int i = 0; i < n; i++) {
            System.out.println(a);
            int c = a + b;
            a = b;
            b = c;
        }
    }
}
