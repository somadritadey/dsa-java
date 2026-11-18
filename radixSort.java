// sort an array using radix sort

import java.util.Scanner;

public class radixSort {
    public static void countingSort(int[] arr, int exp) {
        int[] farr = new int[10];
        for(int i = 0; i < arr.length; i++) {
            int idx = arr[i] / exp % 10;
            farr[idx]++;
        }
        for(int i = 1; i < farr.length; i++) {
            farr[i] += farr[i - 1];
        }

        int[] ans = new int[arr.length];
        for(int i = arr.length - 1; i >= 0; i--) {
            int val = arr[i] / exp % 10;
            int pos = farr[val];
            int idx = pos - 1;
            ans[idx] = arr[i];
            farr[val]--;
        }
        for(int i = 0; i < ans.length; i++) {
            arr[i] = ans[i];
        }
    }
    public static void radixSort(int[] arr) {
        int max = Integer.MIN_VALUE;
        for(int val : arr) {
            if(val > max) {
                max = val;
            }
        }
        int exp = 1;
        while(exp <= max) {
            countingSort(arr, exp);
            exp = exp * 10;
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter number of elements: ");
        int n = scn.nextInt();
        System.out.println("Enter elements: ");
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        System.out.println("Sorted array: ");
        radixSort(arr);
        for(int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
