// two arrays a1 & a2 of size n1 & n2, find their sum

import java.util.Scanner;

public class sumOfTwoArrays {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter the size of first array: ");
        int n1 = scn.nextInt();
        int[] a1 = new int[n1];
        System.out.println("Enter the elements of first array: ");
        for(int i = 0; i < a1.length; i++) {
            a1[i] = scn.nextInt();
        }
        System.out.println("Enter the size of second array: ");
        int n2 = scn.nextInt();
        int[] a2 = new int[n2];
        System.out.println("Enter the elements of second array: ");
        for(int j = 0; j < a2.length; j++) {
            a2[j] = scn.nextInt();
        }

        // ternary operator !
        int[] sum = new int[n1>n2?n1:n2];
        
        int c = 0;
        // for loop will not work here ! i and j will be decremented together after one entire loop
        int i = a1.length - 1;
        int j = a2.length - 1;
        int k = sum.length - 1;
        while(k >= 0) {
            int d = c;
            if(i >= 0) {
                d += a1[i];
            }
            if(j >= 0) {
                d += a2[j];
            }
            c = d / 10;
            d = d % 10;
            sum[k] = d;
            i = i - 1;
            j = j - 1;
            k = k - 1;
        }
        System.out.println("Sum: ");
        if(c != 0) {
            System.out.println(c);
        }
        for(int val: sum) {
            System.out.println(val);
        }
    }
}
