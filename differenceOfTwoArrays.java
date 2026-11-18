// two arrays a1 & a2 of size n1 & n2, find their difference (a2 - a1)

// error in code ! debug later !

import java.util.Scanner;

public class differenceOfTwoArrays {
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

        // a2 - a1, so a2 will be always greater
        int[] diff = new int[n2];

        int c = 0;
        int i = a1.length - 1;
        int j = a2.length - 1;
        int k = diff.length - 1;
        while(k >= 0) {
            int d = 0;
            int a1v = (i>=0?a1[i]:0);
            if(a2[j] + c >= a1v) {
                d = a2[j] + c - a1v;
                c = 0;
            }
            else {
                d = a2[j] + c + 10 - a1v;
                c = -1;
            }
            diff[k] = d;
            i = i - 1;
            j = j - 1;
            k = k - 1;
        }
        int idx = 0;
        while(idx < diff.length) {
            if(diff[idx] == 0) {
                idx++;
            }
            else {
                break;
            }
        }
        System.out.println("Difference: ");
        while(idx < diff.length) {
            System.out.println(diff[idx]);
            idx++;
        }
    }
}

// !!! FIX THE ERROR !!! CODE NOT CORRECT !!!