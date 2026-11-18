// find factorial of number (n*n-1*n-2*...*3*2*1)

import java.util.Scanner;

public class factorial {
    public static int factorialOfNum(int n) {
        if(n == 0) {
            return 1;
        }
        return n * factorialOfNum(n - 1);
    }
    
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int num = scn.nextInt();
        System.out.println("Factorial is: " + factorialOfNum(num));
    }
}
