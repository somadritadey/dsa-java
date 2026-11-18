// find fibonacci series of nth number using dynamic programming

import java.util.Scanner;

public class fibonacciDP {
    // without memoization
    public static int fib(int n) {
        if(n == 0 || n == 1) {
            return n;
        }
        int fibn = fib(n - 1) + fib(n - 2);
        return fibn;
    }

    // memoized! DP concept
    public static int fibMemoized(int n, int[] memo) {
        if(n == 0 || n == 1) {
            return n;
        }
        if(memo[n] != 0) {
            return memo[n]; // as it already has the answer
        }
        int fibn = fibMemoized(n - 1, memo) + fibMemoized(n - 2, memo);
        memo[n] = fibn;
        return fibn;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter the number: ");
        int n = scn.nextInt();
        System.out.println("Fibonacci number: " + fib(n));
        int fibMemo = fibMemoized(n, new int[n + 1]);
        System.out.println("Fibonacci number with memoization: " + fibMemo);
    }
}
