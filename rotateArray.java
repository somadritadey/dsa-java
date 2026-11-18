// rotate a given array (without using another array)

import java.util.Scanner;

public class rotateArray {
    public static void reverseParts(int[] arr, int i, int j) {
        int li = i;
        int ri = j;
        while(li < ri) {
            int temp = arr[li];
            arr[li] = arr[ri];
            arr[ri] = temp;
            li++;
            ri--;
        }
    }

    public static void rotateArray(int[] arr, int k) {
        k = k % arr.length;
        if(k < 0) {
            k = k + arr.length;
        }
        // part 1
        reverseParts(arr, 0, arr.length - 1 - k);
        // part 2
        reverseParts(arr, arr.length - k, arr.length - 1);
        // total array
        reverseParts(arr, 0, arr.length - 1);
    }

    public static void displayArray(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter number of elements of array: ");
        int n = scn.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter elements of array: ");
        for(int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        System.out.println("Enter rotation number: ");
        int k = scn.nextInt();
        System.out.println("Rotated Array: ");
        rotateArray(arr, k);
        displayArray(arr);
    }
}
