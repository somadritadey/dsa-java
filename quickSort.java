// sort elements using quick sort

import java.util.Scanner;

public class quickSort {
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static int partition(int[] arr, int pivot, int lo, int hi) {
        int i = lo;
        int j = lo;
        while(i < hi) {
            if(arr[i] > pivot) {
                i++;
            }
            else {
                swap(arr, i, j);
                i++;
                j++;
            }
        }
        swap(arr, j, hi); // place pivot in its correct position
        return j; // pivot index
    }

    public static void quickSort(int[] arr, int lo, int hi) {
        if(lo > hi) {
            return;
        }
        int pivot = arr[hi];
        int pi = partition(arr, pivot, lo, hi); // pivot index pi
        quickSort(arr, lo, pi - 1);
        quickSort(arr, pi + 1, hi);
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
        quickSort(arr, 0, arr.length - 1);
        for(int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
