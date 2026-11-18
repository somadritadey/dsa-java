// number system conversions (binary, octal, decimal) or arithmetic operations

import java.util.Scanner;

public class numberSystem {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        // decimal to any base
        /*
        System.out.println("Enter the number in decimal: ");
        int n = scn.nextInt();
        System.out.println("Enter the base: ");
        int b = scn.nextInt();
        int newValue = 0;
        int j = 0;
        while(n != 0) {
            int i = n % b;
            newValue += i * (int)Math.pow(10, j);
            n = n / b;
            j++;
        }
        if(n == 0) {
            int i = n % b;
            newValue += i * (int)Math.pow(10, j);
        }
        System.out.println("Converted value: ");
        System.out.println(newValue);
        */

        // any base to decimal
        /*
        System.out.println("Enter the number in any base: ");
        int n = scn.nextInt();
        System.out.println("Enter the base: ");
        int b = scn.nextInt();
        int newValue = 0;
        int j = 0;
        while(n != 0) {
            int i = n % 10;
            newValue += i * (int)Math.pow(b, j);
            n = n / 10;
            j++;
        }
        if(n == 0) {
            int i = n % 10;
            newValue += i * (int)Math.pow(b, j);
        }
        System.out.println("Converted value: ");
        System.out.println(newValue);
        */

        // any base to any base
        /*
        System.out.println("Enter the number in decimal: ");
        int n = scn.nextInt();
        System.out.println("Enter the base of number: ");
        int b1 = scn.nextInt();
        System.out.println("Enter the new base: ");
        int b2 = scn.nextInt();
        int val1 = 0;
        int j = 0;
        while(n != 0) {
            int i = n % 10;
            val1 += i * (int)Math.pow(b1, j);
            n = n / 10;
            j++;
        }
        if(n == 0) {
            int i = n % 10;
            val1 += i * (int)Math.pow(b1, j);
        }
        int val2 = 0;
        int k = 0;
        while(val1 != 0) {
            int i = val1 % b2;
            val2 += i * (int)Math.pow(10, k);
            val1 = val1 / b2;
            k++;
        }
        if(val1 == 0) {
            int i = val1 % b2;
            val2 += i * (int)Math.pow(10, k);
        }
        System.out.println("Converted value: ");
        System.out.println(val2);
        */

        // any base addition, subtraction, multiplication can be done by using above as functions
        // convert first, perform operation, then again convert
    }
}
