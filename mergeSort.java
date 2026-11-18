// sort elements using merge sort

import java.util.Scanner;

public class mergeSort {
    public static int[] mergeTwoSortedArrays(int[] a, int[] b) {
        int[] res = new int[a.length + b.length];
        int i = 0; // a
        int j = 0; // b
        int k = 0; // res
        while(i < a.length && j < b.length) {
            if(a[i] < b[j]) {
                res[k] = a[i];
                i++;
                k++;
            }
            else {
                res[k] = b[j];
                j++;
                k++;
            }
        }
        while(i < a.length) {
            res[k] = a[i];
            i++;
            k++;
        }
        while(j < b.length) {
            res[k] = b[j];
            j++;
            k++;
        }
        return res;
    }

    public static int[] mergeSort(int[] arr, int lo, int hi) {
        if(lo == hi) {
            int[] ba = new int[1];
            ba[0] = arr[lo];
            return ba;
        }
        int mid = (lo + hi) / 2;
        int[] fsh = mergeSort(arr, lo, mid);
        int[] ssh = mergeSort(arr, mid + 1, hi);
        int[] res = mergeTwoSortedArrays(fsh, ssh);
        return res;
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
        arr = mergeSort(arr, 0, arr.length - 1);
        for(int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
